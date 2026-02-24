# LiteralsDemo - Guida Completa ai Letterali in Java

## Panoramica

**LiteralsDemo** è una classe completa per l'apprendimento dei **letterali (literals)** in Java. Un letterale è un valore costante scritto direttamente nel codice sorgente, come `42`, `3.14`, `'A'`, `"Hello"`, `true`, o `null`.

Java supporta diversi tipi di letterali per rappresentare valori di tipi primitivi, stringhe e riferimenti null.

---

## Tipi di Letterali in Java

### Mappatura dei Letterali

| Tipo Letterale | Tipo Java | Esempi | Note |
|----------------|-----------|---------|------|
| Intero decimale | `int` | `42`, `0`, `-100` | Tipo predefinito per interi |
| Intero binario | `int` | `0b1010`, `0B11111111` | Prefisso `0b` o `0B` (Java 7+) |
| Intero ottale | `int` | `077`, `0644` | Prefisso `0` (attenzione!) |
| Intero esadecimale | `int` | `0xFF`, `0x2A` | Prefisso `0x` o `0X` |
| Long | `long` | `100L`, `3000000000L` | Suffisso `L` o `l` (preferire `L`) |
| Floating-point | `double` | `3.14`, `1.23e2` | Tipo predefinito per decimali |
| Float | `float` | `3.14F`, `.5F` | Suffisso `F` o `f` obbligatorio |
| Carattere | `char` | `'A'`, `'\n'`, `'\u0041'` | Apici singoli `''` |
| Stringa | `String` | `"Hello"`, `""` | Apici doppi `""` |
| Text block | `String` | `"""..."""` | Stringhe multilinea (Java 13+) |
| Booleano | `boolean` | `true`, `false` | Solo due valori possibili |
| Null | Qualsiasi riferimento | `null` | Rappresenta assenza di oggetto |

---

## Struttura della Demo

La classe `LiteralsDemo` è organizzata in **12 sezioni educative**:

### 1. Introduzione ai Letterali
- Definizione di letterale
- Differenza tra letterali e variabili
- Caratteristiche dei letterali
- Valutazione a compile-time

**Concetti chiave:**
```java
int number = 42;  // 42 è un LETTERALE (costante)
                  // number è una VARIABILE (contenitore)
```

### 2. Letterali Interi Decimali
- Sintassi dei letterali in base 10
- Tipo predefinito: `int` (32 bit)
- Range: da -2³¹ a 2³¹-1
- Segno come operatore unario

**Esempi:**
```java
int zero = 0;
int positive = 42;
int negative = -100;
int large = 2147483647;  // Integer.MAX_VALUE
```

### 3. Letterali Interi in Altre Basi

#### Binario (Base 2) - Prefisso `0b` o `0B`
```java
int binary = 0b1010;        // 10 in decimale
int flags = 0b0001_0010;    // Leggibile con underscore
```
**Uso comune:** Maschere di bit, flag, permessi

#### Ottale (Base 8) - Prefisso `0`
```java
int octal = 0755;           // 493 decimale (permessi Unix rwxr-xr-x)
```
**⚠️ Attenzione:** `0123` è ottale (83 decimale), NON 123!

#### Esadecimale (Base 16) - Prefisso `0x` o `0X`
```java
int hex = 0xFF;             // 255 decimale
int color = 0xFF0000;       // Rosso RGB
int magic = 0xCAFEBABE;     // Magic number Java class file
```
**Uso comune:** Colori RGB, indirizzi memoria, magic numbers

### 4. Letterali Long
- Suffisso `L` o `l` (raccomandato `L` maiuscolo)
- Obbligatorio per valori fuori dal range `int`
- Range: da -2⁶³ a 2⁶³-1

**Quando il suffisso L è obbligatorio:**
```java
long smallLong = 100;          // OK (autoconversione da int)
// long bigLong = 3000000000;  // ✗ ERRORE! Fuori range int
long bigLong = 3000000000L;    // ✓ OK con suffisso L
```

**Casi d'uso comuni:**
- Timestamp (millisecondi dal 1970)
- Dimensioni file grandi
- Contatori per grandi quantità

### 5. Letterali Floating-Point

#### Double (Tipo Predefinito)
```java
double d1 = 3.14;           // Forma standard
double d2 = 3.14D;          // Suffisso D opzionale
double d3 = .5;             // 0.5 (parte intera omessa)
double d4 = 5.;             // 5.0 (parte decimale omessa)
```

#### Float (Suffisso F Obbligatorio)
```java
float f1 = 3.14F;           // F maiuscolo (raccomandato)
// float f2 = 3.14;         // ✗ ERRORE! 3.14 è double
```

#### Notazione Scientifica
```java
double sci = 1.23e2;        // 1.23 × 10² = 123.0
double small = 1.23e-4;     // 1.23 × 10⁻⁴ = 0.000123
float avogadro = 6.022e23F; // Numero di Avogadro
```

**Precisione:**
- `float`: ~7 cifre significative (32 bit)
- `double`: ~15 cifre significative (64 bit)

### 6. Underscore nei Letterali Numerici (Java 7+)
- Migliora la leggibilità di numeri grandi
- Ignorati completamente dal compilatore

**Esempi:**
```java
int million = 1_000_000;                    // Migliaia separate
long creditCard = 1234_5678_9012_3456L;     // Formato carta
int binary = 0b0001_0010_0011_0100;         // Nibble (4 bit)
int hexColor = 0xFF_00_FF;                  // RGB (magenta)
double pi = 3.14159_26535_89793;            // Decimali raggruppati
```

**Regole:**
- ✓ VALIDO: `1_000`, `0b1010_1100`, `3.14_15_92`
- ✗ NON VALIDO: `_1000` (inizio), `1000_` (fine), `3._14` (punto decimale), `52_L` (suffisso)

### 7. Letterali Carattere
- Rappresentano singoli caratteri Unicode
- Apici singoli `''`

**Sintassi base:**
```java
char letter = 'A';
char digit = '5';
char space = ' ';
```

**Sequenze di Escape:**
```java
char newline = '\n';      // A capo
char tab = '\t';          // Tabulazione
char backslash = '\\';    // Backslash
char singleQuote = '\'';  // Apice singolo
char doubleQuote = '\"';  // Apice doppio
```

**Letterali Unicode:**
```java
char unicodeA = '\u0041';      // A (codice Unicode)
char unicodeEuro = '\u20AC';   // € (simbolo euro)
char unicodeHeart = '\u2665';  // ♥ (cuore)
```

**Char come numeri:**
```java
char numericChar = 65;         // Equivalente a 'A'
int charAsInt = 'Z';           // 90 (codice Unicode di 'Z')
```

**⚠️ Apici singoli vs doppi:**
- `'A'` → `char` (singolo carattere)
- `"A"` → `String` (stringa con 1 carattere)

### 8. Letterali Stringa
- Sequenze di caratteri tra apici doppi `""`
- Oggetti immutabili della classe `String`

**Sintassi base:**
```java
String hello = "Hello, World!";
String empty = "";              // Stringa vuota (valida)
String singleChar = "A";        // String con 1 char (≠ char!)
```

**Escape sequences nelle stringhe:**
```java
String multiline = "Prima riga\nSeconda riga";
String withTab = "Nome:\tMario\tRossi";
String withQuotes = "Disse: \"Hello!\"";
String withBackslash = "C:\\Program Files\\Java";
```

**Concatenazione:**
```java
String concat = "Hello" + " " + "World";
String withNumber = "Valore: " + 42;        // Conversione automatica
```

**Unicode:**
```java
String unicode = "Euro: \u20AC, Heart: \u2665";
String emoji = "Emoji: 😀 🎉 ❤️";
String japanese = "こんにちは";
```

**String Pool:**
```java
String s1 = "Hello";
String s2 = "Hello";  // Stesso oggetto nel pool
s1 == s2              // true (ma usa sempre .equals()!)
```

### 9. Text Blocks - Stringhe Multilinea (Java 13+)
- Delimitatori: tre doppi apici `"""`
- Stringhe multilinea senza escape `\n`
- Indentazione gestita automaticamente

**Confronto:**
```java
// Modo tradizionale (scomodo)
String json = "{\n" +
              "  \"name\": \"Mario\",\n" +
              "  \"age\": 30\n" +
              "}";

// Con text block (Java 13+)
String json = """
        {
          "name": "Mario",
          "age": 30
        }
        """;
```

**Vantaggi:**
- ✓ Nessun escape per doppi apici
- ✓ Nessun `\n` esplicito
- ✓ Nessuna concatenazione con `+`
- ✓ Molto più leggibile per JSON, XML, SQL, HTML

**Esempi d'uso:**
```java
// HTML
String html = """
        <html>
            <body>
                <h1>Benvenuto!</h1>
            </body>
        </html>
        """;

// SQL
String sql = """
        SELECT users.name, orders.total
        FROM users
        JOIN orders ON users.id = orders.user_id
        WHERE orders.total > 100;
        """;
```

### 10. Letterali Booleani
- Solo due valori: `true` e `false`
- Parole chiave (tutto minuscolo)

**Sintassi:**
```java
boolean isTrue = true;
boolean isFalse = false;
```

**⚠️ Regole importanti:**
- ✓ `true`, `false` (minuscolo)
- ✗ `True`, `TRUE` (errore di compilazione)
- ✗ Non sono numeri! (non `0` o `1`)

**Uso tipico:**
```java
// Condizioni
if (isValid) { ... }

// Operatori logici
boolean and = true && false;   // false
boolean or = true || false;    // true
boolean not = !true;           // false

// Flag
boolean debugMode = false;
```

**Wrapper Boolean:**
```java
Boolean wrapperTrue = true;     // Autoboxing
// Boolean ha solo 2 istanze singleton:
// Boolean.TRUE e Boolean.FALSE
```

### 11. Letterale null
- Rappresenta l'assenza di un oggetto
- Può essere assegnato a qualsiasi tipo riferimento

**Uso del letterale null:**
```java
String nullString = null;
Integer nullInteger = null;
Object nullObject = null;
int[] nullArray = null;
```

**⚠️ null NON può essere assegnato a primitivi:**
```java
// int primitiveNull = null;      // ✗ ERRORE di compilazione
Integer wrapperNull = null;       // ✓ OK (Integer è un oggetto)
```

**Controllo di null:**
```java
if (obj == null) { ... }
if (obj != null) { obj.doSomething(); }
```

**NullPointerException:**
```java
String nullStr = null;
int length = nullStr.length();  // ✗ NullPointerException!
```

**Best practices:**
- ✓ Controlla sempre `null` prima di usare un oggetto
- ✓ Usa `Optional<T>` per rendere esplicito che un valore può essere `null`
- ✓ Usa annotazioni `@Nullable` e `@NonNull`
- ✗ Evita di restituire `null` quando possibile (usa stringhe/liste vuote o `Optional`)

### 12. Best Practices con i Letterali

#### 1. Leggibilità dei Numeri
```java
✓ long billion = 1_000_000_000L;        // Leggibile
✗ long billion = 1000000000L;           // Difficile da leggere

✓ int permissions = 0755;               // Ottale per permessi Unix
✓ int color = 0xFF5733;                 // Hex per colori
✓ int flags = 0b10101100;               // Binario per bit flags
```

#### 2. Suffissi per Tipo Corretto
```java
✓ long value = 1000L;    // L maiuscolo (chiaro)
✗ long value = 1000l;    // l minuscolo (confuso con 1)

✓ float pi = 3.14F;      // F maiuscolo (chiaro)
```

#### 3. Costanti Nominali
```java
// ✗ CATTIVO (magic numbers):
if (status == 200) { ... }
double area = 3.14159 * r * r;

// ✓ BUONO (costanti nominali):
public static final int HTTP_OK = 200;
public static final double PI = 3.14159;

if (status == HTTP_OK) { ... }
double area = PI * r * r;
```

#### 4. Stringhe e Text Blocks
```java
// ✗ Scomodo
String json = "{\n" + "  \"name\": \"value\"\n" + "}";

// ✓ Chiaro (Java 13+)
String json = """
        {
          "name": "value"
        }
        """;
```

#### 5. Confronti e null
```java
String input = getUserInput();

// ✗ NullPointerException se input è null
if (input.equals("quit")) { ... }

// ✓ Sicuro (letterale prima)
if ("quit".equals(input)) { ... }

// ✓ Gestisce null
if (Objects.equals(input, "quit")) { ... }
```

#### 6. Tipo Appropriate

| Situazione | Usa | Esempio |
|-----------|-----|---------|
| Numeri interi piccoli | `int` | `42` |
| Numeri interi grandi | `long` | `1000000L` |
| Decimali precisione normale | `double` | `3.14` |
| Decimali memoria limitata | `float` | `3.14F` |
| Singolo carattere | `char` | `'A'` |
| Testo | `String` | `"text"` |
| Flag/condizioni | `boolean` | `true/false` |
| Assenza oggetto | `null` | `null` |

---

## Confronto tra Basi Numeriche

Lo stesso valore (42) può essere scritto in diverse basi:

| Base | Letterale | Valore |
|------|-----------|--------|
| Decimale | `42` | 42 |
| Binario | `0b101010` | 42 |
| Ottale | `052` | 42 |
| Esadecimale | `0x2A` | 42 |

---

## Sequenze di Escape

| Sequenza | Descrizione | Esempio |
|----------|-------------|---------|
| `\n` | Newline (a capo) | `"Prima\nSeconda"` |
| `\t` | Tab (tabulazione) | `"A\tB"` |
| `\\` | Backslash | `"C:\\Path"` |
| `\'` | Apice singolo | `'\''` |
| `\"` | Apice doppio | `"Disse: \"Hi\""` |
| `\r` | Carriage return | Windows: `\r\n` |
| `\b` | Backspace | Cancella 1 carattere |
| `\f` | Form feed | Nuova pagina |
| `\uXXXX` | Unicode | `'\u20AC'` (€) |

---

## Esecuzione della Demo

### Da Menu Interattivo
```bash
mvn exec:java
```
Seleziona l'opzione **[3] Letterali** dal menu.

### Direttamente (se configurato)
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.corso.samples.datatypes.LiteralsDemo"
```

---

## Concetti Chiave da Ricordare

1. **I letterali sono costanti** scritte direttamente nel codice
2. **Il tipo è determinato dalla forma** del letterale:
   - Numeri interi → `int` (default)
   - Numeri decimali → `double` (default)
   - Apici singoli → `char`
   - Apici doppi → `String`
3. **Suffissi per tipi specifici**:
   - `L` per `long`
   - `F` per `float`
   - `D` per `double` (opzionale)
4. **Prefissi per basi diverse**:
   - `0b` per binario
   - `0` per ottale (attenzione!)
   - `0x` per esadecimale
5. **Underscore** (`_`) migliora la leggibilità (Java 7+)
6. **Text blocks** (`"""`) per stringhe multilinea (Java 13+)
7. **`null`** rappresenta l'assenza di oggetto
8. **Usa costanti nominali** invece di "magic numbers"

---

## Best Practice Finale

**✓ Scrivi codice LEGGIBILE:**
- Usa underscore per numeri grandi
- Usa costanti nominali significative
- Usa la base appropriata (bin/oct/hex)
- Usa text blocks per stringhe complesse
- Evita confusione (`L` maiuscolo, non `l`)
- Documenta i "magic numbers" con costanti

---

## Riferimenti

- [Java Language Specification - Literals](https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.10)
- [Java Tutorial - Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [JEP 378: Text Blocks](https://openjdk.org/jeps/378)
- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)

---

## Note sulla Demo

Questa classe demo fornisce:
- ✅ **12 sezioni educative complete** su tutti i tipi di letterali
- ✅ **Esempi pratici e interattivi** per ogni concetto
- ✅ **Best practices professionali** con spiegazioni dettagliate
- ✅ **Commenti in italiano** per facilitare l'apprendimento
- ✅ **Formattazione con caratteri Unicode** per output chiaro
- ✅ **Navigazione interattiva** con pausa tra le sezioni

Ogni sezione include:
- Spiegazioni teoriche dettagliate
- Esempi di codice eseguibile
- Tabelle riassuntive
- Avvertimenti su errori comuni
- Casi d'uso pratici
