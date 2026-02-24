# ClassDemo - Utilizzo Avanzato delle Classi in Java 21

## Panoramica

`ClassDemo` è una classe dimostrativa completa che illustra tutti gli aspetti fondamentali e avanzati delle classi in Java 21. Questa demo è progettata come strumento di apprendimento pratico per comprendere in dettaglio come funzionano le classi in Java.

## Argomenti Trattati

### 0. **Introduzione alle Classi in Java**

Questa sezione fornisce le basi fondamentali per comprendere cosa sono le classi e gli oggetti in Java.

#### Concetti Fondamentali

**Cos'è una CLASSE?**

Una classe è un **blueprint** (progetto/modello) per creare oggetti. Definisce:
- **Attributi** (dati/campi): le caratteristiche dell'oggetto
- **Metodi** (comportamenti): le azioni che l'oggetto può eseguire

**Cos'è un OGGETTO?**

Un oggetto è un'**istanza concreta** di una classe. Se la classe è il "progetto di una casa", l'oggetto è la "casa effettiva" costruita seguendo quel progetto.

**Analogia con il mondo reale:**
- CLASSE `Auto` → Progetto generico di un'automobile
- OGGETTO `miaFiat` → Una Fiat Panda rossa specifica
- OGGETTO `tuaToyota` → Una Toyota Yaris blu specifica

Stessa classe (Auto), ma oggetti diversi con caratteristiche diverse!

#### I 4 Pilastri dell'OOP

La Programmazione Orientata agli Oggetti si basa su quattro principi fondamentali:

1. **ENCAPSULATION (Incapsulamento)**
   - Nascondere i dettagli interni ed esporre solo ciò che è necessario
   - Esempio: campi `private` con getter/setter `public`

2. **INHERITANCE (Ereditarietà)**
   - Una classe può ereditare caratteristiche da un'altra classe
   - Esempio: `Dog extends Animal` (Dog eredita da Animal)

3. **POLYMORPHISM (Polimorfismo)**
   - Oggetti di classi diverse possono essere trattati tramite un'interfaccia comune
   - Esempio: `Animal a = new Dog(); a.makeSound();` chiama il metodo di Dog

4. **ABSTRACTION (Astrazione)**
   - Definire interfacce e contratti senza specificare i dettagli implementativi
   - Esempio: classi astratte e interfacce

#### Vantaggi delle Classi

- ✓ **RIUSABILITÀ**: scrivi una volta, usa molte volte
- ✓ **ORGANIZZAZIONE**: codice strutturato e modulare
- ✓ **MANUTENIBILITÀ**: più facile da modificare e debuggare
- ✓ **ASTRAZIONE**: modellare concetti del mondo reale
- ✓ **COLLABORAZIONE**: più sviluppatori possono lavorare su classi diverse

#### Esempio Pratico: Classe Dog

```java
class Dog {
    String name;      // Attributo: nome del cane
    int age;          // Attributo: età del cane
    
    void bark() {     // Metodo: comportamento
        System.out.println(name + " fa: Bau Bau!");
    }
}

// Creazione di oggetti
Dog rex = new Dog("Rex", 5);    // Primo oggetto
Dog fido = new Dog("Fido", 3);  // Secondo oggetto

// Utilizzo
rex.bark();   // Output: Rex fa: Bau Bau!
fido.bark();  // Output: Fido fa: Bau Bau!
```

Ogni oggetto ha i suoi dati, ma condivide il comportamento (metodi) definito dalla classe.

---

### 1. **Classi Base e Costruttori**

#### Concetti Dimostrati:
- **Campi Instance vs Static**: differenza tra variabili di istanza (ogni oggetto ha la propria copia) e variabili statiche (condivise tra tutte le istanze)
- **Constructor Overloading**: possibilità di avere più costruttori con diverse signature
- **Constructor Chaining**: un costruttore che chiama un altro costruttore della stessa classe usando `this()`
- **Metodi Instance vs Static**: metodi che operano su oggetti specifici vs metodi che appartengono alla classe
- **Override di `toString()`**: personalizzazione della rappresentazione testuale di un oggetto

#### Classe di Esempio: `Person`
Dimostra la creazione di una classe completa con:
- Campi privati per l'encapsulation
- Contatore statico per tracciare il numero totale di istanze
- Tre costruttori con overloading e chaining
- Getter e setter per l'accesso controllato ai dati
- Metodi utility instance e static

---

### 2. **Modificatori di Accesso**

#### Quattro Livelli di Accesso:
- **`public`**: accessibile da qualsiasi classe in qualsiasi package
- **`protected`**: accessibile dalla stessa classe, stesso package e sottoclassi
- **package-private** (default, senza modificatore): accessibile solo dallo stesso package
- **`private`**: accessibile solo dalla stessa classe

#### Classe di Esempio: `AccessModifiersExample`
Mostra come i diversi modificatori di accesso influenzano la visibilità di campi e metodi.

---

### 3. **Classi Interne (Nested Classes)**

Le classi interne permettono di organizzare logicamente le classi e controllare l'incapsulamento.

#### 3a. Static Nested Class
- Non ha accesso ai membri instance della classe esterna
- Può accedere solo ai membri static
- Utile per classi helper logicamente correlate

#### 3b. Inner Class (Non-static Member Class)
- Ha accesso completo a tutti i membri della classe esterna (anche private)
- Richiede un'istanza della classe esterna per essere creata
- Mantiene un riferimento implicito all'oggetto esterno

#### 3c. Local Class
- Definita all'interno di un metodo
- Ha accesso ai membri della classe esterna e alle variabili locali (se final o effectively final)
- Utile per logica specifica che richiede una classe

#### 3d. Anonymous Class
- Classe senza nome definita e istanziata inline
- Estende una classe o implementa un'interfaccia
- Ideale per implementazioni one-time (es. event handlers)

#### Classe di Esempio: `OuterClass`
Contiene esempi di tutti e quattro i tipi di classi interne.

---

### 4. **Classi Astratte ed Ereditarietà**

#### Caratteristiche delle Classi Astratte:
- Non possono essere istanziate direttamente
- Possono contenere metodi astratti (senza implementazione) e concreti (con implementazione)
- Le sottoclassi devono implementare tutti i metodi astratti
- Definiscono un "contratto" che le sottoclassi devono rispettare

#### Gerarchia di Esempio: `Shape` → `Circle`, `Rectangle`
- `Shape`: classe astratta base con metodi astratti `calculateArea()` e `calculatePerimeter()`
- `Circle` e `Rectangle`: implementazioni concrete che forniscono i calcoli specifici
- Dimostrazione di `super()` per chiamare il costruttore della superclasse
- Override di metodi concreti

---

### 4.5. **Incapsulamento (Encapsulation)**

L'incapsulamento è uno dei 4 pilastri fondamentali della Programmazione Orientata agli Oggetti (OOP).

#### Principi Chiave:

1. **INFORMATION HIDING**: nascondere i dettagli implementativi interni
2. **ACCESSO CONTROLLATO**: esporre solo ciò che è necessario
3. **PROTEZIONE DATI**: prevenire stati invalidi dell'oggetto
4. **VALIDAZIONE**: controllare i dati prima di modificarli

#### Confronto: Classe Senza vs Con Incapsulamento

**ESEMPIO NEGATIVO - `BadBankAccount`:**
```java
class BadBankAccount {
    public String accountNumber;  // ❌ Campo pubblico!
    public double balance;         // ❌ Campo pubblico!
}

// Problemi:
BadBankAccount bad = new BadBankAccount();
bad.balance = -500.0;  // ❌ Possiamo impostare valori invalidi!
bad.balance += 1000000;  // ❌ Modifiche non controllate!
```

**ESEMPIO POSITIVO - `GoodBankAccount`:**
```java
class GoodBankAccount {
    private final String accountNumber;  // ✓ Privato e immutabile
    private double balance;              // ✓ Privato
    
    // Accesso controllato
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    
    // Validazione nelle operazioni
    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }
}
```

#### Caratteristiche delle Classi Dimostrate:

**`GoodBankAccount`:**
- Campi `private`: accessibili solo all'interno della classe
- `accountNumber` è `final`: non può essere modificato dopo la creazione
- Metodi `deposit()` e `withdraw()` con validazione completa
- Protezione dell'invariante: il saldo non può mai diventare negativo
- Getter senza setter per il saldo: modificabile solo tramite operazioni controllate

**`CustomerAccount`:**
- Validazione complessa dell'email con metodo helper privato
- Setter che ritorna `boolean` per indicare successo/fallimento
- `createdAt` immutabile (solo getter)
- Normalizzazione dei dati (trim, toLowerCase)
- Information hiding: i dettagli della validazione sono interni

#### Vantaggi dell'Incapsulamento:

- ✓ **PROTEZIONE**: i dati non possono essere messi in stati invalidi
- ✓ **VALIDAZIONE**: ogni modifica viene controllata
- ✓ **MANUTENIBILITÀ**: possiamo cambiare l'implementazione interna senza impattare il codice esterno
- ✓ **DEBUGGING**: più facile tracciare dove e come i dati vengono modificati
- ✓ **FLESSIBILITÀ**: possiamo aggiungere logica (logging, notifiche, cache) ai getter/setter
- ✓ **SICUREZZA**: controllo completo su come i dati vengono accessibili e modificati

#### Best Practices:

1. **Rendere i campi `private`** e fornire accesso tramite getter/setter
2. **Validare sempre** i dati nei setter e nei costruttori
3. **Usare `final`** per campi che non devono cambiare dopo la creazione
4. **Non esporre collezioni mutabili** direttamente (usare copie difensive)
5. **Limitare i setter**: non tutti i campi private necessitano di un setter pubblico
6. **Preferire metodi di business** (es. `withdraw()`) piuttosto che setter generici

---

### 5. **Polimorfismo**

Il polimorfismo permette di trattare oggetti di classi diverse attraverso un'interfaccia comune.

#### Dimostrazione:
- Array di tipo `Shape` che contiene oggetti `Circle` e `Rectangle`
- Stesso metodo (`displayInfo()`, `calculateArea()`) si comporta diversamente in base al tipo effettivo
- Runtime binding: la JVM sceglie l'implementazione corretta a runtime

#### Benefici:
- Codice più flessibile e manutenibile
- Possibilità di estendere il sistema senza modificare il codice esistente
- Fondamento del design pattern Strategy e altri pattern OOP

---

### 6. **Record (Java 14+)**

I Record sono una feature moderna di Java per creare classi dati immutabili con sintassi concisa.

#### Caratteristiche:
- Tutti i campi sono automaticamente `private final`
- Generazione automatica di:
  - Costruttore canonico
  - Getter (con nome del campo, non `getX()`)
  - `equals()`, `hashCode()`, `toString()`
- Sintassi compatta: `record Point(int x, int y) {}`

#### Esempi:
1. **`Point`**: record semplice con due campi
2. **`Employee`**: record con metodi custom aggiuntivi
3. **`ValidatedPerson`**: record con costruttore compatto per validazione

#### Quando Usare i Record:
- Data Transfer Objects (DTO)
- Classi immutabili per rappresentare dati
- Value objects nel Domain-Driven Design
- Chiavi per Map o elementi di Set

---

### 7. **Sealed Classes (Java 17+)**

Le Sealed Classes permettono un controllo preciso sull'ereditarietà, definendo esplicitamente quali classi possono estendere una superclasse.

#### Sintassi:
```java
sealed class Vehicle permits Car, Motorcycle, Truck { }
```

#### Opzioni per le Sottoclassi Permesse:
- **`final`**: non può essere ulteriormente estesa
- **`sealed`**: può essere estesa solo dalle classi che permette
- **`non-sealed`**: può essere estesa da chiunque (rompe la gerarchia sealed)

#### Gerarchia di Esempio: `Vehicle` → `Car`, `Motorcycle`, `Truck`

#### Benefici:
- Gerarchia completamente nota al compile-time
- Migliore type safety
- Exhaustiveness checking nel pattern matching
- Documentazione auto-esplicativa della struttura delle classi

---

### 8. **Pattern Matching (Java 16+ / Java 21)**

Il Pattern Matching semplifica il codice eliminando cast espliciti e controlli ripetitivi.

#### 8a. Pattern Matching per `instanceof` (Java 16+)

**Prima (Java ≤ 15):**
```java
if (obj instanceof String) {
    String str = (String) obj;  // Cast esplicito
    System.out.println(str.length());
}
```

**Dopo (Java 16+):**
```java
if (obj instanceof String str) {
    System.out.println(str.length());  // str già castato
}
```

#### 8b. Pattern Matching per `switch` (Java 21)

Feature avanzata che combina switch expressions con pattern matching.

**Caratteristiche:**
- **Type Patterns**: matching diretto sui tipi
- **Guarded Patterns**: pattern con condizioni (`when` clause)
- **Null Handling**: gestione esplicita di `null`
- **Record Patterns**: destrutturazione di record inline
- **Exhaustiveness Checking**: il compilatore verifica che tutti i casi siano coperti

**Esempio:**
```java
return switch (obj) {
    case null -> "Valore nullo";
    case String s -> "Stringa: " + s;
    case Integer i when i > 0 -> "Positivo: " + i;
    case Point(int x, int y) -> "Punto: (" + x + ", " + y + ")";
    default -> "Altro";
};
```

---

### 9. **Best Practices nella Programmazione OOP**

Questa sezione tratta le linee guida fondamentali per scrivere codice di qualità, manutenibile e robusto.

#### 9a. Principi SOLID

I principi SOLID sono cinque principi fondamentali della progettazione object-oriented:

**S - Single Responsibility Principle (SRP)**
- Ogni classe dovrebbe avere una sola responsabilità
- **Cattivo**: `BadEmployee` gestisce calcolo stipendio, persistenza e reporting
- **Buono**: `GoodEmployee`, `EmployeeSalaryCalculator`, `EmployeeRepository`, `EmployeeReportGenerator` - ognuna con una responsabilità specifica

**O - Open/Closed Principle (OCP)**
- Le classi dovrebbero essere aperte all'estensione ma chiuse alle modifiche
- Esempio: Sistema di sconti estensibile con `Discount` interface
- Possiamo aggiungere nuovi tipi di sconto (`SeasonalDiscount`, `LoyaltyDiscount`) senza modificare `DiscountCalculator`

**L - Liskov Substitution Principle (LSP)**
- Le sottoclassi devono essere sostituibili alle loro superclassi
- Esempio: `Sparrow` e `Penguin` estendono `Bird` con comportamenti appropriati
- Entrambi implementano `move()` in modo coerente con il loro comportamento naturale

**I - Interface Segregation Principle (ISP)**
- I client non dovrebbero dipendere da interfacce che non usano
- **Buono**: `SimplePrinter` implementa solo `Printable`
- **Buono**: `MultiFunctionDevice` implementa `Printable`, `Scannable`, `Faxable`
- Evitare interfacce "grasse" con metodi non necessari per tutti gli implementatori

**D - Dependency Inversion Principle (DIP)**
- Dipendere da abstractions, non da implementazioni concrete
- **Cattivo**: `BadNotificationService` dipende direttamente da `EmailSender`
- **Buono**: `GoodNotificationService` dipende dall'interfaccia `MessageSender`
- Permette di cambiare implementazione (EmailSender → SMSSender) senza modificare il codice

#### 9b. Composition over Inheritance

**Problema dell'ereditarietà:**
- Crea accoppiamento forte (tight coupling)
- Rigida e difficile da modificare
- Esempio: `BadFlyingCar extends BadFlyingVehicle` - e se vogliamo un'auto che non vola?

**Soluzione con la composizione:**
- Maggiore flessibilità
- Possiamo combinare funzionalità dinamicamente
- Esempio: `ModernCar` con `Engine` e opzionale `Wings`
- Stessa classe può comportarsi come auto normale o volante

#### 9c. Immutabilità e Thread Safety

**Vantaggi degli oggetti immutabili:**
- Thread-safe per natura (nessuna sincronizzazione necessaria)
- Più sicuri (non possono essere modificati accidentalmente)
- Più facili da ragionare e debuggare
- Possono essere condivisi liberamente tra thread

**Confronto:**
- **Cattivo**: `MutablePoint` con setter - può causare race conditions
- **Buono**: `ImmutablePoint` con metodi `withX()`, `withY()` che restituiscono nuove istanze
- **Buono**: Record sono immutabili per design

#### 9d. Defensive Programming

**Principi:**
- Validare sempre gli input
- Proteggere lo stato interno
- Non fidarsi dei dati esterni

**Tecniche dimostrate:**

1. **Validazione degli input**
   - `BankAccount` valida che accountNumber non sia vuoto e balance non sia negativo
   - Lancia `IllegalArgumentException` per input non validi

2. **Copia difensiva**
   - `BlogPost` crea copie degli array invece di salvare riferimenti
   - Previene modifiche esterne allo stato interno
   - Restituisce copie, non riferimenti diretti

3. **Null safety**
   - `UserProfile.getDisplayName()` usa valore di default se nickname è null
   - Evita `NullPointerException`

#### 9e. Naming Conventions e Code Organization

**Convenzioni di naming in Java:**
- **Classi e Interfacce**: PascalCase (es. `BankAccount`, `MessageSender`)
- **Metodi e Variabili**: camelCase (es. `calculateTotal`, `userName`)
- **Costanti**: UPPER_SNAKE_CASE (es. `MAX_SIZE`, `DEFAULT_TIMEOUT`)
- **Package**: lowercase (es. `com.corso.demo`)

**Nomi descrittivi:**
- ✗ `int d = 30;` - Non chiaro!
- ✓ `int daysInMonth = 30;` - Autoesplicativo!
- ✗ `void process(String s)` - Generico!
- ✓ `void processCustomerOrder(String orderId)` - Specifico!

**Organizzazione del codice:**
1. Campi static (public → private)
2. Campi instance (public → private)
3. Costruttori
4. Metodi (public → protected → private)
5. Classi interne

**Best practices:**
- Mantenere le classi coese e focalizzate (SRP)
- Limitare la lunghezza dei metodi (idealmente < 20 linee)
- Usare nomi di metodo che descrivano l'azione (`getUser`, `calculateTotal`, `isValid`)

---

## Best Practices - Riepilogo Generale

### Encapsulation (Incapsulamento)
- Campi private con getter/setter pubblici
- Controllo dell'accesso ai dati
- Validazione nei setter o costruttori

### Inheritance (Ereditarietà)
- Estensione di classi astratte
- Override di metodi
- Uso di `super` per accedere alla superclasse

### Polymorphism (Polimorfismo)
- Riferimenti a superclasse che puntano a sottoclassi
- Runtime binding dei metodi
- Array polimorfici

### Composition (Composizione)
- Classi interne per organizzare la logica
- Preferire composition over inheritance quando appropriato

### Immutability (Immutabilità)
- Record per dati immutabili
- Campi final
- Nessun setter nei record

### Type Safety
- Sealed classes per gerarchie controllate
- Pattern matching per eliminare cast non sicuri
- Validazione nei costruttori

---

## Struttura del Codice

La demo è organizzata in sezioni logiche:

1. **Metodo `run()`**: punto di ingresso che esegue tutte le dimostrazioni
2. **Sezioni dimostrative**: ogni concetto ha un metodo dedicato (es. `demonstrateIntroduction()`, `demonstrateBasicClasses()`, `demonstrateBestPractices()`)
3. **Classi di esempio**: definite come static nested classes per mantenere tutto in un file
4. **Utility methods**: metodi helper per la formattazione dell'output

---

## Come Eseguire

La classe viene eseguita tramite il menu principale dell'applicazione:

1. Avviare l'applicazione Java21Course
2. Selezionare l'opzione "Class" dal menu
3. Osservare l'output dettagliato di tutte le dimostrazioni

---

## Output della Demo

La demo produce output formattato che include:

- **Header e footer** con bordi decorativi
- **Sezioni** chiare per ogni argomento
- **Spiegazioni testuali** dei concetti
- **Output di esempio** che mostrano il funzionamento del codice
- **Commenti** inline che spiegano cosa sta succedendo

---

## Requisiti

- **Java 21** (per tutte le feature, specialmente pattern matching per switch)
- **Java 17+** per sealed classes
- **Java 14+** per record

---

## Apprendimento Progressivo

La demo è strutturata in modo progressivo:

0. **Introduzione** (cos'è una classe, oggetti, pilastri OOP) → concetti basilari
1. **Fondamenti** (classi, costruttori) → concetti base
2. **Organizzazione** (modificatori, classi interne) → strutturazione del codice
3. **OOP** (classi astratte, polimorfismo) → paradigma object-oriented
4. **Feature moderne** (record, sealed classes) → Java moderno
5. **Pattern matching** (instanceof, switch) → feature avanzate Java 21
6. **Best practices** (SOLID, composition, immutabilità) → codice professionale

Ogni sezione costruisce sulle precedenti, creando una comprensione completa delle classi in Java.

---

## Conclusione

`ClassDemo` fornisce una panoramica completa e pratica di come si utilizzano le classi in Java, dalle basi ai concetti avanzati. Studiando ed eseguendo questa demo, si acquisirà una solida comprensione di:

- Come progettare classi efficaci
- Come utilizzare l'ereditarietà e il polimorfismo
- Come sfruttare le feature moderne di Java (record, sealed classes, pattern matching)
- Best practices per la programmazione orientata agli oggetti (SOLID, composition over inheritance, defensive programming)
- Come scrivere codice thread-safe e immutabile

Questa conoscenza è fondamentale per scrivere codice Java professionale, manutenibile e idiomatico.
