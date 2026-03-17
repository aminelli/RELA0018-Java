# ConcurrencyMultithreadingDemo

## Obiettivo
La classe `ConcurrencyMultithreadingDemo` mostra in dettaglio e in modo avanzato i principali strumenti Java 21 per **Concurrency** e **Multithreading**, con commenti tecnici in italiano e scenari pratici eseguibili.

## Package
`com.corso.samples.generated`

## Entry Point
- `ConcurrencyMultithreadingDemo.run()`

## Contenuti coperti

### 1) Introduzione
- Differenza tra concorrenza e parallelismo.
- Panoramica sugli strumenti Java 21.

### 2) Thread base e join
- `Thread.ofPlatform()`
- `start()` e sincronizzazione con `join()`.

### 3) Race condition e `synchronized`
- Esempio di contatore non sicuro.
- Correzione tramite sezione critica sincronizzata.

### 4) `ReentrantLock`
- Lock esplicito con `tryLock(timeout)`.
- Rilascio lock in blocco `finally`.

### 5) Variabili atomiche
- `AtomicInteger` per incrementi lock-free.

### 6) `ExecutorService` e `Future`
- Pool fisso, task `Callable`, raccolta risultati asincroni.
- Chiusura ordinata del pool.

### 7) Virtual Threads (Java 21)
- `Executors.newVirtualThreadPerTaskExecutor()`.
- Uso consigliato per carichi I/O-bound ad alta concorrenza.

### 8) `CompletableFuture`
- Pipeline asincrona con `supplyAsync`, `thenApply`, `thenCombine`.
- Gestione timeout ed eccezioni.

### 9) Collezioni concorrenti
- `ConcurrentHashMap` e `CopyOnWriteArrayList`.
- Operazioni thread-safe su stato condiviso.

### 10) Producer-Consumer
- `BlockingQueue` (`LinkedBlockingQueue`) con `put/take`.

### 11) Coordinamento
- `CountDownLatch` per attesa completamento task.
- `Semaphore` per limitare accessi concorrenti.

### 12) Scheduling periodico
- `ScheduledExecutorService` con `scheduleAtFixedRate`.

### 13) Best practices e anti-pattern
- Linee guida pratiche per scrivere codice concorrente robusto.
- Errori comuni da evitare.

## Come eseguire
1. Avvia l'applicazione.
2. Seleziona dal menu la voce `GoF` (come da richiesta corrente).
3. Segui l'output sezione per sezione.

## Nota didattica
La demo privilegia chiarezza e copertura ampia. In produzione, integrare sempre con test concorrenti, osservabilità e profiling per validare throughput/latency reali.
