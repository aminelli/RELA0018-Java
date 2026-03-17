# AdvancedConcurrencyMultithreadingDemo

## Panoramica

`AdvancedConcurrencyMultithreadingDemo` è una demo didattica completa su Java 21, focalizzata su concorrenza avanzata e multithreading.

L'implementazione è:

- **Codice in inglese** (classi, metodi, identificatori, messaggi)
- **Commenti in italiano** con spiegazioni tecniche dettagliate per ogni blocco

## Copertura funzionale (da `prompting/thread.md`)

La demo include esempi pratici sulle principali aree della concorrenza in Java:

1. **Fondamenti dei thread**
   - `Thread`, `Runnable`, `join`

2. **Virtual Threads (Java 21)**
   - `Executors.newVirtualThreadPerTaskExecutor()`

3. **Executor Framework**
   - `ExecutorService`, pool fissi, gestione del ciclo di vita

4. **Future e CompletionService**
   - raccolta asincrona dei risultati in ordine di completamento

5. **CompletableFuture**
   - pipeline asincrona e gestione dei timeout

6. **Lock e sincronizzazione**
   - `ReentrantLock`, timeout di lock, sezioni critiche

7. **Sincronizzatori**
   - `CountDownLatch`, `CyclicBarrier`, `Phaser`, `Semaphore`

8. **Collection concorrenti e contatori lock-free**
   - `ConcurrentHashMap`, `AtomicInteger`, `LongAdder`, `ArrayBlockingQueue`

9. **Fork/Join e stream paralleli**
   - `ForkJoinPool`, operazioni con `parallel()`

10. **Scheduling ed esecuzione basata sul tempo**
    - `ScheduledExecutorService`, task periodici e ritardati

11. **Best practice ed errori comuni**
    - gestione delle interruzioni, gestione dei pool, scelte orientate alla contesa

## Focus didattico

La classe è progettata come percorso tecnico guidato:

- esecuzione chiara per sezioni (`run()` orchestra tutti gli scenari)
- pattern realistici per codice simile a contesti produttivi
- anti-pattern espliciti da evitare nei progetti reali

## Integrazione nel menu

Il menu console include una voce dedicata:

- **"Adavanced Concurrency"**

collegata a:

- `com.corso.samples.generated.AdvancedConcurrencyMultithreadingDemo.run()`
