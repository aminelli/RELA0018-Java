package com.corso.samples.javabase;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Demo avanzata sull'utilizzo di switch in Java 21.
 *
 * <p>
 * Copre switch statement tradizionale, switch expression, pattern matching,
 * gestione del null, guardie con "when", best practices e anti-pattern.
 * </p>
 */
public class SwitchAvanzatiDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private SwitchAvanzatiDemo() {
    }

    /**
     * Punto di ingresso della demo.
     *
     * <p>
     * Ogni metodo mostra uno scenario pratico diverso per chiarire quando usare
     * una specifica variante di switch.
     * </p>
     */
    public static void run() {
        printHeader("SWITCH AVANZATI IN JAVA 21");

        demoIntroduzione();
        demoSwitchStatementClassico();
        demoSwitchExpression();
        demoSwitchConYield();
        demoSwitchSuEnum();
        demoSwitchSuStringConNormalizzazione();
        demoPatternMatchingSwitch();
        demoSwitchConNullCase();
        demoSwitchConGuardieWhen();
        demoUseCaseBusinessRouting();
        demoBestPractices();

        printFooter();
    }

    /**
     * Introduzione teorica per inquadrare il costrutto.
     */
    private static void demoIntroduzione() {
        printSection("1) Introduzione");

        // Lo switch è un costrutto di selezione multipla:
        // sceglie un ramo in base al valore di un'espressione discriminante.
        System.out.println("Switch = selezione multipla su un discriminante.");

        // In Java moderno conviene distinguere:
        // - statement: esegue blocchi
        // - expression: restituisce un valore
        System.out.println("Varianti: statement (classico) ed expression (moderno).");
        System.out.println("In Java 21: pattern matching e guardie aumentano espressività.");
    }

    /**
     * Mostra lo switch statement tradizionale con break.
     */
    private static void demoSwitchStatementClassico() {
        printSection("2) Switch statement classico");

        int month = 4;

        // Nello statement classico è fondamentale usare break per evitare
        // fall-through involontario (esecuzione dei case successivi).
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("Stagione: inverno");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Stagione: primavera");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Stagione: estate");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Stagione: autunno");
                break;
            default:
                // Default difensivo per input non valido.
                System.out.println("Mese non valido");
        }
    }

    /**
     * Mostra la switch expression con frecce.
     */
    private static void demoSwitchExpression() {
        printSection("3) Switch expression");

        DayOfWeek day = DayOfWeek.FRIDAY;

        // La switch expression restituisce un valore tipizzato.
        // Con la sintassi "->" non serve break, riducendo errori comuni.
        String traffic = switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> "alto";
            case FRIDAY -> "medio-alto";
            case SATURDAY, SUNDAY -> "basso";
        };

        System.out.println("Giorno: " + day + ", traffico previsto: " + traffic);
    }

    /**
     * Mostra l'uso di yield in blocchi switch expression.
     */
    private static void demoSwitchConYield() {
        printSection("4) Switch expression con yield");

        String role = "MANAGER";

        // Usiamo un blocco quando la logica è multi-step.
        // "yield" esplicita il valore da restituire dall'intero case.
        int approvalLimit = switch (role) {
            case "ADMIN" -> 100_000;
            case "MANAGER" -> {
                int base = 20_000;
                int bonus = 5_000;
                yield base + bonus;
            }
            case "SUPERVISOR" -> 10_000;
            default -> 1_000;
        };

        System.out.println("Ruolo: " + role + ", limite approvazione: " + approvalLimit);
    }

    /**
     * Mostra l'uso su enum con mapping semantico.
     */
    private static void demoSwitchSuEnum() {
        printSection("5) Switch su enum");

        TicketPriority priority = TicketPriority.HIGH;

        // Con enum lo switch è molto leggibile e robusto.
        // Se aggiungi nuovi enum, il compilatore aiuta a trovare punti da aggiornare.
        String sla = switch (priority) {
            case LOW -> "72h";
            case MEDIUM -> "24h";
            case HIGH -> "8h";
            case CRITICAL -> "1h";
        };

        System.out.println("Priority: " + priority + ", SLA: " + sla);
    }

    /**
     * Mostra switch su stringa con normalizzazione input.
     */
    private static void demoSwitchSuStringConNormalizzazione() {
        printSection("6) Switch su String con normalizzazione");

        String commandFromUser = "  StaRt  ";

        // Prima dello switch conviene normalizzare l'input:
        // trim per spazi laterali, lower-case per confronto case-insensitive.
        String normalized = commandFromUser.trim().toLowerCase(Locale.ROOT);

        String action = switch (normalized) {
            case "start" -> "Avvio processo";
            case "stop" -> "Arresto processo";
            case "status" -> "Lettura stato";
            case "restart" -> "Riavvio processo";
            default -> "Comando non riconosciuto";
        };

        System.out.println("Input originale='" + commandFromUser + "', azione='" + action + "'");
    }

    /**
     * Mostra pattern matching nello switch su tipi differenti.
     */
    private static void demoPatternMatchingSwitch() {
        printSection("7) Pattern matching switch");

        List<Object> samples = List.of(42, -5, 3.14, "Java", true);

        for (Object value : samples) {
            // Lo switch con pattern matching seleziona il case in base al tipo runtime.
            String description = switch (value) {
                case Integer i -> "Intero: " + i;
                case Double d -> "Double: " + d;
                case String s -> "String(" + s.length() + "): " + s;
                case Boolean b -> "Boolean: " + b;
                default -> "Tipo non gestito";
            };
            System.out.println(description);
        }
    }

    /**
     * Mostra la gestione esplicita del null in switch.
     */
    private static void demoSwitchConNullCase() {
        printSection("8) Switch con case null");

        String regionCode = null;

        // In Java 21 possiamo gestire null direttamente nello switch.
        // Questo evita null-check esterni in alcuni scenari.
        String regionName = switch (regionCode) {
            case null -> "Regione non specificata";
            case "it-nord" -> "Nord Italia";
            case "it-centro" -> "Centro Italia";
            case "it-sud" -> "Sud Italia";
            default -> "Regione sconosciuta";
        };

        System.out.println("regionCode=" + regionCode + " -> " + regionName);
    }

    /**
     * Mostra guardie con when per affinare i pattern.
     */
    private static void demoSwitchConGuardieWhen() {
        printSection("9) Switch con guardie (when)");

        List<Object> metrics = List.of(120, 55, -3, "ok", "");

        for (Object metric : metrics) {
            // "when" aggiunge una condizione extra al match del pattern.
            String band = switch (metric) {
                case Integer i when i >= 100 -> "Intero ALTO";
                case Integer i when i >= 0 -> "Intero MEDIO";
                case Integer i -> "Intero NEGATIVO";
                case String s when !s.isBlank() -> "String valorizzata";
                case String s -> "String vuota";
                default -> "Tipo non classificato";
            };
            System.out.println("metric=" + metric + " -> " + band);
        }
    }

    /**
     * Scenario reale: instradamento logica business per eventi.
     */
    private static void demoUseCaseBusinessRouting() {
        printSection("10) Use case: routing eventi business");

        Map<String, EventType> eventStream = Map.of(
                "evt-1", EventType.CREATED,
                "evt-2", EventType.UPDATED,
                "evt-3", EventType.DELETED,
                "evt-4", EventType.ARCHIVED);

        for (Map.Entry<String, EventType> entry : eventStream.entrySet()) {
            String eventId = entry.getKey();
            EventType eventType = entry.getValue();

            // In casi di routing, switch expression migliora leggibilità
            // e rende espliciti tutti i rami disponibili.
            String handler = switch (eventType) {
                case CREATED -> "handleCreate";
                case UPDATED -> "handleUpdate";
                case DELETED -> "handleDelete";
                case ARCHIVED -> "handleArchive";
            };

            System.out.println(eventId + " -> " + handler);
        }
    }

    /**
     * Best practices e anti-pattern sull'uso di switch.
     */
    private static void demoBestPractices() {
        printSection("11) Best practices e anti-pattern");

        String[] practices = {
                "Preferisci switch expression quando devi ottenere un valore.",
                "Usa enum come discriminante quando il dominio è chiuso.",
                "Normalizza input stringa prima dello switch.",
                "Gestisci esplicitamente il caso null nei contesti a rischio.",
                "Usa pattern matching per sostituire catene if/instanceof verbose.",
                "Usa guardie when per condizioni specifiche sui pattern.",
                "Mantieni ogni case corto: estrai metodi per logiche complesse.",
                "Con statement classico, verifica sempre presenza/assenza dei break." };

        for (int i = 0; i < practices.length; i++) {
            System.out.printf("%d) %s%n", i + 1, practices[i]);
        }

        printSubSection("Anti-pattern");
        System.out.println("- Switch troppo lunghi con logica business pesante in-line");
        System.out.println("- Fall-through accidentale nello statement classico");
        System.out.println("- Nessuna normalizzazione su input testuale utente");
        System.out.println("- Mancata copertura di default/null nei percorsi critici");
    }

    /**
     * Stampa intestazione della demo.
     */
    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════╗" + RESET);
        System.out.printf(CYAN + "║ %-58s ║%n" + RESET, title);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    /**
     * Stampa una sezione principale.
     */
    private static void printSection(String title) {
        System.out.println();
        System.out.println(BLUE + "────────────────────────────────────────────────────────────" + RESET);
        System.out.println(GREEN + title + RESET);
        System.out.println(BLUE + "────────────────────────────────────────────────────────────" + RESET);
    }

    /**
     * Stampa una sotto-sezione.
     */
    private static void printSubSection(String subtitle) {
        System.out.println();
        System.out.println(MAGENTA + "▶ " + subtitle + RESET);
    }

    /**
     * Stampa footer finale.
     */
    private static void printFooter() {
        System.out.println();
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
        System.out.println(YELLOW + " Fine demo: Switch Avanzati" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    /**
     * Priorità ticket per esempio su enum.
     */
    private enum TicketPriority {
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }

    /**
     * Tipologia evento per esempio di routing.
     */
    private enum EventType {
        CREATED,
        UPDATED,
        DELETED,
        ARCHIVED
    }
}
