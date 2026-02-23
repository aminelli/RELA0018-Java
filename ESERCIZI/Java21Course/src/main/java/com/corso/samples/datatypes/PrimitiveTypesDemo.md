# PrimitiveTypesDemo - Documentazione

## Panoramica

La classe `PrimitiveTypesDemo` è una demo completa e dettagliata per l'apprendimento dei **tipi primitivi** in Java. Fornisce esempi pratici, spiegazioni approfondite e best practices per tutti gli 8 tipi primitivi del linguaggio Java.

---

## Tipi Primitivi in Java

Java fornisce **8 tipi primitivi fondamentali** divisi in 4 categorie:

| Categoria | Tipi |
|-----------|------|
| **Interi** | `byte`, `short`, `int`, `long` |
| **Virgola Mobile** | `float`, `double` |
| **Caratteri** | `char` |
| **Booleani** | `boolean` |

I tipi primitivi sono memorizzati direttamente nello stack (non nell'heap come gli oggetti), rendendoli più efficienti in termini di memoria e performance.

---

## Sezioni della Demo

### 1. Tipi Interi

Questa sezione copre tutti i tipi interi disponibili in Java.

#### 1.1 BYTE - 8 bit con segno
- **Dimensione**: 8 bit (1 byte)
- **Range**: da -128 a 127
- **Uso tipico**: Ottimizzare memoria con grandi array di piccoli numeri
- **Esempio**: `byte age = 42;`

#### 1.2 SHORT - 16 bit con segno
- **Dimensione**: 16 bit (2 byte)
- **Range**: da -32,768 a 32,767
- **Uso tipico**: Ottimizzare memoria, raramente usato nella pratica
- **Esempio**: `short year = 1_000;`
- **Nota**: Supporto per underscore nei letterali per maggiore leggibilità

#### 1.3 INT - 32 bit con segno
- **Dimensione**: 32 bit (4 byte)
- **Range**: da -2,147,483,648 a 2,147,483,647
- **Uso tipico**: **TIPO PREDEFINITO** per tutti i numeri interi
- **Esempio**: `int population = 1_000_000;`
- **Nota**: Se scrivi `100`, Java lo interpreta come `int`

#### 1.4 LONG - 64 bit con segno
- **Dimensione**: 64 bit (8 byte)
- **Range**: da -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
- **Uso tipico**: Timestamp, grandi quantità, calcoli finanziari
- **Esempio**: `long worldPopulation = 9_000_000_000L;`
- **⚠️ IMPORTANTE**: Usa il suffisso `L` per i letterali long!

#### 1.5 Operazioni Aritmetiche sui Tipi Interi
Esempi pratici di:
- Addizione, sottrazione, moltiplicazione
- **Divisione intera** (10 / 3 = 3, non 3.33)
- Operatore modulo (resto della divisione)

---

### 2. Tipi a Virgola Mobile

Questa sezione esplora i tipi decimali con lo standard IEEE 754.

#### 2.1 FLOAT - 32 bit, precisione singola
- **Dimensione**: 32 bit (4 byte)
- **Precisione**: ~6-7 cifre decimali
- **Uso tipico**: Grafica 3D, gaming (per risparmiare memoria)
- **Esempio**: `float pi = 3.14159F;`
- **⚠️ IMPORTANTE**: Usa il suffisso `F` per i letterali float!
- Supporta notazione scientifica: `1.23e-4F`

#### 2.2 DOUBLE - 64 bit, precisione doppia
- **Dimensione**: 64 bit (8 byte)
- **Precisione**: ~15-16 cifre decimali
- **Uso tipico**: **TIPO PREDEFINITO** per numeri decimali
- **Esempio**: `double pi = 3.141592653589793;`
- **Nota**: Se scrivi `3.14`, Java lo interpreta come `double`
- Supporta notazione scientifica: `6.022e23`

#### 2.3 Operazioni e Valori Speciali
- Divisione decimale (10.0 / 3.0 = 3.333...)
- Funzioni matematiche: `Math.sqrt()`, `Math.pow()`
- **Valori speciali**:
  - `Infinity` (1.0 / 0.0)
  - `-Infinity` (-1.0 / 0.0)
  - `NaN` - Not a Number (0.0 / 0.0)
- **⚠️ Problemi di precisione**: 0.1 + 0.2 ≠ 0.3
- Soluzione: Usa epsilon per confronti

---

### 3. Tipo CHAR

Il tipo `char` rappresenta singoli caratteri Unicode.

#### 3.1 Caratteristiche Principali
- **Dimensione**: 16 bit (2 byte)
- **Range**: 0 a 65,535 (Unicode)
- **Tipo**: UNSIGNED (solo valori positivi)
- **Modi di inizializzazione**:
  - Letterale: `char letter = 'A';`
  - Unicode: `char letter = '\u0041';`
  - Numerico: `char letter = 65;`

#### 3.2 Caratteri Speciali (Escape Sequences)
- `\n` - Newline (a capo)
- `\t` - Tab (tabulazione)
- `\r` - Carriage return
- `\\` - Backslash
- `\'` - Apice singolo
- `\"` - Apice doppio

#### 3.3 Operazioni sui CHAR
- Conversione a codice ASCII/Unicode: `(int)ch`
- Verifica tipo carattere: `Character.isLetter()`, `Character.isDigit()`
- Conversioni maiuscolo/minuscolo: `Character.toUpperCase()`, `Character.toLowerCase()`
- **⚠️ NOTA**: char può partecipare ad operazioni aritmetiche

---

### 4. Tipo BOOLEAN

Il tipo `boolean` rappresenta valori logici.

#### 4.1 Caratteristiche Principali
- **Dimensione**: Non specificata (dipende dalla JVM, tipicamente 1 bit logico)
- **Valori**: Solo `true` o `false`
- **Uso tipico**: Controllo di flusso, condizioni, flag

#### 4.2 Operatori Logici
- `&&` - AND logico (vero se entrambi veri)
- `||` - OR logico (vero se almeno uno è vero)
- `!` - NOT logico (inverte il valore)
- `^` - XOR logico (vero se diversi)

#### 4.3 Short-Circuit Evaluation
- Con `&&`: se il primo è false, il secondo non viene valutato
- Con `||`: se il primo è true, il secondo non viene valutato
- **Esempio pratico**: `if (obj != null && obj.isValid())`

#### 4.4 Operatori di Confronto
- `==` - Uguale
- `!=` - Diverso
- `>` - Maggiore
- `<` - Minore
- `>=` - Maggiore o uguale
- `<=` - Minore o uguale

---

### 5. Conversioni tra Tipi (Casting)

Questa sezione spiega le conversioni tra tipi primitivi.

#### 5.1 WIDENING Conversion (Implicita)
**Gerarchia**: byte → short → int → long → float → double

- Conversione automatica (sicura)
- Nessuna perdita di informazione garantita
- **Esempio**: `byte b = 10; int i = b; // Automatico`

#### 5.2 NARROWING Conversion (Esplicita)
- Richiede cast esplicito: `(tipoDestinazione) variabile`
- Può causare perdita di dati
- **Esempio**: `double d = 123.456; int i = (int)d; // i = 123`
- **⚠️ Overflow**: Se il valore eccede il range del tipo destinazione

#### 5.3 Casting con Espressioni
- Le operazioni tra interi producono almeno un `int`
- **Esempio**: `byte b1 = 10, b2 = 20; byte b3 = (byte)(b1 + b2);`

---

### 6. Wrapper Classes

Ogni tipo primitivo ha una classe wrapper corrispondente.

#### 6.1 Corrispondenze Wrapper

| Primitivo | Wrapper Class |
|-----------|---------------|
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` ⚠️ |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `char` | `Character` ⚠️ |
| `boolean` | `Boolean` |

#### 6.2 Autoboxing e Unboxing
- **Autoboxing**: Conversione automatica da primitivo a wrapper
- **Unboxing**: Conversione automatica da wrapper a primitivo
- **Esempio**: `Integer wrapper = 42; int primitive = wrapper;`

#### 6.3 Metodi Utili
- `Integer.parseInt("123")` - Parsing da stringa
- `Integer.toString(456)` - Conversione a stringa
- `Integer.MIN_VALUE`, `Integer.MAX_VALUE` - Costanti
- `Integer.compare(10, 20)` - Confronto valori
- `Double.isNaN()`, `Double.isInfinite()` - Verifica valori speciali

#### 6.4 ⚠️ Attenzione con i Wrapper
- I wrapper sono OGGETTI, non primitivi
- Usano più memoria
- Possono essere `null`
- Con `==` confrontano riferimenti, non valori!
- **Cache interna**: valori da -128 a 127 sono messi in cache
- **⚠️ USA sempre `.equals()` per confrontare wrapper!**

---

### 7. Letterali

I letterali sono valori costanti scritti direttamente nel codice.

#### 7.1 Letterali Interi
**Basi numeriche supportate**:
- Decimale: `100`
- Binario: `0b1100100` (prefisso `0b`)
- Ottale: `0144` (prefisso `0`)
- Esadecimale: `0x64` (prefisso `0x`)

**Underscore per leggibilità** (Java 7+):
- `int million = 1_000_000;`
- `long creditCard = 1234_5678_9012_3456L;`
- `int binary = 0b0001_0010_0011_0100;`

#### 7.2 Letterali Decimali
- Notazione standard: `3.14`
- Con suffisso D (opzionale): `3.14D`
- Notazione scientifica: `314e-2` (314 × 10⁻²)
- Float (suffisso F obbligatorio): `3.14F`
- **Nota**: Senza suffisso, i decimali sono `double` per default

#### 7.3 Letterali Carattere
- Carattere singolo: `'A'`
- Unicode: `'\u0041'`
- Valore numerico: `65`
- Escape sequence: `'\n'`

#### 7.4 Letterali Booleani
- `true`
- `false`
- Solo minuscoli!

---

### 8. Overflow e Underflow

Comportamento quando un valore supera i limiti di un tipo.

#### 8.1 Overflow Intero
- `Integer.MAX_VALUE + 1` → `Integer.MIN_VALUE`
- Il valore "ricomincia" dal minimo
- **⚠️ Java NON genera eccezioni** per overflow!

#### 8.2 Underflow Intero
- `Integer.MIN_VALUE - 1` → `Integer.MAX_VALUE`
- Il valore "ricomincia" dal massimo

#### 8.3 Overflow con Moltiplicazione
- **Esempio**: `1_000_000_000 * 3` causa overflow
- **Soluzione**: Usa `long` per valori grandi

#### 8.4 Prevenire Overflow
**Strategie**:
1. Usa tipi più grandi (`long` invece di `int`)
2. Controlla i limiti prima di operazioni
3. Usa `Math.addExact()`, `Math.multiplyExact()` (Java 8+)
   - Lanciano `ArithmeticException` in caso di overflow

---

### 9. Best Practices

Linee guida professionali per l'uso dei tipi primitivi.

#### 9.1 Scelta del Tipo Giusto
- ✓ Usa `int` per numeri interi generici (default)
- ✓ Usa `long` per timestamp, grandi quantità
- ✓ Usa `double` per decimali generici (default)
- ✓ Usa `float` solo se memoria è critica
- ✓ Usa `byte`/`short` solo per ottimizzare array grandi
- ✓ Usa `boolean` per flag e condizioni
- ✓ Usa `char` per singoli caratteri

#### 9.2 Dichiarazione e Inizializzazione
- ✓ SEMPRE inizializzare le variabili locali
- ✓ Usa nomi descrittivi: `int userAge` non `int x`
- ✓ Usa costanti per valori magici: `final int MAX_USERS = 100;`

#### 9.3 Operazioni e Conversioni
- ✓ Attenzione alle conversioni implicite
- ✓ Nelle divisioni, considera il tipo del risultato
- ✓ Usa suffissi per chiarezza: `1000000000L`, `3.14F`

#### 9.4 Confronti e Operazioni
- ✓ Per float/double, usa tolleranza (epsilon)
- ✓ Con wrapper, usa `.equals()` non `==`

#### 9.5 Performance e Memoria
- ✓ Primitivi sono più efficienti dei wrapper
- ✓ Usa wrapper quando:
  - Servono in Collections (`List<Integer>`)
  - Può essere `null`
  - Servono metodi utility (parsing, etc.)

#### 9.6 Naming Conventions
- ✓ Variabili: `camelCase` (`userAge`, `averageScore`)
- ✓ Costanti: `UPPER_SNAKE_CASE` (`MAX_SIZE`, `PI`)

---

## Esecuzione della Demo

Per eseguire la demo dei tipi primitivi:

1. Avvia l'applicazione:
   ```bash
   mvn exec:java
   ```

2. Seleziona dal menu: **[1] Tipi Primitivi**

3. La demo mostrerà tutte le sezioni in sequenza con esempi pratici e output formattato

---

## Output della Demo

La demo produce output formattato con:
- 📊 Intestazioni e sezioni chiare
- 💡 Esempi di codice con risultati
- ⚠️ Warning e note importanti
- ✓ Best practices e consigli

Ogni sezione include spiegazioni dettagliate in italiano per facilitare l'apprendimento.

---

## Note Tecniche

- **Package**: `com.corso.samples.datatypes`
- **Classe**: `PrimitiveTypesDemo`
- **Metodo principale**: `public static void run()`
- **Commenti**: In italiano, dettagliati e didattici
- **Formato output**: Console con formattazione Unicode

---

## Riferimenti

Per approfondimenti, consulta:
- [Java Language Specification - Primitive Types](https://docs.oracle.com/javase/specs/jls/se21/html/jls-4.html#jls-4.2)
- [Java Tutorial - Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [IEEE 754 Floating Point Standard](https://en.wikipedia.org/wiki/IEEE_754)

 
