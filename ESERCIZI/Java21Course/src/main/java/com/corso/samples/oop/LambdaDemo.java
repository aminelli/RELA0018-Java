package com.corso.samples.oop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Demo completa sulle Lambda Function in Java 21.
 *
 * <p>
 * Contenuti: sintassi, functional interfaces standard, method reference,
 * constructor reference, stream pipeline, composizione, gestione eccezioni,
 * best practices e anti-pattern.
 * </p>
 */
public class LambdaDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private LambdaDemo() {
    }

    public static void run() {
        printHeader("LAMBDA FUNCTION IN JAVA 21");

        demoIntroduction();
        demoLambdaSyntax();
        demoFunctionalInterfacesCore();
        demoCustomFunctionalInterface();
        demoMethodReferences();
        demoConstructorReferences();
        demoStreamsWithLambdas();
        demoComparatorAndSorting();
        demoOptionalAndLambdas();
        demoCompositionAndChaining();
        demoEffectivelyFinalCapture();
        demoPrimitiveSpecializedFunctionalInterfaces();
        demoExceptionHandlingPattern();
        demoBestPractices();

        printFooter();
    }

    private static void demoIntroduction() {
        printSection("1) Introduzione");

        System.out.println("Una lambda è una funzione anonima concisa che implementa una functional interface.");
        System.out.println("Si usa per passare comportamento come dato (strategy, callback, pipeline). ");

        printSubSection("Prerequisito");
        System.out.println("Funziona con interfacce che hanno un solo metodo astratto (@FunctionalInterface). ");
    }

    private static void demoLambdaSyntax() {
        printSection("2) Sintassi lambda");

        UnaryOperator<Integer> squareA = x -> x * x;
        UnaryOperator<Integer> squareB = (x) -> x * x;
        BiFunction<Integer, Integer, Integer> add = (a, b) -> {
            int sum = a + b;
            return sum;
        };

        System.out.println("squareA(5): " + squareA.apply(5));
        System.out.println("squareB(6): " + squareB.apply(6));
        System.out.println("add(10,20): " + add.apply(10, 20));

        printSubSection("Varianti");
        System.out.println("- Parametro singolo: x -> x * 2");
        System.out.println("- Più parametri: (a,b) -> a + b");
        System.out.println("- Corpo multilinea con return");
    }

    private static void demoFunctionalInterfacesCore() {
        printSection("3) Functional interfaces standard");

        Predicate<String> isLongerThan4 = s -> s != null && s.length() > 4;
        Function<String, Integer> lengthFn = s -> s == null ? 0 : s.length();
        Consumer<String> printer = s -> System.out.println("Consumed: " + s);
        Supplier<String> idSupplier = () -> "ID-" + System.nanoTime();
        UnaryOperator<Integer> increment = x -> x + 1;
        BinaryOperator<Integer> max = Integer::max;

        System.out.println("Predicate('hello'): " + isLongerThan4.test("hello"));
        System.out.println("Function('java'): " + lengthFn.apply("java"));
        printer.accept("message");
        System.out.println("Supplier(): " + idSupplier.get());
        System.out.println("UnaryOperator(10): " + increment.apply(10));
        System.out.println("BinaryOperator max(3,7): " + max.apply(3, 7));
    }

    private static void demoCustomFunctionalInterface() {
        printSection("4) Functional interface custom");

        PricePolicy standard = base -> base;
        PricePolicy discount10 = base -> base * 0.90;

        System.out.printf("Standard 100 -> %.2f%n", standard.apply(100));
        System.out.printf("Discount10 100 -> %.2f%n", discount10.apply(100));

        printSubSection("Use case");
        System.out.println("Policy/Strategy personalizzate senza creare molte classi concrete.");
    }

    private static void demoMethodReferences() {
        printSection("5) Method references");

        List<String> names = new ArrayList<>(List.of("mario", "anna", "luca"));
        names.replaceAll(String::toUpperCase);

        names.forEach(System.out::println);

        Comparator<String> cmp = String::compareToIgnoreCase;
        names.sort(cmp);

        System.out.println("Sorted names: " + names);

        printSubSection("Forme comuni");
        System.out.println("- Static method: ClassName::staticMethod");
        System.out.println("- Instance method su oggetto: obj::instanceMethod");
        System.out.println("- Instance method su tipo: Type::instanceMethod");
    }

    private static void demoConstructorReferences() {
        printSection("6) Constructor references");

        Function<String, User> userFactory = User::new;
        BiFunction<String, Integer, Pair> pairFactory = Pair::new;

        User user = userFactory.apply("Laura");
        Pair pair = pairFactory.apply("A", 100);

        System.out.println("User from ctor ref: " + user);
        System.out.println("Pair from ctor ref: " + pair);
    }

    private static void demoStreamsWithLambdas() {
        printSection("7) Streams + lambda");

        List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> evenSquared = values.stream()
                .filter(v -> v % 2 == 0)
                .map(v -> v * v)
                .toList();

        int sum = values.stream().reduce(0, Integer::sum);

        System.out.println("evenSquared: " + evenSquared);
        System.out.println("sum: " + sum);

        printSubSection("Pipeline");
        System.out.println("filter -> map -> reduce/collect");
    }

    private static void demoComparatorAndSorting() {
        printSection("8) Comparator con lambda");

        List<User> users = new ArrayList<>(List.of(
                new User("Marco"),
                new User("Anna"),
                new User("Luca")));

        users.sort((a, b) -> a.name().compareToIgnoreCase(b.name()));
        System.out.println("Sorted by name asc: " + users);

        users.sort(Comparator.comparing(User::name).reversed());
        System.out.println("Sorted by name desc: " + users);
    }

    private static void demoOptionalAndLambdas() {
        printSection("9) Optional + lambda");

        Optional<String> maybeName = Optional.of("mario");
        String greeting = maybeName
                .map(String::toUpperCase)
                .map(n -> "Ciao " + n)
                .orElse("Ciao ospite");

        System.out.println("Greeting: " + greeting);

        Optional<String> empty = Optional.empty();
        System.out.println("Fallback: " + empty.orElseGet(() -> "default-value"));
    }

    private static void demoCompositionAndChaining() {
        printSection("10) Composizione e chaining");

        Function<String, String> trim = String::trim;
        Function<String, String> upper = String::toUpperCase;
        Function<String, Integer> length = String::length;

        Function<String, Integer> pipeline = trim.andThen(upper).andThen(length);
        int len = pipeline.apply("  java lambda  ");

        Predicate<String> nonNull = s -> s != null;
        Predicate<String> startsWithJ = s -> s.startsWith("J");
        Predicate<String> rule = nonNull.and(startsWithJ);

        System.out.println("pipeline length: " + len);
        System.out.println("rule('JAVA'): " + rule.test("JAVA"));
    }

    private static void demoEffectivelyFinalCapture() {
        printSection("11) Capture di variabili effectively final");

        int threshold = 5;
        List<Integer> values = List.of(1, 5, 7, 10, 3, 8);

        List<Integer> filtered = values.stream()
                .filter(v -> v > threshold)
                .toList();

        System.out.println("threshold=" + threshold + " -> filtered=" + filtered);

        printSubSection("Regola");
        System.out.println("Le variabili locali catturate dalla lambda devono essere final/effectively final.");
    }

    private static void demoPrimitiveSpecializedFunctionalInterfaces() {
        printSection("12) Functional interfaces primitive-specialized");

        IntPredicate isEven = v -> v % 2 == 0;
        int[] sample = { 1, 2, 3, 4, 5, 6 };

        int count = 0;
        for (int value : sample) {
            if (isEven.test(value)) {
                count++;
            }
        }

        System.out.println("Even numbers count: " + count);

        printSubSection("Perché usarle");
        System.out.println("Riduzione boxing/unboxing rispetto a Predicate<Integer>.");
    }

    private static void demoExceptionHandlingPattern() {
        printSection("13) Pattern gestione eccezioni in lambda");

        List<String> raw = List.of("10", "20", "X", "30");

        raw.stream()
                .map(safeParseInt())
                .forEach(v -> System.out.println("Parsed: " + v));

        printSubSection("Nota");
        System.out.println("Gestire eccezioni dentro lambda con wrapper/adapter dedicati.");
    }

    private static Function<String, Integer> safeParseInt() {
        return input -> {
            if (input == null || !input.matches("-?\\d+")) {
                return -1;
            }
            return Integer.valueOf(input);
        };
    }

    private static void demoBestPractices() {
        printSection("14) Best practices e anti-pattern");

        String[] rules = {
                "Usa lambda per logica breve e leggibile.",
                "Se la lambda cresce troppo, estrai in metodo nominato.",
                "Preferisci method reference quando migliora chiarezza.",
                "Usa functional interfaces standard prima di crearne di custom.",
                "Evita side-effect nascosti nelle pipeline stream.",
                "Mantieni immutabilità quando possibile.",
                "Documenta contratti di lambda più complesse.",
                "Usa primitive specializations per hot path numerici.",
                "Gestisci eccezioni in modo esplicito.",
                "Non abusare di stream/lambda se un for è più chiaro." };

        for (int i = 0; i < rules.length; i++) {
            System.out.printf("%d) %s%n", i + 1, rules[i]);
        }

        printSubSection("Anti-pattern");
        System.out.println("- Lambda multilinea molto complessa in-line");
        System.out.println("- Side-effect pesanti dentro map/filter");
        System.out.println("- Cattura variabili mutabili in modo ambiguo");
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
        System.out.println(YELLOW + " Fine demo: Lambda" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    @FunctionalInterface
    private interface PricePolicy {
        double apply(double basePrice);
    }

    private record User(String name) {
        private User {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name obbligatorio");
            }
        }
    }

    private record Pair(String left, Integer right) {
        private Pair {
            if (left == null || left.isBlank()) {
                throw new IllegalArgumentException("left obbligatorio");
            }
            if (right == null) {
                throw new IllegalArgumentException("right obbligatorio");
            }
        }
    }
}
