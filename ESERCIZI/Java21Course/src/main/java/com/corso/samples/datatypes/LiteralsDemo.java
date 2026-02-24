package com.corso.samples.datatypes;

/**
 * Classe demo completa per l'apprendimento dei LETTERALI (LITERALS) in Java
 * 
 * Un letterale è un valore costante scritto direttamente nel codice sorgente.
 * Java supporta diversi tipi di letterali per rappresentare valori di tipi diversi.
 * 
 * TIPI DI LETTERALI IN JAVA:
 * - Letterali interi (int, long)
 * - Letterali floating-point (float, double)
 * - Letterali carattere (char)
 * - Letterali stringa (String)
 * - Letterali booleani (true, false)
 * - Letterale null
 * - Text blocks (Java 13+)
 * 
 * @author Java 21 Course
 * @version 1.0
 */
public class LiteralsDemo {

    /**
     * Metodo principale che esegue tutte le demo sui letterali
     * Questo metodo orchestra l'esecuzione sequenziale di tutte le sezioni
     */
    public static void run() {
        printHeader("DEMO COMPLETA: LETTERALI (LITERALS) IN JAVA");
        
        // Sezione 1: Introduzione ai letterali
        demoIntroduction();
        
        // Sezione 2: Letterali interi decimali
        demoIntegerLiteralsDecimal();
        
        // Sezione 3: Letterali interi in altre basi (binario, ottale, esadecimale)
        demoIntegerLiteralsBases();
        
        // Sezione 4: Letterali long e suffisso L
        demoLongLiterals();
        
        // Sezione 5: Letterali floating-point (float e double)
        demoFloatingPointLiterals();
        
        // Sezione 6: Underscore nei letterali numerici (Java 7+)
        demoUnderscoreInLiterals();
        
        // Sezione 7: Letterali carattere (char)
        demoCharacterLiterals();
        
        // Sezione 8: Letterali stringa
        demoStringLiterals();
        
        // Sezione 9: Text blocks - Stringhe multilinea (Java 13+)
        demoTextBlocks();
        
        // Sezione 10: Letterali booleani
        demoBooleanLiterals();
        
        // Sezione 11: Letterale null
        demoNullLiteral();
        
        // Sezione 12: Best practices con i letterali
        demoBestPractices();
        
        printFooter();
    }

    /**
     * SEZIONE 1: Introduzione ai Letterali
     * 
     * Spiega cosa sono i letterali e perché sono importanti
     */
    private static void demoIntroduction() {
        printSection("1. INTRODUZIONE AI LETTERALI");
        
        System.out.println("Un LETTERALE è un valore costante scritto direttamente nel codice.");
        System.out.println("È la rappresentazione testuale di un valore di un tipo di dato.\n");
        
        printSubSection("Esempi di Letterali");
        
        System.out.println("42            → Letterale intero (tipo int)");
        System.out.println("3.14          → Letterale floating-point (tipo double)");
        System.out.println("'A'           → Letterale carattere (tipo char)");
        System.out.println("\"Hello\"       → Letterale stringa (tipo String)");
        System.out.println("true          → Letterale booleano (tipo boolean)");
        System.out.println("null          → Letterale null\n");
        
        printSubSection("Differenza tra Letterali e Variabili");
        
        // Letterale: valore scritto direttamente
        int number = 42;  // 42 è un letterale
        
        // Variabile: contenitore che può cambiare valore
        int anotherNumber = number;  // number è una variabile, non un letterale
        
        System.out.println("int number = 42;");
        System.out.println("  → 42 è un LETTERALE (valore costante nel codice)");
        System.out.println("  → number è una VARIABILE (contenitore per il valore)\n");
        
        System.out.println("int anotherNumber = number;");
        System.out.println("  → number è una VARIABILE (non un letterale)\n");
        
        printSubSection("Caratteristiche dei Letterali");
        
        System.out.println("✓ I letterali sono COSTANTI (non possono essere modificati)");
        System.out.println("✓ Il tipo del letterale è determinato dalla sua forma");
        System.out.println("✓ Il compilatore valuta i letterali a compile-time");
        System.out.println("✓ I letterali possono essere usati ovunque sia richiesto un valore\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 2: Letterali Interi Decimali
     * 
     * I letterali interi in base 10 sono il modo più comune di scrivere numeri.
     * Per default, un letterale intero è di tipo int.
     */
    private static void demoIntegerLiteralsDecimal() {
        printSection("2. LETTERALI INTERI DECIMALI (BASE 10)");
        
        System.out.println("I letterali interi decimali sono numeri scritti in base 10.");
        System.out.println("Senza suffisso, sono sempre di tipo INT (32 bit).\n");
        
        printSubSection("Sintassi dei Letterali Decimali");
        
        // Letterali interi semplici
        int zero = 0;
        int positive = 42;
        int negative = -100;
        int large = 2147483647;  // Integer.MAX_VALUE
        
        System.out.println("int zero = 0;              → " + zero);
        System.out.println("int positive = 42;         → " + positive);
        System.out.println("int negative = -100;       → " + negative);
        System.out.println("int large = 2147483647;    → " + large + " (Integer.MAX_VALUE)\n");
        
        printSubSection("⚠️ Tipo Predefinito: INT");
        
        System.out.println("Tutti i letterali interi (senza suffisso) sono di tipo INT:");
        System.out.println("  0      → int");
        System.out.println("  42     → int");
        System.out.println("  1000   → int");
        System.out.println("  999999 → int\n");
        
        printSubSection("Range dei Letterali INT");
        
        System.out.println("I letterali int devono essere nel range:");
        System.out.println("  MIN: " + Integer.MIN_VALUE + " (-2^31)");
        System.out.println("  MAX: " + Integer.MAX_VALUE + " (2^31 - 1)\n");
        
        // Tentare di usare un letterale fuori range causa errore di compilazione
        System.out.println("⚠️ ATTENZIONE:");
        System.out.println("  // int overflow = 2147483648;  // ✗ ERRORE! Fuori range per int");
        System.out.println("  // Soluzione: usa long con suffisso L");
        System.out.println("  long correct = 2147483648L;     // ✓ OK!\n");
        
        printSubSection("Segno dei Letterali");
        
        System.out.println("Il segno - (meno) NON fa parte del letterale!");
        System.out.println("È un operatore unario applicato al letterale:\n");
        
        int negativeNumber = -42;
        System.out.println("int negativeNumber = -42;");
        System.out.println("  → 42 è il letterale (positivo)");
        System.out.println("  → - è l'operatore di negazione unario");
        System.out.println("  → Risultato: " + negativeNumber + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 3: Letterali Interi in Altre Basi
     * 
     * Java permette di scrivere letterali interi in binario, ottale ed esadecimale.
     * Questo è utile per lavorare con bit, permessi, colori, ecc.
     */
    private static void demoIntegerLiteralsBases() {
        printSection("3. LETTERALI INTERI IN ALTRE BASI");
        
        System.out.println("Java supporta 4 basi numeriche per i letterali interi:\n");
        
        printSubSection("BINARIO (Base 2) - Prefisso 0b o 0B");
        
        // Letterali binari (introdotti in Java 7)
        int binary1 = 0b1010;        // 10 in decimale
        int binary2 = 0B11111111;    // 255 in decimale
        int binary3 = 0b0001_0010;   // 18 in decimale (con underscore)
        
        System.out.println("Sintassi: 0b seguito da cifre binarie (0 e 1)");
        System.out.println("Usa il prefisso 0b (zero-b minuscolo) o 0B (zero-B maiuscolo)\n");
        
        System.out.println("int binary1 = 0b1010;        → " + binary1 + " (decimale)");
        System.out.println("int binary2 = 0B11111111;    → " + binary2 + " (decimale)");
        System.out.println("int binary3 = 0b0001_0010;   → " + binary3 + " (decimale)\n");
        
        System.out.println("💡 USO COMUNE: Maschere di bit, flag, operazioni binarie");
        System.out.println("  int READ = 0b0100;   // Permesso lettura");
        System.out.println("  int WRITE = 0b0010;  // Permesso scrittura");
        System.out.println("  int EXEC = 0b0001;   // Permesso esecuzione\n");
        
        printSubSection("OTTALE (Base 8) - Prefisso 0");
        
        // Letterali ottali (notazione tradizionale Unix per permessi)
        int octal1 = 077;      // 63 in decimale
        int octal2 = 0755;     // 493 in decimale (permessi Unix rwxr-xr-x)
        int octal3 = 01234;    // 668 in decimale
        
        System.out.println("Sintassi: 0 seguito da cifre ottali (0-7)");
        System.out.println("⚠️ ATTENZIONE: 0 iniziale indica ottale, non decimale!\n");
        
        System.out.println("int octal1 = 077;      → " + octal1 + " (decimale)");
        System.out.println("int octal2 = 0755;     → " + octal2 + " (decimale, permessi Unix)");
        System.out.println("int octal3 = 01234;    → " + octal3 + " (decimale)\n");
        
        System.out.println("💡 USO COMUNE: Permessi file Unix/Linux");
        System.out.println("  0644 → rw-r--r--  (owner: rw, group: r, others: r)");
        System.out.println("  0755 → rwxr-xr-x  (owner: rwx, group: rx, others: rx)\n");
        
        System.out.println("⚠️ ERRORE COMUNE:");
        int misleading = 0123;  // NON è 123! È 83 in decimale!
        System.out.println("  int misleading = 0123; → " + misleading + " (NON 123!)");
        System.out.println("  Lo 0 iniziale lo rende OTTALE!\n");
        
        printSubSection("ESADECIMALE (Base 16) - Prefisso 0x o 0X");
        
        // Letterali esadecimali (molto comuni in programmazione)
        int hex1 = 0xFF;           // 255 in decimale
        int hex2 = 0x1A2B;         // 6699 in decimale
        int hex3 = 0xCAFEBABE;     // Magic number Java class file
        int hex4 = 0xDEADBEEF;     // Valore di debug comune
        
        System.out.println("Sintassi: 0x seguito da cifre esadecimali (0-9, A-F)");
        System.out.println("Le lettere possono essere maiuscole o minuscole\n");
        
        System.out.println("int hex1 = 0xFF;         → " + hex1 + " (decimale)");
        System.out.println("int hex2 = 0x1A2B;       → " + hex2 + " (decimale)");
        System.out.println("int hex3 = 0xCAFEBABE;   → " + hex3 + " (magic number Java)");
        System.out.println("int hex4 = 0xDEADBEEF;   → " + hex4 + " (valore debug)\n");
        
        System.out.println("💡 USO COMUNE: Colori RGB, indirizzi memoria, magic numbers");
        System.out.println("  0xFF0000 → Rosso puro (RGB)");
        System.out.println("  0x00FF00 → Verde puro (RGB)");
        System.out.println("  0x0000FF → Blu puro (RGB)\n");
        
        printSubSection("Confronto tra le Basi");
        
        int value = 42;
        System.out.println("Lo stesso valore (42) in diverse basi:");
        System.out.println("┌───────────┬──────────────┬──────────┐");
        System.out.println("│   BASE    │   LETTERALE  │  VALORE  │");
        System.out.println("├───────────┼──────────────┼──────────┤");
        System.out.println("│ Decimale  │      42      │    " + 42 + "    │");
        System.out.println("│ Binario   │   0b101010   │    " + 0b101010 + "    │");
        System.out.println("│ Ottale    │      052     │    " + 052 + "    │");
        System.out.println("│ Esadec.   │     0x2A     │    " + 0x2A + "    │");
        System.out.println("└───────────┴──────────────┴──────────┘\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 4: Letterali Long
     * 
     * I letterali long sono necessari per valori che superano il range di int.
     * Richiedono il suffisso L o l (si consiglia L maiuscolo).
     */
    private static void demoLongLiterals() {
        printSection("4. LETTERALI LONG (64 BIT)");
        
        System.out.println("Per letterali interi di tipo LONG, usa il suffisso L o l");
        System.out.println("⚠️ RACCOMANDAZIONE: Usa sempre L MAIUSCOLO (l minuscolo si confonde con 1)\n");
        
        printSubSection("Sintassi dei Letterali Long");
        
        // Letterali long con suffisso L
        long longValue1 = 100L;              // L maiuscolo (RACCOMANDATO)
        long longValue2 = 100l;              // l minuscolo (sconsigliato)
        long longValue3 = 9_223_372_036_854_775_807L;  // Long.MAX_VALUE
        
        System.out.println("long longValue1 = 100L;     → " + longValue1 + " (L maiuscolo ✓)");
        System.out.println("long longValue2 = 100l;     → " + longValue2 + " (l minuscolo, confuso con 1)");
        System.out.println("long longValue3 = 9_223_372_036_854_775_807L;");
        System.out.println("  → " + longValue3 + " (Long.MAX_VALUE)\n");
        
        printSubSection("⚠️ Quando il Suffisso L è OBBLIGATORIO");
        
        System.out.println("Il suffisso L è OBBLIGATORIO per valori fuori dal range di int:\n");
        
        // Questo funziona (dentro range int)
        long smallLong = 100;  // OK, autoconversione da int a long
        System.out.println("long smallLong = 100;       // ✓ OK (dentro range int)");
        System.out.println("  → " + smallLong + "\n");
        
        // Questo NON funziona (fuori range int)
        System.out.println("// long bigLong = 3000000000;  // ✗ ERRORE! Letterale fuori range int");
        long bigLong = 3000000000L;  // OK con suffisso L
        System.out.println("long bigLong = 3000000000L;    // ✓ OK con suffisso L");
        System.out.println("  → " + bigLong + "\n");
        
        printSubSection("Long in Diverse Basi");
        
        // Long può essere usato con tutte le basi
        long binaryLong = 0b1111111111111111L;    // Binario
        long octalLong = 0777777L;                 // Ottale
        long hexLong = 0xFFFFFFFFL;                // Esadecimale
        
        System.out.println("I letterali long supportano tutte le basi:\n");
        System.out.println("long binaryLong = 0b1111111111111111L; → " + binaryLong);
        System.out.println("long octalLong = 0777777L;             → " + octalLong);
        System.out.println("long hexLong = 0xFFFFFFFFL;            → " + hexLong + "\n");
        
        printSubSection("💡 Casi d'Uso Comuni per Long");
        
        System.out.println("✓ Timestamp (millisecondi dal 1970)");
        long timestamp = System.currentTimeMillis();
        System.out.println("  long timestamp = System.currentTimeMillis();");
        System.out.println("  → " + timestamp + "\n");
        
        System.out.println("✓ Dimensioni file grandi");
        long fileSize = 5_000_000_000L;  // 5 GB
        System.out.println("  long fileSize = 5_000_000_000L;  // 5 GB");
        System.out.println("  → " + fileSize + " byte\n");
        
        System.out.println("✓ Contatori per grandi quantità");
        long worldPopulation = 8_000_000_000L;
        System.out.println("  long worldPopulation = 8_000_000_000L;");
        System.out.println("  → " + worldPopulation + " persone\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 5: Letterali Floating-Point
     * 
     * I letterali floating-point rappresentano numeri con parte decimale.
     * Possono essere float (32 bit) o double (64 bit, default).
     */
    private static void demoFloatingPointLiterals() {
        printSection("5. LETTERALI FLOATING-POINT (DECIMALI)");
        
        System.out.println("I letterali con punto decimale sono floating-point.");
        System.out.println("⚠️ Per default, sono di tipo DOUBLE (64 bit)\n");
        
        printSubSection("Letterali DOUBLE (Tipo Predefinito)");
        
        // Letterali double (senza suffisso o con suffisso D/d)
        double d1 = 3.14;           // Forma standard
        double d2 = 3.14D;          // Con suffisso D (opzionale)
        double d3 = .5;             // Parte intera omessa (0.5)
        double d4 = 5.;             // Parte decimale omessa (5.0)
        double d5 = 0.0;            // Zero decimale
        
        System.out.println("double d1 = 3.14;    → " + d1 + " (forma standard)");
        System.out.println("double d2 = 3.14D;   → " + d2 + " (con suffisso D)");
        System.out.println("double d3 = .5;      → " + d3 + " (.5 = 0.5)");
        System.out.println("double d4 = 5.;      → " + d4 + " (5. = 5.0)");
        System.out.println("double d5 = 0.0;     → " + d5 + "\n");
        
        printSubSection("Letterali FLOAT (Suffisso F Obbligatorio)");
        
        // Letterali float richiedono SEMPRE il suffisso F o f
        float f1 = 3.14F;           // F maiuscolo (raccomandato)
        float f2 = 3.14f;           // f minuscolo (ok)
        float f3 = .5F;             // 0.5 come float
        
        System.out.println("⚠️ Il suffisso F è OBBLIGATORIO per float!\n");
        System.out.println("float f1 = 3.14F;    → " + f1 + " (F maiuscolo ✓)");
        System.out.println("float f2 = 3.14f;    → " + f2 + " (f minuscolo)");
        System.out.println("float f3 = .5F;      → " + f3 + "\n");
        
        System.out.println("// float f4 = 3.14;   // ✗ ERRORE! 3.14 è double, non compatibile");
        System.out.println("float f4 = 3.14F;      // ✓ CORRETTO\n");
        
        printSubSection("Notazione Scientifica (Esponenziale)");
        
        // Letterali con notazione scientifica (mantissa E esponente)
        double scientific1 = 1.23e2;      // 1.23 × 10^2 = 123.0
        double scientific2 = 1.23E2;      // E maiuscolo (equivalente)
        double scientific3 = 1.23e-4;     // 1.23 × 10^-4 = 0.000123
        float scientificF = 6.022e23F;    // Numero di Avogadro (come float)
        
        System.out.println("Formato: mantissa E esponente (E = ×10^)");
        System.out.println("La E può essere maiuscola o minuscola\n");
        
        System.out.println("double scientific1 = 1.23e2;   → " + scientific1 + " (1.23 × 10²)");
        System.out.println("double scientific2 = 1.23E2;   → " + scientific2 + " (E maiuscolo)");
        System.out.println("double scientific3 = 1.23e-4;  → " + scientific3 + " (1.23 × 10⁻⁴)");
        System.out.println("float scientificF = 6.022e23F; → " + scientificF + " (Avogadro)\n");
        
        printSubSection("Letterali Speciali per Floating-Point");
        
        // Java supporta letterali speciali per valori infiniti e NaN
        // Questi NON sono veri letterali, ma costanti delle classi wrapper
        double positiveInf = Double.POSITIVE_INFINITY;
        double negativeInf = Double.NEGATIVE_INFINITY;
        double notANumber = Double.NaN;
        
        System.out.println("Valori speciali (costanti, non letterali veri):\n");
        System.out.println("Double.POSITIVE_INFINITY → " + positiveInf);
        System.out.println("Double.NEGATIVE_INFINITY → " + negativeInf);
        System.out.println("Double.NaN               → " + notANumber + " (Not a Number)\n");
        
        printSubSection("Precisione: Float vs Double");
        
        float floatPi = 3.1415926535F;
        double doublePi = 3.1415926535;
        
        System.out.println("Confronto di precisione:\n");
        System.out.println("float floatPi = 3.1415926535F;");
        System.out.println("  → Memorizzato: " + floatPi + " (~7 cifre significative)");
        System.out.println("double doublePi = 3.1415926535;");
        System.out.println("  → Memorizzato: " + doublePi + " (~15 cifre significative)\n");
        
        System.out.println("💡 RACCOMANDAZIONE: Usa double per default (maggiore precisione)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 6: Underscore nei Letterali Numerici
     * 
     * Dalla Java 7, è possibile usare underscore (_) nei letterali numerici
     * per migliorare la leggibilità. Gli underscore sono ignorati dal compilatore.
     */
    private static void demoUnderscoreInLiterals() {
        printSection("6. UNDERSCORE NEI LETTERALI NUMERICI (Java 7+)");
        
        System.out.println("Dalla Java 7, puoi usare underscore (_) per migliorare la leggibilità.");
        System.out.println("Il compilatore ignora completamente gli underscore.\n");
        
        printSubSection("Esempi con Underscore");
        
        // Underscore per separare le migliaia
        int million = 1_000_000;
        long billion = 1_000_000_000L;
        long creditCard = 1234_5678_9012_3456L;
        
        System.out.println("Separatore di migliaia:");
        System.out.println("int million = 1_000_000;");
        System.out.println("  → Valore: " + million + " (più leggibile di 1000000)\n");
        
        System.out.println("long billion = 1_000_000_000L;");
        System.out.println("  → Valore: " + billion + "\n");
        
        System.out.println("long creditCard = 1234_5678_9012_3456L;");
        System.out.println("  → Valore: " + creditCard + " (formato carta di credito)\n");
        
        printSubSection("Underscore in Diverse Basi");
        
        // Underscore funziona con tutte le basi
        int binaryByte = 0b0001_0010_0011_0100;      // Gruppi di 4 bit (nibble)
        int octalUnix = 0_755;                        // Permessi Unix
        int hexColor = 0xFF_00_FF;                    // Colore RGB (magenta)
        
        System.out.println("Binario (gruppi di 4 bit):");
        System.out.println("int binaryByte = 0b0001_0010_0011_0100;");
        System.out.println("  → Valore: " + binaryByte + " (più facile vedere i nibble)\n");
        
        System.out.println("Esadecimale (colore RGB):");
        System.out.println("int hexColor = 0xFF_00_FF;  // R=FF, G=00, B=FF (magenta)");
        System.out.println("  → Valore: " + hexColor + "\n");
        
        printSubSection("Underscore in Floating-Point");
        
        // Underscore funziona anche con decimali
        double pi = 3.14159_26535_89793;
        float avogadro = 6.022_140_76e23F;
        
        System.out.println("Separatore in decimali:");
        System.out.println("double pi = 3.14159_26535_89793;");
        System.out.println("  → Valore: " + pi + "\n");
        
        System.out.println("float avogadro = 6.022_140_76e23F;");
        System.out.println("  → Valore: " + avogadro + "\n");
        
        printSubSection("⚠️ Regole per l'Uso di Underscore");
        
        System.out.println("✓ VALIDO:");
        System.out.println("  1_000          ✓ Tra cifre");
        System.out.println("  0b1010_1100    ✓ Tra cifre binarie");
        System.out.println("  0xFF_EC_DE     ✓ Tra cifre esadecimali");
        System.out.println("  3.14_15_92     ✓ Nella parte decimale\n");
        
        System.out.println("✗ NON VALIDO:");
        System.out.println("  // _1000        ✗ All'inizio");
        System.out.println("  // 1000_        ✗ Alla fine");
        System.out.println("  // 0_x52         ✗ Prima o dopo prefisso");
        System.out.println("  // 3._14         ✗ Prima o dopo il punto decimale");
        System.out.println("  // 52_L          ✗ Prima del suffisso L o F\n");
        
        printSubSection("💡 Best Practice con Underscore");
        
        System.out.println("✓ Usa underscore per migliorare la leggibilità di numeri grandi");
        System.out.println("✓ Gruppi di 3 cifre per migliaia: 1_000_000");
        System.out.println("✓ Gruppi di 4 cifre per carte/conti: 1234_5678_9012");
        System.out.println("✓ Gruppi di 4 bit per binari: 0b1010_1100_0011");
        System.out.println("✓ Gruppi di 2 cifre hex per byte: 0xFF_00_AB\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 7: Letterali Carattere
     * 
     * I letterali carattere rappresentano singoli caratteri Unicode.
     * Sono racchiusi tra apici singoli ('').
     */
    private static void demoCharacterLiterals() {
        printSection("7. LETTERALI CARATTERE (CHAR)");
        
        System.out.println("I letterali char rappresentano singoli caratteri.");
        System.out.println("Sono racchiusi tra APICI SINGOLI ('')\n");
        
        printSubSection("Sintassi Base dei Letterali Char");
        
        // Letterali carattere standard
        char letter = 'A';
        char digit = '5';
        char symbol = '@';
        char space = ' ';
        
        System.out.println("char letter = 'A';    → " + letter);
        System.out.println("char digit = '5';     → " + digit);
        System.out.println("char symbol = '@';    → " + symbol);
        System.out.println("char space = ' ';     → '" + space + "' (spazio)\n");
        
        printSubSection("Escape Sequences (Sequenze di Escape)");
        
        System.out.println("Le sequenze di escape iniziano con backslash (\\)");
        System.out.println("Permettono di rappresentare caratteri speciali:\n");
        
        char newline = '\n';      // A capo
        char tab = '\t';          // Tabulazione
        char backslash = '\\';    // Backslash
        char singleQuote = '\'';  // Apice singolo
        char doubleQuote = '\"';  // Apice doppio
        char carriageReturn = '\r'; // Ritorno carrello
        char formFeed = '\f';     // Form feed
        char backspace = '\b';    // Backspace
        
        System.out.println("┌──────────────┬────────────────┬──────────────────────┐");
        System.out.println("│   SEQUENZA   │   DESCRIZIONE  │    ESEMPIO           │");
        System.out.println("├──────────────┼────────────────┼──────────────────────┤");
        System.out.println("│     \\n       │   Newline      │ 'A' + '\\n' + 'B'     │");
        System.out.println("│     \\t       │   Tab          │ 'A' + '\\t' + 'B'     │");
        System.out.println("│     \\\\       │   Backslash    │ char c = '\\\\';       │");
        System.out.println("│     \\'       │   Apice sing.  │ char c = '\\'';       │");
        System.out.println("│     \\\"       │   Apice dopp.  │ char c = '\\\"';       │");
        System.out.println("│     \\r       │   Carriage ret │ Windows: \\r\\n        │");
        System.out.println("│     \\b       │   Backspace    │ Cancella 1 char      │");
        System.out.println("│     \\f       │   Form feed    │ Nuova pagina         │");
        System.out.println("└──────────────┴────────────────┴──────────────────────┘\n");
        
        printSubSection("Letterali Unicode (\\u)");
        
        // I caratteri possono essere espressi usando codici Unicode
        char unicodeA = '\u0041';      // A (codice Unicode)
        char unicodeEuro = '\u20AC';   // € (simbolo euro)
        char unicodeHeart = '\u2665';  // ♥ (cuore)
        char unicodeStar = '\u2605';   // ★ (stella)
        
        System.out.println("Formato: \\uXXXX (dove XXXX è il codice Unicode esadecimale)\n");
        
        System.out.println("char unicodeA = '\\u0041';     → " + unicodeA + " (A)");
        System.out.println("char unicodeEuro = '\\u20AC';  → " + unicodeEuro + " (Euro)");
        System.out.println("char unicodeHeart = '\\u2665'; → " + unicodeHeart + " (Cuore)");
        System.out.println("char unicodeStar = '\\u2605';  → " + unicodeStar + " (Stella)\n");
        
        printSubSection("Letterali Char come Numeri");
        
        // I char sono in realtà numeri interi unsigned (0-65535)
        char numericChar = 65;  // Equivalente a 'A'
        int charAsInt = 'Z';    // Converte 'Z' nel suo codice Unicode (90)
        
        System.out.println("I char sono NUMERI (codici Unicode 16-bit):\n");
        System.out.println("char numericChar = 65;");
        System.out.println("  → Valore: " + numericChar + " (65 = codice Unicode di 'A')\n");
        
        System.out.println("int charAsInt = 'Z';");
        System.out.println("  → Valore: " + charAsInt + " (codice Unicode di 'Z')\n");
        
        printSubSection("⚠️ Apici Singoli vs Doppi");
        
        System.out.println("✓ APICI SINGOLI '' → char (singolo carattere)");
        System.out.println("  char c = 'A';     ✓ CORRETTO\n");
        
        System.out.println("✓ APICI DOPPI \"\" → String (sequenza di caratteri)");
        System.out.println("  String s = \"A\";   ✓ CORRETTO\n");
        
        System.out.println("✗ ERRORI COMUNI:");
        System.out.println("  // char c = \"A\";   ✗ Tipo sbagliato (String, non char)");
        System.out.println("  // char c = 'AB';  ✗ Troppi caratteri (char = 1 solo)");
        System.out.println("  // char c = '';    ✗ Vuoto (char deve avere 1 carattere)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 8: Letterali Stringa
     * 
     * I letterali stringa sono sequenze di caratteri racchiuse tra doppi apici.
     * Le stringhe sono oggetti immutabili della classe String.
     */
    private static void demoStringLiterals() {
        printSection("8. LETTERALI STRINGA");
        
        System.out.println("I letterali stringa sono sequenze di caratteri tra APICI DOPPI (\"\")");
        System.out.println("Le stringhe in Java sono OGGETTI immutabili della classe String\n");
        
        printSubSection("Sintassi Base dei Letterali Stringa");
        
        // Letterali stringa standard
        String hello = "Hello, World!";
        String empty = "";              // Stringa vuota (valida)
        String singleChar = "A";        // Stringa con 1 carattere (diverso da char!)
        String withSpaces = "  spazi  ";
        
        System.out.println("String hello = \"Hello, World!\";");
        System.out.println("  → " + hello + "\n");
        
        System.out.println("String empty = \"\";");
        System.out.println("  → \"" + empty + "\" (stringa vuota, lunghezza 0)\n");
        
        System.out.println("String singleChar = \"A\";");
        System.out.println("  → \"" + singleChar + "\" (String con 1 char, NON char!)\n");
        
        System.out.println("String withSpaces = \"  spazi  \";");
        System.out.println("  → \"" + withSpaces + "\" (spazi inclusi)\n");
        
        printSubSection("Escape Sequences nelle Stringhe");
        
        // Sequenze di escape nelle stringhe
        String multiline = "Prima riga\nSeconda riga\nTerza riga";
        String withTab = "Nome:\tMario\tRossi";
        String withQuotes = "Disse: \"Hello!\"";
        String withBackslash = "C:\\Program Files\\Java";
        
        System.out.println("Le stringhe supportano le stesse escape sequences di char:\n");
        
        System.out.println("String multiline = \"Prima riga\\nSeconda riga\\nTerza riga\";");
        System.out.println("Output:");
        System.out.println(multiline);
        System.out.println();
        
        System.out.println("String withTab = \"Nome:\\tMario\\tRossi\";");
        System.out.println("Output: " + withTab + "\n");
        
        System.out.println("String withQuotes = \"Disse: \\\"Hello!\\\"\";");
        System.out.println("Output: " + withQuotes + "\n");
        
        System.out.println("String withBackslash = \"C:\\\\Program Files\\\\Java\";");
        System.out.println("Output: " + withBackslash + "\n");
        
        printSubSection("Concatenazione di Letterali Stringa");
        
        // Concatenazione a compile-time (letterali)
        String concatenated = "Hello" + " " + "World" + "!";
        
        // Concatenazione con altri tipi (conversione automatica)
        String withNumber = "Il numero è: " + 42;
        String withBoolean = "Valore: " + true;
        
        System.out.println("I letterali stringa possono essere concatenati con +:\n");
        
        System.out.println("String concatenated = \"Hello\" + \" \" + \"World\" + \"!\";");
        System.out.println("  → " + concatenated + "\n");
        
        System.out.println("String withNumber = \"Il numero è: \" + 42;");
        System.out.println("  → " + withNumber + "\n");
        
        System.out.println("String withBoolean = \"Valore: \" + true;");
        System.out.println("  → " + withBoolean + "\n");
        
        printSubSection("Unicode nelle Stringhe");
        
        // Le stringhe possono contenere caratteri Unicode
        String unicode = "Euro: \u20AC, Heart: \u2665, Star: \u2605";
        String emoji = "Emoji: 😀 🎉 ❤️";  // Emoji Unicode
        String japanese = "こんにちは";      // Giapponese
        
        System.out.println("Le stringhe supportano completamente Unicode:\n");
        System.out.println("String unicode = \"Euro: \\u20AC, Heart: \\u2665, Star: \\u2605\";");
        System.out.println("  → " + unicode + "\n");
        
        System.out.println("String emoji = \"Emoji: 😀 🎉 ❤️\";");
        System.out.println("  → " + emoji + "\n");
        
        System.out.println("String japanese = \"こんにちは\";");
        System.out.println("  → " + japanese + " (Ciao in giapponese)\n");
        
        printSubSection("String Pool (Interning)");
        
        // I letterali stringa sono memorizzati in uno string pool
        String s1 = "Hello";
        String s2 = "Hello";  // Stesso letterale
        
        System.out.println("I letterali stringa sono memorizzati in uno STRING POOL:");
        System.out.println("Stringhe identiche condividono la stessa area di memoria\n");
        
        System.out.println("String s1 = \"Hello\";");
        System.out.println("String s2 = \"Hello\";");
        System.out.println("s1 == s2 → " + (s1 == s2) + " (stesso oggetto nel pool!)");
        System.out.println("s1.equals(s2) → " + s1.equals(s2) + "\n");
        
        System.out.println("⚠️ Per confrontare stringhe usa SEMPRE .equals(), non ==\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 9: Text Blocks - Stringhe Multilinea
     * 
     * I text blocks (Java 13+) permettono di scrivere stringhe multilinea
     * in modo più leggibile, senza dover usare \n e concatenazioni.
     */
    private static void demoTextBlocks() {
        printSection("9. TEXT BLOCKS - STRINGHE MULTILINEA (Java 13+)");
        
        System.out.println("I TEXT BLOCKS permettono di scrivere stringhe multilinea facilmente.");
        System.out.println("Sintassi: tre doppi apici \"\"\" per iniziare e terminare\n");
        
        printSubSection("Text Block vs Stringa Tradizionale");
        
        // Modo tradizionale (scomodo)
        String traditional = "{\n" +
                            "  \"name\": \"Mario\",\n" +
                            "  \"age\": 30,\n" +
                            "  \"city\": \"Roma\"\n" +
                            "}";
        
        // Con text block (Java 13+)
        String textBlock = """
                {
                  "name": "Mario",
                  "age": 30,
                  "city": "Roma"
                }
                """;
        
        System.out.println("MODO TRADIZIONALE (scomodo con \\n e +):");
        System.out.println("String traditional = \"{\\n\" +");
        System.out.println("                    \"  \\\"name\\\": \\\"Mario\\\",\\n\" +");
        System.out.println("                    \"  \\\"age\\\": 30,\\n\" +");
        System.out.println("                    \"  \\\"city\\\": \\\"Roma\\\"\\n\" +");
        System.out.println("                    \"}\";");
        System.out.println("\nOutput:");
        System.out.println(traditional);
        System.out.println();
        
        System.out.println("CON TEXT BLOCK (Java 13+):");
        System.out.println("String textBlock = \"\"\"");
        System.out.println("        {");
        System.out.println("          \"name\": \"Mario\",");
        System.out.println("          \"age\": 30,");
        System.out.println("          \"city\": \"Roma\"");
        System.out.println("        }");
        System.out.println("        \"\"\";");
        System.out.println("\nOutput:");
        System.out.println(textBlock);
        
        printSubSection("Sintassi dei Text Blocks");
        
        System.out.println("REGOLE SINTATTICHE:");
        System.out.println("1. Inizia con tre doppi apici \"\"\" seguito da newline");
        System.out.println("2. Il contenuto è su righe successive");
        System.out.println("3. Termina con tre doppi apici \"\"\"");
        System.out.println("4. L'indentazione comune viene rimossa automaticamente\n");
        
        // Esempio di SQL query
        String sqlQuery = """
                SELECT users.name, orders.total
                FROM users
                JOIN orders ON users.id = orders.user_id
                WHERE orders.total > 100
                ORDER BY orders.total DESC;
                """;
        
        System.out.println("Esempio: SQL Query");
        System.out.println("String sqlQuery = \"\"\"");
        System.out.println("        SELECT users.name, orders.total");
        System.out.println("        FROM users");
        System.out.println("        JOIN orders ON users.id = orders.user_id");
        System.out.println("        WHERE orders.total > 100");
        System.out.println("        ORDER BY orders.total DESC;");
        System.out.println("        \"\"\";");
        System.out.println("\nContenuto:");
        System.out.println(sqlQuery);
        
        printSubSection("Vantaggi dei Text Blocks");
        
        System.out.println("✓ Nessun bisogno di escape per doppi apici");
        System.out.println("✓ Nessun bisogno di \\n esplicito per newline");
        System.out.println("✓ Nessun bisogno di concatenazione con +");
        System.out.println("✓ Molto più leggibile per JSON, XML, SQL, HTML");
        System.out.println("✓ L'indentazione viene gestita automaticamente\n");
        
        printSubSection("Esempi d'Uso Comuni");
        
        // HTML
        String html = """
                <html>
                    <body>
                        <h1>Benvenuto!</h1>
                        <p>Questo è un text block</p>
                    </body>
                </html>
                """;
        
        System.out.println("HTML:");
        System.out.println(html);
        
        // JSON
        String json = """
                {
                    "corso": "Java 21",
                    "argomento": "Text Blocks",
                    "utile": true
                }
                """;
        
        System.out.println("JSON:");
        System.out.println(json);
        
        waitForEnter();
    }

    /**
     * SEZIONE 10: Letterali Booleani
     * 
     * I letterali booleani sono true e false.
     * Sono gli unici due valori possibili per il tipo boolean.
     */
    private static void demoBooleanLiterals() {
        printSection("10. LETTERALI BOOLEANI");
        
        System.out.println("I letterali booleani rappresentano valori di verità.");
        System.out.println("Ci sono SOLO DUE letterali booleani: true e false\n");
        
        printSubSection("I Due Letterali Booleani");
        
        boolean isTrue = true;
        boolean isFalse = false;
        
        System.out.println("boolean isTrue = true;     → " + isTrue);
        System.out.println("boolean isFalse = false;   → " + isFalse + "\n");
        
        printSubSection("⚠️ Regole Importanti");
        
        System.out.println("✓ Sono PAROLE CHIAVE, quindi tutto MINUSCOLO");
        System.out.println("  boolean b = true;   ✓ CORRETTO");
        System.out.println("  // boolean b = True;  ✗ ERRORE (T maiuscolo)");
        System.out.println("  // boolean b = TRUE;  ✗ ERRORE (tutto maiuscolo)\n");
        
        System.out.println("✓ NON sono numeri!");
        System.out.println("  In Java, boolean è un tipo separato, non è 0/1");
        System.out.println("  // boolean b = 1;     ✗ ERRORE in Java");
        System.out.println("  // if (1) { ... }     ✗ ERRORE in Java");
        System.out.println("  Alcuni linguaggi (C, C++) trattano 0=false, non-zero=true");
        System.out.println("  Java NO! Usa SOLO true/false\n");
        
        printSubSection("Uso Tipico dei Letterali Booleani");
        
        // Condizioni
        boolean isValid = true;
        if (isValid) {
            System.out.println("✓ Condizione vera");
        }
        
        // Operatori logici
        boolean and = true && false;   // AND logico
        boolean or = true || false;    // OR logico
        boolean not = !true;           // NOT logico
        
        System.out.println("Operatori logici con letterali:");
        System.out.println("true && false  → " + and + " (AND)");
        System.out.println("true || false  → " + or + " (OR)");
        System.out.println("!true          → " + not + " (NOT)\n");
        
        // Assegnazione diretta (flag)
        boolean debugMode = false;
        boolean productionMode = true;
        
        System.out.println("Uso come flag:");
        System.out.println("boolean debugMode = false;");
        System.out.println("boolean productionMode = true;\n");
        
        printSubSection("Conversione da Letterali a Wrapper");
        
        // Boolean wrapper
        Boolean wrapperTrue = true;     // Autoboxing
        Boolean wrapperFalse = false;   // Autoboxing
        
        System.out.println("Autoboxing a Boolean wrapper:");
        System.out.println("Boolean wrapperTrue = true;    → " + wrapperTrue);
        System.out.println("Boolean wrapperFalse = false;  → " + wrapperFalse + "\n");
        
        System.out.println("⚠️ Boolean ha solo DUE istanze singleton:");
        System.out.println("  Boolean.TRUE  (per true)");
        System.out.println("  Boolean.FALSE (per false)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 11: Letterale null
     * 
     * null è un letterale speciale che rappresenta l'assenza di un oggetto.
     * Può essere assegnato a qualsiasi tipo riferimento (ma non primitivo).
     */
    private static void demoNullLiteral() {
        printSection("11. LETTERALE NULL");
        
        System.out.println("null è un letterale speciale che rappresenta \"nessun oggetto\"");
        System.out.println("È l'unico letterale che può essere assegnato a QUALSIASI tipo riferimento\n");
        
        printSubSection("Uso del Letterale null");
        
        // null può essere assegnato a qualsiasi tipo riferimento
        String nullString = null;
        Integer nullInteger = null;
        Object nullObject = null;
        int[] nullArray = null;
        
        System.out.println("null può essere assegnato a qualsiasi tipo riferimento:\n");
        System.out.println("String nullString = null;      → " + nullString);
        System.out.println("Integer nullInteger = null;    → " + nullInteger);
        System.out.println("Object nullObject = null;      → " + nullObject);
        System.out.println("int[] nullArray = null;        → " + nullArray + "\n");
        
        printSubSection("⚠️ null NON può essere Assegnato a Primitivi");
        
        System.out.println("I tipi PRIMITIVI NON possono essere null:");
        System.out.println("  // int primitiveNull = null;      ✗ ERRORE di compilazione");
        System.out.println("  // boolean boolNull = null;       ✗ ERRORE di compilazione");
        System.out.println("  // double doubleNull = null;      ✗ ERRORE di compilazione\n");
        
        System.out.println("Solo i tipi RIFERIMENTO (oggetti) possono essere null:");
        System.out.println("  Integer wrapperNull = null;       ✓ OK (Integer è un oggetto)");
        System.out.println("  String stringNull = null;         ✓ OK (String è un oggetto)\n");
        
        printSubSection("Controllo di null");
        
        String maybeNull = null;
        
        if (maybeNull == null) {
            System.out.println("✓ La variabile è null (controllo con ==)");
        }
        
        if (maybeNull != null) {
            System.out.println("La variabile NON è null");
        } else {
            System.out.println("✓ La variabile è null (controllo con !=)\n");
        }
        
        printSubSection("⚠️ NullPointerException");
        
        System.out.println("Tentare di usare null come un oggetto causa NullPointerException:\n");
        
        String nullStr = null;
        
        try {
            int length = nullStr.length();  // NullPointerException!
            System.out.println("Lunghezza: " + length);
        } catch (NullPointerException e) {
            System.out.println("✗ NullPointerException! Non puoi chiamare metodi su null");
            System.out.println("  nullStr.length() fallisce perché nullStr è null\n");
        }
        
        printSubSection("💡 Best Practices con null");
        
        System.out.println("✓ CONTROLLA sempre null prima di usare un oggetto:");
        System.out.println("""
                  if (obj != null) {
                      obj.doSomething();  // Sicuro
                  }
                  """);
        
        System.out.println("✓ USA Optional<T> (Java 8+) per rendere esplicito che un valore può essere null:");
        System.out.println("""
                  Optional<String> optional = Optional.ofNullable(maybeNull);
                  String value = optional.orElse("default");
                  """);
        
        System.out.println("✓ USA annotazioni @Nullable e @NonNull per documentare:");
        System.out.println("""
                  public void process(@NonNull String input) { ... }
                  public @Nullable String findUser(int id) { ... }
                  """);
        
        System.out.println("✗ EVITA di restituire null quando possibile:");
        System.out.println("  Preferisci: stringa vuota \"\", lista vuota Collections.emptyList()");
        System.out.println("  Oppure: Optional<T> per valori opzionali\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 12: Best Practices con i Letterali
     * 
     * Raccolta di best practices professionali per l'uso dei letterali in Java
     */
    private static void demoBestPractices() {
        printSection("12. BEST PRACTICES CON I LETTERALI");
        
        printSubSection("1. Leggibilità dei Numeri");
        
        System.out.println("✓ USA underscore per numeri grandi:");
        System.out.println("  long billion = 1_000_000_000L;        // ✓ Leggibile");
        System.out.println("  long billion = 1000000000L;           // ✗ Difficile da leggere\n");
        
        System.out.println("✓ USA la base appropriata:");
        System.out.println("  int permissions = 0755;               // ✓ Ottale per permessi Unix");
        System.out.println("  int color = 0xFF5733;                 // ✓ Hex per colori");
        System.out.println("  int flags = 0b10101100;               // ✓ Binario per bit flags\n");
        
        printSubSection("2. Suffissi per Tipo Corretto");
        
        System.out.println("✓ USA suffisso L MAIUSCOLO per long:");
        System.out.println("  long value = 1000L;    // ✓ L maiuscolo (chiaro)");
        System.out.println("  long value = 1000l;    // ✗ l minuscolo (confuso con 1)\n");
        
        System.out.println("✓ USA suffisso F MAIUSCOLO per float:");
        System.out.println("  float pi = 3.14F;      // ✓ F maiuscolo (chiaro)");
        System.out.println("  float pi = 3.14f;      // ✓ Ok, ma F è preferito\n");
        
        printSubSection("3. Costanti Nominali");
        
        System.out.println("✓ USA costanti NOMINALI invece di \"magic numbers\":");
        System.out.println("""
                  // ✗ CATTIVO (magic numbers):
                  if (status == 200) { ... }
                  double area = 3.14159 * r * r;
                  
                  // ✓ BUONO (costanti nominali):
                  public static final int HTTP_OK = 200;
                  public static final double PI = 3.14159;
                  
                  if (status == HTTP_OK) { ... }
                  double area = PI * r * r;
                  """);
        
        printSubSection("4. Stringhe e Text Blocks");
        
        System.out.println("✓ USA text blocks per stringhe multilinea:");
        System.out.println("""
                  // ✗ Scomodo:
                  String json = "{\\n" +
                                "  \\"name\\": \\"value\\"\\n" +
                                "}";
                  
                  // ✓ Chiaro:
                  String json = \\"\\"\\"
                          {
                            "name": "value"
                          }
                          \\"\\"\\";
                  """);
        
        printSubSection("5. Confronti e null");
        
        System.out.println("✓ Confronta stringhe letterali con .equals():");
        System.out.println("""
                  String input = getUserInput();
                  if (input.equals("quit")) { ... }    // ✗ NullPointerException se input è null
                  if ("quit".equals(input)) { ... }    // ✓ Sicuro (letterale prima)
                  """);
        
        System.out.println("✓ Usa Objects.equals() per null-safety:");
        System.out.println("""
                  if (Objects.equals(input, "quit")) { ... }  // ✓ Gestisce null
                  """);
        
        printSubSection("6. Performance");
        
        System.out.println("✓ I letterali stringa sono nell'object pool:");
        System.out.println("""
                  String s1 = "hello";     // Nel pool
                  String s2 = "hello";     // Stesso oggetto dal pool
                  s1 == s2                 // true (ma usa sempre .equals()!)
                  """);
        
        System.out.println("✓ Concatenazione di letterali avviene a compile-time:");
        System.out.println("""
                  String s = "Hello" + " " + "World";  // Ottimizzato dal compilatore
                  // Equivalente a: String s = "Hello World";
                  """);
        
        printSubSection("7. Tipo Appropriato");
        
        System.out.println("✓ Scegli il tipo di letterale appropriato:");
        System.out.println("┌─────────────────────────────┬──────────────────────┐");
        System.out.println("│       SITUAZIONE            │     USA              │");
        System.out.println("├─────────────────────────────┼──────────────────────┤");
        System.out.println("│ Numeri interi piccoli       │ int (42)             │");
        System.out.println("│ Numeri interi grandi        │ long (1000000L)      │");
        System.out.println("│ Decimali precisione normale │ double (3.14)        │");
        System.out.println("│ Decimali memoria limitata   │ float (3.14F)        │");
        System.out.println("│ Singolo carattere           │ char ('A')           │");
        System.out.println("│ Testo                       │ String (\"text\")      │");
        System.out.println("│ Flag/condizioni             │ boolean (true/false) │");
        System.out.println("│ Assenza oggetto             │ null                 │");
        System.out.println("└─────────────────────────────┴──────────────────────┘\n");
        
        printSubSection("💡 REGOLA D'ORO");
        
        System.out.println("✓ Scrivi codice LEGGIBILE:");
        System.out.println("  - Usa underscore per numeri grandi");
        System.out.println("  - Usa costanti nominali significative");
        System.out.println("  - Usa la base appropriata (bin/oct/hex)");
        System.out.println("  - Usa text blocks per stringhe complesse");
        System.out.println("  - Evita confusione (L maiuscolo, non l minuscolo)");
        System.out.println("  - Documenta i \"magic numbers\" con costanti\n");
        
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
        System.out.println("  ✓ DEMO COMPLETATA - Hai appreso tutto sui Letterali in Java!");
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
