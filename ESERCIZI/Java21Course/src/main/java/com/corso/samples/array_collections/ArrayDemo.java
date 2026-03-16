package com.corso.samples.array_collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Classe demo completa per l'apprendimento degli Array in Java
 * 
 * Gli ARRAY sono strutture dati fondamentali in Java:
 * - Collezioni ORDINATE di elementi dello STESSO tipo
 * - Dimensione FISSA (stabilita alla creazione)
 * - Accesso DIRETTO tramite indice (0-based)
 * - Memorizzati in memoria CONTIGUA (efficiente)
 * 
 * CARATTERISTICHE CHIAVE:
 * - Reference type (anche per array di primitivi)
 * - Lunghezza immutabile dopo creazione
 * - Indici da 0 a length-1
 * - ArrayIndexOutOfBoundsException se indice invalido
 * 
 * @author Java 21 Course
 * @version 1.0
 */
public class ArrayDemo {

    /**
     * Metodo principale che esegue tutte le demo sugli Array
     * Questo metodo orchestra l'esecuzione sequenziale di tutte le sezioni
     */
    public static void run() {
        printHeader("DEMO COMPLETA: ARRAY IN JAVA");
        
        // Sezione 1: Introduzione e concetti base
        demoIntroduction();
        
        // Sezione 2: Dichiarazione e inizializzazione
        demoDeclarationInitialization();
        
        // Sezione 3: Array di tipi primitivi
        demoPrimitiveArrays();
        
        // Sezione 4: Array di oggetti
        demoObjectArrays();
        
        // Sezione 5: Array multidimensionali
        demoMultidimensionalArrays();
        
        // Sezione 6: Accesso e modifica elementi
        demoAccessModification();
        
        // Sezione 7: Iterazione su array
        demoIteration();
        
        // Sezione 8: Copia di array
        demoCopyingArrays();
        
        // Sezione 9: Ordinamento
        demoSorting();
        
        // Sezione 10: Ricerca
        demoSearching();
        
        // Sezione 11: Confronto di array
        demoComparison();
        
        // Sezione 12: Conversioni Array ↔ Collection
        demoConversions();
        
        // Sezione 13: Utility Arrays class
        demoArraysUtilities();
        
        // Sezione 14: Best Practices
        demoBestPractices();
        
        printFooter();
    }

    /**
     * SEZIONE 1: Introduzione e Concetti Base
     * 
     * Spiega cosa sono gli array e le loro caratteristiche fondamentali
     */
    private static void demoIntroduction() {
        printSection("1. INTRODUZIONE: COSA SONO GLI ARRAY");
        
        System.out.println("Un ARRAY è una struttura dati che contiene elementi dello stesso tipo.\n");
        
        printSubSection("📊 Caratteristiche Fondamentali");
        
        System.out.println("✓ OMOGENEI: tutti gli elementi sono dello stesso tipo");
        System.out.println("✓ DIMENSIONE FISSA: la lunghezza non può cambiare dopo creazione");
        System.out.println("✓ INDICIZZATI: accesso diretto tramite indice (0-based)");
        System.out.println("✓ CONTIGUI in memoria: elementi memorizzati sequenzialmente");
        System.out.println("✓ REFERENCE TYPE: anche array di primitivi sono oggetti\n");
        
        printSubSection("📋 Sintassi Base");
        
        System.out.println("Dichiarazione:");
        System.out.println("  int[] numbers;           // Raccomandato ([] dopo tipo)");
        System.out.println("  int numbers[];           // Valido ma meno comune\n");
        
        System.out.println("Creazione:");
        System.out.println("  numbers = new int[5];    // Array di 5 interi (inizializzati a 0)\n");
        
        System.out.println("Dichiarazione + Creazione:");
        System.out.println("  int[] numbers = new int[5];\n");
        
        System.out.println("Inizializzazione diretta:");
        System.out.println("  int[] numbers = {10, 20, 30, 40, 50};  // Lunghezza: 5\n");
        
        printSubSection("🔢 Indici (0-based)");
        
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Array: {10, 20, 30, 40, 50}");
        System.out.println("Indici: [0] [1] [2] [3] [4]\n");
        System.out.println("  arr[0] = " + arr[0] + "  (primo elemento)");
        System.out.println("  arr[4] = " + arr[4] + "  (ultimo elemento)");
        System.out.println("  arr.length = " + arr.length + "\n");
        
        printSubSection("⚠️ ArrayIndexOutOfBoundsException");
        
        System.out.println("Accesso a indice invalido causa eccezione:");
        System.out.println("  arr[5]   → ArrayIndexOutOfBoundsException (fuori range)");
        System.out.println("  arr[-1]  → ArrayIndexOutOfBoundsException (indice negativo)\n");
        
        try {
            int value = arr[5];  // Eccezione!
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Eccezione catturata: " + e.getClass().getSimpleName());
            System.out.println("  → Index 5 out of bounds for length 5\n");
        }
        
        printSubSection("💡 Quando Usare Array?");
        
        System.out.println("✓ Dimensione nota e fissa");
        System.out.println("✓ Accesso casuale frequente (O(1))");
        System.out.println("✓ Performance critiche");
        System.out.println("✓ Lavorare con API legacy\n");
        
        System.out.println("✗ Dimensione variabile → usa ArrayList");
        System.out.println("✗ Inserimenti/rimozioni frequenti → usa LinkedList");
        System.out.println("✗ Elementi unici → usa Set\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 2: Dichiarazione e Inizializzazione
     * 
     * Mostra i vari modi per dichiarare e inizializzare array
     */
    private static void demoDeclarationInitialization() {
        printSection("2. DICHIARAZIONE E INIZIALIZZAZIONE");
        
        printSubSection("Dichiarazione");
        
        System.out.println("Sintassi raccomandata ([] dopo tipo):");
        System.out.println("  int[] numbers;");
        System.out.println("  String[] names;");
        System.out.println("  double[] values;\n");
        
        System.out.println("Sintassi alternativa ([] dopo nome variabile):");
        System.out.println("  int numbers[];           // Valido ma meno chiaro");
        System.out.println("  String names[];");
        System.out.println("  double values[];\n");
        
        System.out.println("Dichiarazioni multiple (attenzione!):");
        System.out.println("  int[] a, b, c;           // Tutti array");
        System.out.println("  int a[], b, c;           // Solo 'a' è array, 'b' e 'c' sono int!\n");
        
        printSubSection("Creazione con new");
        
        int[] arr1 = new int[5];
        System.out.println("int[] arr1 = new int[5];");
        System.out.println("  → Crea array di 5 interi inizializzati a 0");
        System.out.println("  → arr1.length = " + arr1.length);
        System.out.println("  → Valori: " + Arrays.toString(arr1) + "\n");
        
        String[] arr2 = new String[3];
        System.out.println("String[] arr2 = new String[3];");
        System.out.println("  → Crea array di 3 String inizializzate a null");
        System.out.println("  → Valori: " + Arrays.toString(arr2) + "\n");
        
        printSubSection("Inizializzazione Diretta (Array Initializer)");
        
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("int[] numbers = {10, 20, 30, 40, 50};");
        System.out.println("  → Lunghezza automaticamente 5");
        System.out.println("  → Valori: " + Arrays.toString(numbers) + "\n");
        
        String[] days = {"Lunedì", "Martedì", "Mercoledì"};
        System.out.println("String[] days = {\"Lunedì\", \"Martedì\", \"Mercoledì\"};");
        System.out.println("  → Lunghezza: " + days.length);
        System.out.println("  → Valori: " + Arrays.toString(days) + "\n");
        
        printSubSection("Inizializzazione Anonima");
        
        System.out.println("Utile per passare array a metodi senza dichiarare variabile:\n");
        System.out.println("  printArray(new int[]{1, 2, 3, 4, 5});");
        printArray(new int[]{1, 2, 3, 4, 5});
        System.out.println();
        
        printSubSection("Valori di Default");
        
        System.out.println("┌──────────────┬──────────────────────────┐");
        System.out.println("│    TIPO      │      VALORE DEFAULT      │");
        System.out.println("├──────────────┼──────────────────────────┤");
        System.out.println("│ byte, short  │ 0                        │");
        System.out.println("│ int, long    │ 0, 0L                    │");
        System.out.println("│ float, double│ 0.0f, 0.0                │");
        System.out.println("│ char         │ '\\u0000' (null char)     │");
        System.out.println("│ boolean      │ false                    │");
        System.out.println("│ Oggetti      │ null                     │");
        System.out.println("└──────────────┴──────────────────────────┘\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 3: Array di Tipi Primitivi
     * 
     * Mostra array di tipi primitivi (int, double, boolean, etc.)
     */
    private static void demoPrimitiveArrays() {
        printSection("3. ARRAY DI TIPI PRIMITIVI");
        
        printSubSection("Array di int");
        
        int[] integers = {10, 20, 30, 40, 50};
        System.out.println("int[] integers = {10, 20, 30, 40, 50};");
        System.out.println("  → Valori: " + Arrays.toString(integers));
        System.out.println("  → Tipo elemento: int (primitivo)");
        System.out.println("  → Tipo array: int[] (oggetto)\n");
        
        printSubSection("Array di double");
        
        double[] prices = {19.99, 29.99, 39.99, 99.99};
        System.out.println("double[] prices = {19.99, 29.99, 39.99, 99.99};");
        System.out.println("  → Valori: " + Arrays.toString(prices));
        System.out.println("  → Media: " + calculateAverage(prices) + "\n");
        
        printSubSection("Array di boolean");
        
        boolean[] flags = {true, false, true, true, false};
        System.out.println("boolean[] flags = {true, false, true, true, false};");
        System.out.println("  → Valori: " + Arrays.toString(flags));
        System.out.println("  → True count: " + countTrue(flags) + "\n");
        
        printSubSection("Array di char");
        
        char[] letters = {'J', 'a', 'v', 'a'};
        System.out.println("char[] letters = {'J', 'a', 'v', 'a'};");
        System.out.println("  → Valori: " + Arrays.toString(letters));
        System.out.println("  → Come String: " + new String(letters) + "\n");
        
        printSubSection("Array di long");
        
        long[] timestamps = {1000000000L, 2000000000L, 3000000000L};
        System.out.println("long[] timestamps = {1000000000L, 2000000000L, 3000000000L};");
        System.out.println("  → Valori: " + Arrays.toString(timestamps) + "\n");
        
        printSubSection("💡 Caratteristiche Array Primitivi");
        
        System.out.println("✓ Memoria efficiente (no boxing overhead)");
        System.out.println("✓ Performance ottimale");
        System.out.println("✓ Valori default automatici (es: 0 per int)");
        System.out.println("✗ No metodi (non sono oggetti)");
        System.out.println("✗ No null come valore (solo per wrapper)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 4: Array di Oggetti
     * 
     * Mostra array di reference types (String, oggetti custom)
     */
    private static void demoObjectArrays() {
        printSection("4. ARRAY DI OGGETTI (REFERENCE TYPES)");
        
        printSubSection("Array di String");
        
        String[] names = {"Alice", "Bob", "Charlie", "Diana"};
        System.out.println("String[] names = {\"Alice\", \"Bob\", \"Charlie\", \"Diana\"};");
        System.out.println("  → Valori: " + Arrays.toString(names));
        System.out.println("  → Tipo elemento: String (oggetto)");
        System.out.println("  → names[0] = " + names[0] + "\n");
        
        printSubSection("Array di String con null");
        
        String[] items = new String[4];
        items[0] = "Primo";
        items[2] = "Terzo";
        System.out.println("String[] items = new String[4];");
        System.out.println("items[0] = \"Primo\";");
        System.out.println("items[2] = \"Terzo\";");
        System.out.println("  → Valori: " + Arrays.toString(items));
        System.out.println("  → items[1] = " + items[1] + " (null di default)\n");
        
        printSubSection("⚠️ NullPointerException");
        
        System.out.println("Chiamare metodi su elementi null causa eccezione:");
        System.out.println("  items[1].length()  → NullPointerException!\n");
        
        try {
            int len = items[1].length();  // NPE!
        } catch (NullPointerException e) {
            System.out.println("Eccezione catturata: " + e.getClass().getSimpleName());
            System.out.println("  → Sempre controllare null prima di usare!\n");
        }
        
        printSubSection("Array di Integer (Wrapper)");
        
        Integer[] numbers = {10, 20, null, 40, 50};
        System.out.println("Integer[] numbers = {10, 20, null, 40, 50};");
        System.out.println("  → Valori: " + Arrays.toString(numbers));
        System.out.println("  → Può contenere null (a differenza di int[])\n");
        
        printSubSection("Array di Oggetti Custom");
        
        Person[] people = new Person[3];
        people[0] = new Person("Alice", 30);
        people[1] = new Person("Bob", 25);
        people[2] = new Person("Charlie", 35);
        
        System.out.println("Person[] people = new Person[3];");
        System.out.println("people[0] = new Person(\"Alice\", 30);");
        System.out.println("// ...\n");
        System.out.println("Contenuto:");
        for (int i = 0; i < people.length; i++) {
            System.out.println("  people[" + i + "] = " + people[i]);
        }
        System.out.println();
        
        printSubSection("💡 Differenze Array Primitivi vs Oggetti");
        
        System.out.println("┌─────────────────┬───────────────┬─────────────────┐");
        System.out.println("│   ASPETTO       │   PRIMITIVI   │    OGGETTI      │");
        System.out.println("├─────────────────┼───────────────┼─────────────────┤");
        System.out.println("│ Null            │ ✗ No          │ ✓ Sì            │");
        System.out.println("│ Default         │ 0, false, ecc │ null            │");
        System.out.println("│ Memoria         │ Minore        │ Maggiore        │");
        System.out.println("│ Performance     │ Migliore      │ Leggermente -   │");
        System.out.println("│ Metodi          │ ✗ No          │ ✓ Sì            │");
        System.out.println("└─────────────────┴───────────────┴─────────────────┘\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 5: Array Multidimensionali
     * 
     * Mostra array 2D, 3D e jagged arrays
     */
    private static void demoMultidimensionalArrays() {
        printSection("5. ARRAY MULTIDIMENSIONALI");
        
        printSubSection("Array 2D (Matrice)");
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("int[][] matrix = {");
        System.out.println("    {1, 2, 3},");
        System.out.println("    {4, 5, 6},");
        System.out.println("    {7, 8, 9}");
        System.out.println("};\n");
        
        System.out.println("Rappresentazione:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("  ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("Accesso elementi:");
        System.out.println("  matrix[0][0] = " + matrix[0][0] + "  (riga 0, colonna 0)");
        System.out.println("  matrix[1][2] = " + matrix[1][2] + "  (riga 1, colonna 2)");
        System.out.println("  matrix[2][1] = " + matrix[2][1] + "  (riga 2, colonna 1)\n");
        
        printSubSection("Creazione Array 2D con new");
        
        int[][] table = new int[3][4];  // 3 righe, 4 colonne
        System.out.println("int[][] table = new int[3][4];  // 3 righe, 4 colonne");
        System.out.println("  → Tutti elementi inizializzati a 0");
        System.out.println("  → table.length = " + table.length + " (numero righe)");
        System.out.println("  → table[0].length = " + table[0].length + " (numero colonne)\n");
        
        printSubSection("Jagged Array (Array Irregolari)");
        
        int[][] jagged = {
            {1, 2},
            {3, 4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("int[][] jagged = {");
        System.out.println("    {1, 2},            // Riga 0: 2 elementi");
        System.out.println("    {3, 4, 5, 6},      // Riga 1: 4 elementi");
        System.out.println("    {7, 8, 9}          // Riga 2: 3 elementi");
        System.out.println("};\n");
        
        System.out.println("Rappresentazione:");
        for (int i = 0; i < jagged.length; i++) {
            System.out.print("  Riga " + i + ": ");
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println("(lunghezza: " + jagged[i].length + ")");
        }
        System.out.println();
        
        printSubSection("Array 3D (Cubo)");
        
        int[][][] cube = new int[2][3][4];  // 2 "piani", 3 righe, 4 colonne
        cube[0][0][0] = 100;
        cube[1][2][3] = 999;
        
        System.out.println("int[][][] cube = new int[2][3][4];");
        System.out.println("  → 2 \"piani\", 3 righe per piano, 4 colonne per riga");
        System.out.println("  → cube[0][0][0] = " + cube[0][0][0]);
        System.out.println("  → cube[1][2][3] = " + cube[1][2][3] + "\n");
        
        printSubSection("💡 Iterazione Array 2D");
        
        System.out.println("Nested loops:");
        System.out.println("  for (int i = 0; i < matrix.length; i++) {           // Righe");
        System.out.println("      for (int j = 0; j < matrix[i].length; j++) {   // Colonne");
        System.out.println("          System.out.print(matrix[i][j] + \" \");");
        System.out.println("      }");
        System.out.println("  }\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 6: Accesso e Modifica Elementi
     * 
     * Mostra come accedere e modificare elementi di array
     */
    private static void demoAccessModification() {
        printSection("6. ACCESSO E MODIFICA ELEMENTI");
        
        printSubSection("Accesso Lettura");
        
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("int[] numbers = {10, 20, 30, 40, 50};\n");
        
        System.out.println("Accesso diretto tramite indice:");
        System.out.println("  numbers[0] = " + numbers[0]);
        System.out.println("  numbers[2] = " + numbers[2]);
        System.out.println("  numbers[4] = " + numbers[4] + "\n");
        
        System.out.println("Primo e ultimo elemento:");
        System.out.println("  Primo:  numbers[0] = " + numbers[0]);
        System.out.println("  Ultimo: numbers[numbers.length - 1] = " + numbers[numbers.length - 1] + "\n");
        
        printSubSection("Modifica Elementi");
        
        System.out.println("Stato iniziale: " + Arrays.toString(numbers) + "\n");
        
        numbers[0] = 100;
        System.out.println("numbers[0] = 100;");
        System.out.println("  → " + Arrays.toString(numbers) + "\n");
        
        numbers[2] = numbers[2] * 2;
        System.out.println("numbers[2] = numbers[2] * 2;");
        System.out.println("  → " + Arrays.toString(numbers) + "\n");
        
        numbers[4] += 5;
        System.out.println("numbers[4] += 5;");
        System.out.println("  → " + Arrays.toString(numbers) + "\n");
        
        printSubSection("Incremento/Decremento");
        
        System.out.println("numbers[1]++; (post-increment)");
        numbers[1]++;
        System.out.println("  → " + Arrays.toString(numbers) + "\n");
        
        System.out.println("++numbers[3]; (pre-increment)");
        ++numbers[3];
        System.out.println("  → " + Arrays.toString(numbers) + "\n");
        
        printSubSection("Scambio Elementi (Swap)");
        
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Prima: " + Arrays.toString(arr));
        
        // Swap arr[1] e arr[3]
        int temp = arr[1];
        arr[1] = arr[3];
        arr[3] = temp;
        
        System.out.println("\nSwap arr[1] ↔ arr[3]:");
        System.out.println("  int temp = arr[1];");
        System.out.println("  arr[1] = arr[3];");
        System.out.println("  arr[3] = temp;");
        System.out.println("\nDopo:  " + Arrays.toString(arr) + "\n");
        
        printSubSection("⚠️ Bounds Checking");
        
        System.out.println("Java controlla automaticamente i limiti:");
        System.out.println("  Indice valido: 0 ≤ indice < length");
        System.out.println("  Indice invalido → ArrayIndexOutOfBoundsException\n");
        
        System.out.println("Esempio con numbers.length = " + numbers.length + ":");
        System.out.println("  numbers[5]  → ERRORE! (massimo indice: 4)");
        System.out.println("  numbers[-1] → ERRORE! (indice negativo)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 7: Iterazione su Array
     * 
     * Mostra i vari modi per iterare su array
     */
    private static void demoIteration() {
        printSection("7. ITERAZIONE SU ARRAY");
        
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("int[] numbers = {10, 20, 30, 40, 50};\n");
        
        printSubSection("1. Classic For Loop (con indice)");
        
        System.out.println("for (int i = 0; i < numbers.length; i++) {");
        System.out.println("    System.out.println(\"numbers[\" + i + \"] = \" + numbers[i]);");
        System.out.println("}\n");
        
        System.out.println("Output:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("  numbers[" + i + "] = " + numbers[i]);
        }
        System.out.println();
        
        System.out.println("✓ Vantaggi: Accesso all'indice, modifica elementi");
        System.out.println("✗ Svantaggi: Verboso, possibile errore off-by-one\n");
        
        printSubSection("2. Enhanced For Loop (for-each)");
        
        System.out.println("for (int num : numbers) {");
        System.out.println("    System.out.println(num);");
        System.out.println("}\n");
        
        System.out.println("Output:");
        for (int num : numbers) {
            System.out.println("  " + num);
        }
        System.out.println();
        
        System.out.println("✓ Vantaggi: Conciso, sicuro, leggibile");
        System.out.println("✗ Svantaggi: No indice, no modifica array (solo lettura efficace)\n");
        
        printSubSection("3. While Loop");
        
        System.out.println("int i = 0;");
        System.out.println("while (i < numbers.length) {");
        System.out.println("    System.out.println(numbers[i]);");
        System.out.println("    i++;");
        System.out.println("}\n");
        
        System.out.println("Output:");
        int i = 0;
        while (i < numbers.length) {
            System.out.println("  " + numbers[i]);
            i++;
        }
        System.out.println();
        
        printSubSection("4. Iterazione Inversa");
        
        System.out.println("for (int i = numbers.length - 1; i >= 0; i--) {");
        System.out.println("    System.out.print(numbers[i] + \" \");");
        System.out.println("}\n");
        
        System.out.print("Output: ");
        for (int j = numbers.length - 1; j >= 0; j--) {
            System.out.print(numbers[j] + " ");
        }
        System.out.println("\n");
        
        printSubSection("5. Stream API (Java 8+)");
        
        System.out.println("Arrays.stream(numbers).forEach(System.out::println);\n");
        
        System.out.println("Output:");
        Arrays.stream(numbers).forEach(n -> System.out.println("  " + n));
        System.out.println();
        
        System.out.println("Con operazioni:");
        System.out.println("  int sum = Arrays.stream(numbers).sum();");
        int sum = Arrays.stream(numbers).sum();
        System.out.println("  → sum = " + sum + "\n");
        
        printSubSection("6. Iterazione Array 2D");
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        System.out.println("Nested loops:");
        System.out.println("for (int i = 0; i < matrix.length; i++) {");
        System.out.println("    for (int j = 0; j < matrix[i].length; j++) {");
        System.out.println("        System.out.print(matrix[i][j] + \" \");");
        System.out.println("    }");
        System.out.println("}\n");
        
        System.out.println("Output:");
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("  ");
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("Enhanced for-each:");
        System.out.println("for (int[] row : matrix) {");
        System.out.println("    for (int value : row) {");
        System.out.println("        System.out.print(value + \" \");");
        System.out.println("    }");
        System.out.println("}\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 8: Copia di Array
     * 
     * Mostra i vari metodi per copiare array
     */
    private static void demoCopyingArrays() {
        printSection("8. COPIA DI ARRAY");
        
        int[] original = {10, 20, 30, 40, 50};
        System.out.println("int[] original = {10, 20, 30, 40, 50};\n");
        
        printSubSection("⚠️ Assegnamento NON copia!");
        
        int[] reference = original;
        System.out.println("int[] reference = original;");
        System.out.println("  → reference e original puntano allo STESSO array!\n");
        
        reference[0] = 999;
        System.out.println("reference[0] = 999;");
        System.out.println("  original  = " + Arrays.toString(original));
        System.out.println("  reference = " + Arrays.toString(reference));
        System.out.println("  → Modifica visibile in entrambi!\n");
        
        // Reset
        original[0] = 10;
        
        printSubSection("1. Arrays.copyOf() - Copia Completa");
        
        int[] copy1 = Arrays.copyOf(original, original.length);
        System.out.println("int[] copy1 = Arrays.copyOf(original, original.length);");
        System.out.println("  → Crea NUOVO array con stessi valori");
        System.out.println("  → copy1 = " + Arrays.toString(copy1) + "\n");
        
        copy1[0] = 100;
        System.out.println("copy1[0] = 100;");
        System.out.println("  original = " + Arrays.toString(original) + " (immutato)");
        System.out.println("  copy1    = " + Arrays.toString(copy1) + " (modificato)\n");
        
        printSubSection("2. Arrays.copyOf() - Copia Parziale/Estesa");
        
        int[] partial = Arrays.copyOf(original, 3);
        System.out.println("Arrays.copyOf(original, 3);  // Solo primi 3 elementi");
        System.out.println("  → " + Arrays.toString(partial) + "\n");
        
        int[] extended = Arrays.copyOf(original, 8);
        System.out.println("Arrays.copyOf(original, 8);  // Esteso con zeri");
        System.out.println("  → " + Arrays.toString(extended) + "\n");
        
        printSubSection("3. Arrays.copyOfRange() - Sottosezione");
        
        int[] range = Arrays.copyOfRange(original, 1, 4);
        System.out.println("Arrays.copyOfRange(original, 1, 4);  // Indici [1, 4)");
        System.out.println("  → " + Arrays.toString(range) + " (elementi da indice 1 a 3)\n");
        
        printSubSection("4. System.arraycopy() - Performance");
        
        int[] copy2 = new int[original.length];
        System.arraycopy(original, 0, copy2, 0, original.length);
        
        System.out.println("int[] copy2 = new int[original.length];");
        System.out.println("System.arraycopy(original, 0, copy2, 0, original.length);");
        System.out.println("  → copy2 = " + Arrays.toString(copy2));
        System.out.println("  → Più veloce per array grandi\n");
        
        printSubSection("5. clone() - Shallow Copy");
        
        int[] clone = original.clone();
        System.out.println("int[] clone = original.clone();");
        System.out.println("  → clone = " + Arrays.toString(clone));
        System.out.println("  → Shallow copy (OK per primitivi)\n");
        
        printSubSection("6. Manual Loop");
        
        int[] manual = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            manual[i] = original[i];
        }
        
        System.out.println("Manual copy con loop:");
        System.out.println("  manual = " + Arrays.toString(manual) + "\n");
        
        printSubSection("⚠️ Shallow vs Deep Copy (Oggetti)");
        
        String[] names = {"Alice", "Bob", "Charlie"};
        String[] namesCopy = names.clone();
        
        System.out.println("String[] names = {\"Alice\", \"Bob\", \"Charlie\"};");
        System.out.println("String[] namesCopy = names.clone();\n");
        
        System.out.println("Per oggetti immutabili (String):");
        System.out.println("  → Shallow copy OK (String è immutabile)\n");
        
        System.out.println("Per oggetti mutabili:");
        System.out.println("  → Serve deep copy manuale degli elementi!");
        System.out.println("  → Altrimenti modifiche visibili in entrambi array\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 9: Ordinamento
     * 
     * Mostra come ordinare array
     */
    private static void demoSorting() {
        printSection("9. ORDINAMENTO");
        
        printSubSection("Arrays.sort() - Ordinamento Naturale");
        
        int[] numbers = {50, 10, 40, 20, 30};
        System.out.println("int[] numbers = {50, 10, 40, 20, 30};");
        System.out.println("Prima:  " + Arrays.toString(numbers) + "\n");
        
        Arrays.sort(numbers);
        System.out.println("Arrays.sort(numbers);");
        System.out.println("Dopo:   " + Arrays.toString(numbers) + " (crescente)\n");
        
        printSubSection("Ordinamento Range");
        
        int[] arr = {50, 10, 40, 20, 30};
        System.out.println("int[] arr = {50, 10, 40, 20, 30};");
        Arrays.sort(arr, 1, 4);  // Ordina solo indici [1, 4)
        System.out.println("Arrays.sort(arr, 1, 4);  // Solo indici [1, 4)");
        System.out.println("Dopo:   " + Arrays.toString(arr) + "\n");
        
        printSubSection("Ordinamento String (Alfabetico)");
        
        String[] names = {"Charlie", "Alice", "Bob", "Diana"};
        System.out.println("String[] names = {\"Charlie\", \"Alice\", \"Bob\", \"Diana\"};");
        System.out.println("Prima:  " + Arrays.toString(names) + "\n");
        
        Arrays.sort(names);
        System.out.println("Arrays.sort(names);");
        System.out.println("Dopo:   " + Arrays.toString(names) + " (alfabetico)\n");
        
        printSubSection("Ordinamento Decrescente (Comparator)");
        
        Integer[] nums = {50, 10, 40, 20, 30};
        System.out.println("Integer[] nums = {50, 10, 40, 20, 30};");
        Arrays.sort(nums, Comparator.reverseOrder());
        System.out.println("Arrays.sort(nums, Comparator.reverseOrder());");
        System.out.println("Dopo:   " + Arrays.toString(nums) + " (decrescente)\n");
        
        printSubSection("Ordinamento Custom (Comparator)");
        
        String[] words = {"banana", "kiwi", "apple", "grape"};
        System.out.println("String[] words = {\"banana\", \"kiwi\", \"apple\", \"grape\"};");
        System.out.println("\nOrdinamento per lunghezza:");
        Arrays.sort(words, Comparator.comparingInt(String::length));
        System.out.println("Arrays.sort(words, Comparator.comparingInt(String::length));");
        System.out.println("  → " + Arrays.toString(words) + "\n");
        
        printSubSection("Ordinamento Oggetti Custom");
        
        Person[] people = {
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        };
        
        System.out.println("Prima (per età):");
        for (Person p : people) {
            System.out.println("  " + p);
        }
        
        Arrays.sort(people, Comparator.comparingInt(p -> p.age));
        System.out.println("\nDopo ordinamento per età:");
        for (Person p : people) {
            System.out.println("  " + p);
        }
        System.out.println();
        
        printSubSection("💡 Algoritmi Sorting");
        
        System.out.println("Arrays.sort() usa:");
        System.out.println("  • Dual-Pivot Quicksort per primitivi (O(n log n))");
        System.out.println("  • TimSort per oggetti (stabile, O(n log n))");
        System.out.println("  • Ottimizzato e performante!\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 10: Ricerca
     * 
     * Mostra come cercare elementi in array
     */
    private static void demoSearching() {
        printSection("10. RICERCA");
        
        printSubSection("Ricerca Lineare (Sequenziale)");
        
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("int[] numbers = {10, 20, 30, 40, 50};\n");
        
        int target = 30;
        int index = linearSearch(numbers, target);
        
        System.out.println("Ricerca lineare di " + target + ":");
        System.out.println("  → Trovato all'indice: " + index);
        System.out.println("  → Complessità: O(n)\n");
        
        printSubSection("Arrays.binarySearch() - Ricerca Binaria");
        
        int[] sorted = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.println("int[] sorted = {10, 20, 30, 40, 50, 60, 70, 80, 90};");
        System.out.println("  ⚠️ Array DEVE essere ordinato!\n");
        
        int found = Arrays.binarySearch(sorted, 50);
        System.out.println("Arrays.binarySearch(sorted, 50);");
        System.out.println("  → Indice: " + found);
        System.out.println("  → Valore: sorted[" + found + "] = " + sorted[found] + "\n");
        
        int notFound = Arrays.binarySearch(sorted, 55);
        System.out.println("Arrays.binarySearch(sorted, 55);  // Non presente");
        System.out.println("  → Risultato: " + notFound + " (negativo)");
        System.out.println("  → Insertion point: " + (-(notFound) - 1) + "\n");
        
        printSubSection("Ricerca Binaria su Range");
        
        int result = Arrays.binarySearch(sorted, 2, 7, 50);
        System.out.println("Arrays.binarySearch(sorted, 2, 7, 50);  // Cerca in [2, 7)");
        System.out.println("  → Indice: " + result + "\n");
        
        printSubSection("Ricerca String");
        
        String[] names = {"Alice", "Bob", "Charlie", "Diana"};
        Arrays.sort(names);  // Ordina prima
        System.out.println("String[] names = {\"Alice\", \"Bob\", \"Charlie\", \"Diana\"};");
        System.out.println("Arrays.sort(names);\n");
        
        int idx = Arrays.binarySearch(names, "Charlie");
        System.out.println("Arrays.binarySearch(names, \"Charlie\");");
        System.out.println("  → Indice: " + idx);
        System.out.println("  → Valore: " + names[idx] + "\n");
        
        printSubSection("Ricerca con Stream (Java 8+)");
        
        boolean exists = Arrays.stream(numbers).anyMatch(n -> n == 30);
        System.out.println("Arrays.stream(numbers).anyMatch(n -> n == 30);");
        System.out.println("  → " + exists + "\n");
        
        int first = Arrays.stream(numbers).filter(n -> n > 25).findFirst().orElse(-1);
        System.out.println("Arrays.stream(numbers).filter(n -> n > 25).findFirst();");
        System.out.println("  → Primo elemento > 25: " + first + "\n");
        
        printSubSection("💡 Linear vs Binary Search");
        
        System.out.println("┌─────────────────┬──────────────┬─────────────────┐");
        System.out.println("│   METODO        │ COMPLESSITÀ  │  REQUISITI      │");
        System.out.println("├─────────────────┼──────────────┼─────────────────┤");
        System.out.println("│ Linear Search   │ O(n)         │ Nessuno         │");
        System.out.println("│ Binary Search   │ O(log n)     │ Array ordinato  │");
        System.out.println("└─────────────────┴──────────────┴─────────────────┘\n");
        
        System.out.println("💡 Usa binary search per array grandi e ordinati!\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 11: Confronto di Array
     * 
     * Mostra come confrontare array
     */
    private static void demoComparison() {
        printSection("11. CONFRONTO DI ARRAY");
        
        printSubSection("⚠️ Operatore == confronta RIFERIMENTI!");
        
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = arr1;
        
        System.out.println("int[] arr1 = {1, 2, 3};");
        System.out.println("int[] arr2 = {1, 2, 3};");
        System.out.println("int[] arr3 = arr1;\n");
        
        System.out.println("arr1 == arr2  → " + (arr1 == arr2) + " (diversi oggetti!)");
        System.out.println("arr1 == arr3  → " + (arr1 == arr3) + " (stesso oggetto)\n");
        
        printSubSection("Arrays.equals() - Confronto Contenuto");
        
        System.out.println("Arrays.equals(arr1, arr2)  → " + Arrays.equals(arr1, arr2));
        System.out.println("  → Confronta elemento per elemento\n");
        
        int[] arr4 = {1, 2, 3, 4};
        System.out.println("int[] arr4 = {1, 2, 3, 4};");
        System.out.println("Arrays.equals(arr1, arr4)  → " + Arrays.equals(arr1, arr4));
        System.out.println("  → Lunghezze diverse\n");
        
        printSubSection("Arrays.deepEquals() - Array Multidimensionali");
        
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        
        System.out.println("int[][] matrix1 = {{1, 2}, {3, 4}};");
        System.out.println("int[][] matrix2 = {{1, 2}, {3, 4}};\n");
        
        System.out.println("Arrays.equals(matrix1, matrix2)");
        System.out.println("  → " + Arrays.equals(matrix1, matrix2) + " (shallow compare!)");
        
        System.out.println("\nArrays.deepEquals(matrix1, matrix2)");
        System.out.println("  → " + Arrays.deepEquals(matrix1, matrix2) + " (deep compare)\n");
        
        printSubSection("Confronto Lessicografico");
        
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 4};
        int[] c = {1, 2, 3, 0};
        
        System.out.println("int[] a = {1, 2, 3};");
        System.out.println("int[] b = {1, 2, 4};");
        System.out.println("int[] c = {1, 2, 3, 0};\n");
        
        System.out.println("Arrays.compare(a, b)  → " + Arrays.compare(a, b) + " (a < b)");
        System.out.println("Arrays.compare(b, a)  → " + Arrays.compare(b, a) + " (b > a)");
        System.out.println("Arrays.compare(a, c)  → " + Arrays.compare(a, c) + " (a < c per lunghezza)\n");
        
        printSubSection("Arrays.mismatch() - Primo Elemento Diverso");
        
        int[] x = {1, 2, 3, 4, 5};
        int[] y = {1, 2, 9, 4, 5};
        
        System.out.println("int[] x = {1, 2, 3, 4, 5};");
        System.out.println("int[] y = {1, 2, 9, 4, 5};\n");
        
        int mismatchIndex = Arrays.mismatch(x, y);
        System.out.println("Arrays.mismatch(x, y)  → " + mismatchIndex);
        System.out.println("  → Primo elemento diverso all'indice " + mismatchIndex + "\n");
        
        int[] z = {1, 2, 3, 4, 5};
        System.out.println("int[] z = {1, 2, 3, 4, 5};");
        System.out.println("Arrays.mismatch(x, z)  → " + Arrays.mismatch(x, z) + " (uguali)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 12: Conversioni Array ↔ Collection
     * 
     * Mostra conversioni tra array e Collections (List, Set)
     */
    private static void demoConversions() {
        printSection("12. CONVERSIONI ARRAY ↔ COLLECTION");
        
        printSubSection("Array → List (Arrays.asList)");
        
        String[] array = {"Alice", "Bob", "Charlie"};
        List<String> list = Arrays.asList(array);
        
        System.out.println("String[] array = {\"Alice\", \"Bob\", \"Charlie\"};");
        System.out.println("List<String> list = Arrays.asList(array);\n");
        System.out.println("  → list = " + list);
        System.out.println("  → Tipo: " + list.getClass().getSimpleName() + "\n");
        
        System.out.println("⚠️ ATTENZIONE: Lista FIXED-SIZE!");
        System.out.println("  ✓ Modifica OK: list.set(0, \"Alicia\");");
        list.set(0, "Alicia");
        System.out.println("    → " + list);
        
        System.out.println("\n  ✗ Add/Remove: UnsupportedOperationException");
        System.out.println("    list.add(\"Diana\");  → ECCEZIONE!\n");
        
        printSubSection("Array → Mutable List (ArrayList)");
        
        String[] arr = {"Alice", "Bob", "Charlie"};
        List<String> mutableList = new java.util.ArrayList<>(Arrays.asList(arr));
        
        System.out.println("List<String> mutableList = new ArrayList<>(Arrays.asList(arr));\n");
        System.out.println("  → Ora è modificabile!");
        mutableList.add("Diana");
        System.out.println("  mutableList.add(\"Diana\");");
        System.out.println("  → " + mutableList + "\n");
        
        printSubSection("List → Array (toArray)");
        
        List<String> names = List.of("Alice", "Bob", "Charlie");
        
        // toArray() restituisce Object[]
        Object[] objArray = names.toArray();
        System.out.println("Object[] objArray = names.toArray();");
        System.out.println("  → " + Arrays.toString(objArray));
        System.out.println("  → Tipo: Object[]\n");
        
        // toArray(T[]) restituisce tipo corretto
        String[] strArray = names.toArray(new String[0]);
        System.out.println("String[] strArray = names.toArray(new String[0]);");
        System.out.println("  → " + Arrays.toString(strArray));
        System.out.println("  → Tipo: String[]\n");
        
        printSubSection("Primitivi → List (Boxing)");
        
        int[] numbers = {1, 2, 3, 4, 5};
        
        // No shortcut per primitivi! Serve boxing
        List<Integer> numList = Arrays.stream(numbers).boxed().toList();
        
        System.out.println("int[] numbers = {1, 2, 3, 4, 5};");
        System.out.println("List<Integer> numList = Arrays.stream(numbers).boxed().toList();");
        System.out.println("  → " + numList + "\n");
        
        printSubSection("List → Array Primitivi (Unboxing)");
        
        List<Integer> integers = List.of(10, 20, 30);
        int[] intArray = integers.stream().mapToInt(Integer::intValue).toArray();
        
        System.out.println("List<Integer> integers = List.of(10, 20, 30);");
        System.out.println("int[] intArray = integers.stream().mapToInt(Integer::intValue).toArray();");
        System.out.println("  → " + Arrays.toString(intArray) + "\n");
        
        printSubSection("💡 Riepilogo Conversioni");
        
        System.out.println("┌─────────────────────┬──────────────────────────────────────┐");
        System.out.println("│   DA → A            │              METODO                  │");
        System.out.println("├─────────────────────┼──────────────────────────────────────┤");
        System.out.println("│ Array → List fixed  │ Arrays.asList(array)                 │");
        System.out.println("│ Array → List mutab. │ new ArrayList<>(Arrays.asList(...))  │");
        System.out.println("│ List → Array        │ list.toArray(new T[0])               │");
        System.out.println("│ int[] → List<Int>   │ Arrays.stream(arr).boxed().toList()  │");
        System.out.println("│ List<Int> → int[]   │ list.stream().mapToInt(...).toArray()│");
        System.out.println("└─────────────────────┴──────────────────────────────────────┘\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 13: Utility Arrays Class
     * 
     * Mostra metodi utili della classe Arrays
     */
    private static void demoArraysUtilities() {
        printSection("13. UTILITY: CLASSE Arrays");
        
        printSubSection("Arrays.toString() - Stampa Array");
        
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("int[] numbers = {10, 20, 30, 40, 50};\n");
        
        System.out.println("System.out.println(numbers);");
        System.out.println("  → " + numbers + " (hash code, inutile!)\n");
        
        System.out.println("System.out.println(Arrays.toString(numbers));");
        System.out.println("  → " + Arrays.toString(numbers) + " (leggibile!)\n");
        
        printSubSection("Arrays.deepToString() - Array Multidimensionali");
        
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        
        System.out.println("int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};\n");
        
        System.out.println("Arrays.toString(matrix);");
        System.out.println("  → " + Arrays.toString(matrix) + " (hash codes!)\n");
        
        System.out.println("Arrays.deepToString(matrix);");
        System.out.println("  → " + Arrays.deepToString(matrix) + " (leggibile!)\n");
        
        printSubSection("Arrays.fill() - Riempimento");
        
        int[] arr = new int[5];
        Arrays.fill(arr, 7);
        
        System.out.println("int[] arr = new int[5];");
        System.out.println("Arrays.fill(arr, 7);");
        System.out.println("  → " + Arrays.toString(arr) + "\n");
        
        Arrays.fill(arr, 1, 4, 99);  // Fill range [1, 4)
        System.out.println("Arrays.fill(arr, 1, 4, 99);  // Solo indici [1, 4)");
        System.out.println("  → " + Arrays.toString(arr) + "\n");
        
        printSubSection("Arrays.stream() - Stream API");
        
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};\n");
        
        int sum = Arrays.stream(data).sum();
        System.out.println("Arrays.stream(data).sum();");
        System.out.println("  → " + sum + "\n");
        
        double average = Arrays.stream(data).average().orElse(0);
        System.out.println("Arrays.stream(data).average();");
        System.out.println("  → " + average + "\n");
        
        int max = Arrays.stream(data).max().orElse(0);
        System.out.println("Arrays.stream(data).max();");
        System.out.println("  → " + max + "\n");
        
        int[] evens = Arrays.stream(data).filter(n -> n % 2 == 0).toArray();
        System.out.println("Arrays.stream(data).filter(n -> n % 2 == 0).toArray();");
        System.out.println("  → " + Arrays.toString(evens) + "\n");
        
        printSubSection("Arrays.setAll() - Generazione Funzionale");
        
        int[] sequence = new int[5];
        Arrays.setAll(sequence, i -> i * 10);
        
        System.out.println("int[] sequence = new int[5];");
        System.out.println("Arrays.setAll(sequence, i -> i * 10);");
        System.out.println("  → " + Arrays.toString(sequence) + "\n");
        
        printSubSection("Arrays.parallelSort() - Sorting Parallelo");
        
        int[] large = IntStream.rangeClosed(1, 1000).toArray();
        
        System.out.println("Per array grandi (>1000 elementi):");
        System.out.println("  Arrays.parallelSort(large);");
        System.out.println("  → Usa più thread, più veloce!\n");
        
        printSubSection("IntStream.range() - Generazione Array");
        
        int[] range = IntStream.range(0, 10).toArray();
        System.out.println("IntStream.range(0, 10).toArray();");
        System.out.println("  → " + Arrays.toString(range) + " (0 escluso 10)\n");
        
        int[] rangeClosed = IntStream.rangeClosed(1, 5).toArray();
        System.out.println("IntStream.rangeClosed(1, 5).toArray();");
        System.out.println("  → " + Arrays.toString(rangeClosed) + " (1 incluso 5)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 14: Best Practices
     * 
     * Raccolta di best practices professionali per array
     */
    private static void demoBestPractices() {
        printSection("14. BEST PRACTICES");
        
        printSubSection("1. ✅ Preferisci [] dopo tipo");
        
        System.out.println("✓ RACCOMANDATO:");
        System.out.println("  int[] numbers;");
        System.out.println("  String[] names;\n");
        
        System.out.println("✗ EVITA:");
        System.out.println("  int numbers[];   // Meno chiaro\n");
        
        printSubSection("2. ✅ Inizializza sempre array");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  int[] arr = new int[10];        // Inizializzato a 0");
        System.out.println("  String[] names = new String[5]; // Inizializzato a null\n");
        
        System.out.println("⚠️ ATTENZIONE:");
        System.out.println("  int[] arr;");
        System.out.println("  arr[0] = 10;  → Compile ERROR! (Non inizializzato)\n");
        
        printSubSection("3. ✅ Controlla bounds manualmente");
        
        System.out.println("✓ SICURO:");
        System.out.println("  if (index >= 0 && index < array.length) {");
        System.out.println("      int value = array[index];");
        System.out.println("  } else {");
        System.out.println("      // Gestisci errore");
        System.out.println("  }\n");
        
        printSubSection("4. ✅ Usa enhanced for quando possibile");
        
        System.out.println("✓ LEGGIBILE (solo lettura):");
        System.out.println("  for (int num : numbers) {");
        System.out.println("      System.out.println(num);");
        System.out.println("  }\n");
        
        System.out.println("✓ CLASSIC (modifica o indice necessario):");
        System.out.println("  for (int i = 0; i < numbers.length; i++) {");
        System.out.println("      numbers[i] *= 2;");
        System.out.println("  }\n");
        
        printSubSection("5. ✅ Defensive Copy per sicurezza");
        
        System.out.println("✓ IMMUTABILE (defensive copy):");
        System.out.println("  public class Data {");
        System.out.println("      private final int[] values;");
        System.out.println("      ");
        System.out.println("      public Data(int[] values) {");
        System.out.println("          this.values = Arrays.copyOf(values, values.length);");
        System.out.println("      }");
        System.out.println("      ");
        System.out.println("      public int[] getValues() {");
        System.out.println("          return Arrays.copyOf(values, values.length);");
        System.out.println("      }");
        System.out.println("  }\n");
        
        System.out.println("✗ VULNERABILE:");
        System.out.println("  this.values = values;  // Client può modificare!\n");
        
        printSubSection("6. ✅ Usa Arrays.equals() per confronto");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  if (Arrays.equals(arr1, arr2)) { ... }\n");
        
        System.out.println("✗ SBAGLIATO:");
        System.out.println("  if (arr1 == arr2) { ... }  // Confronta riferimenti!\n");
        
        printSubSection("7. ✅ Arrays.toString() per debug");
        
        System.out.println("✓ UTILE:");
        System.out.println("  System.out.println(Arrays.toString(arr));\n");
        
        System.out.println("✗ INUTILE:");
        System.out.println("  System.out.println(arr);  // Hash code!\n");
        
        printSubSection("8. ✅ Usa varargs per flessibilità");
        
        System.out.println("✓ FLESSIBILE:");
        System.out.println("  public static int sum(int... numbers) {");
        System.out.println("      return Arrays.stream(numbers).sum();");
        System.out.println("  }");
        System.out.println("  ");
        System.out.println("  sum(1, 2, 3);        // OK");
        System.out.println("  sum(1, 2, 3, 4, 5);  // OK\n");
        
        printSubSection("9. ✅ Considera Collections per dinamicità");
        
        System.out.println("✓ ARRAY (size fissa):");
        System.out.println("  • Dimensione nota e immutabile");
        System.out.println("  • Performance critiche");
        System.out.println("  • Tipi primitivi\n");
        
        System.out.println("✓ ArrayList (size dinamica):");
        System.out.println("  • Dimensione variabile");
        System.out.println("  • Add/remove frequenti");
        System.out.println("  • Più flessibile\n");
        
        printSubSection("10. ✅ Null safety per array di oggetti");
        
        System.out.println("✓ SICURO:");
        System.out.println("  String[] names = getNames();");
        System.out.println("  if (names != null && names.length > 0) {");
        System.out.println("      for (String name : names) {");
        System.out.println("          if (name != null) {");
        System.out.println("              System.out.println(name.toUpperCase());");
        System.out.println("          }");
        System.out.println("      }");
        System.out.println("  }\n");
        
        printSubSection("📝 Checklist Finale");
        
        System.out.println("Prima di usare array, verifica:");
        System.out.println("  ☑ Array è la struttura giusta? (vs ArrayList)");
        System.out.println("  ☑ Dimensione nota e fissa?");
        System.out.println("  ☑ Inizializzato correttamente?");
        System.out.println("  ☑ Controllo bounds dove necessario?");
        System.out.println("  ☑ Enhanced for per sola lettura?");
        System.out.println("  ☑ Defensive copy se mutabile?");
        System.out.println("  ☑ Arrays.equals() per confronti?");
        System.out.println("  ☑ Arrays.toString() per debug?");
        System.out.println("  ☑ Null check per array di oggetti?");
        System.out.println("  ☑ Considerato Stream API?\n");
        
        printSubSection("💡 Regola d'Oro");
        
        System.out.println("\"Array = dimensione FISSA. ArrayList = dimensione DINAMICA.\"");
        System.out.println("\"Usa enhanced for quando possibile. Classic for quando serve indice.\"");
        System.out.println("\"Arrays.equals() per confronto, Arrays.toString() per stampa.\"\n");
        
        waitForEnter();
    }

    // ==================== METODI UTILITY ====================

    /**
     * Classe helper per demo oggetti
     */
    private static class Person {
        String name;
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + " (" + age + " anni)";
        }
    }

    /**
     * Metodo helper per stampare array
     */
    private static void printArray(int[] arr) {
        System.out.print("    → ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Calcola media di array double
     */
    private static double calculateAverage(double[] arr) {
        double sum = 0;
        for (double value : arr) {
            sum += value;
        }
        return sum / arr.length;
    }

    /**
     * Conta valori true in array boolean
     */
    private static int countTrue(boolean[] arr) {
        int count = 0;
        for (boolean value : arr) {
            if (value) count++;
        }
        return count;
    }

    /**
     * Ricerca lineare
     */
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
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
        System.out.println("📚 " + sectionTitle);
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
        System.out.println("  ✓ DEMO COMPLETATA - Hai appreso tutto sugli Array in Java!");
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
