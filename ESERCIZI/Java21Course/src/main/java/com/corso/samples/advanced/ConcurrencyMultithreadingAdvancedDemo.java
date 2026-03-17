package com.corso.samples.advanced;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.Phaser;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Advanced demo for Java 21 concurrency and multithreading.
 *
 * <p>
 * This class provides a complete guided tour across the most important
 * concurrency primitives, utilities and best practices in modern Java.
 * </p>
 */
public final class ConcurrencyMultithreadingAdvancedDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private ConcurrencyMultithreadingAdvancedDemo() {
    }

    /**
     * Entry-point della demo.
     */
    public static void run() {
        printHeader("ADVANCED CONCURRENCY & MULTITHREADING (JAVA 21)");

        demoThreadBasics();
        demoVirtualThreads();
        demoExecutorFramework();
        demoFutureAndCompletionService();
        demoCompletableFuturePipeline();
        demoLocksAndSynchronization();
        demoSynchronizers();
        demoConcurrentCollectionsAndAtomics();
        demoForkJoinAndParallelStreams();
        demoScheduling();
        demoBestPracticesAndCommonMistakes();

        printFooter();
    }

    /**
     * Mostra i concetti base con Thread, Runnable e join.
     */
    private static void demoThreadBasics() {
        printSection("1) Thread Basics");

        // Runnable rappresenta il lavoro da eseguire in parallelo.
        Runnable workerLogic = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Runnable task running on -> " + name);
        };

        // Creiamo un thread platform classico e lo avviamo manualmente.
        Thread thread = Thread.ofPlatform().name("platform-worker").unstarted(workerLogic);
        thread.start();

        try {
            // join() sospende il chiamante finché il thread target non termina.
            thread.join();
        } catch (InterruptedException e) {
            // Best practice: se intercetti InterruptedException devi ripristinare il flag.
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted while waiting join.");
        }
    }

    /**
     * Mostra l'approccio moderno con virtual threads in Java 21.
     */
    private static void demoVirtualThreads() {
        printSection("2) Virtual Threads (Project Loom)");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Callable<String> ioTaskA = () -> {
                sleepSilently(80);
                return "virtual-task-A completed";
            };
            Callable<String> ioTaskB = () -> {
                sleepSilently(60);
                return "virtual-task-B completed";
            };

            // invokeAll coordina più task e restituisce un Future per ciascuno.
            List<Future<String>> futures = executor.invokeAll(List.of(ioTaskA, ioTaskB));
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted during virtual thread execution.");
        } catch (ExecutionException e) {
            System.out.println("Virtual task failure: " + e.getMessage());
        }
    }

    /**
     * Presenta ExecutorService e thread pool configurabili.
     */
    private static void demoExecutorFramework() {
        printSection("3) Executor Framework");

        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            fixedPool.submit(() -> {
                try {
                    // Simuliamo task CPU-bound brevi su pool condiviso.
                    int value = taskId * taskId;
                    System.out.println("pool-task-" + taskId + " -> " + value);
                } finally {
                    latch.countDown();
                }
            });
        }

        awaitLatch(latch, "executor framework demo");
        shutdownExecutor(fixedPool, "fixed-pool");
    }

    /**
     * Mostra Future + CompletionService per raccolta risultati al completamento.
     */
    private static void demoFutureAndCompletionService() {
        printSection("4) Future + CompletionService");

        ExecutorService pool = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<String> completion = new ExecutorCompletionService<>(pool);

        // Ogni task termina in tempi diversi; CompletionService restituisce il primo pronto.
        completion.submit(() -> randomLatencyResult("task-A"));
        completion.submit(() -> randomLatencyResult("task-B"));
        completion.submit(() -> randomLatencyResult("task-C"));

        try {
            for (int i = 0; i < 3; i++) {
                Future<String> completed = completion.take();
                System.out.println("completed -> " + completed.get());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while collecting completion results.");
        } catch (ExecutionException e) {
            System.out.println("CompletionService task failed: " + e.getMessage());
        } finally {
            shutdownExecutor(pool, "completion-service-pool");
        }
    }

    /**
     * Mostra pipeline asincrona con CompletableFuture.
     */
    private static void demoCompletableFuturePipeline() {
        printSection("5) CompletableFuture Pipeline");

        CompletableFuture<Integer> basePrice = CompletableFuture.supplyAsync(() -> 100);

        // thenApply trasforma il valore mantenendo lo stesso flusso asincrono.
        CompletableFuture<Integer> taxed = basePrice.thenApply(price -> price + 22);
        CompletableFuture<Integer> discounted = taxed.thenApply(price -> price - 15);

        CompletableFuture<String> message = discounted.thenApply(total -> "Final total = " + total);

        try {
            System.out.println(message.get(2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while waiting completable pipeline.");
        } catch (ExecutionException | TimeoutException e) {
            System.out.println("CompletableFuture pipeline error: " + e.getMessage());
        }
    }

    /**
     * Mostra lock espliciti e confronto con sezioni critiche sincronizzate.
     */
    private static void demoLocksAndSynchronization() {
        printSection("6) Locks and Synchronization");

        ReentrantLock lock = new ReentrantLock();
        AtomicInteger sharedCounter = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(2);

        Runnable criticalTask = () -> {
            boolean acquired = false;
            try {
                // tryLock con timeout evita stalli infiniti su lock contesi.
                acquired = lock.tryLock(200, TimeUnit.MILLISECONDS);
                if (acquired) {
                    for (int i = 0; i < 2_000; i++) {
                        sharedCounter.incrementAndGet();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                if (acquired) {
                    lock.unlock();
                }
                latch.countDown();
            }
        };

        Thread.ofPlatform().name("lock-worker-1").start(criticalTask);
        Thread.ofPlatform().name("lock-worker-2").start(criticalTask);

        awaitLatch(latch, "lock demo");
        System.out.println("Counter after lock-protected increments -> " + sharedCounter.get());
    }

    /**
     * Mostra i sincronizzatori principali: CountDownLatch, CyclicBarrier, Phaser, Semaphore.
     */
    private static void demoSynchronizers() {
        printSection("7) Synchronizers");

        // CountDownLatch: il main attende il completamento di N worker.
        CountDownLatch latch = new CountDownLatch(2);
        Thread.ofPlatform().start(() -> {
            sleepSilently(40);
            latch.countDown();
        });
        Thread.ofPlatform().start(() -> {
            sleepSilently(60);
            latch.countDown();
        });
        awaitLatch(latch, "countdown latch");
        System.out.println("CountDownLatch released.");

        // CyclicBarrier: sincronizza più thread su un punto comune.
        CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.println("Barrier action executed."));
        runTwoThreads(
                () -> awaitBarrier(barrier, "barrier-worker-1"),
                () -> awaitBarrier(barrier, "barrier-worker-2"));

        // Phaser: coordinazione a fasi dinamiche.
        Phaser phaser = new Phaser(2);
        runTwoThreads(
                () -> doPhasedWork(phaser, "phase-worker-1"),
                () -> doPhasedWork(phaser, "phase-worker-2"));

        // Semaphore: limita il numero di accessi simultanei a una risorsa.
        Semaphore semaphore = new Semaphore(1);
        runTwoThreads(
                () -> executeWithPermit(semaphore, "semaphore-worker-1"),
                () -> executeWithPermit(semaphore, "semaphore-worker-2"));
    }

    /**
     * Mostra collection concorrenti, atomic classes e adders.
     */
    private static void demoConcurrentCollectionsAndAtomics() {
        printSection("8) Concurrent Collections, Atomic and Adders");

        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        AtomicInteger atomicCounter = new AtomicInteger(0);
        LongAdder adder = new LongAdder();

        CountDownLatch latch = new CountDownLatch(4);
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            pool.submit(() -> {
                try {
                    for (int j = 0; j < 2_500; j++) {
                        // merge è atomico a livello di chiave.
                        map.merge("events", 1, Integer::sum);

                        // AtomicInteger è adatto a contatori condivisi semplici.
                        atomicCounter.incrementAndGet();

                        // LongAdder scala meglio sotto alta contesa.
                        adder.increment();
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        awaitLatch(latch, "concurrent collections and atomics");
        shutdownExecutor(pool, "collections-pool");

        System.out.println("ConcurrentHashMap events -> " + map.get("events"));
        System.out.println("AtomicInteger total -> " + atomicCounter.get());
        System.out.println("LongAdder total -> " + adder.sum());

        // BlockingQueue per pattern producer-consumer con backpressure.
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        runTwoThreads(
                () -> produceMessages(queue),
                () -> consumeMessages(queue));
    }

    /**
     * Dimostra ForkJoinPool e parallelStream per workload CPU-bound.
     */
    private static void demoForkJoinAndParallelStreams() {
        printSection("9) ForkJoin and Parallel Streams");

        try (ForkJoinPool fjPool = new ForkJoinPool(4)) {
            // Eseguiamo un calcolo parallelo controllando esplicitamente il pool.
            int sum = fjPool.submit(() -> IntStream.rangeClosed(1, 1_000)
                    .parallel()
                    .sum()).join();
            System.out.println("ForkJoin parallel sum(1..1000) -> " + sum);
        }

        // Parallel stream usa di default il common ForkJoinPool.
        long evenCount = IntStream.rangeClosed(1, 100_000)
                .parallel()
                .filter(value -> value % 2 == 0)
                .count();
        System.out.println("parallelStream even count -> " + evenCount);
    }

    /**
     * Mostra scheduling periodico e delayed con ScheduledExecutorService.
     */
    private static void demoScheduling() {
        printSection("10) Scheduling and Time-based Execution");

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        AtomicInteger ticks = new AtomicInteger(0);

        // fixed-rate: utile per heartbeat/monitoring periodico.
        var periodic = scheduler.scheduleAtFixedRate(() -> {
            int tick = ticks.incrementAndGet();
            System.out.println("heartbeat tick -> " + tick);
        }, 0, 120, TimeUnit.MILLISECONDS);

        // task delayed one-shot.
        scheduler.schedule(() -> System.out.println("delayed task executed"), 200, TimeUnit.MILLISECONDS);

        sleepSilently(420);
        periodic.cancel(true);
        shutdownExecutor(scheduler, "scheduler");
    }

    /**
     * Riassume linee guida pratiche e errori tipici.
     */
    private static void demoBestPracticesAndCommonMistakes() {
        printSection("11) Best Practices and Common Mistakes");

        String[] practices = {
                "Prefer structured pools or virtual-thread executors over manual thread management.",
                "Handle interruption correctly and propagate cancellation semantics.",
                "Use concurrent collections instead of coarse synchronized blocks when possible.",
                "Prefer LongAdder for high-contention counters.",
                "Measure before optimizing and profile CPU-bound vs I/O-bound workloads.",
                "Keep critical sections small and avoid blocking operations inside locks.",
                "Use timeouts for external calls and lock acquisition to avoid indefinite waits." };

        for (int i = 0; i < practices.length; i++) {
            System.out.printf("%d) %s%n", i + 1, practices[i]);
        }

        printSubSection("Common mistakes");
        System.out.println("- Using synchronized everywhere without contention analysis");
        System.out.println("- Ignoring InterruptedException and losing cancellation control");
        System.out.println("- Sharing mutable state without ownership rules");
        System.out.println("- Using parallelStream by default on I/O-bound workflows");
        System.out.println("- Creating too many dedicated pools without lifecycle management");
    }

    /**
     * Utility che simula task con latenza variabile.
     */
    private static String randomLatencyResult(String taskName) {
        int delay = ThreadLocalRandom.current().nextInt(40, 120);
        sleepSilently(delay);
        return taskName + " finished in " + delay + " ms";
    }

    /**
     * Producer semplificato per BlockingQueue.
     */
    private static void produceMessages(ArrayBlockingQueue<String> queue) {
        for (int i = 1; i <= 4; i++) {
            try {
                queue.put("msg-" + i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    /**
     * Consumer semplificato per BlockingQueue.
     */
    private static void consumeMessages(ArrayBlockingQueue<String> queue) {
        for (int i = 1; i <= 4; i++) {
            try {
                String message = queue.take();
                System.out.println("consumed -> " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    /**
     * Attende il raggiungimento di una barrier.
     */
    private static void awaitBarrier(CyclicBarrier barrier, String workerName) {
        try {
            sleepSilently(30);
            barrier.await();
            System.out.println(workerName + " passed barrier");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(workerName + " interrupted while waiting barrier");
        } catch (BrokenBarrierException e) {
            System.out.println(workerName + " barrier broken: " + e.getMessage());
        }
    }

    /**
     * Esegue due fasi coordinate da Phaser.
     */
    private static void doPhasedWork(Phaser phaser, String workerName) {
        for (int phase = 0; phase < 2; phase++) {
            System.out.println(workerName + " running phase " + phase);
            sleepSilently(25);
            phaser.arriveAndAwaitAdvance();
        }
        phaser.arriveAndDeregister();
    }

    /**
     * Esegue una sezione protetta da Semaphore.
     */
    private static void executeWithPermit(Semaphore semaphore, String workerName) {
        boolean permitAcquired = false;
        try {
            semaphore.acquire();
            permitAcquired = true;
            System.out.println(workerName + " entered protected section");
            sleepSilently(35);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (permitAcquired) {
                semaphore.release();
            }
        }
    }

    /**
     * Utility per lanciare due runnable in parallelo e attendere completamento.
     */
    private static void runTwoThreads(Runnable first, Runnable second) {
        Thread t1 = Thread.ofPlatform().name("worker-1").unstarted(first);
        Thread t2 = Thread.ofPlatform().name("worker-2").unstarted(second);

        t1.start();
        t2.start();

        joinAll(t1, t2);
    }

    /**
     * Join multiplo con gestione dell'interruzione.
     */
    private static void joinAll(Thread... threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Interrupted while joining " + thread.getName());
                return;
            }
        }
    }

    /**
     * Attesa con timeout difensivo per CountDownLatch.
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
     * Chiusura ordinata di executor con fallback a shutdownNow.
     */
    private static void shutdownExecutor(ExecutorService executor, String name) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            System.out.println("Interrupted while shutting down executor: " + name);
        }
    }

    /**
     * Sleep utility senza propagare checked exception.
     */
    private static void sleepSilently(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Rendering header della demo.
     */
    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(CYAN + "=".repeat(96) + RESET);
        System.out.println(BLUE + " " + title + RESET);
        System.out.println(CYAN + "=".repeat(96) + RESET);
    }

    /**
     * Rendering sezione principale.
     */
    private static void printSection(String title) {
        System.out.println();
        System.out.println(MAGENTA + "► " + title + RESET);
        System.out.println(YELLOW + "-".repeat(96) + RESET);
    }

    /**
     * Rendering sotto-sezione.
     */
    private static void printSubSection(String title) {
        System.out.println();
        System.out.println(CYAN + "  • " + title + RESET);
    }

    /**
     * Rendering footer della demo.
     */
    private static void printFooter() {
        System.out.println();
        System.out.println(GREEN + "Demo completed: advanced Java concurrency scenarios executed." + RESET);
        System.out.println(CYAN + "=".repeat(96) + RESET);
    }
}