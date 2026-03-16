package com.corso.samples.array_collections;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Demo completa sugli Streams in Java 21.
 *
 * <p>
 * Copre creazione stream, operazioni intermedie/terminali, collectors,
 * primitive streams, optional, parallel stream, best practices e anti-pattern.
 * </p>
 */
public class StreamsDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private StreamsDemo() {
    }

    public static void run() {
        printHeader("STREAMS IN JAVA 21");

        demoIntroduction();
        demoStreamCreation();
        demoIntermediateOperations();
        demoTerminalOperations();
        demoMapFlatMap();
        demoDistinctSortedLimitSkip();
        demoCollectorsToListSetMap();
        demoGroupingPartitioning();
        demoReducingAndSummaries();
        demoOptionalWithStreams();
        demoPrimitiveStreams();
        demoParallelStreams();
        demoCustomCollectorScenario();
        demoBestPractices();

        printFooter();
    }

    private static void demoIntroduction() {
        printSection("1) Introduzione agli Streams");

        System.out.println("Uno Stream è una pipeline dichiarativa per trasformare/elaborare dati.");
        System.out.println("Non memorizza dati: lavora su una sorgente (Collection, array, range, I/O). ");

        printSubSection("Caratteristiche chiave");
        System.out.println("- Lazy evaluation (intermediate ops)");
        System.out.println("- Terminal operation necessaria per esecuzione");
        System.out.println("- Orientato a trasformazioni, non a mutazione esplicita");
    }

    private static void demoStreamCreation() {
        printSection("2) Creazione Stream");

        List<String> names = List.of("mario", "anna", "luca");

        Stream<String> fromCollection = names.stream();
        Stream<String> fromValues = Stream.of("A", "B", "C");
        IntStream fromRange = IntStream.rangeClosed(1, 5);

        System.out.println("fromCollection count: " + fromCollection.count());
        System.out.println("fromValues toList: " + fromValues.toList());
        System.out.println("fromRange sum: " + fromRange.sum());

        printSubSection("Nota");
        System.out.println("Uno stream è consumabile una sola volta.");
    }

    private static void demoIntermediateOperations() {
        printSection("3) Operazioni intermedie");

        List<String> words = List.of("java", "stream", "lambda", "api", "collection");

        List<String> result = words.stream()
                .filter(w -> w.length() >= 5)
                .map(String::toUpperCase)
                .toList();

        System.out.println("filter + map: " + result);

        printSubSection("peek (debug controllato)");
        List<Integer> squares = IntStream.rangeClosed(1, 5)
                .peek(v -> System.out.println("input=" + v))
                .map(v -> v * v)
                .boxed()
                .toList();
        System.out.println("squares: " + squares);
    }

    private static void demoTerminalOperations() {
        printSection("4) Operazioni terminali");

        List<Integer> values = List.of(10, 20, 30, 40, 50);

        long count = values.stream().count();
        int sum = values.stream().reduce(0, Integer::sum);
        Optional<Integer> max = values.stream().max(Integer::compareTo);
        boolean anyMatch = values.stream().anyMatch(v -> v > 45);
        boolean allMatch = values.stream().allMatch(v -> v >= 10);

        System.out.println("count: " + count);
        System.out.println("sum (reduce): " + sum);
        System.out.println("max: " + max.orElse(null));
        System.out.println("anyMatch > 45: " + anyMatch);
        System.out.println("allMatch >= 10: " + allMatch);

        printSubSection("forEachOrdered");
        values.stream().forEachOrdered(v -> System.out.print(v + " "));
        System.out.println();
    }

    private static void demoMapFlatMap() {
        printSection("5) map vs flatMap");

        List<String> names = List.of("Mario Rossi", "Anna Bianchi", "Luca Verdi");

        List<Integer> lengths = names.stream().map(String::length).toList();
        System.out.println("map -> lengths: " + lengths);

        List<String> tokens = names.stream()
                .map(name -> name.split(" "))
                .flatMap(Stream::of)
                .map(String::toLowerCase)
                .toList();

        System.out.println("flatMap tokens: " + tokens);

        printSubSection("Scenario tipico");
        System.out.println("flatMap appiattisce strutture annidate (lista di liste -> lista semplice).");
    }

    private static void demoDistinctSortedLimitSkip() {
        printSection("6) distinct, sorted, limit, skip");

        List<Integer> raw = List.of(5, 2, 9, 2, 1, 5, 8, 3, 7);

        List<Integer> processed = raw.stream()
                .distinct()
                .sorted()
                .skip(1)
                .limit(5)
                .toList();

        System.out.println("raw: " + raw);
        System.out.println("processed: " + processed);
    }

    private static void demoCollectorsToListSetMap() {
        printSection("7) Collectors: toList / toSet / toMap");

        List<User> users = sampleUsers();

        List<String> names = users.stream().map(User::name).toList();
        Set<String> cities = users.stream().map(User::city).collect(Collectors.toCollection(TreeSet::new));
        Map<String, User> byId = users.stream().collect(Collectors.toMap(User::id, Function.identity()));

        System.out.println("names: " + names);
        System.out.println("cities(TreeSet): " + cities);
        System.out.println("byId keys: " + byId.keySet());

        printSubSection("Gestione collisioni in toMap");
        Map<String, String> cityByName = users.stream().collect(
                Collectors.toMap(User::name, User::city, (first, second) -> first));
        System.out.println("cityByName (merge policy): " + cityByName);
    }

    private static void demoGroupingPartitioning() {
        printSection("8) groupingBy e partitioningBy");

        List<User> users = sampleUsers();

        Map<String, List<User>> groupedByCity = users.stream()
                .collect(Collectors.groupingBy(User::city));

        Map<Boolean, List<User>> partitionedAdults = users.stream()
                .collect(Collectors.partitioningBy(u -> u.age() >= 18));

        System.out.println("groupedByCity: " + groupedByCity);
        System.out.println("partitionedAdults: " + partitionedAdults);

        Map<String, Long> countByCity = users.stream()
                .collect(Collectors.groupingBy(User::city, Collectors.counting()));
        System.out.println("countByCity: " + countByCity);
    }

    private static void demoReducingAndSummaries() {
        printSection("9) Reducing e statistiche");

        List<Order> orders = sampleOrders();

        BigDecimal total = orders.stream()
                .map(Order::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        IntSummaryStatistics ageStats = sampleUsers().stream().collect(Collectors.summarizingInt(User::age));
        DoubleSummaryStatistics amountStats = orders.stream().collect(Collectors.summarizingDouble(o -> o.total().doubleValue()));

        System.out.println("orders total: " + total);
        System.out.println("ageStats: " + ageStats);
        System.out.println("amountStats: " + amountStats);
    }

    private static void demoOptionalWithStreams() {
        printSection("10) Optional con Streams");

        List<User> users = sampleUsers();

        Optional<User> firstAdultInRome = users.stream()
                .filter(u -> u.city().equals("Roma"))
                .filter(u -> u.age() >= 18)
                .findFirst();

        String label = firstAdultInRome
                .map(u -> u.name() + " (" + u.age() + ")")
                .orElse("Nessun adulto trovato");

        System.out.println("firstAdultInRome: " + label);

        Optional<String> anyCity = users.stream().map(User::city).findAny();
        System.out.println("findAny city: " + anyCity.orElse("N/D"));
    }

    private static void demoPrimitiveStreams() {
        printSection("11) Primitive Streams (Int/Long/Double)");

        int sumSquares = IntStream.rangeClosed(1, 5)
                .map(v -> v * v)
                .sum();

        double average = IntStream.of(10, 20, 30, 40)
                .average()
                .orElse(0.0);

        List<Integer> boxed = IntStream.range(0, 5).boxed().toList();

        System.out.println("sumSquares 1..5: " + sumSquares);
        System.out.println("average: " + average);
        System.out.println("boxed: " + boxed);

        printSubSection("Beneficio");
        System.out.println("Evita boxing/unboxing in pipeline numeriche.");
    }

    private static void demoParallelStreams() {
        printSection("12) Parallel Streams");

        long startSeq = System.nanoTime();
        long seqSum = IntStream.rangeClosed(1, 2_000_000)
                .asLongStream()
                .sum();
        long endSeq = System.nanoTime();

        long startPar = System.nanoTime();
        long parSum = IntStream.rangeClosed(1, 2_000_000)
                .parallel()
                .asLongStream()
                .sum();
        long endPar = System.nanoTime();

        System.out.println("seqSum: " + seqSum + " time(ns): " + (endSeq - startSeq));
        System.out.println("parSum: " + parSum + " time(ns): " + (endPar - startPar));

        printSubSection("Nota importante");
        System.out.println("Parallel non è sempre più veloce: dipende da workload, overhead e CPU.");
    }

    private static void demoCustomCollectorScenario() {
        printSection("13) Scenario collector custom (simulato via collectingAndThen)");

        List<User> users = sampleUsers();

        String csvNames = users.stream()
                .map(User::name)
                .collect(Collectors.collectingAndThen(Collectors.joining(","), s -> "NAMES:" + s));

        System.out.println("csvNames: " + csvNames);

        List<User> immutableAdults = users.stream()
                .filter(u -> u.age() >= 18)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));

        System.out.println("immutableAdults: " + immutableAdults);
    }

    private static void demoBestPractices() {
        printSection("14) Best practices e anti-pattern");

        String[] rules = {
                "Preferisci stream per trasformazioni dichiarative su collezioni.",
                "Evita side-effect in map/filter.",
                "Usa method references quando migliorano leggibilità.",
                "Scegli primitive streams per workload numerici.",
                "Usa collector appropriati (groupingBy, mapping, summarizing...).",
                "Attenzione a parallel streams su task piccoli.",
                "Non riutilizzare uno stream già consumato.",
                "Gestisci Optional senza get() diretto quando possibile.",
                "Mantieni pipeline leggibili (estrai metodi se necessario).",
                "Misura performance reali prima di ottimizzare." };

        for (int i = 0; i < rules.length; i++) {
            System.out.printf("%d) %s%n", i + 1, rules[i]);
        }

        printSubSection("Anti-pattern");
        System.out.println("- Stream annidati complessi senza chiarezza");
        System.out.println("- Mutare stato esterno in forEach/map");
        System.out.println("- Usare parallel indiscriminatamente");
        System.out.println("- Ignorare costi di boxing/unboxing");
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
        System.out.println(YELLOW + " Fine demo: streams" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    private static List<User> sampleUsers() {
        return List.of(
                new User("U1", "Mario", 28, "Roma"),
                new User("U2", "Anna", 17, "Milano"),
                new User("U3", "Luca", 34, "Roma"),
                new User("U4", "Sara", 22, "Torino"),
                new User("U5", "Marco", 16, "Milano"));
    }

    private static List<Order> sampleOrders() {
        return List.of(
                new Order("O1", new BigDecimal("120.50")),
                new Order("O2", new BigDecimal("89.99")),
                new Order("O3", new BigDecimal("250.00")));
    }

    private record User(String id, String name, int age, String city) {
    }

    private record Order(String id, BigDecimal total) {
    }
}
