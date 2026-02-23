# BigDecimal e BigInteger - Demo Completa

## 📋 Panoramica

Questo modulo fornisce una guida completa e pratica all'utilizzo di **BigDecimal** e **BigInteger** in Java, due classi fondamentali per calcoli con precisione arbitraria.

### Perché BigDecimal e BigInteger?

I tipi primitivi Java hanno limitazioni importanti:

- **Range limitato**: `int`, `long` hanno valori massimi/minimi
- **Imprecisione floating-point**: `double` e `float` causano errori di arrotondamento
  - Esempio: `0.1 + 0.2 = 0.30000000000000004` (NON 0.3!)
  - **Inaccettabile** per calcoli finanziari/monetari

**BigDecimal** e **BigInteger** risolvono questi problemi:
- ✅ Precisione **arbitraria** (limitata solo dalla memoria)
- ✅ **Immutabili** (thread-safe)
- ✅ **Sicure** (nessun overflow, precisione esatta)
- ❌ Performance inferiore rispetto ai primitivi

---

## 🎯 Obiettivi di Apprendimento

Al termine di questa demo, sarai in grado di:

1. ✅ Capire **quando** usare BigDecimal e BigInteger
2. ✅ Creare istanze **correttamente** (critico per BigDecimal!)
3. ✅ Eseguire operazioni aritmetiche con precisione arbitraria
4. ✅ Utilizzare RoundingMode appropriati per divisioni
5. ✅ Confrontare BigDecimal e BigInteger correttamente
6. ✅ Gestire scale e precision in BigDecimal
7. ✅ Applicare best practices professionali
8. ✅ Comprendere trade-off di performance

---

## 📚 Struttura della Demo

La demo è organizzata in **12 sezioni complete**:

### **BIGINTEGER (Sezioni 2-5)**
1. **Introduzione e Motivazione** - Perché usarli
2. **BigInteger - Creazione** - Modi per creare BigInteger
3. **BigInteger - Operazioni Aritmetiche** - add, subtract, multiply, divide
4. **BigInteger - Operazioni Avanzate** - pow, gcd, modPow, isProbablePrime
5. **BigInteger - Comparazioni e Conversioni** - compareTo, conversioni

### **BIGDECIMAL (Sezioni 6-10)**
6. **BigDecimal - Creazione (CRITICO!)** - String vs double
7. **BigDecimal - Operazioni Aritmetiche** - add, subtract, multiply, divide
8. **BigDecimal - Scale e Precision** - Concetti fondamentali
9. **BigDecimal - Rounding Modes** - Modalità di arrotondamento
10. **BigDecimal - Comparazioni** - equals vs compareTo

### **PRATICA (Sezioni 11-12)**
11. **Performance e Considerazioni Pratiche** - Quando usarli
12. **Best Practices** - Checklist professionale

---

## 🔢 BigInteger

### Quando Usare BigInteger

- ✅ Numeri interi oltre il range di `long` (> 9,223,372,036,854,775,807)
- ✅ Fattoriali grandi, numeri di Fibonacci
- ✅ Combinatoria, teoria dei numeri
- ✅ Crittografia (chiavi, modular exponentiation)
- ✅ Calcoli matematici con interi molto grandi

### Creazione di BigInteger

| Metodo | Esempio | Note |
|--------|---------|------|
| Da String | `new BigInteger("12345678901234567890")` | ✅ Per numeri grandi |
| valueOf | `BigInteger.valueOf(1000000L)` | ✅ Da long (caching) |
| Costanti | `BigInteger.ZERO`, `ONE`, `TWO`, `TEN` | ✅ Riutilizza |
| Da byte array | `new BigInteger(bytes)` | Per rappresentazione binaria |
| Random | `new BigInteger(128, new Random())` | Numero random N-bit |

### Operazioni Aritmetiche BigInteger

```java
BigInteger a = new BigInteger("1000000000000000000000");
BigInteger b = new BigInteger("500000000000000000000");

// Operazioni base
BigInteger sum = a.add(b);           // Addizione
BigInteger diff = a.subtract(b);     // Sottrazione
BigInteger prod = a.multiply(b);     // Moltiplicazione
BigInteger quot = a.divide(b);       // Divisione (solo quoziente)
BigInteger mod = a.mod(b);           // Modulo/Resto

// Divisione con resto
BigInteger[] divRem = a.divideAndRemainder(b);
// divRem[0] = quoziente
// divRem[1] = resto

// Altri operatori
BigInteger neg = a.negate();         // Negazione
BigInteger abs = a.abs();            // Valore assoluto
```

⚠️ **CRITICO**: BigInteger è **immutabile**!
```java
// ✗ SBAGLIATO
x.add(BigInteger.ONE);  // Risultato perso!

// ✓ CORRETTO
x = x.add(BigInteger.ONE);  // Riassegna
```

### Operazioni Avanzate BigInteger

```java
// Potenza
BigInteger power = base.pow(100);  // 2^100

// Massimo Comun Divisore
BigInteger gcd = num1.gcd(num2);

// Modular Exponentiation (crittografia)
BigInteger result = base.modPow(exponent, modulus);

// Test di primalità
boolean isPrime = candidate.isProbablePrime(100);  // prob errore: 2^-100

// Prossimo numero primo
BigInteger nextPrime = start.nextProbablePrime();

// Shift bitwise
BigInteger shifted = n.shiftLeft(3);  // n * 2^3
```

### Comparazioni BigInteger

```java
int cmp = a.compareTo(b);
// Ritorna: negativo se a < b, zero se a == b, positivo se a > b

// Helper methods
BigInteger min = a.min(b);
BigInteger max = a.max(b);

// Uguaglianza
boolean eq = a.equals(b);          // Verifica uguaglianza
boolean eq2 = a.compareTo(b) == 0; // Alternativa
```

### Conversioni BigInteger

```java
// A tipi primitivi (⚠️ possibile overflow)
int intVal = big.intValue();
long longVal = big.longValue();
double doubleVal = big.doubleValue();

// Conversioni sicure (lancia ArithmeticException se overflow)
int exact = big.intValueExact();
long exactLong = big.longValueExact();

// A String
String dec = num.toString();      // Decimale
String bin = num.toString(2);     // Binario
String hex = num.toString(16);    // Esadecimale
```

---

## 💰 BigDecimal

### Quando Usare BigDecimal

- ✅ **Calcoli finanziari e monetari** (SEMPRE!)
- ✅ Percentuali e tassi d'interesse
- ✅ Calcoli dove precisione esatta è critica
- ✅ Conformità normativa/legale
- ❌ **NON** per calcoli intensivi in loop (performance)

### ⚠️ CREAZIONE DI BIGDECIMAL (CRITICO!)

**La creazione corretta è LA cosa più importante!**

#### ✗ SBAGLIATO - NEVER use double constructor!

```java
BigDecimal wrong = new BigDecimal(0.1);  // ✗ SBAGLIATO!
// Risultato: 0.1000000000000000055511151231257827021181583404541015625
// Eredita l'imprecisione del double!
```

#### ✓ CORRETTO - ALWAYS use String constructor!

```java
BigDecimal correct = new BigDecimal("0.1");  // ✓ CORRETTO!
// Risultato: 0.1 (esatto)
```

### Metodi di Creazione BigDecimal

| Metodo | Sicurezza | Quando Usarlo |
|--------|-----------|---------------|
| `new BigDecimal("0.1")` | ✅✅✅ | **SEMPRE** preferito |
| `new BigDecimal(0.1)` | ❌❌❌ | **MAI** (impreciso!) |
| `BigDecimal.valueOf(0.1)` | ✅ | Letterali semplici |
| `BigDecimal.valueOf(123)` | ✅✅✅ | Da interi (sicuro) |
| `BigDecimal.valueOf(123, 2)` | ✅✅✅ | Con scale (123.00) |
| `new BigDecimal(BigInteger)` | ✅✅✅ | Da BigInteger |
| Costanti: `ZERO`, `ONE`, `TEN` | ✅✅✅ | Riutilizza |

**💡 REGOLA D'ORO**: Usa **SEMPRE** String per creare BigDecimal con valori decimali!

### Operazioni Aritmetiche BigDecimal

```java
BigDecimal a = new BigDecimal("100.50");
BigDecimal b = new BigDecimal("25.25");

// Operazioni base
BigDecimal sum = a.add(b);           // 125.75
BigDecimal diff = a.subtract(b);     // 75.25
BigDecimal prod = a.multiply(b);     // 2537.6250

// Altri operatori
BigDecimal abs = a.abs();            // Valore assoluto
BigDecimal neg = a.negate();         // Negazione
int sign = a.signum();               // -1, 0, o 1
BigDecimal power = a.pow(3);         // a^3
```

### ⚠️ Divisione con RoundingMode (OBBLIGATORIO!)

La divisione può produrre espansioni decimali infinite (es: 1/3 = 0.333...)

```java
// ✗ SBAGLIATO - ArithmeticException se non esatta!
BigDecimal result = BigDecimal.ONE.divide(new BigDecimal("3"));

// ✓ CORRETTO - Specifica RoundingMode
BigDecimal result = BigDecimal.ONE.divide(
    new BigDecimal("3"),
    10,                     // scale (decimali)
    RoundingMode.HALF_UP    // arrotondamento
);
// Risultato: 0.3333333333

// Divisione esatta (quando possibile, no RoundingMode necessario)
BigDecimal exact = new BigDecimal("100").divide(new BigDecimal("4")); // 25
```

### Scale e Precision

Ogni BigDecimal ha due proprietà:
- **Precision**: numero totale di cifre significative
- **Scale**: numero di cifre dopo la virgola

#### Esempi

| Valore | Precision | Scale |
|--------|-----------|-------|
| `123.45` | 5 | 2 |
| `0.00123` | 3 | 5 |
| `1230000` | 7 | 0 |
| `123.4500` | 6 | 4 |

#### Modificare lo Scale

```java
BigDecimal original = new BigDecimal("123.456789");

// Ridurre scale (richiede RoundingMode)
BigDecimal scaled2 = original.setScale(2, RoundingMode.HALF_UP);
// Risultato: 123.46

// Aumentare scale (aggiunge zeri, no RoundingMode necessario)
BigDecimal scaled10 = original.setScale(10, RoundingMode.UNNECESSARY);
// Risultato: 123.4567890000

// Rimuovere zeri non significativi
BigDecimal withZeros = new BigDecimal("123.4500");
BigDecimal stripped = withZeros.stripTrailingZeros();
// Risultato: 123.45
```

### RoundingMode - Modalità di Arrotondamento

Java fornisce 8 modalità (enum `RoundingMode`):

| RoundingMode | 2.5 → | 2.4 → | -2.5 → | Descrizione |
|--------------|-------|-------|--------|-------------|
| `UP` | 3 | 3 | -3 | Lontano da zero (aumenta modulo) |
| `DOWN` | 2 | 2 | -2 | Verso zero (tronca) |
| `CEILING` | 3 | 3 | -2 | Verso +∞ (sempre su) |
| `FLOOR` | 2 | 2 | -3 | Verso -∞ (sempre giù) |
| `HALF_UP` | 3 | 2 | -3 | **.5 → su** (standard commerciale) |
| `HALF_DOWN` | 2 | 2 | -2 | .5 → giù |
| `HALF_EVEN` | 2 | 2 | -2 | **.5 → pari** (banker's rounding) |
| `UNNECESSARY` | ERR | 2 | ERR | Fallisce se necessario arrotondare |

#### Modi più Comuni

1. **`HALF_UP`** - Arrotondamento commerciale standard (0.5 → 1)
2. **`HALF_EVEN`** - Banker's rounding (riduce bias cumulativo)
3. **`DOWN`** - Troncamento verso zero

```java
BigDecimal val = new BigDecimal("2.5");

val.setScale(0, RoundingMode.HALF_UP);   // 3 (standard)
val.setScale(0, RoundingMode.HALF_EVEN); // 2 (banker's)
val.setScale(0, RoundingMode.DOWN);      // 2 (tronca)
```

### Comparazioni BigDecimal

⚠️ **ATTENZIONE**: `equals()` considera lo scale!

```java
BigDecimal a = new BigDecimal("2.0");   // scale = 1
BigDecimal b = new BigDecimal("2.00");  // scale = 2

a.equals(b);       // false (scale diversi!)
a.compareTo(b);    // 0 (matematicamente uguali)
```

**💡 Best Practice**: Usa `compareTo()` per confronti matematici!

```java
// ✓ CORRETTO - Confronto matematico
if (price1.compareTo(price2) == 0) {
    // Matematicamente uguali
}

// ✗ EVITA - Confronto esatto (considera scale)
if (price1.equals(price2)) {
    // Identici (valore + scale)
}
```

### Comparazioni

```java
int cmp = a.compareTo(b);
// Ritorna: negativo se a < b, zero se a == b, positivo se a > b

// Helper methods
BigDecimal min = a.min(b);
BigDecimal max = a.max(b);

// Per uguaglianza matematica
boolean equal = a.compareTo(b) == 0;  // ✓ Raccomandato
```

---

## 📊 Esempi Pratici

### Esempio 1: Calcolo IVA

```java
BigDecimal prezzo = new BigDecimal("100.00");
BigDecimal aliquotaIVA = new BigDecimal("0.22");  // 22%

BigDecimal iva = prezzo.multiply(aliquotaIVA);
BigDecimal totale = prezzo.add(iva);

// Arrotonda a 2 decimali
totale = totale.setScale(2, RoundingMode.HALF_UP);

System.out.println("Prezzo base: " + prezzo + " €");
System.out.println("IVA (22%):   " + iva + " €");
System.out.println("Totale:      " + totale + " €");
```

### Esempio 2: Fattoriale di 50 (BigInteger)

```java
BigInteger factorial = BigInteger.ONE;
for (int i = 1; i <= 50; i++) {
    factorial = factorial.multiply(BigInteger.valueOf(i));
}
// Risultato: numero a 65 cifre!
System.out.println("50! = " + factorial);
```

### Esempio 3: Interesse Composto

```java
BigDecimal capitale = new BigDecimal("10000.00");  // 10.000 €
BigDecimal tassoAnnuo = new BigDecimal("0.05");     // 5%
int anni = 10;

BigDecimal montante = capitale;
for (int i = 0; i < anni; i++) {
    BigDecimal interesse = montante.multiply(tassoAnnuo);
    montante = montante.add(interesse);
}

montante = montante.setScale(2, RoundingMode.HALF_UP);
System.out.println("Montante dopo 10 anni: " + montante + " €");
```

---

## ⚡ Performance e Considerazioni

### Quando NON Usare BigDecimal/BigInteger

❌ **Evita** in questi casi:
- Loop con milioni di iterazioni
- Calcoli real-time (gaming, grafica)
- Applicazioni performance-critical
- Quando piccoli errori di arrotondamento sono accettabili

### Ottimizzazioni

#### 1. Riutilizza Costanti

```java
// ✗ Inefficiente
for (int i = 0; i < 1000; i++) {
    result = result.multiply(new BigDecimal("1.05"));  // crea 1000 oggetti!
}

// ✓ Efficiente
BigDecimal FACTOR = new BigDecimal("1.05");
for (int i = 0; i < 1000; i++) {
    result = result.multiply(FACTOR);  // riutilizza
}
```

#### 2. Usa valueOf per Piccoli Numeri

```java
BigDecimal.valueOf(10);     // ✓ può usare cache
new BigDecimal("10");       // ✗ sempre nuovo oggetto
```

#### 3. Long con Scaling Manuale (per casi semplici)

Per operazioni monetarie semplici, considera `long` (centesimi):

```java
long priceInCents = 1050;  // 10.50 €
long taxInCents = 220;     // 2.20 €
long totalCents = priceInCents + taxInCents;
double totalEuros = totalCents / 100.0;

// ⚠️ Limiti: max ~92 quadrilioni di centesimi, no divisioni complesse
```

**💡 REGOLA**: Se devi chiedere "posso usare long?", usa BigDecimal (più sicuro).

---

## ✅ Best Practices - Checklist

Prima di usare BigDecimal/BigInteger, verifica:

- [ ] **Creazione**: Usato String constructor per BigDecimal?
- [ ] **Divisione**: Specificato RoundingMode?
- [ ] **Confronti**: Usato `compareTo()` invece di `equals()`?
- [ ] **Immutabilità**: Riassegnato il risultato?
- [ ] **Costanti**: Riutilizzato valori frequenti?
- [ ] **Scale**: Appropriato per il dominio (2 per denaro, 4 per percentuali)?
- [ ] **Null Safety**: Gestiti valori null?
- [ ] **Performance**: Considerato se primitivi sono sufficienti?
- [ ] **Exception Handling**: Gestita `NumberFormatException`?
- [ ] **Documentazione**: Documentato il RoundingMode scelto?

### Regole Fondamentali

#### 1. ✓ Creazione di BigDecimal

```java
// ✓ SEMPRE String
BigDecimal price = new BigDecimal("19.99");

// ✗ MAI double
BigDecimal price = new BigDecimal(19.99);  // SBAGLIATO!
```

#### 2. ✓ Divisione con RoundingMode

```java
// ✓ SEMPRE specifica RoundingMode
result = a.divide(b, 2, RoundingMode.HALF_UP);

// ✗ MAI senza (se non esatta)
result = a.divide(b);  // ArithmeticException!
```

#### 3. ✓ Confronti con compareTo

```java
// ✓ Confronto matematico
if (price1.compareTo(price2) == 0) { ... }

// ✗ Confronto esatto (scale!)
if (price1.equals(price2)) { ... }
```

#### 4. ✓ Immutabilità

```java
// ✓ Riassegna
price = price.add(tax);

// ✗ Risultato perso
price.add(tax);
```

#### 5. ✓ Scale Appropriato

```java
// Denaro: 2 decimali
BigDecimal price = amount.setScale(2, RoundingMode.HALF_UP);

// Percentuali: 4 decimali
BigDecimal rate = percent.setScale(4, RoundingMode.HALF_UP);

// Scientifico: 10+ decimali
BigDecimal result = value.setScale(10, RoundingMode.HALF_UP);
```

#### 6. ✓ Null Safety

```java
if (price != null && price.compareTo(BigDecimal.ZERO) > 0) {
    // safe to use
}
```

#### 7. ✓ Validazione Input

```java
try {
    BigDecimal price = new BigDecimal(userInput);
    if (price.compareTo(BigDecimal.ZERO) < 0) {
        throw new IllegalArgumentException("Prezzo negativo");
    }
} catch (NumberFormatException e) {
    // gestisci input non valido
}
```

---

## 📖 Riferimenti e Risorse

### Documentazione Ufficiale

- [BigDecimal JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigDecimal.html)
- [BigInteger JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigInteger.html)
- [RoundingMode JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/RoundingMode.html)
- [MathContext JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/MathContext.html)

### Articoli Consigliati

- [Effective Java (Item 60): Avoid float and double if exact answers are required](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- [Java BigDecimal: Common Mistakes and Best Practices](https://www.baeldung.com/java-bigdecimal-biginteger)

### Concetti Correlati

- **IEEE 754**: Standard floating-point (per capire perché double è impreciso)
- **Banker's Rounding**: RoundingMode.HALF_EVEN
- **Arbitrary Precision Arithmetic**: Teoria dietro BigDecimal/BigInteger

---

## 🚀 Esecuzione della Demo

Per eseguire la demo completa:

```bash
# Compila il progetto
mvn clean compile

# Esegui l'applicazione
mvn exec:java -Dexec.mainClass="com.corso.demo.App"

# Seleziona l'opzione "BigDecimal e BigInteger" dal menu
```

La demo mostra interattivamente tutti i concetti con esempi eseguibili e spiegazioni dettagliate.

---

## 💡 Riepilogo Finale

### BigInteger
- ✅ Per numeri interi oltre long
- ✅ Fattoriali, Fibonacci, crittografia
- ✅ Operazioni avanzate: gcd, modPow, isProbablePrime

### BigDecimal
- ✅ **SEMPRE** per calcoli finanziari/monetari
- ✅ Crea con **String** (mai double!)
- ✅ Usa **RoundingMode** per divisioni
- ✅ Confronta con **compareTo()** (non equals)

### Regola d'Oro
**"Per il denaro, usa SEMPRE BigDecimal con String constructor."**

---

**📝 Nota**: Questa demo fa parte del corso Java 21. Per domande o approfondimenti, consulta il materiale del corso o la documentazione ufficiale Java.
