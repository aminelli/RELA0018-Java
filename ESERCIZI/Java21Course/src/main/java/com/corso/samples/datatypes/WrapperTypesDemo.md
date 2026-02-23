# WrapperTypesDemo - Documentazione

## Panoramica

La classe `WrapperTypesDemo` è una demo completa e dettagliata per l'apprendimento dei **Wrapper Types** (tipi wrapper) in Java. Fornisce esempi pratici, spiegazioni approfondite e best practices per tutti gli 8 tipi wrapper del linguaggio Java.

I wrapper types sono classi che "avvolgono" (wrap) i tipi primitivi, trasformandoli in oggetti. Questo è fondamentale perché Java distingue tra tipi primitivi (memorizzati nello stack) e oggetti (memorizzati nell'heap).

---

## Perché Esistono i Wrapper?

I wrapper types sono necessari perché:

1. **Collections e Generics** accettano SOLO oggetti, non primitivi
2. Permettono di rappresentare l'**assenza di valore** con `null`
3. Forniscono **metodi utility** per parsing, conversioni e operazioni
4. Sono richiesti dai **Generics** che lavorano solo con tipi riferimento

---

## Mappatura Primitive ↔ Wrapper

| Tipo Primitivo | Wrapper Class | Note |
|----------------|---------------|------|
| `byte` | `Byte` | Nome identico ma maiuscolo |
| `short` | `Short` | Nome identico ma maiuscolo |
| `int` | `Integer` | ⚠️ **NOME DIVERSO**: int → Integer |
| `long` | `Long` | Nome identico ma maiuscolo |
| `float` | `Float` | Nome identico ma maiuscolo |
| `double` | `Double` | Nome identico ma maiuscolo |
| `char` | `Character` | ⚠️ **NOME DIVERSO**: char → Character |
| `boolean` | `Boolean` | Nome identico ma maiuscolo |

**⚠️ Attenzione**: Solo `int` e `char` hanno nomi diversi per i loro wrapper!

---

## Sezioni della Demo

### 1. Introduzione e Mappatura

Questa sezione copre:
- Corrispondenza uno-a-uno tra primitivi e wrapper
- Differenze di nomenclatura (`int` → `Integer`, `char` → `Character`)
- Dichiarazione di wrapper vs primitivi
- **Differenza fondamentale**: i wrapper possono essere `null`, i primitivi no

#### Esempi Chiave

```java
// Primitivi - valori nello stack
int primitiveInt = 42;
double primitiveDouble = 3.14;

// Wrapper - oggetti nell'heap
Integer wrapperInt = 42;        // Autoboxing
Double wrapperDouble = 3.14;    // Autoboxing

// Differenza critica: null
Integer nullableInt = null;     // ✓ VALIDO
// int primitiveNull = null;    // ✗ ERRORE di compilazione
```

---

### 2. Autoboxing e Unboxing

Conversioni automatiche tra primitivi e wrapper introdotte in Java 5.

#### 2.1 Autoboxing (primitivo → wrapper)

Conversione automatica da tipo primitivo a wrapper.

```java
int primitiveValue = 100;
Integer wrapperValue = primitiveValue;  // Autoboxing automatico
// Il compilatore lo trasforma in: Integer.valueOf(primitiveValue)
```

#### 2.2 Unboxing (wrapper → primitivo)

Conversione automatica da wrapper a tipo primitivo.

```java
Integer boxedValue = 200;
int unboxedValue = boxedValue;  // Unboxing automatico
// Il compilatore lo trasforma in: boxedValue.intValue()
```

#### 2.3 Autoboxing in Espressioni

```java
Integer a = 10;
Integer b = 20;
Integer sum = a + b;  // Unboxing di a e b, operazione, poi autoboxing del risultato
```

#### ⚠️ PERICOLO: NullPointerException

```java
Integer nullValue = null;
int dangerous = nullValue;  // ✗ NullPointerException! (unboxing di null)
```

---

### 3. Cache degli Integer

Java mantiene una **cache interna** per Integer con valori da **-128 a 127**.

#### 3.1 Comportamento con la Cache

```java
Integer cached1 = 100;
Integer cached2 = 100;
cached1 == cached2  // → true (STESSO oggetto dalla cache)
```

#### 3.2 Comportamento senza la Cache

```java
Integer notCached1 = 1000;
Integer notCached2 = 1000;
notCached1 == notCached2  // → false (oggetti DIVERSI)
notCached1.equals(notCached2)  // → true (valori uguali)
```

#### 3.3 Cache per Altri Wrapper

- **Byte**: Tutti i valori cached (-128 a 127)
- **Short**: Valori da -128 a 127 cached
- **Long**: Valori da -128 a 127 cached
- **Character**: Valori da 0 a 127 (ASCII) cached
- **Boolean**: Solo due istanze singleton: `Boolean.TRUE` e `Boolean.FALSE`
- **Float**: Nessuna cache
- **Double**: Nessuna cache

#### 💡 LEZIONE IMPORTANTE

**✓ USA SEMPRE `.equals()` per confrontare wrapper, MAI `==`**

L'operatore `==` confronta i **riferimenti** (indirizzi di memoria), non i valori!

---

### 4. Metodi di Parsing

Conversione da stringhe a numeri/valori.

#### 4.1 Parsing verso Primitivi (parseXxx)

```java
int parsedInt = Integer.parseInt("42");
long parsedLong = Long.parseLong("1000000");
double parsedDouble = Double.parseDouble("3.14159");
boolean parsedBoolean = Boolean.parseBoolean("true");
```

#### 4.2 Parsing verso Wrapper (valueOf)

```java
Integer valueOfInt = Integer.valueOf("123");
Long valueOfLong = Long.valueOf("999999");
Double valueOfDouble = Double.valueOf("2.71828");
Boolean valueOfBoolean = Boolean.valueOf("false");
```

#### 4.3 Parsing con Basi Diverse

```java
int binary = Integer.parseInt("1010", 2);     // Base 2 → 10
int octal = Integer.parseInt("77", 8);        // Base 8 → 63
int hex = Integer.parseInt("FF", 16);         // Base 16 → 255
```

#### ⚠️ Gestione Errori

Il parsing può lanciare `NumberFormatException`:

```java
try {
    int value = Integer.parseInt("abc");  // Non è un numero!
} catch (NumberFormatException e) {
    System.out.println("Input non valido!");
}
```

---

### 5. Metodi di Conversione

#### 5.1 Conversione a Stringa

```java
Integer number = 42;
String str1 = number.toString();           // Metodo di istanza
String str2 = Integer.toString(42);        // Metodo statico
String str3 = Integer.toString(255, 16);   // Base 16 → "ff"
```

#### 5.2 Conversione a Primitivo (xxxValue)

```java
Integer value = 100;
int asInt = value.intValue();
long asLong = value.longValue();
double asDouble = value.doubleValue();
byte asByte = value.byteValue();  // Può causare overflow!
```

#### 5.3 valueOf() - Creazione di Wrapper

**Il metodo RACCOMANDATO** per creare wrapper (usa la cache!):

```java
Integer fromInt = Integer.valueOf(42);         // Da int
Integer fromString = Integer.valueOf("42");    // Da String
Integer fromBase = Integer.valueOf("FF", 16);  // Da String con base
```

#### 5.4 Conversioni Specifiche per Numerici

```java
int numero = 42;
String binary = Integer.toBinaryString(42);  // "101010"
String hex = Integer.toHexString(42);        // "2a"
String octal = Integer.toOctalString(42);    // "52"
```

---

### 6. Confronto tra Wrapper

⚠️ **Questo è uno degli errori più comuni in Java!**

#### 6.1 Problema con == (confronta riferimenti)

```java
Integer a = 1000;
Integer b = 1000;
a == b  // → false (oggetti diversi!)
a.equals(b)  // → true (valori uguali)
```

#### 6.2 Caso Speciale: Cache

```java
Integer c = 100;  // Nella cache
Integer d = 100;  // Stesso oggetto dalla cache
c == d  // → true (PER CASO SPECIALE, ma NON FIDARTI!)
```

#### 6.3 Soluzione: USA .equals()

```java
Integer num1 = 500;
Integer num2 = 500;
num1.equals(num2)  // → true ✓ Confronta i valori
num1 == num2       // → false ✗ Confronta i riferimenti
```

#### 6.4 Attenzione con null

```java
Integer num3 = null;
// num3.equals(num1)  // ✗ NullPointerException!
num1.equals(num3)     // ✓ Sicuro (restituisce false)
```

#### 6.5 Metodo compare() per Ordinamento

```java
Integer x = 10;
Integer y = 20;
Integer.compare(x, y)  // → negativo (x < y)
x.compareTo(y)         // → negativo (x < y)

// Convenzione:
// < 0  se primo < secondo
// 0    se primo == secondo
// > 0  se primo > secondo
```

#### 💡 REGOLA D'ORO

- ✓ Per confrontare VALORI wrapper: usa `.equals()`
- ✓ Per confrontare primitivi: usa `==`
- ✓ Per ordinamento: usa `.compareTo()` o `compare()`
- ✗ NON usare MAI `==` per confrontare wrapper

---

### 7. Null Safety e NullPointerException

I wrapper possono essere `null`, il che richiede attenzione!

#### 7.1 Situazioni che Causano NullPointerException

**1. Unboxing di null:**
```java
Integer nullValue = null;
int primitive = nullValue;  // ✗ NullPointerException!
```

**2. Operazioni aritmetiche:**
```java
Integer a = null;
Integer b = 10;
Integer sum = a + b;  // ✗ NullPointerException! (unboxing di a)
```

**3. Chiamata metodi su null:**
```java
Integer value = null;
String str = value.toString();  // ✗ NullPointerException!
```

#### 7.2 Come Prevenire NullPointerException

**1. Controllo esplicito con if:**
```java
Integer maybeNull = getValue();
if (maybeNull != null) {
    int safe = maybeNull;  // Sicuro
}
```

**2. Operatore ternario:**
```java
Integer possiblyNull = getValue();
int safeValue = (possiblyNull != null) ? possiblyNull : 0;
```

**3. Uso di Optional (Java 8+):**
```java
Optional<Integer> optional = Optional.ofNullable(maybeNull);
int value = optional.orElse(0);  // Valore di default se null
```

#### 💡 BEST PRACTICES per Null Safety

- ✓ Inizializza sempre le variabili wrapper se possibile
- ✓ Controlla null prima di unboxing o operazioni
- ✓ Usa `Optional<T>` per rendere esplicita la possibilità di null
- ✓ Documenta con `@Nullable` e `@NonNull`
- ✓ Considera l'uso di primitivi se null non è necessario

---

### 8. Costanti e Metodi Utility

#### 8.1 Costanti MIN_VALUE e MAX_VALUE

```java
Byte.MIN_VALUE      // -128
Byte.MAX_VALUE      // 127
Integer.MIN_VALUE   // -2147483648
Integer.MAX_VALUE   // 2147483647
Long.MIN_VALUE      // -9223372036854775808
Long.MAX_VALUE      // 9223372036854775807
```

#### 8.2 Costanti per Dimensioni

```java
Integer.SIZE    // 32 bit
Long.SIZE       // 64 bit
Double.SIZE     // 64 bit

Integer.BYTES   // 4 byte
Long.BYTES      // 8 byte
Double.BYTES    // 8 byte
```

#### 8.3 Costanti Speciali per Floating Point

```java
Double.POSITIVE_INFINITY   // Infinito positivo
Double.NEGATIVE_INFINITY   // Infinito negativo
Double.NaN                 // Not a Number
Double.MIN_NORMAL          // Più piccolo valore normale
```

#### 8.4 Costanti Boolean

```java
Boolean.TRUE   // Oggetto singleton per true
Boolean.FALSE  // Oggetto singleton per false
```

#### 8.5 Metodi Utility - Verifica Valori Speciali

```java
Double.isNaN(0.0/0.0)        // true
Double.isInfinite(1.0/0.0)   // true
Double.isFinite(42.5)        // true
```

#### 8.6 Metodi Utility - Operazioni Matematiche

```java
Integer.max(10, 20)                          // 20
Integer.min(10, 20)                          // 10
Integer.sum(10, 20)                          // 30
Long.sum(1000000000L, 2000000000L)           // 3000000000
```

#### 8.7 Metodi Utility - Conversione di Segno

```java
Integer.signum(-42)   // -1 (negativo)
Integer.signum(0)     // 0 (zero)
Integer.signum(42)    // 1 (positivo)
Math.abs(-42)         // 42 (valore assoluto)
```

---

### 9. Metodi Specifici per Ogni Wrapper

#### 9.1 Character - Metodi per Caratteri

```java
Character.isLetter('A')           // true
Character.isDigit('5')            // true
Character.isUpperCase('A')        // true
Character.isLowerCase('a')        // true
Character.isWhitespace(' ')       // true
Character.toLowerCase('A')        // 'a'
Character.toUpperCase('a')        // 'A'
Character.isLetterOrDigit('A')    // true
Character.getNumericValue('5')    // 5
```

#### 9.2 Integer/Long - Operazioni Bitwise

```java
Integer.bitCount(42)              // Numero di bit a 1
Integer.highestOneBit(42)         // Bit più alto a 1
Integer.lowestOneBit(42)          // Bit più basso a 1
Integer.numberOfLeadingZeros(42)  // Zeri iniziali
Integer.numberOfTrailingZeros(42) // Zeri finali
Integer.reverse(42)               // Inverte i bit
Integer.rotateLeft(42, 2)         // Rotazione sinistra
```

#### 9.3 Integer/Long - Conversioni Unsigned

Java tratta gli interi come signed, ma fornisce metodi per unsigned:

```java
byte signedByte = -1;
int unsignedValue = Byte.toUnsignedInt(signedByte);  // 255
Integer.toUnsignedString(-1)                         // "4294967295"
```

#### 9.4 Double/Float - Conversioni Rappresentazione Binaria

```java
double d = 3.14;
long bits = Double.doubleToLongBits(d);      // Rappresentazione IEEE 754
double backToDouble = Double.longBitsToDouble(bits);  // Riconvertito
```

#### 9.5 Boolean - Logica

```java
Boolean.logicalAnd(true, false)   // false
Boolean.logicalOr(true, false)    // true
Boolean.logicalXor(true, false)   // true
```

---

### 10. Collections e Generics

**Questa è la RAGIONE PRINCIPALE per cui esistono i wrapper!**

Le Collections e i Generics accettano SOLO oggetti, non primitivi.

#### 10.1 Problema: Collections NON Accettano Primitivi

```java
// List<int> numbers = new ArrayList<>();  // ✗ ERRORE di compilazione!
```

#### 10.2 Soluzione: Usa i Wrapper

```java
List<Integer> numbers = new ArrayList<>();  // ✓ OK!
numbers.add(10);   // Autoboxing automatico
numbers.add(20);
numbers.add(30);

int first = numbers.get(0);  // Unboxing automatico
```

#### 10.3 Operazioni su Collections

```java
// Somma di tutti gli elementi
int sum = 0;
for (Integer num : numbers) {  // Unboxing in ogni iterazione
    sum += num;
}

// Con Stream (Java 8+)
int sumWithStream = numbers.stream()
                          .mapToInt(Integer::intValue)
                          .sum();
```

#### 10.4 Collections con Altri Wrapper

```java
List<Double> prices = new ArrayList<>();
prices.add(19.99);
prices.add(29.99);

List<Boolean> flags = new ArrayList<>();
flags.add(true);
flags.add(false);
```

#### 10.5 null in Collections

```java
List<Integer> numbersWithNull = new ArrayList<>();
numbersWithNull.add(10);
numbersWithNull.add(null);  // Valido!
numbersWithNull.add(30);

// ⚠️ ATTENZIONE quando si itera:
for (Integer num : numbersWithNull) {
    if (num != null) {
        int value = num * 2;  // Sicuro
    }
}
```

#### ⚠️ Performance con Collections

- Ogni elemento è un OGGETTO (maggiore uso di memoria)
- Overhead di autoboxing/unboxing
- Possibili NullPointerException

**Alternative per performance critiche:**
- Array primitivi: `int[]` invece di `List<Integer>`
- Stream specializzati: `IntStream`, `LongStream`, `DoubleStream`
- Librerie specializzate (es. Trove, FastUtil)

---

### 11. Performance: Wrapper vs Primitivi

I wrapper hanno un COSTO rispetto ai primitivi.

#### 11.1 Differenze di Memoria

| Tipo | Primitivo | Wrapper | Overhead |
|------|-----------|---------|----------|
| boolean | ~1 bit | ~16 byte | ~128x |
| byte | 1 byte | ~16 byte | ~16x |
| short | 2 byte | ~16 byte | ~8x |
| char | 2 byte | ~16 byte | ~8x |
| int | 4 byte | ~16 byte | ~4x |
| float | 4 byte | ~16 byte | ~4x |
| long | 8 byte | ~24 byte | ~3x |
| double | 8 byte | ~24 byte | ~3x |

L'overhead include:
- Header dell'oggetto (8-12 byte)
- Il valore primitivo
- Padding per allineamento memoria

#### 11.2 Differenze di Performance

Autoboxing/unboxing hanno un costo:
- Allocazione oggetti (memoria heap)
- Garbage collection
- Accesso indiretto (dereferenziazione puntatore)

**Esempio:** Somma di 1.000.000 di numeri
- **Primitivi**: ~2-5 ms
- **Wrapper** (con autoboxing): ~10-50 ms (2-10x più lenti)

#### 11.3 Quando Usare Primitivi

✓ Usa PRIMITIVI quando:
- Performance è critica (loop intensivi, calcoli matematici)
- Array grandi di numeri (`int[]`, `double[]` invece di `List`)
- Variabili locali in metodi (non serve null)
- Campi di classe dove null non ha senso

#### 11.4 Quando Usare Wrapper

✓ Usa WRAPPER quando:
- Necessario per Collections (`List<Integer>`, `Set<Double>`)
- Necessario per Generics (`<T>` deve essere tipo riferimento)
- Il valore può essere null (rappresenta assenza di valore)
- Servono metodi utility (`Integer.parseInt`, `Double.isNaN`)
- Serializzazione/deserializzazione

---

### 12. Best Practices Professionali

#### 12.1 Creazione di Wrapper

```java
// ✓ USA valueOf() invece del costruttore
Integer good = Integer.valueOf(42);     // Usa la cache
// Integer bad = new Integer(42);       // ✗ DEPRECATO

// ✓ Autoboxing è OK per leggibilità
Integer auto = 42;  // Chiaro e conciso
```

#### 12.2 Confronto di Valori

```java
// ✓ USA .equals() per confrontare valori
Integer a = 1000, b = 1000;
if (a.equals(b)) { ... }      // ✓ CORRETTO
if (a == b) { ... }           // ✗ SBAGLIATO

// ✓ Per ordinamento, usa .compareTo()
if (a.compareTo(b) < 0) { ... }  // a è minore di b
```

#### 12.3 Null Safety

```java
// ✓ CONTROLLA sempre null prima di unboxing
Integer value = getValue();
if (value != null) {
    int primitive = value;
}

// ✓ USA Optional
Optional<Integer> optional = Optional.ofNullable(value);
int result = optional.orElse(0);
```

#### 12.4 Collections

```java
// ✓ Per Collections, i wrapper sono necessari
List<Integer> numbers = new ArrayList<>();

// ✓ Per array grandi, considera primitivi
int[] bigArray = new int[1_000_000];
```

#### 12.5 Performance

```java
// ✗ LENTO - autoboxing/unboxing in loop
Long sum = 0L;
for (int i = 0; i < 1_000_000; i++) {
    sum += i;  // Unboxing + autoboxing ogni iterazione!
}

// ✓ VELOCE - solo primitivi
long sum = 0;
for (int i = 0; i < 1_000_000; i++) {
    sum += i;  // Nessun boxing
}
```

#### 12.6 Parsing e Conversioni

```java
// ✓ GESTISCI sempre NumberFormatException
try {
    int value = Integer.parseInt(userInput);
} catch (NumberFormatException e) {
    System.out.println("Input non valido!");
}
```

#### 12.7 Scelta tra Primitivo e Wrapper

| Situazione | Primitivo | Wrapper |
|------------|-----------|---------|
| Variabile locale | ✓ | |
| Parametro metodo | ✓ | |
| Campo classe (non-null) | ✓ | |
| Campo classe (nullable) | | ✓ |
| Ritorno metodo (non-null) | ✓ | |
| Ritorno metodo (nullable) | | ✓ |
| Collections/Generics | | ✓ |
| Array grandi | ✓ | |
| Calcoli intensivi | ✓ | |
| Serializzazione JSON | | ✓ |

#### 💡 REGOLA D'ORO FINALE

- **Preferisci PRIMITIVI per default** (più semplici, più veloci)
- **Usa WRAPPER quando:**
  - Necessario per il linguaggio (Collections, Generics)
  - null ha un significato semantico ("valore assente")
  - Servono metodi utility delle classi wrapper

---

## Esecuzione della Demo

Per eseguire la demo dei tipi wrapper:

1. Avvia l'applicazione:
   ```bash
   mvn exec:java
   ```

2. Seleziona dal menu: **[2] Tipi Wrapper**

3. La demo mostrerà tutte le 12 sezioni in sequenza con esempi pratici e output formattato

---

## Output della Demo

La demo produce output formattato con:
- 📦 Intestazioni e sezioni chiare
- 💡 Esempi di codice con risultati
- ⚠️ Warning e note importanti
- ✓ Best practices e consigli
- Tabelle comparative

Ogni sezione include spiegazioni dettagliate in italiano e attende che l'utente prema INVIO prima di procedere alla sezione successiva.

---

## Note Tecniche

- **Package**: `com.corso.samples.datatypes`
- **Classe**: `WrapperTypesDemo`
- **Metodo principale**: `public static void run()`
- **Commenti**: In italiano, dettagliati e didattici
- **Formato output**: Console con formattazione Unicode
- **Dipendenze**: Solo JDK standard (java.util.ArrayList, java.util.List)

---

## Riferimenti

Per approfondimenti, consulta:
- [Java Language Specification - Wrapper Classes](https://docs.oracle.com/javase/specs/jls/se21/html/jls-5.html#jls-5.1.7)
- [Java Tutorial - Autoboxing and Unboxing](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html)
- [Java API Documentation - Integer](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Integer.html)

---

**Ultima modifica**: 22 febbraio 2026  
**Versione Java**: 21  
**Autore**: Java 21 Course
