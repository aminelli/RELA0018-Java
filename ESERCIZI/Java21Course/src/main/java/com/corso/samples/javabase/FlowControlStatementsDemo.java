package com.corso.samples.javabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Demo completa sui Flow Control Statements in Java 21.
 *
 * <p>
 * Contenuti principali:
 * </p>
 * <ul>
 * <li>if / else if / else e forme annidate</li>
 * <li>switch statement classico e switch expression moderna</li>
 * <li>operatori ternari e short-circuit</li>
 * <li>for, while, do-while, enhanced for</li>
 * <li>break, continue, label (uso consapevole)</li>
 * <li>return come controllo del flusso</li>
 * <li>best practices e anti-pattern comuni</li>
 * </ul>
 */
public class FlowControlStatementsDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String BLUE = "\u001B[34m";

    private FlowControlStatementsDemo() {
    }

    public static void run() {
        printHeader("FLOW CONTROL STATEMENTS IN JAVA 21");

        demoIntroduction();
        demoIfElse();
        demoNestedIfAndGuards();
        demoSwitchStatementClassic();
        demoSwitchExpressionModern();
        demoTernaryOperator();
        demoForLoop();
        demoEnhancedForLoop();
        demoWhileLoop();
        demoDoWhileLoop();
        demoBreakContinue();
        demoLabeledBreakContinue();
        demoReturnAsFlowControl();
        demoShortCircuitAndBooleanLogic();
        demoBestPractices();

        printFooter();
    }

    private static void demoIntroduction() {
        printSection("1) Introduzione ai Flow Control Statements");

        System.out.println("I flow control statements determinano l'ordine di esecuzione del codice.");
        System.out.println("In Java, i blocchi principali sono:");
        System.out.println("- Decisione: if, if-else, switch");
        System.out.println("- Iterazione: for, while, do-while, enhanced for");
        System.out.println("- Salto/controllo: break, continue, return");
        System.out.println();

        printSubSection("Quando usare cosa");
        System.out.println("if/else      -> decisioni booleane generiche");
        System.out.println("switch       -> selezione tra casi discreti");
        System.out.println("for          -> iterazioni con contatore noto");
        System.out.println("while        -> iterazioni condizionali pre-test");
        System.out.println("do-while     -> almeno una esecuzione garantita");
        System.out.println("break/continue -> interruzioni/skip controllato");
    }

    private static void demoIfElse() {
        printSection("2) if / else if / else");

        int score = 84;
        String grade;

        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.printf("Score: %d -> Grade: %s%n", score, grade);

        printSubSection("if senza parentesi graffe (evitare se non banale)");
        boolean premiumUser = true;
        if (premiumUser)
            System.out.println("Accesso premium abilitato.");

        System.out.println("Best practice: usare sempre le graffe anche per un solo statement.");
    }

    private static void demoNestedIfAndGuards() {
        printSection("3) if annidati e guard clauses");

        Integer age = loadAgeFromExternalLikeSource();
        boolean acceptedTerms = true;

        printSubSection("if annidato");
        if (age != null) {
            if (age >= 18) {
                if (acceptedTerms) {
                    System.out.println("Registrazione completata (annidato).");
                } else {
                    System.out.println("Termini non accettati.");
                }
            } else {
                System.out.println("Utente minorenne.");
            }
        } else {
            System.out.println("Età non fornita.");
        }

        printSubSection("Guard clauses (preferibile per leggibilità)");
        registrationFlowWithGuards(age, acceptedTerms);
    }

    private static void demoSwitchStatementClassic() {
        printSection("4) switch statement classico");

        int month = (int) ((System.currentTimeMillis() % 12) + 1);

        System.out.printf("Mese %d -> ", month);
        switch (month) {
            case 12, 1, 2 -> System.out.println("Inverno");
            case 3, 4, 5 -> System.out.println("Primavera");
            case 6, 7, 8 -> System.out.println("Estate");
            case 9, 10, 11 -> System.out.println("Autunno");
            default -> System.out.println("Mese non valido");
        }

        printSubSection("Attenzione al fall-through");
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Lunedi");
                break;
            case 2:
                System.out.println("Martedi");
                break;
            case 3:
                System.out.println("Mercoledi");
                // Nessun break intenzionale per mostrare fall-through
            case 4:
                System.out.println("(fall-through) Giovedi");
                break;
            default:
                System.out.println("Altro giorno");
        }
        System.out.println("Best practice: evitare fall-through involontario.");
    }

    private static void demoSwitchExpressionModern() {
        printSection("5) switch expression moderna (Java 14+)");

        int quarter = 3;

        String quarterName = switch (quarter) {
            case 1 -> "Q1";
            case 2 -> "Q2";
            case 3 -> "Q3";
            case 4 -> "Q4";
            default -> "N/A";
        };

        System.out.printf("Quarter: %d -> %s%n", quarter, quarterName);

        printSubSection("switch expression con blocco e yield");
        int temperature = 32;

        String comfortLevel = switch (temperature) {
            case 0, 1, 2, 3, 4, 5 -> "Molto freddo";
            case 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 -> "Freddo";
            case 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 -> "Confortevole";
            default -> {
                if (temperature > 40) {
                    yield "Estremo caldo";
                }
                yield "Caldo";
            }
        };

        System.out.printf("Temperatura %d°C -> %s%n", temperature, comfortLevel);

        printSubSection("switch con enum: caso ideale");
        Priority priority = Priority.HIGH;
        String sla = switch (priority) {
            case LOW -> "SLA 72h";
            case MEDIUM -> "SLA 24h";
            case HIGH -> "SLA 8h";
            case CRITICAL -> "SLA 1h";
        };
        System.out.printf("Priority %s -> %s%n", priority, sla);
    }

    private static void demoTernaryOperator() {
        printSection("6) Operatore ternario (?:)");

        int stock = 5;
        String availability = stock > 0 ? "Disponibile" : "Non disponibile";
        System.out.printf("Stock: %d -> %s%n", stock, availability);

        printSubSection("Ternario annidato (usare con moderazione)");
        int value = 73;
        String band = value >= 90 ? "Eccellente"
                : value >= 70 ? "Buono"
                        : value >= 50 ? "Sufficiente" : "Insufficiente";

        System.out.printf("Valore %d -> %s%n", value, band);
        System.out.println("Best practice: se diventa poco leggibile, tornare a if/else.");
    }

    private static void demoForLoop() {
        printSection("7) for loop");

        printSubSection("for classico con indice");
        for (int i = 1; i <= 5; i++) {
            System.out.printf("Iterazione %d%n", i);
        }

        printSubSection("for con step custom");
        for (int i = 0; i <= 10; i += 2) {
            System.out.printf("Pari: %d%n", i);
        }

        printSubSection("for decrescente");
        for (int countdown = 5; countdown >= 1; countdown--) {
            System.out.printf("T-%d%n", countdown);
        }

        printSubSection("for infinito controllato da break");
        int attempts = 0;
        for (;;) {
            attempts++;
            System.out.printf("Tentativo %d%n", attempts);
            if (attempts == 3) {
                break;
            }
        }
    }

    private static void demoEnhancedForLoop() {
        printSection("8) enhanced for (for-each)");

        int[] numbers = { 10, 20, 30, 40 };
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Somma: " + sum);

        printSubSection("for-each su collection");
        List<String> topics = List.of("if", "switch", "for", "while", "break", "continue");
        for (String topic : topics) {
            System.out.printf("- %s%n", topic);
        }

        printSubSection("Limite del for-each");
        System.out.println("Non hai accesso diretto all'indice; usa for classico se serve l'indice.");
    }

    private static void demoWhileLoop() {
        printSection("9) while loop");

        int counter = 1;
        while (counter <= 3) {
            System.out.printf("while -> step %d%n", counter);
            counter++;
        }

        printSubSection("while per letture/eventi condizionali");
        String[] fakeInputs = { "start", "process", "stop" };
        int idx = 0;

        while (idx < fakeInputs.length && !"stop".equalsIgnoreCase(fakeInputs[idx])) {
            System.out.printf("Comando: %s%n", fakeInputs[idx]);
            idx++;
        }
        System.out.println("Uscita dal while su condizione di stop.");
    }

    private static void demoDoWhileLoop() {
        printSection("10) do-while loop");

        int tries = 0;
        boolean valid;

        do {
            tries++;
            System.out.printf("Tentativo validazione #%d%n", tries);
            valid = tries >= 2;
        } while (!valid);

        System.out.println("do-while garantisce almeno una esecuzione.");
    }

    private static void demoBreakContinue() {
        printSection("11) break e continue");

        printSubSection("continue: salta iterazione corrente");
        for (int i = 1; i <= 8; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.printf("Dispari: %d%n", i);
        }

        printSubSection("break: interrompe il ciclo");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("Break raggiunto a i=6");
                break;
            }
            System.out.printf("i=%d%n", i);
        }
    }

    private static void demoLabeledBreakContinue() {
        printSection("12) labeled break/continue (uso avanzato)");

        printSubSection("labeled break su cicli annidati");
        int target = 23;
        boolean found = false;

        searchGrid: for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                int cellValue = row * 10 + col;
                if (cellValue == target) {
                    System.out.printf("Trovato target %d in row=%d col=%d%n", target, row, col);
                    found = true;
                    break searchGrid;
                }
            }
        }

        if (!found) {
            System.out.println("Target non trovato");
        }

        printSubSection("labeled continue");
        outerLoop: for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                if (row == 2 && col == 2) {
                    System.out.println("Salto alla prossima riga (continue outerLoop)");
                    continue outerLoop;
                }
                System.out.printf("row=%d col=%d%n", row, col);
            }
        }

        System.out.println("Best practice: usare label solo quando migliora davvero la chiarezza.");
    }

    private static void demoReturnAsFlowControl() {
        printSection("13) return come controllo del flusso");

        printSubSection("early return per guard clauses");
        processOrder(null);
        processOrder("ORD-2026-0001");

        printSubSection("return con Optional per assenza risultato");
        Optional<String> maybeEmail = findEmailByUserId(2);
        System.out.println("Email user 2: " + maybeEmail.orElse("N/D"));

        Optional<String> missingEmail = findEmailByUserId(99);
        System.out.println("Email user 99: " + missingEmail.orElse("N/D"));
    }

    private static void demoShortCircuitAndBooleanLogic() {
        printSection("14) Short-circuit e logica booleana");

        printSubSection("AND short-circuit (&&)");
        String token = loadAuthTokenFromExternalLikeSource();
        if (token != null && token.startsWith("Bearer ")) {
            System.out.println("Token valido");
        } else {
            System.out.println("Token assente o invalido (nessuna NullPointerException)");
        }

        printSubSection("OR short-circuit (||)");
        boolean isAdmin = false;
        boolean hasPermission = true;
        if (isAdmin || hasPermission) {
            System.out.println("Accesso consentito.");
        }

        printSubSection("Ordine delle condizioni");
        int[] values = { 1, 2, 3 };
        int position = 3;

        if (position >= 0 && position < values.length) {
            System.out.println("Accesso sicuro all'array.");
        } else {
            System.out.println("Indice fuori range.");
        }
    }

    private static void demoBestPractices() {
        printSection("15) Best Practices e anti-pattern");

        List<String> bestPractices = List.of(
                "Preferire switch expression per assegnazioni: codice più compatto e sicuro.",
                "Usare guard clauses per ridurre annidamenti profondi.",
                "Evitare label complesse se una estrazione in metodo è più chiara.",
                "Usare for-each quando non serve l'indice.",
                "Usare while per condizioni aperte e for per cicli con contatore.",
                "Limitare il ternario a espressioni semplici.",
                "Evitare break/continue eccessivi che frammentano il flusso.",
                "Validare sempre input e indici prima di accessi sensibili.",
                "Nominare bene variabili di controllo (counter, index, attempts).",
                "Prediligere leggibilità e manutenibilità alla micro-ottimizzazione.");

        for (int i = 0; i < bestPractices.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, bestPractices.get(i));
        }

        printSubSection("Anti-pattern frequenti");
        System.out.println("- if annidati oltre 3 livelli senza estrazione metodi");
        System.out.println("- switch senza default quando il dominio non è chiuso");
        System.out.println("- cicli infiniti senza condizione di uscita esplicita");
        System.out.println("- uso improprio di break/continue per simulare goto");
        System.out.println("- condizioni booleane troppo lunghe senza variabili intermedie");

        printSubSection("Regole d'oro");
        System.out.println("1) Prima la chiarezza, poi la compattezza.");
        System.out.println("2) Ogni ramo deve essere facilmente testabile.");
        System.out.println("3) Ogni ciclo deve avere una condizione di uscita evidente.");
    }

    private static void registrationFlowWithGuards(Integer age, boolean acceptedTerms) {
        if (age == null) {
            System.out.println("Guard: età non fornita.");
            return;
        }
        if (age < 18) {
            System.out.println("Guard: utente minorenne.");
            return;
        }
        if (!acceptedTerms) {
            System.out.println("Guard: termini non accettati.");
            return;
        }
        System.out.println("Guard: registrazione completata.");
    }

    private static void processOrder(String orderId) {
        if (orderId == null || orderId.isBlank()) {
            System.out.println("Ordine non valido: id mancante.");
            return;
        }

        System.out.printf("Elaborazione ordine %s...%n", orderId);
        System.out.println("Ordine completato.");
    }

    private static Optional<String> findEmailByUserId(int userId) {
        if (userId == 1) {
            return Optional.of("mario.rossi@example.com");
        }
        if (userId == 2) {
            return Optional.of("laura.bianchi@example.com");
        }
        return Optional.empty();
    }

    private static Integer loadAgeFromExternalLikeSource() {
        long tick = System.nanoTime();
        if (tick % 5 == 0) {
            return null;
        }
        return 23;
    }

    private static String loadAuthTokenFromExternalLikeSource() {
        long tick = System.nanoTime();
        if (tick % 2 == 0) {
            return "Bearer sample-token";
        }
        return null;
    }

    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════╗" + RESET);
        System.out.printf(CYAN + "║ %-58s ║%n" + RESET, title);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    private static void printSection(String title) {
        System.out.println();
        System.out.println(BLUE + "────────────────────────────────────────────────────────────" + RESET);
        System.out.println(GREEN + title + RESET);
        System.out.println(BLUE + "────────────────────────────────────────────────────────────" + RESET);
    }

    private static void printSubSection(String subtitle) {
        System.out.println();
        System.out.println(MAGENTA + "▶ " + subtitle + RESET);
    }

    private static void printFooter() {
        System.out.println();
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
        System.out.println(YELLOW + " Fine demo: Flow Control Statements" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    private enum Priority {
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }
}
