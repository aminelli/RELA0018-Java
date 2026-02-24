package com.corso.samples.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Demo completa OOP: Incapsulamento, Ereditarietà e Polimorfismo.
 *
 * <p>
 * Include distinzione tra:
 * </p>
 * <ul>
 * <li>Polimorfismo implicito (dinamico/runtime via override + upcasting)</li>
 * <li>Polimorfismo esplicito (scelta esplicita via overload/cast/pattern matching)</li>
 * </ul>
 */
public class OOPDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private OOPDemo() {
    }

    public static void run() {
        printHeader("OOP: INCAPSULAMENTO, EREDITARIETA, POLIMORFISMO");

        demoIntroduction();
        demoEncapsulationBasics();
        demoEncapsulationWithValidation();
        demoEncapsulationWithReadOnlyView();
        demoInheritanceBasics();
        demoInheritanceWithSuperAndOverride();
        demoCompositionVsInheritance();
        demoPolymorphismImplicitRuntime();
        demoPolymorphismExplicitOverloading();
        demoPolymorphismExplicitCastPatternMatching();
        demoAbstractClassAndInterfaceTogether();
        demoLiskovSubstitutionIdea();
        demoBestPractices();

        printFooter();
    }

    private static void demoIntroduction() {
        printSection("1) Introduzione OOP");

        System.out.println("I tre pilastri principali trattati:");
        System.out.println("- Incapsulamento: protezione stato + API controllata");
        System.out.println("- Ereditarietà: riuso e specializzazione (is-a)");
        System.out.println("- Polimorfismo: stesso contratto, comportamenti diversi");

        printSubSection("Obiettivo");
        System.out.println("Capire quando usare ogni pilastro e come evitare anti-pattern progettuali.");
    }

    private static void demoEncapsulationBasics() {
        printSection("2) Incapsulamento base");

        BankAccount account = new BankAccount("IT00X12345", 500.0);
        account.deposit(120.0);
        account.withdraw(80.0);

        System.out.println("IBAN (read-only): " + account.getIban());
        System.out.printf("Saldo: %.2f%n", account.getBalance());

        printSubSection("Perché funziona");
        System.out.println("Campi private + metodi pubblici = controllo completo delle modifiche allo stato.");
    }

    private static void demoEncapsulationWithValidation() {
        printSection("3) Incapsulamento con validazione");

        Product product = new Product("P100", "Notebook", 999.90);
        System.out.println("Prodotto iniziale: " + product);

        product.changePrice(899.90);
        System.out.println("Prezzo aggiornato: " + product);

        printSubSection("Regola");
        System.out.println("Le invarianti (es. prezzo > 0) si difendono dentro i metodi della classe.");
    }

    private static void demoEncapsulationWithReadOnlyView() {
        printSection("4) Incapsulamento con vista read-only");

        StudentRegistry registry = new StudentRegistry();
        registry.add(new Student("S1", "Mario"));
        registry.add(new Student("S2", "Anna"));

        List<Student> snapshot = registry.getStudents();
        System.out.println("Snapshot studenti: " + snapshot);

        printSubSection("Nota");
        System.out.println("La lista restituita è immutabile (copy) per evitare modifiche esterne allo stato interno.");
    }

    private static void demoInheritanceBasics() {
        printSection("5) Ereditarietà base");

        Vehicle car = new Car("AB123CD", 4);
        Vehicle bike = new Bike("XY987ZT");

        System.out.println(car.describe());
        System.out.println(bike.describe());

        printSubSection("Scenario");
        System.out.println("Classe base Vehicle con attributi comuni e specializzazioni Car/Bike.");
    }

    private static void demoInheritanceWithSuperAndOverride() {
        printSection("6) Ereditarietà con super e override");

        Employee dev = new Developer("Laura", 35000, "Java");
        Employee mgr = new Manager("Luca", 45000, 8);

        System.out.println(dev.summary());
        System.out.println(mgr.summary());

        printSubSection("Punto chiave");
        System.out.println("Le sottoclassi estendono comportamento chiamando super + override metodi specifici.");
    }

    private static void demoCompositionVsInheritance() {
        printSection("7) Composizione vs Ereditarietà");

        Engine engine = new Engine("Hybrid-1.8");
        CarWithEngine composedCar = new CarWithEngine("ZZ000AA", engine);

        System.out.println(composedCar.describe());

        printSubSection("Best practice");
        System.out.println("Preferire composizione quando la relazione non è strettamente 'is-a'.");
    }

    private static void demoPolymorphismImplicitRuntime() {
        printSection("8) Polimorfismo implicito (runtime)");

        List<Animal> animals = List.of(
                new Dog("Rex"),
                new Cat("Mia"),
                new Bird("Sky"));

        for (Animal animal : animals) {
            System.out.println(animal.name() + " -> " + animal.sound());
        }

        printSubSection("Spiegazione");
        System.out.println("Hai un riferimento alla classe base (Animal), ma Java invoca automaticamente");
        System.out.println("l'override corretto in base all'oggetto reale: questo è polimorfismo implicito.");
    }

    private static void demoPolymorphismExplicitOverloading() {
        printSection("9) Polimorfismo esplicito (compile-time via overloading)");

        ReportFormatter formatter = new ReportFormatter();

        System.out.println(formatter.format("Sales report"));
        System.out.println(formatter.format(120));
        System.out.println(formatter.format("Revenue", 12999.95));

        printSubSection("Spiegazione");
        System.out.println("La scelta del metodo avviene esplicitamente dalla firma usata dal chiamante");
        System.out.println("(numero/tipo parametri): forma di polimorfismo ad-hoc a compile-time.");
    }

    private static void demoPolymorphismExplicitCastPatternMatching() {
        printSection("10) Polimorfismo esplicito con cast/pattern matching");

        List<PaymentMethod> payments = List.of(
                new CardPayment("****1234"),
                new BankTransferPayment("IT55X000"),
                new WalletPayment("MyWallet"));

        for (PaymentMethod method : payments) {
            System.out.println("Base execute -> " + method.execute(99.90));

            // Scelta esplicita di comportamento specifico tipo concreto
            String detail = switch (method) {
                case CardPayment card -> "  card token -> " + card.cardToken();
                case BankTransferPayment bank -> "  iban masked -> " + bank.maskedIban();
                case WalletPayment wallet -> "  wallet provider -> " + wallet.provider();
                default -> "  dettaglio non disponibile";
            };
            System.out.println(detail);
        }

        printSubSection("Spiegazione");
        System.out.println("Qui il chiamante sceglie in modo esplicito il tipo concreto (pattern matching/cast).");
        System.out.println("È utile in scenari specifici, ma da usare con moderazione.");
    }

    private static void demoAbstractClassAndInterfaceTogether() {
        printSection("11) Classe astratta + interfaccia");

        TaxCalculator standard = new StandardTaxCalculator();
        TaxCalculator reduced = new ReducedTaxCalculator();

        System.out.printf("Tax standard su 1000: %.2f%n", standard.calculate(1000));
        System.out.printf("Tax reduced su 1000: %.2f%n", reduced.calculate(1000));

        printSubSection("Scenario");
        System.out.println("Interfaccia = contratto; astratta = base con logica condivisa.");
    }

    private static void demoLiskovSubstitutionIdea() {
        printSection("12) Liskov Substitution (idea pratica)");

        List<Employee> team = List.of(
                new Developer("Marta", 30000, "Kotlin"),
                new Manager("Gianni", 50000, 5));

        double totalComp = 0;
        for (Employee e : team) {
            totalComp += e.annualCompensation();
            System.out.println(e.summary());
        }

        System.out.printf("Compensazione totale team: %.2f%n", totalComp);

        printSubSection("Idea");
        System.out.println("Se una sottoclasse rompe le aspettative del tipo base, il design è fragile.");
    }

    private static void demoBestPractices() {
        printSection("13) Best practices e anti-pattern");

        List<String> rules = List.of(
                "Incapsula sempre lo stato: campi private e API esplicite.",
                "Valida input nei costruttori e metodi mutatori.",
                "Usa ereditarietà solo per vera relazione is-a.",
                "Preferisci composizione quando possibile.",
                "Progetta classi base stabili e coese.",
                "Evita downcast frequenti: spesso indicano astrazione sbagliata.",
                "Polimorfismo implicito (override) come default.",
                "Polimorfismo esplicito (overload/cast) solo dove aggiunge chiarezza.",
                "Mantieni responsabilità singola per classe.",
                "Scrivi API orientate al dominio, non ai dettagli interni.");

        for (int i = 0; i < rules.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, rules.get(i));
        }

        printSubSection("Anti-pattern");
        System.out.println("- Campi public mutabili");
        System.out.println("- Gerarchie profonde e artificiali");
        System.out.println("- Override che cambia semanticamente il contratto base");
        System.out.println("- Abuso di instanceof/cast in tutto il codice");
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
        System.out.println(YELLOW + " Fine demo: OOP" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    private static class BankAccount {
        private final String iban;
        private double balance;

        BankAccount(String iban, double initialBalance) {
            this.iban = requireText(iban, "iban");
            if (initialBalance < 0) {
                throw new IllegalArgumentException("initialBalance non valido");
            }
            this.balance = initialBalance;
        }

        String getIban() {
            return iban;
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

    private static class Product {
        private final String code;
        private final String name;
        private double price;

        Product(String code, String name, double price) {
            this.code = requireText(code, "code");
            this.name = requireText(name, "name");
            this.price = validatePrice(price);
        }

        void changePrice(double newPrice) {
            this.price = validatePrice(newPrice);
        }

        @Override
        public String toString() {
            return "Product{code='" + code + "', name='" + name + "', price=" + price + "}";
        }
    }

    private record Student(String id, String name) {
        Student {
            requireText(id, "id");
            requireText(name, "name");
        }
    }

    private static class StudentRegistry {
        private final List<Student> students = new ArrayList<>();

        void add(Student student) {
            students.add(Objects.requireNonNull(student));
        }

        List<Student> getStudents() {
            return List.copyOf(students);
        }
    }

    private abstract static class Vehicle {
        private final String plate;

        Vehicle(String plate) {
            this.plate = requireText(plate, "plate");
        }

        abstract String type();

        String describe() {
            return type() + " plate=" + plate;
        }
    }

    private static class Car extends Vehicle {
        private final int doors;

        Car(String plate, int doors) {
            super(plate);
            if (doors <= 0) {
                throw new IllegalArgumentException("doors deve essere > 0");
            }
            this.doors = doors;
        }

        @Override
        String type() {
            return "Car(" + doors + " doors)";
        }
    }

    private static class Bike extends Vehicle {
        Bike(String plate) {
            super(plate);
        }

        @Override
        String type() {
            return "Bike";
        }
    }

    private static class Employee {
        protected final String name;
        protected final double baseSalary;

        Employee(String name, double baseSalary) {
            this.name = requireText(name, "name");
            if (baseSalary < 0) {
                throw new IllegalArgumentException("baseSalary non valido");
            }
            this.baseSalary = baseSalary;
        }

        double annualCompensation() {
            return baseSalary;
        }

        String summary() {
            return "Employee{name='" + name + "', comp=" + annualCompensation() + "}";
        }
    }

    private static class Developer extends Employee {
        private final String mainSkill;

        Developer(String name, double baseSalary, String mainSkill) {
            super(name, baseSalary);
            this.mainSkill = requireText(mainSkill, "mainSkill");
        }

        @Override
        double annualCompensation() {
            return baseSalary + 2000;
        }

        @Override
        String summary() {
            return "Developer{name='" + name + "', skill='" + mainSkill + "', comp=" + annualCompensation() + "}";
        }
    }

    private static class Manager extends Employee {
        private final int teamSize;

        Manager(String name, double baseSalary, int teamSize) {
            super(name, baseSalary);
            if (teamSize < 0) {
                throw new IllegalArgumentException("teamSize non valido");
            }
            this.teamSize = teamSize;
        }

        @Override
        double annualCompensation() {
            return baseSalary + (teamSize * 500);
        }

        @Override
        String summary() {
            return "Manager{name='" + name + "', teamSize=" + teamSize + ", comp=" + annualCompensation() + "}";
        }
    }

    private static class Engine {
        private final String model;

        Engine(String model) {
            this.model = requireText(model, "model");
        }

        String model() {
            return model;
        }
    }

    private static class CarWithEngine {
        private final String plate;
        private final Engine engine;

        CarWithEngine(String plate, Engine engine) {
            this.plate = requireText(plate, "plate");
            this.engine = Objects.requireNonNull(engine);
        }

        String describe() {
            return "CarWithEngine{plate='" + plate + "', engine='" + engine.model() + "'}";
        }
    }

    private abstract static class Animal {
        private final String name;

        Animal(String name) {
            this.name = requireText(name, "name");
        }

        String name() {
            return name;
        }

        abstract String sound();
    }

    private static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }

        @Override
        String sound() {
            return "bau";
        }
    }

    private static class Cat extends Animal {
        Cat(String name) {
            super(name);
        }

        @Override
        String sound() {
            return "miao";
        }
    }

    private static class Bird extends Animal {
        Bird(String name) {
            super(name);
        }

        @Override
        String sound() {
            return "cip";
        }
    }

    private static class ReportFormatter {
        String format(String title) {
            return "[TEXT] " + title;
        }

        String format(int totalItems) {
            return "[COUNT] total=" + totalItems;
        }

        String format(String metric, double value) {
            return "[METRIC] " + metric + "=" + String.format("%.2f", value);
        }
    }

    private interface PaymentMethod {
        String execute(double amount);
    }

    private static class CardPayment implements PaymentMethod {
        private final String token;

        CardPayment(String token) {
            this.token = requireText(token, "token");
        }

        @Override
        public String execute(double amount) {
            return "CardPayment amount=" + amount;
        }

        String cardToken() {
            return token;
        }
    }

    private static class BankTransferPayment implements PaymentMethod {
        private final String iban;

        BankTransferPayment(String iban) {
            this.iban = requireText(iban, "iban");
        }

        @Override
        public String execute(double amount) {
            return "BankTransfer amount=" + amount;
        }

        String maskedIban() {
            return "****" + iban.substring(Math.max(0, iban.length() - 4));
        }
    }

    private static class WalletPayment implements PaymentMethod {
        private final String provider;

        WalletPayment(String provider) {
            this.provider = requireText(provider, "provider");
        }

        @Override
        public String execute(double amount) {
            return "WalletPayment amount=" + amount;
        }

        String provider() {
            return provider;
        }
    }

    private interface TaxCalculator {
        double calculate(double taxableAmount);
    }

    private abstract static class BaseTaxCalculator implements TaxCalculator {
        protected double ensurePositive(double value) {
            if (value < 0) {
                throw new IllegalArgumentException("taxableAmount non valido");
            }
            return value;
        }
    }

    private static class StandardTaxCalculator extends BaseTaxCalculator {
        @Override
        public double calculate(double taxableAmount) {
            return ensurePositive(taxableAmount) * 0.22;
        }
    }

    private static class ReducedTaxCalculator extends BaseTaxCalculator {
        @Override
        public double calculate(double taxableAmount) {
            return ensurePositive(taxableAmount) * 0.10;
        }
    }

    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " obbligatorio");
        }
        return value;
    }

    private static double validatePrice(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("newPrice deve essere > 0");
        }
        return value;
    }
}
