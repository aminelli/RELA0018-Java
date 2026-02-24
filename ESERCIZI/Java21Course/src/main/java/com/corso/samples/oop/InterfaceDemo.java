package com.corso.samples.oop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Demo completa sulle Interfacce in Java 21.
 *
 * <p>
 * Copre definizione, implementazione, default/static/private methods,
 * functional interfaces, multiple inheritance of type, strategie, adapter e best practices.
 * </p>
 */
public class InterfaceDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private InterfaceDemo() {
    }

    public static void run() {
        printHeader("INTERFACCE IN JAVA 21");

        demoIntroduction();
        demoBasicInterfaceAndImplementation();
        demoPolymorphismWithInterface();
        demoDefaultMethods();
        demoStaticAndPrivateMethodsInInterface();
        demoFunctionalInterfaceAndLambda();
        demoMethodReference();
        demoStrategyPattern();
        demoAdapterPattern();
        demoComparableAndComparator();
        demoMarkerAndTaggingScenario();
        demoInterfaceSegregationPrinciple();
        demoDependencyInversionWithInterfaces();
        demoBestPractices();

        printFooter();
    }

    private static void demoIntroduction() {
        printSection("1) Introduzione alle Interfacce");

        System.out.println("Un'interfaccia definisce un contratto: cosa fare, non come.");
        System.out.println("In Java, una classe può implementare più interfacce.");

        printSubSection("Perché usare interfacce");
        System.out.println("- Disaccoppiare client e implementazione");
        System.out.println("- Favorire testabilità (mock/stub)");
        System.out.println("- Abilitare polimorfismo e sostituibilità");
    }

    private static void demoBasicInterfaceAndImplementation() {
        printSection("2) Interfaccia base e implementazione");

        PaymentProcessor processor = new CardPaymentProcessor();
        PaymentResult result = processor.process(new PaymentRequest("ORD-1001", 149.90));

        System.out.println("Processor: " + processor.name());
        System.out.println("Result: " + result);
    }

    private static void demoPolymorphismWithInterface() {
        printSection("3) Polimorfismo tramite interfaccia");

        List<NotificationChannel> channels = List.of(
                new EmailChannel(),
                new SmsChannel(),
                new PushChannel());

        for (NotificationChannel channel : channels) {
            System.out.println(channel.send("Benvenuto nel corso Java 21"));
        }

        printSubSection("Vantaggio");
        System.out.println("Il chiamante usa NotificationChannel senza conoscere le classi concrete.");
    }

    private static void demoDefaultMethods() {
        printSection("4) Default methods");

        CsvExporter csv = new CsvExporter();
        JsonExporter json = new JsonExporter();

        System.out.println(csv.export("userId,name"));
        System.out.println(json.export("{\"userId\":\"U1\"}"));

        printSubSection("Use case");
        System.out.println("I default methods permettono evoluzione API senza rompere implementazioni esistenti.");
    }

    private static void demoStaticAndPrivateMethodsInInterface() {
        printSection("5) Metodi static e private in interfaccia");

        String normalized = Exporter.normalizeName("  report  monthly ");
        System.out.println("normalizeName (static): " + normalized);

        AuditTrail audit = new ConsoleAuditTrail();
        audit.audit("Export completato");

        printSubSection("Nota");
        System.out.println("I metodi private in interfaccia sono helper riusabili da default methods.");
    }

    private static void demoFunctionalInterfaceAndLambda() {
        printSection("6) @FunctionalInterface e lambda");

        DiscountPolicy noDiscount = amount -> amount;
        DiscountPolicy seasonal = amount -> amount * 0.90;

        System.out.printf("No discount: %.2f%n", noDiscount.apply(200));
        System.out.printf("Seasonal discount: %.2f%n", seasonal.apply(200));
    }

    private static void demoMethodReference() {
        printSection("7) Method reference");

        List<String> names = new ArrayList<>(List.of("mario", "anna", "luca"));
        names.replaceAll(String::toUpperCase);

        System.out.println("Upper names: " + names);
    }

    private static void demoStrategyPattern() {
        printSection("8) Strategy pattern con interfacce");

        ShippingCalculator standard = new StandardShipping();
        ShippingCalculator express = new ExpressShipping();

        Order order = new Order("ORD-SHIPPING-01", 3.5);
        System.out.printf("Standard shipping: %.2f%n", standard.calculate(order));
        System.out.printf("Express shipping: %.2f%n", express.calculate(order));

        printSubSection("Scenario");
        System.out.println("Cambio algoritmo runtime senza if/else annidati.");
    }

    private static void demoAdapterPattern() {
        printSection("9) Adapter pattern");

        LegacyMailService legacy = new LegacyMailService();
        NotificationChannel adapted = new LegacyMailAdapter(legacy);

        System.out.println(adapted.send("Messaggio via adapter"));

        printSubSection("Scenario");
        System.out.println("Integrare sistemi legacy dietro interfacce moderne.");
    }

    private static void demoComparableAndComparator() {
        printSection("10) Comparable e Comparator");

        List<Student> students = new ArrayList<>(List.of(
                new Student("Mario", 27),
                new Student("Anna", 30),
                new Student("Luca", 25)));

        students.sort(null); // usa Comparable
        System.out.println("Sorted by vote desc (Comparable): " + students);

        students.sort((a, b) -> a.name().compareToIgnoreCase(b.name())); // Comparator lambda
        System.out.println("Sorted by name (Comparator): " + students);
    }

    private static void demoMarkerAndTaggingScenario() {
        printSection("11) Marker/tagging interface scenario");

        ReportDocument report = new ReportDocument("RPT-2026-01", true);
        if (report instanceof Exportable) {
            System.out.println("Documento exportabile: " + report.id());
        }

        printSubSection("Nota");
        System.out.println("I marker interface sono meno frequenti oggi, ma utili in framework legacy o convenzioni interne.");
    }

    private static void demoInterfaceSegregationPrinciple() {
        printSection("12) Interface Segregation Principle (ISP)");

        InMemoryUserRepository repository = new InMemoryUserRepository();
        ReadRepository<UserRecord> reader = repository;
        WriteRepository<UserRecord> writer = repository;

        writer.save(new UserRecord("U1", "Mario"));
        writer.save(new UserRecord("U2", "Anna"));

        System.out.println("All users: " + reader.findAll());

        printSubSection("Principio");
        System.out.println("Meglio interfacce piccole e specifiche invece di una interfaccia gigante.");
    }

    private static void demoDependencyInversionWithInterfaces() {
        printSection("13) Dependency Inversion con interfacce");

        Logger logger = new ConsoleLogger();
        UserService service = new UserService(logger);
        service.register("laura");

        printSubSection("Beneficio");
        System.out.println("UserService dipende da Logger (astrazione), non da una classe concreta.");
    }

    private static void demoBestPractices() {
        printSection("14) Best practices e anti-pattern");

        List<String> rules = List.of(
                "Definisci interfacce orientate al dominio (nomi espressivi).",
                "Mantieni interfacce piccole (ISP).",
                "Usa default methods solo per comportamento veramente comune.",
                "Evita 'interfacce vuote' non motivate.",
                "Preferisci composizione + interfacce a gerarchie rigide.",
                "Sfrutta lambda per functional interfaces semplici.",
                "Documenta chiaramente il contratto dei metodi.",
                "Mantieni implementazioni sostituibili e testabili.",
                "Non esporre dettagli tecnici superflui nel contratto.",
                "Bilancia flessibilità e semplicità: non astrarre troppo presto.");

        for (int i = 0; i < rules.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, rules.get(i));
        }

        printSubSection("Anti-pattern comuni");
        System.out.println("- Interfaccia con troppi metodi scollegati");
        System.out.println("- Contratti instabili che cambiano spesso");
        System.out.println("- Implementazioni fortemente accoppiate a dettagli esterni");
        System.out.println("- Uso indiscriminato di default methods per logica complessa");
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
        System.out.println(YELLOW + " Fine demo: Interfacce" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    private interface PaymentProcessor {
        PaymentResult process(PaymentRequest request);

        String name();
    }

    private static class CardPaymentProcessor implements PaymentProcessor {
        @Override
        public PaymentResult process(PaymentRequest request) {
            Objects.requireNonNull(request);
            return new PaymentResult(request.orderId(), true, "OK", LocalDateTime.now());
        }

        @Override
        public String name() {
            return "CardPaymentProcessor";
        }
    }

    private record PaymentRequest(String orderId, double amount) {
        private PaymentRequest {
            Objects.requireNonNull(orderId);
            if (amount <= 0) {
                throw new IllegalArgumentException("amount deve essere > 0");
            }
        }
    }

    private record PaymentResult(String orderId, boolean success, String message, LocalDateTime timestamp) {
    }

    private interface NotificationChannel {
        String send(String message);
    }

    private static class EmailChannel implements NotificationChannel {
        @Override
        public String send(String message) {
            return "EMAIL -> " + message;
        }
    }

    private static class SmsChannel implements NotificationChannel {
        @Override
        public String send(String message) {
            return "SMS -> " + message;
        }
    }

    private static class PushChannel implements NotificationChannel {
        @Override
        public String send(String message) {
            return "PUSH -> " + message;
        }
    }

    private interface Exporter {
        String export(String data);

        default String exportWithHeader(String data) {
            return "HEADER:" + data;
        }

        static String normalizeName(String raw) {
            return compactSpaces(raw).toUpperCase();
        }

        private static String compactSpaces(String raw) {
            if (raw == null) {
                return "";
            }
            return raw.trim().replaceAll("\\s+", " ");
        }
    }

    private static class CsvExporter implements Exporter {
        @Override
        public String export(String data) {
            return exportWithHeader("CSV|" + data);
        }
    }

    private static class JsonExporter implements Exporter {
        @Override
        public String export(String data) {
            return exportWithHeader("JSON|" + data);
        }
    }

    private interface AuditTrail {
        void audit(String event);

        default void auditWithPrefix(String event) {
            write(formatEvent(event));
        }

        private String formatEvent(String event) {
            return "AUDIT::" + event;
        }

        void write(String line);
    }

    private static class ConsoleAuditTrail implements AuditTrail {
        @Override
        public void audit(String event) {
            auditWithPrefix(event);
        }

        @Override
        public void write(String line) {
            System.out.println(line);
        }
    }

    @FunctionalInterface
    private interface DiscountPolicy {
        double apply(double amount);
    }

    private interface ShippingCalculator {
        double calculate(Order order);
    }

    private static class StandardShipping implements ShippingCalculator {
        @Override
        public double calculate(Order order) {
            return 4.99 + order.weightKg() * 0.50;
        }
    }

    private static class ExpressShipping implements ShippingCalculator {
        @Override
        public double calculate(Order order) {
            return 9.99 + order.weightKg() * 1.10;
        }
    }

    private record Order(String id, double weightKg) {
        private Order {
            Objects.requireNonNull(id);
            if (weightKg <= 0) {
                throw new IllegalArgumentException("weightKg deve essere > 0");
            }
        }
    }

    private static class LegacyMailService {
        String sendLegacy(String payload) {
            return "LEGACY_MAIL::" + payload;
        }
    }

    private static class LegacyMailAdapter implements NotificationChannel {
        private final LegacyMailService legacy;

        LegacyMailAdapter(LegacyMailService legacy) {
            this.legacy = Objects.requireNonNull(legacy);
        }

        @Override
        public String send(String message) {
            return legacy.sendLegacy(message);
        }
    }

    private record Student(String name, int vote) implements Comparable<Student> {
        private Student {
            Objects.requireNonNull(name);
            if (vote < 0 || vote > 30) {
                throw new IllegalArgumentException("vote range 0..30");
            }
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(other.vote, this.vote);
        }
    }

    private interface Exportable {
    }

    private record ReportDocument(String id, boolean signed) implements Exportable {
        private ReportDocument {
            Objects.requireNonNull(id);
        }
    }

    private interface ReadRepository<T> {
        List<T> findAll();
    }

    private interface WriteRepository<T> {
        void save(T element);
    }

    private static class InMemoryUserRepository implements ReadRepository<UserRecord>, WriteRepository<UserRecord> {
        private final List<UserRecord> store = new ArrayList<>();

        @Override
        public List<UserRecord> findAll() {
            return List.copyOf(store);
        }

        @Override
        public void save(UserRecord element) {
            store.add(Objects.requireNonNull(element));
        }
    }

    private record UserRecord(String id, String username) {
        private UserRecord {
            Objects.requireNonNull(id);
            Objects.requireNonNull(username);
        }
    }

    private interface Logger {
        void info(String message);
    }

    private static class ConsoleLogger implements Logger {
        @Override
        public void info(String message) {
            System.out.println("[INFO] " + message);
        }
    }

    private static class UserService {
        private final Logger logger;

        UserService(Logger logger) {
            this.logger = Objects.requireNonNull(logger);
        }

        void register(String username) {
            logger.info("User registered: " + username);
        }
    }
}
