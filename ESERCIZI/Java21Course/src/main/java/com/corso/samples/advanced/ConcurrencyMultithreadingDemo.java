package com.corso.samples.advanced;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo avanzata su Concurrency e Multithreading in Java 21.
 *
 * <p>
 * Include thread platform/virtual, sincronizzazione, lock espliciti,
 * strutture concorrenti, esecuzione asincrona, coordinamento e best practices.
 * </p>
 */
public class ConcurrencyMultithreadingDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private ConcurrencyMultithreadingDemo() {
    }

    /**
     * Entry-point della demo: esegue tutte le sezioni in ordine progressivo.
     */
    public static void run() {
        printHeader("CONCURRENCY & MULTITHREADING IN JAVA 21");

        demoIntroduction();
        demoThreadBasicsAndJoin();
        demoRaceConditionAndSynchronized();
        demoReentrantLock();
        demoAtomicVariables();
        demoExecutorServiceAndFuture();
        demoVirtualThreads();
        demoCompletableFuturePipeline();
        demoConcurrentCollections();
        demoProducerConsumerBlockingQueue();
        demoCountDownLatchAndSemaphore();
        demoScheduledExecutor();
        demoBestPractices();

        printFooter();
    }

    /**
     * Introduzione teorica ai concetti base di concorrenza.
     */
    private static void demoIntroduction() {
        printSection("1) Introduzione");

        // Concurrency: più task avanzano nello stesso intervallo temporale.
        // Parallelismo: più task eseguono realmente in parallelo su core multipli.
        System.out.println("Concurrency: gestione cooperativa di task multipli.");
        System.out.println("Parallelismo: esecuzione simultanea su più core.");

        // In Java 21 abbiamo strumenti moderni per scalare workload I/O-bound.
        System.out.println("Java 21: platform threads + virtual threads + API concorrenti mature.");
    }

    /**
     * Esempio base con Thread, Runnable e join.
     */
    private static void demoThreadBasicsAndJoin() {
        printSection("2) Thread base, start() e join()");

        Runnable task = () -> {
            // Questo codice viene eseguito in un thread separato.
            String name = Thread.currentThread().getName();
            System.out.println("Task in esecuzione su: " + name);
        };

        Thread worker = Thread.ofPlatform().name("worker-platform-1").unstarted(task);

        // start() avvia realmente il thread.
        worker.start();

        try {
            // join() blocca il chiamante finché il thread target non termina.
            worker.join();
        } catch (InterruptedException e) {
            // Best practice: ripristinare interrupt flag quando intercetti InterruptedException.
            Thread.currentThread().interrupt();
            System.out.println("Thread principale interrotto durante join.");
        }

        System.out.println("Thread worker completato.");
    }

    /**
     * Mostra race condition e correzione con synchronized.
     */
    private static void demoRaceConditionAndSynchronized() {
        printSection("3) Race condition e synchronized");

        UnsafeCounter unsafeCounter = new UnsafeCounter();
        runTwoThreadsIncrement(unsafeCounter::increment, 10_000);
        System.out.println("Contatore NON sicuro (atteso 20000): " + unsafeCounter.value());

        SafeCounter safeCounter = new SafeCounter();
        runTwoThreadsIncrement(safeCounter::increment, 10_000);
        System.out.println("Contatore synchronized (atteso 20000): " + safeCounter.value());

        // Spiegazione tecnica:
        // - nel primo caso incremento non atomico (read-modify-write) crea perdita di aggiornamenti
        // - nel secondo caso synchronized serializza accesso alla sezione critica
    }

    /**
     * Mostra lock esplicito con ReentrantLock e tryLock.
     */
    private static void demoReentrantLock() {
        printSection("4) ReentrantLock");

        ReentrantLock lock = new ReentrantLock();
        List<String> audit = new CopyOnWriteArrayList<>();

        Runnable criticalTask = () -> {
            // tryLock con timeout evita attese indefinite in scenari contesi.
            boolean acquired = false;
            try {
                acquired = lock.tryLock(200, TimeUnit.MILLISECONDS);
                if (acquired) {
                    audit.add("lock acquired da " + Thread.currentThread().getName());
                } else {
                    audit.add("timeout lock per " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                audit.add("interrotto " + Thread.currentThread().getName());
            } finally {
                // Unlock sempre in finally per evitare deadlock dovuti a eccezioni.
                if (acquired) {
                    lock.unlock();
                }
            }
        };

        runTwoThreads(criticalTask);
        System.out.println("Audit lock: " + audit);
    }

    /**
     * Mostra AtomicInteger per operazioni atomiche lock-free.
     */
    private static void demoAtomicVariables() {
        printSection("5) Atomic variables");

        AtomicInteger atomicCounter = new AtomicInteger(0);

        Runnable incTask = () -> {
            for (int i = 0; i < 10_000; i++) {
                // incrementAndGet è atomico senza synchronized esplicito.
                atomicCounter.incrementAndGet();
            }
        };

        runTwoThreads(incTask);
        System.out.println("AtomicInteger (atteso 20000): " + atomicCounter.get());
    }

    /**
     * Esecuzione concorrente con pool di thread e Future.
     */
    private static void demoExecutorServiceAndFuture() {
        printSection("6) ExecutorService e Future");

        ExecutorService pool = Executors.newFixedThreadPool(3);

        Callable<Integer> taskA = () -> {
            sleepSilently(80);
            return 10;
        };

        Callable<Integer> taskB = () -> {
            sleepSilently(100);
            return 32;
        };

        try {
            Future<Integer> futureA = pool.submit(taskA);
            Future<Integer> futureB = pool.submit(taskB);

            int result = futureA.get() + futureB.get();
            System.out.println("Somma Future = " + result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrotto durante attesa Future.");
        } catch (ExecutionException e) {
            System.out.println("Errore task asincrono: " + e.getCause());
        } finally {
            // Chiusura ordinata del pool.
            shutdownExecutor(pool, "fixed-pool");
        }
    }

    /**
     * Mostra virtual threads (Java 21) per workload I/O-bound ad alta concorrenza.
     */
    private static void demoVirtualThreads() {
        printSection("7) Virtual Threads (Java 21)");

        ExecutorService vExecutor = Executors.newVirtualThreadPerTaskExecutor();

        try {
            List<Callable<String>> tasks = List.of(
                    () -> simulateIoTask("A", 120),
                    () -> simulateIoTask("B", 90),
                    () -> simulateIoTask("C", 70));

            Instant start = Instant.now();
            List<Future<String>> futures = vExecutor.invokeAll(tasks);
            for (Future<String> f : futures) {
                System.out.println(f.get());
            }
            long elapsed = Duration.between(start, Instant.now()).toMillis();
            System.out.println("Completamento virtual threads in ~" + elapsed + " ms");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interruzione su virtual threads.");
        } catch (ExecutionException e) {
            System.out.println("Errore virtual task: " + e.getCause());
        } finally {
            shutdownExecutor(vExecutor, "virtual-thread-executor");
        }
    }

    /**
     * Mostra pipeline asincrona con CompletableFuture.
     */
    private static void demoCompletableFuturePipeline() {
        printSection("8) CompletableFuture");

        CompletableFuture<Integer> priceFuture = CompletableFuture.supplyAsync(() -> 100)
                .thenApply(base -> base + 20)
                .thenApply(total -> total - 5);

        CompletableFuture<Integer> discountFuture = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Integer> finalFuture = priceFuture.thenCombine(discountFuture, (price, discount) -> price - discount);

        try {
            Integer finalPrice = finalFuture.get(2, TimeUnit.SECONDS);
            System.out.println("Prezzo finale asincrono: " + finalPrice);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrotto su CompletableFuture.");
        } catch (ExecutionException | TimeoutException e) {
            System.out.println("Errore pipeline async: " + e.getMessage());
        }
    }

    /**
     * Mostra collezioni thread-safe della libreria concurrent.
     */
    private static void demoConcurrentCollections() {
        printSection("9) Concurrent Collections");

        ConcurrentMap<String, Integer> counters = new ConcurrentHashMap<>();

        Runnable updateTask = () -> {
            // merge gestisce update atomico per chiave.
            counters.merge("hits", 1, Integer::sum);
            counters.merge("hits", 1, Integer::sum);
        };

        runTwoThreads(updateTask);
        System.out.println("ConcurrentHashMap counters: " + counters);

        CopyOnWriteArrayList<String> listeners = new CopyOnWriteArrayList<>();
        listeners.add("L1");
        listeners.add("L2");

        // Iterazione safe anche durante modifiche concorrenti.
        for (String listener : listeners) {
            System.out.println("listener -> " + listener);
        }
    }

    /**
     * Producer-consumer con BlockingQueue.
     */
    private static void demoProducerConsumerBlockingQueue() {
        printSection("10) Producer-Consumer con BlockingQueue");

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread producer = Thread.ofPlatform().name("producer").unstarted(() -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    queue.put("msg-" + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread consumer = Thread.ofPlatform().name("consumer").unstarted(() -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    String msg = queue.take();
                    System.out.println("consumed -> " + msg);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        producer.start();
        consumer.start();
        joinAll(producer, consumer);
    }

    /**
     * Coordinamento con CountDownLatch e controllo accesso con Semaphore.
     */
    private static void demoCountDownLatchAndSemaphore() {
        printSection("11) CountDownLatch e Semaphore");

        CountDownLatch latch = new CountDownLatch(3);
        Semaphore semaphore = new Semaphore(2);

        Runnable task = () -> {
            boolean permit = false;
            try {
                // Il semaphore limita il numero massimo di task concorrenti.
                semaphore.acquire();
                permit = true;
                System.out.println(Thread.currentThread().getName() + " entra nella sezione limitata");
                sleepSilently(60);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                if (permit) {
                    semaphore.release();
                }
                // Segnaliamo completion al latch.
                latch.countDown();
            }
        };

        Thread t1 = Thread.ofPlatform().name("T1").unstarted(task);
        Thread t2 = Thread.ofPlatform().name("T2").unstarted(task);
        Thread t3 = Thread.ofPlatform().name("T3").unstarted(task);

        t1.start();
        t2.start();
        t3.start();

        try {
            latch.await();
            System.out.println("Tutti i task coordinati sono terminati.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interruzione durante await latch.");
        }
    }

    /**
     * Esecuzione periodica con ScheduledExecutorService.
     */
    private static void demoScheduledExecutor() {
        printSection("12) ScheduledExecutorService");

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        AtomicInteger tick = new AtomicInteger();

        try {
            var periodic = scheduler.scheduleAtFixedRate(() -> {
                int n = tick.incrementAndGet();
                System.out.println("tick=" + n);
            }, 0, 150, TimeUnit.MILLISECONDS);

            sleepSilently(500);
            periodic.cancel(true);
        } finally {
            shutdownExecutor(scheduler, "scheduler");
        }
    }

    /**
     * Best practices operative su concorrenza.
     */
    private static void demoBestPractices() {
        printSection("13) Best practices e anti-pattern");

        String[] rules = {
                "Preferisci API di alto livello (ExecutorService, CompletableFuture) rispetto a Thread raw.",
                "Usa virtual threads per task I/O-bound ad alta cardinalità.",
                "Minimizza le sezioni critiche synchronized/lock per ridurre contention.",
                "Usa strutture concurrent dedicate invece di collezioni non thread-safe.",
                "Gestisci sempre InterruptedException ripristinando il flag di interrupt.",
                "Evita shared mutable state quando possibile (favorisci immutabilità).",
                "Misura throughput/latency prima di ottimizzare (profilazione reale).",
                "Chiudi sempre executor e risorse concorrenti in modo ordinato." };

        for (int i = 0; i < rules.length; i++) {
            System.out.printf("%d) %s%n", i + 1, rules[i]);
        }

        printSubSection("Anti-pattern");
        System.out.println("- Creare thread manuali in loop senza limiti");
        System.out.println("- Ignorare race condition su variabili condivise");
        System.out.println("- Dimenticare shutdown di pool/scheduler");
        System.out.println("- Bloccare thread inutilmente con sleep arbitrari");
    }

    private static void runTwoThreads(Runnable runnable) {
        Thread t1 = Thread.ofPlatform().name("A").unstarted(runnable);
        Thread t2 = Thread.ofPlatform().name("B").unstarted(runnable);
        t1.start();
        t2.start();
        joinAll(t1, t2);
    }

    private static void runTwoThreadsIncrement(Runnable incrementTask, int iterationsPerThread) {
        Runnable wrapped = () -> {
            for (int i = 0; i < iterationsPerThread; i++) {
                incrementTask.run();
            }
        };
        runTwoThreads(wrapped);
    }

    private static void joinAll(Thread... threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Join interrotto su " + thread.getName());
            }
        }
    }

    private static String simulateIoTask(String id, long millis) {
        sleepSilently(millis);
        return "Task " + id + " completato da " + Thread.currentThread();
    }

    private static void sleepSilently(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void shutdownExecutor(ExecutorService executor, String name) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
        System.out.println("Executor chiuso: " + name);
    }

    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════╗" + RESET);
        System.out.printf(CYAN + "║ %-58s ║%n" + RESET, title);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    private static void printSection(String title) {
        System.out.println();
        System.out.println(BLUE + "────────────────────────────────────────────────────────────" + RESET);
        System.out.println(GREEN + title + RESET);
        System.out.println(BLUE + "────────────────────────────────────────────────────────────" + RESET);
    }

    private static void printSubSection(String subtitle) {
        System.out.println();
        System.out.println(MAGENTA + "▶ " + subtitle + RESET);
    }

    private static void printFooter() {
        System.out.println();
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
        System.out.println(YELLOW + " Fine demo: Concurrency e Multithreading" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    private static class UnsafeCounter {
        private int value;

        void increment() {
            value++;
        }

        int value() {
            return value;
        }
    }

    private static class SafeCounter {
        private int value;

        synchronized void increment() {
            value++;
        }

        synchronized int value() {
            return value;
        }
    }
}
