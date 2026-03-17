package com.corso.samples.array_collections;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * Advanced demo on collections for concurrent and multithreaded programming.
 *
 * <p>
 * This class covers practical usage patterns for thread-safe collections,
 * lock-free structures, producer-consumer flow, parallel aggregation,
 * and guidelines to avoid common performance and correctness pitfalls.
 * </p>
 */
public final class ConcurrentCollectionsMultithreadingDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private ConcurrentCollectionsMultithreadingDemo() {
    }

    /**
     * Entry-point della demo: esegue in sequenza tutti gli scenari didattici.
     */
    public static void run() {
        printHeader("ADVANCED CONCURRENT COLLECTIONS & MULTITHREADING");

        demoIntroduction();
        demoSynchronizedListVsCopyOnWriteArrayList();
        demoConcurrentHashMapAtomicOperations();
        demoLongAdderWithFrequencyMap();
        demoConcurrentLinkedQueue();
        demoBlockingQueueProducerConsumerWithVirtualThreads();
        demoConcurrentSkipListMapOrderedView();
        demoParallelAggregationWithCompletableFuture();
        demoBestPracticesAndAntiPatterns();

        printFooter();
    }

    /**
     * Introduzione concettuale su collezioni concorrenti.
     */
    private static void demoIntroduction() {
        printSection("1) Introduction");

        // Le collection standard (es. ArrayList, HashMap) non sono thread-safe,
        // quindi accessi concorrenti in lettura/scrittura possono produrre race condition.
        System.out.println("Standard collections are not thread-safe by default.");

        // Le collection concorrenti del package java.util.concurrent offrono garanzie
        // di sicurezza thread-aware con semantiche precise (blocking, lock-free, copy-on-write).
        System.out.println("Concurrent collections provide safe patterns for multi-thread access.");

        // La scelta corretta dipende dal carico: read-heavy, write-heavy,
        // bisogno di ordine, latenza, blocco o non-blocco.
        System.out.println("Choose structures based on workload shape and consistency needs.");
    }

    /**
     * Confronta synchronizedList e CopyOnWriteArrayList in un contesto read-heavy.
     */
    private static void demoSynchronizedListVsCopyOnWriteArrayList() {
        printSection("2) synchronizedList vs CopyOnWriteArrayList");

        List<String> synchronizedList = java.util.Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();

        // Popoliamo entrambe le liste con dati identici per un confronto omogeneo.
        for (int i = 0; i < 1_000; i++) {
            String value = "item-" + i;
            synchronizedList.add(value);
            copyOnWriteList.add(value);
        }

        // Misuriamo molte letture concorrenti:
        // CopyOnWriteArrayList è spesso ottimale in scenari con poche scritture e tante letture.
        long syncReadTime = benchmarkConcurrentReads(synchronizedList);
        long cowReadTime = benchmarkConcurrentReads(copyOnWriteList);

        System.out.println("synchronizedList read benchmark: " + syncReadTime + " ms");
        System.out.println("CopyOnWriteArrayList read benchmark: " + cowReadTime + " ms");

        // Nota didattica: su CopyOnWrite ogni scrittura crea una copia interna dell'array,
        // quindi è sconsigliata in workload write-heavy.
        copyOnWriteList.add("late-item");
        System.out.println("CopyOnWrite size after one write: " + copyOnWriteList.size());
    }

    /**
     * Mostra update atomici su ConcurrentHashMap con compute/merge.
     */
    private static void demoConcurrentHashMapAtomicOperations() {
        printSection("3) ConcurrentHashMap atomic operations");

        ConcurrentMap<String, Integer> cartByUser = new ConcurrentHashMap<>();
        CountDownLatch latch = new CountDownLatch(4);
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            pool.submit(() -> {
                try {
                    // merge applica una riduzione atomica sulla stessa chiave,
                    // evitando race condition nel classico read-modify-write.
                    for (int j = 0; j < 5_000; j++) {
                        cartByUser.merge("alice", 1, Integer::sum);
                    }

                    // compute permette logica più articolata in modo atomico per chiave.
                    cartByUser.compute("bob", (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
                } finally {
                    latch.countDown();
                }
            });
        }

        awaitLatch(latch, "ConcurrentHashMap workload");
        shutdownExecutor(pool, "concurrent-hash-map-pool");

        System.out.println("alice total events (expected 20000): " + cartByUser.get("alice"));
        System.out.println("bob total events (expected 4): " + cartByUser.get("bob"));
    }

    /**
     * Dimostra LongAdder per contatori ad alta contesa con mappe concorrenti.
     */
    private static void demoLongAdderWithFrequencyMap() {
        printSection("4) LongAdder + ConcurrentHashMap");

        ConcurrentMap<String, LongAdder> counters = new ConcurrentHashMap<>();
        ExecutorService pool = Executors.newFixedThreadPool(6);
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            final int workerId = i;
            pool.submit(() -> {
                try {
                    // computeIfAbsent crea il contatore una sola volta per chiave,
                    // poi increment() aggiorna in maniera efficiente sotto alta contesa.
                    for (int j = 0; j < 3_000; j++) {
                        String key = (workerId % 2 == 0) ? "LOGIN" : "SEARCH";
                        counters.computeIfAbsent(key, ignored -> new LongAdder()).increment();
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        awaitLatch(latch, "LongAdder workload");
        shutdownExecutor(pool, "long-adder-pool");

        System.out.println("LOGIN count: " + counters.get("LOGIN").sum());
        System.out.println("SEARCH count: " + counters.get("SEARCH").sum());
    }

    /**
     * Mostra coda lock-free per throughput elevato con più producer/consumer.
     */
    private static void demoConcurrentLinkedQueue() {
        printSection("5) ConcurrentLinkedQueue (lock-free)");

        Queue<String> events = new ConcurrentLinkedQueue<>();

        // Inseriamo eventi da thread distinti: la coda è non bloccante e thread-safe.
        runTwoThreads(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        events.offer("producer-A:event-" + i);
                    }
                },
                () -> {
                    for (int i = 0; i < 5; i++) {
                        events.offer("producer-B:event-" + i);
                    }
                });

        // Poll progressivo: ogni chiamata recupera e rimuove un elemento se presente.
        String head;
        while ((head = events.poll()) != null) {
            System.out.println("consumed -> " + head);
        }
    }

    /**
     * Producer-consumer classico con BlockingQueue e virtual threads (Java 21).
     */
    private static void demoBlockingQueueProducerConsumerWithVirtualThreads() {
        printSection("6) BlockingQueue + Virtual Threads");

        BlockingQueue<String> inbox = new LinkedBlockingQueue<>(10);

        try (ExecutorService vExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Producer: pubblica messaggi; put() blocca solo se la coda è piena.
            CompletableFuture<Void> producer = CompletableFuture.runAsync(() -> {
                for (int i = 1; i <= 8; i++) {
                    try {
                        inbox.put("message-" + i);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }, vExecutor);

            // Consumer: legge messaggi; take() blocca finché non trova elementi.
            CompletableFuture<Void> consumer = CompletableFuture.runAsync(() -> {
                for (int i = 1; i <= 8; i++) {
                    try {
                        String message = inbox.take();
                        System.out.println("processed -> " + message);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }, vExecutor);

            producer.join();
            consumer.join();
        }
    }

    /**
     * Mostra mappa ordinata concorrente utile per ranking/time-indexed data.
     */
    private static void demoConcurrentSkipListMapOrderedView() {
        printSection("7) ConcurrentSkipListMap (ordered map)");

        ConcurrentSkipListMap<Integer, String> scoreBoard = new ConcurrentSkipListMap<>();

        // Inserimenti concorrenti con ordine naturale della chiave preservato.
        runTwoThreads(
                () -> {
                    scoreBoard.put(30, "user-C");
                    scoreBoard.put(10, "user-A");
                },
                () -> {
                    scoreBoard.put(20, "user-B");
                    scoreBoard.put(40, "user-D");
                });

        System.out.println("Ordered scoreboard: " + scoreBoard);

        // Navigable views: utile per finestre/range query concorrenti.
        Map<Integer, String> top2 = scoreBoard.tailMap(30, true);
        System.out.println("Tail view from 30: " + top2);
    }

    /**
     * Esempio di aggregazione parallela con snapshot in collection concorrente.
     */
    private static void demoParallelAggregationWithCompletableFuture() {
        printSection("8) Parallel aggregation with CompletableFuture");

        ConcurrentMap<String, Integer> totals = new ConcurrentHashMap<>();
        Instant start = Instant.now();

        // Ogni future simula un task indipendente e aggiorna lo stesso accumulatore.
        CompletableFuture<Void> orders = CompletableFuture.runAsync(() -> {
            sleepSilently(70);
            totals.merge("orders", 120, Integer::sum);
        });

        CompletableFuture<Void> refunds = CompletableFuture.runAsync(() -> {
            sleepSilently(50);
            totals.merge("refunds", 15, Integer::sum);
        });

        CompletableFuture<Void> shipments = CompletableFuture.runAsync(() -> {
            sleepSilently(60);
            totals.merge("shipments", 98, Integer::sum);
        });

        CompletableFuture.allOf(orders, refunds, shipments).join();

        long elapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("Aggregated totals: " + totals + " in ~" + elapsed + " ms");
    }

    /**
     * Elenco di linee guida operative e anti-pattern da evitare.
     */
    private static void demoBestPracticesAndAntiPatterns() {
        printSection("9) Best practices and anti-patterns");

        String[] bestPractices = {
                "Select collection type by contention profile (read-heavy/write-heavy).",
                "Use atomic map methods (compute, merge, computeIfAbsent).",
                "Prefer LongAdder over AtomicLong for hot counters.",
                "Use BlockingQueue for producer-consumer backpressure.",
                "Limit shared mutable state and model ownership explicitly.",
                "Measure with realistic workloads before optimizing.",
                "Always design cancellation/interruption paths.",
                "Prefer immutable values as collection payload when possible." };

        for (int i = 0; i < bestPractices.length; i++) {
            System.out.printf("%d) %s%n", i + 1, bestPractices[i]);
        }

        printSubSection("Anti-patterns");
        System.out.println("- Sharing ArrayList/HashMap across threads without synchronization");
        System.out.println("- Using CopyOnWriteArrayList in write-heavy loops");
        System.out.println("- Manual check-then-act instead of atomic map methods");
        System.out.println("- Ignoring InterruptedException or swallowing interruption flags");
        System.out.println("- Overusing global locks when concurrent collections already solve the problem");
    }

    /**
     * Benchmark semplificato per leggere una lista in parallelo.
     */
    private static long benchmarkConcurrentReads(List<String> list) {
        Objects.requireNonNull(list, "list must not be null");

        Instant start = Instant.now();

        ExecutorService pool = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(4);

        for (int i = 0; i < 4; i++) {
            pool.submit(() -> {
                try {
                    // Nel caso di synchronizedList, iterare richiede lock esterno per coerenza.
                    if (list instanceof CopyOnWriteArrayList) {
                        for (int index = 0; index < list.size(); index++) {
                            list.get(index);
                        }
                    } else {
                        synchronized (list) {
                            for (int index = 0; index < list.size(); index++) {
                                list.get(index);
                            }
                        }
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        awaitLatch(latch, "read benchmark");
        shutdownExecutor(pool, "read-benchmark-pool");

        return Duration.between(start, Instant.now()).toMillis();
    }

    /**
     * Esegue due task e attende il completamento.
     */
    private static void runTwoThreads(Runnable first, Runnable second) {
        Thread t1 = Thread.ofPlatform().name("worker-1").unstarted(first);
        Thread t2 = Thread.ofPlatform().name("worker-2").unstarted(second);

        t1.start();
        t2.start();

        joinAll(t1, t2);
    }

    /**
     * Join multiplo con gestione corretta dell'interruzione.
     */
    private static void joinAll(Thread... threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main thread interrupted while joining " + thread.getName());
                return;
            }
        }
    }

    /**
     * Attende un latch con timeout difensivo per evitare attese infinite.
     */
    private static void awaitLatch(CountDownLatch latch, String scope) {
        try {
            boolean completed = latch.await(5, TimeUnit.SECONDS);
            if (!completed) {
                System.out.println("Timeout while waiting for " + scope);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while waiting for " + scope);
        }
    }

    /**
     * Shutdown ordinato di un executor.
     */
    private static void shutdownExecutor(ExecutorService executor, String name) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                // Se i task non terminano in tempo, forziamo l'interruzione.
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            System.out.println("Interrupted while shutting down executor: " + name);
        }
    }

    /**
     * Sleep utility per simulare latenza I/O.
     */
    private static void sleepSilently(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Stampa l'intestazione della demo.
     */
    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(CYAN + "=".repeat(90) + RESET);
        System.out.println(BLUE + " " + title + RESET);
        System.out.println(CYAN + "=".repeat(90) + RESET);
    }

    /**
     * Stampa una sezione principale.
     */
    private static void printSection(String title) {
        System.out.println();
        System.out.println(MAGENTA + "► " + title + RESET);
        System.out.println(YELLOW + "-".repeat(90) + RESET);
    }

    /**
     * Stampa una sotto-sezione.
     */
    private static void printSubSection(String title) {
        System.out.println();
        System.out.println(CYAN + "  • " + title + RESET);
    }

    /**
     * Stampa il footer della demo.
     */
    private static void printFooter() {
        System.out.println();
        System.out.println(GREEN + "Demo completed: concurrent collections and multithreading scenarios executed." + RESET);
        System.out.println(CYAN + "=".repeat(90) + RESET);
    }
}