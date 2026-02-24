package com.corso.samples.oop;

/**
 * ClassDemo - Dimostrazione completa e dettagliata dell'utilizzo avanzato delle
 * classi in Java 21
 * 
 * Questa classe demo mostra:
 * - Definizione di classi e costruttori
 * - Campi (instance, static, final)
 * - Metodi (instance, static, overloading, overriding)
 * - Modificatori di accesso
 * - Classi interne (nested, inner, local, anonymous)
 * - Classi astratte ed ereditarietà
 * - Record (Java 14+)
 * - Sealed classes (Java 17+)
 * - Pattern matching per instanceof e switch (Java 21)
 * - Encapsulation, Inheritance, Polymorphism
 */
public class ClassDemo {

    /**
     * Metodo principale che esegue tutte le dimostrazioni
     */
    public static void run() {
        printHeader("DIMOSTRAZIONE COMPLETA DELLE CLASSI IN JAVA 21");

        // 0. Introduzione alle Classi
        demonstrateIntroduction();

        // 1. Classi Base e Costruttori
        demonstrateBasicClasses();

        // 2. Modificatori di Accesso
        demonstrateAccessModifiers();

        // 3. Classi Interne (Nested Classes)
        demonstrateNestedClasses();

        // 4. Classi Astratte ed Ereditarietà
        demonstrateAbstractClasses();

        // 5. Incapsulamento (Encapsulation)
        demonstrateEncapsulation();

        // 6. Polimorfismo (Polymorphism)
        demonstratePolymorphism();

        // 7. Record (Java 14+)
        demonstrateRecords();

        // 8. Sealed Classes (Java 17+)
        demonstrateSealedClasses();

        // 9. Pattern Matching (Java 21)
        demonstratePatternMatching();

        // 10. Best Practices nella Programmazione OOP
        demonstrateBestPractices();

        printFooter();
    }

    // ========================================================================
    // 0. INTRODUZIONE ALLE CLASSI
    // ========================================================================

    private static void demonstrateIntroduction() {
        printSection("0. Introduzione alle Classi in Java");

        System.out.println("Cos'è una CLASSE?");
        System.out.println();
        System.out.println("  Una classe è un BLUEPRINT (progetto/modello) per creare oggetti.");
        System.out.println("  Definisce:");
        System.out.println("    - ATTRIBUTI (dati/campi): le caratteristiche dell'oggetto");
        System.out.println("    - METODI (comportamenti): le azioni che l'oggetto può eseguire");
        System.out.println();

        System.out.println("Cos'è un OGGETTO?");
        System.out.println();
        System.out.println("  Un oggetto è un'ISTANZA concreta di una classe.");
        System.out.println("  Se la classe è il 'progetto di una casa', l'oggetto è la 'casa effettiva'.");
        System.out.println();

        System.out.println("Analogia con il mondo reale:");
        System.out.println();
        System.out.println("  CLASSE 'Auto'          →  Progetto generico di un'auto");
        System.out.println("  OGGETTO 'miaFiat'      →  Una Fiat Panda rossa specifica");
        System.out.println("  OGGETTO 'tuaToyota'    →  Una Toyota Yaris blu specifica");
        System.out.println();
        System.out.println("  Stessa classe (Auto), ma oggetti diversi con caratteristiche diverse!");
        System.out.println();

        // Esempio pratico molto semplice
        System.out.println("Esempio pratico:");
        System.out.println();

        System.out.println("  Definiamo una classe 'Dog' (Cane):");
        System.out.println();
        System.out.println("    class Dog {");
        System.out.println("        String name;      // Attributo: nome del cane");
        System.out.println("        int age;          // Attributo: età del cane");
        System.out.println("        ");
        System.out.println("        void bark() {     // Metodo: comportamento");
        System.out.println("            System.out.println(name + \" fa: Bau Bau!\");");
        System.out.println("        }");
        System.out.println("    }");
        System.out.println();

        // Creazione di oggetti
        Dog rex = new Dog("Rex", 5);
        Dog fido = new Dog("Fido", 3);

        System.out.println("  Creiamo due oggetti dalla classe Dog:");
        System.out.println();
        System.out.println("    Dog rex = new Dog(\"Rex\", 5);    // Primo oggetto");
        System.out.println("    Dog fido = new Dog(\"Fido\", 3);  // Secondo oggetto");
        System.out.println();

        System.out.println("  Usiamo i nostri oggetti:");
        System.out.println();
        System.out.print("    rex.bark()   → ");
        rex.bark();
        System.out.print("    fido.bark()  → ");
        fido.bark();
        System.out.println();

        System.out.println("  Ogni oggetto ha i suoi dati, ma condivide il comportamento (metodi).");
        System.out.println();

        // Concetti fondamentali OOP
        System.out.println("I 4 Pilastri della Programmazione Orientata agli Oggetti (OOP):");
        System.out.println();

        System.out.println("  1. ENCAPSULATION (Incapsulamento)");
        System.out.println("     Nascondere i dettagli interni e esporre solo ciò che è necessario.");
        System.out.println("     Esempio: campi private con getter/setter public");
        System.out.println();

        System.out.println("  2. INHERITANCE (Ereditarietà)");
        System.out.println("     Una classe può ereditare caratteristiche da un'altra classe.");
        System.out.println("     Esempio: Dog extends Animal (Dog eredita da Animal)");
        System.out.println();

        System.out.println("  3. POLYMORPHISM (Polimorfismo)");
        System.out.println("     Oggetti di classi diverse possono essere trattati attraverso un'interfaccia comune.");
        System.out.println("     Esempio: Animal a = new Dog(); a.makeSound(); // chiama il metodo di Dog");
        System.out.println();

        System.out.println("  4. ABSTRACTION (Astrazione)");
        System.out.println("     Definire interfacce e contratti senza specificare i dettagli implementativi.");
        System.out.println("     Esempio: classi astratte e interfacce");
        System.out.println();

        // Vantaggi delle classi
        System.out.println("Perché usare le classi?");
        System.out.println();
        System.out.println("  ✓ RIUSABILITÀ: scrivi una volta, usa molte volte");
        System.out.println("  ✓ ORGANIZZAZIONE: codice strutturato e modulare");
        System.out.println("  ✓ MANUTENIBILITÀ: più facile da modificare e debuggare");
        System.out.println("  ✓ ASTRAZIONE: modellare concetti del mondo reale");
        System.out.println("  ✓ COLLABORAZIONE: più sviluppatori possono lavorare su classi diverse");
        System.out.println();

        System.out.println("Nelle sezioni seguenti esploreremo in dettaglio tutti questi concetti!");
        System.out.println();
    }

    /**
     * Classe di esempio semplice per l'introduzione
     */
    static class Dog {
        private final String name;
        private final int age;

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void bark() {
            System.out.println(name + " (" + age + " anni) fa: Bau Bau!");
        }
    }

    // ========================================================================
    // 1. DIMOSTRAZIONE CLASSI BASE E COSTRUTTORI
    // ========================================================================

    private static void demonstrateBasicClasses() {
        printSection("1. Classi Base e Costruttori");

        // Creazione di un oggetto usando il costruttore di default (senza parametri)
        Person person1 = new Person();
        System.out.println("Persona creata con costruttore default: " + person1);

        // Creazione di un oggetto usando il costruttore con parametri
        Person person2 = new Person("Mario Rossi", 35);
        System.out.println("Persona creata con costruttore parametrizzato: " + person2);

        // Creazione usando il costruttore con un solo parametro (constructor chaining)
        Person person3 = new Person("Giulia Bianchi");
        System.out.println("Persona creata con costruttore a un parametro: " + person3);

        // Utilizzo di metodi instance
        person2.celebrateBirthday();
        System.out.println("Dopo il compleanno: " + person2);

        // Utilizzo di metodi static
        System.out.println("Totale persone create: " + Person.getTotalPersons());

        System.out.println();
    }

    /**
     * Classe dimostrativa che mostra:
     * - Campi instance (nome, età)
     * - Campo static (contatore totale persone)
     * - Constructor overloading (più costruttori)
     * - Constructor chaining (chiamata tra costruttori)
     * - Metodi instance e static
     * - toString() override
     */
    static class Person {
        // CAMPI INSTANCE: ogni oggetto Person ha la propria copia di questi campi
        private String name; // Campo privato: accessibile solo all'interno della classe
        private int age; // Campo privato

        // CAMPO STATIC: condiviso tra tutte le istanze della classe
        // Viene utilizzato per contare quante persone sono state create
        private static int totalPersons = 0;

        // COSTRUTTORE DEFAULT (senza parametri)
        // Viene chiamato quando si crea un oggetto senza specificare valori
        public Person() {
            this("Unknown", 0); // Constructor chaining: chiama l'altro costruttore
            System.out.println("  -> Costruttore default invocato");
        }

        // COSTRUTTORE CON UN PARAMETRO
        // Dimostra il constructor chaining: questo costruttore chiama quello completo
        public Person(String name) {
            this(name, 0); // Chiama il costruttore con due parametri, passando age=0
            System.out.println("  -> Costruttore con un parametro invocato");
        }

        // COSTRUTTORE COMPLETO (con tutti i parametri)
        // Questo è il costruttore "principale" che inizializza effettivamente i campi
        public Person(String name, int age) {
            this.name = name; // 'this' si riferisce all'oggetto corrente
            this.age = age;
            totalPersons++; // Incrementa il contatore statico
            System.out.println("  -> Costruttore completo invocato");
        }

        // METODO INSTANCE: opera sui dati dell'oggetto specifico
        public void celebrateBirthday() {
            this.age++;
            System.out.println("  -> " + name + " festeggia il compleanno! Nuova età: " + age);
        }

        // METODI GETTER: permettono l'accesso controllato ai campi privati
        // (Encapsulation)
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        // METODO SETTER: permette la modifica controllata dei campi privati
        public void setName(String name) {
            // Potremmo aggiungere validazione qui
            if (name != null && !name.trim().isEmpty()) {
                this.name = name;
            }
        }

        // METODO STATIC: appartiene alla classe, non alle istanze
        // Non può accedere ai campi instance (name, age) perché non opera su un oggetto
        // specifico
        public static int getTotalPersons() {
            return totalPersons;
        }

        // OVERRIDE del metodo toString() da Object
        // Permette una rappresentazione testuale significativa dell'oggetto
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    // ========================================================================
    // 2. DIMOSTRAZIONE MODIFICATORI DI ACCESSO
    // ========================================================================

    private static void demonstrateAccessModifiers() {
        printSection("2. Modificatori di Accesso");

        System.out.println("I modificatori di accesso in Java sono:");
        System.out.println("  - public: accessibile da qualsiasi classe");
        System.out.println("  - protected: accessibile da stessa classe, stesso package e sottoclassi");
        System.out.println("  - package-private (default): accessibile solo dallo stesso package");
        System.out.println("  - private: accessibile solo dalla stessa classe");

        AccessModifiersExample example = new AccessModifiersExample();
        example.demonstrateAccess();

        System.out.println();
    }

    /**
     * Classe che dimostra i diversi livelli di accesso
     */
    static class AccessModifiersExample {
        public String publicField = "Pubblico"; // Accessibile ovunque
        protected String protectedField = "Protetto"; // Accessibile in package e sottoclassi
        String packageField = "Package"; // Accessibile solo nel package
        private String privateField = "Privato"; // Accessibile solo in questa classe

        public void demonstrateAccess() {
            // All'interno della classe possiamo accedere a tutti i campi
            System.out.println("  Accesso interno alla classe:");
            System.out.println("    publicField: " + publicField);
            System.out.println("    protectedField: " + protectedField);
            System.out.println("    packageField: " + packageField);
            System.out.println("    privateField: " + privateField);
        }

        // Metodi con diversi livelli di accesso
        public void publicMethod() {
            System.out.println("  Metodo pubblico chiamato");
        }

        protected void protectedMethod() {
            System.out.println("  Metodo protetto chiamato");
        }

        void packageMethod() {
            System.out.println("  Metodo package-private chiamato");
        }

        private void privateMethod() {
            System.out.println("  Metodo privato chiamato");
        }
    }

    // ========================================================================
    // 3. DIMOSTRAZIONE CLASSI INTERNE (NESTED CLASSES)
    // ========================================================================

    private static void demonstrateNestedClasses() {
        printSection("3. Classi Interne (Nested Classes)");

        // 3a. Static Nested Class
        System.out.println("3a. Static Nested Class:");
        OuterClass.StaticNestedClass staticNested = new OuterClass.StaticNestedClass();
        staticNested.display();

        // 3b. Inner Class (Non-static)
        System.out.println("\n3b. Inner Class (Non-static):");
        OuterClass outer = new OuterClass("Dati Esterni");
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        // 3c. Local Class (definita all'interno di un metodo)
        System.out.println("\n3c. Local Class:");
        outer.demonstrateLocalClass();

        // 3d. Anonymous Class (classe anonima)
        System.out.println("\n3d. Anonymous Class:");
        outer.demonstrateAnonymousClass();

        System.out.println();
    }

    /**
     * Classe esterna che contiene vari tipi di classi interne
     */
    static class OuterClass {
        private String outerData;
        private static String staticOuterData = "Dati Statici Esterni";

        public OuterClass(String data) {
            this.outerData = data;
        }

        // 3a. STATIC NESTED CLASS
        // - Non ha accesso ai membri instance della classe esterna
        // - Può accedere solo ai membri static della classe esterna
        // - Si comporta come una classe top-level, ma è organizzata all'interno di
        // un'altra classe
        static class StaticNestedClass {
            public void display() {
                System.out.println("  Static Nested Class:");
                System.out.println("    Posso accedere a: " + staticOuterData);
                // System.out.println(outerData); // ERRORE! Non può accedere a membri instance
                System.out.println("    Uso: per organizzare classi helper logicamente correlate");
            }
        }

        // 3b. INNER CLASS (Non-static Member Class)
        // - Ha accesso a tutti i membri della classe esterna (anche private)
        // - Richiede un'istanza della classe esterna per essere creata
        // - Mantiene un riferimento implicito all'oggetto della classe esterna
        class InnerClass {
            public void display() {
                System.out.println("  Inner Class:");
                System.out.println("    Posso accedere a: " + outerData); // Accesso a campo instance
                System.out.println("    Posso accedere a: " + staticOuterData); // E anche a static
                System.out.println("    Uso: quando la classe interna ha senso solo nel contesto di quella esterna");
            }
        }

        // 3c. LOCAL CLASS (definita dentro un metodo)
        // - Ha accesso ai membri della classe esterna
        // - Ha accesso alle variabili locali del metodo (se final o effectively final)
        public void demonstrateLocalClass() {
            final String localVariable = "Variabile Locale";

            // Definizione della local class all'interno del metodo
            class LocalClass {
                public void display() {
                    System.out.println("  Local Class:");
                    System.out.println("    Posso accedere a: " + outerData);
                    System.out.println("    Posso accedere a: " + localVariable);
                    System.out.println("    Uso: per logica specifica di un metodo che richiede una classe");
                }
            }

            // Creazione e utilizzo della local class
            LocalClass local = new LocalClass();
            local.display();
        }

        // 3d. ANONYMOUS CLASS (classe anonima)
        // - Estende una classe o implementa un'interfaccia inline
        // - Non ha nome e viene definita e istanziata contemporaneamente
        // - Utile per implementazioni one-time
        public void demonstrateAnonymousClass() {
            // Definizione di un'interfaccia semplice
            interface Greeter {
                void greet();
            }

            // Creazione di una classe anonima che implementa l'interfaccia
            Greeter greeter = new Greeter() {
                @Override
                public void greet() {
                    System.out.println("  Anonymous Class:");
                    System.out.println("    Ciao da una classe anonima!");
                    System.out.println("    Posso accedere a: " + outerData);
                    System.out.println("    Uso: implementazioni veloci di interfacce o classi astratte");
                }
            };

            greeter.greet();
        }
    }

    // ========================================================================
    // 4. DIMOSTRAZIONE CLASSI ASTRATTE ED EREDITARIETÀ
    // ========================================================================

    private static void demonstrateAbstractClasses() {
        printSection("4. Classi Astratte ed Ereditarietà");

        System.out.println("Le classi astratte:");
        System.out.println("  - Non possono essere istanziate direttamente");
        System.out.println("  - Possono contenere metodi astratti (senza implementazione)");
        System.out.println("  - Possono contenere metodi concreti (con implementazione)");
        System.out.println("  - Le sottoclassi devono implementare tutti i metodi astratti");
        System.out.println();

        // Creazione di oggetti delle sottoclassi
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        // Chiamata ai metodi
        circle.displayInfo();
        System.out.println();
        rectangle.displayInfo();

        System.out.println();
    }

    /**
     * Classe astratta che rappresenta una forma geometrica
     * - Definisce il contratto che tutte le forme devono rispettare
     * - Fornisce implementazione per metodi comuni
     */
    abstract static class Shape {
        protected String color; // Campo protetto: accessibile nelle sottoclassi

        // Costruttore della classe astratta
        public Shape() {
            this.color = "Bianco";
        }

        // METODO ASTRATTO: deve essere implementato dalle sottoclassi
        // Non ha corpo (implementazione)
        public abstract double calculateArea();

        // METODO ASTRATTO
        public abstract double calculatePerimeter();

        // METODO CONCRETO: ha un'implementazione che può essere usata o override
        public void displayInfo() {
            System.out.println("  Forma: " + this.getClass().getSimpleName());
            System.out.println("  Colore: " + color);
            System.out.println("  Area: " + calculateArea());
            System.out.println("  Perimetro: " + calculatePerimeter());
        }

        // Metodo concreto con logica comune
        public void setColor(String color) {
            this.color = color;
        }
    }

    /**
     * Classe concreta che estende Shape
     * Deve implementare tutti i metodi astratti della classe padre
     */
    static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            super(); // Chiama il costruttore della superclasse
            this.radius = radius;
            this.color = "Rosso"; // Possiamo accedere ai campi protected della superclasse
        }

        // IMPLEMENTAZIONE del metodo astratto
        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        // IMPLEMENTAZIONE del metodo astratto
        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    /**
     * Un'altra classe concreta che estende Shape
     */
    static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            super();
            this.width = width;
            this.height = height;
            this.color = "Blu";
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        // OVERRIDE di un metodo concreto della superclasse
        @Override
        public void displayInfo() {
            super.displayInfo(); // Chiama l'implementazione della superclasse
            System.out.println("  Dimensioni: " + width + " x " + height);
        }
    }

    // ========================================================================
    // 5. DIMOSTRAZIONE INCAPSULAMENTO (ENCAPSULATION)
    // ========================================================================

    private static void demonstrateEncapsulation() {
        printSection("5. Incapsulamento (Encapsulation)");

        System.out.println("L'INCAPSULAMENTO è uno dei 4 pilastri fondamentali dell'OOP.");
        System.out.println();
        System.out.println("Principi chiave:");
        System.out.println("  1. INFORMATION HIDING: nascondere i dettagli implementativi interni");
        System.out.println("  2. ACCESSO CONTROLLATO: esporre solo ciò che è necessario");
        System.out.println("  3. PROTEZIONE DATI: prevenire stati invalidi dell'oggetto");
        System.out.println("  4. VALIDAZIONE: controllare i dati prima di modificarli");
        System.out.println();

        // Esempio CATTIVO: classe senza incapsulamento
        System.out.println("ESEMPIO NEGATIVO - Classe senza incapsulamento:");
        System.out.println();

        BadBankAccount badAccount = new BadBankAccount();
        badAccount.balance = 1000.0; // Accesso diretto ai campi!
        System.out.println("  Saldo iniziale: €" + badAccount.balance);

        // Problema: possiamo mettere valori invalidi!
        badAccount.balance = -500.0; // ERRORE! Saldo negativo!
        System.out.println("  ❌ PROBLEMA: Saldo negativo impostato direttamente: €" + badAccount.balance);

        // Problema: non possiamo tracciare le modifiche
        badAccount.balance += 1000000; // Modifica sospetta!
        System.out.println("  ❌ PROBLEMA: Modifica non controllata: €" + badAccount.balance);
        System.out.println();

        // Esempio BUONO: classe con corretto incapsulamento
        System.out.println("ESEMPIO POSITIVO - Classe con corretto incapsulamento:");
        System.out.println();

        GoodBankAccount goodAccount = new GoodBankAccount("IT1234567890", 1000.0);
        System.out.println("  Conto creato: " + goodAccount.getAccountNumber());
        System.out.println("  Saldo iniziale: €" + goodAccount.getBalance());
        System.out.println();

        // Operazioni controllate
        System.out.println("  Operazione: deposito di €500");
        if (goodAccount.deposit(500.0)) {
            System.out.println("  ✓ Deposito riuscito. Nuovo saldo: €" + goodAccount.getBalance());
        }
        System.out.println();

        System.out.println("  Operazione: prelievo di €200");
        if (goodAccount.withdraw(200.0)) {
            System.out.println("  ✓ Prelievo riuscito. Nuovo saldo: €" + goodAccount.getBalance());
        }
        System.out.println();

        // Tentativo di operazione invalida
        System.out.println("  Tentativo: prelievo di €5000 (eccede il saldo)");
        if (!goodAccount.withdraw(5000.0)) {
            System.out.println("  ✓ Prelievo rifiutato. Saldo protetto: €" + goodAccount.getBalance());
        }
        System.out.println();

        // Tentativo di operazione invalida
        System.out.println("  Tentativo: deposito di €-100 (importo negativo)");
        if (!goodAccount.deposit(-100.0)) {
            System.out.println("  ✓ Deposito rifiutato. Dati validati correttamente.");
        }
        System.out.println();

        // Non possiamo modificare il numero di conto (immutabile)
        System.out.println("  Il numero di conto è IMMUTABILE (solo getter, nessun setter):");
        System.out.println("  ✓ Numero conto: " + goodAccount.getAccountNumber());
        System.out.println("  ✓ Non può essere modificato dopo la creazione");
        System.out.println();

        // Dimostrazione con esempio avanzato: validazione complessa
        System.out.println("ESEMPIO AVANZATO - Incapsulamento con validazione complessa:");
        System.out.println();

        CustomerAccount customer = new CustomerAccount("Mario Rossi", "mario.rossi@email.com");
        System.out.println("  Cliente: " + customer.getName());
        System.out.println("  Email: " + customer.getEmail());
        System.out.println();

        // Tentativo di impostare email invalida
        System.out.println("  Tentativo: impostare email invalida 'non_una_email'");
        if (!customer.setEmail("non_una_email")) {
            System.out.println("  ✓ Email rifiutata. Validazione funzionante.");
            System.out.println("  Email rimasta: " + customer.getEmail());
        }
        System.out.println();

        // Impostare email valida
        System.out.println("  Tentativo: impostare email valida 'mario.rossi@newemail.com'");
        if (customer.setEmail("mario.rossi@newemail.com")) {
            System.out.println("  ✓ Email aggiornata: " + customer.getEmail());
        }
        System.out.println();

        System.out.println("VANTAGGI DELL'INCAPSULAMENTO:");
        System.out.println("  ✓ PROTEZIONE: i dati non possono essere messi in stati invalidi");
        System.out.println("  ✓ VALIDAZIONE: ogni modifica viene controllata");
        System.out.println("  ✓ MANUTENIBILITÀ: possiamo cambiare l'implementazione interna senza impatto");
        System.out.println("  ✓ DEBUGGING: più facile tracciare dove e come i dati vengono modificati");
        System.out.println("  ✓ FLESSIBILITÀ: possiamo aggiungere logica (logging, notifiche) ai getter/setter");

        System.out.println();
    }

    /**
     * ESEMPIO NEGATIVO: classe senza incapsulamento
     * Problemi:
     * - Campi pubblici accessibili direttamente
     * - Nessuna validazione
     * - Dati possono essere messi in stati invalidi
     */
    static class BadBankAccount {
        public String accountNumber; // ❌ Campo pubblico!
        public double balance; // ❌ Campo pubblico!

        // Chiunque può modificare questi campi direttamente
        // senza alcun controllo!
    }

    /**
     * ESEMPIO POSITIVO: classe con corretto incapsulamento
     * Caratteristiche:
     * - Campi private
     * - Accesso controllato tramite getter/setter
     * - Validazione di tutti i dati
     * - Protezione dell'invariante (saldo non negativo)
     */
    static class GoodBankAccount {
        // Campi PRIVATE: accessibili solo all'interno della classe
        private final String accountNumber; // Immutabile (final)
        private double balance;

        /**
         * Costruttore con validazione
         */
        public GoodBankAccount(String accountNumber, double initialBalance) {
            // Validazione nel costruttore
            if (accountNumber == null || accountNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Il numero di conto non può essere vuoto");
            }
            if (initialBalance < 0) {
                throw new IllegalArgumentException("Il saldo iniziale non può essere negativo");
            }

            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        /**
         * GETTER per accountNumber
         * Solo lettura - nessun setter perché il campo è immutabile
         */
        public String getAccountNumber() {
            return accountNumber;
        }

        /**
         * GETTER per balance
         * Solo lettura - il saldo può essere modificato solo tramite deposit/withdraw
         */
        public double getBalance() {
            return balance;
        }

        /**
         * Metodo controllato per depositare denaro
         * Validazione: l'importo deve essere positivo
         */
        public boolean deposit(double amount) {
            if (amount <= 0) {
                System.out.println("    ❌ Errore: l'importo del deposito deve essere positivo");
                return false;
            }

            balance += amount;
            // Qui potremmo aggiungere logging, notifiche, etc.
            return true;
        }

        /**
         * Metodo controllato per prelevare denaro
         * Validazione: l'importo deve essere positivo e non eccedere il saldo
         */
        public boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("    ❌ Errore: l'importo del prelievo deve essere positivo");
                return false;
            }

            if (amount > balance) {
                System.out.println("    ❌ Errore: fondi insufficienti (saldo: €" + balance + ")");
                return false;
            }

            balance -= amount;
            // Qui potremmo aggiungere logging, notifiche, etc.
            return true;
        }
    }

    /**
     * ESEMPIO AVANZATO: incapsulamento con validazione complessa
     * Dimostra validazione di email e altre best practices
     */
    static class CustomerAccount {
        private String name;
        private String email;
        private final java.time.LocalDateTime createdAt; // Immutabile

        public CustomerAccount(String name, String email) {
            setName(name); // Usa il setter per validazione
            if (!setEmail(email)) { // Usa il setter per validazione
                throw new IllegalArgumentException("Email non valida");
            }
            this.createdAt = java.time.LocalDateTime.now();
        }

        public String getName() {
            return name;
        }

        /**
         * Setter con validazione per il nome
         */
        public void setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Il nome non può essere vuoto");
            }
            this.name = name.trim();
        }

        public String getEmail() {
            return email;
        }

        /**
         * Setter con validazione complessa per l'email
         * Ritorna true se la modifica è riuscita, false altrimenti
         */
        public boolean setEmail(String email) {
            if (email == null || !isValidEmail(email)) {
                System.out.println("    ❌ Errore: email non valida");
                return false;
            }
            this.email = email.toLowerCase().trim();
            return true;
        }

        /**
         * Metodo PRIVATE helper per la validazione
         * Information hiding: i dettagli della validazione sono nascosti
         */
        private boolean isValidEmail(String email) {
            // Validazione semplificata per esempio didattico
            return email.contains("@") && email.contains(".") && email.length() > 5;
        }

        /**
         * Getter per data di creazione - solo lettura, nessun setter
         */
        public java.time.LocalDateTime getCreatedAt() {
            return createdAt; // LocalDateTime è immutabile, quindi sicuro da restituire
        }
    }

    // ========================================================================
    // 5. DIMOSTRAZIONE POLIMORFISMO
    // ========================================================================

    private static void demonstratePolymorphism() {
        printSection("5. Polimorfismo");

        System.out.println("Il polimorfismo permette di trattare oggetti di classi diverse");
        System.out.println("attraverso un'interfaccia o superclasse comune.");
        System.out.println();

        // Array di Shape che contiene oggetti di diverse sottoclassi
        Shape[] shapes = {
                new Circle(3.0),
                new Rectangle(4.0, 5.0),
                new Circle(7.0),
                new Rectangle(2.0, 8.0)
        };

        // POLIMORFISMO: lo stesso metodo si comporta diversamente
        // in base al tipo effettivo dell'oggetto
        System.out.println("Elaborazione polimorfica di diverse forme:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("\n  Forma " + (i + 1) + ":");
            shapes[i].displayInfo();

            // Il metodo calculateArea() viene chiamato sulla superclasse Shape,
            // ma l'implementazione eseguita dipende dal tipo concreto dell'oggetto
        }

        System.out.println();
    }

    // ========================================================================
    // 6. DIMOSTRAZIONE RECORD (Java 14+)
    // ========================================================================

    private static void demonstrateRecords() {
        printSection("7. Record (Java 14+)");

        System.out.println("I Record sono classi immutabili per contenere dati:");
        System.out.println("  - Tutti i campi sono final");
        System.out.println("  - Generano automaticamente: constructor, getters, equals(), hashCode(), toString()");
        System.out.println("  - Sintassi compatta e concisa");
        System.out.println("  - Ideali per DTO (Data Transfer Objects)");
        System.out.println();

        // Creazione di record
        Point point1 = new Point(10, 20);
        Point point2 = new Point(10, 20);
        Point point3 = new Point(15, 25);

        // I getters sono automatici e seguono il pattern del nome del campo (non get*)
        System.out.println("  Point 1: x=" + point1.x() + ", y=" + point1.y());

        // toString() generato automaticamente
        System.out.println("  Point 1 toString: " + point1);

        // equals() generato automaticamente (confronto basato sui valori)
        System.out.println("  Point 1 equals Point 2: " + point1.equals(point2)); // true
        System.out.println("  Point 1 equals Point 3: " + point1.equals(point3)); // false

        // hashCode() coerente con equals()
        System.out.println("  Point 1 hashCode: " + point1.hashCode());
        System.out.println("  Point 2 hashCode: " + point2.hashCode()); // Stesso hashCode di point1

        // Record con metodi custom
        Employee emp = new Employee("Alice", "Sviluppatrice", 50000);
        System.out.println("\n  " + emp);
        System.out.println("  Descrizione: " + emp.getDescription());

        // Record compatto con validazione
        try {
            ValidatedPerson person = new ValidatedPerson("Bob", -5); // Età negativa
        } catch (IllegalArgumentException e) {
            System.out.println("  Validazione fallita: " + e.getMessage());
        }

        ValidatedPerson validPerson = new ValidatedPerson("Charlie", 30);
        System.out.println("  Persona validata: " + validPerson);

        System.out.println();
    }

    /**
     * Record semplice con due campi
     * Il compilatore genera automaticamente:
     * - Costruttore: public Point(int x, int y)
     * - Getters: public int x() e public int y()
     * - equals(), hashCode(), toString()
     */
    record Point(int x, int y) {
        // Il corpo del record può essere vuoto per casi semplici
        // I campi sono automaticamente private final
    }

    /**
     * Record con metodi custom
     * Possiamo aggiungere metodi instance oltre a quelli generati automaticamente
     */
    record Employee(String name, String role, double salary) {
        // Metodo custom
        public String getDescription() {
            return name + " lavora come " + role + " con uno stipendio di €" + salary;
        }

        // Possiamo anche fare override dei metodi generati
        @Override
        public String toString() {
            return "Employee[" + name + ", " + role + "]";
        }
    }

    /**
     * Record con costruttore compatto per validazione
     * Il costruttore compatto permette di validare o normalizzare i dati
     * prima che vengano assegnati ai campi
     */
    record ValidatedPerson(String name, int age) {
        // COMPACT CONSTRUCTOR: non ha lista di parametri
        // Viene eseguito prima dell'assegnazione automatica ai campi
        public ValidatedPerson {
            // Validazione dei dati
            if (age < 0) {
                throw new IllegalArgumentException("L'età non può essere negativa");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Il nome non può essere vuoto");
            }
            // Normalizzazione
            name = name.trim();
            // Non serve assegnare i campi, viene fatto automaticamente
        }
    }

    // ========================================================================
    // 8. DIMOSTRAZIONE SEALED CLASSES (Java 17+)
    // ========================================================================

    private static void demonstrateSealedClasses() {
        printSection("8. Sealed Classes (Java 17+)");

        System.out.println("Le Sealed Classes permettono un controllo preciso sull'ereditarietà:");
        System.out.println("  - Definiscono esplicitamente quali classi possono estenderle");
        System.out.println("  - Garantiscono che la gerarchia sia chiusa e nota");
        System.out.println("  - Migliorano la type safety e l'exhaustiveness checking");
        System.out.println();

        // Creazione di istanze delle sottoclassi permesse
        Vehicle car = new Car("Toyota", 4);
        Vehicle motorcycle = new Motorcycle("Ducati", true);
        Vehicle truck = new Truck("Volvo", 18000);

        // Utilizzo del polimorfismo
        processVehicle(car);
        processVehicle(motorcycle);
        processVehicle(truck);

        System.out.println();
    }

    /**
     * SEALED CLASS: definisce esplicitamente chi può estenderla
     * La keyword 'permits' elenca tutte le sottoclassi permesse
     * 
     * Benefici:
     * - La gerarchia è completamente nota al compile-time
     * - Aiuta con pattern matching exhaustive
     * - Migliora la manutenibilità del codice
     */
    sealed abstract static class Vehicle permits Car, Motorcycle, Truck {
        protected String brand;

        public Vehicle(String brand) {
            this.brand = brand;
        }

        public abstract void displayInfo();
    }

    /**
     * Sottoclasse FINAL: non può essere ulteriormente estesa
     * Questa è una delle opzioni per le classi permesse
     */
    static final class Car extends Vehicle {
        private int doors;

        public Car(String brand, int doors) {
            super(brand);
            this.doors = doors;
        }

        @Override
        public void displayInfo() {
            System.out.println("  Auto: " + brand + " con " + doors + " porte");
        }
    }

    /**
     * Sottoclasse SEALED: può essere estesa, ma solo dalle classi che permette
     * (In questo esempio è final per semplicità, ma potrebbe essere sealed)
     */
    static final class Motorcycle extends Vehicle {
        private boolean hasSidecar;

        public Motorcycle(String brand, boolean hasSidecar) {
            super(brand);
            this.hasSidecar = hasSidecar;
        }

        @Override
        public void displayInfo() {
            System.out.println("  Moto: " + brand + (hasSidecar ? " con sidecar" : " senza sidecar"));
        }
    }

    /**
     * Sottoclasse NON-SEALED: può essere estesa da chiunque
     * Rompe la sealed hierarchy per questo ramo
     */
    static non-sealed class Truck extends Vehicle {
        private int cargoCapacity;

        public Truck(String brand, int cargoCapacity) {
            super(brand);
            this.cargoCapacity = cargoCapacity;
        }

        @Override
        public void displayInfo() {
            System.out.println("  Camion: " + brand + " con capacità di " + cargoCapacity + " kg");
        }
    }

    /**
     * Metodo che processa veicoli
     * Grazie alle sealed classes, il compilatore sa esattamente quali tipi sono
     * possibili
     */
    private static void processVehicle(Vehicle vehicle) {
        vehicle.displayInfo();
    }

    // ========================================================================
    // 9. DIMOSTRAZIONE PATTERN MATCHING (Java 21)
    // ========================================================================

    private static void demonstratePatternMatching() {
        printSection("9. Pattern Matching (Java 16+ / Java 21)");

        System.out.println("Pattern Matching migliora la leggibilità e sicurezza del codice:");
        System.out.println();

        // 8a. Pattern Matching per instanceof (Java 16+)
        demonstrateInstanceofPatternMatching();

        // 8b. Pattern Matching per switch (Java 21)
        demonstrateSwitchPatternMatching();

        System.out.println();
    }

    /**
     * Dimostrazione Pattern Matching per instanceof
     */
    private static void demonstrateInstanceofPatternMatching() {
        System.out.println("9a. Pattern Matching per instanceof:");
        System.out.println();

        Object obj1 = "Hello World";
        Object obj2 = 12345;
        Object obj3 = new Point(5, 10);

        processObject(obj1);
        processObject(obj2);
        processObject(obj3);

        System.out.println();
    }

    /**
     * Pattern Matching per instanceof elimina il cast esplicito
     */
    private static void processObject(Object obj) {
        // VECCHIO MODO (prima di Java 16):
        // if (obj instanceof String) {
        // String str = (String) obj; // Cast esplicito necessario
        // System.out.println("Stringa di lunghezza: " + str.length());
        // }

        // NUOVO MODO (Java 16+ con Pattern Matching):
        // La variabile 'str' viene automaticamente creata e castata
        if (obj instanceof String str) {
            System.out.println("  Stringa: '" + str + "' (lunghezza: " + str.length() + ")");
        } else if (obj instanceof Integer num) {
            System.out.println("  Numero intero: " + num + " (doppio: " + (num * 2) + ")");
        } else if (obj instanceof Point point) {
            System.out.println("  Point: " + point + " (distanza dall'origine: " +
                    Math.sqrt(point.x() * point.x() + point.y() * point.y()) + ")");
        } else {
            System.out.println("  Tipo sconosciuto: " + obj.getClass().getName());
        }
    }

    /**
     * Dimostrazione Pattern Matching per switch (Java 21)
     */
    private static void demonstrateSwitchPatternMatching() {
        System.out.println("10b. Pattern Matching per switch (Java 21):");
        System.out.println();

        Object[] objects = {
                "Test",
                42,
                3.14,
                new Point(3, 4),
                new Circle(5.0),
                null
        };

        for (Object obj : objects) {
            String description = describeObject(obj);
            System.out.println("  " + description);
        }
    }

    /**
     * Pattern Matching per switch con Java 21
     * Caratteristiche:
     * - Pattern matching con type patterns
     * - Guarded patterns (when clauses)
     * - Null handling
     * - Exhaustiveness checking per sealed types
     */
    private static String describeObject(Object obj) {
        // Switch expression con pattern matching (Java 21)
        return switch (obj) {
            // Null pattern (Java 21)
            case null -> "Valore nullo";

            // Type pattern semplice
            case String s -> "Stringa: '" + s + "' (lunghezza " + s.length() + ")";

            // Guarded pattern: pattern con condizione aggiuntiva
            case Integer i when i > 0 -> "Intero positivo: " + i;
            case Integer i when i < 0 -> "Intero negativo: " + i;
            case Integer i -> "Zero";

            // Type pattern con ulteriore elaborazione
            case Double d -> String.format("Numero decimale: %.2f", d);

            // Pattern matching con record
            case Point(int x, int y) when x == 0 && y == 0 ->
                "Punto nell'origine";
            case Point(int x, int y) when x == y ->
                "Punto sulla diagonale: (" + x + ", " + y + ")";
            case Point point ->
                "Punto generico: " + point;

            // Pattern per classi custom
            case Circle c ->
                String.format("Cerchio con raggio %.2f (area: %.2f)",
                        ((Circle) c).calculateArea() / Math.PI, c.calculateArea());

            // Default case per qualsiasi altro tipo
            default -> "Oggetto di tipo: " + obj.getClass().getSimpleName();
        };
    }

    // ========================================================================
    // 10. DIMOSTRAZIONE BEST PRACTICES
    // ========================================================================

    private static void demonstrateBestPractices() {
        printSection("10. Best Practices nella Programmazione OOP");

        System.out.println("Le best practices sono linee guida fondamentali per scrivere");
        System.out.println("codice di qualità, manutenibile e robusto.");
        System.out.println();

        // 10a. Principi SOLID
        demonstrateSOLIDPrinciples();

        // 10b. Composition over Inheritance
        demonstrateCompositionOverInheritance();

        // 10c. Immutabilità e Thread Safety
        demonstrateImmutability();

        // 10d. Defensive Programming
        demonstrateDefensiveProgramming();

        // 10e. Naming Conventions e Code Organization
        demonstrateNamingConventions();

        System.out.println();
    }

    /**
     * Dimostrazione dei principi SOLID
     */
    private static void demonstrateSOLIDPrinciples() {
        System.out.println("10a. Principi SOLID:");
        System.out.println();

        System.out.println("  S - Single Responsibility Principle (SRP)");
        System.out.println("      Ogni classe dovrebbe avere una sola responsabilità");
        System.out.println();

        // Esempio CATTIVO: classe con troppe responsabilità
        BadEmployee badEmp = new BadEmployee("Mario", 50000);
        badEmp.calculateSalary();
        badEmp.saveToDatabase();
        badEmp.generateReport();
        System.out.println("      ❌ BadEmployee ha 3 responsabilità: calcolo, persistenza, reporting");
        System.out.println();

        // Esempio BUONO: responsabilità separate
        GoodEmployee goodEmp = new GoodEmployee("Luigi", 50000);
        EmployeeSalaryCalculator calculator = new EmployeeSalaryCalculator();
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeReportGenerator reportGen = new EmployeeReportGenerator();

        calculator.calculate(goodEmp);
        repository.save(goodEmp);
        reportGen.generate(goodEmp);
        System.out.println("      ✓ Ogni classe ha una sola responsabilità ben definita");
        System.out.println();

        System.out.println("  O - Open/Closed Principle (OCP)");
        System.out.println("      Le classi dovrebbero essere aperte all'estensione ma chiuse alle modifiche");
        System.out.println();

        // Esempio: sistema di sconto estensibile
        DiscountCalculator discCalc = new DiscountCalculator();
        Product product = new Product("Laptop", 1000.0);

        Discount seasonalDiscount = new SeasonalDiscount(10);
        Discount loyaltyDiscount = new LoyaltyDiscount(5);

        System.out.println("      Prezzo originale: €" + product.getPrice());
        System.out.println("      Con sconto stagionale: €" + discCalc.apply(product, seasonalDiscount));
        System.out.println("      Con sconto fedeltà: €" + discCalc.apply(product, loyaltyDiscount));
        System.out.println("      ✓ Possiamo aggiungere nuovi tipi di sconto senza modificare DiscountCalculator");
        System.out.println();

        System.out.println("  L - Liskov Substitution Principle (LSP)");
        System.out.println("      Le sottoclassi devono essere sostituibili alle loro superclassi");
        System.out.println();

        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        System.out.println("      Passero:");
        sparrow.move();
        System.out.println("      Pinguino:");
        penguin.move();
        System.out.println("      ✓ Entrambi possono sostituire Bird, ma con comportamenti appropriati");
        System.out.println();

        System.out.println("  I - Interface Segregation Principle (ISP)");
        System.out.println("      I client non dovrebbero dipendere da interfacce che non usano");
        System.out.println();

        SimplePrinter simplePrinter = new SimplePrinter();
        MultiFunctionDevice mfd = new MultiFunctionDevice();

        simplePrinter.print("Documento");
        System.out.println("      ✓ SimplePrinter implementa solo Printable, non metodi che non usa");

        mfd.print("Documento");
        mfd.scan("Documento");
        mfd.fax("Documento");
        System.out.println("      ✓ MultiFunctionDevice implementa tutte le interfacce di cui ha bisogno");
        System.out.println();

        System.out.println("  D - Dependency Inversion Principle (DIP)");
        System.out.println("      Dipendere da abstractions, non da implementazioni concrete");
        System.out.println();

        // CATTIVO: dipende da implementazione concreta
        BadNotificationService badService = new BadNotificationService();
        badService.sendNotification("Messaggio");
        System.out.println("      ❌ BadNotificationService dipende direttamente da EmailSender");
        System.out.println();

        // BUONO: dipende da astrazione
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SMSSender();

        GoodNotificationService goodEmailService = new GoodNotificationService(emailSender);
        GoodNotificationService goodSmsService = new GoodNotificationService(smsSender);

        goodEmailService.sendNotification("Messaggio");
        goodSmsService.sendNotification("Messaggio");
        System.out.println("      ✓ GoodNotificationService dipende dall'interfaccia MessageSender");
        System.out.println();
    }

    // ========== CLASSI PER SOLID - SRP ==========

    // CATTIVO: troppe responsabilità
    static class BadEmployee {
        private String name;
        private double salary;

        public BadEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public void calculateSalary() {
            // Logica di calcolo stipendio
            System.out.println("      Calcolo stipendio per " + name);
        }

        public void saveToDatabase() {
            // Logica di persistenza
            System.out.println("      Salvataggio di " + name + " nel database");
        }

        public void generateReport() {
            // Logica di reporting
            System.out.println("      Generazione report per " + name);
        }
    }

    // BUONO: responsabilità separate
    static class GoodEmployee {
        private final String name;
        private final double salary;

        public GoodEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }
    }

    static class EmployeeSalaryCalculator {
        public void calculate(GoodEmployee emp) {
            System.out.println("      Calcolo stipendio per " + emp.getName());
        }
    }

    static class EmployeeRepository {
        public void save(GoodEmployee emp) {
            System.out.println("      Salvataggio di " + emp.getName() + " nel database");
        }
    }

    static class EmployeeReportGenerator {
        public void generate(GoodEmployee emp) {
            System.out.println("      Generazione report per " + emp.getName());
        }
    }

    // ========== CLASSI PER SOLID - OCP ==========

    static class Product {
        private final String name;
        private final double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    // Astrazione per gli sconti
    interface Discount {
        double apply(double price);
    }

    static class SeasonalDiscount implements Discount {
        private final double percentage;

        public SeasonalDiscount(double percentage) {
            this.percentage = percentage;
        }

        @Override
        public double apply(double price) {
            return price * (1 - percentage / 100);
        }
    }

    static class LoyaltyDiscount implements Discount {
        private final double percentage;

        public LoyaltyDiscount(double percentage) {
            this.percentage = percentage;
        }

        @Override
        public double apply(double price) {
            return price * (1 - percentage / 100);
        }
    }

    static class DiscountCalculator {
        public double apply(Product product, Discount discount) {
            return discount.apply(product.getPrice());
        }
    }

    // ========== CLASSI PER SOLID - LSP ==========

    abstract static class Bird {
        public abstract void move();
    }

    static class Sparrow extends Bird {
        @Override
        public void move() {
            System.out.println("        Volando nel cielo...");
        }
    }

    static class Penguin extends Bird {
        @Override
        public void move() {
            // I pinguini non volano, ma si muovono nuotando
            System.out.println("        Nuotando nell'acqua...");
        }
    }

    // ========== CLASSI PER SOLID - ISP ==========

    interface Printable {
        void print(String document);
    }

    interface Scannable {
        void scan(String document);
    }

    interface Faxable {
        void fax(String document);
    }

    static class SimplePrinter implements Printable {
        @Override
        public void print(String document) {
            System.out.println("      Stampa: " + document);
        }
    }

    static class MultiFunctionDevice implements Printable, Scannable, Faxable {
        @Override
        public void print(String document) {
            System.out.println("      MFD Stampa: " + document);
        }

        @Override
        public void scan(String document) {
            System.out.println("      MFD Scansione: " + document);
        }

        @Override
        public void fax(String document) {
            System.out.println("      MFD Fax: " + document);
        }
    }

    // ========== CLASSI PER SOLID - DIP ==========

    // CATTIVO: dipende da implementazione concreta
    static class BadNotificationService {
        private final EmailSender emailSender = new EmailSender();

        public void sendNotification(String message) {
            emailSender.sendEmail(message);
        }
    }

    // BUONO: dipende da astrazione
    interface MessageSender {
        void send(String message);
    }

    static class EmailSender implements MessageSender {
        @Override
        public void send(String message) {
            System.out.println("      Email inviata: " + message);
        }

        public void sendEmail(String message) {
            send(message);
        }
    }

    static class SMSSender implements MessageSender {
        @Override
        public void send(String message) {
            System.out.println("      SMS inviato: " + message);
        }
    }

    static class GoodNotificationService {
        private final MessageSender sender;

        // Dependency Injection: dipende da astrazione
        public GoodNotificationService(MessageSender sender) {
            this.sender = sender;
        }

        public void sendNotification(String message) {
            sender.send(message);
        }
    }

    /**
     * Dimostrazione di Composition over Inheritance
     */
    private static void demonstrateCompositionOverInheritance() {
        System.out.println("10b. Composition over Inheritance:");
        System.out.println();
        System.out.println("  Preferire la composizione all'ereditarietà quando possibile.");
        System.out.println("  L'ereditarietà crea un accoppiamento forte (tight coupling).");
        System.out.println("  La composizione offre maggiore flessibilità.");
        System.out.println();

        // CATTIVO: ereditarietà rigida
        System.out.println("  ❌ Con ereditarietà (rigido):");
        BadFlyingCar flyingCar = new BadFlyingCar();
        flyingCar.drive();
        flyingCar.fly();
        System.out.println("      Problema: se vogliamo un'auto che non vola, dobbiamo creare un'altra gerarchia");
        System.out.println();

        // BUONO: composizione flessibile
        System.out.println("  ✓ Con composizione (flessibile):");
        Engine engine = new Engine();
        Wings wings = new Wings();

        ModernCar normalCar = new ModernCar(engine, null);
        ModernCar flyingModernCar = new ModernCar(engine, wings);

        normalCar.operate();
        flyingModernCar.operate();
        System.out.println("      Vantaggio: possiamo combinare funzionalità dinamicamente");
        System.out.println();
    }

    // ========== CLASSI PER COMPOSITION VS INHERITANCE ==========

    // CATTIVO: ereditarietà
    static class BadVehicle {
        public void drive() {
            System.out.println("      Guida su strada");
        }
    }

    static class BadFlyingVehicle extends BadVehicle {
        public void fly() {
            System.out.println("      Vola in cielo");
        }
    }

    static class BadFlyingCar extends BadFlyingVehicle {
        // Ereditiamo tutto, anche ciò che potremmo non volere
    }

    // BUONO: composizione
    static class Engine {
        public void start() {
            System.out.println("      Motore avviato");
        }
    }

    static class Wings {
        public void extend() {
            System.out.println("      Ali estese per il volo");
        }
    }

    static class ModernCar {
        private final Engine engine;
        private final Wings wings; // Può essere null

        public ModernCar(Engine engine, Wings wings) {
            this.engine = engine;
            this.wings = wings;
        }

        public void operate() {
            engine.start();
            if (wings != null) {
                wings.extend();
                System.out.println("      Auto volante in azione!");
            } else {
                System.out.println("      Auto normale in azione");
            }
        }
    }

    /**
     * Dimostrazione di Immutabilità e Thread Safety
     */
    private static void demonstrateImmutability() {
        System.out.println("9c. Immutabilità e Thread Safety:");
        System.out.println();
        System.out.println("  Gli oggetti immutabili sono:");
        System.out.println("    - Thread-safe per natura (nessun synchronization necessario)");
        System.out.println("    - Più sicuri (non possono essere modificati accidentalmente)");
        System.out.println("    - Più facili da ragionare e debuggare");
        System.out.println();

        // Classe mutabile (CATTIVO per thread safety)
        MutablePoint mutablePoint = new MutablePoint(10, 20);
        System.out.println("  ❌ Oggetto mutabile: " + mutablePoint);
        mutablePoint.setX(30);
        System.out.println("      Dopo modifica: " + mutablePoint);
        System.out.println("      Problema: non è thread-safe, può causare race conditions");
        System.out.println();

        // Classe immutabile (BUONO)
        ImmutablePoint immutablePoint = new ImmutablePoint(10, 20);
        System.out.println("  ✓ Oggetto immutabile: " + immutablePoint);
        ImmutablePoint newPoint = immutablePoint.withX(30);
        System.out.println("      Dopo 'modifica': " + newPoint);
        System.out.println("      Originale invariato: " + immutablePoint);
        System.out.println("      Vantaggio: thread-safe, nessuna sincronizzazione necessaria");
        System.out.println();

        // I Record sono immutabili per default
        System.out.println("  ✓ I Record sono immutabili per design:");
        Point recordPoint = new Point(10, 20);
        System.out.println("      Record Point: " + recordPoint);
        System.out.println("      Tutti i campi sono automaticamente final");
        System.out.println();
    }

    // ========== CLASSI PER IMMUTABILITY ==========

    // CATTIVO: mutabile
    static class MutablePoint {
        private int x;
        private int y;

        public MutablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "MutablePoint(" + x + ", " + y + ")";
        }
    }

    // BUONO: immutabile
    static final class ImmutablePoint {
        private final int x;
        private final int y;

        public ImmutablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        // Invece di setter, metodi che restituiscono nuove istanze
        public ImmutablePoint withX(int newX) {
            return new ImmutablePoint(newX, this.y);
        }

        public ImmutablePoint withY(int newY) {
            return new ImmutablePoint(this.x, newY);
        }

        @Override
        public String toString() {
            return "ImmutablePoint(" + x + ", " + y + ")";
        }
    }

    /**
     * Dimostrazione di Defensive Programming
     */
    private static void demonstrateDefensiveProgramming() {
        System.out.println("10d. Defensive Programming:");
        System.out.println();
        System.out.println("  Validare sempre gli input e proteggere lo stato interno.");
        System.out.println();

        // Validazione degli input
        System.out.println("  ✓ Validazione degli input:");
        try {
            BankAccount account1 = new BankAccount("IT12345", -100);
        } catch (IllegalArgumentException e) {
            System.out.println("      Errore catturato: " + e.getMessage());
        }

        BankAccount account = new BankAccount("IT12345", 1000);
        System.out.println("      Account creato: " + account);
        System.out.println();

        // Copia difensiva
        System.out.println("  ✓ Copia difensiva per proteggere lo stato:");
        String[] initialTags = { "Java", "Programming" };
        BlogPost post = new BlogPost("Titolo", initialTags);

        System.out.println("      Post creato con tags: " + String.join(", ", post.getTags()));

        // Modifichiamo l'array originale
        initialTags[0] = "HACKERATO";
        System.out.println("      Array originale modificato, ma post protetto: " +
                String.join(", ", post.getTags()));

        // Modifichiamo l'array restituito
        String[] retrievedTags = post.getTags();
        retrievedTags[0] = "TENTATIVO HACK";
        System.out.println("      Array restituito modificato, ma post ancora protetto: " +
                String.join(", ", post.getTags()));
        System.out.println();

        // Null safety
        System.out.println("  ✓ Null safety:");
        UserProfile profile1 = new UserProfile("Alice", null);
        System.out.println("      " + profile1.getDisplayName());

        UserProfile profile2 = new UserProfile("Bob", "Bobby");
        System.out.println("      " + profile2.getDisplayName());
        System.out.println();
    }

    // ========== CLASSI PER DEFENSIVE PROGRAMMING ==========

    static class BankAccount {
        private final String accountNumber;
        private final double balance;

        public BankAccount(String accountNumber, double balance) {
            // Validazione degli input
            if (accountNumber == null || accountNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Il numero di conto non può essere vuoto");
            }
            if (balance < 0) {
                throw new IllegalArgumentException("Il saldo non può essere negativo");
            }

            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "BankAccount{number='" + accountNumber + "', balance=" + balance + "}";
        }
    }

    static class BlogPost {
        private final String title;
        private final String[] tags;

        public BlogPost(String title, String[] tags) {
            this.title = title;
            // COPIA DIFENSIVA: creiamo una copia dell'array invece di salvare il
            // riferimento
            this.tags = tags != null ? tags.clone() : new String[0];
        }

        public String[] getTags() {
            // COPIA DIFENSIVA: restituiamo una copia, non il riferimento interno
            return tags.clone();
        }
    }

    static class UserProfile {
        private final String username;
        private final String nickname;

        public UserProfile(String username, String nickname) {
            this.username = username;
            this.nickname = nickname;
        }

        public String getDisplayName() {
            // Null safety: usa valore di default se nickname è null
            return nickname != null ? nickname : username;
        }
    }

    /**
     * Dimostrazione di Naming Conventions e Code Organization
     */
    private static void demonstrateNamingConventions() {
        System.out.println("10e. Naming Conventions e Code Organization:");
        System.out.println();
        System.out.println("  Convenzioni di Naming in Java:");
        System.out.println();

        System.out.println("  ✓ Classi e Interfacce: PascalCase (es. BankAccount, MessageSender)");
        System.out.println("  ✓ Metodi e Variabili: camelCase (es. calculateTotal, userName)");
        System.out.println("  ✓ Costanti: UPPER_SNAKE_CASE (es. MAX_SIZE, DEFAULT_TIMEOUT)");
        System.out.println("  ✓ Package: lowercase (es. com.corso.demo)");
        System.out.println();

        System.out.println("  Nomi descrittivi e autoesplicativi:");
        System.out.println();

        // CATTIVO
        int d = 30; // Cosa rappresenta 'd'?
        System.out.println("      ❌ int d = 30;  // Non chiaro!");

        // BUONO
        int daysInMonth = 30;
        System.out.println("      ✓ int daysInMonth = 30;  // Autoesplicativo!");
        System.out.println();

        // CATTIVO
        System.out.println("      ❌ void process(String s) { ... }  // Generico!");

        // BUONO
        System.out.println("      ✓ void processCustomerOrder(String orderId) { ... }  // Specifico!");
        System.out.println();

        System.out.println("  Organizzazione del codice:");
        System.out.println();
        System.out.println("  ✓ Raggruppare membri per tipo e visibilità:");
        System.out.println("      1. Campi static (public → private)");
        System.out.println("      2. Campi instance (public → private)");
        System.out.println("      3. Costruttori");
        System.out.println("      4. Metodi (public → protected → private)");
        System.out.println("      5. Classi interne");
        System.out.println();

        System.out.println("  ✓ Mantenere le classi coese e focalizzate (SRP)");
        System.out.println("  ✓ Limitare la lunghezza dei metodi (idealmente < 20 linee)");
        System.out.println("  ✓ Usare nomi di metodo che descrivano l'azione (getUser, calculateTotal, isValid)");
        System.out.println();
    }

    // ========================================================================
    // UTILITY METHODS PER LA FORMATTAZIONE OUTPUT
    // ========================================================================

    private static void printHeader(String title) {
        String border = "═".repeat(80);
        System.out.println("\n" + border);
        System.out.println("  " + title);
        System.out.println(border + "\n");
    }

    private static void printSection(String title) {
        String border = "─".repeat(80);
        System.out.println(border);
        System.out.println("  " + title);
        System.out.println(border);
        System.out.println();
    }

    private static void printFooter() {
        String border = "═".repeat(80);
        System.out.println(border);
        System.out.println("  Fine della dimostrazione");
        System.out.println(border + "\n");
    }
}
