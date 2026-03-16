package com.corso.samples.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Demo completa su costruttori, metodi e proprietà delle classi in Java 21.
 *
 * <p>
 * Include anche esempi delle principali tipologie di classi dichiarabili e scenari
 * d'uso pratici.
 * </p>
 */
public class MethodsPropertiesDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private MethodsPropertiesDemo() {
    }

    public static void run() {
        printHeader("METODI E PROPRIETA DELLE CLASSI IN JAVA 21");

        demoIntroduction();
        demoConstructorsBasic();
        demoConstructorsOverloadAndChaining();
        demoConstructorsCopyAndFactory();
        demoPropertiesAndEncapsulation();
        demoComputedProperties();
        demoMethodsInstanceStaticOverload();
        demoOverrideAndPolymorphism();
        demoVarargsAndGenericMethods();
        demoFluentMethods();
        demoClassTypesOverview();
        demoNestedAndInnerClasses();
        demoLocalAndAnonymousClasses();
        demoRecordAsPropertyCarrier();
        demoSealedHierarchyScenario();
        demoBestPractices();

        printFooter();
    }

    private static void demoIntroduction() {
        printSection("1) Introduzione");
        System.out.println("In Java, una classe combina:");
        System.out.println("- Costruttori: inizializzano correttamente lo stato.");
        System.out.println("- Proprietà (campi): rappresentano i dati.");
        System.out.println("- Metodi: rappresentano il comportamento.");

        printSubSection("Obiettivo del modulo");
        System.out.println("Capire come progettare classi robuste, leggibili e manutenibili,");
        System.out.println("con focus su validazione, encapsulation e API pulite.");
    }

    private static void demoConstructorsBasic() {
        printSection("2) Costruttori base");

        Product p1 = new Product();
        Product p2 = new Product("P100", "Mouse", 24.90);
        p1.setPrice(9.90);

        System.out.println("Costruttore no-args -> " + p1);
        System.out.println("Costruttore parametrico -> " + p2);
        System.out.printf("Getter sample -> code=%s name=%s price=%.2f%n", p2.getCode(), p2.getName(), p2.getPrice());

        printSubSection("Regola");
        System.out.println("Un costruttore deve lasciare sempre l'oggetto in stato valido.");
    }

    private static void demoConstructorsOverloadAndChaining() {
        printSection("3) Overload e constructor chaining (this(...))");

        UserAccount u1 = new UserAccount("mario");
        UserAccount u2 = new UserAccount("laura", "laura@demo.it");
        UserAccount u3 = new UserAccount("anna", "anna@demo.it", true);

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);

        printSubSection("Scenario tipico");
        System.out.println("Overload utile quando hai diversi livelli di dettaglio input.");
    }

    private static void demoConstructorsCopyAndFactory() {
        printSection("4) Copy constructor e costruttore privato con factory");

        Product original = new Product("P200", "Keyboard", 39.90);
        Product copied = new Product(original);

        Temperature celsius = Temperature.ofCelsius(25.0);
        Temperature fahrenheit = Temperature.ofFahrenheit(77.0);

        System.out.println("Original: " + original);
        System.out.println("Copied:   " + copied);
        System.out.printf("Temp C: %.2f°C%n", celsius.celsius());
        System.out.printf("Temp F->C: %.2f°C%n", fahrenheit.celsius());

        printSubSection("Perché factory methods");
        System.out.println("Nomi espliciti (ofCelsius/ofFahrenheit) evitano ambiguità nei parametri.");
    }

    private static void demoPropertiesAndEncapsulation() {
        printSection("5) Proprietà e encapsulation");

        Wallet wallet = new Wallet("EUR", 100.0);
        wallet.deposit(50.0);
        wallet.withdraw(20.0);

        System.out.println("Currency: " + wallet.getCurrency());
        System.out.printf("Balance: %.2f%n", wallet.getBalance());

        printSubSection("Best practice");
        System.out.println("Campi private + metodi pubblici che proteggono invarianti.");
    }

    private static void demoComputedProperties() {
        printSection("6) Proprietà calcolate");

        Rectangle rect = new Rectangle(8.0, 3.5);
        System.out.printf("Width: %.2f, Height: %.2f%n", rect.getWidth(), rect.getHeight());
        System.out.printf("Area (computed): %.2f%n", rect.getArea());
        System.out.printf("Perimeter (computed): %.2f%n", rect.getPerimeter());

        printSubSection("Nota");
        System.out.println("Le proprietà derivate non si memorizzano, si calcolano quando servono.");
    }

    private static void demoMethodsInstanceStaticOverload() {
        printSection("7) Metodi instance, static e overload");

        Calculator calc = new Calculator();
        System.out.println("Instance add(int,int): " + calc.add(4, 7));
        System.out.println("Instance add(double,double): " + calc.add(4.5, 7.2));
        System.out.println("Static max(int,int): " + Calculator.max(12, 9));

        printSubSection("Quando static");
        System.out.println("Per logica senza stato d'istanza (utility o factory).");
    }

    private static void demoOverrideAndPolymorphism() {
        printSection("8) Override e polimorfismo");

        NotificationService email = new EmailNotificationService();
        NotificationService sms = new SmsNotificationService();

        System.out.println(email.send("Conferma registrazione"));
        System.out.println(sms.send("Codice OTP"));

        printSubSection("Scenario");
        System.out.println("Stessa API (send), implementazioni diverse in runtime.");
    }

    private static void demoVarargsAndGenericMethods() {
        printSection("9) Metodi varargs e metodi generici");

        String joined = Strings.joinWithComma("Java", "OOP", "Class", "Methods");
        Integer first = GenericUtils.firstOf(10, 20, 30);
        String firstWord = GenericUtils.firstOf("alpha", "beta");

        System.out.println("joinWithComma: " + joined);
        System.out.println("firstOf Integer: " + first);
        System.out.println("firstOf String: " + firstWord);
    }

    private static void demoFluentMethods() {
        printSection("10) Fluent methods (method chaining)");

        QueryFilter filter = new QueryFilter()
                .status("ACTIVE")
                .minAge(18)
                .city("Milano");

        System.out.println("Filtro costruito: " + filter.describe());

        printSubSection("Beneficio");
        System.out.println("Configurazione leggibile e compatta per oggetti complessi.");
    }

    private static void demoClassTypesOverview() {
        printSection("11) Tipologie di classi dichiarabili");

        ImmutableConfig config = new ImmutableConfig("Java21Course", "Europe/Rome");

        System.out.println("1) Classe concreta -> Product, Wallet");
        System.out.println("2) Classe astratta -> NotificationService");
        System.out.println("3) Classe final -> ImmutableConfig");
        System.out.println("4) Classe annidata statica -> Department.Stats");
        System.out.println("5) Classe inner -> Department.Employee");
        System.out.println("6) Classe locale -> Validator locale in metodo");
        System.out.println("7) Classe anonima -> renderer anonimo");
        System.out.println("8) Record -> CustomerView");
        System.out.println("9) Gerarchia sealed -> Operation (Add/Subtract)");
        System.out.println("Config immutable sample -> app=" + config.appName() + ", tz=" + config.timezone());
    }

    private static void demoNestedAndInnerClasses() {
        printSection("12) Static nested class e inner class");

        Department dep = new Department("Engineering");
        Department.Employee e1 = dep.new Employee("Mario", "Backend");
        Department.Employee e2 = dep.new Employee("Laura", "Frontend");

        dep.addEmployee(e1);
        dep.addEmployee(e2);

        Department.Stats stats = Department.Stats.from(dep);

        System.out.println("Department: " + dep.getName());
        System.out.println("Employees: " + dep.getEmployeeCount());
        System.out.println("Stats summary: " + stats.summary());
        System.out.println("Inner sample: " + e1.label());
    }

    private static void demoLocalAndAnonymousClasses() {
        printSection("13) Classe locale e anonima");

        int validCount = validateCodes(List.of("A12", "B33", "ERR", "C77"));
        System.out.println("Valid code count (local class): " + validCount);

        RenderStrategy renderer = new RenderStrategy() {
            @Override
            String transform(String input) {
                return "[ANON] " + input.toUpperCase();
            }
        };

        System.out.println(renderer.render("preview message"));

        printSubSection("Nota pratica");
        System.out.println("La classe anonima è utile per implementazioni one-shot con logica dedicata.");
    }

    private static void demoRecordAsPropertyCarrier() {
        printSection("14) Record come portatore di proprietà");

        CustomerView view = new CustomerView("C001", "Luca", "Roma");
        System.out.println("Record: " + view);
        System.out.println("Accessor auto-generati -> id=" + view.id() + ", name=" + view.name());
    }

    private static void demoSealedHierarchyScenario() {
        printSection("15) Sealed class hierarchy scenario");

        List<Operation> operations = List.of(
                new Add(7, 5),
                new Subtract(20, 3));

        for (Operation op : operations) {
            System.out.println(op.describe() + " = " + op.execute());
        }

        printSubSection("Scenario");
        System.out.println("Sealed utile quando vuoi limitare formalmente le varianti possibili.");
    }

    private static void demoBestPractices() {
        printSection("16) Best practices e anti-pattern");

        List<String> bestPractices = List.of(
                "Valida input nei costruttori e fallisci velocemente (fail-fast).",
                "Mantieni campi private; esponi solo API necessarie.",
                "Evita setter pubblici se rompono invarianti.",
                "Preferisci immutabilità per value object.",
                "Usa nomi metodi orientati al dominio (deposit, withdraw, execute).",
                "Scegli static solo per logica senza stato.",
                "Usa overload con cautela e semantica chiara.",
                "Per molte opzioni, preferisci builder/fluent API.",
                "Per DTO semplici, valuta record.",
                "Evita classi troppo grandi: alta coesione, responsabilità singola.");

        for (int i = 0; i < bestPractices.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, bestPractices.get(i));
        }

        printSubSection("Anti-pattern comuni");
        System.out.println("- Costruttori con troppi parametri ambigui");
        System.out.println("- Getter/setter automatici senza regole di dominio");
        System.out.println("- Stato pubblico mutabile");
        System.out.println("- Utility class istanziabile");
        System.out.println("- Ereditarietà usata quando basterebbe composizione");
    }

    private static int validateCodes(List<String> codes) {
        class CodeValidator {
            boolean isValid(String code) {
                return code != null && code.length() == 3
                        && Character.isUpperCase(code.charAt(0))
                        && Character.isDigit(code.charAt(1))
                        && Character.isDigit(code.charAt(2));
            }
        }

        CodeValidator validator = new CodeValidator();
        int count = 0;
        for (String code : codes) {
            if (validator.isValid(code)) {
                count++;
            }
        }
        return count;
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
        System.out.println(YELLOW + " Fine demo: Metodi e proprietà" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    private static class Product {
        private String code;
        private String name;
        private double price;

        Product() {
            this("N/A", "Undefined", 0.0);
        }

        Product(String code, String name, double price) {
            this.code = requireText(code, "code");
            this.name = requireText(name, "name");
            this.price = validatePrice(price);
        }

        Product(Product other) {
            this(other.code, other.name, other.price);
        }

        String getCode() {
            return code;
        }

        String getName() {
            return name;
        }

        double getPrice() {
            return price;
        }

        void setPrice(double price) {
            this.price = validatePrice(price);
        }

        @Override
        public String toString() {
            return "Product{code='" + code + "', name='" + name + "', price=" + price + "}";
        }
    }

    private static class UserAccount {
        private final String username;
        private final String email;
        private final boolean active;

        UserAccount(String username) {
            this(username, username + "@example.local", true);
        }

        UserAccount(String username, String email) {
            this(username, email, true);
        }

        UserAccount(String username, String email, boolean active) {
            this.username = requireText(username, "username");
            this.email = requireText(email, "email");
            this.active = active;
        }

        @Override
        public String toString() {
            return "UserAccount{username='" + username + "', email='" + email + "', active=" + active + "}";
        }
    }

    private static class Temperature {
        private final double celsius;

        private Temperature(double celsius) {
            this.celsius = celsius;
        }

        static Temperature ofCelsius(double celsius) {
            return new Temperature(celsius);
        }

        static Temperature ofFahrenheit(double fahrenheit) {
            double c = (fahrenheit - 32) * 5 / 9;
            return new Temperature(c);
        }

        double celsius() {
            return celsius;
        }
    }

    private static class Wallet {
        private final String currency;
        private double balance;

        Wallet(String currency, double initialBalance) {
            this.currency = requireText(currency, "currency");
            if (initialBalance < 0) {
                throw new IllegalArgumentException("initialBalance non valida");
            }
            this.balance = initialBalance;
        }

        String getCurrency() {
            return currency;
        }

        double getBalance() {
            return balance;
        }

        void deposit(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("deposit > 0 richiesto");
            }
            balance += amount;
        }

        void withdraw(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("withdraw > 0 richiesto");
            }
            if (amount > balance) {
                throw new IllegalArgumentException("fondi insufficienti");
            }
            balance -= amount;
        }
    }

    private static class Rectangle {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            if (width <= 0 || height <= 0) {
                throw new IllegalArgumentException("dimensioni non valide");
            }
            this.width = width;
            this.height = height;
        }

        double getWidth() {
            return width;
        }

        double getHeight() {
            return height;
        }

        double getArea() {
            return width * height;
        }

        double getPerimeter() {
            return 2 * (width + height);
        }
    }

    private static class Calculator {
        int add(int a, int b) {
            return a + b;
        }

        double add(double a, double b) {
            return a + b;
        }

        static int max(int a, int b) {
            return a >= b ? a : b;
        }
    }

    private abstract static class NotificationService {
        abstract String send(String message);
    }

    private static class EmailNotificationService extends NotificationService {
        @Override
        String send(String message) {
            return "EMAIL sent: " + message;
        }
    }

    private static class SmsNotificationService extends NotificationService {
        @Override
        String send(String message) {
            return "SMS sent: " + message;
        }
    }

    private static class Strings {
        private Strings() {
            throw new AssertionError("Utility class non istanziabile");
        }

        static String joinWithComma(String... values) {
            return String.join(", ", values);
        }
    }

    private static class GenericUtils {
        private GenericUtils() {
            throw new AssertionError("Utility class non istanziabile");
        }

        @SafeVarargs
        static <T> T firstOf(T... values) {
            if (values == null || values.length == 0) {
                throw new IllegalArgumentException("almeno un elemento richiesto");
            }
            return values[0];
        }
    }

    private static class QueryFilter {
        private String status;
        private Integer minAge;
        private String city;

        QueryFilter status(String status) {
            this.status = requireText(status, "status");
            return this;
        }

        QueryFilter minAge(int minAge) {
            if (minAge < 0) {
                throw new IllegalArgumentException("minAge non valida");
            }
            this.minAge = minAge;
            return this;
        }

        QueryFilter city(String city) {
            this.city = requireText(city, "city");
            return this;
        }

        String describe() {
            return "status=" + status + ", minAge=" + minAge + ", city=" + city;
        }
    }

    private static final class ImmutableConfig {
        private final String appName;
        private final String timezone;

        ImmutableConfig(String appName, String timezone) {
            this.appName = requireText(appName, "appName");
            this.timezone = requireText(timezone, "timezone");
        }

        String appName() {
            return appName;
        }

        String timezone() {
            return timezone;
        }
    }

    private static class Department {
        private final String name;
        private final List<Employee> employees = new ArrayList<>();

        Department(String name) {
            this.name = requireText(name, "name");
        }

        String getName() {
            return name;
        }

        void addEmployee(Employee e) {
            employees.add(Objects.requireNonNull(e));
        }

        int getEmployeeCount() {
            return employees.size();
        }

        static class Stats {
            private final String departmentName;
            private final int employeeCount;

            private Stats(String departmentName, int employeeCount) {
                this.departmentName = departmentName;
                this.employeeCount = employeeCount;
            }

            static Stats from(Department dep) {
                return new Stats(dep.name, dep.employees.size());
            }

            String summary() {
                return departmentName + " has " + employeeCount + " employees";
            }
        }

        class Employee {
            private final String fullName;
            private final String role;

            Employee(String fullName, String role) {
                this.fullName = requireText(fullName, "fullName");
                this.role = requireText(role, "role");
            }

            String label() {
                return Department.this.name + " :: " + fullName + " (" + role + ")";
            }
        }
    }

    private abstract static class RenderStrategy {
        final String render(String input) {
            return transform(input);
        }

        abstract String transform(String input);
    }

    private record CustomerView(String id, String name, String city) {
        CustomerView {
            requireText(id, "id");
            requireText(name, "name");
            requireText(city, "city");
        }
    }

    private sealed abstract static class Operation permits Add, Subtract {
        protected final int left;
        protected final int right;

        Operation(int left, int right) {
            this.left = left;
            this.right = right;
        }

        abstract int execute();

        String describe() {
            return getClass().getSimpleName() + "(" + left + "," + right + ")";
        }
    }

    private static final class Add extends Operation {
        Add(int left, int right) {
            super(left, right);
        }

        @Override
        int execute() {
            return left + right;
        }
    }

    private static final class Subtract extends Operation {
        Subtract(int left, int right) {
            super(left, right);
        }

        @Override
        int execute() {
            return left - right;
        }
    }

    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " obbligatorio");
        }
        return value;
    }

    private static double validatePrice(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("price non può essere negativa");
        }
        return value;
    }
}
