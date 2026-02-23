package com.corso.samples.datatypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Classe demo completa per l'apprendimento di BigDecimal e BigInteger in Java
 * 
 * BigDecimal e BigInteger sono classi immutabili per rappresentare numeri
 * con precisione arbitraria, essenziali per calcoli finanziari e scientifici.
 * 
 * QUANDO USARLI:
 * - BigDecimal: calcoli finanziari, monetari, dove la precisione è critica
 * - BigInteger: numeri interi molto grandi oltre il range di long
 * 
 * CARATTERISTICHE:
 * - Precisione arbitraria (limitata solo dalla memoria)
 * - Immutabili (ogni operazione crea un nuovo oggetto)
 * - Performance inferiore rispetto ai tipi primitivi
 * 
 * @author Java 21 Course
 * @version 1.0
 */
public class BigDecimalBigIntegerDemo {

    /**
     * Metodo principale che esegue tutte le demo su BigDecimal e BigInteger
     * Questo metodo orchestra l'esecuzione sequenziale di tutte le sezioni
     */
    public static void run() {
        printHeader("DEMO COMPLETA: BIGDECIMAL E BIGINTEGER IN JAVA");
        
        // Sezione 1: Introduzione e motivazione
        demoIntroduction();
        
        // Sezione 2: BigInteger - Creazione
        demoBigIntegerCreation();
        
        // Sezione 3: BigInteger - Operazioni aritmetiche
        demoBigIntegerArithmetic();
        
        // Sezione 4: BigInteger - Operazioni avanzate
        demoBigIntegerAdvanced();
        
        // Sezione 5: BigInteger - Comparazioni e conversioni
        demoBigIntegerComparison();
        
        // Sezione 6: BigDecimal - Creazione (CRITICO!)
        demoBigDecimalCreation();
        
        // Sezione 7: BigDecimal - Operazioni aritmetiche
        demoBigDecimalArithmetic();
        
        // Sezione 8: BigDecimal - Scale e Precision
        demoBigDecimalScalePrecision();
        
        // Sezione 9: BigDecimal - Rounding Modes
        demoBigDecimalRounding();
        
        // Sezione 10: BigDecimal - Comparazioni
        demoBigDecimalComparison();
        
        // Sezione 11: Performance e considerazioni pratiche
        demoPerformanceConsiderations();
        
        // Sezione 12: Best Practices
        demoBestPractices();
        
        printFooter();
    }

    /**
     * SEZIONE 1: Introduzione e Motivazione
     * 
     * Spiega quando e perché usare BigDecimal e BigInteger invece dei tipi primitivi
     */
    private static void demoIntroduction() {
        printSection("1. INTRODUZIONE: PERCHÉ BIGDECIMAL E BIGINTEGER?");
        
        System.out.println("Java fornisce tipi primitivi per numeri (int, long, float, double),");
        System.out.println("ma hanno LIMITAZIONI importanti:\n");
        
        printSubSection("⚠️ Problema 1: Limiti di Range");
        
        System.out.println("I tipi primitivi hanno range limitati:");
        System.out.println("  int:    " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);
        System.out.println("  long:   " + Long.MIN_VALUE + " a " + Long.MAX_VALUE);
        System.out.println("\nSe i numeri superano questi limiti, si verifica OVERFLOW!\n");
        
        long maxLong = Long.MAX_VALUE;
        System.out.println("long maxLong = Long.MAX_VALUE;  // " + maxLong);
        long overflow = maxLong + 1;
        System.out.println("long overflow = maxLong + 1;     // " + overflow + " ✗ OVERFLOW!\n");
        
        printSubSection("⚠️ Problema 2: Imprecisione con Floating-Point");
        
        System.out.println("float e double usano rappresentazione floating-point (IEEE 754)");
        System.out.println("che può causare ERRORI DI ARROTONDAMENTO:\n");
        
        double d1 = 0.1;
        double d2 = 0.2;
        double sum = d1 + d2;
        
        System.out.println("double d1 = 0.1;");
        System.out.println("double d2 = 0.2;");
        System.out.println("double sum = d1 + d2;");
        System.out.println("  → Risultato: " + sum);
        System.out.println("  → Atteso:    0.3");
        System.out.println("  ✗ NON UGUALE! (errore di rappresentazione binaria)\n");
        
        System.out.println("Questo è INACCETTABILE per calcoli FINANZIARI!");
        System.out.println("Es: 0.1 € + 0.2 € DEVE essere esattamente 0.3 €, non 0.30000000000000004 €!\n");
        
        printSubSection("✓ Soluzione: BigDecimal e BigInteger");
        
        System.out.println("┌─────────────────┬────────────────────────────────────────────────┐");
        System.out.println("│   CLASSE        │              QUANDO USARLA                     │");
        System.out.println("├─────────────────┼────────────────────────────────────────────────┤");
        System.out.println("│ BigInteger      │ Numeri INTERI che superano il range di long   │");
        System.out.println("│                 │ Esempio: fattoriali, fibonacci grandi,         │");
        System.out.println("│                 │ crittografia (chiavi grandi)                   │");
        System.out.println("├─────────────────┼────────────────────────────────────────────────┤");
        System.out.println("│ BigDecimal      │ Numeri DECIMALI dove la PRECISIONE è critica  │");
        System.out.println("│                 │ Esempio: calcoli finanziari, monetari,         │");
        System.out.println("│                 │ scientifici, percentuali                       │");
        System.out.println("└─────────────────┴────────────────────────────────────────────────┘\n");
        
        System.out.println("CARATTERISTICHE COMUNI:");
        System.out.println("  ✓ Precisione ARBITRARIA (limitata solo dalla memoria)");
        System.out.println("  ✓ IMMUTABILI (ogni operazione crea un nuovo oggetto)");
        System.out.println("  ✓ SICURE (nessun overflow, precisione esatta)");
        System.out.println("  ✗ PERFORMANCE inferiore rispetto ai primitivi\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 2: BigInteger - Creazione
     * 
     * Mostra i diversi modi per creare istanze di BigInteger
     */
    private static void demoBigIntegerCreation() {
        printSection("2. BIGINTEGER - CREAZIONE");
        
        System.out.println("BigInteger rappresenta numeri interi di grandezza arbitraria.\n");
        
        printSubSection("Metodo 1: Da String");
        
        BigInteger bi1 = new BigInteger("12345678901234567890");
        System.out.println("BigInteger bi1 = new BigInteger(\"12345678901234567890\");");
        System.out.println("  → " + bi1);
        System.out.println("  (numero troppo grande per long!)\n");
        
        // Numero enorme
        BigInteger huge = new BigInteger("123456789012345678901234567890123456789012345678901234567890");
        System.out.println("BigInteger huge = new BigInteger(\"123456789...huge...\");");
        System.out.println("  → " + huge + "\n");
        
        printSubSection("Metodo 2: Da long (valueOf)");
        
        BigInteger bi2 = BigInteger.valueOf(1000000L);
        System.out.println("BigInteger bi2 = BigInteger.valueOf(1000000L);");
        System.out.println("  → " + bi2);
        System.out.println("  💡 Usa valueOf per numeri piccoli (caching interno)\n");
        
        printSubSection("Metodo 3: Costanti Predefinite");
        
        System.out.println("BigInteger.ZERO  = " + BigInteger.ZERO);
        System.out.println("BigInteger.ONE   = " + BigInteger.ONE);
        System.out.println("BigInteger.TWO   = " + BigInteger.TWO);
        System.out.println("BigInteger.TEN   = " + BigInteger.TEN + "\n");
        
        printSubSection("Metodo 4: Da Array di Byte");
        
        byte[] bytes = {127, -128, 0, 1};
        BigInteger bi3 = new BigInteger(bytes);
        System.out.println("byte[] bytes = {127, -128, 0, 1};");
        System.out.println("BigInteger bi3 = new BigInteger(bytes);");
        System.out.println("  → " + bi3 + " (interpretazione binaria)\n");
        
        printSubSection("Metodo 5: Random BigInteger");
        
        BigInteger random = new BigInteger(128, new java.util.Random());
        System.out.println("BigInteger random = new BigInteger(128, new Random());");
        System.out.println("  → " + random + " (128-bit random)\n");
        
        printSubSection("⚠️ ATTENZIONE: NumberFormatException");
        
        System.out.println("String non numeriche causano NumberFormatException:\n");
        try {
            BigInteger invalid = new BigInteger("abc123");
            System.out.println("Result: " + invalid);
        } catch (NumberFormatException e) {
            System.out.println("new BigInteger(\"abc123\");");
            System.out.println("✗ NumberFormatException: " + e.getMessage() + "\n");
        }
        
        waitForEnter();
    }

    /**
     * SEZIONE 3: BigInteger - Operazioni Aritmetiche
     * 
     * Dimostra le operazioni aritmetiche di base con BigInteger
     */
    private static void demoBigIntegerArithmetic() {
        printSection("3. BIGINTEGER - OPERAZIONI ARITMETICHE");
        
        System.out.println("BigInteger è IMMUTABILE: ogni operazione restituisce un NUOVO oggetto.\n");
        
        BigInteger a = new BigInteger("1000000000000000000000");  // 10^21
        BigInteger b = new BigInteger("999999999999999999999");   // 10^21 - 1
        
        System.out.println("BigInteger a = new BigInteger(\"1000000000000000000000\");  // 10^21");
        System.out.println("BigInteger b = new BigInteger(\"999999999999999999999\");   // 10^21 - 1\n");
        
        printSubSection("Addizione (add)");
        
        BigInteger sum = a.add(b);
        System.out.println("BigInteger sum = a.add(b);");
        System.out.println("  → " + sum + "\n");
        
        printSubSection("Sottrazione (subtract)");
        
        BigInteger diff = a.subtract(b);
        System.out.println("BigInteger diff = a.subtract(b);");
        System.out.println("  → " + diff + "\n");
        
        printSubSection("Moltiplicazione (multiply)");
        
        BigInteger prod = a.multiply(BigInteger.valueOf(2));
        System.out.println("BigInteger prod = a.multiply(BigInteger.valueOf(2));");
        System.out.println("  → " + prod + "\n");
        
        printSubSection("Divisione (divide)");
        
        BigInteger quot = a.divide(BigInteger.valueOf(2));
        System.out.println("BigInteger quot = a.divide(BigInteger.valueOf(2));");
        System.out.println("  → " + quot + "\n");
        
        printSubSection("Modulo/Resto (mod, remainder)");
        
        BigInteger mod = a.mod(BigInteger.valueOf(7));
        System.out.println("BigInteger mod = a.mod(BigInteger.valueOf(7));");
        System.out.println("  → " + mod);
        System.out.println("  (resto della divisione per 7)\n");
        
        printSubSection("Divisione con Resto (divideAndRemainder)");
        
        BigInteger dividend = new BigInteger("123456789");
        BigInteger divisor = new BigInteger("12345");
        BigInteger[] divResult = dividend.divideAndRemainder(divisor);
        
        System.out.println("BigInteger dividend = new BigInteger(\"123456789\");");
        System.out.println("BigInteger divisor = new BigInteger(\"12345\");");
        System.out.println("BigInteger[] result = dividend.divideAndRemainder(divisor);");
        System.out.println("  → Quoziente: " + divResult[0]);
        System.out.println("  → Resto:     " + divResult[1] + "\n");
        
        printSubSection("Negazione (negate)");
        
        BigInteger neg = a.negate();
        System.out.println("BigInteger neg = a.negate();");
        System.out.println("  → " + neg + "\n");
        
        printSubSection("Valore Assoluto (abs)");
        
        BigInteger negative = new BigInteger("-12345");
        BigInteger absolute = negative.abs();
        System.out.println("BigInteger negative = new BigInteger(\"-12345\");");
        System.out.println("BigInteger absolute = negative.abs();");
        System.out.println("  → " + absolute + "\n");
        
        printSubSection("⚠️ ERRORE COMUNE: Usare +=, -=, ecc.");
        
        System.out.println("BigInteger è IMMUTABILE, quindi queste operazioni sono SBAGLIATE:\n");
        
        BigInteger x = BigInteger.valueOf(10);
        System.out.println("BigInteger x = BigInteger.valueOf(10);");
        System.out.println("x = x + BigInteger.ONE;  // ✗ ERRORE DI COMPILAZIONE (no operatore +)");
        System.out.println("x += BigInteger.ONE;     // ✗ ERRORE DI COMPILAZIONE\n");
        
        System.out.println("CORRETTO:");
        x = x.add(BigInteger.ONE);
        System.out.println("x = x.add(BigInteger.ONE);  // ✓ OK (crea nuovo oggetto)");
        System.out.println("  → x = " + x + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 4: BigInteger - Operazioni Avanzate
     * 
     * Mostra operazioni matematiche avanzate disponibili per BigInteger
     */
    private static void demoBigIntegerAdvanced() {
        printSection("4. BIGINTEGER - OPERAZIONI AVANZATE");
        
        printSubSection("Potenza (pow)");
        
        BigInteger base = BigInteger.valueOf(2);
        BigInteger power = base.pow(100);  // 2^100
        
        System.out.println("BigInteger base = BigInteger.valueOf(2);");
        System.out.println("BigInteger power = base.pow(100);  // 2^100");
        System.out.println("  → " + power);
        System.out.println("  (numero a 31 cifre!)\n");
        
        printSubSection("Massimo Comun Divisore (gcd)");
        
        BigInteger num1 = new BigInteger("12345678");
        BigInteger num2 = new BigInteger("87654321");
        BigInteger gcd = num1.gcd(num2);
        
        System.out.println("BigInteger num1 = new BigInteger(\"12345678\");");
        System.out.println("BigInteger num2 = new BigInteger(\"87654321\");");
        System.out.println("BigInteger gcd = num1.gcd(num2);");
        System.out.println("  → MCD = " + gcd + "\n");
        
        printSubSection("Modular Exponentiation (modPow) - Crittografia");
        
        BigInteger base2 = new BigInteger("12345");
        BigInteger exponent = new BigInteger("6789");
        BigInteger modulus = new BigInteger("100000");
        BigInteger modPowResult = base2.modPow(exponent, modulus);
        
        System.out.println("Calcola (12345^6789) mod 100000 - usato in crittografia:");
        System.out.println("BigInteger result = base.modPow(exponent, modulus);");
        System.out.println("  → " + modPowResult + "\n");
        
        printSubSection("Test di Primalità (isProbablePrime)");
        
        BigInteger candidate = new BigInteger("104729");  // Numero primo
        boolean isPrime = candidate.isProbablePrime(100);
        
        System.out.println("BigInteger candidate = new BigInteger(\"104729\");");
        System.out.println("boolean isPrime = candidate.isProbablePrime(100);");
        System.out.println("  → " + isPrime + " (probabilità di errore: 2^-100)\n");
        
        BigInteger notPrime = new BigInteger("104730");
        System.out.println("BigInteger notPrime = new BigInteger(\"104730\");");
        System.out.println("boolean isPrime2 = notPrime.isProbablePrime(100);");
        System.out.println("  → " + notPrime.isProbablePrime(100) + "\n");
        
        printSubSection("Next Probable Prime (nextProbablePrime)");
        
        BigInteger start = new BigInteger("1000000");
        BigInteger nextPrime = start.nextProbablePrime();
        
        System.out.println("BigInteger start = new BigInteger(\"1000000\");");
        System.out.println("BigInteger nextPrime = start.nextProbablePrime();");
        System.out.println("  → " + nextPrime + " (primo numero primo > 1000000)\n");
        
        printSubSection("Shift Bitwise (shiftLeft, shiftRight)");
        
        BigInteger n = new BigInteger("100");
        BigInteger shifted = n.shiftLeft(3);  // Equivalente a n * 2^3
        
        System.out.println("BigInteger n = new BigInteger(\"100\");");
        System.out.println("BigInteger shifted = n.shiftLeft(3);  // n * 2^3");
        System.out.println("  → " + shifted + " (100 * 8 = 800)\n");
        
        printSubSection("💡 Esempio Pratico: Fattoriale di 50");
        
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= 50; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        
        System.out.println("Calcolo 50! (fattoriale di 50):");
        System.out.println("  → " + factorial);
        System.out.println("  (numero a 65 cifre!)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 5: BigInteger - Comparazioni e Conversioni
     * 
     * Mostra come confrontare BigInteger e convertirli in altri tipi
     */
    private static void demoBigIntegerComparison() {
        printSection("5. BIGINTEGER - COMPARAZIONI E CONVERSIONI");
        
        printSubSection("Comparazione con compareTo");
        
        BigInteger a = new BigInteger("1000");
        BigInteger b = new BigInteger("2000");
        BigInteger c = new BigInteger("1000");
        
        System.out.println("BigInteger a = new BigInteger(\"1000\");");
        System.out.println("BigInteger b = new BigInteger(\"2000\");");
        System.out.println("BigInteger c = new BigInteger(\"1000\");\n");
        
        int cmp1 = a.compareTo(b);
        System.out.println("a.compareTo(b)  →  " + cmp1 + "  (negativo: a < b)");
        
        int cmp2 = b.compareTo(a);
        System.out.println("b.compareTo(a)  →  " + cmp2 + "  (positivo: b > a)");
        
        int cmp3 = a.compareTo(c);
        System.out.println("a.compareTo(c)  →  " + cmp3 + "  (zero: a == c)\n");
        
        printSubSection("Equals vs CompareTo");
        
        System.out.println("Per verificare UGUAGLIANZA, usa equals() o compareTo():\n");
        
        boolean eq1 = a.equals(c);
        System.out.println("a.equals(c)       →  " + eq1);
        
        boolean eq2 = a.compareTo(c) == 0;
        System.out.println("a.compareTo(c) == 0  →  " + eq2 + "\n");
        
        printSubSection("Metodi di Confronto Helper");
        
        BigInteger x = new BigInteger("42");
        BigInteger y = new BigInteger("100");
        
        System.out.println("BigInteger x = new BigInteger(\"42\");");
        System.out.println("BigInteger y = new BigInteger(\"100\");\n");
        
        System.out.println("x.min(y)  →  " + x.min(y) + "  (il più piccolo)");
        System.out.println("x.max(y)  →  " + x.max(y) + "  (il più grande)\n");
        
        printSubSection("Conversioni a Tipi Primitivi");
        
        BigInteger big = new BigInteger("12345");
        
        System.out.println("BigInteger big = new BigInteger(\"12345\");\n");
        
        int intValue = big.intValue();
        System.out.println("big.intValue()    →  " + intValue);
        
        long longValue = big.longValue();
        System.out.println("big.longValue()   →  " + longValue);
        
        float floatValue = big.floatValue();
        System.out.println("big.floatValue()  →  " + floatValue);
        
        double doubleValue = big.doubleValue();
        System.out.println("big.doubleValue() →  " + doubleValue + "\n");
        
        printSubSection("⚠️ ATTENZIONE: Overflow nelle Conversioni");
        
        BigInteger tooBig = new BigInteger("999999999999999999999999999");
        int overflowInt = tooBig.intValue();
        
        System.out.println("BigInteger tooBig = new BigInteger(\"999999999999999999999999999\");");
        System.out.println("int overflow = tooBig.intValue();");
        System.out.println("  → " + overflowInt);
        System.out.println("  ⚠️ OVERFLOW! Usa intValueExact() per eccezione sicura\n");
        
        System.out.println("CONVERSIONE SICURA con xxxValueExact():");
        try {
            int exact = tooBig.intValueExact();
            System.out.println("Result: " + exact);
        } catch (ArithmeticException e) {
            System.out.println("tooBig.intValueExact();");
            System.out.println("✗ ArithmeticException: " + e.getMessage() + " ✓ Sicuro!\n");
        }
        
        printSubSection("Conversione a String");
        
        BigInteger num = new BigInteger("1234567890");
        
        String dec = num.toString();
        System.out.println("num.toString()      →  " + dec + " (decimale)");
        
        String bin = num.toString(2);
        System.out.println("num.toString(2)     →  " + bin + " (binario)");
        
        String hex = num.toString(16);
        System.out.println("num.toString(16)    →  " + hex + " (esadecimale)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 6: BigDecimal - Creazione (CRITICO!)
     * 
     * Mostra come creare BigDecimal CORRETTAMENTE - questa è la sezione più importante!
     */
    private static void demoBigDecimalCreation() {
        printSection("6. BIGDECIMAL - CREAZIONE (⚠️ SEZIONE CRITICA!)");
        
        System.out.println("BigDecimal rappresenta numeri decimali con precisione arbitraria.");
        System.out.println("⚠️ LA CREAZIONE È CRITICA: usare il costruttore sbagliato causa imprecisioni!\n");
        
        printSubSection("✗ ERRORE COMUNE: Costruttore da double");
        
        System.out.println("⚠️ NON USARE MAI il costruttore BigDecimal(double):\n");
        
        BigDecimal wrong = new BigDecimal(0.1);  // ✗ SBAGLIATO!
        System.out.println("BigDecimal wrong = new BigDecimal(0.1);  // ✗ SBAGLIATO!");
        System.out.println("  → " + wrong);
        System.out.println("  ✗ NON è 0.1! (eredita l'imprecisione del double)\n");
        
        printSubSection("✓ CORRETTO: Costruttore da String");
        
        BigDecimal correct = new BigDecimal("0.1");  // ✓ CORRETTO!
        System.out.println("BigDecimal correct = new BigDecimal(\"0.1\");  // ✓ CORRETTO!");
        System.out.println("  → " + correct);
        System.out.println("  ✓ Esattamente 0.1\n");
        
        printSubSection("Confronto: double vs String");
        
        System.out.println("DIMOSTRAZIONE della differenza:\n");
        
        BigDecimal fromDouble = new BigDecimal(0.1);
        BigDecimal fromString = new BigDecimal("0.1");
        
        System.out.println("new BigDecimal(0.1)     → " + fromDouble);
        System.out.println("new BigDecimal(\"0.1\")   → " + fromString);
        System.out.println("equals()                → " + fromDouble.equals(fromString));
        System.out.println("\n💡 REGOLA: USA SEMPRE String per creare BigDecimal!\n");
        
        printSubSection("Metodo valueOf (da double) - Uso Controllato");
        
        System.out.println("valueOf converte double in String internamente (più sicuro):\n");
        
        BigDecimal bd1 = BigDecimal.valueOf(0.1);
        System.out.println("BigDecimal bd1 = BigDecimal.valueOf(0.1);");
        System.out.println("  → " + bd1);
        System.out.println("  ✓ Convertito internamente a String (relativamente sicuro)\n");
        
        System.out.println("Ma ATTENZIONE: valueOf funziona bene per letterali semplici,");
        System.out.println("ma se il double ha già un errore, l'errore persiste:\n");
        
        double imprecise = 0.1 + 0.2;  // 0.30000000000000004
        BigDecimal bd2 = BigDecimal.valueOf(imprecise);
        System.out.println("double imprecise = 0.1 + 0.2;  // " + imprecise);
        System.out.println("BigDecimal bd2 = BigDecimal.valueOf(imprecise);");
        System.out.println("  → " + bd2);
        System.out.println("  ✗ Eredita l'imprecisione!\n");
        
        printSubSection("Creazione da long e int (Sicura)");
        
        BigDecimal bd3 = BigDecimal.valueOf(12345);
        System.out.println("BigDecimal bd3 = BigDecimal.valueOf(12345);");
        System.out.println("  → " + bd3 + " ✓ Sicuro con interi\n");
        
        BigDecimal bd4 = BigDecimal.valueOf(12345, 2);  // 123.45 (12345 * 10^-2)
        System.out.println("BigDecimal bd4 = BigDecimal.valueOf(12345, 2);  // scale = 2");
        System.out.println("  → " + bd4 + " (12345 * 10^-2 = 123.45)\n");
        
        printSubSection("Costanti Predefinite");
        
        System.out.println("BigDecimal.ZERO  = " + BigDecimal.ZERO);
        System.out.println("BigDecimal.ONE   = " + BigDecimal.ONE);
        System.out.println("BigDecimal.TEN   = " + BigDecimal.TEN + "\n");
        
        printSubSection("Creazione da BigInteger");
        
        BigInteger bi = new BigInteger("123456789012345678901234567890");
        BigDecimal bd5 = new BigDecimal(bi);
        
        System.out.println("BigInteger bi = new BigInteger(\"123456789012345678901234567890\");");
        System.out.println("BigDecimal bd5 = new BigDecimal(bi);");
        System.out.println("  → " + bd5 + "\n");
        
        printSubSection("⚠️ RIEPILOGO: Come Creare BigDecimal");
        
        System.out.println("┌────────────────────────────────┬─────────────┬──────────────────────┐");
        System.out.println("│          METODO                │   SICURO?   │       QUANDO         │");
        System.out.println("├────────────────────────────────┼─────────────┼──────────────────────┤");
        System.out.println("│ new BigDecimal(\"0.1\")          │     ✓✓✓     │ SEMPRE preferito     │");
        System.out.println("│ new BigDecimal(0.1)            │      ✗✗✗    │ MAI (impreciso!)     │");
        System.out.println("│ BigDecimal.valueOf(0.1)        │      ✓      │ Letterali semplici   │");
        System.out.println("│ BigDecimal.valueOf(123)        │     ✓✓✓     │ Da interi (sicuro)   │");
        System.out.println("│ BigDecimal.valueOf(123, 2)     │     ✓✓✓     │ Con scale specifico  │");
        System.out.println("│ new BigDecimal(BigInteger)     │     ✓✓✓     │ Da BigInteger        │");
        System.out.println("└────────────────────────────────┴─────────────┴──────────────────────┘\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 7: BigDecimal - Operazioni Aritmetiche
     * 
     * Dimostra le operazioni aritmetiche con BigDecimal
     */
    private static void demoBigDecimalArithmetic() {
        printSection("7. BIGDECIMAL - OPERAZIONI ARITMETICHE");
        
        System.out.println("Come BigInteger, BigDecimal è IMMUTABILE.\n");
        
        BigDecimal a = new BigDecimal("100.50");
        BigDecimal b = new BigDecimal("25.25");
        
        System.out.println("BigDecimal a = new BigDecimal(\"100.50\");");
        System.out.println("BigDecimal b = new BigDecimal(\"25.25\");\n");
        
        printSubSection("Addizione (add)");
        
        BigDecimal sum = a.add(b);
        System.out.println("BigDecimal sum = a.add(b);");
        System.out.println("  → " + sum + "\n");
        
        printSubSection("Sottrazione (subtract)");
        
        BigDecimal diff = a.subtract(b);
        System.out.println("BigDecimal diff = a.subtract(b);");
        System.out.println("  → " + diff + "\n");
        
        printSubSection("Moltiplicazione (multiply)");
        
        BigDecimal prod = a.multiply(b);
        System.out.println("BigDecimal prod = a.multiply(b);");
        System.out.println("  → " + prod);
        System.out.println("  (nota: scale automaticamente = somma degli scale)\n");
        
        printSubSection("⚠️ Divisione (divide) - Richiede RoundingMode!");
        
        System.out.println("La divisione può produrre risultati INFINITI (espansione decimale):");
        System.out.println("Esempio: 1 / 3 = 0.333333... (infinito)\n");
        
        System.out.println("DIVISIONE SENZA RoundingMode:");
        try {
            BigDecimal result = BigDecimal.ONE.divide(new BigDecimal("3"));
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("BigDecimal.ONE.divide(new BigDecimal(\"3\"));");
            System.out.println("✗ ArithmeticException: " + e.getMessage() + "\n");
        }
        
        System.out.println("DIVISIONE CON RoundingMode (OBBLIGATORIO per divisioni non esatte):\n");
        
        BigDecimal result1 = BigDecimal.ONE.divide(new BigDecimal("3"), 10, RoundingMode.HALF_UP);
        System.out.println("BigDecimal result = BigDecimal.ONE.divide(");
        System.out.println("    new BigDecimal(\"3\"), ");
        System.out.println("    10,                    // scale (decimali)");
        System.out.println("    RoundingMode.HALF_UP   // arrotondamento");
        System.out.println(");");
        System.out.println("  → " + result1 + " (10 decimali, arrotondato)\n");
        
        printSubSection("Divisione Esatta (quando possibile)");
        
        BigDecimal exact = new BigDecimal("100").divide(new BigDecimal("4"));
        System.out.println("BigDecimal exact = new BigDecimal(\"100\").divide(new BigDecimal(\"4\"));");
        System.out.println("  → " + exact + " (esatta, no RoundingMode necessario)\n");
        
        printSubSection("Potenza (pow)");
        
        BigDecimal base = new BigDecimal("2.5");
        BigDecimal power = base.pow(3);
        
        System.out.println("BigDecimal base = new BigDecimal(\"2.5\");");
        System.out.println("BigDecimal power = base.pow(3);  // 2.5^3");
        System.out.println("  → " + power + "\n");
        
        printSubSection("Valore Assoluto, Negazione, Signum");
        
        BigDecimal negative = new BigDecimal("-123.45");
        
        System.out.println("BigDecimal negative = new BigDecimal(\"-123.45\");\n");
        
        System.out.println("negative.abs()     →  " + negative.abs() + " (valore assoluto)");
        System.out.println("negative.negate()  →  " + negative.negate() + " (cambia segno)");
        System.out.println("negative.signum()  →  " + negative.signum() + " (-1=neg, 0=zero, 1=pos)\n");
        
        printSubSection("💡 Esempio Pratico: Calcolo IVA");
        
        BigDecimal prezzo = new BigDecimal("100.00");
        BigDecimal aliquotaIVA = new BigDecimal("0.22");  // 22%
        
        BigDecimal iva = prezzo.multiply(aliquotaIVA);
        BigDecimal totale = prezzo.add(iva);
        
        System.out.println("Calcolo prezzo con IVA al 22%:");
        System.out.println("  Prezzo base:  " + prezzo + " €");
        System.out.println("  IVA (22%):    " + iva + " €");
        System.out.println("  Totale:       " + totale + " €\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 8: BigDecimal - Scale e Precision
     * 
     * Spiega i concetti fondamentali di scale e precision in BigDecimal
     */
    private static void demoBigDecimalScalePrecision() {
        printSection("8. BIGDECIMAL - SCALE E PRECISION");
        
        System.out.println("Ogni BigDecimal ha due proprietà fondamentali:\n");
        System.out.println("  • PRECISION: numero totale di cifre significative");
        System.out.println("  • SCALE: numero di cifre dopo la virgola decimale\n");
        
        printSubSection("Esempi di Scale e Precision");
        
        BigDecimal bd1 = new BigDecimal("123.45");
        System.out.println("BigDecimal bd1 = new BigDecimal(\"123.45\");");
        System.out.println("  Valore:     " + bd1);
        System.out.println("  Precision:  " + bd1.precision() + " (5 cifre totali: 1,2,3,4,5)");
        System.out.println("  Scale:      " + bd1.scale() + " (2 cifre dopo la virgola)\n");
        
        BigDecimal bd2 = new BigDecimal("0.00123");
        System.out.println("BigDecimal bd2 = new BigDecimal(\"0.00123\");");
        System.out.println("  Valore:     " + bd2);
        System.out.println("  Precision:  " + bd2.precision() + " (3 cifre significative: 1,2,3)");
        System.out.println("  Scale:      " + bd2.scale() + " (5 cifre dopo la virgola)\n");
        
        BigDecimal bd3 = new BigDecimal("1230000");
        System.out.println("BigDecimal bd3 = new BigDecimal(\"1230000\");");
        System.out.println("  Valore:     " + bd3);
        System.out.println("  Precision:  " + bd3.precision() + " (7 cifre: tutti gli zeri contano)");
        System.out.println("  Scale:      " + bd3.scale() + " (nessuna cifra decimale)\n");
        
        printSubSection("Modificare lo Scale con setScale");
        
        BigDecimal original = new BigDecimal("123.456789");
        System.out.println("BigDecimal original = new BigDecimal(\"123.456789\");");
        System.out.println("  → " + original + " (scale = " + original.scale() + ")\n");
        
        // Ridurre lo scale (richiede RoundingMode)
        BigDecimal scaled2 = original.setScale(2, RoundingMode.HALF_UP);
        System.out.println("BigDecimal scaled2 = original.setScale(2, RoundingMode.HALF_UP);");
        System.out.println("  → " + scaled2 + " (scale = " + scaled2.scale() + ")\n");
        
        // Aumentare lo scale (aggiunge zeri, no RoundingMode necessario)
        BigDecimal scaled10 = original.setScale(10, RoundingMode.UNNECESSARY);
        System.out.println("BigDecimal scaled10 = original.setScale(10, RoundingMode.UNNECESSARY);");
        System.out.println("  → " + scaled10 + " (scale = " + scaled10.scale() + ")\n");
        
        printSubSection("⚠️ ATTENZIONE: setScale senza RoundingMode");
        
        System.out.println("Ridurre lo scale SENZA RoundingMode causa errore se necessario arrotondare:\n");
        try {
            BigDecimal fail = original.setScale(2);  // Deprecato e pericoloso
            System.out.println("Result: " + fail);
        } catch (ArithmeticException e) {
            System.out.println("original.setScale(2);  // senza RoundingMode");
            System.out.println("✗ ArithmeticException: " + e.getMessage() + "\n");
        }
        
        printSubSection("stripTrailingZeros - Rimuove Zeri Non Significativi");
        
        BigDecimal withZeros = new BigDecimal("123.4500");
        BigDecimal stripped = withZeros.stripTrailingZeros();
        
        System.out.println("BigDecimal withZeros = new BigDecimal(\"123.4500\");");
        System.out.println("  → " + withZeros + " (scale = " + withZeros.scale() + ")");
        System.out.println("\nBigDecimal stripped = withZeros.stripTrailingZeros();");
        System.out.println("  → " + stripped + " (scale = " + stripped.scale() + ")\n");
        
        printSubSection("💡 Scale in Operazioni Aritmetiche");
        
        BigDecimal a = new BigDecimal("10.5");    // scale = 1
        BigDecimal b = new BigDecimal("2.25");    // scale = 2
        
        System.out.println("BigDecimal a = new BigDecimal(\"10.5\");    // scale = 1");
        System.out.println("BigDecimal b = new BigDecimal(\"2.25\");    // scale = 2\n");
        
        BigDecimal sum = a.add(b);
        System.out.println("a.add(b)      → " + sum + " (scale = " + sum.scale() + " - max dei due)");
        
        BigDecimal prod = a.multiply(b);
        System.out.println("a.multiply(b) → " + prod + " (scale = " + prod.scale() + " - somma: 1+2)");
        
        BigDecimal quot = a.divide(b, 5, RoundingMode.HALF_UP);
        System.out.println("a.divide(b, 5, HALF_UP) → " + quot + " (scale = 5 - specificato)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 9: BigDecimal - Rounding Modes
     * 
     * Esplora tutti i modi di arrotondamento disponibili
     */
    private static void demoBigDecimalRounding() {
        printSection("9. BIGDECIMAL - ROUNDING MODES (MODALITÀ DI ARROTONDAMENTO)");
        
        System.out.println("Java fornisce 8 modalità di arrotondamento (RoundingMode enum).\n");
        
        printSubSection("Valore di Test");
        
        BigDecimal positive = new BigDecimal("2.5");
        BigDecimal negative = new BigDecimal("-2.5");
        BigDecimal posHigh = new BigDecimal("2.6");
        BigDecimal posLow = new BigDecimal("2.4");
        
        System.out.println("Testeremo con questi valori:");
        System.out.println("  positive = 2.5   negative = -2.5");
        System.out.println("  posHigh = 2.6    posLow = 2.4\n");
        
        printSubSection("RoundingMode.UP - Arrotonda SEMPRE verso l'infinito");
        
        System.out.println("Arrotonda lontano dallo zero (aumenta modulo):\n");
        System.out.println("  2.5  →  " + positive.setScale(0, RoundingMode.UP));
        System.out.println("  2.4  →  " + posLow.setScale(0, RoundingMode.UP));
        System.out.println(" -2.5  →  " + negative.setScale(0, RoundingMode.UP) + "\n");
        
        printSubSection("RoundingMode.DOWN - Arrotonda SEMPRE verso zero");
        
        System.out.println("Arrotonda verso zero (riduce modulo, tronca):\n");
        System.out.println("  2.5  →  " + positive.setScale(0, RoundingMode.DOWN));
        System.out.println("  2.6  →  " + posHigh.setScale(0, RoundingMode.DOWN));
        System.out.println(" -2.5  →  " + negative.setScale(0, RoundingMode.DOWN) + "\n");
        
        printSubSection("RoundingMode.CEILING - Arrotonda verso +infinito");
        
        System.out.println("Arrotonda sempre in alto (verso il soffitto):\n");
        System.out.println("  2.5  →  " + positive.setScale(0, RoundingMode.CEILING));
        System.out.println("  2.4  →  " + posLow.setScale(0, RoundingMode.CEILING));
        System.out.println(" -2.5  →  " + negative.setScale(0, RoundingMode.CEILING));
        System.out.println(" -2.6  →  " + new BigDecimal("-2.6").setScale(0, RoundingMode.CEILING) + "\n");
        
        printSubSection("RoundingMode.FLOOR - Arrotonda verso -infinito");
        
        System.out.println("Arrotonda sempre in basso (verso il pavimento):\n");
        System.out.println("  2.5  →  " + positive.setScale(0, RoundingMode.FLOOR));
        System.out.println("  2.6  →  " + posHigh.setScale(0, RoundingMode.FLOOR));
        System.out.println(" -2.5  →  " + negative.setScale(0, RoundingMode.FLOOR));
        System.out.println(" -2.4  →  " + new BigDecimal("-2.4").setScale(0, RoundingMode.FLOOR) + "\n");
        
        printSubSection("RoundingMode.HALF_UP - Arrotondamento Commerciale Standard");
        
        System.out.println("Arrotonda al più vicino, se .5 arrotonda VERSO L'ALTO:\n");
        System.out.println("  2.5  →  " + positive.setScale(0, RoundingMode.HALF_UP));
        System.out.println("  2.4  →  " + posLow.setScale(0, RoundingMode.HALF_UP));
        System.out.println("  2.6  →  " + posHigh.setScale(0, RoundingMode.HALF_UP));
        System.out.println(" -2.5  →  " + negative.setScale(0, RoundingMode.HALF_UP));
        System.out.println("\n💡 HALF_UP è il metodo più comune (arrotondamento scolastico)\n");
        
        printSubSection("RoundingMode.HALF_DOWN - Arrotonda .5 verso il basso");
        
        System.out.println("Arrotonda al più vicino, se .5 arrotonda VERSO IL BASSO:\n");
        System.out.println("  2.5  →  " + positive.setScale(0, RoundingMode.HALF_DOWN));
        System.out.println("  2.6  →  " + posHigh.setScale(0, RoundingMode.HALF_DOWN));
        System.out.println(" -2.5  →  " + negative.setScale(0, RoundingMode.HALF_DOWN) + "\n");
        
        printSubSection("RoundingMode.HALF_EVEN - Banker's Rounding");
        
        System.out.println("Arrotonda al più vicino, se .5 arrotonda al PARI più vicino:\n");
        System.out.println("  2.5  →  " + positive.setScale(0, RoundingMode.HALF_EVEN) + " (2 è pari)");
        System.out.println("  3.5  →  " + new BigDecimal("3.5").setScale(0, RoundingMode.HALF_EVEN) + " (4 è pari)");
        System.out.println("  4.5  →  " + new BigDecimal("4.5").setScale(0, RoundingMode.HALF_EVEN) + " (4 è pari)");
        System.out.println("  5.5  →  " + new BigDecimal("5.5").setScale(0, RoundingMode.HALF_EVEN) + " (6 è pari)");
        System.out.println("\n💡 HALF_EVEN riduce il bias cumulativo in serie di arrotondamenti\n");
        
        printSubSection("RoundingMode.UNNECESSARY - Nessun Arrotondamento");
        
        System.out.println("Fallisce se l'operazione richiederebbe arrotondamento:\n");
        
        BigDecimal exact = new BigDecimal("2.00");
        System.out.println("  2.00 → " + exact.setScale(1, RoundingMode.UNNECESSARY) + " ✓ OK");
        
        try {
            BigDecimal fail = positive.setScale(0, RoundingMode.UNNECESSARY);
            System.out.println("Result: " + fail);
        } catch (ArithmeticException e) {
            System.out.println("  2.5  → ArithmeticException ✗ (richiederebbe arrotondamento)\n");
        }
        
        printSubSection("📊 Tabella Riepilogativa");
        
        System.out.println("┌─────────────────┬────────┬────────┬─────────┬───────────────────────┐");
        System.out.println("│  RoundingMode   │  2.5   │  2.4   │  -2.5   │    DESCRIZIONE        │");
        System.out.println("├─────────────────┼────────┼────────┼─────────┼───────────────────────┤");
        System.out.println("│ UP              │   3    │   3    │   -3    │ Lontano da zero       │");
        System.out.println("│ DOWN            │   2    │   2    │   -2    │ Verso zero (tronca)   │");
        System.out.println("│ CEILING         │   3    │   3    │   -2    │ Verso +∞              │");
        System.out.println("│ FLOOR           │   2    │   2    │   -3    │ Verso -∞              │");
        System.out.println("│ HALF_UP         │   3    │   2    │   -3    │ .5 → su (standard)    │");
        System.out.println("│ HALF_DOWN       │   2    │   2    │   -2    │ .5 → giù              │");
        System.out.println("│ HALF_EVEN       │   2    │   2    │   -2    │ .5 → pari (banker's)  │");
        System.out.println("│ UNNECESSARY     │  ERR   │   2    │   ERR   │ No arrotondamento     │");
        System.out.println("└─────────────────┴────────┴────────┴─────────┴───────────────────────┘\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 10: BigDecimal - Comparazioni
     * 
     * Mostra come confrontare correttamente BigDecimal
     */
    private static void demoBigDecimalComparison() {
        printSection("10. BIGDECIMAL - COMPARAZIONI");
        
        printSubSection("⚠️ PROBLEMA: equals() Considera lo Scale!");
        
        BigDecimal a = new BigDecimal("2.0");
        BigDecimal b = new BigDecimal("2.00");
        
        System.out.println("BigDecimal a = new BigDecimal(\"2.0\");   // scale = 1");
        System.out.println("BigDecimal b = new BigDecimal(\"2.00\");  // scale = 2\n");
        
        boolean equalsResult = a.equals(b);
        System.out.println("a.equals(b)  →  " + equalsResult);
        System.out.println("  ✗ FALSE! Anche se matematicamente uguali, hanno scale diversi!\n");
        
        printSubSection("✓ SOLUZIONE: compareTo() per Uguaglianza Matematica");
        
        int compareResult = a.compareTo(b);
        System.out.println("a.compareTo(b)  →  " + compareResult);
        System.out.println("  ✓ ZERO = matematicamente uguali (ignora scale)\n");
        
        printSubSection("Confronti con compareTo");
        
        BigDecimal x = new BigDecimal("100.5");
        BigDecimal y = new BigDecimal("200.3");
        BigDecimal z = new BigDecimal("100.5");
        
        System.out.println("BigDecimal x = new BigDecimal(\"100.5\");");
        System.out.println("BigDecimal y = new BigDecimal(\"200.3\");");
        System.out.println("BigDecimal z = new BigDecimal(\"100.5\");\n");
        
        System.out.println("x.compareTo(y)  →  " + x.compareTo(y) + "  (negativo: x < y)");
        System.out.println("y.compareTo(x)  →  " + y.compareTo(x) + "  (positivo: y > x)");
        System.out.println("x.compareTo(z)  →  " + x.compareTo(z) + "  (zero: x == z)\n");
        
        printSubSection("Metodi Helper per Confronti");
        
        System.out.println("x.min(y)  →  " + x.min(y) + "  (il più piccolo)");
        System.out.println("x.max(y)  →  " + x.max(y) + "  (il più grande)\n");
        
        printSubSection("💡 Best Practice per Confronti");
        
        System.out.println("┌──────────────────────────┬─────────────────────────────────────┐");
        System.out.println("│       METODO             │           QUANDO USARLO             │");
        System.out.println("├──────────────────────────┼─────────────────────────────────────┤");
        System.out.println("│ equals()                 │ Uguaglianza ESATTA (valore + scale) │");
        System.out.println("│ compareTo() == 0         │ Uguaglianza MATEMATICA (solo valore)│");
        System.out.println("│ compareTo() < 0          │ Minore di                           │");
        System.out.println("│ compareTo() > 0          │ Maggiore di                         │");
        System.out.println("└──────────────────────────┴─────────────────────────────────────┘\n");
        
        System.out.println("ESEMPIO PRATICO:");
        
        BigDecimal price1 = new BigDecimal("10.5");
        BigDecimal price2 = new BigDecimal("10.50");
        
        System.out.println("BigDecimal price1 = new BigDecimal(\"10.5\");");
        System.out.println("BigDecimal price2 = new BigDecimal(\"10.50\");\n");
        
        System.out.println("// Confronto per uguaglianza MATEMATICA (corretto per prezzi)");
        if (price1.compareTo(price2) == 0) {
            System.out.println("✓ Prezzi uguali (matematicamente)\n");
        }
        
        System.out.println("// Confronto ESATTO (probabilmente non quello che vuoi)");
        if (price1.equals(price2)) {
            System.out.println("Identici (valore + scale)");
        } else {
            System.out.println("✗ Diversi (scale differenti: 1 vs 2)\n");
        }
        
        waitForEnter();
    }

    /**
     * SEZIONE 11: Performance e Considerazioni Pratiche
     * 
     * Discute aspetti di performance e quando usare BigDecimal/BigInteger
     */
    private static void demoPerformanceConsiderations() {
        printSection("11. PERFORMANCE E CONSIDERAZIONI PRATICHE");
        
        printSubSection("⚠️ BigDecimal/BigInteger sono LENTI");
        
        System.out.println("Le operazioni con BigDecimal/BigInteger sono MOLTO più lente");
        System.out.println("rispetto ai tipi primitivi (int, long, double).\n");
        
        System.out.println("MOTIVI:");
        System.out.println("  • Allocazione di oggetti (heap)");
        System.out.println("  • Immutabilità (creano nuovi oggetti ad ogni operazione)");
        System.out.println("  • Garbage collection overhead");
        System.out.println("  • Algoritmi complessi per precisione arbitraria\n");
        
        printSubSection("💡 Quando Usare Tipi Primitivi vs BigDecimal/BigInteger");
        
        System.out.println("USA TIPI PRIMITIVI (int, long, double) quando:");
        System.out.println("  ✓ Performance è critica");
        System.out.println("  ✓ I valori stanno nel range dei primitivi");
        System.out.println("  ✓ Piccoli errori di arrotondamento sono accettabili");
        System.out.println("  ✓ Applicazioni scientifiche/ingegneristiche generiche\n");
        
        System.out.println("USA BIGDECIMAL quando:");
        System.out.println("  ✓ Precisione ESATTA è richiesta (calcoli finanziari!)");
        System.out.println("  ✓ Calcoli monetari (denaro)");
        System.out.println("  ✓ Percentuali e tassi d'interesse");
        System.out.println("  ✓ Conformità normativa/legale");
        System.out.println("  ✗ NON per calcoli intensivi in loop\n");
        
        System.out.println("USA BIGINTEGER quando:");
        System.out.println("  ✓ Numeri interi oltre range long");
        System.out.println("  ✓ Fattoriali, combinatoria, Fibonacci grandi");
        System.out.println("  ✓ Crittografia (chiavi, modular exponentiation)");
        System.out.println("  ✓ Calcoli matematici con interi molto grandi\n");
        
        printSubSection("🎯 Ottimizzazioni Pratiche");
        
        System.out.println("1. RIUTILIZZA COSTANTI:");
        System.out.println("   // ✗ Inefficiente");
        System.out.println("   for (int i = 0; i < 1000; i++) {");
        System.out.println("       result = result.multiply(new BigDecimal(\"1.05\"));  // crea 1000 oggetti!");
        System.out.println("   }");
        System.out.println();
        System.out.println("   // ✓ Efficiente");
        System.out.println("   BigDecimal FACTOR = new BigDecimal(\"1.05\");  // riutilizza");
        System.out.println("   for (int i = 0; i < 1000; i++) {");
        System.out.println("       result = result.multiply(FACTOR);");
        System.out.println("   }\n");
        
        System.out.println("2. USA valueOf PER PICCOLI NUMERI:");
        System.out.println("   BigDecimal.valueOf(10)     // ✓ può usare cache interna");
        System.out.println("   new BigDecimal(\"10\")       // ✗ sempre nuovo oggetto\n");
        
        System.out.println("3. ATTENZIONE AI LOOP:");
        System.out.println("   Evita BigDecimal in loop tight (milioni di iterazioni)");
        System.out.println("   Considera se long con scaling manuale è sufficiente\n");
        
        printSubSection("💰 Esempio: Scaling Manuale per Performance");
        
        System.out.println("Per somme monetarie semplici, puoi usare long (centesimi):\n");
        
        // Con long (performance)
        long priceInCents = 1050;  // 10.50 €
        long taxInCents = 220;     // 2.20 €
        long totalCents = priceInCents + taxInCents;
        double totalEuros = totalCents / 100.0;
        
        System.out.println("// Con long (rapido, ma limitato)");
        System.out.println("long priceInCents = 1050;  // 10.50 €");
        System.out.println("long taxInCents = 220;     // 2.20 €");
        System.out.println("long totalCents = priceInCents + taxInCents;");
        System.out.println("  → " + totalCents + " centesimi = " + totalEuros + " €\n");
        
        System.out.println("⚠️ Limiti del long:");
        System.out.println("  • Max ~92 milioni di miliardi di centesimi");
        System.out.println("  • No operazioni complesse (divisioni non esatte)");
        System.out.println("  • Rischio overflow se non controllato\n");
        
        System.out.println("💡 REGOLA PRATICA:");
        System.out.println("  Se devi chiedere \"posso usare long?\", usa BigDecimal (più sicuro)\n");
        
        printSubSection("🔒 Thread Safety");
        
        System.out.println("BigDecimal e BigInteger sono IMMUTABILI:");
        System.out.println("  ✓ Intrinsecamente thread-safe");
        System.out.println("  ✓ Possono essere condivisi tra thread senza sincronizzazione");
        System.out.println("  ✓ Sicuri come chiavi in HashMap, in Set, ecc.\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 12: Best Practices
     * 
     * Raccolta di best practices professionali per BigDecimal e BigInteger
     */
    private static void demoBestPractices() {
        printSection("12. BEST PRACTICES");
        
        printSubSection("1. ✓ Creazione di BigDecimal");
        
        System.out.println("✓ USA String per creare BigDecimal:");
        System.out.println("   BigDecimal price = new BigDecimal(\"19.99\");  // CORRETTO\n");
        
        System.out.println("✗ MAI usare double:");
        System.out.println("   BigDecimal price = new BigDecimal(19.99);  // SBAGLIATO (impreciso!)\n");
        
        System.out.println("✓ valueOf OK per letterali semplici:");
        System.out.println("   BigDecimal.valueOf(10.5)  // Accettabile\n");
        
        printSubSection("2. ✓ Divisione con RoundingMode");
        
        System.out.println("✓ SEMPRE specifica RoundingMode per divisioni:");
        System.out.println("   result = a.divide(b, 2, RoundingMode.HALF_UP);  // CORRETTO\n");
        
        System.out.println("✗ MAI senza RoundingMode (se non esatta):");
        System.out.println("   result = a.divide(b);  // ArithmeticException se non esatta!\n");
        
        printSubSection("3. ✓ Confronti con compareTo");
        
        System.out.println("✓ USA compareTo per confronti matematici:");
        System.out.println("   if (price1.compareTo(price2) == 0) { ... }  // CORRETTO\n");
        
        System.out.println("✗ EVITA equals per confronti di valore:");
        System.out.println("   if (price1.equals(price2)) { ... }  // Confronta anche scale!\n");
        
        printSubSection("4. ✓ Immutabilità");
        
        System.out.println("✓ RICORDA: ogni operazione crea un NUOVO oggetto:");
        System.out.println("   price = price.add(tax);  // ✓ CORRETTO (riassegna)");
        System.out.println("   price.add(tax);          // ✗ SBAGLIATO (risultato perso!)\n");
        
        printSubSection("5. ✓ Costanti e Riutilizzo");
        
        System.out.println("✓ DEFINISCI costanti per valori riutilizzati:");
        System.out.println("   private static final BigDecimal VAT_RATE = new BigDecimal(\"0.22\");");
        System.out.println("   private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);\n");
        
        printSubSection("6. ✓ Scale Appropriato");
        
        System.out.println("✓ USA scale appropriato per il dominio:");
        System.out.println("   // Denaro: 2 decimali");
        System.out.println("   BigDecimal price = amount.setScale(2, RoundingMode.HALF_UP);");
        System.out.println();
        System.out.println("   // Percentuali: 4 decimali");
        System.out.println("   BigDecimal rate = percent.setScale(4, RoundingMode.HALF_UP);");
        System.out.println();
        System.out.println("   // Calcoli scientifici: 10+ decimali");
        System.out.println("   BigDecimal result = value.setScale(10, RoundingMode.HALF_UP);\n");
        
        printSubSection("7. ✓ Null Safety");
        
        System.out.println("✓ CONTROLLA null prima di operazioni:");
        System.out.println("   if (price != null && price.compareTo(BigDecimal.ZERO) > 0) {");
        System.out.println("       // safe to use");
        System.out.println("   }\n");
        
        printSubSection("8. ✓ Documentazione del RoundingMode");
        
        System.out.println("✓ DOCUMENTA la scelta del RoundingMode:");
        System.out.println("   // Usa HALF_UP per arrotondamento commerciale standard");
        System.out.println("   total = subtotal.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);\n");
        
        printSubSection("9. ✓ Validazione Input");
        
        System.out.println("✓ VALIDA input da utenti/fonti esterne:");
        System.out.println("   try {");
        System.out.println("       BigDecimal price = new BigDecimal(userInput);");
        System.out.println("       if (price.compareTo(BigDecimal.ZERO) < 0) {");
        System.out.println("           throw new IllegalArgumentException(\"Prezzo negativo\");");
        System.out.println("       }");
        System.out.println("   } catch (NumberFormatException e) {");
        System.out.println("       // gestisci input non valido");
        System.out.println("   }\n");
        
        printSubSection("10. ✓ MathContext per Operazioni Complesse");
        
        System.out.println("✓ USA MathContext per precisione controllata:");
        System.out.println("   MathContext mc = new MathContext(10, RoundingMode.HALF_UP);");
        System.out.println("   BigDecimal result = a.divide(b, mc);  // 10 cifre significative\n");
        
        printSubSection("📝 Checklist Finale");
        
        System.out.println("Prima di usare BigDecimal/BigInteger, chiediti:");
        System.out.println("  ☑ La precisione esatta è davvero necessaria?");
        System.out.println("  ☑ I tipi primitivi sono insufficienti?");
        System.out.println("  ☑ Ho specificato RoundingMode per divisioni?");
        System.out.println("  ☑ Sto usando compareTo (non equals) per confronti?");
        System.out.println("  ☑ Sto creando da String (non da double)?");
        System.out.println("  ☑ Sto riassegnando il risultato (immutabilità)?");
        System.out.println("  ☑ Lo scale è appropriato per il dominio?");
        System.out.println("  ☑ Ho gestito NumberFormatException?");
        System.out.println("  ☑ Ho considerato performance in loop?\n");
        
        System.out.println("💡 REGOLA D'ORO:");
        System.out.println("\"Per il denaro, usa SEMPRE BigDecimal con String constructor.\"");
        System.out.println("\"Per tutto il resto, valuta se i primitivi sono sufficienti.\"\n");
        
        waitForEnter();
    }

    // ==================== METODI UTILITY PER FORMATTAZIONE ====================

    /**
     * Stampa un'intestazione principale
     */
    private static void printHeader(String title) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("  " + title);
        System.out.println("=".repeat(80) + "\n");
    }

    /**
     * Stampa un separatore di sezione
     */
    private static void printSection(String sectionTitle) {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("📝 " + sectionTitle);
        System.out.println("─".repeat(80) + "\n");
    }

    /**
     * Stampa una sotto-sezione
     */
    private static void printSubSection(String subSectionTitle) {
        System.out.println("┌─ " + subSectionTitle);
        System.out.println("│");
    }

    /**
     * Stampa un footer finale
     */
    private static void printFooter() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("  ✓ DEMO COMPLETATA - Hai appreso tutto su BigDecimal e BigInteger!");
        System.out.println("=".repeat(80) + "\n");
    }

    /**
     * Attende che l'utente prema INVIO per continuare
     */
    private static void waitForEnter() {
        System.out.println("─".repeat(80));
        System.out.print("Premi INVIO per continuare...");
        try {
            System.in.read();
            // Consuma eventuali caratteri rimanenti nel buffer
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (Exception e) {
            // Ignora eventuali eccezioni
        }
        System.out.println();
    }
}
