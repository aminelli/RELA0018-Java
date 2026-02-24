package com.corso.samples.javabase;

/**
 * Classe demo completa per l'apprendimento degli OPERATORI in Java
 * 
 * Gli operatori sono simboli speciali che eseguono operazioni su operandi.
 * Java supporta molti tipi di operatori per diverse operazioni.
 * 
 * TIPI DI OPERATORI TRATTATI:
 * - Operatori di assegnamento (Assignment)
 * - Operatori aritmetici (Arithmetic)
 * - Operatori unari (Unary)
 * - Operatori relazionali/comparazione (Relational)
 * - Operatori logici (Logical)
 * - Operatori bitwise (Bit-level)
 * - Operatore ternario (Ternary/Conditional)
 * - Type Casting (conversioni di tipo)
 * - Precedenza degli operatori
 * 
 * @author Java 21 Course
 * @version 1.0
 */
public class OperatorsDemo {

    /**
     * Metodo principale che esegue tutte le demo sugli operatori
     * Questo metodo orchestra l'esecuzione sequenziale di tutte le sezioni
     */
    public static void run() {
        printHeader("DEMO COMPLETA: OPERATORI E TYPE CASTING IN JAVA");
        
        // Sezione 1: Introduzione agli operatori
        demoIntroduction();
        
        // Sezione 2: Operatori di assegnamento
        demoAssignmentOperators();
        
        // Sezione 3: Operatori aritmetici
        demoArithmeticOperators();
        
        // Sezione 4: Operatori unari
        demoUnaryOperators();
        
        // Sezione 5: Operatori relazionali (comparazione)
        demoRelationalOperators();
        
        // Sezione 6: Operatori logici
        demoLogicalOperators();
        
        // Sezione 7: Operatori bitwise
        demoBitwiseOperators();
        
        // Sezione 8: Operatore ternario
        demoTernaryOperator();
        
        // Sezione 9: Type Casting - Conversioni implicite (widening)
        demoWideningCasting();
        
        // Sezione 10: Type Casting - Conversioni esplicite (narrowing)
        demoNarrowingCasting();
        
        // Sezione 11: Type Casting con oggetti
        demoObjectCasting();
        
        // Sezione 12: Precedenza degli operatori
        demoOperatorPrecedence();
        
        // Sezione 13: Best practices con gli operatori
        demoBestPractices();
        
        printFooter();
    }

    /**
     * SEZIONE 1: Introduzione agli Operatori
     * 
     * Spiega cosa sono gli operatori e le diverse categorie disponibili in Java
     */
    private static void demoIntroduction() {
        printSection("1. INTRODUZIONE AGLI OPERATORI");
        
        System.out.println("Un OPERATORE è un simbolo speciale che esegue operazioni su uno o più operandi.");
        System.out.println("Gli operandi sono i valori su cui l'operatore agisce.\n");
        
        printSubSection("Esempio di Operatore");
        
        int a = 10;
        int b = 5;
        int result = a + b;  // + è l'operatore, a e b sono gli operandi
        
        System.out.println("int result = a + b;");
        System.out.println("  → + è l'OPERATORE");
        System.out.println("  → a e b sono gli OPERANDI");
        System.out.println("  → result = " + result + "\n");
        
        printSubSection("Classificazione degli Operatori");
        
        System.out.println("Gli operatori Java si classificano in base al numero di operandi:\n");
        
        System.out.println("1. UNARI (1 operando):");
        System.out.println("   ++, --, +, -, !, ~");
        System.out.println("   Esempio: ++x, -y, !flag\n");
        
        System.out.println("2. BINARI (2 operandi):");
        System.out.println("   +, -, *, /, %, ==, !=, >, <, &&, ||, ecc.");
        System.out.println("   Esempio: x + y, a > b, flag1 && flag2\n");
        
        System.out.println("3. TERNARI (3 operandi):");
        System.out.println("   ? : (operatore condizionale)");
        System.out.println("   Esempio: result = (x > y) ? x : y;\n");
        
        printSubSection("Categorie di Operatori in Java");
        
        System.out.println("┌──────────────────────────┬──────────────────────────────────┐");
        System.out.println("│       CATEGORIA          │         OPERATORI                │");
        System.out.println("├──────────────────────────┼──────────────────────────────────┤");
        System.out.println("│ Assegnamento             │ =, +=, -=, *=, /=, %=, ecc.      │");
        System.out.println("│ Aritmetici               │ +, -, *, /, %                    │");
        System.out.println("│ Unari                    │ ++, --, +, -, !, ~               │");
        System.out.println("│ Relazionali              │ ==, !=, >, <, >=, <=             │");
        System.out.println("│ Logici                   │ &&, ||, !                        │");
        System.out.println("│ Bitwise                  │ &, |, ^, ~, <<, >>, >>>          │");
        System.out.println("│ Ternario                 │ ? :                              │");
        System.out.println("│ Type Casting             │ (type), instanceof               │");
        System.out.println("└──────────────────────────┴──────────────────────────────────┘\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 2: Operatori di Assegnamento
     * 
     * Gli operatori di assegnamento assegnano valori alle variabili.
     * L'operatore base è =, ma esistono forme combinate per convenienza.
     */
    private static void demoAssignmentOperators() {
        printSection("2. OPERATORI DI ASSEGNAMENTO (ASSIGNMENT)");
        
        System.out.println("Gli operatori di assegnamento assegnano un valore a una variabile.");
        System.out.println("L'operatore base è = (uguale), ma ci sono forme composite.\n");
        
        printSubSection("Assegnamento Semplice (=)");
        
        int x = 10;
        int y = 20;
        int z = x + y;
        
        System.out.println("int x = 10;      → Assegna 10 a x");
        System.out.println("int y = 20;      → Assegna 20 a y");
        System.out.println("int z = x + y;   → Assegna " + z + " a z\n");
        
        printSubSection("Assegnamenti Composti");
        
        System.out.println("Gli operatori composti combinano un'operazione con l'assegnamento:\n");
        
        // +=
        int a = 10;
        System.out.println("int a = 10;");
        a += 5;  // Equivalente a: a = a + 5
        System.out.println("a += 5;          → a = " + a + " (equivalente a: a = a + 5)\n");
        
        // -=
        int b = 20;
        System.out.println("int b = 20;");
        b -= 3;  // Equivalente a: b = b - 3
        System.out.println("b -= 3;          → b = " + b + " (equivalente a: b = b - 3)\n");
        
        // *=
        int c = 5;
        System.out.println("int c = 5;");
        c *= 4;  // Equivalente a: c = c * 4
        System.out.println("c *= 4;          → c = " + c + " (equivalente a: c = c * 4)\n");
        
        // /=
        int d = 20;
        System.out.println("int d = 20;");
        d /= 4;  // Equivalente a: d = d / 4
        System.out.println("d /= 4;          → d = " + d + " (equivalente a: d = d / 4)\n");
        
        // %=
        int e = 17;
        System.out.println("int e = 17;");
        e %= 5;  // Equivalente a: e = e % 5
        System.out.println("e %= 5;          → e = " + e + " (equivalente a: e = e % 5)\n");
        
        printSubSection("Tabella Completa degli Operatori di Assegnamento");
        
        System.out.println("┌────────────┬───────────────────────┬──────────────────┐");
        System.out.println("│  OPERATORE │   ESEMPIO             │   EQUIVALENTE    │");
        System.out.println("├────────────┼───────────────────────┼──────────────────┤");
        System.out.println("│     =      │   x = 5               │   x = 5          │");
        System.out.println("│    +=      │   x += 3              │   x = x + 3      │");
        System.out.println("│    -=      │   x -= 3              │   x = x - 3      │");
        System.out.println("│    *=      │   x *= 3              │   x = x * 3      │");
        System.out.println("│    /=      │   x /= 3              │   x = x / 3      │");
        System.out.println("│    %=      │   x %= 3              │   x = x % 3      │");
        System.out.println("│    &=      │   x &= 3              │   x = x & 3      │");
        System.out.println("│    |=      │   x |= 3              │   x = x | 3      │");
        System.out.println("│    ^=      │   x ^= 3              │   x = x ^ 3      │");
        System.out.println("│   <<=      │   x <<= 2             │   x = x << 2     │");
        System.out.println("│   >>=      │   x >>= 2             │   x = x >> 2     │");
        System.out.println("│  >>>=      │   x >>>= 2            │   x = x >>> 2    │");
        System.out.println("└────────────┴───────────────────────┴──────────────────┘\n");
        
        printSubSection("⚠️ Attenzione: L'Assegnamento Restituisce un Valore");
        
        int m, n, p;
        m = n = p = 10;  // Assegnamento multiplo (da destra a sinistra)
        
        System.out.println("L'operatore = restituisce il valore assegnato:");
        System.out.println("m = n = p = 10;");
        System.out.println("  → Valutazione: p = 10, poi n = 10, poi m = 10");
        System.out.println("  → m = " + m + ", n = " + n + ", p = " + p + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 3: Operatori Aritmetici
     * 
     * Gli operatori aritmetici eseguono operazioni matematiche di base.
     */
    private static void demoArithmeticOperators() {
        printSection("3. OPERATORI ARITMETICI (ARITHMETIC)");
        
        System.out.println("Gli operatori aritmetici eseguono operazioni matematiche standard.\n");
        
        printSubSection("Operatori Aritmetici Base");
        
        int a = 10;
        int b = 3;
        
        System.out.println("Dati: a = " + a + ", b = " + b + "\n");
        
        // Addizione
        int sum = a + b;
        System.out.println("a + b  = " + sum + "  (Addizione)");
        
        // Sottrazione
        int diff = a - b;
        System.out.println("a - b  = " + diff + "  (Sottrazione)");
        
        // Moltiplicazione
        int prod = a * b;
        System.out.println("a * b  = " + prod + "  (Moltiplicazione)");
        
        // Divisione intera
        int quot = a / b;
        System.out.println("a / b  = " + quot + "  (Divisione intera, tronca la parte decimale)");
        
        // Modulo (resto della divisione)
        int mod = a % b;
        System.out.println("a % b  = " + mod + "  (Modulo/Resto: 10 diviso 3 fa 3 con resto 1)\n");
        
        printSubSection("⚠️ Divisione Intera vs Divisione Decimale");
        
        System.out.println("DIVISIONE INTERA (entrambi int):");
        int intResult = 10 / 3;
        System.out.println("int result = 10 / 3;    → " + intResult + " (parte decimale troncata!)\n");
        
        System.out.println("DIVISIONE DECIMALE (almeno un double):");
        double doubleResult = 10.0 / 3;
        System.out.println("double result = 10.0 / 3;  → " + doubleResult);
        
        double doubleResult2 = 10 / 3.0;
        System.out.println("double result = 10 / 3.0;  → " + doubleResult2);
        
        double doubleResult3 = (double) 10 / 3;
        System.out.println("double result = (double)10 / 3;  → " + doubleResult3 + " (cast esplicito)\n");
        
        printSubSection("⚠️ Divisione per Zero");
        
        System.out.println("INTERI: Divisione per zero causa ArithmeticException");
        try {
            int errorResult = 10 / 0;
            System.out.println("Result: " + errorResult);
        } catch (ArithmeticException e) {
            System.out.println("✗ ArithmeticException: " + e.getMessage() + "\n");
        }
        
        System.out.println("FLOATING-POINT: Divisione per zero produce Infinity");
        double infResult = 10.0 / 0.0;
        System.out.println("10.0 / 0.0 = " + infResult);
        
        double negInfResult = -10.0 / 0.0;
        System.out.println("-10.0 / 0.0 = " + negInfResult);
        
        double nanResult = 0.0 / 0.0;
        System.out.println("0.0 / 0.0 = " + nanResult + " (Not a Number)\n");
        
        printSubSection("Operatore Modulo (%) - Casi d'Uso");
        
        System.out.println("L'operatore % restituisce il RESTO della divisione:\n");
        
        // Verificare se un numero è pari o dispari
        int num = 17;
        System.out.println("Verificare se " + num + " è pari o dispari:");
        if (num % 2 == 0) {
            System.out.println("  → Pari (resto 0)");
        } else {
            System.out.println("  → Dispari (resto 1)\n");
        }
        
        // Ottenere l'ultima cifra
        int number = 12345;
        int lastDigit = number % 10;
        System.out.println("Ultima cifra di " + number + ": " + lastDigit);
        
        // Ciclare tra valori (wrap-around)
        System.out.println("\nCiclare tra 0-6 (giorni della settimana):");
        for (int i = 0; i < 10; i++) {
            System.out.print("Giorno " + i + " → " + (i % 7) + "  ");
        }
        System.out.println("\n");
        
        printSubSection("💡 Operazioni Aritmetiche con Tipi Misti");
        
        System.out.println("Quando si mescolano tipi, Java promuove al tipo \"più grande\":\n");
        
        int intVal = 10;
        double doubleVal = 3.5;
        double mixedResult = intVal + doubleVal;  // int promosso a double
        
        System.out.println("int intVal = 10;");
        System.out.println("double doubleVal = 3.5;");
        System.out.println("double result = intVal + doubleVal;");
        System.out.println("  → " + mixedResult + " (int promosso a double)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 4: Operatori Unari
     * 
     * Gli operatori unari operano su un singolo operando.
     * Include incremento, decremento, negazione.
     */
    private static void demoUnaryOperators() {
        printSection("4. OPERATORI UNARI (UNARY)");
        
        System.out.println("Gli operatori unari operano su UN SOLO operando.\n");
        
        printSubSection("Operatore di Incremento (++)");
        
        System.out.println("L'operatore ++ incrementa di 1 il valore della variabile.\n");
        
        // Post-incremento
        int a = 5;
        System.out.println("int a = 5;");
        int b = a++;  // POST-incremento: prima usa il valore, poi incrementa
        System.out.println("int b = a++;   (POST-incremento)");
        System.out.println("  → b = " + b + " (usa il valore PRIMA di incrementare)");
        System.out.println("  → a = " + a + " (ora a è incrementato)\n");
        
        // Pre-incremento
        int c = 5;
        System.out.println("int c = 5;");
        int d = ++c;  // PRE-incremento: prima incrementa, poi usa il valore
        System.out.println("int d = ++c;   (PRE-incremento)");
        System.out.println("  → d = " + d + " (incrementa PRIMA, poi usa il valore)");
        System.out.println("  → c = " + c + "\n");
        
        printSubSection("Operatore di Decremento (--)");
        
        System.out.println("L'operatore -- decrementa di 1 il valore della variabile.\n");
        
        // Post-decremento
        int e = 10;
        System.out.println("int e = 10;");
        int f = e--;  // POST-decremento
        System.out.println("int f = e--;   (POST-decremento)");
        System.out.println("  → f = " + f + " (usa il valore PRIMA di decrementare)");
        System.out.println("  → e = " + e + " (ora e è decrementato)\n");
        
        // Pre-decremento
        int g = 10;
        System.out.println("int g = 10;");
        int h = --g;  // PRE-decremento
        System.out.println("int h = --g;   (PRE-decremento)");
        System.out.println("  → h = " + h + " (decrementa PRIMA, poi usa il valore)");
        System.out.println("  → g = " + g + "\n");
        
        printSubSection("Confronto: Pre vs Post Incremento/Decremento");
        
        System.out.println("┌─────────────────┬────────────────────────────────────────┐");
        System.out.println("│   OPERATORE     │           COMPORTAMENTO                │");
        System.out.println("├─────────────────┼────────────────────────────────────────┤");
        System.out.println("│   x++           │ POST: usa valore, poi incrementa       │");
        System.out.println("│   ++x           │ PRE: incrementa, poi usa valore        │");
        System.out.println("│   x--           │ POST: usa valore, poi decrementa       │");
        System.out.println("│   --x           │ PRE: decrementa, poi usa valore        │");
        System.out.println("└─────────────────┴────────────────────────────────────────┘\n");
        
        printSubSection("Operatore Unario Plus (+) e Minus (-)");
        
        int positive = 10;
        int negative = -positive;  // Negazione unaria
        int stillPositive = +positive;  // Plus unario (raramente usato)
        
        System.out.println("int positive = 10;");
        System.out.println("int negative = -positive;     → " + negative + " (negazione)");
        System.out.println("int stillPositive = +positive;  → " + stillPositive + " (plus unario, no effect)\n");
        
        printSubSection("Operatore Logico NOT (!)");
        
        boolean flag = true;
        boolean notFlag = !flag;  // Negazione logica
        
        System.out.println("boolean flag = true;");
        System.out.println("boolean notFlag = !flag;   → " + notFlag + " (negazione logica)");
        System.out.println("!true = " + !true);
        System.out.println("!false = " + !false + "\n");
        
        printSubSection("Operatore Bitwise Complement (~)");
        
        int num = 5;  // In binario: 0000 0101
        int complement = ~num;  // Complemento bit-a-bit: 1111 1010 (= -6 in complemento a 2)
        
        System.out.println("int num = 5;       (binario: 0000 0101)");
        System.out.println("int comp = ~num;   → " + complement);
        System.out.println("  (complemento bit-a-bit: tutti i bit invertiti)\n");
        
        printSubSection("⚠️ Errori Comuni con ++ e --");
        
        System.out.println("ATTENZIONE alla differenza tra pre e post incremento:\n");
        
        int x = 5;
        System.out.println("int x = 5;");
        System.out.println("System.out.println(x++);  // Stampa " + x++ + ", poi x diventa 6");
        System.out.println("x è ora: " + x + "\n");
        
        int y = 5;
        System.out.println("int y = 5;");
        System.out.println("System.out.println(++y);  // Incrementa a 6, poi stampa " + ++y);
        System.out.println("y è ora: " + y + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 5: Operatori Relazionali (Comparazione)
     * 
     * Gli operatori relazionali confrontano due valori e restituiscono un boolean.
     */
    private static void demoRelationalOperators() {
        printSection("5. OPERATORI RELAZIONALI (COMPARAZIONE)");
        
        System.out.println("Gli operatori relazionali confrontano due valori.");
        System.out.println("Restituiscono sempre un valore BOOLEAN (true o false).\n");
        
        printSubSection("I Sei Operatori Relazionali");
        
        int a = 10;
        int b = 5;
        int c = 10;
        
        System.out.println("Dati: a = " + a + ", b = " + b + ", c = " + c + "\n");
        
        // Uguale a (==)
        System.out.println("a == b  →  " + (a == b) + "  (uguale a)");
        System.out.println("a == c  →  " + (a == c) + "  (uguale a)");
        
        // Diverso da (!=)
        System.out.println("a != b  →  " + (a != b) + "  (diverso da)");
        System.out.println("a != c  →  " + (a != c) + "  (diverso da)");
        
        // Maggiore di (>)
        System.out.println("a > b   →  " + (a > b) + "   (maggiore di)");
        System.out.println("b > a   →  " + (b > a) + "  (maggiore di)");
        
        // Minore di (<)
        System.out.println("a < b   →  " + (a < b) + "  (minore di)");
        System.out.println("b < a   →  " + (b < a) + "   (minore di)");
        
        // Maggiore o uguale (>=)
        System.out.println("a >= b  →  " + (a >= b) + "   (maggiore o uguale)");
        System.out.println("a >= c  →  " + (a >= c) + "   (maggiore o uguale)");
        
        // Minore o uguale (<=)
        System.out.println("a <= b  →  " + (a <= b) + "  (minore o uguale)");
        System.out.println("a <= c  →  " + (a <= c) + "   (minore o uguale)\n");
        
        printSubSection("Tabella degli Operatori Relazionali");
        
        System.out.println("┌────────────┬─────────────────────────┬──────────────────┐");
        System.out.println("│  OPERATORE │      DESCRIZIONE        │     ESEMPIO      │");
        System.out.println("├────────────┼─────────────────────────┼──────────────────┤");
        System.out.println("│     ==     │ Uguale a                │ 5 == 5 → true    │");
        System.out.println("│     !=     │ Diverso da              │ 5 != 3 → true    │");
        System.out.println("│     >      │ Maggiore di             │ 5 > 3 → true     │");
        System.out.println("│     <      │ Minore di               │ 5 < 3 → false    │");
        System.out.println("│     >=     │ Maggiore o uguale       │ 5 >= 5 → true    │");
        System.out.println("│     <=     │ Minore o uguale         │ 5 <= 3 → false   │");
        System.out.println("└────────────┴─────────────────────────┴──────────────────┘\n");
        
        printSubSection("Uso nelle Condizioni");
        
        int age = 18;
        System.out.println("int age = " + age + ";");
        
        if (age >= 18) {
            System.out.println("if (age >= 18) → true");
            System.out.println("  → Maggiorenne\n");
        }
        
        int score = 75;
        System.out.println("int score = " + score + ";");
        
        if (score >= 60) {
            System.out.println("if (score >= 60) → true");
            System.out.println("  → Promosso\n");
        }
        
        printSubSection("⚠️ Attenzione: == vs .equals()");
        
        System.out.println("Per i PRIMITIVI, usa == per confrontare valori:");
        int x = 10;
        int y = 10;
        System.out.println("int x = 10, y = 10;");
        System.out.println("x == y  →  " + (x == y) + " ✓ Corretto per primitivi\n");
        
        System.out.println("Per gli OGGETTI (String, Integer, ecc.), usa .equals():");
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("String s1 = new String(\"hello\");");
        System.out.println("String s2 = new String(\"hello\");");
        System.out.println("s1 == s2       →  " + (s1 == s2) + " (confronta riferimenti)");
        System.out.println("s1.equals(s2)  →  " + s1.equals(s2) + " (confronta contenuti) ✓\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 6: Operatori Logici
     * 
     * Gli operatori logici operano su valori boolean e restituiscono boolean.
     * Usati per combinare condizioni.
     */
    private static void demoLogicalOperators() {
        printSection("6. OPERATORI LOGICI (LOGICAL)");
        
        System.out.println("Gli operatori logici operano su valori BOOLEAN.");
        System.out.println("Usati per combinare condizioni multiple.\n");
        
        printSubSection("I Tre Operatori Logici Principali");
        
        boolean t = true;
        boolean f = false;
        
        System.out.println("Dati: t = true, f = false\n");
        
        // AND logico (&&)
        System.out.println("AND LOGICO (&&) - Vero solo se ENTRAMBI sono veri:");
        System.out.println("t && t  →  " + (t && t) + "   (true AND true)");
        System.out.println("t && f  →  " + (t && f) + "  (true AND false)");
        System.out.println("f && t  →  " + (f && t) + "  (false AND true)");
        System.out.println("f && f  →  " + (f && f) + "  (false AND false)\n");
        
        // OR logico (||)
        System.out.println("OR LOGICO (||) - Vero se ALMENO UNO è vero:");
        System.out.println("t || t  →  " + (t || t) + "   (true OR true)");
        System.out.println("t || f  →  " + (t || f) + "   (true OR false)");
        System.out.println("f || t  →  " + (f || t) + "   (false OR true)");
        System.out.println("f || f  →  " + (f || f) + "  (false OR false)\n");
        
        // NOT logico (!)
        System.out.println("NOT LOGICO (!) - Inverte il valore:");
        System.out.println("!t      →  " + !t + "  (NOT true)");
        System.out.println("!f      →  " + !f + "   (NOT false)\n");
        
        printSubSection("Tabelle di Verità");
        
        System.out.println("TABELLA AND (&&):");
        System.out.println("┌───────┬───────┬──────────┐");
        System.out.println("│   A   │   B   │  A && B  │");
        System.out.println("├───────┼───────┼──────────┤");
        System.out.println("│ true  │ true  │   true   │");
        System.out.println("│ true  │ false │   false  │");
        System.out.println("│ false │ true  │   false  │");
        System.out.println("│ false │ false │   false  │");
        System.out.println("└───────┴───────┴──────────┘\n");
        
        System.out.println("TABELLA OR (||):");
        System.out.println("┌───────┬───────┬──────────┐");
        System.out.println("│   A   │   B   │  A || B  │");
        System.out.println("├───────┼───────┼──────────┤");
        System.out.println("│ true  │ true  │   true   │");
        System.out.println("│ true  │ false │   true   │");
        System.out.println("│ false │ true  │   true   │");
        System.out.println("│ false │ false │   false  │");
        System.out.println("└───────┴───────┴──────────┘\n");
        
        printSubSection("Uso Pratico nelle Condizioni");
        
        int age = 25;
        boolean hasLicense = true;
        
        System.out.println("int age = " + age + ";");
        System.out.println("boolean hasLicense = " + hasLicense + ";\n");
        
        // AND - entrambe le condizioni devono essere vere
        if (age >= 18 && hasLicense) {
            System.out.println("if (age >= 18 && hasLicense)  →  true");
            System.out.println("  → Può guidare (ha età E patente)\n");
        }
        
        // OR - almeno una condizione deve essere vera
        boolean isWeekend = false;
        boolean isHoliday = true;
        System.out.println("boolean isWeekend = " + isWeekend + ";");
        System.out.println("boolean isHoliday = " + isHoliday + ";\n");
        
        if (isWeekend || isHoliday) {
            System.out.println("if (isWeekend || isHoliday)  →  true");
            System.out.println("  → Giorno di riposo (weekend O festivo)\n");
        }
        
        // NOT - inverte la condizione
        boolean isRaining = false;
        System.out.println("boolean isRaining = " + isRaining + ";");
        
        if (!isRaining) {
            System.out.println("if (!isRaining)  →  true");
            System.out.println("  → Bel tempo (non piove)\n");
        }
        
        printSubSection("⚠️ Short-Circuit Evaluation (Valutazione Cortocircuitata)");
        
        System.out.println("Gli operatori && e || usano 'short-circuit evaluation':");
        System.out.println("Se il risultato è già determinato dal primo operando,");
        System.out.println("il secondo operando NON viene valutato.\n");
        
        System.out.println("AND (&&): Se il primo è FALSE, il secondo non viene valutato");
        boolean result1 = false && expensiveOperation();
        System.out.println("false && expensiveOperation()  →  " + result1);
        System.out.println("  → expensiveOperation() NON chiamato (short-circuit)\n");
        
        System.out.println("OR (||): Se il primo è TRUE, il secondo non viene valutato");
        boolean result2 = true || expensiveOperation();
        System.out.println("true || expensiveOperation()  →  " + result2);
        System.out.println("  → expensiveOperation() NON chiamato (short-circuit)\n");
        
        printSubSection("Operatori Bitwise Logici (NON Short-Circuit)");
        
        System.out.println("& e | sono operatori BITWISE, ma funzionano anche con boolean:");
        System.out.println("Differenza: NON usano short-circuit, valutano ENTRAMBI gli operandi\n");
        
        System.out.println("true & false   →  " + (true & false) + " (AND bitwise, no short-circuit)");
        System.out.println("true | false   →  " + (true | false) + " (OR bitwise, no short-circuit)");
        System.out.println("true ^ false   →  " + (true ^ false) + " (XOR - vero se DIVERSI)\n");
        
        System.out.println("💡 BEST PRACTICE: Usa && e || per condizioni (più efficienti)\n");
        
        waitForEnter();
    }

    /**
     * Metodo simulato per dimostrare lo short-circuit
     */
    private static boolean expensiveOperation() {
        System.out.println("  [expensiveOperation() chiamato!]");
        return true;
    }

    /**
     * SEZIONE 7: Operatori Bitwise (Bit-Level)
     * 
     * Gli operatori bitwise operano sui singoli bit dei numeri interi.
     * Utili per operazioni a basso livello, flag, maschere.
     */
    private static void demoBitwiseOperators() {
        printSection("7. OPERATORI BITWISE (BIT-LEVEL)");
        
        System.out.println("Gli operatori bitwise operano sui SINGOLI BIT dei numeri interi.");
        System.out.println("Utili per operazioni a basso livello, flag, maschere di bit.\n");
        
        printSubSection("Operatori Bitwise Base");
        
        int a = 5;   // In binario: 0000 0101
        int b = 3;   // In binario: 0000 0011
        
        System.out.println("int a = 5;   // Binario: 0000 0101");
        System.out.println("int b = 3;   // Binario: 0000 0011\n");
        
        // AND bitwise (&)
        int andResult = a & b;  // 0000 0001 = 1
        System.out.println("a & b  = " + andResult + "  (AND bitwise)");
        System.out.println("  0000 0101  (5)");
        System.out.println("& 0000 0011  (3)");
        System.out.println("  ---------");
        System.out.println("  0000 0001  (1) → Bit a 1 solo dove ENTRAMBI sono 1\n");
        
        // OR bitwise (|)
        int orResult = a | b;  // 0000 0111 = 7
        System.out.println("a | b  = " + orResult + "  (OR bitwise)");
        System.out.println("  0000 0101  (5)");
        System.out.println("| 0000 0011  (3)");
        System.out.println("  ---------");
        System.out.println("  0000 0111  (7) → Bit a 1 dove ALMENO UNO è 1\n");
        
        // XOR bitwise (^)
        int xorResult = a ^ b;  // 0000 0110 = 6
        System.out.println("a ^ b  = " + xorResult + "  (XOR bitwise - exclusive OR)");
        System.out.println("  0000 0101  (5)");
        System.out.println("^ 0000 0011  (3)");
        System.out.println("  ---------");
        System.out.println("  0000 0110  (6) → Bit a 1 solo dove sono DIVERSI\n");
        
        // NOT bitwise (~)
        int notResult = ~a;  // Inverte tutti i bit
        System.out.println("~a     = " + notResult + " (NOT bitwise - complemento)");
        System.out.println("  ~0000 0101 = 1111 1010 (in complemento a 2 = -6)\n");
        
        printSubSection("Operatori di Shift (Scorrimento Bit)");
        
        int num = 8;  // Binario: 0000 1000
        System.out.println("int num = 8;  // Binario: 0000 1000\n");
        
        // Left shift (<<) - scorre i bit a sinistra
        int leftShift = num << 2;  // 0010 0000 = 32
        System.out.println("num << 2  = " + leftShift + " (shift sinistro di 2 posizioni)");
        System.out.println("  0000 1000 (8)");
        System.out.println("  << 2");
        System.out.println("  0010 0000 (32) → Equivale a moltiplicare per 2^2 = 4\n");
        
        // Right shift (>>) - scorre i bit a destra (preserva il segno)
        int rightShift = num >> 2;  // 0000 0010 = 2
        System.out.println("num >> 2  = " + rightShift + " (shift destro di 2 posizioni, con segno)");
        System.out.println("  0000 1000 (8)");
        System.out.println("  >> 2");
        System.out.println("  0000 0010 (2) → Equivale a dividere per 2^2 = 4\n");
        
        // Unsigned right shift (>>>) - scorre a destra riempiendo con 0
        int negNum = -8;
        int unsignedShift = negNum >>> 2;
        System.out.println("int negNum = -8;");
        System.out.println("negNum >>> 2  = " + unsignedShift + " (shift destro SENZA segno)");
        System.out.println("  >>> riempie sempre con 0 a sinistra (ignora il segno)\n");
        
        printSubSection("Tabella Operatori Bitwise");
        
        System.out.println("┌────────────┬─────────────────────────────────────────────┐");
        System.out.println("│  OPERATORE │           DESCRIZIONE                       │");
        System.out.println("├────────────┼─────────────────────────────────────────────┤");
        System.out.println("│     &      │ AND bitwise (1 se entrambi 1)               │");
        System.out.println("│     |      │ OR bitwise (1 se almeno uno 1)              │");
        System.out.println("│     ^      │ XOR bitwise (1 se diversi)                  │");
        System.out.println("│     ~      │ NOT bitwise (inverte tutti i bit)           │");
        System.out.println("│    <<      │ Left shift (scorre a sinistra)              │");
        System.out.println("│    >>      │ Right shift (scorre a destra, con segno)    │");
        System.out.println("│   >>>      │ Unsigned right shift (scorre, riempie con 0)│");
        System.out.println("└────────────┴─────────────────────────────────────────────┘\n");
        
        printSubSection("💡 Casi d'Uso Pratici");
        
        System.out.println("1. MOLTIPLICAZIONE/DIVISIONE VELOCE per potenze di 2:");
        int value = 10;
        System.out.println("   " + value + " << 1 = " + (value << 1) + " (moltiplicare per 2)");
        System.out.println("   " + value + " << 3 = " + (value << 3) + " (moltiplicare per 8)");
        System.out.println("   " + value + " >> 1 = " + (value >> 1) + " (dividere per 2)\n");
        
        System.out.println("2. GESTIONE FLAG (più flag in un solo int):");
        final int READ = 1 << 0;    // 0001 = 1
        final int WRITE = 1 << 1;   // 0010 = 2
        final int EXECUTE = 1 << 2; // 0100 = 4
        
        int permissions = READ | WRITE;  // Combina flag
        System.out.println("   READ = " + READ + ", WRITE = " + WRITE + ", EXECUTE = " + EXECUTE);
        System.out.println("   permissions = READ | WRITE = " + permissions);
        System.out.println("   Ha permesso READ? " + ((permissions & READ) != 0));
        System.out.println("   Ha permesso WRITE? " + ((permissions & WRITE) != 0));
        System.out.println("   Ha permesso EXECUTE? " + ((permissions & EXECUTE) != 0) + "\n");
        
        System.out.println("3. MASCHERE DI BIT (estrarre bit specifici):");
        int color = 0xFF5733;  // Colore RGB
        int red = (color >> 16) & 0xFF;   // Estrae byte rosso
        int green = (color >> 8) & 0xFF;  // Estrae byte verde
        int blue = color & 0xFF;          // Estrae byte blu
        System.out.println("   Color = 0xFF5733");
        System.out.println("   Red   = " + red + " (0x" + Integer.toHexString(red) + ")");
        System.out.println("   Green = " + green + " (0x" + Integer.toHexString(green) + ")");
        System.out.println("   Blue  = " + blue + " (0x" + Integer.toHexString(blue) + ")\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 8: Operatore Ternario (Condizionale)
     * 
     * L'operatore ternario è l'unico operatore che prende tre operandi.
     * È una forma compatta di if-else.
     */
    private static void demoTernaryOperator() {
        printSection("8. OPERATORE TERNARIO (CONDITIONAL)");
        
        System.out.println("L'operatore ternario è l'UNICO operatore con TRE operandi.");
        System.out.println("Sintassi: condizione ? valore_se_vero : valore_se_falso\n");
        
        printSubSection("Sintassi e Funzionamento");
        
        int a = 10;
        int b = 5;
        
        System.out.println("int a = " + a + ", b = " + b + ";\n");
        
        // Trova il massimo tra due numeri
        int max = (a > b) ? a : b;
        System.out.println("int max = (a > b) ? a : b;");
        System.out.println("  → Condizione: a > b → " + (a > b));
        System.out.println("  → Valore restituito: " + max + " (a, perché a > b è true)\n");
        
        int min = (a < b) ? a : b;
        System.out.println("int min = (a < b) ? a : b;");
        System.out.println("  → Condizione: a < b → " + (a < b));
        System.out.println("  → Valore restituito: " + min + " (b, perché a < b è false)\n");
        
        printSubSection("Equivalenza con if-else");
        
        System.out.println("L'operatore ternario è equivalente a if-else:\n");
        
        System.out.println("CON OPERATORE TERNARIO:");
        System.out.println("  int result = (a > b) ? a : b;\n");
        
        System.out.println("EQUIVALENTE CON IF-ELSE:");
        System.out.println("  int result;");
        System.out.println("  if (a > b) {");
        System.out.println("      result = a;");
        System.out.println("  } else {");
        System.out.println("      result = b;");
        System.out.println("  }\n");
        
        printSubSection("Esempi Pratici");
        
        // Determinare se un numero è pari o dispari
        int number = 17;
        String parity = (number % 2 == 0) ? "pari" : "dispari";
        System.out.println("int number = " + number + ";");
        System.out.println("String parity = (number % 2 == 0) ? \"pari\" : \"dispari\";");
        System.out.println("  → " + parity + "\n");
        
        // Determinare il voto
        int score = 75;
        String grade = (score >= 60) ? "Promosso" : "Bocciato";
        System.out.println("int score = " + score + ";");
        System.out.println("String grade = (score >= 60) ? \"Promosso\" : \"Bocciato\";");
        System.out.println("  → " + grade + "\n");
        
        // Valore assoluto
        int value = -42;
        int absolute = (value >= 0) ? value : -value;
        System.out.println("int value = " + value + ";");
        System.out.println("int absolute = (value >= 0) ? value : -value;");
        System.out.println("  → " + absolute + "\n");
        
        printSubSection("Operatori Ternari Annidati");
        
        System.out.println("È possibile annidare operatori ternari (ma attenzione alla leggibilità!):\n");
        
        int points = 85;
        String level = (points >= 90) ? "A" :
                       (points >= 80) ? "B" :
                       (points >= 70) ? "C" :
                       (points >= 60) ? "D" : "F";
        
        System.out.println("int points = " + points + ";");
        System.out.println("String level = (points >= 90) ? \"A\" :");
        System.out.println("               (points >= 80) ? \"B\" :");
        System.out.println("               (points >= 70) ? \"C\" :");
        System.out.println("               (points >= 60) ? \"D\" : \"F\";");
        System.out.println("  → Livello: " + level + "\n");
        
        printSubSection("⚠️ Best Practices");
        
        System.out.println("✓ USA l'operatore ternario per assegnazioni semplici e condizionali");
        System.out.println("✓ Migliora la leggibilità per espressioni brevi");
        System.out.println("✓ Metti sempre la condizione tra parentesi per chiarezza\n");
        
        System.out.println("✗ EVITA annidamenti complessi (difficile da leggere)");
        System.out.println("✗ EVITA per logica complessa (usa if-else)");
        System.out.println("✗ EVITA side-effects nei branch (chiamate a metodi che modificano stato)\n");
        
        System.out.println("💡 REGOLA: Se richiede più di una riga, usa if-else invece del ternario!\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 9: Type Casting - Conversioni Implicite (Widening)
     * 
     * Il widening casting è automatico quando si converte da un tipo più piccolo
     * a uno più grande. Non c'è perdita di dati.
     */
    private static void demoWideningCasting() {
        printSection("9. TYPE CASTING - CONVERSIONI IMPLICITE (WIDENING)");
        
        System.out.println("Il WIDENING CASTING è la conversione AUTOMATICA da un tipo più piccolo");
        System.out.println("a uno più grande. Non richiede cast esplicito e non perde dati.\n");
        
        printSubSection("Gerarchia dei Tipi Numerici (dal più piccolo al più grande)");
        
        System.out.println("byte → short → int → long → float → double");
        System.out.println("       char  → int\n");
        
        System.out.println("Il casting è AUTOMATICO se si va da sinistra a destra.\n");
        
        printSubSection("Esempi di Widening Casting Automatico");
        
        // byte → int
        byte byteVal = 100;
        int intVal = byteVal;  // Automatico
        System.out.println("byte byteVal = 100;");
        System.out.println("int intVal = byteVal;   → " + intVal + " (byte → int, automatico)\n");
        
        // int → long
        int intVal2 = 1000;
        long longVal = intVal2;  // Automatico
        System.out.println("int intVal2 = 1000;");
        System.out.println("long longVal = intVal2;  → " + longVal + " (int → long, automatico)\n");
        
        // long → float
        long longVal2 = 100000L;
        float floatVal = longVal2;  // Automatico
        System.out.println("long longVal2 = 100000L;");
        System.out.println("float floatVal = longVal2;  → " + floatVal + " (long → float, automatico)\n");
        
        // float → double
        float floatVal2 = 3.14F;
        double doubleVal = floatVal2;  // Automatico
        System.out.println("float floatVal2 = 3.14F;");
        System.out.println("double doubleVal = floatVal2;  → " + doubleVal + " (float → double, automatico)\n");
        
        // char → int
        char charVal = 'A';
        int charAsInt = charVal;  // Automatico, ottiene il codice Unicode
        System.out.println("char charVal = 'A';");
        System.out.println("int charAsInt = charVal;  → " + charAsInt + " (char → int, codice Unicode)\n");
        
        printSubSection("Widening in Espressioni");
        
        System.out.println("Durante le operazioni, Java promuove automaticamente al tipo \"più grande\":\n");
        
        byte b = 10;
        int i = 20;
        long l = 30L;
        
        // Nell'espressione, byte e int vengono promossi a long
        long result = b + i + l;
        
        System.out.println("byte b = 10;");
        System.out.println("int i = 20;");
        System.out.println("long l = 30L;");
        System.out.println("long result = b + i + l;  → " + result);
        System.out.println("  (byte e int promossi automaticamente a long)\n");
        
        int i2 = 10;
        double d = 3.5;
        double result2 = i2 + d;  // int promosso a double
        
        System.out.println("int i2 = 10;");
        System.out.println("double d = 3.5;");
        System.out.println("double result2 = i2 + d;  → " + result2);
        System.out.println("  (int promosso automaticamente a double)\n");
        
        printSubSection("💡 Vantaggi del Widening Casting");
        
        System.out.println("✓ AUTOMATICO (nessun cast esplicito richiesto)");
        System.out.println("✓ SICURO (nessuna perdita di dati)");
        System.out.println("✓ TRASPARENTE (il compilatore lo gestisce)\n");
        
        printSubSection("⚠️ Attenzione: Precisione con float");
        
        long bigLong = 123456789012345L;
        float floatFromLong = bigLong;  // Automatico, MA può perdere precisione
        
        System.out.println("long bigLong = 123456789012345L;");
        System.out.println("float floatFromLong = bigLong;");
        System.out.println("  → " + floatFromLong);
        System.out.println("  ⚠️ float ha solo ~7 cifre significative, può perdere precisione!\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 10: Type Casting - Conversioni Esplicite (Narrowing)
     * 
     * Il narrowing casting è richiesto quando si converte da un tipo più grande
     * a uno più piccolo. Può causare perdita di dati.
     */
    private static void demoNarrowingCasting() {
        printSection("10. TYPE CASTING - CONVERSIONI ESPLICITE (NARROWING)");
        
        System.out.println("Il NARROWING CASTING è la conversione da un tipo più grande a uno più piccolo.");
        System.out.println("Richiede un CAST ESPLICITO e può causare PERDITA DI DATI.\n");
        
        printSubSection("Sintassi del Cast Esplicito");
        
        System.out.println("Sintassi: (tipo_destinazione) valore\n");
        
        double doubleVal = 9.78;
        int intVal = (int) doubleVal;  // Cast esplicito richiesto
        
        System.out.println("double doubleVal = 9.78;");
        System.out.println("int intVal = (int) doubleVal;");
        System.out.println("  → " + intVal + " (parte decimale TRONCATA, non arrotondata!)\n");
        
        printSubSection("Esempi di Narrowing Casting");
        
        // double → int (perde parte decimale)
        double d = 123.456;
        int i = (int) d;
        System.out.println("double d = 123.456;");
        System.out.println("int i = (int) d;  → " + i + " (parte decimale persa)\n");
        
        // long → int (può perdere dati se troppo grande)
        long l = 100L;
        int i2 = (int) l;
        System.out.println("long l = 100L;");
        System.out.println("int i2 = (int) l;  → " + i2 + " (OK, dentro range int)\n");
        
        // int → byte (può perdere dati se fuori range byte)
        int i3 = 128;  // Fuori range byte (-128 to 127)
        byte b = (byte) i3;
        System.out.println("int i3 = 128;");
        System.out.println("byte b = (byte) i3;  → " + b + " (fuori range byte, overflow!)\n");
        
        // int → char
        int i4 = 65;
        char c = (char) i4;
        System.out.println("int i4 = 65;");
        System.out.println("char c = (char) i4;  → '" + c + "' (codice Unicode 65 = 'A')\n");
        
        printSubSection("⚠️ Perdita di Dati con Narrowing");
        
        System.out.println("ESEMPIO 1: Parte decimale troncata");
        double price = 19.99;
        int wholePart = (int) price;
        System.out.println("double price = 19.99;");
        System.out.println("int wholePart = (int) price;  → " + wholePart);
        System.out.println("  ⚠️ Persi: 0.99 (troncato, NON arrotondato!)\n");
        
        System.out.println("ESEMPIO 2: Overflow con valori fuori range");
        int bigInt = 200;  // Fuori range byte (-128 to 127)
        byte smallByte = (byte) bigInt;
        System.out.println("int bigInt = 200;");
        System.out.println("byte smallByte = (byte) bigInt;  → " + smallByte);
        System.out.println("  ⚠️ Overflow! 200 non sta in un byte, risultato imprevedibile\n");
        
        System.out.println("ESEMPIO 3: Perdita di informazione con long → int");
        long hugeLong = 3_000_000_000L;  // Fuori range int (max ~2.1 miliardi)
        int hugeInt = (int) hugeLong;
        System.out.println("long hugeLong = 3_000_000_000L;");
        System.out.println("int hugeInt = (int) hugeLong;  → " + hugeInt);
        System.out.println("  ⚠️ Fuori range int, overflow!\n");
        
        printSubSection("💡 Come Gestire il Narrowing in Modo Sicuro");
        
        System.out.println("1. VERIFICA il range prima del cast:");
        long valueLong = 100L;
        if (valueLong >= Integer.MIN_VALUE && valueLong <= Integer.MAX_VALUE) {
            int safeInt = (int) valueLong;
            System.out.println("   Cast sicuro: " + safeInt + " ✓\n");
        }
        
        System.out.println("2. USA Math.round() per arrotondare double/float → int:");
        double decimal = 9.7;
        int rounded = (int) Math.round(decimal);
        System.out.println("   double decimal = 9.7;");
        System.out.println("   int rounded = (int) Math.round(decimal);  → " + rounded + " (arrotondato)\n");
        
        System.out.println("3. USA wrapper methods per conversioni sicure:");
        String numStr = "12345";
        int parsed = Integer.parseInt(numStr);
        System.out.println("   String numStr = \"12345\";");
        System.out.println("   int parsed = Integer.parseInt(numStr);  → " + parsed + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 11: Type Casting con Oggetti
     * 
     * Il casting si applica anche agli oggetti in una gerarchia di ereditarietà.
     */
    private static void demoObjectCasting() {
        printSection("11. TYPE CASTING CON OGGETTI");
        
        System.out.println("Il casting funziona anche con OGGETTI in gerarchie di ereditarietà.");
        System.out.println("Upcasting (verso superclasse) è automatico, downcasting (verso sottoclasse) è esplicito.\n");
        
        printSubSection("Upcasting (Automatico)");
        
        System.out.println("Upcasting: sottoclasse → superclasse (sempre sicuro, automatico)\n");
        
        System.out.println("Integer intObj = 100;");
        System.out.println("Number numObj = intObj;  // Upcasting automatico (Integer → Number)");
        System.out.println("Object objObj = intObj;  // Upcasting automatico (Integer → Object)\n");
        
        Integer intObj = 100;
        Number numObj = intObj;  // Upcasting automatico
        Object objObj = intObj;  // Upcasting automatico
        
        System.out.println("intObj = " + intObj);
        System.out.println("numObj = " + numObj);
        System.out.println("objObj = " + objObj + "\n");
        
        printSubSection("Downcasting (Esplicito)");
        
        System.out.println("Downcasting: superclasse → sottoclasse (richiede cast, può fallire!)\n");
        
        Object obj = "Hello";  // Stringa in Object
        
        // Downcasting corretto
        if (obj instanceof String) {
            String str = (String) obj;  // Cast esplicito
            System.out.println("Object obj = \"Hello\";");
            System.out.println("String str = (String) obj;  → " + str + " ✓ OK\n");
        }
        
        printSubSection("⚠️ ClassCastException");
        
        System.out.println("Downcasting ERRATO causa ClassCastException:\n");
        
        Object obj2 = "Hello";
        try {
            Integer wrongCast = (Integer) obj2;  // ✗ String non può essere Integer!
            System.out.println("Result: " + wrongCast);
        } catch (ClassCastException e) {
            System.out.println("Object obj2 = \"Hello\";");
            System.out.println("Integer wrongCast = (Integer) obj2;");
            System.out.println("✗ ClassCastException: " + e.getMessage() + "\n");
        }
        
        printSubSection("Operatore instanceof (Verifica Prima di Castare)");
        
        System.out.println("USA instanceof per verificare il tipo prima del downcasting:\n");
        
        Object[] objects = {100, "Hello", 3.14, true};
        
        for (Object o : objects) {
            System.out.print("Oggetto: " + o + " → ");
            
            if (o instanceof Integer) {
                Integer i = (Integer) o;
                System.out.println("Integer (valore: " + i + ")");
            } else if (o instanceof String) {
                String s = (String) o;
                System.out.println("String (lunghezza: " + s.length() + ")");
            } else if (o instanceof Double) {
                Double d = (Double) o;
                System.out.println("Double (valore: " + d + ")");
            } else if (o instanceof Boolean) {
                Boolean bool = (Boolean) o;
                System.out.println("Boolean (valore: " + bool + ")");
            }
        }
        System.out.println();
        
        printSubSection("💡 Best Practices con Object Casting");
        
        System.out.println("✓ USA instanceof prima di every downcasting");
        System.out.println("✓ EVITA cast non necessari");
        System.out.println("✓ PREFERISCI generics (<T>) invece di Object quando possibile");
        System.out.println("✓ DOCUMENTA i cast espliciti con commenti esplicativi\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 12: Precedenza degli Operatori
     * 
     * La precedenza determina l'ordine di valutazione in espressioni complesse.
     */
    private static void demoOperatorPrecedence() {
        printSection("12. PRECEDENZA DEGLI OPERATORI");
        
        System.out.println("La PRECEDENZA degli operatori determina l'ORDINE di valutazione");
        System.out.println("quando più operatori appaiono nella stessa espressione.\n");
        
        printSubSection("Esempio Base di Precedenza");
        
        int result = 2 + 3 * 4;  // * ha precedenza su +
        System.out.println("int result = 2 + 3 * 4;");
        System.out.println("  → Valutato come: 2 + (3 * 4)");
        System.out.println("  → Risultato: " + result + " (non 20!)\n");
        
        int result2 = (2 + 3) * 4;  // Parentesi hanno massima precedenza
        System.out.println("int result2 = (2 + 3) * 4;");
        System.out.println("  → Valutato come: (2 + 3) * 4");
        System.out.println("  → Risultato: " + result2 + "\n");
        
        printSubSection("Tabella di Precedenza (da alta a bassa)");
        
        System.out.println("┌──────┬────────────────────────────┬─────────────────────────┐");
        System.out.println("│ PREC.│       OPERATORI            │      ASSOCIATIVITÀ      │");
        System.out.println("├──────┼────────────────────────────┼─────────────────────────┤");
        System.out.println("│  1   │ Postfix: x++, x--          │  Sinistra → Destra      │");
        System.out.println("│  2   │ Unari: ++x, --x, +, -, !, ~│  Destra → Sinistra      │");
        System.out.println("│  3   │ Casting: (type)            │  Destra → Sinistra      │");
        System.out.println("│  4   │ Moltiplicativi: *, /, %    │  Sinistra → Destra      │");
        System.out.println("│  5   │ Additivi: +, -             │  Sinistra → Destra      │");
        System.out.println("│  6   │ Shift: <<, >>, >>>         │  Sinistra → Destra      │");
        System.out.println("│  7   │ Relazionali: <, >, <=, >=  │  Sinistra → Destra      │");
        System.out.println("│  8   │ Uguaglianza: ==, !=        │  Sinistra → Destra      │");
        System.out.println("│  9   │ AND bitwise: &             │  Sinistra → Destra      │");
        System.out.println("│ 10   │ XOR bitwise: ^             │  Sinistra → Destra      │");
        System.out.println("│ 11   │ OR bitwise: |              │  Sinistra → Destra      │");
        System.out.println("│ 12   │ AND logico: &&             │  Sinistra → Destra      │");
        System.out.println("│ 13   │ OR logico: ||              │  Sinistra → Destra      │");
        System.out.println("│ 14   │ Ternario: ? :              │  Destra → Sinistra      │");
        System.out.println("│ 15   │ Assegnamento: =, +=, -=... │  Destra → Sinistra      │");
        System.out.println("└──────┴────────────────────────────┴─────────────────────────┘\n");
        
        System.out.println("Le PARENTESI () hanno SEMPRE precedenza massima!\n");
        
        printSubSection("Esempi di Precedenza in Azione");
        
        System.out.println("ESEMPIO 1: Aritmetica");
        int ex1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2  →  " + ex1 + " (prima *, poi +)\n");
        
        System.out.println("ESEMPIO 2: Confronto e Logica");
        boolean ex2 = 5 > 3 && 10 < 20;
        System.out.println("5 > 3 && 10 < 20  →  " + ex2);
        System.out.println("  (prima i confronti >, <, poi &&)\n");
        
        System.out.println("ESEMPIO 3: Assegnamento");
        int a, b, c;
        a = b = c = 10;  // Associatività destra → sinistra
        System.out.println("a = b = c = 10;");
        System.out.println("  → Valutato da destra: c=10, b=10, a=10");
        System.out.println("  → a=" + a + ", b=" + b + ", c=" + c + "\n");
        
        System.out.println("ESEMPIO 4: Espressione Complessa");
        int ex4 = 2 + 3 * 4 / 2 - 1;
        System.out.println("2 + 3 * 4 / 2 - 1");
        System.out.println("  → Passo 1: 3 * 4 = 12 (moltiplicazione)");
        System.out.println("  → Passo 2: 12 / 2 = 6 (divisione)");
        System.out.println("  → Passo 3: 2 + 6 = 8 (addizione)");
        System.out.println("  → Passo 4: 8 - 1 = 7 (sottrazione)");
        System.out.println("  → Risultato: " + ex4 + "\n");
        
        printSubSection("💡 Best Practices per la Precedenza");
        
        System.out.println("✓ USA le PARENTESI per rendere esplicito l'ordine");
        System.out.println("  Anche se non necessarie, migliorano la leggibilità:\n");
        
        System.out.println("  // Funziona, ma ambiguo:");
        System.out.println("  if (x > 5 && y < 10 || z == 0) { ... }\n");
        
        System.out.println("  // Meglio con parentesi esplicite:");
        System.out.println("  if ((x > 5 && y < 10) || z == 0) { ... }\n");
        
        System.out.println("✓ EVITA espressioni troppo complesse in una sola riga");
        System.out.println("✓ SPEZZA espressioni complesse in passaggi intermedi");
        System.out.println("✓ DOCUMENTA espressioni non ovvie con commenti\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 13: Best Practices con gli Operatori
     * 
     * Raccolta di best practices professionali per l'uso degli operatori
     */
    private static void demoBestPractices() {
        printSection("13. BEST PRACTICES CON GLI OPERATORI");
        
        printSubSection("1. Chiarezza e Leggibilità");
        
        System.out.println("✓ USA parentesi per chiarire la precedenza, anche se non necessarie:");
        System.out.println("  result = (a + b) * (c - d);  // ✓ Chiaro");
        System.out.println("  result = a + b * c - d;      // ✗ Ambiguo\n");
        
        System.out.println("✓ USA spazi attorno agli operatori binari:");
        System.out.println("  x = a + b;   // ✓ Leggibile");
        System.out.println("  x=a+b;       // ✗ Difficile da leggere\n");
        
        printSubSection("2. Operatori di Incremento/Decremento");
        
        System.out.println("✓ USA ++ e -- in istruzioni separate quando possibile:");
        System.out.println("  x++;         // ✓ Chiaro");
        System.out.println("  y = x;       // ✓ Chiaro\n");
        
        System.out.println("✗ EVITA uso complesso in espressioni:");
        System.out.println("  y = x++ + ++x;  // ✗ Confuso e prono a errori\n");
        
        printSubSection("3. Operatori Logici");
        
        System.out.println("✓ USA && e || invece di & e | per condizioni (short-circuit):");
        System.out.println("  if (obj != null && obj.isValid()) { ... }  // ✓ Sicuro");
        System.out.println("  if (obj != null & obj.isValid()) { ... }   // ✗ NPE se obj è null!\n");
        
        System.out.println("✓ USA ! per negare boolean, non confronti con false:");
        System.out.println("  if (!flag) { ... }        // ✓ Idiomatico");
        System.out.println("  if (flag == false) { ... } // ✗ Verboso\n");
        
        printSubSection("4. Operatore Ternario");
        
        System.out.println("✓ USA il ternario per assegnazioni condizionali semplici:");
        System.out.println("  String status = (age >= 18) ? \"adult\" : \"minor\";  // ✓ OK\n");
        
        System.out.println("✗ EVITA ternari annidati complessi:");
        System.out.println("  // ✗ Difficile da leggere");
        System.out.println("  value = a > b ? c > d ? e : f : g > h ? i : j;\n");
        
        System.out.println("  // ✓ Meglio con if-else");
        System.out.println("  if (a > b) {");
        System.out.println("      value = (c > d) ? e : f;");
        System.out.println("  } else {");
        System.out.println("      value = (g > h) ? i : j;");
        System.out.println("  }\n");
        
        printSubSection("5. Type Casting");
        
        System.out.println("✓ VERIFICA sempre il range prima di narrowing cast:");
        System.out.println("  if (longVal <= Integer.MAX_VALUE && longVal >= Integer.MIN_VALUE) {");
        System.out.println("      int intVal = (int) longVal;  // ✓ Sicuro");
        System.out.println("  }\n");
        
        System.out.println("✓ USA instanceof prima di downcasting oggetti:");
        System.out.println("  if (obj instanceof String) {");
        System.out.println("      String str = (String) obj;  // ✓ Sicuro");
        System.out.println("  }\n");
        
        printSubSection("6. Divisione");
        
        System.out.println("✓ ATTENZIONE alla divisione intera vs decimale:");
        System.out.println("  double result = 10 / 3;      // ✗ Risultato: 3.0 (divisione intera!)");
        System.out.println("  double result = 10.0 / 3;    // ✓ Risultato: 3.333...\n");
        
        System.out.println("✓ CONTROLLA divisione per zero per interi:");
        System.out.println("  if (divisor != 0) {");
        System.out.println("      result = dividend / divisor;");
        System.out.println("  }\n");
        
        printSubSection("7. Operatori Composti");
        
        System.out.println("✓ USA operatori composti per brevità:");
        System.out.println("  x += 5;      // ✓ Conciso (equivale a x = x + 5)");
        System.out.println("  x = x + 5;   // ✓ Esplicito, ma più verboso\n");
        
        printSubSection("8. Confronti");
        
        System.out.println("✓ USA .equals() per confrontare oggetti:");
        System.out.println("  if (str1.equals(str2)) { ... }  // ✓ Confronta contenuti");
        System.out.println("  if (str1 == str2) { ... }       // ✗ Confronta riferimenti\n");
        
        System.out.println("✓ USA == solo per primitivi e controlli null:");
        System.out.println("  if (obj == null) { ... }        // ✓ OK");
        System.out.println("  if (count == 0) { ... }         // ✓ OK (primitivo)\n");
        
        printSubSection("💡 Regola d'Oro");
        
        System.out.println("\"Il codice si legge MOLTO PIÙ spesso di quanto si scrive.");
        System.out.println(" Scrivi per chiarezza, non per brevità estrema.\"\n");
        
        System.out.println("✓ Codice LEGGIBILE > Codice BREVE");
        System.out.println("✓ Codice CHIARO > Codice \"FURBO\"");
        System.out.println("✓ Codice MANUTENIBILE > Codice \"COMPATTO\"\n");
        
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
        System.out.println("  ✓ DEMO COMPLETATA - Hai appreso tutto sugli Operatori e Type Casting in Java!");
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
