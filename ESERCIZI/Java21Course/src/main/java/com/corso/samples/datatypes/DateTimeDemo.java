package com.corso.samples.datatypes;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * Classe demo completa per l'apprendimento di Date e Time in Java
 * 
 * Java ha evoluto l'API Date/Time nel corso degli anni:
 * - VECCHIA API (java.util.Date, Calendar) - prima di Java 8, problematica
 * - NUOVA API (java.time.*) - da Java 8, moderna e robusta
 * 
 * CARATTERISTICHE NUOVA API (java.time):
 * - IMMUTABILE: thread-safe
 * - API chiara e consistente
 * - Supporto timezone robusto
 * - Separazione tra date, time, datetime
 * 
 * @author Java 21 Course
 * @version 1.0
 */
public class DateTimeDemo {

    /**
     * Metodo principale che esegue tutte le demo su Date e Time
     * Questo metodo orchestra l'esecuzione sequenziale di tutte le sezioni
     */
    public static void run() {
        printHeader("DEMO COMPLETA: DATE & TIME IN JAVA");
        
        // Sezione 1: Introduzione ed evoluzione API
        demoIntroduction();
        
        // Sezione 2: API Vecchia (Date, Calendar) - cenni storici
        demoLegacyAPI();
        
        // Sezione 3: LocalDate - Date senza orario
        demoLocalDate();
        
        // Sezione 4: LocalTime - Orario senza data
        demoLocalTime();
        
        // Sezione 5: LocalDateTime - Data + Orario
        demoLocalDateTime();
        
        // Sezione 6: ZonedDateTime - Con timezone
        demoZonedDateTime();
        
        // Sezione 7: Instant - Timestamp UTC
        demoInstant();
        
        // Sezione 8: Duration - Durata tra tempi
        demoDuration();
        
        // Sezione 9: Period - Periodo tra date
        demoPeriod();
        
        // Sezione 10: DateTimeFormatter - Parsing e Formatting
        demoFormatting();
        
        // Sezione 11: TemporalAdjusters - Manipolazioni avanzate
        demoTemporalAdjusters();
        
        // Sezione 12: Comparazioni e Calcoli
        demoComparisonsCalculations();
        
        // Sezione 13: Conversioni (vecchia ↔ nuova API)
        demoConversions();
        
        // Sezione 14: Best Practices
        demoBestPractices();
        
        printFooter();
    }

    /**
     * SEZIONE 1: Introduzione ed Evoluzione API
     * 
     * Spiega l'evoluzione delle API Date/Time in Java e perché usare java.time
     */
    private static void demoIntroduction() {
        printSection("1. INTRODUZIONE: EVOLUZIONE DATE/TIME API");
        
        System.out.println("Java ha tre generazioni di API per gestire date e tempo.\n");
        
        printSubSection("📅 Prima Generazione: java.util.Date (Java 1.0)");
        
        System.out.println("Problemi:");
        System.out.println("  ✗ Mutabile (non thread-safe)");
        System.out.println("  ✗ API confusa (month: 0-11, year: 1900+offset)");
        System.out.println("  ✗ Metodi deprecati");
        System.out.println("  ✗ Nessun supporto timezone robusto\n");
        
        printSubSection("📆 Seconda Generazione: java.util.Calendar (Java 1.1)");
        
        System.out.println("Miglioramenti:");
        System.out.println("  ✓ Supporto timezone migliorato");
        System.out.println("  ✓ API più completa\n");
        
        System.out.println("Problemi rimasti:");
        System.out.println("  ✗ Ancora mutabile");
        System.out.println("  ✗ API verbosa e complessa");
        System.out.println("  ✗ Month ancora 0-based\n");
        
        printSubSection("🎯 Terza Generazione: java.time.* (Java 8+) - MODERNA");
        
        System.out.println("Vantaggi:");
        System.out.println("  ✓ IMMUTABILE (thread-safe)");
        System.out.println("  ✓ API chiara e fluente");
        System.out.println("  ✓ Separazione concetti (date, time, datetime, timezone)");
        System.out.println("  ✓ Supporto timezone robusto (IANA Time Zone Database)");
        System.out.println("  ✓ Inspirata da Joda-Time (libreria popolare)\n");
        
        printSubSection("📊 Classi Principali java.time");
        
        System.out.println("┌──────────────────┬────────────────────────────────────────────┐");
        System.out.println("│     CLASSE       │              DESCRIZIONE                   │");
        System.out.println("├──────────────────┼────────────────────────────────────────────┤");
        System.out.println("│ LocalDate        │ Data (senza orario, senza timezone)        │");
        System.out.println("│ LocalTime        │ Orario (senza data, senza timezone)        │");
        System.out.println("│ LocalDateTime    │ Data + Orario (senza timezone)             │");
        System.out.println("│ ZonedDateTime    │ Data + Orario + Timezone                   │");
        System.out.println("│ Instant          │ Timestamp (secondi da epoch UTC)           │");
        System.out.println("│ Duration         │ Durata in tempo (ore, minuti, secondi)     │");
        System.out.println("│ Period           │ Periodo in date (anni, mesi, giorni)       │");
        System.out.println("│ DateTimeFormatter│ Parsing e formatting                       │");
        System.out.println("└──────────────────┴────────────────────────────────────────────┘\n");
        
        printSubSection("💡 Quale Usare?");
        
        System.out.println("✓ LocalDate       : Compleanno, scadenza, data evento");
        System.out.println("✓ LocalTime       : Orario apertura negozio, sveglia");
        System.out.println("✓ LocalDateTime   : Appuntamento senza considerare timezone");
        System.out.println("✓ ZonedDateTime   : Evento internazionale, conversione timezone");
        System.out.println("✓ Instant         : Timestamp per database, log, timestamp UTC\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 2: API Vecchia (Date, Calendar)
     * 
     * Mostra brevemente l'API vecchia per contesto storico
     */
    private static void demoLegacyAPI() {
        printSection("2. API VECCHIA: java.util.Date e Calendar");
        
        System.out.println("⚠️ QUESTA API È DEPRECATA - Usare java.time invece!\n");
        System.out.println("Mostrata solo per comprensione codice legacy.\n");
        
        printSubSection("java.util.Date (evitare!)");
        
        Date now = new Date();
        System.out.println("Date now = new Date();");
        System.out.println("  → now = " + now + "\n");
        
        System.out.println("Problemi:");
        System.out.println("  • toString() usa timezone locale (non ISO 8601)");
        System.out.println("  • Mutabile (setTime() modifica l'oggetto)");
        System.out.println("  • Molti metodi deprecati\n");
        
        printSubSection("java.util.Calendar (evitare!)");
        
        Calendar cal = Calendar.getInstance();
        System.out.println("Calendar cal = Calendar.getInstance();");
        System.out.println("  → Year: " + cal.get(Calendar.YEAR));
        System.out.println("  → Month: " + cal.get(Calendar.MONTH) + " (0=gennaio!)");
        System.out.println("  → Day: " + cal.get(Calendar.DAY_OF_MONTH) + "\n");
        
        System.out.println("Problemi:");
        System.out.println("  • Month è 0-based (0=gennaio, 11=dicembre) - confuso!");
        System.out.println("  • Mutabile");
        System.out.println("  • API verbosa\n");
        
        printSubSection("✅ SOLUZIONE: Usa java.time!");
        
        LocalDate today = LocalDate.now();
        System.out.println("LocalDate today = LocalDate.now();");
        System.out.println("  → today = " + today);
        System.out.println("  → Year: " + today.getYear());
        System.out.println("  → Month: " + today.getMonthValue() + " (1=gennaio, naturale!)");
        System.out.println("  → Day: " + today.getDayOfMonth() + "\n");
        
        System.out.println("💡 Immutabile, chiaro, moderno!\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 3: LocalDate - Date senza orario
     * 
     * Mostra come lavorare con date (senza orario)
     */
    private static void demoLocalDate() {
        printSection("3. LOCALDATE: DATE SENZA ORARIO");
        
        System.out.println("LocalDate rappresenta una data (anno-mese-giorno) senza orario.");
        System.out.println("Es: 2026-02-23\n");
        
        printSubSection("Creazione LocalDate");
        
        // Data corrente
        LocalDate today = LocalDate.now();
        System.out.println("LocalDate today = LocalDate.now();");
        System.out.println("  → today = " + today + "\n");
        
        // Data specifica
        LocalDate birthday = LocalDate.of(1990, 5, 15);
        System.out.println("LocalDate birthday = LocalDate.of(1990, 5, 15);");
        System.out.println("  → birthday = " + birthday + "\n");
        
        // Con Month enum (più leggibile)
        LocalDate christmas = LocalDate.of(2026, Month.DECEMBER, 25);
        System.out.println("LocalDate christmas = LocalDate.of(2026, Month.DECEMBER, 25);");
        System.out.println("  → christmas = " + christmas + "\n");
        
        // Parsing da stringa
        LocalDate parsed = LocalDate.parse("2025-12-31");
        System.out.println("LocalDate parsed = LocalDate.parse(\"2025-12-31\");");
        System.out.println("  → parsed = " + parsed + "\n");
        
        printSubSection("Estrazione Componenti");
        
        System.out.println("Data: " + today);
        System.out.println("  → getYear()         = " + today.getYear());
        System.out.println("  → getMonth()        = " + today.getMonth() + " (enum)");
        System.out.println("  → getMonthValue()   = " + today.getMonthValue() + " (1-12)");
        System.out.println("  → getDayOfMonth()   = " + today.getDayOfMonth());
        System.out.println("  → getDayOfWeek()    = " + today.getDayOfWeek());
        System.out.println("  → getDayOfYear()    = " + today.getDayOfYear() + "\n");
        
        printSubSection("Modifiche (creano NUOVE istanze!)");
        
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("LocalDate tomorrow = today.plusDays(1);");
        System.out.println("  → tomorrow = " + tomorrow);
        System.out.println("  → today = " + today + " (immutata!)\n");
        
        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println("today.plusWeeks(1)    → " + nextWeek);
        
        LocalDate nextMonth = today.plusMonths(1);
        System.out.println("today.plusMonths(1)   → " + nextMonth);
        
        LocalDate nextYear = today.plusYears(1);
        System.out.println("today.plusYears(1)    → " + nextYear + "\n");
        
        // Sottrazioni
        LocalDate yesterday = today.minusDays(1);
        System.out.println("today.minusDays(1)    → " + yesterday + "\n");
        
        printSubSection("Metodi with - Sostituzione Componenti");
        
        LocalDate sameMonthDifferentDay = today.withDayOfMonth(15);
        System.out.println("today.withDayOfMonth(15)  → " + sameMonthDifferentDay);
        
        LocalDate sameYearDifferentMonth = today.withMonth(12);
        System.out.println("today.withMonth(12)       → " + sameYearDifferentMonth);
        
        LocalDate differentYear = today.withYear(2030);
        System.out.println("today.withYear(2030)      → " + differentYear + "\n");
        
        printSubSection("Verifica Proprietà");
        
        LocalDate leapYear = LocalDate.of(2024, 2, 29);
        System.out.println("LocalDate leapYear = LocalDate.of(2024, 2, 29);");
        System.out.println("  → isLeapYear() = " + leapYear.isLeapYear() + "\n");
        
        LocalDate notLeapYear = LocalDate.of(2023, 1, 1);
        System.out.println("LocalDate notLeapYear = LocalDate.of(2023, 1, 1);");
        System.out.println("  → isLeapYear() = " + notLeapYear.isLeapYear() + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 4: LocalTime - Orario senza data
     * 
     * Mostra come lavorare con orari (senza data)
     */
    private static void demoLocalTime() {
        printSection("4. LOCALTIME: ORARIO SENZA DATA");
        
        System.out.println("LocalTime rappresenta un orario (ore:minuti:secondi.nanosecondi).");
        System.out.println("Es: 14:30:15\n");
        
        printSubSection("Creazione LocalTime");
        
        // Orario corrente
        LocalTime now = LocalTime.now();
        System.out.println("LocalTime now = LocalTime.now();");
        System.out.println("  → now = " + now + "\n");
        
        // Orario specifico
        LocalTime lunch = LocalTime.of(12, 30);
        System.out.println("LocalTime lunch = LocalTime.of(12, 30);");
        System.out.println("  → lunch = " + lunch + "\n");
        
        LocalTime precise = LocalTime.of(14, 30, 45);  // ore, minuti, secondi
        System.out.println("LocalTime precise = LocalTime.of(14, 30, 45);");
        System.out.println("  → precise = " + precise + "\n");
        
        LocalTime veryPrecise = LocalTime.of(14, 30, 45, 123456789);  // + nanosecondi
        System.out.println("LocalTime veryPrecise = LocalTime.of(14, 30, 45, 123456789);");
        System.out.println("  → veryPrecise = " + veryPrecise + "\n");
        
        // Parsing
        LocalTime parsed = LocalTime.parse("18:45:30");
        System.out.println("LocalTime.parse(\"18:45:30\")  → " + parsed + "\n");
        
        printSubSection("Estrazione Componenti");
        
        System.out.println("Orario: " + now);
        System.out.println("  → getHour()   = " + now.getHour());
        System.out.println("  → getMinute() = " + now.getMinute());
        System.out.println("  → getSecond() = " + now.getSecond());
        System.out.println("  → getNano()   = " + now.getNano() + "\n");
        
        printSubSection("Modifiche");
        
        LocalTime later = lunch.plusHours(2);
        System.out.println("lunch.plusHours(2)     → " + later);
        
        LocalTime soonLater = lunch.plusMinutes(30);
        System.out.println("lunch.plusMinutes(30)  → " + soonLater);
        
        LocalTime earlier = lunch.minusHours(1);
        System.out.println("lunch.minusHours(1)    → " + earlier + "\n");
        
        printSubSection("Orari Predefiniti");
        
        System.out.println("LocalTime.MIN       → " + LocalTime.MIN + " (00:00)");
        System.out.println("LocalTime.MAX       → " + LocalTime.MAX + " (23:59:59.999999999)");
        System.out.println("LocalTime.NOON      → " + LocalTime.NOON + " (12:00)");
        System.out.println("LocalTime.MIDNIGHT  → " + LocalTime.MIDNIGHT + " (00:00)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 5: LocalDateTime - Data + Orario
     * 
     * Mostra come lavorare con data e orario insieme
     */
    private static void demoLocalDateTime() {
        printSection("5. LOCALDATETIME: DATA + ORARIO (senza timezone)");
        
        System.out.println("LocalDateTime combina LocalDate e LocalTime.");
        System.out.println("Es: 2026-02-23T14:30:15\n");
        
        printSubSection("Creazione LocalDateTime");
        
        // Corrente
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime now = LocalDateTime.now();");
        System.out.println("  → now = " + now + "\n");
        
        // Specifico
        LocalDateTime meeting = LocalDateTime.of(2026, 2, 25, 14, 30);
        System.out.println("LocalDateTime meeting = LocalDateTime.of(2026, 2, 25, 14, 30);");
        System.out.println("  → meeting = " + meeting + "\n");
        
        // Da LocalDate + LocalTime
        LocalDate date = LocalDate.of(2026, 3, 10);
        LocalTime time = LocalTime.of(9, 0);
        LocalDateTime combined = LocalDateTime.of(date, time);
        System.out.println("LocalDate date = LocalDate.of(2026, 3, 10);");
        System.out.println("LocalTime time = LocalTime.of(9, 0);");
        System.out.println("LocalDateTime combined = LocalDateTime.of(date, time);");
        System.out.println("  → combined = " + combined + "\n");
        
        // Parsing
        LocalDateTime parsed = LocalDateTime.parse("2026-12-31T23:59:59");
        System.out.println("LocalDateTime.parse(\"2026-12-31T23:59:59\")  → " + parsed + "\n");
        
        printSubSection("Estrazione Componenti");
        
        System.out.println("DateTime: " + now);
        System.out.println("  → toLocalDate()  = " + now.toLocalDate());
        System.out.println("  → toLocalTime()  = " + now.toLocalTime());
        System.out.println("  → getYear()      = " + now.getYear());
        System.out.println("  → getMonth()     = " + now.getMonth());
        System.out.println("  → getDayOfMonth()= " + now.getDayOfMonth());
        System.out.println("  → getHour()      = " + now.getHour());
        System.out.println("  → getMinute()    = " + now.getMinute() + "\n");
        
        printSubSection("Modifiche");
        
        LocalDateTime tomorrow = now.plusDays(1);
        System.out.println("now.plusDays(1)      → " + tomorrow);
        
        LocalDateTime nextHour = now.plusHours(1);
        System.out.println("now.plusHours(1)     → " + nextHour);
        
        LocalDateTime complex = now.plusDays(5).plusHours(3).plusMinutes(30);
        System.out.println("now.plusDays(5).plusHours(3).plusMinutes(30)");
        System.out.println("  → " + complex + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 6: ZonedDateTime - Con timezone
     * 
     * Mostra come gestire date/orari con timezone
     */
    private static void demoZonedDateTime() {
        printSection("6. ZONEDDATETIME: DATA + ORARIO + TIMEZONE");
        
        System.out.println("ZonedDateTime include timezone (es: Europe/Rome, America/New_York).\n");
        
        printSubSection("Creazione ZonedDateTime");
        
        // Corrente con timezone sistema
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("ZonedDateTime now = ZonedDateTime.now();");
        System.out.println("  → now = " + now + "\n");
        
        // Con timezone specifico
        ZonedDateTime romeTime = ZonedDateTime.now(ZoneId.of("Europe/Rome"));
        System.out.println("ZonedDateTime romeTime = ZonedDateTime.now(ZoneId.of(\"Europe/Rome\"));");
        System.out.println("  → romeTime = " + romeTime + "\n");
        
        ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of(\"America/New_York\"));");
        System.out.println("  → nyTime = " + nyTime + "\n");
        
        printSubSection("Conversione Timezone");
        
        ZonedDateTime romeNow = ZonedDateTime.now(ZoneId.of("Europe/Rome"));
        System.out.println("Ora a Roma: " + romeNow.toLocalTime());
        
        ZonedDateTime sameInstantNY = romeNow.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Stesso istante a New York: " + sameInstantNY.toLocalTime());
        System.out.println("  (differenza: " + (romeNow.getHour() - sameInstantNY.getHour()) + " ore)\n");
        
        printSubSection("Zone ID Disponibili");
        
        Set<String> zones = ZoneId.getAvailableZoneIds();
        System.out.println("Zone ID disponibili: " + zones.size());
        System.out.println("\nEsempi:");
        System.out.println("  • Europe/Rome");
        System.out.println("  • America/New_York");
        System.out.println("  • Asia/Tokyo");
        System.out.println("  • UTC");
        System.out.println("  • GMT\n");
        
        printSubSection("💡 Quando Usare ZonedDateTime?");
        
        System.out.println("✓ Eventi internazionali (call con timezone diversi)");
        System.out.println("✓ Schedulazione globale");
        System.out.println("✓ Conversioni tra timezone");
        System.out.println("✓ Applicazioni multi-timezone\n");
        
        System.out.println("✗ Per date/orari locali senza timezone → usa LocalDateTime\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 7: Instant - Timestamp UTC
     * 
     * Mostra l'uso di Instant per timestamp
     */
    private static void demoInstant() {
        printSection("7. INSTANT: TIMESTAMP UTC");
        
        System.out.println("Instant rappresenta un punto nel tempo (timestamp).");
        System.out.println("Secondi/nanosecondi dall'EPOCH (1970-01-01T00:00:00Z UTC).\n");
        
        printSubSection("Creazione Instant");
        
        Instant now = Instant.now();
        System.out.println("Instant now = Instant.now();");
        System.out.println("  → now = " + now + "\n");
        
        Instant epoch = Instant.EPOCH;
        System.out.println("Instant.EPOCH  → " + epoch + " (1970-01-01T00:00:00Z)\n");
        
        // Da secondi epoch
        Instant fromSeconds = Instant.ofEpochSecond(1000000000);
        System.out.println("Instant.ofEpochSecond(1000000000)  → " + fromSeconds + "\n");
        
        // Da millisecondi
        Instant fromMillis = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println("Instant.ofEpochMilli(System.currentTimeMillis())  → " + fromMillis + "\n");
        
        printSubSection("Estrazione Valori");
        
        System.out.println("Instant: " + now);
        System.out.println("  → getEpochSecond() = " + now.getEpochSecond());
        System.out.println("  → toEpochMilli()   = " + now.toEpochMilli());
        System.out.println("  → getNano()        = " + now.getNano() + "\n");
        
        printSubSection("Operazioni");
        
        Instant later = now.plusSeconds(3600);  // +1 ora
        System.out.println("now.plusSeconds(3600)  → " + later);
        
        Instant muchLater = now.plus(5, ChronoUnit.DAYS);
        System.out.println("now.plus(5, ChronoUnit.DAYS)  → " + muchLater + "\n");
        
        printSubSection("Conversione Instant ↔ ZonedDateTime");
        
        Instant instant = Instant.now();
        ZonedDateTime zdt = instant.atZone(ZoneId.of("Europe/Rome"));
        System.out.println("Instant instant = Instant.now();");
        System.out.println("instant.atZone(ZoneId.of(\"Europe/Rome\"))  → " + zdt + "\n");
        
        Instant backToInstant = zdt.toInstant();
        System.out.println("zdt.toInstant()  → " + backToInstant + "\n");
        
        printSubSection("💡 Quando Usare Instant?");
        
        System.out.println("✓ Timestamp per database");
        System.out.println("✓ Log e audit trail");
        System.out.println("✓ Misurazioni performance");
        System.out.println("✓ Eventi machine-to-machine (UTC sempre)");
        System.out.println("✗ Date/orari human-readable → usa LocalDateTime/ZonedDateTime\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 8: Duration - Durata tra tempi
     * 
     * Mostra come calcolare durate in tempo (ore, minuti, secondi)
     */
    private static void demoDuration() {
        printSection("8. DURATION: DURATA TRA TEMPI");
        
        System.out.println("Duration rappresenta una quantità di tempo (ore, minuti, secondi).");
        System.out.println("Usata per differenze tra orari o datetime.\n");
        
        printSubSection("Creazione Duration");
        
        Duration fiveMinutes = Duration.ofMinutes(5);
        System.out.println("Duration.ofMinutes(5)  → " + fiveMinutes + " (PT5M)\n");
        
        Duration twoHours = Duration.ofHours(2);
        System.out.println("Duration.ofHours(2)    → " + twoHours + " (PT2H)\n");
        
        Duration thirtySeconds = Duration.ofSeconds(30);
        System.out.println("Duration.ofSeconds(30) → " + thirtySeconds + " (PT30S)\n");
        
        Duration oneDay = Duration.ofDays(1);
        System.out.println("Duration.ofDays(1)     → " + oneDay + " (PT24H)\n");
        
        printSubSection("Duration Tra Due Tempi");
        
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 30);
        Duration workDay = Duration.between(start, end);
        
        System.out.println("LocalTime start = LocalTime.of(9, 0);");
        System.out.println("LocalTime end = LocalTime.of(17, 30);");
        System.out.println("Duration workDay = Duration.between(start, end);");
        System.out.println("  → workDay = " + workDay);
        System.out.println("  → in ore: " + workDay.toHours() + " h");
        System.out.println("  → in minuti: " + workDay.toMinutes() + " min\n");
        
        printSubSection("Duration Tra DateTime");
        
        LocalDateTime meetingStart = LocalDateTime.of(2026, 2, 23, 14, 0);
        LocalDateTime meetingEnd = LocalDateTime.of(2026, 2, 23, 15, 30);
        Duration meetingDuration = Duration.between(meetingStart, meetingEnd);
        
        System.out.println("Meeting dalle 14:00 alle 15:30");
        System.out.println("  → Duration = " + meetingDuration);
        System.out.println("  → Minuti: " + meetingDuration.toMinutes() + "\n");
        
        printSubSection("Estrazione Componenti");
        
        Duration complex = Duration.ofHours(2).plusMinutes(30).plusSeconds(45);
        System.out.println("Duration: " + complex);
        System.out.println("  → toHours()        = " + complex.toHours());
        System.out.println("  → toMinutes()      = " + complex.toMinutes());
        System.out.println("  → toSeconds()      = " + complex.toSeconds());
        System.out.println("  → getSeconds()     = " + complex.getSeconds());
        System.out.println("  → getNano()        = " + complex.getNano() + "\n");
        
        printSubSection("Operazioni");
        
        Duration d1 = Duration.ofHours(3);
        Duration d2 = Duration.ofMinutes(90);
        
        Duration sum = d1.plus(d2);
        System.out.println("Duration.ofHours(3).plus(Duration.ofMinutes(90))");
        System.out.println("  → " + sum + " (" + sum.toMinutes() + " min)\n");
        
        Duration diff = d1.minus(d2);
        System.out.println("Duration.ofHours(3).minus(Duration.ofMinutes(90))");
        System.out.println("  → " + diff + " (" + diff.toMinutes() + " min)\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 9: Period - Periodo tra date
     * 
     * Mostra come calcolare periodi in date (anni, mesi, giorni)
     */
    private static void demoPeriod() {
        printSection("9. PERIOD: PERIODO TRA DATE");
        
        System.out.println("Period rappresenta una quantità di tempo in giorni, mesi, anni.");
        System.out.println("Usato per differenze tra date.\n");
        
        printSubSection("Creazione Period");
        
        Period oneWeek = Period.ofWeeks(1);
        System.out.println("Period.ofWeeks(1)   → " + oneWeek + " (P7D)\n");
        
        Period oneMonth = Period.ofMonths(1);
        System.out.println("Period.ofMonths(1)  → " + oneMonth + " (P1M)\n");
        
        Period oneYear = Period.ofYears(1);
        System.out.println("Period.ofYears(1)   → " + oneYear + " (P1Y)\n");
        
        Period complex = Period.of(1, 6, 15);  // 1 anno, 6 mesi, 15 giorni
        System.out.println("Period.of(1, 6, 15) → " + complex + " (P1Y6M15D)\n");
        
        printSubSection("Period Tra Due Date");
        
        LocalDate birth = LocalDate.of(1990, 5, 15);
        LocalDate today = LocalDate.now();
        Period age = Period.between(birth, today);
        
        System.out.println("LocalDate birth = LocalDate.of(1990, 5, 15);");
        System.out.println("LocalDate today = LocalDate.now();");
        System.out.println("Period age = Period.between(birth, today);");
        System.out.println("  → age = " + age);
        System.out.println("  → Anni: " + age.getYears());
        System.out.println("  → Mesi: " + age.getMonths());
        System.out.println("  → Giorni: " + age.getDays() + "\n");
        
        printSubSection("Calcolo Età Precisa");
        
        LocalDate birthDate = LocalDate.of(1995, 8, 20);
        LocalDate currentDate = LocalDate.now();
        Period ageNow = Period.between(birthDate, currentDate);
        
        System.out.println("Nato il: " + birthDate);
        System.out.println("Oggi: " + currentDate);
        System.out.println("Età: " + ageNow.getYears() + " anni, " + 
                           ageNow.getMonths() + " mesi, " + 
                           ageNow.getDays() + " giorni\n");
        
        printSubSection("Period vs Duration");
        
        System.out.println("┌──────────┬─────────────────────────────────────────────┐");
        System.out.println("│ TIPO     │              UTILIZZO                       │");
        System.out.println("├──────────┼─────────────────────────────────────────────┤");
        System.out.println("│ Period   │ Differenze in date (anni, mesi, giorni)     │");
        System.out.println("│          │ Usa con LocalDate                            │");
        System.out.println("├──────────┼─────────────────────────────────────────────┤");
        System.out.println("│ Duration │ Differenze in tempo (ore, min, sec)         │");
        System.out.println("│          │ Usa con LocalTime, LocalDateTime, Instant   │");
        System.out.println("└──────────┴─────────────────────────────────────────────┘\n");
        
        printSubSection("Operazioni con Period");
        
        LocalDate start = LocalDate.of(2026, 1, 1);
        Period sixMonths = Period.ofMonths(6);
        LocalDate end = start.plus(sixMonths);
        
        System.out.println("LocalDate start = LocalDate.of(2026, 1, 1);");
        System.out.println("Period sixMonths = Period.ofMonths(6);");
        System.out.println("LocalDate end = start.plus(sixMonths);");
        System.out.println("  → end = " + end + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 10: DateTimeFormatter - Parsing e Formatting
     * 
     * Mostra come formattare e parsare date/orari
     */
    private static void demoFormatting() {
        printSection("10. DATETIMEFORMATTER: PARSING E FORMATTING");
        
        printSubSection("Formatter Predefiniti");
        
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime now2  = ZonedDateTime.now();
        
        System.out.println("LocalDateTime now = LocalDateTime.now();");
        System.out.println("  → now = " + now + "\n");
        
        System.out.println("Formatter predefiniti:");
        System.out.println("  ISO_LOCAL_DATE      → " + now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("  ISO_LOCAL_TIME      → " + now.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("  ISO_LOCAL_DATE_TIME → " + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n");
        
        printSubSection("Formatter Localizzati");
        
        System.out.println("FormatStyle.SHORT  → " + now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
        System.out.println("FormatStyle.MEDIUM → " + now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println("FormatStyle.LONG   → " + now2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
        System.out.println("FormatStyle.FULL   → " + now2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)) + "\n");
        
        printSubSection("Pattern Custom");
        
        DateTimeFormatter custom1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Pattern \"dd/MM/yyyy\"        → " + now.format(custom1));
        
        DateTimeFormatter custom2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Pattern \"dd-MM-yyyy HH:mm:ss\" → " + now.format(custom2));
        
        DateTimeFormatter custom3 = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
        System.out.println("Pattern \"EEEE, dd MMMM yyyy\" → " + now.format(custom3));
        
        DateTimeFormatter custom4 = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Pattern \"HH:mm\"             → " + now.format(custom4) + "\n");
        
        printSubSection("Pattern Symbols");
        
        System.out.println("┌────────┬────────────────────────────────────────────┐");
        System.out.println("│ Symbol │              Significato                   │");
        System.out.println("├────────┼────────────────────────────────────────────┤");
        System.out.println("│ yyyy   │ Anno (4 cifre): 2026                       │");
        System.out.println("│ yy     │ Anno (2 cifre): 26                         │");
        System.out.println("│ MM     │ Mese (numero): 02                          │");
        System.out.println("│ MMM    │ Mese (breve): Feb                          │");
        System.out.println("│ MMMM   │ Mese (completo): Febbraio                  │");
        System.out.println("│ dd     │ Giorno: 23                                 │");
        System.out.println("│ EEE    │ Giorno settimana (breve): Dom              │");
        System.out.println("│ EEEE   │ Giorno settimana (completo): Domenica      │");
        System.out.println("│ HH     │ Ora (24h): 14                              │");
        System.out.println("│ hh     │ Ora (12h): 02                              │");
        System.out.println("│ mm     │ Minuti: 30                                 │");
        System.out.println("│ ss     │ Secondi: 45                                │");
        System.out.println("│ a      │ AM/PM                                      │");
        System.out.println("└────────┴────────────────────────────────────────────┘\n");
        
        printSubSection("Parsing da Stringa");
        
        String dateStr = "23/02/2026";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(dateStr, formatter);
        
        System.out.println("String dateStr = \"23/02/2026\";");
        System.out.println("DateTimeFormatter formatter = DateTimeFormatter.ofPattern(\"dd/MM/yyyy\");");
        System.out.println("LocalDate parsedDate = LocalDate.parse(dateStr, formatter);");
        System.out.println("  → parsedDate = " + parsedDate + "\n");
        
        String timeStr = "14:30:45";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime parsedTime = LocalTime.parse(timeStr, timeFormatter);
        
        System.out.println("LocalTime.parse(\"14:30:45\", formatter)  → " + parsedTime + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 11: TemporalAdjusters - Manipolazioni avanzate
     * 
     * Mostra l'uso di TemporalAdjusters per manipolazioni complesse
     */
    private static void demoTemporalAdjusters() {
        printSection("11. TEMPORALADJUSTERS: MANIPOLAZIONI AVANZATE");
        
        System.out.println("TemporalAdjusters fornisce metodi per manipolazioni date complesse.\n");
        
        LocalDate today = LocalDate.now();
        System.out.println("Oggi: " + today + "\n");
        
        printSubSection("Inizio/Fine Mese");
        
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("Primo giorno del mese  → " + firstDayOfMonth);
        
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Ultimo giorno del mese → " + lastDayOfMonth + "\n");
        
        printSubSection("Inizio/Fine Anno");
        
        LocalDate firstDayOfYear = today.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("Primo giorno dell'anno  → " + firstDayOfYear);
        
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Ultimo giorno dell'anno → " + lastDayOfYear + "\n");
        
        printSubSection("Prossimo/Precedente Giorno della Settimana");
        
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("Prossimo lunedì               → " + nextMonday);
        
        LocalDate nextOrSameMonday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        System.out.println("Prossimo lunedì (o oggi)      → " + nextOrSameMonday);
        
        LocalDate previousFriday = today.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        System.out.println("Venerdì precedente            → " + previousFriday);
        
        LocalDate previousOrSameFriday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));
        System.out.println("Venerdì precedente (o oggi)   → " + previousOrSameFriday + "\n");
        
        printSubSection("N-esimo Giorno del Mese");
        
        LocalDate firstMonday = today.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("Primo lunedì del mese     → " + firstMonday);
        
        LocalDate lastFriday = today.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        System.out.println("Ultimo venerdì del mese   → " + lastFriday);
        
        LocalDate secondWednesday = today.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.WEDNESDAY));
        System.out.println("Secondo mercoledì del mese → " + secondWednesday + "\n");
        
        printSubSection("💡 Esempio Pratico: Calcolo Scadenze");
        
        LocalDate invoiceDate = LocalDate.of(2026, 2, 15);
        LocalDate dueDate = invoiceDate.with(TemporalAdjusters.lastDayOfMonth()).plusMonths(1);
        
        System.out.println("Data fattura: " + invoiceDate);
        System.out.println("Scadenza (ultimo giorno mese successivo): " + dueDate + "\n");
        
        // Prossima data di pagamento (15 del mese)
        LocalDate nextPayday = today.withDayOfMonth(15);
        if (nextPayday.isBefore(today)) {
            nextPayday = nextPayday.plusMonths(1);
        }
        System.out.println("Prossima data pagamento (15 del mese): " + nextPayday + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 12: Comparazioni e Calcoli
     * 
     * Mostra come confrontare e calcolare con date/orari
     */
    private static void demoComparisonsCalculations() {
        printSection("12. COMPARAZIONI E CALCOLI");
        
        printSubSection("Confronto Date");
        
        LocalDate date1 = LocalDate.of(2026, 1, 15);
        LocalDate date2 = LocalDate.of(2026, 3, 20);
        
        System.out.println("LocalDate date1 = LocalDate.of(2026, 1, 15);");
        System.out.println("LocalDate date2 = LocalDate.of(2026, 3, 20);\n");
        
        System.out.println("date1.isBefore(date2)  → " + date1.isBefore(date2));
        System.out.println("date1.isAfter(date2)   → " + date1.isAfter(date2));
        System.out.println("date1.isEqual(date2)   → " + date1.isEqual(date2));
        System.out.println("date1.compareTo(date2) → " + date1.compareTo(date2) + " (negativo se before)\n");
        
        printSubSection("Confronto con Oggi");
        
        LocalDate today = LocalDate.now();
        LocalDate past = LocalDate.of(2020, 1, 1);
        LocalDate future = LocalDate.of(2030, 12, 31);
        
        System.out.println("Oggi: " + today);
        System.out.println("past.isBefore(today)   → " + past.isBefore(today));
        System.out.println("future.isAfter(today)  → " + future.isAfter(today) + "\n");
        
        printSubSection("Calcolo Differenze con ChronoUnit");
        
        LocalDate start = LocalDate.of(2026, 1, 1);
        LocalDate end = LocalDate.of(2026, 12, 31);
        
        long daysBetween = ChronoUnit.DAYS.between(start, end);
        long weeksBetween = ChronoUnit.WEEKS.between(start, end);
        long monthsBetween = ChronoUnit.MONTHS.between(start, end);
        
        System.out.println("Da " + start + " a " + end + ":");
        System.out.println("  → Giorni:  " + daysBetween);
        System.out.println("  → Settimane: " + weeksBetween);
        System.out.println("  → Mesi:    " + monthsBetween + "\n");
        
        printSubSection("Calcolo Differenze Tempo con ChronoUnit");
        
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 30);
        
        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime);
        
        System.out.println("Da " + startTime + " a " + endTime + ":");
        System.out.println("  → Ore:     " + hours);
        System.out.println("  → Minuti:  " + minutes + "\n");
        
        printSubSection("💡 Esempio: Giorni Fino a Natale");
        
        LocalDate now = LocalDate.now();
        LocalDate christmas = LocalDate.of(now.getYear(), 12, 25);
        
        if (christmas.isBefore(now)) {
            christmas = christmas.plusYears(1);  // Natale prossimo anno
        }
        
        long daysUntilChristmas = ChronoUnit.DAYS.between(now, christmas);
        
        System.out.println("Oggi: " + now);
        System.out.println("Natale: " + christmas);
        System.out.println("Giorni mancanti: " + daysUntilChristmas + "\n");
        
        printSubSection("💡 Esempio: Età in Giorni");
        
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        long ageInDays = ChronoUnit.DAYS.between(birthDate, LocalDate.now());
        
        System.out.println("Nato il: " + birthDate);
        System.out.println("Età in giorni: " + ageInDays + "\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 13: Conversioni tra API Vecchia e Nuova
     * 
     * Mostra come convertire tra java.util.Date/Calendar e java.time
     */
    private static void demoConversions() {
        printSection("13. CONVERSIONI: VECCHIA API ↔ NUOVA API");
        
        System.out.println("Quando lavori con codice legacy, serve convertire tra API.\n");
        
        printSubSection("Date → Instant → LocalDateTime");
        
        Date oldDate = new Date();
        System.out.println("Date oldDate = new Date();");
        System.out.println("  → oldDate = " + oldDate + "\n");
        
        // Date → Instant
        Instant instant = oldDate.toInstant();
        System.out.println("Instant instant = oldDate.toInstant();");
        System.out.println("  → instant = " + instant + "\n");
        
        // Instant → LocalDateTime
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();");
        System.out.println("  → localDateTime = " + localDateTime + "\n");
        
        printSubSection("LocalDateTime → Date");
        
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime now = LocalDateTime.now();");
        System.out.println("  → now = " + now + "\n");
        
        // LocalDateTime → Instant → Date
        Instant instantFromLdt = now.atZone(ZoneId.systemDefault()).toInstant();
        Date dateFromLdt = Date.from(instantFromLdt);
        System.out.println("Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());");
        System.out.println("  → date = " + dateFromLdt + "\n");
        
        printSubSection("Calendar → LocalDateTime");
        
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar calendar = Calendar.getInstance();\n");
        
        Instant instantFromCal = calendar.toInstant();
        LocalDateTime ldtFromCal = instantFromCal.atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        System.out.println("LocalDateTime ldt = calendar.toInstant()");
        System.out.println("                           .atZone(ZoneId.systemDefault())");
        System.out.println("                           .toLocalDateTime();");
        System.out.println("  → ldt = " + ldtFromCal + "\n");
        
        printSubSection("LocalDate ↔ java.sql.Date");
        
        LocalDate localDate = LocalDate.of(2026, 2, 23);
        System.out.println("LocalDate localDate = LocalDate.of(2026, 2, 23);\n");
        
        // LocalDate → java.sql.Date
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        System.out.println("java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);");
        System.out.println("  → sqlDate = " + sqlDate + "\n");
        
        // java.sql.Date → LocalDate
        LocalDate localDateBack = sqlDate.toLocalDate();
        System.out.println("LocalDate localDateBack = sqlDate.toLocalDate();");
        System.out.println("  → localDateBack = " + localDateBack + "\n");
        
        printSubSection("📊 Tabella Conversioni Rapide");
        
        System.out.println("┌────────────────────┬─────────────────────────────────────┐");
        System.out.println("│   DA → A           │              METODO                 │");
        System.out.println("├────────────────────┼─────────────────────────────────────┤");
        System.out.println("│ Date → Instant     │ date.toInstant()                    │");
        System.out.println("│ Instant → Date     │ Date.from(instant)                  │");
        System.out.println("│ LocalDate → SQL    │ java.sql.Date.valueOf(localDate)    │");
        System.out.println("│ SQL → LocalDate    │ sqlDate.toLocalDate()               │");
        System.out.println("│ Calendar → Instant │ calendar.toInstant()                │");
        System.out.println("└────────────────────┴─────────────────────────────────────┘\n");
        
        waitForEnter();
    }

    /**
     * SEZIONE 14: Best Practices
     * 
     * Raccolta di best practices professionali per Date/Time
     */
    private static void demoBestPractices() {
        printSection("14. BEST PRACTICES");
        
        printSubSection("1. ✅ USA java.time.*, NON java.util.Date/Calendar");
        
        System.out.println("✓ CORRETTO (moderna, immutabile, chiara):");
        System.out.println("  LocalDate today = LocalDate.now();\n");
        
        System.out.println("✗ EVITA (vecchia API, mutabile, problematica):");
        System.out.println("  Date date = new Date();  // Solo se necessario per legacy\n");
        
        printSubSection("2. ✅ Scegli il Tipo Giusto");
        
        System.out.println("┌─────────────────┬──────────────────────────────────────┐");
        System.out.println("│   SCENARIO      │           USA                        │");
        System.out.println("├─────────────────┼──────────────────────────────────────┤");
        System.out.println("│ Solo data       │ LocalDate                            │");
        System.out.println("│ Solo orario     │ LocalTime                            │");
        System.out.println("│ Data + orario   │ LocalDateTime (locale)               │");
        System.out.println("│ + Timezone      │ ZonedDateTime                        │");
        System.out.println("│ Timestamp UTC   │ Instant                              │");
        System.out.println("│ Durata tempo    │ Duration                             │");
        System.out.println("│ Periodo date    │ Period                               │");
        System.out.println("└─────────────────┴──────────────────────────────────────┘\n");
        
        printSubSection("3. ✅ Usa Instant per Database Timestamp");
        
        System.out.println("✓ CORRETTO (standard UTC):");
        System.out.println("  Instant timestamp = Instant.now();");
        System.out.println("  // Salvare nel DB come TIMESTAMP\n");
        
        System.out.println("✗ EVITA (dipende da timezone server):");
        System.out.println("  LocalDateTime ldt = LocalDateTime.now();");
        System.out.println("  // Ambiguo senza timezone!\n");
        
        printSubSection("4. ✅ Specifica Sempre Timezone per ZonedDateTime");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(\"Europe/Rome\"));\n");
        
        System.out.println("⚠️ ATTENZIONE:");
        System.out.println("  ZonedDateTime.now();  // Usa timezone sistema (può variare!)\n");
        
        printSubSection("5. ✅ Usa DateTimeFormatter per Parsing/Formatting");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  DateTimeFormatter fmt = DateTimeFormatter.ofPattern(\"dd/MM/yyyy\");");
        System.out.println("  String formatted = date.format(fmt);");
        System.out.println("  LocalDate parsed = LocalDate.parse(\"23/02/2026\", fmt);\n");
        
        System.out.println("✗ EVITA:");
        System.out.println("  String formatted = date.toString();  // Formato fisso ISO\n");
        
        printSubSection("6. ✅ Gestisci Eccezioni Parsing");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  try {");
        System.out.println("      LocalDate date = LocalDate.parse(userInput, formatter);");
        System.out.println("  } catch (DateTimeParseException e) {");
        System.out.println("      // Gestisci input invalido");
        System.out.println("  }\n");
        
        printSubSection("7. ✅ Usa TemporalAdjusters per Logica Complessa");
        
        System.out.println("✓ CORRETTO (leggibile):");
        System.out.println("  LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());\n");
        
        System.out.println("✗ EVITA (manuale, error-prone):");
        System.out.println("  LocalDate lastDay = date.withDayOfMonth(");
        System.out.println("      date.getMonth().length(date.isLeapYear()));  // Complesso!\n");
        
        printSubSection("8. ✅ Usa ChronoUnit per Differenze");
        
        System.out.println("✓ CORRETTO:");
        System.out.println("  long days = ChronoUnit.DAYS.between(start, end);\n");
        
        System.out.println("✗ EVITA (manuale):");
        System.out.println("  long days = (end.toEpochDay() - start.toEpochDay());  // Meno chiaro\n");
        
        printSubSection("9. ✅ Valida Date da Input Utente");
        
        System.out.println("✓ SEMPRE valida:");
        System.out.println("  • Range valido (es: data non nel futuro per data nascita)");
        System.out.println("  • Formato corretto");
        System.out.println("  • Gestisci DateTimeParseException\n");
        
        System.out.println("Esempio:");
        System.out.println("  if (birthDate.isAfter(LocalDate.now())) {");
        System.out.println("      throw new IllegalArgumentException(\"Data nascita futura!\");");
        System.out.println("  }\n");
        
        printSubSection("10. ✅ Usa Clock per Testabilità");
        
        System.out.println("✓ CORRETTO (testabile):");
        System.out.println("  public class Service {");
        System.out.println("      private final Clock clock;");
        System.out.println("      ");
        System.out.println("      public Service(Clock clock) {");
        System.out.println("          this.clock = clock;");
        System.out.println("      }");
        System.out.println("      ");
        System.out.println("      public LocalDate getToday() {");
        System.out.println("          return LocalDate.now(clock);  // Iniettabile per test!");
        System.out.println("      }");
        System.out.println("  }\n");
        
        printSubSection("📝 Checklist Finale");
        
        System.out.println("Prima di lavorare con Date/Time, verifica:");
        System.out.println("  ☑ Sto usando java.time.* (non java.util.Date)?");
        System.out.println("  ☑ Ho scelto il tipo giusto (LocalDate/Time/DateTime, Instant)?");
        System.out.println("  ☑ Per timestamp DB, uso Instant?");
        System.out.println("  ☑ Per timezone, specifico esplicitamente ZoneId?");
        System.out.println("  ☑ Per formatting, uso DateTimeFormatter?");
        System.out.println("  ☑ Gestisco DateTimeParseException nel parsing?");
        System.out.println("  ☑ Per calcoli complessi, uso TemporalAdjusters?");
        System.out.println("  ☑ Per differenze, uso ChronoUnit?");
        System.out.println("  ☑ Valido input utente (range, formato)?");
        System.out.println("  ☑ Per test, considero Clock injectable?\n");
        
        printSubSection("💡 Regola d'Oro");
        
        System.out.println("\"Usa java.time.* (Java 8+), NON java.util.Date/Calendar.\"");
        System.out.println("\"Instant per timestamp UTC, LocalDateTime per eventi locali.\"");
        System.out.println("\"Specifica sempre timezone quando rilevante.\"\n");
        
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
        System.out.println("📅 " + sectionTitle);
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
        System.out.println("  ✓ DEMO COMPLETATA - Hai appreso tutto su Date & Time in Java!");
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
