package com.corso.samples.datatypes;

/**
 * Classe demo completa per l'apprendimento dei TIPI PRIMITIVI in Java.
 * 
 * In Java esistono 8 tipi primitivi fondamentali divisi in 4 categorie:
 * - Interi: byte, short, int, long
 * - Virgola mobile: float, double
 * - Caratteri: char
 * - Booleani: boolean
 * 
 * I tipi primitivi sono diversi dagli oggetti: sono memorizzati direttamente
 * nello stack e non nell'heap, rendendoli più efficienti in termini di memoria.
 */
public class PrimitiveTypesDemo {
    
    /**
     * Metodo principale che esegue tutte le demo sui tipi primitivi
     */
    public static void run() {
        printHeader("TIPI PRIMITIVI IN JAVA");
        
        // Esegue le demo per ogni categoria di tipo primitivo
        demoIntegerTypes();
        demoFloatingPointTypes();
        demoCharType();
        demoBooleanType();
        demoTypeConversions();
        demoWrapperClasses();
        demoLiterals();
        demoOverflowUnderflow();
        demoBestPractices();
        
        printFooter();
    }
    
    /**
     * Demo completa dei tipi numerici INTERI (byte, short, int, long)
     */
    private static void demoIntegerTypes() {
        printSection("1. TIPI INTERI");
        
        System.out.println("I tipi interi rappresentano numeri senza parte decimale.");
        System.out.println("Sono signed (con segno), quindi possono essere positivi o negativi.\n");
        
        // ===== BYTE =====
        printSubSection("1.1 BYTE - 8 bit con segno");
        
        // Il tipo byte occupa 8 bit (1 byte) e può contenere valori da -128 a 127
        byte byteMin = -128;              // Valore minimo
        byte byteMax = 127;               // Valore massimo
        byte byteExample = 42;            // Esempio di valore
        
        System.out.println("Dimensione: 8 bit (1 byte)");
        System.out.println("Range: " + Byte.MIN_VALUE + " a " + Byte.MAX_VALUE);
        System.out.println("Esempio: byte age = " + byteExample + ";");
        System.out.println("Uso tipico: ottimizzare memoria con grandi array di piccoli numeri\n");
        
        // ===== SHORT =====
        printSubSection("1.2 SHORT - 16 bit con segno");
        
        // Il tipo short occupa 16 bit (2 byte) e può contenere valori da -32,768 a 32,767
        short shortMin = -32_768;         // Valore minimo (nota l'uso di underscore per leggibilità)
        short shortMax = 32_767;          // Valore massimo
        short shortExample = 1_000;       // Esempio di valore
        
        System.out.println("Dimensione: 16 bit (2 byte)");
        System.out.println("Range: " + Short.MIN_VALUE + " a " + Short.MAX_VALUE);
        System.out.println("Esempio: short year = " + shortExample + ";");
        System.out.println("Uso tipico: ottimizzare memoria, raramente usato nella pratica\n");
        
        // ===== INT =====
        printSubSection("1.3 INT - 32 bit con segno");
        
        // Il tipo int è il tipo PREDEFINITO per i numeri interi in Java
        // Occupa 32 bit (4 byte) e può contenere valori da -2^31 a 2^31-1
        int intMin = -2_147_483_648;      // Valore minimo
        int intMax = 2_147_483_647;       // Valore massimo
        int intExample = 1_000_000;       // Esempio di valore
        
        System.out.println("Dimensione: 32 bit (4 byte)");
        System.out.println("Range: " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);
        System.out.println("Esempio: int population = " + intExample + ";");
        System.out.println("Uso tipico: TIPO PREDEFINITO per tutti i numeri interi");
        System.out.println("Note: Se scrivi '100' Java lo interpreta come int\n");
        
        // ===== LONG =====
        printSubSection("1.4 LONG - 64 bit con segno");
        
        // Il tipo long occupa 64 bit (8 byte) per numeri molto grandi
        // I letterali long terminano con 'L' o 'l' (meglio usare 'L' maiuscola)
        long longMin = -9_223_372_036_854_775_808L;  // Valore minimo
        long longMax = 9_223_372_036_854_775_807L;   // Valore massimo
        long longExample = 9_000_000_000L;           // Esempio: 9 miliardi
        
        System.out.println("Dimensione: 64 bit (8 byte)");
        System.out.println("Range: " + Long.MIN_VALUE + " a " + Long.MAX_VALUE);
        System.out.println("Esempio: long worldPopulation = " + longExample + "L;");
        System.out.println("Uso tipico: timestamp, grandi quantità, calcoli finanziari");
        System.out.println("IMPORTANTE: Usa il suffisso 'L' per i letterali long!\n");
        
        // ===== OPERAZIONI ARITMETICHE =====
        printSubSection("1.5 OPERAZIONI ARITMETICHE SUI TIPI INTERI");
        
        int a = 10;
        int b = 3;
        
        System.out.println("Dati: a = " + a + ", b = " + b);
        System.out.println("Addizione (a + b):       " + (a + b));
        System.out.println("Sottrazione (a - b):     " + (a - b));
        System.out.println("Moltiplicazione (a * b): " + (a * b));
        System.out.println("Divisione (a / b):       " + (a / b) + "  <- Divisione INTERA!");
        System.out.println("Resto/Modulo (a % b):    " + (a % b));
        System.out.println("\nNOTA: La divisione tra interi produce un risultato INTERO (troncato)");
        System.out.println("      10 / 3 = 3 (e non 3.33...)\n");
    }
    
    /**
     * Demo completa dei tipi a VIRGOLA MOBILE (float, double)
     */
    private static void demoFloatingPointTypes() {
        printSection("2. TIPI A VIRGOLA MOBILE");
        
        System.out.println("I tipi a virgola mobile rappresentano numeri con parte decimale.");
        System.out.println("Utilizzano lo standard IEEE 754.\n");
        
        // ===== FLOAT =====
        printSubSection("2.1 FLOAT - 32 bit, precisione singola");
        
        // Il tipo float occupa 32 bit e ha circa 6-7 cifre decimali di precisione
        // I letterali float terminano con 'F' o 'f'
        float floatExample = 3.14159F;
        float floatScientific = 1.23e-4F;  // Notazione scientifica: 1.23 * 10^-4
        
        System.out.println("Dimensione: 32 bit (4 byte)");
        System.out.println("Range: ±" + Float.MAX_VALUE);
        System.out.println("Precisione: ~6-7 cifre decimali");
        System.out.println("Esempio: float pi = " + floatExample + "F;");
        System.out.println("Notazione scientifica: " + floatScientific + "F");
        System.out.println("Uso tipico: Grafica 3D, gaming (per risparmiare memoria)");
        System.out.println("IMPORTANTE: Usa il suffisso 'F' per i letterali float!\n");
        
        // ===== DOUBLE =====
        printSubSection("2.2 DOUBLE - 64 bit, precisione doppia");
        
        // Il tipo double è il tipo PREDEFINITO per i numeri decimali in Java
        // Occupa 64 bit e ha circa 15-16 cifre decimali di precisione
        double doubleExample = 3.141592653589793;
        double doubleScientific = 6.022e23;  // Numero di Avogadro
        
        System.out.println("Dimensione: 64 bit (8 byte)");
        System.out.println("Range: ±" + Double.MAX_VALUE);
        System.out.println("Precisione: ~15-16 cifre decimali");
        System.out.println("Esempio: double pi = " + doubleExample + ";");
        System.out.println("Notazione scientifica: " + doubleScientific);
        System.out.println("Uso tipico: TIPO PREDEFINITO per numeri decimali");
        System.out.println("Note: Se scrivi '3.14' Java lo interpreta come double\n");
        
        // ===== OPERAZIONI E VALORI SPECIALI =====
        printSubSection("2.3 OPERAZIONI E VALORI SPECIALI");
        
        double x = 10.0;
        double y = 3.0;
        
        System.out.println("Dati: x = " + x + ", y = " + y);
        System.out.println("Divisione (x / y):     " + (x / y) + "  <- Divisione DECIMALE!");
        System.out.println("Radice quadrata:       " + Math.sqrt(x));
        System.out.println("Potenza (x^y):         " + Math.pow(x, y));
        
        // Valori speciali
        System.out.println("\nValori speciali:");
        double infinity = 1.0 / 0.0;
        double negInfinity = -1.0 / 0.0;
        double notANumber = 0.0 / 0.0;
        
        System.out.println("Infinito positivo:     " + infinity);
        System.out.println("Infinito negativo:     " + negInfinity);
        System.out.println("Not a Number (NaN):    " + notANumber);
        System.out.println("È NaN?:                " + Double.isNaN(notANumber));
        System.out.println("È Infinito?:           " + Double.isInfinite(infinity));
        
        // Problemi di precisione
        System.out.println("\n⚠️  ATTENZIONE: Problemi di precisione!");
        double result = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 = " + result);
        System.out.println("NON è esattamente 0.3 a causa della rappresentazione binaria!");
        System.out.println("Per confronti, usa una tolleranza (epsilon):");
        double epsilon = 0.0001;
        boolean areEqual = Math.abs(result - 0.3) < epsilon;
        System.out.println("Math.abs(result - 0.3) < " + epsilon + " : " + areEqual + "\n");
    }
    
    /**
     * Demo del tipo CHAR (carattere Unicode)
     */
    private static void demoCharType() {
        printSection("3. TIPO CHAR");
        
        System.out.println("Il tipo char rappresenta un SINGOLO carattere Unicode.");
        System.out.println("È un tipo a 16 bit UNSIGNED (solo valori positivi).\n");
        
        printSubSection("3.1 CARATTERISTICHE PRINCIPALI");
        
        // Il char può essere inizializzato in vari modi
        char letterChar = 'A';                    // Letterale carattere
        char unicodeChar = '\u0041';              // Codice Unicode (A)
        char numericChar = 65;                    // Valore numerico (A)
        char specialChar = '\n';                  // Carattere speciale (newline)
        
        System.out.println("Dimensione: 16 bit (2 byte)");
        System.out.println("Range: 0 a " + (int)Character.MAX_VALUE + " (Unicode)");
        System.out.println("Esempio letterale:     char letter = '" + letterChar + "';");
        System.out.println("Esempio Unicode:       char letter = '\\u0041'; -> '" + unicodeChar + "'");
        System.out.println("Esempio numerico:      char letter = 65; -> '" + numericChar + "'");
        System.out.println("Uso tipico: singoli caratteri, elaborazione testo\n");
        
        printSubSection("3.2 CARATTERI SPECIALI (Escape Sequences)");
        
        System.out.println("\\n  - Newline (a capo)");
        System.out.println("\\t  - Tab (tabulazione)");
        System.out.println("\\r  - Carriage return");
        System.out.println("\\\\  - Backslash");
        System.out.println("\\'  - Apice singolo");
        System.out.println("\\\"  - Apice doppio");
        
        printSubSection("3.3 OPERAZIONI SUI CHAR");
        
        char ch = 'A';
        System.out.println("Carattere originale:   '" + ch + "'");
        System.out.println("Codice ASCII/Unicode:  " + (int)ch);
        System.out.println("Carattere successivo:  '" + (char)(ch + 1) + "' (B)");
        System.out.println("È una lettera?:        " + Character.isLetter(ch));
        System.out.println("È una cifra?:          " + Character.isDigit(ch));
        System.out.println("È maiuscolo?:          " + Character.isUpperCase(ch));
        System.out.println("Minuscolo:             '" + Character.toLowerCase(ch) + "'");
        System.out.println("Maiuscolo:             '" + Character.toUpperCase(ch) + "'\n");
        
        // Nota importante: char può essere usato in operazioni aritmetiche
        System.out.println("⚠️  NOTA: char può partecipare ad operazioni aritmetiche");
        System.out.println("'A' + 1 = '" + (char)('A' + 1) + "' (viene promosso a int, va fatto il cast)\n");
    }
    
    /**
     * Demo del tipo BOOLEAN (valori logici)
     */
    private static void demoBooleanType() {
        printSection("4. TIPO BOOLEAN");
        
        System.out.println("Il tipo boolean rappresenta valori logici: vero o falso.");
        System.out.println("Può avere SOLO due valori: true o false.\n");
        
        printSubSection("4.1 CARATTERISTICHE PRINCIPALI");
        
        // Il boolean è utilizzato per espressioni condizionali
        boolean isTrue = true;
        boolean isFalse = false;
        boolean result = (5 > 3);        // Risultato di confronto
        
        System.out.println("Dimensione: Non specificata (dipende dalla JVM, tipicamente 1 bit logico)");
        System.out.println("Valori possibili: true, false");
        System.out.println("Esempio: boolean isActive = " + isTrue + ";");
        System.out.println("Uso tipico: controllo di flusso, condizioni, flag\n");
        
        printSubSection("4.2 OPERATORI LOGICI");
        
        boolean a = true;
        boolean b = false;
        
        System.out.println("Dati: a = " + a + ", b = " + b + "\n");
        
        // Operatori logici
        System.out.println("AND logico (a && b):    " + (a && b) + "  <- vero se entrambi veri");
        System.out.println("OR logico (a || b):     " + (a || b) + "  <- vero se almeno uno è vero");
        System.out.println("NOT logico (!a):        " + (!a) + "  <- inverte il valore");
        System.out.println("XOR logico (a ^ b):     " + (a ^ b) + "  <- vero se diversi");
        
        printSubSection("4.3 SHORT-CIRCUIT EVALUATION");
        
        System.out.println("Gli operatori && e || usano la valutazione 'short-circuit':");
        System.out.println("- Con &&: se il primo è false, il secondo non viene valutato");
        System.out.println("- Con ||: se il primo è true, il secondo non viene valutato");
        System.out.println("\nEsempio:");
        System.out.println("if (obj != null && obj.isValid()) { ... }");
        System.out.println("Il secondo controllo avviene SOLO se obj != null\n");
        
        printSubSection("4.4 OPERATORI DI CONFRONTO");
        
        int x = 10;
        int y = 20;
        
        System.out.println("Dati: x = " + x + ", y = " + y + "\n");
        System.out.println("Uguale (x == y):              " + (x == y));
        System.out.println("Diverso (x != y):             " + (x != y));
        System.out.println("Maggiore (x > y):             " + (x > y));
        System.out.println("Minore (x < y):               " + (x < y));
        System.out.println("Maggiore o uguale (x >= y):   " + (x >= y));
        System.out.println("Minore o uguale (x <= y):     " + (x <= y) + "\n");
    }
    
    /**
     * Demo delle CONVERSIONI tra tipi primitivi (casting)
     */
    private static void demoTypeConversions() {
        printSection("5. CONVERSIONI TRA TIPI (CASTING)");
        
        System.out.println("Java supporta due tipi di conversione tra tipi primitivi:");
        System.out.println("- WIDENING (implicita): da tipo più piccolo a più grande");
        System.out.println("- NARROWING (esplicita): da tipo più grande a più piccolo\n");
        
        printSubSection("5.1 WIDENING CONVERSION (Implicita)");
        
        System.out.println("Gerarchia dei tipi (dal più piccolo al più grande):");
        System.out.println("byte -> short -> int -> long -> float -> double");
        System.out.println("         char -> int\n");
        
        // Conversioni implicite (automatiche, sicure)
        byte byteValue = 10;
        int intValue = byteValue;           // byte -> int (automatico)
        long longValue = intValue;          // int -> long (automatico)
        float floatValue = longValue;       // long -> float (automatico)
        double doubleValue = floatValue;    // float -> double (automatico)
        
        System.out.println("byte b = 10;");
        System.out.println("int i = b;           // OK - automatico");
        System.out.println("long l = i;          // OK - automatico");
        System.out.println("float f = l;         // OK - automatico");
        System.out.println("double d = f;        // OK - automatico");
        System.out.println("\nNessuna perdita di informazione garantita!\n");
        
        printSubSection("5.2 NARROWING CONVERSION (Esplicita)");
        
        System.out.println("Richiede un CAST esplicito perché può causare perdita di dati.");
        System.out.println("Sintassi: (tipoDestinazione) variabileSorgente\n");
        
        // Conversioni esplicite (richiedono cast)
        double doubleVal = 123.456;
        int intVal = (int) doubleVal;           // Troncamento: perde la parte decimale
        
        System.out.println("double d = 123.456;");
        System.out.println("int i = (int) d;     // i = " + intVal + " (parte decimale persa!)");
        
        // Overflow in narrowing
        int largeInt = 130;
        byte smallByte = (byte) largeInt;       // Overflow! 130 > 127 (max byte)
        
        System.out.println("\nint largeInt = 130;");
        System.out.println("byte b = (byte) largeInt;  // b = " + smallByte + " (OVERFLOW!)");
        System.out.println("130 eccede il range di byte, il risultato è imprevedibile!\n");
        
        printSubSection("5.3 CASTING CON ESPRESSIONI");
        
        System.out.println("Nelle espressioni, i tipi vengono promossi automaticamente:");
        
        byte b1 = 10;
        byte b2 = 20;
        // byte b3 = b1 + b2;  // ERRORE! Il risultato di b1+b2 è int
        int b3 = b1 + b2;       // OK
        byte b4 = (byte)(b1 + b2);  // OK con cast esplicito
        
        System.out.println("byte b1 = 10, b2 = 20;");
        System.out.println("byte b3 = b1 + b2;        // ERRORE di compilazione!");
        System.out.println("int b3 = b1 + b2;         // OK - risultato è int");
        System.out.println("byte b4 = (byte)(b1+b2);  // OK con cast esplicito\n");
        System.out.println("REGOLA: operazioni tra interi producono almeno un int\n");
    }
    
    /**
     * Demo delle WRAPPER CLASSES (classi involucro)
     */
    private static void demoWrapperClasses() {
        printSection("6. WRAPPER CLASSES");
        
        System.out.println("Ogni tipo primitivo ha una classe wrapper corrispondente.");
        System.out.println("Le wrapper classes permettono di trattare i primitivi come oggetti.\n");
        
        printSubSection("6.1 CORRISPONDENZE WRAPPER");
        
        System.out.println("Primitivo  ->  Wrapper Class");
        System.out.println("--------   ->  -------------");
        System.out.println("byte       ->  Byte");
        System.out.println("short      ->  Short");
        System.out.println("int        ->  Integer    <- NOTA: nome diverso!");
        System.out.println("long       ->  Long");
        System.out.println("float      ->  Float");
        System.out.println("double     ->  Double");
        System.out.println("char       ->  Character  <- NOTA: nome diverso!");
        System.out.println("boolean    ->  Boolean\n");
        
        printSubSection("6.2 AUTOBOXING E UNBOXING");
        
        System.out.println("AUTOBOXING: conversione automatica da primitivo a wrapper");
        System.out.println("UNBOXING: conversione automatica da wrapper a primitivo\n");
        
        // Autoboxing (primitivo -> wrapper)
        int primitiveInt = 42;
        Integer wrapperInt = primitiveInt;  // Autoboxing automatico
        
        System.out.println("int primitiveInt = 42;");
        System.out.println("Integer wrapperInt = primitiveInt;  // Autoboxing");
        
        // Unboxing (wrapper -> primitivo)
        Integer anotherWrapper = 100;
        int anotherPrimitive = anotherWrapper;  // Unboxing automatico
        
        System.out.println("\nInteger anotherWrapper = 100;");
        System.out.println("int anotherPrimitive = anotherWrapper;  // Unboxing\n");
        
        printSubSection("6.3 METODI UTILI DELLE WRAPPER CLASSES");
        
        System.out.println("Le wrapper classes forniscono metodi utili:\n");
        
        // Parsing (conversione da String)
        String numberStr = "123";
        int parsed = Integer.parseInt(numberStr);
        System.out.println("Integer.parseInt(\"123\") = " + parsed);
        
        // Conversione a String
        int num = 456;
        String numString = Integer.toString(num);
        System.out.println("Integer.toString(456) = \"" + numString + "\"");
        
        // Costanti utili
        System.out.println("\nCostanti utili:");
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Double.NaN = " + Double.NaN);
        System.out.println("Double.POSITIVE_INFINITY = " + Double.POSITIVE_INFINITY);
        
        // Confronti
        System.out.println("\nInteger.compare(10, 20) = " + Integer.compare(10, 20) + " (negativo se <)");
        System.out.println("Double.compare(3.14, 2.71) = " + Double.compare(3.14, 2.71) + " (positivo se >)");
        
        printSubSection("6.4 ⚠️  ATTENZIONE CON I WRAPPER");
        
        System.out.println("I wrapper sono OGGETTI, non primitivi:");
        System.out.println("- Usano più memoria");
        System.out.println("- Possono essere null (i primitivi NO)");
        System.out.println("- Il confronto con == confronta i riferimenti, non i valori!\n");
        
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        
        System.out.println("Integer a = 127; Integer b = 127;");
        System.out.println("a == b: " + (a == b) + "  <- true (cache interna per -128..127)");
        System.out.println("\nInteger c = 128; Integer d = 128;");
        System.out.println("c == d: " + (c == d) + "  <- false (oggetti diversi!)");
        System.out.println("c.equals(d): " + c.equals(d) + "  <- true (confronto dei valori)");
        System.out.println("\n⚠️  USA sempre .equals() per confrontare i wrapper!\n");
    }
    
    /**
     * Demo dei LETTERALI (literal values)
     */
    private static void demoLiterals() {
        printSection("7. LETTERALI");
        
        System.out.println("I letterali sono valori costanti scritti direttamente nel codice.\n");
        
        printSubSection("7.1 LETTERALI INTERI");
        
        // Varie basi numeriche
        int decimal = 100;              // Base 10 (decimale)
        int binary = 0b1100100;         // Base 2 (binario) - prefisso 0b
        int octal = 0144;               // Base 8 (ottale) - prefisso 0
        int hexadecimal = 0x64;         // Base 16 (esadecimale) - prefisso 0x
        
        System.out.println("Decimale:      100 = " + decimal);
        System.out.println("Binario:    0b1100100 = " + binary);
        System.out.println("Ottale:        0144 = " + octal);
        System.out.println("Esadecimale:   0x64 = " + hexadecimal);
        System.out.println("Tutti rappresentano lo stesso valore!\n");
        
        // Underscore per leggibilità (Java 7+)
        int million = 1_000_000;
        long creditCard = 1234_5678_9012_3456L;
        int binary2 = 0b0001_0010_0011_0100;
        
        System.out.println("Underscore per leggibilità (ignorati dal compilatore):");
        System.out.println("int million = 1_000_000; = " + million);
        System.out.println("long creditCard = 1234_5678_9012_3456L;");
        System.out.println("int binary = 0b0001_0010_0011_0100;\n");
        
        printSubSection("7.2 LETTERALI DECIMALI");
        
        // Notazione standard e scientifica
        double d1 = 3.14;               // Notazione standard
        double d2 = 3.14D;              // Con suffisso D (opzionale)
        double d3 = 314e-2;             // Notazione scientifica: 314 * 10^-2
        float f1 = 3.14F;               // Suffisso F obbligatorio per float
        
        System.out.println("double d1 = 3.14;       = " + d1);
        System.out.println("double d2 = 3.14D;      = " + d2);
        System.out.println("double d3 = 314e-2;     = " + d3);
        System.out.println("float f1 = 3.14F;       = " + f1);
        System.out.println("\nNOTA: Senza suffisso, i decimali sono double per default!\n");
        
        printSubSection("7.3 LETTERALI CARATTERE");
        
        char c1 = 'A';                  // Carattere singolo
        char c2 = '\u0041';             // Unicode
        char c3 = 65;                   // Valore numerico
        char newline = '\n';            // Escape sequence
        
        System.out.println("char c1 = 'A';          = '" + c1 + "'");
        System.out.println("char c2 = '\\u0041';     = '" + c2 + "'");
        System.out.println("char c3 = 65;           = '" + c3 + "'");
        System.out.println("char newline = '\\n';    = codice di a capo\n");
        
        printSubSection("7.4 LETTERALI BOOLEANI");
        
        System.out.println("boolean b1 = true;");
        System.out.println("boolean b2 = false;");
        System.out.println("\nSolo due valori possibili: true e false (minuscoli!)\n");
    }
    
    /**
     * Demo di OVERFLOW e UNDERFLOW
     */
    private static void demoOverflowUnderflow() {
        printSection("8. OVERFLOW E UNDERFLOW");
        
        System.out.println("⚠️  Quando un valore supera i limiti di un tipo, si verifica overflow/underflow.");
        System.out.println("Java NON genera eccezioni per overflow con i primitivi!\n");
        
        printSubSection("8.1 OVERFLOW INTERO");
        
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Valore massimo int: " + maxInt);
        System.out.println("MAX_VALUE + 1: " + (maxInt + 1));
        System.out.println("Overflow! Il valore 'ricomincia' dal minimo: " + Integer.MIN_VALUE);
        System.out.println("\nÈ come un contatore che torna a zero dopo il massimo.\n");
        
        printSubSection("8.2 UNDERFLOW INTERO");
        
        int minInt = Integer.MIN_VALUE;
        System.out.println("Valore minimo int: " + minInt);
        System.out.println("MIN_VALUE - 1: " + (minInt - 1));
        System.out.println("Underflow! Il valore 'ricomincia' dal massimo: " + Integer.MAX_VALUE + "\n");
        
        printSubSection("8.3 OVERFLOW CON MOLTIPLICAZIONE");
        
        int billion = 1_000_000_000;
        int result = billion * 3;  // Overflow!
        
        System.out.println("int billion = 1_000_000_000;");
        System.out.println("billion * 3 = " + result);
        System.out.println("Risultato atteso: 3_000_000_000");
        System.out.println("Risultato ottenuto: " + result + " (OVERFLOW!)");
        System.out.println("\n⚠️  Soluzione: usa long per valori grandi!");
        
        long billionL = 1_000_000_000L;
        long correctResult = billionL * 3;
        System.out.println("long billion = 1_000_000_000L;");
        System.out.println("billion * 3 = " + correctResult + " (CORRETTO!)\n");
        
        printSubSection("8.4 PREVENIRE OVERFLOW");
        
        System.out.println("Metodi per prevenire overflow:");
        System.out.println("1. Usa tipi più grandi (long invece di int)");
        System.out.println("2. Controlla i limiti prima di operazioni");
        System.out.println("3. Usa Math.addExact(), Math.multiplyExact() (Java 8+)");
        System.out.println("   che lanciano ArithmeticException in caso di overflow\n");
        
        try {
            int safe = Math.addExact(Integer.MAX_VALUE, 1);
        } catch (ArithmeticException e) {
            System.out.println("Math.addExact(MAX_VALUE, 1) -> ArithmeticException!");
            System.out.println("Eccezione catturata: previene overflow silenzioso\n");
        }
    }
    
    /**
     * Demo di BEST PRACTICES nell'uso dei tipi primitivi
     */
    private static void demoBestPractices() {
        printSection("9. BEST PRACTICES");
        
        printSubSection("9.1 SCELTA DEL TIPO GIUSTO");
        
        System.out.println("✓ Usa int per numeri interi generici (default)");
        System.out.println("✓ Usa long per timestamp, grandi quantità");
        System.out.println("✓ Usa double per decimali generici (default)");
        System.out.println("✓ Usa float solo se memoria è critica (es: array enormi)");
        System.out.println("✓ Usa byte/short solo per ottimizzare array grandi");
        System.out.println("✓ Usa boolean per flag e condizioni");
        System.out.println("✓ Usa char per singoli caratteri\n");
        
        printSubSection("9.2 DICHIARAZIONE E INIZIALIZZAZIONE");
        
        System.out.println("✓ SEMPRE inizializzare le variabili locali:");
        System.out.println("  int count = 0;  // GOOD");
        System.out.println("  int count;      // BAD - potrebbe non essere inizializzato\n");
        
        System.out.println("✓ Usa nomi descrittivi:");
        System.out.println("  int userAge = 25;           // GOOD");
        System.out.println("  int x = 25;                 // BAD\n");
        
        System.out.println("✓ Usa costanti per valori magici:");
        System.out.println("  final int MAX_USERS = 100;  // GOOD");
        System.out.println("  if (users > 100) {...}      // BAD\n");
        
        printSubSection("9.3 OPERAZIONI E CONVERSIONI");
        
        System.out.println("✓ Fai attenzione alle conversioni implicite:");
        System.out.println("  int i = 10;");
        System.out.println("  double d = i;     // OK - widening");
        System.out.println("  int j = (int) d;  // Richiede cast - narrowing\n");
        
        System.out.println("✓ Nelle divisioni, considera il tipo del risultato:");
        System.out.println("  int a = 10, b = 3;");
        System.out.println("  int result = a / b;          // 3 (divisione intera)");
        System.out.println("  double result = (double)a / b; // 3.333... (cast!)\n");
        
        System.out.println("✓ Usa suffissi per chiarezza:");
        System.out.println("  long l = 1000000000L;   // Non 1000000000");
        System.out.println("  float f = 3.14F;        // Non 3.14\n");
        
        printSubSection("9.4 CONFRONTI E OPERAZIONI");
        
        System.out.println("✓ Per confronti di float/double, usa tolleranza:");
        System.out.println("  double epsilon = 0.0001;");
        System.out.println("  if (Math.abs(a - b) < epsilon) {...}\n");
        
        System.out.println("✓ Con i wrapper, usa equals() non ==:");
        System.out.println("  Integer a = 200, b = 200;");
        System.out.println("  if (a.equals(b)) {...}  // GOOD");
        System.out.println("  if (a == b) {...}       // BAD - confronta riferimenti!\n");
        
        printSubSection("9.5 PERFORMANCE E MEMORIA");
        
        System.out.println("✓ Primitivi sono più efficienti dei wrapper:");
        System.out.println("  - Usano meno memoria");
        System.out.println("  - Più veloci (no overhead oggetti)");
        System.out.println("  - Preferisci primitivi quando possibile\n");
        
        System.out.println("✓ Ma usa wrapper quando:");
        System.out.println("  - Servono in Collections (List<Integer>)");
        System.out.println("  - Può essere null");
        System.out.println("  - Servono metodi utility (parsing, etc.)\n");
        
        printSubSection("9.6 NAMING CONVENTIONS");
        
        System.out.println("✓ Variabili: camelCase");
        System.out.println("  int userAge;");
        System.out.println("  double averageScore;\n");
        
        System.out.println("✓ Costanti: UPPER_SNAKE_CASE");
        System.out.println("  final int MAX_SIZE = 100;");
        System.out.println("  final double PI = 3.14159;\n");
    }
    
    // ===== METODI DI UTILITÀ PER LA FORMATTAZIONE =====
    
    private static void printHeader(String title) {
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                  ║");
        System.out.printf("║     %-58s  ║%n", title);
        System.out.println("║                                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    private static void printSection(String title) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("  " + title);
        System.out.println("=".repeat(70) + "\n");
    }
    
    private static void printSubSection(String title) {
        System.out.println();
        System.out.println("--- " + title + " " + "-".repeat(Math.max(0, 66 - title.length())));
        System.out.println();
    }
    
    private static void printFooter() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("  DEMO COMPLETATA!");
        System.out.println("=".repeat(70));
        System.out.println("\nPer approfondimenti, consulta la documentazione ufficiale Java.");
        System.out.println();
    }
}
