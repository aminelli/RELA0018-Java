# CollectionDemo - Collections in Java 21

## Panoramica

`CollectionDemo` copre in dettaglio le principali tipologie del Java Collections Framework, incluse varianti ordinate, navigabili, concorrenti, bloccanti e legacy/special-purpose.

- Package: `com.corso.samples.arrcoll`
- Classe: `CollectionDemo`
- Avvio: `run()`

## Obiettivi didattici

Al termine della demo saprai:
1. distinguere `Collection` vs `Map`;
2. scegliere tra `List`, `Set`, `Queue`, `Deque`;
3. usare `Sorted/Navigable` collections;
4. usare `Concurrent` e `Blocking` collections;
5. riconoscere classi legacy/specializzate (`Vector`, `Hashtable`, `WeakHashMap`, `EnumMap`, `Properties`, ecc.);
6. applicare best practices di design e performance.

## Tipologie trattate

### Collection branch
- `Collection`
- `List`: `ArrayList`, `LinkedList`, `Vector`, `Stack`, `CopyOnWriteArrayList`
- `Set`: `HashSet`, `LinkedHashSet`, `TreeSet`, `EnumSet`, `CopyOnWriteArraySet`, `ConcurrentSkipListSet`
- `Queue`: `PriorityQueue`, `ConcurrentLinkedQueue`
- `Deque`: `ArrayDeque`, `LinkedList`, `ConcurrentLinkedDeque`

### Blocking collections
- `ArrayBlockingQueue`
- `LinkedBlockingQueue`
- `PriorityBlockingQueue`
- `DelayQueue`
- `SynchronousQueue`
- `LinkedBlockingDeque`

### Map branch
- `Map`: `HashMap`, `LinkedHashMap`
- `SortedMap/NavigableMap`: `TreeMap`
- `ConcurrentMap`: `ConcurrentHashMap`
- `ConcurrentNavigableMap`: `ConcurrentSkipListMap`
- Legacy/special: `Hashtable`, `WeakHashMap`, `IdentityHashMap`, `EnumMap`, `Properties`

### Utility helpers
- `Collections.unmodifiable*`
- `Collections.synchronized*`
- `Collections.checked*`
- `Collections.empty*`, `singleton*`

## Scenari pratici inclusi

- scelta struttura dati in base a duplicati/ordine/performance;
- producer-consumer con blocking queues;
- cache/chiavi deboli con `WeakHashMap`;
- chiavi enum con `EnumMap`;
- trasformazioni con Stream + Collectors;
- guida rapida per scelta collection corretta.

## Best practices principali

- Programmare sulle interfacce (`List`, `Set`, `Map`).
- Preferire immutabilità quando possibile.
- Usare collection concorrenti dedicate in multi-thread.
- Evitare raw types (sempre generics).
- Considerare ordine, complessità e access pattern prima della scelta.

## Esecuzione

```bash
mvn clean compile
mvn exec:java
```

Dal menu selezionare: **Collection**.
