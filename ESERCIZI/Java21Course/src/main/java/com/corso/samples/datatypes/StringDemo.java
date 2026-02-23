package com.corso.samples.datatypes;

/**
 * Classe demo completa per l'apprendimento del tipo String in Java
 * 
 * String è una delle classi più utilizzate in Java, rappresenta sequenze
 * immutabili di caratteri Unicode (UTF-16).
 * 
 * CARATTERISTICHE FONDAMENTALI:
 * - IMMUTABILE: una volta creata, non può essere modificata
 * - Reference Type: oggetto, non tipo primitivo
 * - String Pool: ottimizzazione JVM per letterali
 * - Thread-safe: grazie all'immutabilità
 * 
 * @author Java 21 Course
 * @version 1.0
 */
public class StringDemo {

    /**
     * Metodo principale che esegue tutte le demo su String
     * Questo metodo orchestra l'esecuzione sequenziale di tutte le sezioni
     */
    public static void run() {
        printHeader("DEMO COMPLETA: STRING IN JAVA");
        
        // Sezione 1: Introduzione e caratteristiche
        demoIntroduction();
        
        // Sezione 2: Creazione di String
        demoStringCreation();
        
        // Sezione 3: String Pool e Internamento
        demoStringPool();
        
        // Sezione 4: Concatenazione
        demoConcatenation();
        
        // Sezione 5: Confronti e uguaglianza
        demoComparison();
        
        // Sezione 6: Metodi di ricerca
        demoSearchMethods();
        
        // Sezione 7: Metodi di estrazione
        demoExtractionMethods();
        
        // Sezione 8: Metodi di modifica
        demoModificationMethods();
        
        // Sezione 9: Split e Join
        demoSplitJoin();
        
        // Sezione 10: Formatting
        demoFormatting();
        
        // Sezione 11: Text Blocks (Java 15+)
        demoTextBlocks();
        
        // Sezione 12: StringBuilder e StringBuffer
        demoStringBuilderBuffer();
        
        // Sezione 13: Best Practices
        demoBestPractices();
        
        printFooter();
    }

    /**
     * SEZIONE 1: Introduzione e Caratteristiche
     * 
     * Spiega cosa sono le String, perché sono immutabili e le caratteristiche fondamentali
     */
    private static void demoIntroduction() {
        printSection("1. INTRODUZIONE: COS'È UNA STRING?");
        
        System.out.println("String è una classe in Java che rappresenta sequenze di caratteri.");
        System.out.println("È uno dei tipi più utilizzati, ma ha caratteristiche uniche.\n");
        
        printSubSection("📝 Caratteristiche Fondamentali");
        
        System.out.println("1. IMMUTABILE (Immutable):");
        System.out.println("   • Una volta creata, NON può essere modificata");
        System.out.println("   • Ogni \"modifica\" crea una NUOVA String");
        System.out.println("   • Thread-safe per natura\n");
        
        System.out.println("2. REFERENCE TYPE:");
        System.out.println("   • È una classe (java.lang.String)");
        System.out.println("   • Non è un tipo primitivo");
        System.out.println("   • Memorizzata nell'heap (con ottimizzazione String Pool)\n");
        
        System.out.println("3. SEQUENCE DI CHAR:");
        System.out.println("   • Rappresenta testo come sequenza di caratteri Unicode (UTF-16)");
        System.out.println("   • Ogni carattere è un char (16-bit)\n");
        
        printSubSection("💡 Perché String è Immutabile?");
        
        System.out.println("Vantaggi dell'immutabilità:");
        System.out.println("  ✓ SICUREZZA: non può essere modificata dopo la creazione");
        System.out.println("  ✓ THREAD-SAFE: condivisibile tra thread senza sincronizzazione");
        System.out.println("  ✓ CACHING: String Pool per ottimizzare la memoria");
        System.out.println("  ✓ HASH CODE: può essere calcolato una sola volta e cachato\n");
        
        printSubSection("Dimostrazione Immutabilità");
        
        String original = "Hello";
        System.out.println("String original = \"Hello\";");
        System.out.println("  → original = \"" + original + "\"\n");
        
        String upper = original.toUpperCase();
        System.out.println("String upper = original.toUpperCase();");
        System.out.println("  → upper = \"" + upper + "\"");
        System.out.println("  → original = \"" + original + "\" (IMMUTATA!)\n");
        
        System.out.println("💡 toUpperCase() NON modifica 'original', crea una NUOVA String!\n");
        
        printSubSection("String vs char[]");
        
        System.out.println("┌────────────────┬──────────────────────────────────────────┐");
        System.out.println("│   TIPO         │           CARATTERISTICHE                │");
        System.out.println("├────────────────┼──────────────────────────────────────────┤");
        System.out.println("│ String         │ Immutabile, String Pool, metodi ricchi   │");
        System.out.println("│ char[]         │ Mutabile, nessun pool, array base        │");
        System.out.println("└────────────────┴──────────────────────────────────────────┘\n");
        
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String str = new String(chars);
        
        System.out.println("char[] chars = {'H', 'e', 'l', 'l', 'o'};");
        System.out.println("String str = new String(chars);");
        System.out.println("  → str = \"" + str + "\"\n");
        
        chars[0] = 'J';  // Modifico l'array
        System.out.println("chars[0] = 'J';  // Modifico l'array");
        System.out.println("  → chars = " + new String(chars) + " (modificato)");
        System.out.println("  → str = \"" + str + "\" (invariata, copia indipendente)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 2: Creazione di String
     * 
     * Mostra tutti i modi per creare String in Java
     */
    private static void demoStringCreation() {
        printSection("2. CREAZIONE DI STRING");
        
        printSubSection("Metodo 1: Letterale (String Literal) - PREFERITO");
        
        String s1 = "Hello";
        System.out.println("String s1 = \"Hello\";  // ✓ Preferito (usa String Pool)");
        System.out.println("  → s1 = \"" + s1 + "\"\n");
        
        printSubSection("Metodo 2: Costruttore new String() - EVITARE");
        
        String s2 = new String("Hello");
        System.out.println("String s2 = new String(\"Hello\");  // ✗ Evitare (crea nuovo oggetto)");
        System.out.println("  → s2 = \"" + s2 + "\"");
        System.out.println("  ⚠️ Crea un NUOVO oggetto, NON usa String Pool!\n");
        
        printSubSection("Metodo 3: Da char array");
        
        char[] chars = {'W', 'o', 'r', 'l', 'd'};
        String s3 = new String(chars);
        System.out.println("char[] chars = {'W', 'o', 'r', 'l', 'd'};");
        System.out.println("String s3 = new String(chars);");
        System.out.println("  → s3 = \"" + s3 + "\"\n");
        
        // Da porzione di array
        String s4 = new String(chars, 1, 3);  // offset=1, count=3
        System.out.println("String s4 = new String(chars, 1, 3);  // offset=1, count=3");
        System.out.println("  → s4 = \"" + s4 + "\" (caratteri da indice 1 a 3)\n");
        
        printSubSection("Metodo 4: Da byte array (encoding)");
        
        byte[] bytes = {72, 101, 108, 108, 111};  // "Hello" in ASCII
        String s5 = new String(bytes);
        System.out.println("byte[] bytes = {72, 101, 108, 108, 111};  // ASCII");
        System.out.println("String s5 = new String(bytes);");
        System.out.println("  → s5 = \"" + s5 + "\"\n");
        
        printSubSection("Metodo 5: Concatenazione");
        
        String s6 = "Hello" + " " + "World";
        System.out.println("String s6 = \"Hello\" + \" \" + \"World\";");
        System.out.println("  → s6 = \"" + s6 + "\"\n");
        
        printSubSection("Metodo 6: valueOf - Conversione da Altri Tipi");
        
        String s7 = String.valueOf(123);
        System.out.println("String s7 = String.valueOf(123);");
        System.out.println("  → s7 = \"" + s7 + "\"\n");
        
        String s8 = String.valueOf(true);
        System.out.println("String s8 = String.valueOf(true);");
        System.out.println("  → s8 = \"" + s8 + "\"\n");
        
        String s9 = String.valueOf(3.14);
        System.out.println("String s9 = String.valueOf(3.14);");
        System.out.println("  → s9 = \"" + s9 + "\"\n");
        
        printSubSection("Metodo 7: String Vuota");
        
        String empty1 = "";
        String empty2 = new String();
        System.out.println("String empty1 = \"\";");
        System.out.println("String empty2 = new String();");
        System.out.println("  → empty1.isEmpty() = " + empty1.isEmpty());
        System.out.println("  → empty2.isEmpty() = " + empty2.isEmpty() + "\n");
        
        printSubSection("⚠️ BEST PRACTICE: Usa Letterali!");
        
        System.out.println("✓ PREFERITO:");
        System.out.println("  String s = \"Hello\";  // Usa String Pool, efficiente\n");
        
        System.out.println("✗ EVITA:");
        System.out.println("  String s = new String(\"Hello\");  // Crea nuovo oggetto inutilmente\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 3: String Pool e Internamento
     * 
     * Spiega il meccanismo del String Pool e l'internamento
     */
    private static void demoStringPool() {
        printSection("3. STRING POOL E INTERNAMENTO");
        
        System.out.println("Il String Pool è un'area speciale della memoria (Heap) dove Java");
        System.out.println("memorizza i letterali String per ottimizzare l'uso della memoria.\n");
        
        printSubSection("Come Funziona il String Pool");
        
        System.out.println("Quando scrivi un letterale String, Java:");
        System.out.println("  1. Controlla se esiste già nel String Pool");
        System.out.println("  2. Se esiste, riutilizza quell'istanza");
        System.out.println("  3. Se non esiste, la crea e la aggiunge al pool\n");
        
        printSubSection("Dimostrazione con Letterali");
        
        String a = "Java";
        String b = "Java";
        
        System.out.println("String a = \"Java\";");
        System.out.println("String b = \"Java\";\n");
        
        System.out.println("a == b  →  " + (a == b) + "  ✓ (stesso oggetto dal pool!)");
        System.out.println("a.equals(b)  →  " + a.equals(b) + "  ✓ (stesso valore)\n");
        
        printSubSection("new String() NON Usa il Pool");
        
        String c = new String("Java");
        String d = new String("Java");
        
        System.out.println("String c = new String(\"Java\");");
        System.out.println("String d = new String(\"Java\");\n");
        
        System.out.println("c == d  →  " + (c == d) + "  ✗ (oggetti diversi!)");
        System.out.println("c.equals(d)  →  " + c.equals(d) + "  ✓ (stesso valore)\n");
        
        System.out.println("a == c  →  " + (a == c) + "  ✗ (uno dal pool, uno no)");
        System.out.println("a.equals(c)  →  " + a.equals(c) + "  ✓ (stesso valore)\n");
        
        printSubSection("intern() - Aggiungere al Pool Manualmente");
        
        String e = new String("Java").intern();
        
        System.out.println("String e = new String(\"Java\").intern();\n");
        System.out.println("a == e  →  " + (a == e) + "  ✓ (intern restituisce riferimento dal pool!)");
        System.out.println("  💡 intern() cerca nel pool e ritorna l'istanza esistente\n");
        
        printSubSection("Concatenazione e Pool");
        
        String f = "Ja" + "va";  // Compile-time constant: usa pool
        System.out.println("String f = \"Ja\" + \"va\";  // Compile-time constant");
        System.out.println("a == f  →  " + (a == f) + "  ✓ (ottimizzato dal compilatore)\n");
        
        String prefix = "Ja";
        String g = prefix + "va";  // Runtime concatenation: NON usa pool
        System.out.println("String prefix = \"Ja\";");
        System.out.println("String g = prefix + \"va\";  // Runtime concatenation");
        System.out.println("a == g  →  " + (a == g) + "  ✗ (creato a runtime)\n");
        
        printSubSection("📊 Riepilogo String Pool");
        
        System.out.println("┌─────────────────────────────┬───────────────┬──────────────┐");
        System.out.println("│         CREAZIONE           │  USA POOL?    │  EFFICIENZA  │");
        System.out.println("├─────────────────────────────┼───────────────┼──────────────┤");
        System.out.println("│ \"Hello\"                     │      ✓        │     Alta     │");
        System.out.println("│ new String(\"Hello\")         │      ✗        │     Bassa    │");
        System.out.println("│ new String(\"Hello\").intern()│      ✓        │     Media    │");
        System.out.println("│ \"Hel\" + \"lo\" (compile-time)│      ✓        │     Alta     │");
        System.out.println("│ str1 + str2 (runtime)       │      ✗        │     Bassa    │");
        System.out.println("└─────────────────────────────┴───────────────┴──────────────┘\n");
        
        printSubSection("⚠️ IMPORTANTE: == vs equals()");
        
        System.out.println("✓ USA equals() per confrontare VALORI:");
        System.out.println("  if (str1.equals(str2)) { ... }  // Confronta contenuto\n");
        
        System.out.println("✗ NON usare == per confrontare String:");
        System.out.println("  if (str1 == str2) { ... }  // Confronta RIFERIMENTI (pericoloso!)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 4: Concatenazione
     * 
     * Mostra i vari modi per concatenare String e le loro performance
     */
    private static void demoConcatenation() {
        printSection("4. CONCATENAZIONE DI STRING");
        
        printSubSection("Metodo 1: Operatore + (Semplice)");
        
        String first = "Hello";
        String second = "World";
        String result1 = first + " " + second;
        
        System.out.println("String first = \"Hello\";");
        System.out.println("String second = \"World\";");
        System.out.println("String result = first + \" \" + second;");
        System.out.println("  → result = \"" + result1 + "\"\n");
        
        System.out.println("💡 Compilatore ottimizza internamente usando StringBuilder\n");
        
        printSubSection("Metodo 2: concat() Method");
        
        String result2 = first.concat(" ").concat(second);
        System.out.println("String result = first.concat(\" \").concat(second);");
        System.out.println("  → result = \"" + result2 + "\"\n");
        
        printSubSection("Metodo 3: String.join() - Per Array/Liste");
        
        String[] words = {"Java", "is", "awesome"};
        String joined = String.join(" ", words);
        
        System.out.println("String[] words = {\"Java\", \"is\", \"awesome\"};");
        System.out.println("String joined = String.join(\" \", words);");
        System.out.println("  → joined = \"" + joined + "\"\n");
        
        // Con delimitatore diverso
        String csv = String.join(", ", "apple", "banana", "orange");
        System.out.println("String csv = String.join(\", \", \"apple\", \"banana\", \"orange\");");
        System.out.println("  → csv = \"" + csv + "\"\n");
        
        printSubSection("Metodo 4: StringBuilder (Performance)");
        
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        String result3 = sb.toString();
        
        System.out.println("StringBuilder sb = new StringBuilder();");
        System.out.println("sb.append(\"Hello\").append(\" \").append(\"World\");");
        System.out.println("String result = sb.toString();");
        System.out.println("  → result = \"" + result3 + "\"\n");
        
        printSubSection("⚠️ Concatenazione in Loop - PERFORMANCE CRITICA!");
        
        System.out.println("✗ PESSIMO - Crea migliaia di oggetti String!");
        System.out.println("String result = \"\";");
        System.out.println("for (int i = 0; i < 1000; i++) {");
        System.out.println("    result += i;  // Crea NUOVO oggetto ad ogni iterazione!");
        System.out.println("}\n");
        
        System.out.println("✓ OTTIMO - Usa StringBuilder!");
        System.out.println("StringBuilder sb = new StringBuilder();");
        System.out.println("for (int i = 0; i < 1000; i++) {");
        System.out.println("    sb.append(i);  // Modifica lo stesso oggetto");
        System.out.println("}");
        System.out.println("String result = sb.toString();\n");
        
        printSubSection("💡 Dimostrazione Performance");
        
        // Misura con + in loop (piccolo esempio)
        long start1 = System.nanoTime();
        String slow = "";
        for (int i = 0; i < 100; i++) {
            slow += i;
        }
        long time1 = System.nanoTime() - start1;
        
        // Misura con StringBuilder
        long start2 = System.nanoTime();
        StringBuilder fast = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            fast.append(i);
        }
        String fastResult = fast.toString();
        long time2 = System.nanoTime() - start2;
        
        System.out.println("Concatenazione 100 numeri:");
        System.out.println("  Metodo +           : " + time1 + " ns");
        System.out.println("  StringBuilder      : " + time2 + " ns");
        System.out.println("  Differenza         : ~" + (time1 / Math.max(time2, 1)) + "x più veloce!\n");
        
        printSubSection("📊 Quando Usare Cosa?");
        
        System.out.println("┌──────────────────────┬────────────────────────────────────────┐");
        System.out.println("│     SCENARIO         │           USA                          │");
        System.out.println("├──────────────────────┼────────────────────────────────────────┤");
        System.out.println("│ Concatenazioni       │ Operatore + (semplice e leggibile)    │");
        System.out.println("│ semplici (2-3)       │ \"Hello \" + name + \"!\"                 │");
        System.out.println("├──────────────────────┼────────────────────────────────────────┤");
        System.out.println("│ Unire array/liste    │ String.join()                          │");
        System.out.println("│ con separatore       │ String.join(\", \", array)               │");
        System.out.println("├──────────────────────┼────────────────────────────────────────┤");
        System.out.println("│ Loop o molte         │ StringBuilder                          │");
        System.out.println("│ concatenazioni       │ (mutabile, efficiente)                 │");
        System.out.println("├──────────────────────┼────────────────────────────────────────┤");
        System.out.println("│ Multi-thread         │ StringBuffer                           │");
        System.out.println("│ (sincronizzato)      │ (thread-safe ma più lento)             │");
        System.out.println("└──────────────────────┴────────────────────────────────────────┘\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 5: Confronti e Uguaglianza
     * 
     * Mostra come confrontare String correttamente
     */
    private static void demoComparison() {
        printSection("5. CONFRONTI E UGUAGLIANZA");
        
        printSubSection("⚠️ ERRORE COMUNE: Usare == per Confrontare String");
        
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        
        System.out.println("String s1 = \"Java\";");
        System.out.println("String s2 = \"Java\";");
        System.out.println("String s3 = new String(\"Java\");\n");
        
        System.out.println("s1 == s2  →  " + (s1 == s2) + "  (stesso riferimento - pool)");
        System.out.println("s1 == s3  →  " + (s1 == s3) + "  (riferimenti diversi!)");
        System.out.println("\n⚠️ == confronta RIFERIMENTI, NON valori!\n");
        
        printSubSection("✓ CORRETTO: Usare equals()");
        
        System.out.println("s1.equals(s2)  →  " + s1.equals(s2) + "  ✓ (stesso valore)");
        System.out.println("s1.equals(s3)  →  " + s1.equals(s3) + "  ✓ (stesso valore)\n");
        
        printSubSection("equalsIgnoreCase() - Ignora Maiuscole/Minuscole");
        
        String lower = "java";
        String upper = "JAVA";
        String mixed = "JaVa";
        
        System.out.println("String lower = \"java\";");
        System.out.println("String upper = \"JAVA\";");
        System.out.println("String mixed = \"JaVa\";\n");
        
        System.out.println("lower.equals(upper)            →  " + lower.equals(upper) + "  (case-sensitive)");
        System.out.println("lower.equalsIgnoreCase(upper)  →  " + lower.equalsIgnoreCase(upper) + "  ✓ (ignora case)");
        System.out.println("mixed.equalsIgnoreCase(upper)  →  " + mixed.equalsIgnoreCase(upper) + "  ✓\n");
        
        printSubSection("compareTo() - Ordine Lessicografico");
        
        String a = "Apple";
        String b = "Banana";
        String c = "Apple";
        
        System.out.println("String a = \"Apple\";");
        System.out.println("String b = \"Banana\";");
        System.out.println("String c = \"Apple\";\n");
        
        int cmp1 = a.compareTo(b);
        System.out.println("a.compareTo(b)  →  " + cmp1 + "  (negativo: a < b alfabeticamente)");
        
        int cmp2 = b.compareTo(a);
        System.out.println("b.compareTo(a)  →  " + cmp2 + "  (positivo: b > a)");
        
        int cmp3 = a.compareTo(c);
        System.out.println("a.compareTo(c)  →  " + cmp3 + "  (zero: a == c)\n");
        
        printSubSection("compareToIgnoreCase()");
        
        String x = "apple";
        String y = "APPLE";
        
        System.out.println("String x = \"apple\";");
        System.out.println("String y = \"APPLE\";\n");
        
        System.out.println("x.compareTo(y)            →  " + x.compareTo(y) + "  (diversi per case)");
        System.out.println("x.compareToIgnoreCase(y)  →  " + x.compareToIgnoreCase(y) + "  (uguali ignorando case)\n");
        
        printSubSection("contentEquals() - Confronto con CharSequence");
        
        String str = "Hello";
        StringBuilder sbuild = new StringBuilder("Hello");
        StringBuffer sbuff = new StringBuffer("Hello");
        
        System.out.println("String str = \"Hello\";");
        System.out.println("StringBuilder sbuild = new StringBuilder(\"Hello\");");
        System.out.println("StringBuffer sbuff = new StringBuffer(\"Hello\");\n");
        
        System.out.println("str.contentEquals(sbuild)  →  " + str.contentEquals(sbuild));
        System.out.println("str.contentEquals(sbuff)   →  " + str.contentEquals(sbuff) + "\n");
        
        printSubSection("📊 Riepilogo Metodi di Confronto");
        
        System.out.println("┌─────────────────────────┬──────────────────────────────────────┐");
        System.out.println("│       METODO            │           DESCRIZIONE                │");
        System.out.println("├─────────────────────────┼──────────────────────────────────────┤");
        System.out.println("│ ==                      │ Confronta riferimenti (✗ evitare)    │");
        System.out.println("│ equals()                │ Confronta valori (✓ usa questo)      │");
        System.out.println("│ equalsIgnoreCase()      │ Confronta ignorando case             │");
        System.out.println("│ compareTo()             │ Ordine lessicografico (-1, 0, 1)     │");
        System.out.println("│ compareToIgnoreCase()   │ compareTo ignorando case             │");
        System.out.println("│ contentEquals()         │ Confronta con CharSequence           │");
        System.out.println("└─────────────────────────┴──────────────────────────────────────┘\n");
        
        printSubSection("⚠️ Null Safety");
        
        String nullStr = null;
        String validStr = "Hello";
        
        System.out.println("String nullStr = null;");
        System.out.println("String validStr = \"Hello\";\n");
        
        System.out.println("// ✗ NullPointerException!");
        System.out.println("// nullStr.equals(validStr);  → Crash!\n");
        
        System.out.println("// ✓ Sicuro");
        System.out.println("validStr.equals(nullStr)  →  " + validStr.equals(nullStr) + "  (sicuro, ritorna false)\n");
        
        System.out.println("💡 BEST PRACTICE: Metti il letterale PRIMA:");
        System.out.println("  \"Hello\".equals(userInput)  // Sicuro anche se userInput è null\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 6: Metodi di Ricerca
     * 
     * Mostra i metodi per cercare caratteri e sottostringhe
     */
    private static void demoSearchMethods() {
        printSection("6. METODI DI RICERCA");
        
        String text = "Java Programming Language";
        System.out.println("String text = \"" + text + "\";\n");
        
        printSubSection("indexOf() - Trova Prima Occorrenza");
        
        int index1 = text.indexOf('a');
        System.out.println("text.indexOf('a')  →  " + index1 + "  (prima 'a' all'indice 1)\n");
        
        int index2 = text.indexOf("Programming");
        System.out.println("text.indexOf(\"Programming\")  →  " + index2 + "  (inizia all'indice 5)\n");
        
        int index3 = text.indexOf('a', 2);  // Cerca da indice 2
        System.out.println("text.indexOf('a', 2)  →  " + index3 + "  (prima 'a' dopo indice 2)\n");
        
        int notFound = text.indexOf('z');
        System.out.println("text.indexOf('z')  →  " + notFound + "  (non trovato = -1)\n");
        
        printSubSection("lastIndexOf() - Trova Ultima Occorrenza");
        
        int last1 = text.lastIndexOf('a');
        System.out.println("text.lastIndexOf('a')  →  " + last1 + "  (ultima 'a')\n");
        
        int last2 = text.lastIndexOf("a", 10);  // Cerca indietro da indice 10
        System.out.println("text.lastIndexOf('a', 10)  →  " + last2 + "  (ultima 'a' prima di ind. 10)\n");
        
        printSubSection("contains() - Verifica Presenza");
        
        boolean has1 = text.contains("Programming");
        System.out.println("text.contains(\"Programming\")  →  " + has1 + "\n");
        
        boolean has2 = text.contains("Python");
        System.out.println("text.contains(\"Python\")  →  " + has2 + "\n");
        
        System.out.println("💡 contains() equivale a: indexOf(str) >= 0\n");
        
        printSubSection("startsWith() e endsWith()");
        
        System.out.println("text.startsWith(\"Java\")      →  " + text.startsWith("Java"));
        System.out.println("text.startsWith(\"Programming\")→  " + text.startsWith("Programming") + "\n");
        
        System.out.println("text.endsWith(\"Language\")    →  " + text.endsWith("Language"));
        System.out.println("text.endsWith(\"Java\")        →  " + text.endsWith("Java") + "\n");
        
        // startsWith con offset
        System.out.println("text.startsWith(\"Programming\", 5)  →  " + text.startsWith("Programming", 5));
        System.out.println("  (verifica se inizia con 'Programming' all'indice 5)\n");
        
        printSubSection("matches() - Regular Expression");
        
        String email = "user@example.com";
        boolean validEmail = email.matches(".*@.*\\..*");
        
        System.out.println("String email = \"user@example.com\";");
        System.out.println("email.matches(\".*@.*\\\\..*\")  →  " + validEmail);
        System.out.println("  (verifica pattern email semplice)\n");
        
        String digits = "12345";
        boolean allDigits = digits.matches("\\d+");
        
        System.out.println("String digits = \"12345\";");
        System.out.println("digits.matches(\"\\\\d+\")  →  " + allDigits);
        System.out.println("  (verifica se sono solo cifre)\n");
        
        printSubSection("💡 Esempi Pratici");
        
        String url = "https://www.example.com/page";
        
        System.out.println("String url = \"" + url + "\";\n");
        
        if (url.startsWith("https://")) {
            System.out.println("✓ URL sicuro (HTTPS)\n");
        }
        
        if (url.contains("example")) {
            System.out.println("✓ URL contiene 'example'\n");
        }
        
        if (url.endsWith(".com")) {
            System.out.println("✗ Non termina con '.com', termina con: '");
        } else if (url.contains(".com")) {
            System.out.println("✓ Contiene dominio .com\n");
        }
        
        waitForEnter();
    }

    /**
     * SEZIONE 7: Metodi di Estrazione
     * 
     * Mostra come estrarre parti di una String
     */
    private static void demoExtractionMethods() {
        printSection("7. METODI DI ESTRAZIONE");
        
        String text = "Java Programming";
        System.out.println("String text = \"" + text + "\";\n");
        
        printSubSection("charAt() - Carattere a Indice Specifico");
        
        char ch1 = text.charAt(0);
        char ch2 = text.charAt(5);
        
        System.out.println("text.charAt(0)  →  '" + ch1 + "'  (primo carattere)");
        System.out.println("text.charAt(5)  →  '" + ch2 + "'\n");
        
        printSubSection("⚠️ StringIndexOutOfBoundsException");
        
        System.out.println("// text.charAt(100);  → StringIndexOutOfBoundsException!\n");
        try {
            char invalid = text.charAt(100);
            System.out.println("Char: " + invalid);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("✗ Eccezione: " + e.getClass().getSimpleName() + "\n");
        }
        
        printSubSection("substring() - Estrae Sottostringa");
        
        String sub1 = text.substring(5);  // Da indice 5 alla fine
        System.out.println("text.substring(5)      →  \"" + sub1 + "\"  (da ind. 5 alla fine)\n");
        
        String sub2 = text.substring(0, 4);  // Da indice 0 a 4 (escluso)
        System.out.println("text.substring(0, 4)   →  \"" + sub2 + "\"  (da 0 a 4, 4 escluso)\n");
        
        String sub3 = text.substring(5, 12);
        System.out.println("text.substring(5, 12)  →  \"" + sub3 + "\"\n");
        
        System.out.println("💡 substring(begin, end): include begin, ESCLUDE end\n");
        
        printSubSection("toCharArray() - Converte in Array di Char");
        
        char[] chars = text.toCharArray();
        System.out.println("char[] chars = text.toCharArray();");
        System.out.println("  → chars.length = " + chars.length);
        System.out.print("  → chars = [");
        for (int i = 0; i < Math.min(chars.length, 10); i++) {
            System.out.print("'" + chars[i] + "'");
            if (i < Math.min(chars.length, 10) - 1) System.out.print(", ");
        }
        System.out.println("...]\n");
        
        printSubSection("getBytes() - Converte in Array di Byte");
        
        byte[] bytes = text.getBytes();
        System.out.println("byte[] bytes = text.getBytes();");
        System.out.println("  → bytes.length = " + bytes.length);
        System.out.println("  → bytes[0] = " + bytes[0] + " (char 'J' in ASCII)\n");
        
        printSubSection("codePointAt() - Codice Unicode");
        
        String emoji = "Hello 😀 World";
        int codePoint = emoji.codePointAt(6);
        
        System.out.println("String emoji = \"Hello 😀 World\";");
        System.out.println("int codePoint = emoji.codePointAt(6);");
        System.out.println("  → codePoint = " + codePoint + " (U+" + Integer.toHexString(codePoint).toUpperCase() + ")\n");
        
        printSubSection("💡 Esempio Pratico: Estrazione Nome File");
        
        String filePath = "C:/Users/Documents/report.pdf";
        int lastSlash = filePath.lastIndexOf('/');
        String fileName = filePath.substring(lastSlash + 1);
        
        System.out.println("String filePath = \"" + filePath + "\";");
        System.out.println("int lastSlash = filePath.lastIndexOf('/');");
        System.out.println("String fileName = filePath.substring(lastSlash + 1);");
        System.out.println("  → fileName = \"" + fileName + "\"\n");
        
        // Estrazione estensione
        int lastDot = fileName.lastIndexOf('.');
        String extension = fileName.substring(lastDot + 1);
        
        System.out.println("String extension = fileName.substring(fileName.lastIndexOf('.') + 1);");
        System.out.println("  → extension = \"" + extension + "\"\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 8: Metodi di Modifica
     * 
     * Mostra i metodi che restituiscono versioni modificate della String
     */
    private static void demoModificationMethods() {
        printSection("8. METODI DI MODIFICA (creano NUOVE String!)");
        
        System.out.println("⚠️ RICORDA: String è IMMUTABILE!");
        System.out.println("Questi metodi NON modificano la String originale, creano una NUOVA String.\n");
        
        printSubSection("toLowerCase() e toUpperCase()");
        
        String original = "Java Programming";
        String lower = original.toLowerCase();
        String upper = original.toUpperCase();
        
        System.out.println("String original = \"" + original + "\";");
        System.out.println("String lower = original.toLowerCase();");
        System.out.println("  → lower = \"" + lower + "\"");
        System.out.println("String upper = original.toUpperCase();");
        System.out.println("  → upper = \"" + upper + "\"");
        System.out.println("  → original = \"" + original + "\" (IMMUTATA!)\n");
        
        printSubSection("trim() - Rimuove Spazi all'Inizio e Fine");
        
        String padded = "   Hello World   ";
        String trimmed = padded.trim();
        
        System.out.println("String padded = \"   Hello World   \";");
        System.out.println("String trimmed = padded.trim();");
        System.out.println("  → trimmed = \"" + trimmed + "\"");
        System.out.println("  → lunghezza: " + padded.length() + " → " + trimmed.length() + "\n");
        
        printSubSection("strip() - Rimuove Whitespace Unicode (Java 11+)");
        
        String unicode = " \u2000 Hello \u2000 ";  // Unicode space
        String stripped = unicode.strip();
        
        System.out.println("String unicode = \" \\u2000 Hello \\u2000 \";");
        System.out.println("String stripped = unicode.strip();");
        System.out.println("  → stripped = \"" + stripped + "\"");
        System.out.println("\n💡 strip() rimuove TUTTI i whitespace Unicode, trim() solo spazi standard\n");
        
        // stripLeading e stripTrailing
        String leading = unicode.stripLeading();
        String trailing = unicode.stripTrailing();
        
        System.out.println("unicode.stripLeading()  → \"" + leading + "\"");
        System.out.println("unicode.stripTrailing() → \"" + trailing + "\"\n");
        
        printSubSection("replace() - Sostituisce Caratteri o Sequenze");
        
        String text = "Java is great. Java is powerful.";
        String replaced1 = text.replace('a', 'A');
        
        System.out.println("String text = \"" + text + "\";");
        System.out.println("text.replace('a', 'A')  →  \"" + replaced1 + "\"\n");
        
        String replaced2 = text.replace("Java", "Python");
        System.out.println("text.replace(\"Java\", \"Python\")  →  \"" + replaced2 + "\"\n");
        
        printSubSection("replaceFirst() e replaceAll() - Con Regex");
        
        String replFirst = text.replaceFirst("Java", "Python");
        System.out.println("text.replaceFirst(\"Java\", \"Python\")  →  \"" + replFirst + "\"");
        System.out.println("  (sostituisce solo la PRIMA occorrenza)\n");
        
        String replAll = text.replaceAll("Java", "Python");
        System.out.println("text.replaceAll(\"Java\", \"Python\")  →  \"" + replAll + "\"");
        System.out.println("  (sostituisce TUTTE le occorrenze)\n");
        
        // Con regex
        String digits = "Price: 123 dollars, Tax: 45 dollars";
        String noDigits = digits.replaceAll("\\d+", "XX");
        
        System.out.println("String digits = \"" + digits + "\";");
        System.out.println("digits.replaceAll(\"\\\\d+\", \"XX\")  →  \"" + noDigits + "\"");
        System.out.println("  (sostituisce tutti i numeri con XX)\n");
        
        printSubSection("repeat() - Ripete String (Java 11+)");
        
        String star = "*".repeat(10);
        System.out.println("\"*\".repeat(10)  →  \"" + star + "\"\n");
        
        String line = "-=".repeat(5);
        System.out.println("\"-=\".repeat(5)  →  \"" + line + "\"\n");
        
        printSubSection("concat() - Concatena");
        
        String hello = "Hello";
        String world = " World";
        String greeting = hello.concat(world);
        
        System.out.println("String hello = \"Hello\";");
        System.out.println("String world = \" World\";");
        System.out.println("String greeting = hello.concat(world);");
        System.out.println("  → greeting = \"" + greeting + "\"\n");
        
        printSubSection("indent() - Indenta Testo (Java 12+)");
        
        String multiline = "Line 1\nLine 2\nLine 3";
        String indented = multiline.indent(4);
        
        System.out.println("String multiline = \"Line 1\\nLine 2\\nLine 3\";");
        System.out.println("String indented = multiline.indent(4);");
        System.out.println("\nRisultato:");
        System.out.println(indented);
        
        waitForEnter();
    }

    /**
     * SEZIONE 9: Split e Join
     * 
     * Mostra come dividere e unire String
     */
    private static void demoSplitJoin() {
        printSection("9. SPLIT E JOIN");
        
        printSubSection("split() - Divide String in Array");
        
        String csv = "apple,banana,orange,grape";
        String[] fruits = csv.split(",");
        
        System.out.println("String csv = \"" + csv + "\";");
        System.out.println("String[] fruits = csv.split(\",\");\n");
        System.out.println("Risultato:");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("  fruits[" + i + "] = \"" + fruits[i] + "\"");
        }
        System.out.println();
        
        printSubSection("split() con Regex");
        
        String mixed = "one,two;three:four|five";
        String[] parts = mixed.split("[,;:|]");  // Split su multipli delimitatori
        
        System.out.println("String mixed = \"" + mixed + "\";");
        System.out.println("String[] parts = mixed.split(\"[,;:|]\");  // Regex\n");
        System.out.println("Risultato:");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("  parts[" + i + "] = \"" + parts[i] + "\"");
        }
        System.out.println();
        
        printSubSection("split() con Limit");
        
        String data = "field1:field2:field3:field4";
        String[] limited = data.split(":", 2);  // Limita a 2 parti
        
        System.out.println("String data = \"" + data + "\";");
        System.out.println("String[] limited = data.split(\":\", 2);  // Limita a 2\n");
        System.out.println("Risultato:");
        for (int i = 0; i < limited.length; i++) {
            System.out.println("  limited[" + i + "] = \"" + limited[i] + "\"");
        }
        System.out.println();
        
        printSubSection("String.join() - Unisce Array/Lista");
        
        String[] words = {"Java", "is", "awesome"};
        String sentence = String.join(" ", words);
        
        System.out.println("String[] words = {\"Java\", \"is\", \"awesome\"};");
        System.out.println("String sentence = String.join(\" \", words);");
        System.out.println("  → sentence = \"" + sentence + "\"\n");
        
        // Con delimitatore diverso
        String csvOut = String.join(", ", words);
        System.out.println("String.join(\", \", words)  →  \"" + csvOut + "\"\n");
        
        // Con varargs
        String path = String.join("/", "home", "user", "documents", "file.txt");
        System.out.println("String.join(\"/\", \"home\", \"user\", \"documents\", \"file.txt\")");
        System.out.println("  → \"" + path + "\"\n");
        
        printSubSection("💡 Esempio Pratico: CSV Processing");
        
        System.out.println("Parsing e ricostruzione di dati CSV:\n");
        
        String csvLine = "John,Doe,30,Engineer";
        System.out.println("Input CSV: \"" + csvLine + "\"\n");
        
        // Parse
        String[] fields = csvLine.split(",");
        System.out.println("Parse:");
        System.out.println("  Nome: " + fields[0]);
        System.out.println("  Cognome: " + fields[1]);
        System.out.println("  Età: " + fields[2]);
        System.out.println("  Professione: " + fields[3] + "\n");
        
        // Modifica
        fields[2] = "31";  // Incrementa età
        
        // Ricostruisci
        String updatedCsv = String.join(",", fields);
        System.out.println("Output CSV: \"" + updatedCsv + "\"\n");
        
        printSubSection("⚠️ Attenzione agli Spazi");
        
        String spacedCsv = "apple, banana, orange";
        String[] spacedFruits = spacedCsv.split(",");
        
        System.out.println("String spacedCsv = \"apple, banana, orange\";");
        System.out.println("String[] spacedFruits = spacedCsv.split(\",\");\n");
        System.out.println("Risultato (con spazi!):");
        for (int i = 0; i < spacedFruits.length; i++) {
            System.out.println("  [" + i + "] = \"" + spacedFruits[i] + "\"");
        }
        System.out.println("\n💡 Usa trim() su ogni elemento se necessario:\n");
        
        for (int i = 0; i < spacedFruits.length; i++) {
            spacedFruits[i] = spacedFruits[i].trim();
            System.out.println("  [" + i + "] = \"" + spacedFruits[i] + "\"");
        }
        System.out.println();
        
        waitForEnter();
    }

    /**
     * SEZIONE 10: Formatting
     * 
     * Mostra come formattare String con String.format() e formatted()
     */
    private static void demoFormatting() {
        printSection("10. FORMATTING");
        
        printSubSection("String.format() - Formattazione Avanzata");
        
        String name = "Mario";
        int age = 30;
        double salary = 45000.50;
        
        String formatted1 = String.format("Nome: %s, Età: %d, Stipendio: %.2f€", name, age, salary);
        
        System.out.println("String name = \"Mario\";");
        System.out.println("int age = 30;");
        System.out.println("double salary = 45000.50;\n");
        System.out.println("String.format(\"Nome: %s, Età: %d, Stipendio: %.2f€\", name, age, salary);");
        System.out.println("  → \"" + formatted1 + "\"\n");
        
        printSubSection("Format Specifiers");
        
        System.out.println("┌──────────┬──────────────────────────────────────────────┐");
        System.out.println("│ Specifier│              Descrizione                     │");
        System.out.println("├──────────┼──────────────────────────────────────────────┤");
        System.out.println("│ %s       │ String                                       │");
        System.out.println("│ %d       │ Decimale intero                              │");
        System.out.println("│ %f       │ Floating-point                               │");
        System.out.println("│ %.2f     │ Floating-point con 2 decimali                │");
        System.out.println("│ %n       │ Newline (platform independent)               │");
        System.out.println("│ %x       │ Esadecimale                                  │");
        System.out.println("│ %o       │ Ottale                                       │");
        System.out.println("│ %e       │ Notazione scientifica                        │");
        System.out.println("│ %b       │ Boolean                                      │");
        System.out.println("│ %c       │ Character                                    │");
        System.out.println("└──────────┴──────────────────────────────────────────────┘\n");
        
        printSubSection("Esempi di Format Specifiers");
        
        int num = 255;
        System.out.println("int num = 255;\n");
        System.out.println("String.format(\"Decimale: %d\", num)       → \"" + String.format("Decimale: %d", num) + "\"");
        System.out.println("String.format(\"Hex: %x\", num)            → \"" + String.format("Hex: %x", num) + "\"");
        System.out.println("String.format(\"Hex uppercase: %X\", num) → \"" + String.format("Hex uppercase: %X", num) + "\"");
        System.out.println("String.format(\"Ottale: %o\", num)        → \"" + String.format("Ottale: %o", num) + "\"\n");
        
        double pi = Math.PI;
        System.out.println("double pi = Math.PI;\n");
        System.out.println("String.format(\"Pi: %f\", pi)        → \"" + String.format("Pi: %f", pi) + "\"");
        System.out.println("String.format(\"Pi: %.2f\", pi)      → \"" + String.format("Pi: %.2f", pi) + "\"");
        System.out.println("String.format(\"Pi: %.4f\", pi)      → \"" + String.format("Pi: %.4f", pi) + "\"");
        System.out.println("String.format(\"Pi: %e\", pi)        → \"" + String.format("Pi: %e", pi) + "\"\n");
        
        printSubSection("Width e Padding");
        
        System.out.println("String.format(\"|%10s|\", \"Hello\")    → \"" + String.format("|%10s|", "Hello") + "\"");
        System.out.println("String.format(\"|%-10s|\", \"Hello\")   → \"" + String.format("|%-10s|", "Hello") + "\"");
        System.out.println("String.format(\"|%10d|\", 42)         → \"" + String.format("|%10d|", 42) + "\"");
        System.out.println("String.format(\"|%010d|\", 42)        → \"" + String.format("|%010d|", 42) + "\"\n");
        
        printSubSection("formatted() - Metodo di Istanza (Java 15+)");
        
        String template = "Nome: %s, Età: %d";
        String result = template.formatted("Luigi", 25);
        
        System.out.println("String template = \"Nome: %s, Età: %d\";");
        System.out.println("String result = template.formatted(\"Luigi\", 25);");
        System.out.println("  → \"" + result + "\"\n");
        
        System.out.println("💡 formatted() è equivalente a String.format() ma più leggibile\n");
        
        printSubSection("💡 Esempio Pratico: Tabella Formattata");
        
        System.out.println("Creazione di una tabella formattata:\n");
        
        System.out.println(String.format("%-15s %-10s %10s", "Prodotto", "Quantità", "Prezzo"));
        System.out.println("-".repeat(40));
        System.out.println(String.format("%-15s %-10d %10.2f€", "Laptop", 5, 899.99));
        System.out.println(String.format("%-15s %-10d %10.2f€", "Mouse", 20, 15.50));
        System.out.println(String.format("%-15s %-10d %10.2f€", "Tastiera", 10, 45.00));
        System.out.println();
        
        waitForEnter();
    }

    /**
     * SEZIONE 11: Text Blocks (Java 15+)
     * 
     * Mostra l'uso dei Text Blocks introdotti in Java 15
     */
    private static void demoTextBlocks() {
        printSection("11. TEXT BLOCKS (Java 15+)");
        
        System.out.println("I Text Blocks semplificano la creazione di stringhe multilinea.\n");
        
        printSubSection("Metodo Tradizionale (Prima di Java 15)");
        
        String oldWay = "{\n" +
                        "  \"name\": \"John\",\n" +
                        "  \"age\": 30,\n" +
                        "  \"city\": \"New York\"\n" +
                        "}";
        
        System.out.println("String json = \"{\\n\" +");
        System.out.println("              \"  \\\"name\\\": \\\"John\\\",\\n\" +");
        System.out.println("              \"  \\\"age\\\": 30,\\n\" +");
        System.out.println("              \"  \\\"city\\\": \\\"New York\\\"\\n\" +");
        System.out.println("              \"}\";");
        System.out.println("\n✗ Leggibilità scarsa, molte escape sequences\n");
        
        printSubSection("✓ Con Text Blocks (Java 15+)");
        
        String textBlock = """
                {
                  "name": "John",
                  "age": 30,
                  "city": "New York"
                }
                """;
        
        System.out.println("String json = \"\"\"");
        System.out.println("        {");
        System.out.println("          \"name\": \"John\",");
        System.out.println("          \"age\": 30,");
        System.out.println("          \"city\": \"New York\"");
        System.out.println("        }");
        System.out.println("        \"\"\";");
        System.out.println("\n✓ Molto più leggibile!\n");
        
        System.out.println("Risultato:");
        System.out.println(textBlock);
        
        printSubSection("Indentazione Automatica");
        
        System.out.println("Text blocks rimuovono automaticamente l'indentazione comune:\n");
        
        String indented = """
                    Line 1
                    Line 2
                        Line 3 (indentata)
                    Line 4
                """;
        
        System.out.println("Codice con indentazione grande:");
        System.out.println("String s = \"\"\"");
        System.out.println("            Line 1");
        System.out.println("            Line 2");
        System.out.println("                Line 3 (indentata)");
        System.out.println("            Line 4");
        System.out.println("        \"\"\";");
        System.out.println("\nRisultato (indentazione common rimossa):");
        System.out.println(indented);
        
        printSubSection("Escape Sequences nei Text Blocks");
        
        String withEscapes = """
                Line 1
                Line 2 with "quotes"
                Line 3 with \ttab
                Line 4 with \\ backslash
                """;
        
        System.out.println("Le escape sequences funzionano normalmente:");
        System.out.println(withEscapes);
        
        printSubSection("Interpolazione con formatted()");
        
        String name = "Alice";
        int score = 95;
        
        String report = """
                Student Report
                --------------
                Name: %s
                Score: %d/100
                Status: %s
                """.formatted(name, score, score >= 60 ? "PASS" : "FAIL");
        
        System.out.println("Text block con formatted():");
        System.out.println(report);
        
        printSubSection("💡 Casi d'Uso Comuni");
        
        System.out.println("Text blocks sono ideali per:");
        System.out.println("  ✓ JSON, XML, HTML");
        System.out.println("  ✓ Query SQL");
        System.out.println("  ✓ Template di testo");
        System.out.println("  ✓ Messaggi multilinea\n");
        
        String sql = """
                SELECT id, name, email
                FROM users
                WHERE age > 18
                  AND active = true
                ORDER BY name
                """;
        
        System.out.println("Esempio SQL:");
        System.out.println(sql);
        
        waitForEnter();
    }

    /**
     * SEZIONE 12: StringBuilder e StringBuffer
     * 
     * Mostra quando e come usare StringBuilder e StringBuffer per performance
     */
    private static void demoStringBuilderBuffer() {
        printSection("12. STRINGBUILDER E STRINGBUFFER");
        
        System.out.println("StringBuilder e StringBuffer sono classi MUTABILI per costruire String.\n");
        
        printSubSection("Il Problema con String in Loop");
        
        System.out.println("✗ PESSIMO - Concatenazione String in loop:");
        System.out.println("String result = \"\";");
        System.out.println("for (int i = 0; i < 1000; i++) {");
        System.out.println("    result += i;  // Crea 1000 oggetti String!");
        System.out.println("}");
        System.out.println("\nProblema: ogni += crea un NUOVO oggetto String → garbage collection intenso\n");
        
        printSubSection("✓ Soluzione: StringBuilder");
        
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        String result = sb.toString();
        
        System.out.println("StringBuilder sb = new StringBuilder();");
        System.out.println("sb.append(\"Hello\");");
        System.out.println("sb.append(\" \");");
        System.out.println("sb.append(\"World\");");
        System.out.println("String result = sb.toString();");
        System.out.println("  → result = \"" + result + "\"\n");
        
        printSubSection("Metodi Principali di StringBuilder");
        
        StringBuilder demo = new StringBuilder("Java");
        
        System.out.println("StringBuilder demo = new StringBuilder(\"Java\");\n");
        
        demo.append(" Programming");
        System.out.println("demo.append(\" Programming\")  → \"" + demo + "\"");
        
        demo.insert(4, " 21");
        System.out.println("demo.insert(4, \" 21\")        → \"" + demo + "\"");
        
        demo.delete(4, 7);
        System.out.println("demo.delete(4, 7)             → \"" + demo + "\"");
        
        demo.reverse();
        System.out.println("demo.reverse()                → \"" + demo + "\"");
        
        demo.reverse();  // Rimetti normale
        System.out.println("demo.reverse()                → \"" + demo + "\" (ripristinato)\n");
        
        printSubSection("Capacità e Performance");
        
        StringBuilder sb2 = new StringBuilder();  // Capacità default: 16
        System.out.println("StringBuilder sb = new StringBuilder();");
        System.out.println("  → capacità iniziale: " + sb2.capacity());
        System.out.println("  → lunghezza: " + sb2.length() + "\n");
        
        sb2.append("This is a longer string");
        System.out.println("Dopo append(\"This is a longer string\"):");
        System.out.println("  → capacità: " + sb2.capacity() + " (espansa automaticamente)");
        System.out.println("  → lunghezza: " + sb2.length() + "\n");
        
        // Con capacità iniziale
        StringBuilder sb3 = new StringBuilder(100);
        System.out.println("StringBuilder sb3 = new StringBuilder(100);");
        System.out.println("  → capacità: " + sb3.capacity() + " (preassegnata)\n");
        
        System.out.println("💡 Preassegnare capacità migliora performance se conosci la dimensione\n");
        
        printSubSection("StringBuilder vs StringBuffer");
        
        System.out.println("┌─────────────────┬──────────────────┬─────────────────────────┐");
        System.out.println("│    CLASSE       │  THREAD-SAFE?    │      PERFORMANCE        │");
        System.out.println("├─────────────────┼──────────────────┼─────────────────────────┤");
        System.out.println("│ StringBuilder   │       ✗          │  Alta (non sincronizzato)│");
        System.out.println("│ StringBuffer    │       ✓          │  Bassa (sincronizzato)   │");
        System.out.println("└─────────────────┴──────────────────┴─────────────────────────┘\n");
        
        System.out.println("✓ USA StringBuilder: nella maggior parte dei casi (single-thread)");
        System.out.println("✓ USA StringBuffer: SOLO se condiviso tra thread\n");
        
        printSubSection("💡 Dimostrazione Performance");
        
        int iterations = 5000;
        
        // String concatenation
        long start1 = System.nanoTime();
        String slow = "";
        for (int i = 0; i < iterations; i++) {
            slow += "x";
        }
        long time1 = System.nanoTime() - start1;
        
        // StringBuilder
        long start2 = System.nanoTime();
        StringBuilder fast = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            fast.append("x");
        }
        String fastResult = fast.toString();
        long time2 = System.nanoTime() - start2;
        
        System.out.println("Concatenazione di " + iterations + " caratteri:\n");
        System.out.println("String +=           : " + (time1 / 1_000_000.0) + " ms");
        System.out.println("StringBuilder       : " + (time2 / 1_000_000.0) + " ms");
        System.out.println("\nStringBuilder è ~" + (time1 / Math.max(time2, 1)) + "x più veloce!\n");
        
        printSubSection("Method Chaining");
        
        String chained = new StringBuilder()
                .append("Java")
                .append(" ")
                .append("21")
                .append(" ")
                .append("Course")
                .toString();
        
        System.out.println("Method chaining (fluent interface):\n");
        System.out.println("String result = new StringBuilder()");
        System.out.println("    .append(\"Java\")");
        System.out.println("    .append(\" \")");
        System.out.println("    .append(\"21\")");
        System.out.println("    .append(\" \")");
        System.out.println("    .append(\"Course\")");
        System.out.println("    .toString();");
        System.out.println("\n  → result = \"" + chained + "\"\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 13: Best Practices
     * 
     * Raccolta di best practices professionali per lavorare con String
     */
    private static void demoBestPractices() {
        printSection("13. BEST PRACTICES");
        
        printSubSection("1. ✓ Usa Letterali, NON new String()");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  String s = \"Hello\";  // Usa String Pool\n");
        
        System.out.println("✗ EVITA:");
        System.out.println("  String s = new String(\"Hello\");  // Crea oggetto inutilmente\n");
        
        printSubSection("2. ✓ Usa equals(), NON ==");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  if (str1.equals(str2)) { ... }  // Confronta valore\n");
        
        System.out.println("✗ EVITA:");
        System.out.println("  if (str1 == str2) { ... }  // Confronta riferimento (pericoloso!)\n");
        
        printSubSection("3. ✓ Letterale Prima per Null Safety");
        
        System.out.println("✓ CORRETTO (sicuro anche se userInput è null):");
        System.out.println("  if (\"admin\".equals(userInput)) { ... }\n");
        
        System.out.println("✗ EVITA (NullPointerException se userInput è null):");
        System.out.println("  if (userInput.equals(\"admin\")) { ... }\n");
        
        printSubSection("4. ✓ StringBuilder in Loop");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  StringBuilder sb = new StringBuilder();");
        System.out.println("  for (int i = 0; i < 1000; i++) {");
        System.out.println("      sb.append(i);");
        System.out.println("  }");
        System.out.println("  String result = sb.toString();\n");
        
        System.out.println("✗ EVITA:");
        System.out.println("  String result = \"\";");
        System.out.println("  for (int i = 0; i < 1000; i++) {");
        System.out.println("      result += i;  // Lento!");
        System.out.println("  }\n");
        
        printSubSection("5. ✓ isEmpty() per Verificare String Vuota");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  if (str.isEmpty()) { ... }");
        System.out.println("  if (str.isBlank()) { ... }  // Java 11+ (include whitespace)\n");
        
        System.out.println("✗ EVITA:");
        System.out.println("  if (str.length() == 0) { ... }  // Meno leggibile");
        System.out.println("  if (str.equals(\"\")) { ... }     // Meno efficiente\n");
        
        printSubSection("6. ✓ Text Blocks per Testo Multilinea");
        
        System.out.println("✓ CORRETTO (Java 15+):");
        System.out.println("  String json = \"\"\"");
        System.out.println("      {");
        System.out.println("        \"name\": \"value\"");
        System.out.println("      }");
        System.out.println("      \"\"\";\n");
        
        System.out.println("✗ EVITA:");
        System.out.println("  String json = \"{\\n\" + \"  \\\"name\\\": \\\"value\\\"\\n\" + \"}\";");
        System.out.println("  // Meno leggibile\n");
        
        printSubSection("7. ✓ String.format() per Formattazione Complessa");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  String msg = String.format(\"User %s has %d points\", name, score);\n");
        
        System.out.println("✗ EVITA:");
        System.out.println("  String msg = \"User \" + name + \" has \" + score + \" points\";");
        System.out.println("  // Meno leggibile con molte variabili\n");
        
        printSubSection("8. ✓ intern() con Attenzione");
        
        System.out.println("⚠️ USA intern() SOLO se:");
        System.out.println("  • Hai MOLTE String duplicate");
        System.out.println("  • Servono confronti == (raro)");
        System.out.println("  • Vuoi risparmiare memoria\n");
        
        System.out.println("✗ NON usare intern() per default:");
        System.out.println("  • String Pool non è garbage collected facilmente");
        System.out.println("  • Può causare memory leak se abusato\n");
        
        printSubSection("9. ✓ Valida Input Utente");
        
        System.out.println("✓ SEMPRE valida input esterni:\n");
        System.out.println("if (userInput == null || userInput.trim().isEmpty()) {");
        System.out.println("    throw new IllegalArgumentException(\"Input vuoto\");");
        System.out.println("}");
        System.out.println("\nif (userInput.length() > 100) {");
        System.out.println("    throw new IllegalArgumentException(\"Input troppo lungo\");");
        System.out.println("}\n");
        
        printSubSection("10. ✓ Evita String Mutabili Simulate");
        
        System.out.println("✗ EVITA (inefficiente e non idiomatico):");
        System.out.println("  String s = \"Hello\";");
        System.out.println("  s = s + \" World\";  // Crea nuova String ogni volta\n");
        
        System.out.println("✓ Se hai bisogno di mutabilità, usa StringBuilder:\n");
        System.out.println("  StringBuilder sb = new StringBuilder(\"Hello\");");
        System.out.println("  sb.append(\" World\");  // Modifica in-place\n");
        
        printSubSection("📝 Checklist Finale");
        
        System.out.println("Prima di lavorare con String, chiedi:");
        System.out.println("  ☑ Sto usando letterali invece di new String()?");
        System.out.println("  ☑ Sto usando equals() invece di ==?");
        System.out.println("  ☑ Ho il letterale prima di variabili (null safety)?");
        System.out.println("  ☑ Sto usando StringBuilder nei loop?");
        System.out.println("  ☑ Sto validando input utente?");
        System.out.println("  ☑ Sto usando isEmpty()/isBlank() invece di length() == 0?");
        System.out.println("  ☑ Per multilinea, uso text blocks (Java 15+)?");
        System.out.println("  ☑ Per formattazione, uso String.format()?");
        System.out.println("  ☑ Evito intern() a meno che necessario?");
        System.out.println("  ☑ Conosco l'immutabilità di String?\n");
        
        printSubSection("💡 Regola d'Oro");
        
        System.out.println("\"String è IMMUTABILE. Se serve mutabilità, usa StringBuilder.\"");
        System.out.println("\"Usa equals() per confrontare valori, MAI ==.\"\n");
        
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
        System.out.println("  ✓ DEMO COMPLETATA - Hai appreso tutto su String in Java!");
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
