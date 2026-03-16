package com.corso.samples.array_collections;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Demo completa sulle Collections in Java 21.
 *
 * <p>
 * Include in modo esteso tutte le tipologie principali del Java Collections Framework:
 * Collection, List, Set, Queue, Deque, Map e varianti sorted/navigable/concurrent,
 * più classi legacy/special purpose e best practices.
 * </p>
 */
public class CollectionDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private CollectionDemo() {
    }

    public static void run() {
        printHeader("COLLECTIONS IN JAVA 21");

        demoIntroductionAndTaxonomy();
        demoCollectionAndListInterfaces();
        demoListImplementations();
        demoSetImplementations();
        demoQueueAndDequeImplementations();
        demoMapImplementations();
        demoConcurrentCollections();
        demoLegacyAndSpecializedCollections();
        demoCollectionsUtilityClass();
        demoStreamsAndCollectorsWithCollections();
        demoSelectionGuide();
        demoBestPractices();

        printFooter();
    }

    private static void demoIntroductionAndTaxonomy() {
        printSection("1) Tassonomia Collections");

        System.out.println("Tipologie principali:");
        System.out.println("- Collection (radice): List, Set, Queue, Deque");
        System.out.println("- Map (ramo separato): associazioni key/value");

        printSubSection("Sotto-tipologie rilevanti");
        System.out.println("- SortedSet / NavigableSet");
        System.out.println("- SortedMap / NavigableMap");
        System.out.println("- Concurrent collections");
        System.out.println("- BlockingQueue / BlockingDeque");

        printSubSection("Principio base");
        System.out.println("Programmare sull'interfaccia (List/Set/Map), non sull'implementazione concreta.");
    }

    private static void demoCollectionAndListInterfaces() {
        printSection("2) Collection e List: operazioni base");

        Collection<String> words = new ArrayList<>();
        words.add("java");
        words.add("collection");
        words.add("framework");

        System.out.println("Collection: " + words);
        System.out.println("contains('java'): " + words.contains("java"));
        System.out.println("size: " + words.size());

        List<String> list = new ArrayList<>(words);
        list.add(1, "21");
        System.out.println("List with index insertion: " + list);
        System.out.println("get(2): " + list.get(2));
    }

    private static void demoListImplementations() {
        printSection("3) List implementations");

        List<String> arrayList = new ArrayList<>(List.of("A", "B", "C"));
        LinkedList<String> linkedList = new LinkedList<>(List.of("A", "B", "C"));
        Vector<String> vector = new Vector<>(List.of("A", "B", "C"));
        Stack<String> stack = new Stack<>();
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>(List.of("A", "B", "C"));

        stack.push("first");
        stack.push("second");

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("Vector (legacy synchronized): " + vector);
        System.out.println("Stack pop: " + stack.pop() + " | remaining=" + stack);
        System.out.println("CopyOnWriteArrayList: " + cowList);

        printSubSection("Scenario consigliati");
        System.out.println("ArrayList -> uso generale/read-heavy");
        System.out.println("LinkedList -> inserimenti/rimozioni su estremi");
        System.out.println("CopyOnWriteArrayList -> letture frequenti, poche scritture, thread-safe");
    }

    private static void demoSetImplementations() {
        printSection("4) Set implementations");

        Set<String> hashSet = new HashSet<>(List.of("A", "B", "A", "C"));
        Set<String> linkedHashSet = new LinkedHashSet<>(List.of("B", "A", "C", "A"));
        SortedSet<String> treeSet = new TreeSet<>(List.of("B", "A", "C"));
        EnumSet<Level> enumSet = EnumSet.of(Level.LOW, Level.HIGH);
        CopyOnWriteArraySet<String> cowSet = new CopyOnWriteArraySet<>(List.of("A", "B", "A"));
        NavigableSet<Integer> skipSet = new ConcurrentSkipListSet<>(List.of(10, 30, 20));

        System.out.println("HashSet (no order): " + hashSet);
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
        System.out.println("TreeSet (sorted): " + treeSet);
        System.out.println("EnumSet: " + enumSet);
        System.out.println("CopyOnWriteArraySet: " + cowSet);
        System.out.println("ConcurrentSkipListSet: " + skipSet + " | higher(20)=" + skipSet.higher(20));

        printSubSection("Nota");
        System.out.println("Set elimina duplicati per definizione.");
    }

    private static void demoQueueAndDequeImplementations() {
        printSection("5) Queue e Deque implementations");

        Queue<String> priorityQueue = new PriorityQueue<>(List.of("medium", "high", "low"));
        Deque<String> arrayDeque = new ArrayDeque<>(List.of("middle"));
        Deque<String> linkedListDeque = new LinkedList<>(List.of("M"));
        Queue<String> concurrentQueue = new ConcurrentLinkedQueue<>(List.of("A", "B"));
        Deque<String> concurrentDeque = new ConcurrentLinkedDeque<>(List.of("X", "Y"));

        arrayDeque.addFirst("first");
        arrayDeque.addLast("last");
        linkedListDeque.addFirst("L1");
        linkedListDeque.addLast("L2");

        System.out.println("PriorityQueue poll order: " + priorityQueue.poll() + ", " + priorityQueue.poll() + ", "
                + priorityQueue.poll());
        System.out.println("ArrayDeque: " + arrayDeque + " | pop=" + arrayDeque.pop());
        System.out.println("LinkedList as Deque: " + linkedListDeque);
        System.out.println("ConcurrentLinkedQueue poll: " + concurrentQueue.poll());
        System.out.println("ConcurrentLinkedDeque pollLast: " + concurrentDeque.pollLast());

        printSubSection("Blocking queues/deques");
        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer(1);
        arrayBlockingQueue.offer(2);

        BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.offer(10);
        linkedBlockingQueue.offer(20);

        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.offer(30);
        priorityBlockingQueue.offer(10);

        DelayQueue<DelayedItem> delayQueue = new DelayQueue<>();
        delayQueue.offer(new DelayedItem("d1", 1));
        DelayedItem delayedReady;
        try {
            delayedReady = delayQueue.poll(5, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            delayedReady = null;
        }

        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        boolean offered = synchronousQueue.offer("payload");

        BlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
        linkedBlockingDeque.offerFirst("A");
        linkedBlockingDeque.offerLast("B");

        System.out.println("ArrayBlockingQueue: " + arrayBlockingQueue);
        System.out.println("LinkedBlockingQueue: " + linkedBlockingQueue);
        System.out.println("PriorityBlockingQueue poll: " + priorityBlockingQueue.poll());
        System.out.println("DelayQueue poll after tiny wait: " + delayedReady);
        System.out.println("SynchronousQueue offer without consumer: " + offered);
        System.out.println("LinkedBlockingDeque: " + linkedBlockingDeque);
    }

    private static void demoMapImplementations() {
        printSection("6) Map implementations");

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("first", 10);
        linkedHashMap.put("second", 20);

        SortedMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("C", 30);
        treeMap.put("A", 10);
        treeMap.put("B", 20);

        ConcurrentMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("X", 100);
        concurrentHashMap.merge("X", 50, Integer::sum);

        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("legacy", 1);

        System.out.println("HashMap: " + hashMap);
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);
        System.out.println("TreeMap (sorted keys): " + treeMap);
        System.out.println("ConcurrentHashMap: " + concurrentHashMap);
        System.out.println("Hashtable (legacy synchronized): " + hashtable);

        NavigableMap<String, Integer> navMap = new TreeMap<>(treeMap);
        System.out.println("NavigableMap higherKey('A'): " + navMap.higherKey("A"));
    }

    private static void demoConcurrentCollections() {
        printSection("7) Concurrent collections");

        ConcurrentMap<String, Integer> chm = new ConcurrentHashMap<>();
        chm.put("counter", 0);
        chm.compute("counter", (k, v) -> v == null ? 1 : v + 1);

        ConcurrentNavigableMap<Integer, String> skipMap = new ConcurrentSkipListMap<>();
        skipMap.put(2, "B");
        skipMap.put(1, "A");

        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>(List.of("v1", "v2"));
        CopyOnWriteArraySet<String> cowSet = new CopyOnWriteArraySet<>(List.of("s1", "s2"));

        System.out.println("ConcurrentHashMap: " + chm);
        System.out.println("ConcurrentSkipListMap: " + skipMap);
        System.out.println("CopyOnWriteArrayList: " + cowList);
        System.out.println("CopyOnWriteArraySet: " + cowSet);

        printSubSection("Uso consigliato");
        System.out.println("Preferire collection concurrent dedicate rispetto a synchronized wrappers in scenari multi-thread.");
    }

    private static void demoLegacyAndSpecializedCollections() {
        printSection("8) Legacy e special-purpose collections");

        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        Object weakKey = new Object();
        weakHashMap.put(weakKey, "cached");

        IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<>();
        String keyA = new StringBuilder("K").toString();
        String keyB = new StringBuilder("K").toString();
        identityHashMap.put(keyA, 1);
        identityHashMap.put(keyB, 2); // chiavi diverse per identità

        EnumMap<Level, String> enumMap = new EnumMap<>(Level.class);
        enumMap.put(Level.LOW, "low-priority");
        enumMap.put(Level.HIGH, "high-priority");

        Properties properties = new Properties();
        properties.setProperty("app.name", "Java21Course");
        properties.setProperty("app.version", "1.0");

        System.out.println("WeakHashMap size (before GC hint): " + weakHashMap.size());
        System.out.println("IdentityHashMap size (identity based): " + identityHashMap.size());
        System.out.println("EnumMap: " + enumMap);
        System.out.println("Properties: " + properties);

        // cleanup reference to favor GC eligibility in example
        weakKey = null;
        if (weakKey == null) {
            System.out.println("weakKey released (GC timing non deterministico).");
        }
    }

    private static void demoCollectionsUtilityClass() {
        printSection("9) Collections utility class");

        List<String> modifiable = new ArrayList<>(List.of("b", "a", "c"));
        Collections.sort(modifiable);
        Collections.reverse(modifiable);

        List<String> unmodifiable = Collections.unmodifiableList(modifiable);
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>(modifiable));
        List<String> checkedList = Collections.checkedList(new ArrayList<>(), String.class);
        checkedList.add("ok");

        System.out.println("modifiable sorted/reversed: " + modifiable);
        System.out.println("unmodifiableList: " + unmodifiable);
        System.out.println("synchronizedList: " + synchronizedList);
        System.out.println("checkedList: " + checkedList);
        System.out.println("emptyList: " + Collections.emptyList());
        System.out.println("singletonList: " + Collections.singletonList("single"));
    }

    private static void demoStreamsAndCollectorsWithCollections() {
        printSection("10) Streams + Collectors con Collections");

        List<String> names = List.of("mario", "anna", "luca", "marco", "alessia");

        List<String> filteredUpper = names.stream()
                .filter(n -> n.length() >= 5)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println("filteredUpper: " + filteredUpper);
        System.out.println("groupedByLength: " + groupedByLength);
    }

    private static void demoSelectionGuide() {
        printSection("11) Guida rapida di scelta");

        String[] guide = {
                "List ordinata con accesso indice rapido -> ArrayList",
                "List con inserimenti su estremi -> LinkedList / ArrayDeque",
                "Set senza ordine -> HashSet",
                "Set con ordine inserimento -> LinkedHashSet",
                "Set ordinato -> TreeSet",
                "Map key/value generale -> HashMap",
                "Map ordinata per chiave -> TreeMap",
                "Map thread-safe ad alte prestazioni -> ConcurrentHashMap",
                "Code prioritarie -> PriorityQueue / PriorityBlockingQueue",
                "Pipeline producer-consumer -> BlockingQueue implementations" };

        for (int i = 0; i < guide.length; i++) {
            System.out.printf("%d) %s%n", i + 1, guide[i]);
        }
    }

    private static void demoBestPractices() {
        printSection("12) Best practices e anti-pattern");

        String[] tips = {
                "Programma su interfacce (List/Set/Map), non su classi concrete.",
                "Scegli la collection in base a ordine, duplicati, access pattern e concorrenza.",
                "Usa immutabilità quando possibile (List.of, Map.of, unmodifiable wrappers).",
                "In multi-threading preferisci concurrent collections dedicate.",
                "Evita raw types: usa sempre generics.",
                "Documenta se metodi mutano o meno le collection in input.",
                "Per lookup frequenti usa Set/Map invece di scansioni lineari su List.",
                "Per comparazioni ordinate definisci Comparator chiari e consistenti.",
                "Evita null keys/values dove non necessari.",
                "Misura prima di ottimizzare: trade-off memoria/performance." };

        for (int i = 0; i < tips.length; i++) {
            System.out.printf("%d) %s%n", i + 1, tips[i]);
        }

        printSubSection("Anti-pattern");
        System.out.println("- Usare Vector/Hashtable/Stack senza necessità legacy");
        System.out.println("- Usare LinkedList come sostituto universale di ArrayList");
        System.out.println("- Accessi concorrenti su collection non thread-safe");
        System.out.println("- Confondere ordine di inserimento con ordinamento naturale");
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
        System.out.println(YELLOW + " Fine demo: Collection" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    private enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    private static final class DelayedItem implements Delayed {
        private final String value;
        private final long readyAtNanos;

        DelayedItem(String value, long delayMillis) {
            this.value = Objects.requireNonNull(value);
            this.readyAtNanos = System.nanoTime() + Duration.ofMillis(delayMillis).toNanos();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long remaining = readyAtNanos - System.nanoTime();
            return unit.convert(remaining, TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            long diff = this.getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS);
            return Long.compare(diff, 0);
        }

        @Override
        public String toString() {
            return "DelayedItem{" + value + "}";
        }
    }
}
