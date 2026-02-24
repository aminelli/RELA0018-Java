package com.corso.samples.datatypes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * Demo completa sull'uso di Optional in Java.
 */
public class OptionalDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private OptionalDemo() {
    }

    public static void run() {
        printHeader("OPTIONAL IN JAVA");

        demoWhyOptional();
        demoCreation();
        demoReadAndFallback();
        demoTransformations();
        demoFiltering();
        demoIfPresentVariants();
        demoOrElseVsOrElseGet();
        demoOrAndExceptionPatterns();
        demoOptionalWithStreams();
        demoPrimitiveOptionals();
        demoServiceRepositoryScenario();
        demoBestPractices();

        printFooter();
    }

    private static void demoWhyOptional() {
        printSection("1) Perché Optional");
        System.out.println("Optional rappresenta esplicitamente la presenza/assenza di un valore.");
        System.out.println("Riduce il rischio di NullPointerException e rende il contratto API più chiaro.");

        printSubSection("Obiettivo");
        System.out.println("Sostituire 'null-check sparsi' con pipeline dichiarative e fallback espliciti.");
    }

    private static void demoCreation() {
        printSection("2) Creazione di Optional");

        Optional<String> ofValue = Optional.of("Java 21");
        Optional<String> ofNullableNull = Optional.ofNullable(null);
        Optional<String> empty = Optional.empty();

        System.out.println("Optional.of(\"Java 21\"): " + ofValue);
        System.out.println("Optional.ofNullable(null): " + ofNullableNull);
        System.out.println("Optional.empty(): " + empty);

        printSubSection("Attenzione");
        System.out.println("Optional.of(null) lancia NullPointerException.");
    }

    private static void demoReadAndFallback() {
        printSection("3) Lettura e fallback");

        Optional<String> present = Optional.of("Corso Java");
        Optional<String> absent = Optional.empty();

        String v1 = present.orElse("Default");
        String v2 = absent.orElse("Default");
        String v3 = absent.orElseGet(() -> "Default lazy");

        System.out.println("present.orElse(...): " + v1);
        System.out.println("absent.orElse(...): " + v2);
        System.out.println("absent.orElseGet(...): " + v3);

        printSubSection("Linea guida");
        System.out.println("Evita get() diretto se non hai verificato prima la presenza del valore.");
    }

    private static void demoTransformations() {
        printSection("4) map / flatMap");

        Optional<User> user = Optional.of(new User("u1", "Anna", new Address("Roma", "00100")));

        Optional<String> city = user.map(User::address).map(Address::city);
        Optional<String> zip = user.flatMap(u -> Optional.ofNullable(u.address())).map(Address::zipCode);

        System.out.println("city via map: " + city.orElse("N/D"));
        System.out.println("zip via flatMap+map: " + zip.orElse("N/D"));

        Optional<User> userWithoutAddress = Optional.of(new User("u2", "Luca", null));
        String citySafe = userWithoutAddress
                .map(User::address)
                .map(Address::city)
                .orElse("Sconosciuta");
        System.out.println("utente senza indirizzo -> city: " + citySafe);
    }

    private static void demoFiltering() {
        printSection("5) filter");

        Optional<Integer> maybeAge = Optional.of(20);

        Optional<Integer> adult = maybeAge.filter(a -> a >= 18);
        Optional<Integer> senior = maybeAge.filter(a -> a >= 65);

        System.out.println("adult present: " + adult.isPresent());
        System.out.println("senior present: " + senior.isPresent());

        printSubSection("Use case");
        System.out.println("Valida un valore opzionale senza if annidati.");
    }

    private static void demoIfPresentVariants() {
        printSection("6) ifPresent / ifPresentOrElse");

        Optional<String> maybeToken = Optional.of("abc-123");
        Optional<String> noToken = Optional.empty();

        maybeToken.ifPresent(token -> System.out.println("token trovato: " + token));

        noToken.ifPresentOrElse(
                token -> System.out.println("token: " + token),
                () -> System.out.println("token assente"));
    }

    private static void demoOrElseVsOrElseGet() {
        printSection("7) orElse vs orElseGet");

        Optional<String> present = Optional.of("value");

        String withOrElse = present.orElse(expensiveDefault("orElse"));
        String withOrElseGet = present.orElseGet(() -> expensiveDefault("orElseGet"));

        System.out.println("Result orElse: " + withOrElse);
        System.out.println("Result orElseGet: " + withOrElseGet);

        printSubSection("Conclusione");
        System.out.println("orElse valuta sempre il fallback, orElseGet solo quando serve.");
    }

    private static void demoOrAndExceptionPatterns() {
        printSection("8) or(...) e orElseThrow(...)");

        Optional<String> primary = Optional.empty();
        Optional<String> secondary = Optional.of("fallback-from-secondary");

        String resolved = primary
                .or(() -> secondary)
                .orElseThrow(() -> new IllegalStateException("Valore non disponibile"));

        System.out.println("resolved via or(...): " + resolved);

        Optional<Order> maybeOrder = findOrderById("O-100");
        Order order = maybeOrder.orElseThrow(() -> new IllegalArgumentException("Ordine non trovato"));
        System.out.println("order loaded: " + order);
    }

    private static void demoOptionalWithStreams() {
        printSection("9) Optional + Streams");

        List<String> raw = List.of("10", "x", "42", "", "77");

        List<Integer> parsed = raw.stream()
                .map(OptionalDemo::tryParseInt)
                .flatMap(Optional::stream)
                .toList();

        System.out.println("input: " + raw);
        System.out.println("parsed validi: " + parsed);

        Optional<Integer> firstBig = parsed.stream().filter(v -> v > 40).findFirst();
        System.out.println("first > 40: " + firstBig.orElse(-1));
    }

    private static void demoPrimitiveOptionals() {
        printSection("10) OptionalInt / OptionalDouble");

        OptionalInt maybeSize = OptionalInt.of(15);
        OptionalDouble maybeAvg = OptionalDouble.empty();

        int size = maybeSize.orElse(0);
        double avg = maybeAvg.orElseGet(() -> 0.0);

        System.out.println("OptionalInt -> " + size);
        System.out.println("OptionalDouble -> " + avg);

        printSubSection("Quando usarli");
        System.out.println("Nei flussi numerici per evitare boxing/unboxing non necessario.");
    }

    private static void demoServiceRepositoryScenario() {
        printSection("11) Scenario realistico: repository/service");

        UserRepository repository = new UserRepository();
        PricingService pricingService = new PricingService();

        Optional<User> maybeUser = repository.findById("u1");

        BigDecimal discount = maybeUser
                .filter(User::isAdult)
                .map(User::id)
                .flatMap(pricingService::findDiscountForUser)
                .orElse(BigDecimal.ZERO);

        System.out.println("Discount user u1: " + discount);

        BigDecimal discountUnknown = repository.findById("missing")
                .filter(User::isAdult)
                .map(User::id)
                .flatMap(pricingService::findDiscountForUser)
                .orElse(BigDecimal.ZERO);

        System.out.println("Discount missing user: " + discountUnknown);
    }

    private static void demoBestPractices() {
        printSection("12) Best practices e anti-pattern");

        String[] rules = {
                "Usa Optional come tipo di ritorno quando il valore può mancare.",
                "Non usare Optional per campi di entità/DTO serializzati.",
                "Non usare Optional come parametro di metodo salvo casi molto specifici.",
                "Preferisci map/flatMap/filter a if annidati con null.",
                "Preferisci orElseGet per fallback costosi.",
                "Usa orElseThrow per invarianti obbligatorie.",
                "Non chiamare get() senza controllo di presenza.",
                "Documenta il significato dell'assenza (empty)." };

        for (int i = 0; i < rules.length; i++) {
            System.out.printf("%d) %s%n", i + 1, rules[i]);
        }

        printSubSection("Anti-pattern");
        System.out.println("- Optional.get() come scorciatoia");
        System.out.println("- Optional annidati (Optional<Optional<T>>)");
        System.out.println("- Conversione continua Optional <-> null senza valore aggiunto");
    }

    private static String expensiveDefault(String source) {
        System.out.println("calcolo fallback da " + source + "...");
        return "generated-default";
    }

    private static Optional<Integer> tryParseInt(String value) {
        if (value == null || value.isBlank()) {
            return Optional.empty();
        }

        try {
            int parsed = Integer.parseInt(value);
            return Optional.of(parsed);
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }

    private static Optional<Order> findOrderById(String orderId) {
        if (Objects.equals(orderId, "O-100")) {
            return Optional.of(new Order(orderId, new BigDecimal("99.90")));
        }
        return Optional.empty();
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
        System.out.println(YELLOW + " Fine demo: Optional" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    private record Address(String city, String zipCode) {
    }

    private record User(String id, String name, Address address) {
        boolean isAdult() {
            return !"Luca".equals(name);
        }
    }

    private record Order(String id, BigDecimal total) {
    }

    private static class UserRepository {
        private final Map<String, User> users = Map.of(
                "u1", new User("u1", "Anna", new Address("Roma", "00100")),
                "u2", new User("u2", "Luca", null));

        Optional<User> findById(String id) {
            return Optional.ofNullable(users.get(id));
        }
    }

    private static class PricingService {
        Optional<BigDecimal> findDiscountForUser(String userId) {
            if ("u1".equals(userId)) {
                return Optional.of(new BigDecimal("10.00"));
            }
            return Optional.empty();
        }
    }
}
