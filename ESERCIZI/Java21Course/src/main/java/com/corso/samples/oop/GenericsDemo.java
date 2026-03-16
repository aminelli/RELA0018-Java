package com.corso.samples.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Demo completa sui Generics in Java 21.
 *
 * <p>
 * Copre:
 * </p>
 * <ul>
 * <li>Classi e metodi generici</li>
 * <li>Type inference e diamond operator</li>
 * <li>Bounded type parameters</li>
 * <li>Wildcards: ?, ? extends, ? super</li>
 * <li>PECS (Producer Extends, Consumer Super)</li>
 * <li>Type erasure, bridge methods, limitazioni</li>
 * <li>Best practices e anti-pattern</li>
 * </ul>
 */
public class GenericsDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private GenericsDemo() {
    }

    public static void run() {
        printHeader("GENERICS IN JAVA 21");

        demoIntroduction();
        demoGenericClassBasics();
        demoGenericMethods();
        demoTypeInferenceAndDiamond();
        demoBoundedTypeParameters();
        demoMultipleBounds();
        demoWildcardsUnbounded();
        demoWildcardsExtendsSuper();
        demoPECSRule();
        demoGenericInterfaceImplementation();
        demoTypeErasureConcept();
        demoCommonRestrictions();
        demoBestPractices();

        printFooter();
    }

    private static void demoIntroduction() {
        printSection("1) Introduzione ai Generics");

        System.out.println("I Generics permettono di parametrizzare i tipi:");
        System.out.println("- Maggiore type-safety a compile-time");
        System.out.println("- Riduzione cast espliciti");
        System.out.println("- API più riusabili e chiare");

        printSubSection("Termini chiave");
        System.out.println("T        -> type parameter");
        System.out.println("E        -> element (collection)");
        System.out.println("K,V      -> key/value (map)");
        System.out.println("?        -> wildcard");
    }

    private static void demoGenericClassBasics() {
        printSection("2) Classe generica base");

        Box<String> stringBox = new Box<>("Java");
        Box<Integer> intBox = new Box<>(21);

        System.out.println("stringBox: " + stringBox.get());
        System.out.println("intBox: " + intBox.get());

        stringBox.set("Generics");
        System.out.println("stringBox updated: " + stringBox.get());

        printSubSection("Vantaggio");
        System.out.println("Il compilatore impedisce inserimenti di tipo errato.");
    }

    private static void demoGenericMethods() {
        printSection("3) Metodi generici");

        Integer firstInt = GenericUtils.firstOf(10, 20, 30);
        String firstWord = GenericUtils.firstOf("alpha", "beta");

        System.out.println("firstOf integers: " + firstInt);
        System.out.println("firstOf strings: " + firstWord);

        Pair<String, Integer> pair = GenericUtils.pairOf("eta", 25);
        System.out.println("pairOf: " + pair);
        System.out.println("pair key/value accessors -> " + pair.key() + " / " + pair.value());
    }

    private static void demoTypeInferenceAndDiamond() {
        printSection("4) Type inference e diamond operator");

        List<String> names = new ArrayList<>();
        names.add("Mario");
        names.add("Anna");

        Map<String, Integer> scores = Map.of("Math", 28, "Java", 30);

        System.out.println("names: " + names);
        System.out.println("scores: " + scores);

        printSubSection("Nota");
        System.out.println("Con <> Java infere i tipi dal contesto evitando ridondanza.");
    }

    private static void demoBoundedTypeParameters() {
        printSection("5) Bounded type parameters");

        StatsBox<Integer> intStats = new StatsBox<>();
        intStats.add(10);
        intStats.add(20);
        intStats.add(30);

        StatsBox<Double> doubleStats = new StatsBox<>();
        doubleStats.add(4.5);
        doubleStats.add(5.5);

        System.out.printf("intStats avg: %.2f%n", intStats.average());
        System.out.printf("doubleStats avg: %.2f%n", doubleStats.average());

        printSubSection("Regola");
        System.out.println("T extends Number consente operazioni numeriche in modo type-safe.");
    }

    private static void demoMultipleBounds() {
        printSection("6) Multiple bounds");

        SortableNamedEntity a = new SortableNamedEntity("beta");
        SortableNamedEntity b = new SortableNamedEntity("alpha");

        SortableNamedEntity max = GenericComparators.maxOf(a, b);
        System.out.println("maxOf by compareTo: " + max.name());

        printSubSection("Firma usata");
        System.out.println("<T extends Comparable<T> & Named> permette più vincoli sul tipo.");
    }

    private static void demoWildcardsUnbounded() {
        printSection("7) Wildcard unbounded (?)");

        List<String> strings = List.of("a", "b", "c");
        List<Integer> ints = List.of(1, 2, 3, 4);

        System.out.println("size(strings): " + GenericUtils.sizeOf(strings));
        System.out.println("size(ints): " + GenericUtils.sizeOf(ints));

        printSubSection("Quando usarlo");
        System.out.println("Per API che leggono dati senza dipendere dal tipo specifico elemento.");
    }

    private static void demoWildcardsExtendsSuper() {
        printSection("8) Wildcards: ? extends e ? super");

        List<Integer> source = List.of(10, 20, 30);
        List<Number> target = new ArrayList<>();

        GenericUtils.copyNumbers(source, target);
        System.out.println("target after copy: " + target);

        printSubSection("Interpretazione");
        System.out.println("? extends Number = producer (leggi)");
        System.out.println("? super Number   = consumer (scrivi)");
    }

    private static void demoPECSRule() {
        printSection("9) PECS: Producer Extends, Consumer Super");

        List<Double> producer = List.of(1.2, 3.4, 5.6);
        List<Object> consumer = new ArrayList<>();

        GenericUtils.transfer(producer, consumer);
        System.out.println("consumer after transfer: " + consumer);

        printSubSection("Regola pratica");
        System.out.println("Se PRODUCE -> extends. Se CONSUMA -> super.");
    }

    private static void demoGenericInterfaceImplementation() {
        printSection("10) Interfaccia generica e implementazioni");

        Repository<User> userRepo = new InMemoryRepository<>();
        userRepo.save(new User("U1", "Mario"));
        userRepo.save(new User("U2", "Anna"));

        Optional<User> found = userRepo.findById("U2");
        System.out.println("findById(U2): " + found.orElse(null));
        System.out.println("all users: " + userRepo.findAll());
    }

    private static void demoTypeErasureConcept() {
        printSection("11) Type erasure (concetto)");

        Box<String> bs = new Box<>("hello");
        Box<Integer> bi = new Box<>(123);

        System.out.println("bs runtime class: " + bs.getClass().getName());
        System.out.println("bi runtime class: " + bi.getClass().getName());
        System.out.println("same runtime class? " + (bs.getClass() == bi.getClass()));

        printSubSection("Spiegazione");
        System.out.println("A runtime i parametri generici sono erasi (type erasure).");
    }

    private static void demoCommonRestrictions() {
        printSection("12) Restrizioni comuni dei Generics");

        printSubSection("Limitazioni note");
        System.out.println("- Non puoi fare new T()");
        System.out.println("- Non puoi usare primitive direttamente (usa wrapper)");
        System.out.println("- Non puoi creare array di tipo parametrico (new T[])");
        System.out.println("- Non puoi usare instanceof con parametro concreto generico");

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        System.out.println("Integers with wrappers: " + ints);
    }

    private static void demoBestPractices() {
        printSection("13) Best practices e anti-pattern");

        List<String> rules = List.of(
                "Usa generics ovunque serva type-safety, evita raw types.",
                "Preferisci List<T> a List<Object> quando il tipo è noto.",
                "Per API di sola lettura usa wildcard (<? extends T>) se utile.",
                "Applica PECS per producer/consumer.",
                "Evita cast non sicuri e @SuppressWarnings non necessari.",
                "Nomina type parameter in modo standard (T,E,K,V,R).",
                "Mantieni API generiche semplici e comprensibili.",
                "Usa bounded types solo quando portano valore reale.",
                "Documenta i contratti di tipo nelle API pubbliche.",
                "Testa scenari limite con diversi parametri di tipo.");

        for (int i = 0; i < rules.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, rules.get(i));
        }

        printSubSection("Anti-pattern");
        System.out.println("- Uso di raw types (List invece di List<T>)");
        System.out.println("- API troppo complesse con wildcard annidate inutilmente");
        System.out.println("- Cast frequenti invece di firma generica corretta");
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
        System.out.println(YELLOW + " Fine demo: Generics" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    private static final class Box<T> {
        private T value;

        Box(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }

        void set(T value) {
            this.value = value;
        }
    }

    private static final class Pair<K, V> {
        private final K key;
        private final V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key() {
            return key;
        }

        V value() {
            return value;
        }

        @Override
        public String toString() {
            return "Pair{key=" + key + ", value=" + value + "}";
        }
    }

    private static final class StatsBox<T extends Number> {
        private final List<T> values = new ArrayList<>();

        void add(T value) {
            values.add(Objects.requireNonNull(value));
        }

        double average() {
            if (values.isEmpty()) {
                return 0.0;
            }
            double sum = 0;
            for (T value : values) {
                sum += value.doubleValue();
            }
            return sum / values.size();
        }
    }

    private interface Named {
        String name();
    }

    private static final class SortableNamedEntity implements Comparable<SortableNamedEntity>, Named {
        private final String name;

        SortableNamedEntity(String name) {
            this.name = Objects.requireNonNull(name);
        }

        @Override
        public int compareTo(SortableNamedEntity other) {
            return this.name.compareToIgnoreCase(other.name);
        }

        @Override
        public String name() {
            return name;
        }
    }

    private static final class GenericComparators {
        private GenericComparators() {
            throw new AssertionError("Utility class");
        }

        static <T extends Comparable<T> & Named> T maxOf(T a, T b) {
            return a.compareTo(b) >= 0 ? a : b;
        }
    }

    private static final class GenericUtils {
        private GenericUtils() {
            throw new AssertionError("Utility class");
        }

        @SafeVarargs
        static <T> T firstOf(T... values) {
            if (values == null || values.length == 0) {
                throw new IllegalArgumentException("values richiesto");
            }
            return values[0];
        }

        static <K, V> Pair<K, V> pairOf(K key, V value) {
            return new Pair<>(key, value);
        }

        static int sizeOf(List<?> list) {
            return list.size();
        }

        static void copyNumbers(List<? extends Number> source, List<? super Number> target) {
            for (Number number : source) {
                target.add(number);
            }
        }

        static <T> void transfer(List<? extends T> source, List<? super T> target) {
            for (T element : source) {
                target.add(element);
            }
        }
    }

    private interface Repository<T> {
        void save(T element);

        Optional<T> findById(String id);

        List<T> findAll();
    }

    private static final class InMemoryRepository<T extends Identifiable> implements Repository<T> {
        private final List<T> store = new ArrayList<>();

        @Override
        public void save(T element) {
            store.add(Objects.requireNonNull(element));
        }

        @Override
        public Optional<T> findById(String id) {
            for (T element : store) {
                if (element.id().equals(id)) {
                    return Optional.of(element);
                }
            }
            return Optional.empty();
        }

        @Override
        public List<T> findAll() {
            return List.copyOf(store);
        }
    }

    private interface Identifiable {
        String id();
    }

    private record User(String id, String name) implements Identifiable {
        private User {
            if (id == null || id.isBlank()) {
                throw new IllegalArgumentException("id obbligatorio");
            }
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name obbligatorio");
            }
        }
    }
}
