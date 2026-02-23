package com.corso.samples.datatypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe demo completa per l'apprendimento dei WRAPPER TYPES in Java
 * 
 * I wrapper types sono classi che "avvolgono" (wrap) i tipi primitivi,
 * trasformandoli in oggetti. Questo è necessario perché Java distingue
 * tra tipi primitivi (memorizzati nello stack) e oggetti (memorizzati nell'heap).
 * 
 * QUANDO USARE I WRAPPER:
 * - Con le Collections (List, Set, Map, etc.) che accettano solo oggetti
 * - Quando serve un valore nullable (i primitivi non possono essere null)
 * - Per accedere ai metodi utility delle classi wrapper
 * - Con i Generics che richiedono tipi riferimento
 * 
 * @author Java 21 Course
 * @version 1.0
 */
public class WrapperTypesDemo {

    /**
     * Metodo principale che esegue tutte le demo sui wrapper types
     * Questo metodo orchestra l'esecuzione sequenziale di tutte le sezioni
     */
    public static void run() {
        printHeader("DEMO COMPLETA: WRAPPER TYPES IN JAVA");
        
        // Sezione 1: Introduzione e corrispondenze primitive <-> wrapper
        demoIntroductionAndMapping();
        
        // Sezione 2: Autoboxing e Unboxing (conversioni automatiche)
        demoAutoboxingUnboxing();
        
        // Sezione 3: Cache degli Integer e comportamento speciale
        demoIntegerCache();
        
        // Sezione 4: Metodi di parsing (da stringa a wrapper/primitivo)
        demoParsingMethods();
        
        // Sezione 5: Metodi di conversione (toString, valueOf)
        demoConversionMethods();
        
        // Sezione 6: Confronto tra wrapper (== vs equals)
        demoComparison();
        
        // Sezione 7: Null safety e NullPointerException
        demoNullSafety();
        
        // Sezione 8: Costanti e metodi utility
        demoConstantsAndUtilities();
        
        // Sezione 9: Wrapper specifici - Metodi unici per ogni tipo
        demoSpecificWrapperMethods();
        
        // Sezione 10: Collections e Generics (il motivo principale dei wrapper)
        demoCollectionsAndGenerics();
        
        // Sezione 11: Performance: Wrapper vs Primitivi
        demoPerformanceConsiderations();
        
        // Sezione 12: Best Practices professionali
        demoBestPractices();
        
        printFooter();
    }

    /**
     * SEZIONE 1: Introduzione ai Wrapper Types e mappatura primitive <-> wrapper
     * 
     * Questa sezione mostra la corrispondenza uno-a-uno tra tipi primitivi
     * e le relative classi wrapper, evidenziando le differenze di nomenclatura.
     */
    private static void demoIntroductionAndMapping() {
        printSection("1. INTRODUZIONE AI WRAPPER TYPES");
        
        System.out.println("I wrapper types sono classi che incapsulano i tipi primitivi.");
        System.out.println("Ogni tipo primitivo ha il suo wrapper corrispondente:\n");
        
        // Mappatura completa tra primitivi e wrapper
        System.out.println("┌──────────────┬────────────────┬─────────────────────────────────────┐");
        System.out.println("│  PRIMITIVO   │    WRAPPER     │           NOTA                      │");
        System.out.println("├──────────────┼────────────────┼─────────────────────────────────────┤");
        System.out.println("│ byte         │ Byte           │ Nome identico ma maiuscolo          │");
        System.out.println("│ short        │ Short          │ Nome identico ma maiuscolo          │");
        System.out.println("│ int          │ Integer        │ ⚠️ NOME DIVERSO: int → Integer      │");
        System.out.println("│ long         │ Long           │ Nome identico ma maiuscolo          │");
        System.out.println("│ float        │ Float          │ Nome identico ma maiuscolo          │");
        System.out.println("│ double       │ Double         │ Nome identico ma maiuscolo          │");
        System.out.println("│ char         │ Character      │ ⚠️ NOME DIVERSO: char → Character   │");
        System.out.println("│ boolean      │ Boolean        │ Nome identico ma maiuscolo          │");
        System.out.println("└──────────────┴────────────────┴─────────────────────────────────────┘\n");
        
        // Esempi di dichiarazione
        printSubSection("Esempi di Dichiarazione");
        
        // Tipi primitivi
        int primitiveInt = 42;
        double primitiveDouble = 3.14;
        boolean primitiveBoolean = true;
        
        // Tipi wrapper (note: sono oggetti!)
        Integer wrapperInt = 42;              // Autoboxing (conversione automatica)
        Double wrapperDouble = 3.14;          // Autoboxing
        Boolean wrapperBoolean = true;        // Autoboxing
        
        System.out.println("Primitivi:");
        System.out.println("  int primitiveInt = 42;              → Valore nello stack");
        System.out.println("  double primitiveDouble = 3.14;      → Valore nello stack");
        System.out.println("  boolean primitiveBoolean = true;    → Valore nello stack\n");
        
        System.out.println("Wrapper (oggetti):");
        System.out.println("  Integer wrapperInt = 42;            → Oggetto nell'heap");
        System.out.println("  Double wrapperDouble = 3.14;        → Oggetto nell'heap");
        System.out.println("  Boolean wrapperBoolean = true;      → Oggetto nell'heap\n");
        
        // Differenza fondamentale: i wrapper possono essere null
        Integer nullableInt = null;           // ✓ VALIDO per wrapper
        // int primitiveNull = null;          // ✗ ERRORE di compilazione per primitivi
        
        System.out.println("⚠️ DIFFERENZA FONDAMENTALE:");
        System.out.println("  Integer nullableInt = null;         → ✓ VALIDO (i wrapper sono oggetti)");
        System.out.println("  int primitiveNull = null;           → ✗ ERRORE (i primitivi non possono essere null)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 2: Autoboxing e Unboxing
     * 
     * Autoboxing: conversione automatica da primitivo a wrapper
     * Unboxing: conversione automatica da wrapper a primitivo
     * Introdotti in Java 5 per semplificare il codice
     */
    private static void demoAutoboxingUnboxing() {
        printSection("2. AUTOBOXING E UNBOXING");
        
        System.out.println("Autoboxing e Unboxing sono conversioni automatiche introdotte in Java 5.");
        System.out.println("Rendono il codice più semplice e leggibile.\n");
        
        printSubSection("AUTOBOXING (primitivo → wrapper)");
        
        // Autoboxing: il compilatore converte automaticamente il primitivo in wrapper
        int primitiveValue = 100;
        Integer wrapperValue = primitiveValue;    // Autoboxing automatico
        // Il compilatore trasforma questo in: Integer wrapperValue = Integer.valueOf(primitiveValue);
        
        System.out.println("Codice scritto:");
        System.out.println("  int primitiveValue = 100;");
        System.out.println("  Integer wrapperValue = primitiveValue;  // Autoboxing\n");
        
        System.out.println("Cosa fa il compilatore:");
        System.out.println("  Integer wrapperValue = Integer.valueOf(primitiveValue);");
        System.out.println("  Risultato: wrapperValue = " + wrapperValue + "\n");
        
        printSubSection("UNBOXING (wrapper → primitivo)");
        
        // Unboxing: il compilatore converte automaticamente il wrapper in primitivo
        Integer boxedValue = 200;
        int unboxedValue = boxedValue;            // Unboxing automatico
        // Il compilatore trasforma questo in: int unboxedValue = boxedValue.intValue();
        
        System.out.println("Codice scritto:");
        System.out.println("  Integer boxedValue = 200;");
        System.out.println("  int unboxedValue = boxedValue;          // Unboxing\n");
        
        System.out.println("Cosa fa il compilatore:");
        System.out.println("  int unboxedValue = boxedValue.intValue();");
        System.out.println("  Risultato: unboxedValue = " + unboxedValue + "\n");
        
        printSubSection("AUTOBOXING in Espressioni");
        
        // Autoboxing funziona anche in espressioni complesse
        Integer a = 10;                           // Autoboxing
        Integer b = 20;                           // Autoboxing
        Integer sum = a + b;                      // Unboxing di a e b, poi autoboxing del risultato
        
        System.out.println("Espressione con wrapper:");
        System.out.println("  Integer a = 10;");
        System.out.println("  Integer b = 20;");
        System.out.println("  Integer sum = a + b;                    // Unboxing + Autoboxing");
        System.out.println("  Risultato: sum = " + sum + "\n");
        
        System.out.println("Il compilatore fa:");
        System.out.println("  1. Unboxing: a.intValue() + b.intValue()  → 30");
        System.out.println("  2. Autoboxing: Integer.valueOf(30)        → sum\n");
        
        printSubSection("⚠️ PERICOLO: NullPointerException con Unboxing");
        
        // Se un wrapper è null e facciamo unboxing, otteniamo NullPointerException
        Integer nullValue = null;
        System.out.println("Integer nullValue = null;");
        System.out.println("Tentativo di unboxing:");
        
        try {
            int dangerous = nullValue;            // NullPointerException! (unboxing di null)
            System.out.println("  int dangerous = nullValue;          → Risultato: " + dangerous);
        } catch (NullPointerException e) {
            System.out.println("  int dangerous = nullValue;          → ✗ NullPointerException!");
            System.out.println("  Il compilatore prova a chiamare nullValue.intValue(), ma nullValue è null!\n");
        }
        
        waitForEnter();
    }

    /**
     * SEZIONE 3: Cache degli Integer
     * 
     * Java mantiene una cache per Integer con valori da -128 a 127.
     * Questo significa che Integer.valueOf() per questi valori restituisce
     * sempre lo stesso oggetto dalla cache, invece di crearne uno nuovo.
     * Questo ottimizza memoria e performance per i valori più comuni.
     */
    private static void demoIntegerCache() {
        printSection("3. CACHE DEGLI INTEGER (-128 a 127)");
        
        System.out.println("Java mantiene una CACHE interna per gli Integer con valori da -128 a 127.");
        System.out.println("Questo significa che Integer.valueOf() per questi valori restituisce");
        System.out.println("sempre lo STESSO oggetto dalla cache (ottimizzazione di memoria).\n");
        
        printSubSection("Comportamento CON la Cache (valori da -128 a 127)");
        
        // Valori nella cache: gli oggetti sono condivisi
        Integer cached1 = 100;                    // Autoboxing → Integer.valueOf(100)
        Integer cached2 = 100;                    // Autoboxing → Integer.valueOf(100)
        
        System.out.println("Integer cached1 = 100;");
        System.out.println("Integer cached2 = 100;");
        System.out.println("cached1 == cached2 → " + (cached1 == cached2) + "  ✓ STESSO oggetto dalla cache!");
        System.out.println("cached1.equals(cached2) → " + cached1.equals(cached2) + "\n");
        
        // Anche con metodi espliciti
        Integer explicitCached1 = Integer.valueOf(50);
        Integer explicitCached2 = Integer.valueOf(50);
        
        System.out.println("Integer explicitCached1 = Integer.valueOf(50);");
        System.out.println("Integer explicitCached2 = Integer.valueOf(50);");
        System.out.println("explicitCached1 == explicitCached2 → " + (explicitCached1 == explicitCached2) + "  ✓ STESSO oggetto!\n");
        
        printSubSection("Comportamento SENZA la Cache (valori fuori da -128 a 127)");
        
        // Valori fuori dalla cache: ogni volta viene creato un nuovo oggetto
        Integer notCached1 = 1000;                // Autoboxing → Integer.valueOf(1000) → nuovo oggetto
        Integer notCached2 = 1000;                // Autoboxing → Integer.valueOf(1000) → nuovo oggetto diverso!
        
        System.out.println("Integer notCached1 = 1000;");
        System.out.println("Integer notCached2 = 1000;");
        System.out.println("notCached1 == notCached2 → " + (notCached1 == notCached2) + "  ✗ OGGETTI DIVERSI!");
        System.out.println("notCached1.equals(notCached2) → " + notCached1.equals(notCached2) + "  ✓ Ma i VALORI sono uguali\n");
        
        // Con costruttore: sempre nuovo oggetto (DEPRECATO in Java 9+)
        @SuppressWarnings("deprecation")
        Integer constructed1 = new Integer(100);  // Sempre nuovo oggetto
        @SuppressWarnings("deprecation")
        Integer constructed2 = new Integer(100);  // Sempre nuovo oggetto
        
        System.out.println("⚠️ Con costruttore (DEPRECATO):");
        System.out.println("Integer constructed1 = new Integer(100);  // SCONSIGLIATO!");
        System.out.println("Integer constructed2 = new Integer(100);");
        System.out.println("constructed1 == constructed2 → " + (constructed1 == constructed2) + "  ✗ SEMPRE oggetti diversi\n");
        
        printSubSection("💡 LEZIONE IMPORTANTE");
        
        System.out.println("✓ USA sempre .equals() per confrontare wrapper, MAI ==");
        System.out.println("✓ L'operatore == confronta i RIFERIMENTI (indirizzi di memoria), non i valori");
        System.out.println("✓ Il metodo .equals() confronta i VALORI contenuti negli oggetti");
        System.out.println("✓ La cache funziona solo per Integer, Long, Short, Byte e Character (range limitato)\n");
        
        // Altri wrapper con cache
        printSubSection("Cache per Altri Wrapper");
        
        System.out.println("Byte:      Tutti i valori (-128 a 127) sono cached");
        System.out.println("Short:     Valori da -128 a 127 sono cached");
        System.out.println("Long:      Valori da -128 a 127 sono cached");
        System.out.println("Character: Valori da 0 a 127 (ASCII) sono cached");
        System.out.println("Boolean:   Solo due istanze: Boolean.TRUE e Boolean.FALSE");
        System.out.println("Float:     Nessuna cache");
        System.out.println("Double:    Nessuna cache\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 4: Metodi di Parsing
     * 
     * I metodi di parsing convertono stringhe in tipi primitivi o wrapper.
     * Ogni wrapper fornisce metodi statici per il parsing.
     */
    private static void demoParsingMethods() {
        printSection("4. METODI DI PARSING (String → Wrapper/Primitivo)");
        
        System.out.println("Ogni wrapper fornisce metodi statici per convertire stringhe in numeri/valori.\n");
        
        printSubSection("Parsing verso PRIMITIVI (parseXxx)");
        
        // Metodi parseXxx() restituiscono primitivi
        int parsedInt = Integer.parseInt("42");
        long parsedLong = Long.parseLong("1000000");
        double parsedDouble = Double.parseDouble("3.14159");
        boolean parsedBoolean = Boolean.parseBoolean("true");
        
        System.out.println("int parsedInt = Integer.parseInt(\"42\");");
        System.out.println("  → parsedInt = " + parsedInt + " (tipo primitivo int)\n");
        
        System.out.println("long parsedLong = Long.parseLong(\"1000000\");");
        System.out.println("  → parsedLong = " + parsedLong + " (tipo primitivo long)\n");
        
        System.out.println("double parsedDouble = Double.parseDouble(\"3.14159\");");
        System.out.println("  → parsedDouble = " + parsedDouble + " (tipo primitivo double)\n");
        
        System.out.println("boolean parsedBoolean = Boolean.parseBoolean(\"true\");");
        System.out.println("  → parsedBoolean = " + parsedBoolean + " (tipo primitivo boolean)\n");
        
        printSubSection("Parsing verso WRAPPER (valueOf)");
        
        // Metodi valueOf() restituiscono wrapper (oggetti)
        Integer valueOfInt = Integer.valueOf("123");
        Long valueOfLong = Long.valueOf("999999");
        Double valueOfDouble = Double.valueOf("2.71828");
        Boolean valueOfBoolean = Boolean.valueOf("false");
        
        System.out.println("Integer valueOfInt = Integer.valueOf(\"123\");");
        System.out.println("  → valueOfInt = " + valueOfInt + " (oggetto Integer)\n");
        
        System.out.println("Long valueOfLong = Long.valueOf(\"999999\");");
        System.out.println("  → valueOfLong = " + valueOfLong + " (oggetto Long)\n");
        
        System.out.println("Double valueOfDouble = Double.valueOf(\"2.71828\");");
        System.out.println("  → valueOfDouble = " + valueOfDouble + " (oggetto Double)\n");
        
        System.out.println("Boolean valueOfBoolean = Boolean.valueOf(\"false\");");
        System.out.println("  → valueOfBoolean = " + valueOfBoolean + " (oggetto Boolean)\n");
        
        printSubSection("Parsing con Basi Diverse (per interi)");
        
        // Integer, Long, Short, Byte supportano parsing con basi diverse
        int binary = Integer.parseInt("1010", 2);        // Base 2 (binario)
        int octal = Integer.parseInt("77", 8);           // Base 8 (ottale)
        int hex = Integer.parseInt("FF", 16);            // Base 16 (esadecimale)
        
        System.out.println("int binary = Integer.parseInt(\"1010\", 2);    // Binario");
        System.out.println("  → binary = " + binary + " (1010 in base 2 = 10 in base 10)\n");
        
        System.out.println("int octal = Integer.parseInt(\"77\", 8);       // Ottale");
        System.out.println("  → octal = " + octal + " (77 in base 8 = 63 in base 10)\n");
        
        System.out.println("int hex = Integer.parseInt(\"FF\", 16);        // Esadecimale");
        System.out.println("  → hex = " + hex + " (FF in base 16 = 255 in base 10)\n");
        
        printSubSection("⚠️ Gestione Errori con Parsing");
        
        System.out.println("Il parsing può lanciare NumberFormatException se la stringa non è valida:\n");
        
        try {
            int invalid = Integer.parseInt("abc");     // Non è un numero!
            System.out.println("int invalid = Integer.parseInt(\"abc\"); → " + invalid);
        } catch (NumberFormatException e) {
            System.out.println("int invalid = Integer.parseInt(\"abc\");");
            System.out.println("  → ✗ NumberFormatException: \"abc\" non è un numero valido!\n");
        }
        
        // Best practice: gestire sempre le eccezioni
        System.out.println("💡 BEST PRACTICE: Usa sempre try-catch per il parsing:");
        System.out.println("""
                try {
                    int number = Integer.parseInt(userInput);
                    // Usa il numero...
                } catch (NumberFormatException e) {
                    System.out.println("Input non valido!");
                }
                """);
        
        waitForEnter();
    }

    /**
     * SEZIONE 5: Metodi di Conversione
     * 
     * I wrapper forniscono metodi per convertire valori in stringhe,
     * altri tipi primitivi, e altri wrapper.
     */
    private static void demoConversionMethods() {
        printSection("5. METODI DI CONVERSIONE");
        
        System.out.println("I wrapper forniscono numerosi metodi per convertire valori.\n");
        
        printSubSection("Conversione a STRINGA (toString)");
        
        // toString() su istanze
        Integer number = 42;
        String str1 = number.toString();                  // Metodo di istanza
        
        // toString() statico
        String str2 = Integer.toString(42);               // Metodo statico
        String str3 = Integer.toString(255, 16);          // In base esadecimale
        
        System.out.println("Integer number = 42;");
        System.out.println("String str1 = number.toString();");
        System.out.println("  → str1 = \"" + str1 + "\"\n");
        
        System.out.println("String str2 = Integer.toString(42);");
        System.out.println("  → str2 = \"" + str2 + "\"\n");
        
        System.out.println("String str3 = Integer.toString(255, 16);    // Base 16");
        System.out.println("  → str3 = \"" + str3 + "\" (255 in esadecimale)\n");
        
        printSubSection("Conversione a PRIMITIVO (xxxValue)");
        
        // Ogni wrapper ha metodi per convertirsi in tutti i tipi primitivi
        Integer value = 100;
        
        int asInt = value.intValue();
        long asLong = value.longValue();
        double asDouble = value.doubleValue();
        byte asByte = value.byteValue();
        
        System.out.println("Integer value = 100;");
        System.out.println("int asInt = value.intValue();          → " + asInt);
        System.out.println("long asLong = value.longValue();       → " + asLong);
        System.out.println("double asDouble = value.doubleValue(); → " + asDouble);
        System.out.println("byte asByte = value.byteValue();       → " + asByte + " (può causare overflow!)\n");
        
        printSubSection("valueOf() - Creazione di Wrapper");
        
        // valueOf() è il metodo RACCOMANDATO per creare wrapper (usa la cache!)
        Integer fromInt = Integer.valueOf(42);            // Da int
        Integer fromString = Integer.valueOf("42");       // Da String
        Integer fromBase = Integer.valueOf("FF", 16);     // Da String con base
        
        System.out.println("Integer fromInt = Integer.valueOf(42);");
        System.out.println("  → fromInt = " + fromInt + " (usa la cache se possibile)\n");
        
        System.out.println("Integer fromString = Integer.valueOf(\"42\");");
        System.out.println("  → fromString = " + fromString + "\n");
        
        System.out.println("Integer fromBase = Integer.valueOf(\"FF\", 16);");
        System.out.println("  → fromBase = " + fromBase + " (FF hex = 255 decimale)\n");
        
        printSubSection("Conversioni Specifiche per Numerici");
        
        // toBinaryString, toHexString, toOctalString (solo per interi)
        String binary = Integer.toBinaryString(42);
        String hex = Integer.toHexString(42);
        String octal = Integer.toOctalString(42);
        
        System.out.println("int numero = 42;");
        System.out.println("Integer.toBinaryString(42)  → \"" + binary + "\" (binario)");
        System.out.println("Integer.toHexString(42)     → \"" + hex + "\" (esadecimale)");
        System.out.println("Integer.toOctalString(42)   → \"" + octal + "\" (ottale)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 6: Confronto tra Wrapper
     * 
     * Mostra la differenza critica tra == e .equals() quando si confrontano wrapper.
     * Questo è uno degli errori più comuni per chi impara Java!
     */
    private static void demoComparison() {
        printSection("6. CONFRONTO TRA WRAPPER (== vs equals)");
        
        System.out.println("⚠️ ATTENZIONE: Questo è uno degli errori più comuni in Java!\n");
        
        printSubSection("Problema con == (confronta riferimenti)");
        
        // L'operatore == confronta i RIFERIMENTI (indirizzi di memoria)
        Integer a = 1000;
        Integer b = 1000;
        
        System.out.println("Integer a = 1000;");
        System.out.println("Integer b = 1000;");
        System.out.println("a == b → " + (a == b) + "  ✗ FALSO perché sono oggetti diversi!");
        System.out.println("a.equals(b) → " + a.equals(b) + "  ✓ VERO perché i valori sono uguali\n");
        
        // Caso particolare: cache degli Integer
        Integer c = 100;  // Nella cache
        Integer d = 100;  // Stesso oggetto dalla cache
        
        System.out.println("Integer c = 100;  // Valore nella cache (-128 a 127)");
        System.out.println("Integer d = 100;");
        System.out.println("c == d → " + (c == d) + "  ✓ VERO per caso speciale (cache)");
        System.out.println("  → MA NON FIDARTI! Usa sempre .equals()!\n");
        
        printSubSection("Soluzione: USA .equals() per i VALORI");
        
        System.out.println("Il metodo .equals() confronta i VALORI contenuti, non i riferimenti.\n");
        
        Integer num1 = 500;
        Integer num2 = 500;
        Integer num3 = null;
        
        System.out.println("Integer num1 = 500;");
        System.out.println("Integer num2 = 500;");
        System.out.println("Integer num3 = null;");
        System.out.println();
        System.out.println("num1.equals(num2) → " + num1.equals(num2) + "  ✓ Confronta i valori");
        System.out.println("num1 == num2 → " + (num1 == num2) + "  ✗ Confronta i riferimenti");
        System.out.println();
        
        // Attenzione con null
        System.out.println("⚠️ ATTENZIONE con null:");
        try {
            boolean result = num3.equals(num1);  // NullPointerException!
            System.out.println("num3.equals(num1) → " + result);
        } catch (NullPointerException e) {
            System.out.println("num3.equals(num1) → ✗ NullPointerException (num3 è null!)");
        }
        
        System.out.println("num1.equals(num3) → " + num1.equals(num3) + "  ✓ Sicuro (restituisce false)\n");
        
        printSubSection("Metodo compare() per Ordinamento");
        
        // I wrapper forniscono il metodo compare() per confronti ordinali
        Integer x = 10;
        Integer y = 20;
        
        int comparison1 = Integer.compare(x, y);     // Metodo statico
        int comparison2 = x.compareTo(y);            // Metodo di istanza
        
        System.out.println("Integer x = 10;");
        System.out.println("Integer y = 20;");
        System.out.println();
        System.out.println("Integer.compare(x, y) → " + comparison1 + "  (negativo perché x < y)");
        System.out.println("x.compareTo(y) → " + comparison2 + "  (negativo perché x < y)");
        System.out.println();
        System.out.println("Convenzione:");
        System.out.println("  Ritorna < 0  se primo < secondo");
        System.out.println("  Ritorna 0    se primo == secondo");
        System.out.println("  Ritorna > 0  se primo > secondo\n");
        
        printSubSection("💡 REGOLA D'ORO");
        
        System.out.println("✓ Per confrontare VALORI wrapper: usa .equals()");
        System.out.println("✓ Per confrontare primitivi: usa == (va bene, sono valori non oggetti)");
        System.out.println("✓ Per ordinamento: usa .compareTo() o compare()");
        System.out.println("✗ NON usare MAI == per confrontare wrapper (tranne primitivi)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 7: Null Safety e NullPointerException
     * 
     * I wrapper possono essere null (a differenza dei primitivi),
     * e questo può causare NullPointerException in vari scenari.
     */
    private static void demoNullSafety() {
        printSection("7. NULL SAFETY E NullPointerException");
        
        System.out.println("I wrapper sono oggetti, quindi possono essere null.");
        System.out.println("Questo richiede attenzione per evitare NullPointerException!\n");
        
        printSubSection("Situazioni che Causano NullPointerException");
        
        Integer nullValue = null;
        
        // Scenario 1: Unboxing di null
        System.out.println("1. UNBOXING di null:");
        System.out.println("   Integer nullValue = null;");
        try {
            int primitive = nullValue;  // Tenta di chiamare nullValue.intValue()
            System.out.println("   int primitive = nullValue; → " + primitive);
        } catch (NullPointerException e) {
            System.out.println("   int primitive = nullValue; → ✗ NullPointerException!\n");
        }
        
        // Scenario 2: Operazioni aritmetiche
        System.out.println("2. OPERAZIONI ARITMETICHE con null:");
        System.out.println("   Integer a = null;");
        System.out.println("   Integer b = 10;");
        try {
            Integer a = null;
            Integer b = 10;
            Integer sum = a + b;  // Tenta unboxing di a
            System.out.println("   Integer sum = a + b; → " + sum);
        } catch (NullPointerException e) {
            System.out.println("   Integer sum = a + b; → ✗ NullPointerException!\n");
        }
        
        // Scenario 3: Chiamata metodi su null
        System.out.println("3. CHIAMATA METODI su null:");
        System.out.println("   Integer value = null;");
        try {
            String str = nullValue.toString();
            System.out.println("   String str = value.toString(); → " + str);
        } catch (NullPointerException e) {
            System.out.println("   String str = value.toString(); → ✗ NullPointerException!\n");
        }
        
        printSubSection("✓ Come Prevenire NullPointerException");
        
        System.out.println("1. CONTROLLO ESPLICITO con if:");
        Integer maybeNull = null;
        if (maybeNull != null) {
            int safe = maybeNull;  // Sicuro
            System.out.println("   Valore: " + safe);
        } else {
            System.out.println("   Il valore è null, uso default: 0\n");
        }
        
        System.out.println("2. OPERATORE TERNARIO:");
        Integer possiblyNull = null;
        int safeValue = (possiblyNull != null) ? possiblyNull : 0;
        System.out.println("   int safeValue = (possiblyNull != null) ? possiblyNull : 0;");
        System.out.println("   → safeValue = " + safeValue + "\n");
        
        System.out.println("3. USO DI Optional (Java 8+):");
        System.out.println("""
                   Optional<Integer> optional = Optional.ofNullable(maybeNull);
                   int value = optional.orElse(0);  // Valore di default se null
                   """);
        
        System.out.println("4. METODI STATICI SAFE:");
        System.out.println("   // Per comparazioni:");
        Integer val1 = null;
        Integer val2 = 10;
        int comparison = Integer.compare(
            (val1 != null ? val1 : 0), 
            (val2 != null ? val2 : 0)
        );
        System.out.println("   Integer.compare(val1, val2) con gestione null → " + comparison + "\n");
        
        printSubSection("💡 BEST PRACTICES per Null Safety");
        
        System.out.println("✓ Inizializza sempre le variabili wrapper se possibile");
        System.out.println("✓ Controlla null prima di unboxing o operazioni");
        System.out.println("✓ Usa Optional<T> per rendere esplicita la possibilità di null");
        System.out.println("✓ Documenta con @Nullable e @NonNull (annotazioni)");
        System.out.println("✓ Considera l'uso di primitivi se null non è necessario\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 8: Costanti e Metodi Utility
     * 
     * Ogni wrapper fornisce costanti utili (MIN_VALUE, MAX_VALUE, SIZE, etc.)
     * e metodi utility per operazioni comuni.
     */
    private static void demoConstantsAndUtilities() {
        printSection("8. COSTANTI E METODI UTILITY");
        
        System.out.println("Ogni wrapper fornisce costanti e metodi utility per operazioni comuni.\n");
        
        printSubSection("Costanti MIN_VALUE e MAX_VALUE");
        
        System.out.println("Costanti per i LIMITI dei tipi:");
        System.out.println("Byte.MIN_VALUE   = " + Byte.MIN_VALUE);
        System.out.println("Byte.MAX_VALUE   = " + Byte.MAX_VALUE);
        System.out.println("Short.MIN_VALUE  = " + Short.MIN_VALUE);
        System.out.println("Short.MAX_VALUE  = " + Short.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Long.MIN_VALUE   = " + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE   = " + Long.MAX_VALUE);
        System.out.println("Float.MIN_VALUE  = " + Float.MIN_VALUE + "  (più piccolo positivo)");
        System.out.println("Float.MAX_VALUE  = " + Float.MAX_VALUE);
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE + "  (più piccolo positivo)");
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE + "\n");
        
        printSubSection("Costanti per Dimensioni");
        
        System.out.println("Costanti per le DIMENSIONI (in bit):");
        System.out.println("Byte.SIZE      = " + Byte.SIZE + " bit");
        System.out.println("Short.SIZE     = " + Short.SIZE + " bit");
        System.out.println("Integer.SIZE   = " + Integer.SIZE + " bit");
        System.out.println("Long.SIZE      = " + Long.SIZE + " bit");
        System.out.println("Float.SIZE     = " + Float.SIZE + " bit");
        System.out.println("Double.SIZE    = " + Double.SIZE + " bit");
        System.out.println("Character.SIZE = " + Character.SIZE + " bit\n");
        
        System.out.println("Dimensioni in BYTE:");
        System.out.println("Integer.BYTES  = " + Integer.BYTES + " byte");
        System.out.println("Long.BYTES     = " + Long.BYTES + " byte");
        System.out.println("Double.BYTES   = " + Double.BYTES + " byte\n");
        
        printSubSection("Costanti Speciali per Floating Point");
        
        System.out.println("Valori speciali per FLOAT e DOUBLE:");
        System.out.println("Double.POSITIVE_INFINITY = " + Double.POSITIVE_INFINITY);
        System.out.println("Double.NEGATIVE_INFINITY = " + Double.NEGATIVE_INFINITY);
        System.out.println("Double.NaN = " + Double.NaN + "  (Not a Number)");
        System.out.println("Double.MIN_NORMAL = " + Double.MIN_NORMAL + "  (più piccolo valore normale)\n");
        
        printSubSection("Costanti Boolean");
        
        System.out.println("Boolean ha solo DUE istanze (singleton):");
        System.out.println("Boolean.TRUE  → oggetto singleton per true");
        System.out.println("Boolean.FALSE → oggetto singleton per false");
        Boolean t1 = Boolean.TRUE;
        Boolean t2 = Boolean.valueOf(true);
        System.out.println("Boolean.TRUE == Boolean.valueOf(true) → " + (t1 == t2) + "  (stesso oggetto!)\n");
        
        printSubSection("Metodi Utility - Verifica Valori Speciali");
        
        double nanValue = 0.0 / 0.0;
        double infinity = 1.0 / 0.0;
        double normal = 42.5;
        
        System.out.println("Double.isNaN(0.0/0.0) → " + Double.isNaN(nanValue) + "  (è NaN)");
        System.out.println("Double.isInfinite(1.0/0.0) → " + Double.isInfinite(infinity) + "  (è infinito)");
        System.out.println("Double.isFinite(42.5) → " + Double.isFinite(normal) + "  (è finito)\n");
        
        printSubSection("Metodi Utility - Operazioni Matematiche");
        
        System.out.println("Integer.max(10, 20) → " + Integer.max(10, 20));
        System.out.println("Integer.min(10, 20) → " + Integer.min(10, 20));
        System.out.println("Integer.sum(10, 20) → " + Integer.sum(10, 20));
        System.out.println("Long.sum(1000000000L, 2000000000L) → " + Long.sum(1000000000L, 2000000000L) + "\n");
        
        printSubSection("Metodi Utility - Conversione di Segno");
        
        System.out.println("Integer.signum(-42) → " + Integer.signum(-42) + "  (negativo)");
        System.out.println("Integer.signum(0) → " + Integer.signum(0) + "  (zero)");
        System.out.println("Integer.signum(42) → " + Integer.signum(42) + "  (positivo)");
        System.out.println("Math.abs(-42) → " + Math.abs(-42) + "  (valore assoluto)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 9: Metodi Specifici per Ogni Wrapper
     * 
     * Ogni wrapper ha metodi unici specifici per il suo tipo.
     * Esploriamo i metodi più utili per ciascun wrapper.
     */
    private static void demoSpecificWrapperMethods() {
        printSection("9. METODI SPECIFICI PER OGNI WRAPPER");
        
        System.out.println("Ogni wrapper ha metodi unici per il suo tipo specifico.\n");
        
        printSubSection("CHARACTER - Metodi per Caratteri");
        
        char ch = 'A';
        System.out.println("char ch = 'A';\n");
        
        System.out.println("Character.isLetter('A') → " + Character.isLetter(ch));
        System.out.println("Character.isDigit('A') → " + Character.isDigit(ch));
        System.out.println("Character.isUpperCase('A') → " + Character.isUpperCase(ch));
        System.out.println("Character.isLowerCase('A') → " + Character.isLowerCase(ch));
        System.out.println("Character.isWhitespace('A') → " + Character.isWhitespace(ch));
        System.out.println("Character.toLowerCase('A') → " + Character.toLowerCase(ch));
        System.out.println("Character.toUpperCase('a') → " + Character.toUpperCase('a'));
        System.out.println("Character.isLetterOrDigit('A') → " + Character.isLetterOrDigit(ch));
        System.out.println("Character.getNumericValue('5') → " + Character.getNumericValue('5') + "\n");
        
        printSubSection("INTEGER/LONG - Operazioni Bitwise");
        
        int num = 42;
        System.out.println("int num = 42;\n");
        
        System.out.println("Integer.bitCount(42) → " + Integer.bitCount(num) + "  (numero di bit a 1)");
        System.out.println("Integer.highestOneBit(42) → " + Integer.highestOneBit(num) + "  (bit più alto a 1)");
        System.out.println("Integer.lowestOneBit(42) → " + Integer.lowestOneBit(num) + "  (bit più basso a 1)");
        System.out.println("Integer.numberOfLeadingZeros(42) → " + Integer.numberOfLeadingZeros(num) + "  (zeri iniziali)");
        System.out.println("Integer.numberOfTrailingZeros(42) → " + Integer.numberOfTrailingZeros(num) + "  (zeri finali)");
        System.out.println("Integer.reverse(42) → " + Integer.reverse(num) + "  (inverte i bit)");
        System.out.println("Integer.rotateLeft(42, 2) → " + Integer.rotateLeft(num, 2) + "  (rotazione sinistra)\n");
        
        printSubSection("INTEGER/LONG - Conversioni Unsigned (Java 8+)");
        
        // Java tratta gli interi come signed, ma fornisce metodi per unsigned
        byte signedByte = -1;
        int unsignedValue = Byte.toUnsignedInt(signedByte);
        
        System.out.println("byte signedByte = -1;");
        System.out.println("Valore signed: " + signedByte);
        System.out.println("Byte.toUnsignedInt(-1) → " + unsignedValue + "  (interpretato come unsigned)");
        System.out.println("Integer.toUnsignedString(-1) → " + Integer.toUnsignedString(-1) + "\n");
        
        printSubSection("DOUBLE/FLOAT - Conversioni Rappresentazione Binaria");
        
        double d = 3.14;
        long bits = Double.doubleToLongBits(d);
        double backToDouble = Double.longBitsToDouble(bits);
        
        System.out.println("double d = 3.14;");
        System.out.println("Double.doubleToLongBits(3.14) → " + bits + "  (rappresentazione binaria IEEE 754)");
        System.out.println("Double.longBitsToDouble(bits) → " + backToDouble + "  (riconvertito)\n");
        
        printSubSection("BOOLEAN - Logica");
        
        System.out.println("Boolean.logicalAnd(true, false) → " + Boolean.logicalAnd(true, false));
        System.out.println("Boolean.logicalOr(true, false) → " + Boolean.logicalOr(true, false));
        System.out.println("Boolean.logicalXor(true, false) → " + Boolean.logicalXor(true, false) + "\n");
        
        printSubSection("Metodi hashCode()");
        
        // Ogni wrapper ha un hashCode() per uso in HashMap, HashSet, etc.
        Integer i = 100;
        Double db = 3.14;
        Boolean bool = true;
        
        System.out.println("Integer(100).hashCode() → " + i.hashCode());
        System.out.println("Double(3.14).hashCode() → " + db.hashCode());
        System.out.println("Boolean(true).hashCode() → " + bool.hashCode() + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 10: Collections e Generics
     * 
     * Questa è la RAGIONE PRINCIPALE per cui esistono i wrapper!
     * Le Collections e i Generics in Java accettano solo tipi riferimento (oggetti),
     * non primitivi. I wrapper permettono di usare i primitivi nelle Collections.
     */
    private static void demoCollectionsAndGenerics() {
        printSection("10. COLLECTIONS E GENERICS - Il Motivo Principale dei Wrapper!");
        
        System.out.println("Le Collections (List, Set, Map) e i Generics accettano SOLO oggetti.");
        System.out.println("I wrapper permettono di usare tipi \"primitivi\" nelle Collections.\n");
        
        printSubSection("Problema: Collections NON Accettano Primitivi");
        
        System.out.println("✗ IMPOSSIBILE:");
        System.out.println("  // List<int> numbers = new ArrayList<>();  // ERRORE di compilazione!");
        System.out.println("  I generics richiedono tipi riferimento, non primitivi.\n");
        
        System.out.println("✓ SOLUZIONE: Usa i Wrapper!");
        System.out.println("  List<Integer> numbers = new ArrayList<>();  // OK!\n");
        
        printSubSection("List con Wrapper");
        
        // List di Integer (autoboxing automatico)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);           // Autoboxing: 10 → Integer.valueOf(10)
        numbers.add(20);
        numbers.add(30);
        
        System.out.println("List<Integer> numbers = new ArrayList<>();");
        System.out.println("numbers.add(10);  // Autoboxing automatico");
        System.out.println("numbers.add(20);");
        System.out.println("numbers.add(30);");
        System.out.println("numbers → " + numbers + "\n");
        
        // Accesso agli elementi (unboxing automatico)
        int first = numbers.get(0);  // Unboxing: Integer → int
        System.out.println("int first = numbers.get(0);  // Unboxing automatico");
        System.out.println("first → " + first + "\n");
        
        printSubSection("Operazioni su Collections con Wrapper");
        
        // Somma di tutti gli elementi
        int sum = 0;
        for (Integer num : numbers) {  // Unboxing automatico in ogni iterazione
            sum += num;
        }
        System.out.println("Somma di tutti gli elementi:");
        System.out.println("for (Integer num : numbers) { sum += num; }");
        System.out.println("sum → " + sum + "\n");
        
        // Con Stream (Java 8+)
        int sumWithStream = numbers.stream()
                                   .mapToInt(Integer::intValue)  // Unboxing esplicito
                                   .sum();
        System.out.println("Con Stream API:");
        System.out.println("numbers.stream().mapToInt(Integer::intValue).sum()");
        System.out.println("→ " + sumWithStream + "\n");
        
        printSubSection("List con Altri Wrapper");
        
        // List di Double
        List<Double> prices = new ArrayList<>();
        prices.add(19.99);
        prices.add(29.99);
        prices.add(9.99);
        
        System.out.println("List<Double> prices = new ArrayList<>();");
        System.out.println("prices.add(19.99);");
        System.out.println("prices → " + prices + "\n");
        
        // List di Boolean
        List<Boolean> flags = new ArrayList<>();
        flags.add(true);
        flags.add(false);
        flags.add(true);
        
        System.out.println("List<Boolean> flags = new ArrayList<>();");
        System.out.println("flags.add(true);");
        System.out.println("flags → " + flags + "\n");
        
        printSubSection("⚠️ Attenzione: Performance con Collections");
        
        System.out.println("Ogni elemento in una Collection è un OGGETTO:");
        System.out.println("  - Maggiore uso di memoria (oggetto vs primitivo)");
        System.out.println("  - Overhead di autoboxing/unboxing");
        System.out.println("  - Possibili NullPointerException\n");
        
        System.out.println("Per array GRANDI di numeri, considera:");
        System.out.println("  - Array primitivi: int[] invece di List<Integer>");
        System.out.println("  - Stream specializzati: IntStream, LongStream, DoubleStream");
        System.out.println("  - Librerie specializzate per performance critiche\n");
        
        printSubSection("Esempio: null in Collections");
        
        List<Integer> numbersWithNull = new ArrayList<>();
        numbersWithNull.add(10);
        numbersWithNull.add(null);  // Valido! Le Collections accettano null
        numbersWithNull.add(30);
        
        System.out.println("List<Integer> numbersWithNull = new ArrayList<>();");
        System.out.println("numbersWithNull.add(null);  // OK!");
        System.out.println("numbersWithNull → " + numbersWithNull + "\n");
        
        System.out.println("⚠️ ATTENZIONE quando si itera:");
        try {
            for (Integer num : numbersWithNull) {
                int double_value = num * 2;  // NullPointerException se num è null!
                System.out.println("  " + num + " * 2 = " + double_value);
            }
        } catch (NullPointerException e) {
            System.out.println("  ✗ NullPointerException! Controlla sempre null prima di unboxing.\n");
        }
        
        waitForEnter();
    }

    /**
     * SEZIONE 11: Performance - Wrapper vs Primitivi
     * 
     * I wrapper hanno un costo in termini di memoria e performance.
     * È importante sapere quando usarli e quando preferire i primitivi.
     */
    private static void demoPerformanceConsiderations() {
        printSection("11. PERFORMANCE: WRAPPER vs PRIMITIVI");
        
        System.out.println("I wrapper hanno un COSTO rispetto ai primitivi.\n");
        
        printSubSection("Differenze di Memoria");
        
        System.out.println("MEMORIA OCCUPATA:");
        System.out.println("┌─────────────┬──────────────┬───────────────┬─────────────┐");
        System.out.println("│   TIPO      │  PRIMITIVO   │    WRAPPER    │  OVERHEAD   │");
        System.out.println("├─────────────┼──────────────┼───────────────┼─────────────┤");
        System.out.println("│ boolean     │   1 bit*     │   ~16 byte    │   ~128x     │");
        System.out.println("│ byte        │   1 byte     │   ~16 byte    │   ~16x      │");
        System.out.println("│ short       │   2 byte     │   ~16 byte    │   ~8x       │");
        System.out.println("│ char        │   2 byte     │   ~16 byte    │   ~8x       │");
        System.out.println("│ int         │   4 byte     │   ~16 byte    │   ~4x       │");
        System.out.println("│ float       │   4 byte     │   ~16 byte    │   ~4x       │");
        System.out.println("│ long        │   8 byte     │   ~24 byte    │   ~3x       │");
        System.out.println("│ double      │   8 byte     │   ~24 byte    │   ~3x       │");
        System.out.println("└─────────────┴──────────────┴───────────────┴─────────────┘");
        System.out.println("* I boolean occupano 1 byte in array, ma l'implementazione varia\n");
        System.out.println("L'overhead include:");
        System.out.println("  - Header dell'oggetto (8-12 byte)");
        System.out.println("  - Il valore primitivo");
        System.out.println("  - Padding per allineamento memoria\n");
        
        printSubSection("Differenze di Performance - Autoboxing/Unboxing");
        
        System.out.println("Autoboxing e unboxing hanno un COSTO:");
        System.out.println("  - Allocazione oggetti (memoria heap)");
        System.out.println("  - Garbage collection");
        System.out.println("  - Accesso indiretto (dereferenziazione puntatore)\n");
        
        // Esempio: loop con primitivi
        System.out.println("Esempio: SOMMA con PRIMITIVI");
        long startPrimitive = System.nanoTime();
        long sumPrimitive = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sumPrimitive += i;
        }
        long endPrimitive = System.nanoTime();
        long timePrimitive = endPrimitive - startPrimitive;
        
        System.out.println("  long sum = 0;");
        System.out.println("  for (int i = 0; i < 1_000_000; i++) { sum += i; }");
        System.out.println("  Tempo: " + timePrimitive + " ns\n");
        
        // Esempio: loop con wrapper (con autoboxing/unboxing)
        System.out.println("Esempio: SOMMA con WRAPPER (autoboxing/unboxing)");
        long startWrapper = System.nanoTime();
        Long sumWrapper = 0L;  // Wrapper
        for (int i = 0; i < 1_000_000; i++) {
            sumWrapper += i;  // Unboxing di sumWrapper, poi autoboxing del risultato!
        }
        long endWrapper = System.nanoTime();
        long timeWrapper = endWrapper - startWrapper;
        
        System.out.println("  Long sum = 0L;");
        System.out.println("  for (int i = 0; i < 1_000_000; i++) { sum += i; }");
        System.out.println("  Tempo: " + timeWrapper + " ns\n");
        
        // Confronto
        System.out.println("CONFRONTO:");
        System.out.println("  Primitivi: " + timePrimitive + " ns");
        System.out.println("  Wrapper:   " + timeWrapper + " ns");
        if (timeWrapper > timePrimitive) {
            double ratio = (double) timeWrapper / timePrimitive;
            System.out.println("  → I wrapper sono ~" + String.format("%.1f", ratio) + "x più lenti in questo caso\n");
        }
        
        printSubSection("💡 QUANDO USARE PRIMITIVI");
        
        System.out.println("✓ Usa PRIMITIVI quando:");
        System.out.println("  - Performance è critica (loop intensivi, calcoli matematici)");
        System.out.println("  - Array grandi di numeri (int[], double[] invece di List)");
        System.out.println("  - Variabili locali in metodi (non serve null)");
        System.out.println("  - Campi di classe dove null non ha senso\n");
        
        printSubSection("💡 QUANDO USARE WRAPPER");
        
        System.out.println("✓ Usa WRAPPER quando:");
        System.out.println("  - Necessario per Collections (List<Integer>, Set<Double>, etc.)");
        System.out.println("  - Necessario per Generics (<T> deve essere tipo riferimento)");
        System.out.println("  - Il valore può essere null (rappresenta assenza di valore)");
        System.out.println("  - Servono metodi utility (Integer.parseInt, Double.isNaN, etc.)");
        System.out.println("  - Serializzazione/deserializzazione\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 12: Best Practices Professionali
     * 
     * Raccolta di best practices per l'uso professionale dei wrapper types.
     */
    private static void demoBestPractices() {
        printSection("12. BEST PRACTICES PROFESSIONALI");
        
        System.out.println("Linee guida per l'uso professionale dei wrapper types.\n");
        
        printSubSection("1. CREAZIONE DI WRAPPER");
        
        System.out.println("✓ USA valueOf() invece del costruttore:");
        System.out.println("  Integer good = Integer.valueOf(42);     // ✓ Usa la cache");
        System.out.println("  Integer bad = new Integer(42);          // ✗ DEPRECATO, sempre nuovo oggetto\n");
        
        System.out.println("✓ AUTOBOXING è OK per leggibilità:");
        System.out.println("  Integer auto = 42;                      // ✓ Chiaro e conciso\n");
        
        printSubSection("2. CONFRONTO DI VALORI");
        
        System.out.println("✓ USA .equals() per confrontare valori:");
        System.out.println("  Integer a = 1000, b = 1000;");
        System.out.println("  if (a.equals(b)) { ... }                // ✓ CORRETTO");
        System.out.println("  if (a == b) { ... }                     // ✗ SBAGLIATO (confronta riferimenti)\n");
        
        System.out.println("✓ Per ordinamento, usa .compareTo():");
        System.out.println("  if (a.compareTo(b) < 0) { ... }         // ✓ a è minore di b\n");
        
        printSubSection("3. NULL SAFETY");
        
        System.out.println("✓ CONTROLLA sempre null prima di unboxing:");
        System.out.println("""
                  Integer value = getValueFromSomewhere();
                  if (value != null) {
                      int primitive = value;  // Sicuro
                  }
                  """);
        
        System.out.println("✓ USA Optional per rendere esplicita la possibilità di null:");
        System.out.println("""
                  Optional<Integer> optional = Optional.ofNullable(value);
                  int result = optional.orElse(0);  // Valore default
                  """);
        
        printSubSection("4. COLLECTIONS");
        
        System.out.println("✓ Per Collections, i wrapper sono NECESSARI:");
        System.out.println("  List<Integer> numbers = new ArrayList<>();  // ✓ Corretto\n");
        
        System.out.println("✓ Per array grandi, considera primitivi:");
        System.out.println("  int[] bigArray = new int[1_000_000];    // ✓ Più efficiente\n");
        
        System.out.println("✓ Gestisci null nelle Collections:");
        System.out.println("""
                  for (Integer num : list) {
                      if (num != null) {
                          // Usa num...
                      }
                  }
                  """);
        
        printSubSection("5. PERFORMANCE");
        
        System.out.println("✓ Evita autoboxing/unboxing in loop intensivi:");
        System.out.println("  // ✗ LENTO:");
        System.out.println("  Long sum = 0L;");
        System.out.println("  for (int i = 0; i < 1_000_000; i++) {");
        System.out.println("      sum += i;  // Unboxing + autoboxing ad ogni iterazione!");
        System.out.println("  }\n");
        
        System.out.println("  // ✓ VELOCE:");
        System.out.println("  long sum = 0;");
        System.out.println("  for (int i = 0; i < 1_000_000; i++) {");
        System.out.println("      sum += i;  // Solo primitivi, nessun boxing");
        System.out.println("  }\n");
        
        printSubSection("6. PARSING E CONVERSIONI");
        
        System.out.println("✓ GESTISCI sempre NumberFormatException:");
        System.out.println("""
                  try {
                      int value = Integer.parseInt(userInput);
                  } catch (NumberFormatException e) {
                      System.out.println("Input non valido!");
                  }
                  """);
        
        System.out.println("✓ Usa metodi specifici per basi diverse:");
        System.out.println("  int hex = Integer.parseInt(\"FF\", 16);   // Base 16\n");
        
        printSubSection("7. IMMUTABILITÀ");
        
        System.out.println("✓ I wrapper sono IMMUTABILI:");
        System.out.println("  Integer a = 10;");
        System.out.println("  Integer b = a;");
        System.out.println("  a = 20;  // Crea un NUOVO oggetto, non modifica quello esistente");
        System.out.println("  // b è ancora 10, non è cambiato!\n");
        
        printSubSection("8. DOCUMENTAZIONE");
        
        System.out.println("✓ DOCUMENTA quando un valore può essere null:");
        System.out.println("""
                  /**
                   * @return l'età dell'utente, o null se non disponibile
                   */
                  public Integer getUserAge() { ... }
                  """);
        
        printSubSection("9. SCELTA TRA PRIMITIVO E WRAPPER");
        
        System.out.println("┌────────────────────────────┬──────────────┬──────────────┐");
        System.out.println("│       SITUAZIONE           │  PRIMITIVO   │   WRAPPER    │");
        System.out.println("├────────────────────────────┼──────────────┼──────────────┤");
        System.out.println("│ Variabile locale           │      ✓       │              │");
        System.out.println("│ Parametro metodo           │      ✓       │              │");
        System.out.println("│ Campo classe (non-null)    │      ✓       │              │");
        System.out.println("│ Campo classe (nullable)    │              │      ✓       │");
        System.out.println("│ Ritorno metodo (non-null)  │      ✓       │              │");
        System.out.println("│ Ritorno metodo (nullable)  │              │      ✓       │");
        System.out.println("│ Collections/Generics       │              │      ✓       │");
        System.out.println("│ Array grandi               │      ✓       │              │");
        System.out.println("│ Calcoli intensivi          │      ✓       │              │");
        System.out.println("│ Serializzazione JSON       │              │      ✓       │");
        System.out.println("└────────────────────────────┴──────────────┴──────────────┘\n");
        
        printSubSection("💡 REGOLA D'ORO FINALE");
        
        System.out.println("✓ Preferisci PRIMITIVI per default (più semplici, più veloci)");
        System.out.println("✓ Usa WRAPPER quando:");
        System.out.println("    - Necessario per il linguaggio (Collections, Generics)");
        System.out.println("    - null ha un significato semantico (\"valore assente\")");
        System.out.println("    - Servono metodi utility delle classi wrapper\n");
        
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
        System.out.println("📦 " + sectionTitle);
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
        System.out.println("  ✓ DEMO COMPLETATA - Hai appreso tutto sui Wrapper Types!");
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
