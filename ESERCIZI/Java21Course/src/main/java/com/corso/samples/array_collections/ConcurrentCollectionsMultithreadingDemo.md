# ConcurrentCollectionsMultithreadingDemo

## Overview

`ConcurrentCollectionsMultithreadingDemo` is an advanced educational demo focused on **thread-safe collections** and **multithreaded programming patterns** in Java 21.

The class is designed for learning and includes practical scenarios, best practices, and common anti-patterns.

## Covered Topics

1. **Introduction to concurrent collections**
   - Why standard collections are not safe under concurrent writes.
   - How to choose collection types based on workload.

2. **`synchronizedList` vs `CopyOnWriteArrayList`**
   - Read-heavy benchmarks.
   - Trade-offs for write-heavy scenarios.

3. **`ConcurrentHashMap` atomic APIs**
   - `merge`, `compute`, and `computeIfAbsent`.
   - Avoiding read-modify-write race conditions.

4. **`LongAdder` counters with `ConcurrentHashMap`**
   - Efficient counting under high contention.
   - Frequency-map pattern for metrics/events.

5. **`ConcurrentLinkedQueue` (lock-free queue)**
   - Multi-producer usage.
   - Non-blocking event pipelines.

6. **`BlockingQueue` + Virtual Threads (Java 21)**
   - Producer-consumer with backpressure.
   - `put`/`take` semantics in bounded queues.

7. **`ConcurrentSkipListMap`**
   - Concurrent ordered map.
   - Range/tail views for ordered data access.

8. **Parallel aggregation with `CompletableFuture`**
   - Multiple async tasks updating shared concurrent structures safely.

9. **Best Practices and Anti-patterns**
   - Correct design choices for high-concurrency systems.
   - Common mistakes to avoid in production code.

## Teaching Notes

- The **code is in English**, as required for technical consistency.
- The **comments are in Italian** and explain each block in a didactic, detailed way.
- The demo emphasizes both:
  - **Correctness** (thread safety, interruption handling, atomic operations)
  - **Performance awareness** (contention profile, lock-free vs blocking structures)

## How to Run

The demo is invoked from the console menu entry:

- **"Switch Avanzati"**

which now runs:

- `com.corso.samples.generated.ConcurrentCollectionsMultithreadingDemo.run()`
