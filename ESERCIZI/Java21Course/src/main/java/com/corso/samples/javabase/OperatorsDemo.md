# OperatorsDemo - Operatori e Type Casting in Java

## Panoramica

`OperatorsDemo` è una classe educational completa che esplora in dettaglio tutti gli **operatori** disponibili in Java e le tecniche di **type casting**. Questa demo copre operatori aritmetici, logici, bitwise, relazionali, di assegnamento, e le conversioni di tipo sia implicite che esplicite.

## Obiettivi di Apprendimento

Questa demo ti permette di comprendere:

1. **Operatori di Assegnamento** - Come assegnare valori alle variabili (=, +=, -=, ecc.)
2. **Operatori Aritmetici** - Operazioni matematiche (+, -, *, /, %)
3. **Operatori Unari** - Incremento, decremento, negazione (++, --, !, ~)
4. **Operatori Relazionali** - Confronti tra valori (==, !=, >, <, >=, <=)
5. **Operatori Logici** - Combinazione di condizioni (&&, ||, !)
6. **Operatori Bitwise** - Manipolazione bit per bit (&, |, ^, ~, <<, >>, >>>)
7. **Operatore Ternario** - Condizionale compatto (? :)
8. **Type Casting Implicito** - Widening casting automatico
9. **Type Casting Esplicito** - Narrowing casting con potenziale perdita di dati
10. **Type Casting con Oggetti** - Upcasting e downcasting in gerarchie
11. **Precedenza degli Operatori** - Ordine di valutazione nelle espressioni
12. **Best Practices** - Linee guida professionali per l'uso degli operatori

## Struttura della Demo

La classe è organizzata in **13 sezioni** progressive:

```
1. Introduzione agli Operatori
   - Definizione e classificazione
   - Operatori unari, binari, ternari
   - Categorie di operatori

2. Operatori di Assegnamento
   - Assegnamento semplice (=)
   - Assegnamenti composti (+=, -=, *=, /=, %=, ecc.)
   - Assegnamento multiplo

3. Operatori Aritmetici
   - Operatori base (+, -, *, /, %)
   - Divisione intera vs decimale
   - Divisione per zero
   - Operatore modulo
   - Operazioni con tipi misti

4. Operatori Unari
   - Incremento (++) - pre e post
   - Decremento (--) - pre e post
   - Plus unario (+) e minus unario (-)
   - NOT logico (!)
   - Complemento bitwise (~)

5. Operatori Relazionali
   - Confronto di uguaglianza (==, !=)
   - Confronti di ordine (>, <, >=, <=)
   - Uso nelle condizioni
   - == vs .equals()

6. Operatori Logici
   - AND logico (&&)
   - OR logico (||)
   - NOT logico (!)
   - Tabelle di verità
   - Short-circuit evaluation
   - Operatori bitwise logici (&, |, ^)

7. Operatori Bitwise
   - AND bitwise (&)
   - OR bitwise (|)
   - XOR bitwise (^)
   - NOT bitwise (~)
   - Left shift (<<)
   - Right shift (>>)
   - Unsigned right shift (>>>)
   - Casi d'uso pratici (flag, maschere)

8. Operatore Ternario
   - Sintassi: condizione ? vero : falso
   - Equivalenza con if-else
   - Esempi pratici
   - Ternari annidati
   - Best practices

9. Type Casting - Widening (Implicito)
   - Gerarchia dei tipi numerici
   - Conversioni automatiche
   - Promozione in espressioni
   - Vantaggi e limitazioni

10. Type Casting - Narrowing (Esplicito)
    - Sintassi del cast esplicito
    - Perdita di dati
    - Overflow e underflow
    - Cast sicuro con validazioni
    - Arrotondamento

11. Type Casting con Oggetti
    - Upcasting automatico (verso superclasse)
    - Downcasting esplicito (verso sottoclasse)
    - ClassCastException
    - Operatore instanceof
    - Best practices

12. Precedenza degli Operatori
    - Tabella di precedenza completa
    - Associatività (sinistra/destra)
    - Esempi di precedenza in azione
    - Uso delle parentesi

13. Best Practices
    - Chiarezza e leggibilità
    - Uso corretto di ++/--
    - Short-circuit evaluation
    - Operatore ternario
    - Type casting sicuro
    - Divisione
    - Confronti
```

## Tabelle di Riferimento

### Operatori di Assegnamento

| Operatore | Esempio    | Equivalente a |
|-----------|------------|---------------|
| =         | x = 5      | x = 5         |
| +=        | x += 3     | x = x + 3     |
| -=        | x -= 3     | x = x - 3     |
| *=        | x *= 3     | x = x * 3     |
| /=        | x /= 3     | x = x / 3     |
| %=        | x %= 3     | x = x % 3     |
| &=        | x &= 3     | x = x & 3     |
| \|=       | x \|= 3    | x = x \| 3    |
| ^=        | x ^= 3     | x = x ^ 3     |
| <<=       | x <<= 2    | x = x << 2    |
| >>=       | x >>= 2    | x = x >> 2    |
| >>>=      | x >>>= 2   | x = x >>> 2   |

### Operatori Aritmetici

| Operatore | Descrizione      | Esempio  | Risultato |
|-----------|------------------|----------|-----------|
| +         | Addizione        | 10 + 3   | 13        |
| -         | Sottrazione      | 10 - 3   | 7         |
| *         | Moltiplicazione  | 10 * 3   | 30        |
| /         | Divisione        | 10 / 3   | 3 (int)   |
| %         | Modulo (resto)   | 10 % 3   | 1         |

### Operatori Relazionali

| Operatore | Descrizione         | Esempio      | Risultato |
|-----------|---------------------|--------------|-----------|
| ==        | Uguale a            | 5 == 5       | true      |
| !=        | Diverso da          | 5 != 3       | true      |
| >         | Maggiore di         | 5 > 3        | true      |
| <         | Minore di           | 5 < 3        | false     |
| >=        | Maggiore o uguale   | 5 >= 5       | true      |
| <=        | Minore o uguale     | 5 <= 3       | false     |

### Operatori Logici

| Operatore | Descrizione | Esempio          | Risultato |
|-----------|-------------|------------------|-----------|
| &&        | AND logico  | true && false    | false     |
| \|\|      | OR logico   | true \|\| false  | true      |
| !         | NOT logico  | !true            | false     |

**Tabelle di Verità:**

**AND (&&):**
| A     | B     | A && B |
|-------|-------|--------|
| true  | true  | true   |
| true  | false | false  |
| false | true  | false  |
| false | false | false  |

**OR (||):**
| A     | B     | A \|\| B |
|-------|-------|----------|
| true  | true  | true     |
| true  | false | true     |
| false | true  | true     |
| false | false | false    |

### Operatori Bitwise

| Operatore | Descrizione                    | Esempio    | Descrizione dettagliata             |
|-----------|--------------------------------|------------|-------------------------------------|
| &         | AND bitwise                    | 5 & 3      | Bit a 1 dove entrambi sono 1        |
| \|        | OR bitwise                     | 5 \| 3     | Bit a 1 dove almeno uno è 1         |
| ^         | XOR bitwise                    | 5 ^ 3      | Bit a 1 dove sono diversi           |
| ~         | NOT bitwise (complemento)      | ~5         | Inverte tutti i bit                 |
| <<        | Left shift                     | 8 << 2     | Scorre bit a sinistra (×2^n)        |
| >>        | Right shift (con segno)        | 8 >> 2     | Scorre bit a destra (÷2^n)          |
| >>>       | Unsigned right shift           | -8 >>> 2   | Scorre a destra riempiendo con 0    |

**Esempio di operazioni bitwise:**
```
  5 & 3:
  0000 0101  (5)
& 0000 0011  (3)
  ---------
  0000 0001  (1)

  5 | 3:
  0000 0101  (5)
| 0000 0011  (3)
  ---------
  0000 0111  (7)

  5 ^ 3:
  0000 0101  (5)
^ 0000 0011  (3)
  ---------
  0000 0110  (6)
```

### Operatori Unari

| Operatore | Descrizione              | Esempio | Comportamento                          |
|-----------|--------------------------|---------|----------------------------------------|
| ++        | Incremento               | x++     | POST: usa valore, poi incrementa       |
| ++        | Pre-incremento           | ++x     | PRE: incrementa, poi usa valore        |
| --        | Decremento               | x--     | POST: usa valore, poi decrementa       |
| --        | Pre-decremento           | --x     | PRE: decrementa, poi usa valore        |
| +         | Plus unario              | +x      | Mantiene il segno positivo             |
| -         | Minus unario (negazione) | -x      | Inverte il segno                       |
| !         | NOT logico               | !flag   | Inverte il valore boolean              |
| ~         | Complemento bitwise      | ~5      | Inverte tutti i bit                    |

### Gerarchia Type Casting (Widening)

```
byte → short → int → long → float → double
       char  → int
```

**Widening (automatico):** Conversione da tipo più piccolo a tipo più grande
- Nessun cast esplicito richiesto
- Nessuna perdita di dati
- Sicuro

**Narrowing (esplicito):** Conversione da tipo più grande a tipo più piccolo
- Cast esplicito richiesto: `(targetType) value`
- Possibile perdita di dati
- Richiede attenzione

### Precedenza degli Operatori (dal più alto al più basso)

| Precedenza | Operatori                    | Associatività      |
|------------|------------------------------|--------------------|
| 1          | Postfix: x++, x--            | Sinistra → Destra  |
| 2          | Unari: ++x, --x, +, -, !, ~  | Destra → Sinistra  |
| 3          | Casting: (type)              | Destra → Sinistra  |
| 4          | Moltiplicativi: *, /, %      | Sinistra → Destra  |
| 5          | Additivi: +, -               | Sinistra → Destra  |
| 6          | Shift: <<, >>, >>>           | Sinistra → Destra  |
| 7          | Relazionali: <, >, <=, >=    | Sinistra → Destra  |
| 8          | Uguaglianza: ==, !=          | Sinistra → Destra  |
| 9          | AND bitwise: &               | Sinistra → Destra  |
| 10         | XOR bitwise: ^               | Sinistra → Destra  |
| 11         | OR bitwise: \|               | Sinistra → Destra  |
| 12         | AND logico: &&               | Sinistra → Destra  |
| 13         | OR logico: \|\|              | Sinistra → Destra  |
| 14         | Ternario: ? :                | Destra → Sinistra  |
| 15         | Assegnamento: =, +=, -=, ... | Destra → Sinistra  |

**Le parentesi () hanno sempre precedenza massima!**

## Esempi di Codice

### Operatori Aritmetici

```java
int a = 10;
int b = 3;

int sum = a + b;      // 13 (addizione)
int diff = a - b;     // 7  (sottrazione)
int prod = a * b;     // 30 (moltiplicazione)
int quot = a / b;     // 3  (divisione intera - tronca!)
int mod = a % b;      // 1  (modulo/resto)

// Divisione decimale
double decQuot = 10.0 / 3;  // 3.333... (almeno un operando double)
```

### Incremento e Decremento

```java
int x = 5;

// Post-incremento
int y = x++;  // y = 5, x = 6 (usa il valore, poi incrementa)

// Pre-incremento
int z = ++x;  // z = 7, x = 7 (incrementa, poi usa il valore)

// Post-decremento
int w = x--;  // w = 7, x = 6 (usa il valore, poi decrementa)

// Pre-decremento
int v = --x;  // v = 5, x = 5 (decrementa, poi usa il valore)
```

### Operatori Logici e Short-Circuit

```java
boolean a = true;
boolean b = false;

boolean and = a && b;   // false (AND - entrambi devono essere true)
boolean or = a || b;    // true  (OR - almeno uno deve essere true)
boolean not = !a;       // false (NOT - inverte il valore)

// Short-circuit evaluation
boolean result1 = false && expensiveMethod();  // expensiveMethod() NON chiamato
boolean result2 = true || expensiveMethod();   // expensiveMethod() NON chiamato

// Uso pratico con null safety
if (obj != null && obj.isValid()) {  // Sicuro: se obj è null, obj.isValid() non viene valutato
    // ...
}
```

### Operatori Bitwise

```java
int a = 5;   // 0000 0101
int b = 3;   // 0000 0011

int and = a & b;   // 0000 0001 = 1 (bit a 1 dove entrambi sono 1)
int or = a | b;    // 0000 0111 = 7 (bit a 1 dove almeno uno è 1)
int xor = a ^ b;   // 0000 0110 = 6 (bit a 1 dove sono diversi)
int not = ~a;      // 1111 1010 = -6 (inverte tutti i bit)

// Shift operations
int leftShift = 8 << 2;    // 32  (8 * 2^2 = 8 * 4)
int rightShift = 8 >> 2;   // 2   (8 / 2^2 = 8 / 4)

// Caso d'uso: flag
final int READ = 1 << 0;    // 0001 = 1
final int WRITE = 1 << 1;   // 0010 = 2
final int EXEC = 1 << 2;    // 0100 = 4

int perms = READ | WRITE;   // Combina flag
boolean canRead = (perms & READ) != 0;   // Verifica flag
```

### Operatore Ternario

```java
int a = 10;
int b = 5;

// Forma base: condizione ? valore_se_vero : valore_se_falso
int max = (a > b) ? a : b;  // 10

// Equivalente a:
int max;
if (a > b) {
    max = a;
} else {
    max = b;
}

// Altri esempi
String parity = (num % 2 == 0) ? "pari" : "dispari";
String grade = (score >= 60) ? "Promosso" : "Bocciato";
int abs = (value >= 0) ? value : -value;

// Ternari annidati (attenzione alla leggibilità!)
String level = (points >= 90) ? "A" :
               (points >= 80) ? "B" :
               (points >= 70) ? "C" : "D";
```

### Type Casting - Widening (Automatico)

```java
// Gerarchia: byte → short → int → long → float → double

byte byteVal = 100;
int intVal = byteVal;        // Automatico, nessun cast

int intVal2 = 1000;
long longVal = intVal2;      // Automatico

long longVal2 = 100000L;
float floatVal = longVal2;   // Automatico

float floatVal2 = 3.14F;
double doubleVal = floatVal2;  // Automatico

// Promozione in espressioni
byte b = 10;
int i = 20;
long l = 30L;
long result = b + i + l;  // byte e int promossi a long
```

### Type Casting - Narrowing (Esplicito)

```java
// Cast esplicito richiesto: (targetType) value

double d = 9.78;
int i = (int) d;  // 9 (parte decimale TRONCATA!)

long l = 100L;
int i2 = (int) l;  // 100 (OK, dentro range int)

int i3 = 128;
byte b = (byte) i3;  // -128 (OVERFLOW! fuori range byte: -128 to 127)

// Cast sicuro con validazione
long valueLong = 100L;
if (valueLong >= Integer.MIN_VALUE && valueLong <= Integer.MAX_VALUE) {
    int safeInt = (int) valueLong;  // Sicuro
}

// Arrotondamento invece di troncamento
double decimal = 9.7;
int rounded = (int) Math.round(decimal);  // 10 (arrotondato)
```

### Type Casting con Oggetti

```java
// Upcasting (automatico)
Integer intObj = 100;
Number numObj = intObj;   // Upcasting automatico Integer → Number
Object objObj = intObj;   // Upcasting automatico Integer → Object

// Downcasting (esplicito, richiede instanceof)
Object obj = "Hello";

if (obj instanceof String) {
    String str = (String) obj;  // Sicuro
    System.out.println(str.toUpperCase());
}

// Downcasting errato causa ClassCastException
Object obj2 = "Hello";
try {
    Integer wrong = (Integer) obj2;  // ClassCastException!
} catch (ClassCastException e) {
    System.out.println("Cast non valido!");
}
```

### Precedenza degli Operatori

```java
// L'ordine di valutazione segue la precedenza
int result1 = 2 + 3 * 4;      // 14 (prima *, poi +)
int result2 = (2 + 3) * 4;    // 20 (parentesi hanno precedenza)

int result3 = 10 + 5 * 2;     // 20 (5 * 2 = 10, poi 10 + 10)
int result4 = 2 + 3 * 4 / 2 - 1;  // 7
// Passo 1: 3 * 4 = 12
// Passo 2: 12 / 2 = 6
// Passo 3: 2 + 6 = 8
// Passo 4: 8 - 1 = 7

// Confronti e logica
boolean result5 = 5 > 3 && 10 < 20;  // true (prima >, <, poi &&)

// Assegnamento (destra → sinistra)
int a, b, c;
a = b = c = 10;  // Valutato da destra: c=10, b=10, a=10
```

## Best Practices

### 1. Chiarezza e Leggibilità

✅ **Usa parentesi per chiarire la precedenza:**
```java
result = (a + b) * (c - d);  // ✓ Chiaro
result = a + b * c - d;      // ✗ Ambiguo
```

✅ **Usa spazi attorno agli operatori binari:**
```java
x = a + b;   // ✓ Leggibile
x=a+b;       // ✗ Difficile da leggere
```

### 2. Incremento/Decremento

✅ **Usa ++ e -- in istruzioni separate quando possibile:**
```java
x++;     // ✓ Chiaro
y = x;   // ✓ Chiaro
```

✗ **Evita uso complesso in espressioni:**
```java
y = x++ + ++x;  // ✗ Confuso e prono a errori
```

### 3. Operatori Logici

✅ **Usa && e || (short-circuit) invece di & e |:**
```java
if (obj != null && obj.isValid()) { ... }  // ✓ Sicuro
if (obj != null & obj.isValid()) { ... }   // ✗ NPE se obj è null!
```

✅ **Usa ! per negare boolean:**
```java
if (!flag) { ... }        // ✓ Idiomatico
if (flag == false) { ... } // ✗ Verboso
```

### 4. Operatore Ternario

✅ **Usa per assegnazioni condizionali semplici:**
```java
String status = (age >= 18) ? "adult" : "minor";  // ✓ OK
```

✗ **Evita ternari annidati complessi:**
```java
value = a > b ? c > d ? e : f : g > h ? i : j;  // ✗ Illeggibile
```

### 5. Type Casting

✅ **Verifica il range prima di narrowing:**
```java
if (longVal <= Integer.MAX_VALUE && longVal >= Integer.MIN_VALUE) {
    int intVal = (int) longVal;  // ✓ Sicuro
}
```

✅ **Usa instanceof prima di downcasting oggetti:**
```java
if (obj instanceof String) {
    String str = (String) obj;  // ✓ Sicuro
}
```

### 6. Divisione

✅ **Attenzione alla divisione intera vs decimale:**
```java
double result = 10 / 3;      // ✗ 3.0 (divisione intera!)
double result = 10.0 / 3;    // ✓ 3.333...
```

✅ **Controlla divisione per zero per interi:**
```java
if (divisor != 0) {
    result = dividend / divisor;
}
```

### 7. Confronti

✅ **Usa .equals() per confrontare oggetti:**
```java
if (str1.equals(str2)) { ... }  // ✓ Confronta contenuti
if (str1 == str2) { ... }       // ✗ Confronta riferimenti
```

✅ **Usa == solo per primitivi e controlli null:**
```java
if (obj == null) { ... }  // ✓ OK
if (count == 0) { ... }   // ✓ OK (primitivo)
```

### Regola d'Oro

> **"Il codice si legge MOLTO PIÙ spesso di quanto si scrive.  
> Scrivi per chiarezza, non per brevità estrema."**

- ✅ Codice **LEGGIBILE** > Codice **BREVE**
- ✅ Codice **CHIARO** > Codice **"FURBO"**
- ✅ Codice **MANUTENIBILE** > Codice **"COMPATTO"**

## Come Eseguire la Demo

### Da Menu Interattivo

1. Compila il progetto:
   ```bash
   mvn clean compile
   ```

2. Esegui l'applicazione:
   ```bash
   mvn exec:java
   ```

3. Seleziona l'opzione **[4] Operatori** dal menu

### Esecuzione Diretta (da Codice)

```java
import com.corso.samples.datatypes.OperatorsDemo;

public class Test {
    public static void main(String[] args) {
        OperatorsDemo.run();
    }
}
```

## Struttura del Codice

```java
public class OperatorsDemo {
    public static void run() {
        // Orchestrator principale che esegue tutte le sezioni
    }
    
    private static void demoIntroduction() { ... }
    private static void demoAssignmentOperators() { ... }
    private static void demoArithmeticOperators() { ... }
    private static void demoUnaryOperators() { ... }
    private static void demoRelationalOperators() { ... }
    private static void demoLogicalOperators() { ... }
    private static void demoBitwiseOperators() { ... }
    private static void demoTernaryOperator() { ... }
    private static void demoWideningCasting() { ... }
    private static void demoNarrowingCasting() { ... }
    private static void demoObjectCasting() { ... }
    private static void demoOperatorPrecedence() { ... }
    private static void demoBestPractices() { ... }
    
    // Utility methods per formattazione
    private static void printHeader(String title) { ... }
    private static void printSection(String sectionTitle) { ... }
    private static void printSubSection(String subSectionTitle) { ... }
    private static void printFooter() { ... }
    private static void waitForEnter() { ... }
}
```

## Concetti Chiave

### Short-Circuit Evaluation

Gli operatori `&&` e `||` utilizzano la valutazione cortocircuitata:
- **&&**: Se il primo operando è `false`, il secondo non viene valutato (il risultato sarà comunque `false`)
- **||**: Se il primo operando è `true`, il secondo non viene valutato (il risultato sarà comunque `true`)

```java
boolean result1 = false && expensiveMethod();  // expensiveMethod() NON chiamato
boolean result2 = true || expensiveMethod();   // expensiveMethod() NON chiamato
```

### Overflow e Underflow

Quando un valore supera il range del tipo, si verifica overflow (o underflow):

```java
int maxInt = Integer.MAX_VALUE;  // 2147483647
int overflow = maxInt + 1;       // -2147483648 (overflow!)

byte b = 127;    // Max byte
b++;             // -128 (overflow!)

int big = 200;
byte small = (byte) big;  // -56 (overflow!)
```

### Divisione Intera vs Decimale

La divisione tra due interi produce un risultato intero (troncato):

```java
int result1 = 10 / 3;      // 3 (troncato!)
double result2 = 10 / 3;   // 3.0 (ancora divisione intera!)
double result3 = 10.0 / 3; // 3.333... (divisione decimale)
```

## Riferimenti

- [Java Language Specification - Operators](https://docs.oracle.com/javase/specs/jls/se21/html/jls-15.html)
- [Java Tutorials - Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
- [Effective Java (3rd Edition) - Item 60: Avoid float and double if exact answers are required](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- [Java Operator Precedence Table](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)

## Note Importanti

⚠️ **Divisione per Zero:**
- Con interi: causa `ArithmeticException`
- Con floating-point: produce `Infinity` o `NaN`

⚠️ **Type Casting:**
- Widening: sempre sicuro, automatico
- Narrowing: richiede cast esplicito, può perdere dati

⚠️ **Operatori Bitwise:**
- Utili per operazioni a basso livello
- Usali con cautela: riducono la leggibilità

⚠️ **Precedenza:**
- Usa parentesi per chiarezza, anche se non necessarie

## Contenuto Correlato

- **PrimitiveTypesDemo**: Tipi primitivi su cui operano gli operatori
- **WrapperTypesDemo**: Oggetti wrapper e conversioni
- **LiteralsDemo**: Letterali usati nelle espressioni con operatori

---

**Autore:** Java 21 Course  
**Versione:** 1.0  
**Ultima modifica:** 2024
