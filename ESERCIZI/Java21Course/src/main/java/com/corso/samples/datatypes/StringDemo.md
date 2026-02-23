# StringDemo - Guida Completa al Tipo String in Java

## Panoramica

`StringDemo` è un modulo educativo completo che esplora in profondità il tipo `String` in Java, uno dei tipi più utilizzati nel linguaggio. La classe dimostra le caratteristiche fondamentali delle String, i metodi di manipolazione, le best practices e le ottimizzazioni per le performance.

**Package:** `com.corso.samples.datatypes`  
**Classe:** `StringDemo.java`  
**Metodo principale:** `run()`

## Obiettivi di Apprendimento

Dopo aver completato questo modulo, saprai:

- ✅ Comprendere l'**immutabilità** di String e le sue implicazioni
- ✅ Utilizzare il **String Pool** per ottimizzare la memoria
- ✅ Creare String in modi diversi (letterali, costruttori, conversioni)
- ✅ Confrontare String **correttamente** (`equals()` vs `==`)
- ✅ Cercare e estrarre parti di String
- ✅ Manipolare String (uppercase, trim, replace, split, join)
- ✅ Formattare String con `format()` e `formatted()`
- ✅ Usare **Text Blocks** (Java 15+) per testo multilinea
- ✅ Ottimizzare concatenazioni con **StringBuilder** e **StringBuffer**
- ✅ Applicare best practices professionali per lavorare con String

## Contenuto del Modulo

StringDemo è organizzato in **13 sezioni complete**:

### 1. Introduzione: Cos'è una String?
- Caratteristiche fondamentali (immutabilità, reference type, sequence di char)
- Perché String è immutabile (sicurezza, thread-safety, caching)
- Dimostrazione pratica dell'immutabilità
- String vs char[]

### 2. Creazione di String
- Letterali (String Pool) - **PREFERITO**
- Costruttore `new String()` - **EVITARE**
- Da char array
- Da byte array (encoding)
- Concatenazione
- `valueOf()` - conversione da altri tipi
- String vuota

### 3. String Pool e Internamento
- Come funziona il String Pool
- Letterali vs `new String()`
- `intern()` - aggiungere al pool manualmente
- Concatenazione compile-time vs runtime
- `==` vs `equals()` - fondamentale!

### 4. Concatenazione
- Operatore `+` (semplice)
- `concat()` method
- `String.join()` per array/liste
- `StringBuilder` (performance)
- ⚠️ **PERFORMANCE CRITICA** nei loop
- Comparazione performance

### 5. Confronti e Uguaglianza
- ⚠️ `==` vs `equals()` - errore comune
- `equalsIgnoreCase()`
- `compareTo()` - ordine lessicografico
- `compareToIgnoreCase()`
- `contentEquals()` - con CharSequence
- Null safety - letterale prima!

### 6. Metodi di Ricerca
- `indexOf()` / `lastIndexOf()`
- `contains()`
- `startsWith()` / `endsWith()`
- `matches()` - regular expressions
- Esempi pratici (URL validation)

### 7. Metodi di Estrazione
- `charAt()` - carattere a indice specifico
- `substring()` - estrae sottostringa
- `toCharArray()` / `getBytes()`
- `codePointAt()` - codice Unicode
- Esempio pratico: estrazione nome file ed estensione

### 8. Metodi di Modifica
- `toLowerCase()` / `toUpperCase()`
- `trim()` - rimuove spazi
- `strip()` / `stripLeading()` / `stripTrailing()` (Java 11+)
- `replace()` / `replaceFirst()` / `replaceAll()`
- `repeat()` (Java 11+)
- `concat()`
- `indent()` (Java 12+)

### 9. Split e Join
- `split()` - divide String in array
- Split con regex
- Split con limit
- `String.join()` - unisce array/lista
- Esempio pratico: CSV processing
- ⚠️ Attenzione agli spazi

### 10. Formatting
- `String.format()` - formattazione avanzata
- Format specifiers (`%s`, `%d`, `%f`, `%.2f`, ecc.)
- Width e padding
- `formatted()` - metodo di istanza (Java 15+)
- Esempio pratico: tabella formattata

### 11. Text Blocks (Java 15+)
- Sintassi `""" ... """`
- Metodo tradizionale vs Text Blocks
- Indentazione automatica
- Escape sequences
- Interpolazione con `formatted()`
- Casi d'uso (JSON, SQL, HTML)

### 12. StringBuilder e StringBuffer
- Il problema con String in loop
- `StringBuilder` - mutabile, non thread-safe
- Metodi principali (`append()`, `insert()`, `delete()`, `reverse()`)
- Capacità iniziale e performance
- StringBuilder vs StringBuffer
- Dimostrazione performance
- Method chaining (fluent interface)

### 13. Best Practices
- 10 regole fondamentali
- Checklist finale
- Regola d'oro

---

## Perché String è Immutabile?

**Immutabilità** significa che una volta creato un oggetto String, il suo valore **non può più essere modificato**. Ogni "modifica" crea una **nuova String**.

### Vantaggi dell'Immutabilità

| Vantaggio | Descrizione |
|-----------|-------------|
| **Sicurezza** | Non può essere alterata dopo la creazione (importante per password, path, ecc.) |
| **Thread-safety** | Condivisibile tra thread senza sincronizzazione |
| **String Pool** | Permette il riutilizzo di istanze identiche (risparmio memoria) |
| **Hash Code** | Può essere calcolato una sola volta e cachato (performance HashMap) |
| **Predicibilità** | Nessun side-effect inaspettato quando passata a metodi |

### Dimostrazione

```java
String original = "Hello";
String upper = original.toUpperCase();

System.out.println(upper);     // "HELLO"
System.out.println(original);  // "Hello" (IMMUTATA!)
```

`toUpperCase()` **NON modifica** `original`, ma crea e ritorna una **nuova String**.

---

## String Pool e Ottimizzazione Memoria

Il **String Pool** è un'area speciale dell'heap dove Java memorizza i letterali String per ottimizzare l'uso della memoria.

### Come Funziona

```java
String s1 = "Java";       // Letterale → va nel pool
String s2 = "Java";       // Stesso letterale → riutilizza dal pool
String s3 = new String("Java");  // new → crea nuovo oggetto (NON pool)

s1 == s2  // true  (stesso oggetto dal pool)
s1 == s3  // false (oggetti diversi)
s1.equals(s3)  // true  (stesso valore)
```

### Tabella: Uso del Pool

| Creazione | Usa Pool? | Efficienza |
|-----------|-----------|------------|
| `"Hello"` | ✓ | Alta |
| `new String("Hello")` | ✗ | Bassa |
| `new String("Hello").intern()` | ✓ | Media |
| `"Hel" + "lo"` (compile-time) | ✓ | Alta |
| `str1 + str2` (runtime) | ✗ | Bassa |

### Regola Fondamentale

**✓ USA**: Letterali String (`"testo"`)  
**✗ EVITA**: `new String("testo")` senza motivo

---

## Confronto String: == vs equals()

**ERRORE COMUNE**: Usare `==` per confrontare String

### ❌ SBAGLIATO: ==

```java
String s1 = "Java";
String s2 = new String("Java");

if (s1 == s2) {  // false! (confronta RIFERIMENTI)
    System.out.println("Uguali");
}
```

### ✅ CORRETTO: equals()

```java
if (s1.equals(s2)) {  // true! (confronta VALORI)
    System.out.println("Uguali");
}
```

### Tabella: Metodi di Confronto

| Metodo | Descrizione | Quando Usare |
|--------|-------------|--------------|
| `==` | Confronta **riferimenti** (identità oggetto) | ⚠️ Evitare per String |
| `equals()` | Confronta **valori** (contenuto) | ✓ Usare sempre |
| `equalsIgnoreCase()` | Confronta valori ignorando maiuscole/minuscole | Confronti case-insensitive |
| `compareTo()` | Ordine lessicografico (-1, 0, 1) | Ordinamento, sorting |
| `compareToIgnoreCase()` | compareTo ignorando case | Ordinamento case-insensitive |
| `contentEquals()` | Confronta con CharSequence | Confronto con StringBuilder/StringBuffer |

### Null Safety

```java
String userInput = null;

// ❌ CRASH: NullPointerException
if (userInput.equals("admin")) { ... }

// ✅ SICURO: anche se userInput è null
if ("admin".equals(userInput)) { ... }
```

**BEST PRACTICE**: Metti il **letterale prima** per evitare NullPointerException.

---

## Concatenazione e Performance

### Il Problema dei Loop

```java
// ❌ PESSIMO: crea 1000 oggetti String!
String result = "";
for (int i = 0; i < 1000; i++) {
    result += i;  // Ogni += crea un NUOVO oggetto
}
```

### La Soluzione: StringBuilder

```java
// ✅ OTTIMO: modifica lo stesso oggetto
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);  // Modifica in-place
}
String result = sb.toString();
```

### Performance Comparison

Per concatenare **5000** caratteri:

| Metodo | Tempo | Performance |
|--------|-------|-------------|
| `String +=` | ~500 ms | Baseline |
| `StringBuilder` | ~2 ms | **~250x più veloce** |

### Quando Usare Cosa?

| Scenario | Usa |
|----------|-----|
| Concatenazioni semplici (2-3) | Operatore `+` |
| Unire array/liste con separatore | `String.join()` |
| Loop o molte concatenazioni | `StringBuilder` |
| Multi-thread (sincronizzato) | `StringBuffer` |

---

## Reference Rapido: Metodi String

### Ricerca

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `indexOf(char)` | Trova prima occorrenza | `"Java".indexOf('a')` → `1` |
| `indexOf(String)` | Trova prima occorrenza sottostringa | `"Java".indexOf("av")` → `1` |
| `lastIndexOf(char)` | Trova ultima occorrenza | `"Java".lastIndexOf('a')` → `3` |
| `contains(String)` | Verifica presenza | `"Java".contains("av")` → `true` |
| `startsWith(String)` | Inizia con | `"Java".startsWith("Ja")` → `true` |
| `endsWith(String)` | Finisce con | `"Java".endsWith("va")` → `true` |

### Estrazione

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `charAt(int)` | Carattere a indice | `"Java".charAt(0)` → `'J'` |
| `substring(int)` | Da indice alla fine | `"Java".substring(2)` → `"va"` |
| `substring(int, int)` | Da indice a indice (escluso) | `"Java".substring(0, 2)` → `"Ja"` |
| `toCharArray()` | Converte in char[] | `"Java".toCharArray()` → `['J','a','v','a']` |

### Modifica (creano nuova String!)

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `toLowerCase()` | Minuscolo | `"JAVA".toLowerCase()` → `"java"` |
| `toUpperCase()` | Maiuscolo | `"java".toUpperCase()` → `"JAVA"` |
| `trim()` | Rimuove spazi inizio/fine | `"  Hi  ".trim()` → `"Hi"` |
| `strip()` | Rimuove whitespace Unicode (Java 11+) | `" Hi ".strip()` → `"Hi"` |
| `replace(char, char)` | Sostituisce carattere | `"Java".replace('a', 'o')` → `"Jovo"` |
| `replace(String, String)` | Sostituisce sottostringa | `"Java".replace("va", "")` → `"Ja"` |
| `replaceAll(regex, String)` | Sostituisce con regex | `"a1b2".replaceAll("\\d", "X")` → `"aXbX"` |
| `replaceFirst(regex, String)` | Sostituisce prima occorrenza | `"a1b2".replaceFirst("\\d", "X")` → `"aXb2"` |
| `repeat(int)` | Ripete n volte (Java 11+) | `"*".repeat(5)` → `"*****"` |

### Verifica

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `isEmpty()` | Lunghezza è 0 | `"".isEmpty()` → `true` |
| `isBlank()` | Vuota o solo whitespace (Java 11+) | `"  ".isBlank()` → `true` |
| `length()` | Lunghezza | `"Java".length()` → `4` |
| `equals(Object)` | Confronto valore | `"Java".equals("Java")` → `true` |
| `equalsIgnoreCase(String)` | Confronto ignorando case | `"Java".equalsIgnoreCase("JAVA")` → `true` |

### Split & Join

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `split(String)` | Divide per delimitatore | `"a,b,c".split(",")` → `["a", "b", "c"]` |
| `split(regex, limit)` | Divide con limite | `"a:b:c:d".split(":", 2)` → `["a", "b:c:d"]` |
| `String.join(delim, arr)` | Unisce array | `String.join(", ", arr)` → `"a, b, c"` |

### Formatting

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `String.format(fmt, args)` | Formattazione | `String.format("%s: %d", "Age", 30)` → `"Age: 30"` |
| `formatted(args)` | Formattazione istanza (Java 15+) | `"%s: %d".formatted("Age", 30)` → `"Age: 30"` |

---

## StringBuilder vs StringBuffer

Entrambe sono classi **mutabili** per costruire String efficientemente.

### Differenze

| Caratteristica | StringBuilder | StringBuffer |
|----------------|---------------|--------------|
| **Thread-safe** | ✗ No | ✓ Sì (sincronizzato) |
| **Performance** | Alta | Bassa (overhead sincronizzazione) |
| **Quando usare** | Single-thread (99% dei casi) | Multi-thread (raro) |

### Metodi Principali

```java
StringBuilder sb = new StringBuilder("Java");

sb.append(" 21");           // "Java 21"
sb.insert(4, " Programming"); // "Java Programming 21"
sb.delete(4, 16);           // "Java 21"
sb.reverse();               // "12 avaJ"
sb.reverse();               // "Java 21"

String result = sb.toString();  // Converte in String
```

### Capacità Iniziale

```java
StringBuilder sb = new StringBuilder();  // capacità 16
StringBuilder sb = new StringBuilder(100);  // capacità 100 (preassegnata)

sb.capacity()  // Capacità attuale
sb.length()    // Lunghezza contenuto
```

**Tip**: Preassegnare la capacità migliora le performance se conosci la dimensione approssimativa.

### Method Chaining

```java
String result = new StringBuilder()
    .append("Java")
    .append(" ")
    .append("21")
    .append(" ")
    .append("Course")
    .toString();
```

---

## Text Blocks (Java 15+)

Text blocks semplificano la creazione di stringhe multilinea.

### Sintassi

```java
String json = """
    {
      "name": "John",
      "age": 30,
      "city": "New York"
    }
    """;
```

### Vantaggi rispetto al Metodo Tradizionale

```java
// ❌ Prima di Java 15: illeggibile, troppe escape
String json = "{\n" +
              "  \"name\": \"John\",\n" +
              "  \"age\": 30,\n" +
              "  \"city\": \"New York\"\n" +
              "}";

// ✅ Con Text Blocks: leggibile, naturale
String json = """
    {
      "name": "John",
      "age": 30,
      "city": "New York"
    }
    """;
```

### Indentazione Automatica

Text blocks rimuovono automaticamente l'indentazione comune:

```java
String text = """
            Line 1
            Line 2
                Line 3 (indentata)
        """;
// Risultato:
// Line 1
// Line 2
//     Line 3 (indentata)
```

### Interpolazione con formatted()

```java
String name = "Alice";
int score = 95;

String report = """
    Student Report
    --------------
    Name: %s
    Score: %d/100
    """.formatted(name, score);
```

### Casi d'Uso Ideali

- JSON, XML, HTML
- Query SQL
- Template di testo
- Messaggi multilinea
- Email, documenti formattati

---

## Esempi Pratici

### 1. Validazione URL

```java
String url = "https://www.example.com/page";

if (url.startsWith("https://")) {
    System.out.println("URL sicuro (HTTPS)");
}

if (url.contains("example")) {
    System.out.println("URL contiene 'example'");
}

if (url.endsWith(".com")) {
    System.out.println("Dominio .com");
}
```

### 2. Estrazione Nome File ed Estensione

```java
String filePath = "C:/Users/Documents/report.pdf";

int lastSlash = filePath.lastIndexOf('/');
String fileName = filePath.substring(lastSlash + 1);  // "report.pdf"

int lastDot = fileName.lastIndexOf('.');
String name = fileName.substring(0, lastDot);         // "report"
String extension = fileName.substring(lastDot + 1);   // "pdf"
```

### 3. CSV Processing

```java
String csvLine = "John,Doe,30,Engineer";

// Parse
String[] fields = csvLine.split(",");
System.out.println("Nome: " + fields[0]);
System.out.println("Cognome: " + fields[1]);
System.out.println("Età: " + fields[2]);

// Modifica
fields[2] = "31";

// Ricostruisci
String updatedCsv = String.join(",", fields);  // "John,Doe,31,Engineer"
```

### 4. Tabella Formattata

```java
System.out.println(String.format("%-15s %-10s %10s", "Prodotto", "Quantità", "Prezzo"));
System.out.println("-".repeat(40));
System.out.println(String.format("%-15s %-10d %10.2f€", "Laptop", 5, 899.99));
System.out.println(String.format("%-15s %-10d %10.2f€", "Mouse", 20, 15.50));
```

Output:
```
Prodotto        Quantità        Prezzo
----------------------------------------
Laptop          5               899.99€
Mouse           20               15.50€
```

### 5. Costruzione Dinamica di SQL

```java
StringBuilder sql = new StringBuilder();
sql.append("SELECT id, name, email FROM users WHERE ");

boolean hasAge = true;
boolean hasActive = true;

if (hasAge) {
    sql.append("age > 18");
}

if (hasActive) {
    if (hasAge) sql.append(" AND ");
    sql.append("active = true");
}

sql.append(" ORDER BY name");

String query = sql.toString();
// "SELECT id, name, email FROM users WHERE age > 18 AND active = true ORDER BY name"
```

---

## Best Practices

### 1. ✅ Usa Letterali, NON new String()

```java
// ✅ CORRETTO
String s = "Hello";

// ❌ EVITA
String s = new String("Hello");
```

### 2. ✅ Usa equals(), NON ==

```java
// ✅ CORRETTO
if (str1.equals(str2)) { ... }

// ❌ EVITA
if (str1 == str2) { ... }
```

### 3. ✅ Letterale Prima per Null Safety

```java
// ✅ CORRETTO (sicuro anche se userInput è null)
if ("admin".equals(userInput)) { ... }

// ❌ EVITA (NullPointerException se userInput è null)
if (userInput.equals("admin")) { ... }
```

### 4. ✅ StringBuilder in Loop

```java
// ✅ CORRETTO
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String result = sb.toString();

// ❌ EVITA
String result = "";
for (int i = 0; i < 1000; i++) {
    result += i;  // Lento!
}
```

### 5. ✅ isEmpty() / isBlank() per Verificare Vuoto

```java
// ✅ CORRETTO
if (str.isEmpty()) { ... }
if (str.isBlank()) { ... }  // Java 11+ (include whitespace)

// ❌ EVITA
if (str.length() == 0) { ... }
if (str.equals("")) { ... }
```

### 6. ✅ Text Blocks per Testo Multilinea

```java
// ✅ CORRETTO (Java 15+)
String json = """
    {
      "name": "value"
    }
    """;

// ❌ EVITA
String json = "{\n  \"name\": \"value\"\n}";
```

### 7. ✅ String.format() per Formattazione Complessa

```java
// ✅ CORRETTO
String msg = String.format("User %s has %d points", name, score);

// ❌ EVITA (meno leggibile)
String msg = "User " + name + " has " + score + " points";
```

### 8. ⚠️ intern() con Attenzione

Usa `intern()` **SOLO** se:
- Hai molte String duplicate
- Servono confronti `==` (raro)
- Vuoi risparmiare memoria

**NON** usare `intern()` per default:
- String Pool non è facilmente garbage collected
- Può causare memory leak se abusato

### 9. ✅ Valida Input Utente

```java
if (userInput == null || userInput.trim().isEmpty()) {
    throw new IllegalArgumentException("Input vuoto");
}

if (userInput.length() > 100) {
    throw new IllegalArgumentException("Input troppo lungo");
}
```

### 10. ✅ Evita String Mutabili Simulate

```java
// ❌ EVITA
String s = "Hello";
s = s + " World";  // Crea nuova String ogni volta

// ✅ Se serve mutabilità, usa StringBuilder
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
```

---

## Checklist Finale

Prima di lavorare con String, verifica:

- ☑ Sto usando letterali invece di `new String()`?
- ☑ Sto usando `equals()` invece di `==`?
- ☑ Ho il letterale prima di variabili (null safety)?
- ☑ Sto usando `StringBuilder` nei loop?
- ☑ Sto validando input utente?
- ☑ Sto usando `isEmpty()`/`isBlank()` invece di `length() == 0`?
- ☑ Per multilinea, uso text blocks (Java 15+)?
- ☑ Per formattazione, uso `String.format()`?
- ☑ Evito `intern()` a meno che necessario?
- ☑ Conosco l'immutabilità di String?

---

## Regola d'Oro

> **"String è IMMUTABILE. Se serve mutabilità, usa StringBuilder."**
> 
> **"Usa equals() per confrontare valori, MAI ==."**

---

## Come Eseguire la Demo

### Dalla Console Maven

```bash
# Compila il progetto
mvn clean compile

# Esegui l'applicazione principale
mvn exec:java -Dexec.mainClass="com.corso.demo.App"
```

### Dal Menu Principale

1. Avvia l'applicazione: `mvn exec:java -Dexec.mainClass="com.corso.demo.App"`
2. Seleziona: **[6] String**
3. Segui la demo interattiva attraverso tutte le 13 sezioni
4. Premi INVIO tra una sezione e l'altra per procedere

### Esecuzione Diretta della Demo

```bash
# Esegui solo StringDemo
mvn exec:java -Dexec.mainClass="com.corso.samples.datatypes.StringDemo" -Dexec.classpathScope=compile
```

---

## Struttura del Codice

```
StringDemo.java
├── run()                              // Metodo principale (orchestra tutte le sezioni)
├── demoIntroduction()                 // 1. Introduzione e caratteristiche
├── demoStringCreation()               // 2. Creazione di String
├── demoStringPool()                   // 3. String Pool e internamento
├── demoConcatenation()                // 4. Concatenazione
├── demoComparison()                   // 5. Confronti e uguaglianza
├── demoSearchMethods()                // 6. Metodi di ricerca
├── demoExtractionMethods()            // 7. Metodi di estrazione
├── demoModificationMethods()          // 8. Metodi di modifica
├── demoSplitJoin()                    // 9. Split e Join
├── demoFormatting()                   // 10. Formatting
├── demoTextBlocks()                   // 11. Text Blocks (Java 15+)
├── demoStringBuilderBuffer()          // 12. StringBuilder e StringBuffer
├── demoBestPractices()                // 13. Best Practices
└── Metodi Utility
    ├── printHeader()
    ├── printSection()
    ├── printSubSection()
    ├── printFooter()
    └── waitForEnter()
```

---

## Riferimenti

- [Java String Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html)
- [StringBuilder Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/StringBuilder.html)
- [StringBuffer Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/StringBuffer.html)
- [JEP 355: Text Blocks (Preview)](https://openjdk.org/jeps/355)
- [JEP 378: Text Blocks](https://openjdk.org/jeps/378)
- [Effective Java (Joshua Bloch) - Item 63: Beware the performance of string concatenation](https://www.oreilly.com/library/view/effective-java/9780134686097/)

---

**Buono studio e buon coding!** 🚀
