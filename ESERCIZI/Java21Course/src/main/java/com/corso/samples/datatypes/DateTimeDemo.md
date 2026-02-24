# DateTimeDemo - Guida Completa Date & Time in Java

## 📋 Panoramica

- **Package**: `com.corso.samples.datatypes`
- **Classe**: `DateTimeDemo`
- **Metodo principale**: `run()`
- **Scopo**: Dimostrazione completa dell'API Date/Time di Java (java.time.*)

## 🎯 Obiettivi di Apprendimento

Dopo aver completato questo modulo, saprai:

1. **Comprendere l'evoluzione**: Differenze tra API vecchia (Date/Calendar) e nuova (java.time)
2. **LocalDate**: Lavorare con date senza orario
3. **LocalTime**: Gestire orari senza data
4. **LocalDateTime**: Combinare data e orario (senza timezone)
5. **ZonedDateTime**: Gestire timezone e conversioni tra fusi orari
6. **Instant**: Usare timestamp UTC per database e log
7. **Duration**: Calcolare durate in tempo (ore, minuti, secondi)
8. **Period**: Calcolare periodi in date (anni, mesi, giorni)
9. **DateTimeFormatter**: Formattare e parsare date/orari con pattern custom
10. **TemporalAdjusters**: Manipolazioni avanzate (primo/ultimo giorno mese, prossimo lunedì, etc.)
11. **Comparazioni e Calcoli**: Confrontare date e calcolare differenze
12. **Conversioni**: Convertire tra API vecchia e nuova
13. **Best Practices**: Applicare pattern professionali per Date/Time

## 📚 Contenuto del Modulo

### Sezione 1: Introduzione ed Evoluzione API
- Storia delle API Date/Time in Java
- Problemi di java.util.Date (mutabilità, API confusa)
- Problemi di java.util.Calendar (verbosità, month 0-based)
- Vantaggi di java.time.* (immutabilità, chiarezza, thread-safety)
- Panoramica classi principali

### Sezione 2: API Vecchia (java.util.Date/Calendar)
- Breve overview per contesto storico
- Perché evitarla
- Quando è necessaria (integrazione legacy)

### Sezione 3: LocalDate - Date senza orario
- Creazione: `now()`, `of()`, `parse()`
- Estrazione componenti: year, month, day, dayOfWeek
- Manipolazioni: plusDays/Months/Years, minusDays
- Metodi `with` per sostituzione componenti
- Verifica anno bisestile

### Sezione 4: LocalTime - Orario senza data
- Creazione: `now()`, `of()`, `parse()`
- Estrazione componenti: hour, minute, second, nano
- Manipolazioni: plusHours/Minutes, minusHours
- Costanti predefinite: MIN, MAX, NOON, MIDNIGHT

### Sezione 5: LocalDateTime - Data + Orario
- Creazione: `now()`, `of()`, combinazione LocalDate+LocalTime
- Estrazione e conversione: `toLocalDate()`, `toLocalTime()`
- Manipolazioni combinate (plusDays + plusHours)

### Sezione 6: ZonedDateTime - Con timezone
- Creazione con ZoneId specifico
- Conversione tra timezone con `withZoneSameInstant()`
- Zone ID disponibili (Europe/Rome, America/New_York, etc.)
- Quando usare ZonedDateTime vs LocalDateTime

### Sezione 7: Instant - Timestamp UTC
- Rappresentazione timestamp (secondi da epoch)
- Creazione: `now()`, `ofEpochSecond()`, `ofEpochMilli()`
- Conversione Instant ↔ ZonedDateTime
- Quando usare Instant (database, log, eventi machine)

### Sezione 8: Duration - Durata tra tempi
- Creazione: `ofMinutes()`, `ofHours()`, `ofSeconds()`, `ofDays()`
- Calcolo durata tra due LocalTime o LocalDateTime
- Estrazione componenti: toHours(), toMinutes(), toSeconds()
- Operazioni: plus(), minus()

### Sezione 9: Period - Periodo tra date
- Creazione: `ofWeeks()`, `ofMonths()`, `ofYears()`, `of()`
- Calcolo periodo tra due LocalDate
- Applicazione pratica: calcolo età
- Differenza Period vs Duration

### Sezione 10: DateTimeFormatter - Parsing e Formatting
- Formatter predefiniti (ISO_LOCAL_DATE, ISO_DATE_TIME)
- Formatter localizzati (FormatStyle.SHORT/MEDIUM/LONG/FULL)
- Pattern custom con simboli (yyyy, MM, dd, HH, mm, ss, etc.)
- Parsing da stringa con gestione errori

### Sezione 11: TemporalAdjusters - Manipolazioni avanzate
- Primo/ultimo giorno del mese
- Primo/ultimo giorno dell'anno
- Prossimo/precedente giorno della settimana
- N-esimo giorno del mese (es: secondo mercoledì)
- Applicazioni pratiche: calcolo scadenze

### Sezione 12: Comparazioni e Calcoli
- Confronto date: `isBefore()`, `isAfter()`, `isEqual()`
- ChronoUnit per differenze: DAYS, WEEKS, MONTHS, YEARS, HOURS, MINUTES
- Esempi pratici: giorni fino a Natale, età in giorni

### Sezione 13: Conversioni (vecchia ↔ nuova API)
- Date → Instant → LocalDateTime
- LocalDateTime → Instant → Date
- Calendar → LocalDateTime
- LocalDate ↔ java.sql.Date
- Tabella conversioni rapide

### Sezione 14: Best Practices
- Usa java.time.* NON Date/Calendar
- Scegli il tipo giusto per il contesto
- Instant per timestamp database
- Specifica sempre timezone esplicitamente
- DateTimeFormatter per parsing/formatting
- Gestisci DateTimeParseException
- TemporalAdjusters per logica complessa
- ChronoUnit per differenze
- Valida input utente
- Clock injectable per testabilità

## 🔍 Java Time API: Evoluzione

### Perché la Nuova API (java.time)?

| Aspetto | java.util.Date/Calendar | java.time.* |
|---------|-------------------------|-------------|
| **Immutabilità** | ❌ Mutabile | ✅ Immutabile |
| **Thread-safety** | ❌ Non thread-safe | ✅ Thread-safe |
| **API Clarity** | ❌ Confusa, deprecata | ✅ Chiara, fluente |
| **Month Indexing** | ❌ 0-based (0=gennaio) | ✅ 1-based (1=gennaio) |
| **Timezone** | ⚠️ Limitato | ✅ Robusto (IANA DB) |
| **Separazione concetti** | ❌ Date mescola tutto | ✅ LocalDate, LocalTime, etc. |

### Timeline Evoluzione

```
Java 1.0 (1996): java.util.Date
  ↓ Problemi: mutabile, API confusa
Java 1.1 (1997): java.util.Calendar
  ↓ Miglioramenti ma ancora problemi
Java 8 (2014): java.time.* (JSR-310)
  ↓ Ispirata da Joda-Time
Java 21 (2023): Consolidata e matura ✅
```

## 📊 Quale Tipo Usare?

| Scenario | Tipo Raccomandato | Esempio |
|----------|-------------------|---------|
| Solo data (compleanno, scadenza) | `LocalDate` | `LocalDate.of(1990, 5, 15)` |
| Solo orario (sveglia, orario negozio) | `LocalTime` | `LocalTime.of(9, 30)` |
| Data + orario locale | `LocalDateTime` | `LocalDateTime.of(2026, 2, 23, 14, 30)` |
| Data + orario + timezone | `ZonedDateTime` | `ZonedDateTime.now(ZoneId.of("Europe/Rome"))` |
| Timestamp UTC (DB, log) | `Instant` | `Instant.now()` |
| Durata tempo (ore, min, sec) | `Duration` | `Duration.ofHours(2)` |
| Periodo date (anni, mesi, giorni) | `Period` | `Period.ofMonths(6)` |

## 📖 Reference Rapido Classi Principali

### LocalDate - Metodi Principali

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `now()` | Data corrente | `LocalDate.now()` |
| `of(year, month, day)` | Data specifica | `LocalDate.of(2026, 2, 23)` |
| `parse(text)` | Da stringa ISO | `LocalDate.parse("2026-02-23")` |
| `getYear()` | Anno | `2026` |
| `getMonth()` | Mese (enum) | `FEBRUARY` |
| `getMonthValue()` | Mese (numero) | `2` |
| `getDayOfMonth()` | Giorno | `23` |
| `getDayOfWeek()` | Giorno settimana | `SUNDAY` |
| `plusDays(n)` | Aggiunge giorni | `date.plusDays(7)` |
| `minusMonths(n)` | Sottrae mesi | `date.minusMonths(1)` |
| `withYear(year)` | Sostituisce anno | `date.withYear(2030)` |
| `isLeapYear()` | Anno bisestile? | `true/false` |
| `isBefore(other)` | Prima di? | `true/false` |
| `isAfter(other)` | Dopo? | `true/false` |

### LocalTime - Metodi Principali

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `now()` | Orario corrente | `LocalTime.now()` |
| `of(hour, minute)` | Orario specifico | `LocalTime.of(14, 30)` |
| `parse(text)` | Da stringa | `LocalTime.parse("14:30")` |
| `getHour()` | Ora | `14` |
| `getMinute()` | Minuto | `30` |
| `plusHours(n)` | Aggiunge ore | `time.plusHours(2)` |
| `minusMinutes(n)` | Sottrae minuti | `time.minusMinutes(15)` |

### LocalDateTime - Metodi Principali

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `now()` | Data+ora corrente | `LocalDateTime.now()` |
| `of(year, month, day, hour, minute)` | Specifico | `LocalDateTime.of(2026, 2, 23, 14, 30)` |
| `of(date, time)` | Da LocalDate + LocalTime | `LocalDateTime.of(date, time)` |
| `toLocalDate()` | Estrae LocalDate | `LocalDate` |
| `toLocalTime()` | Estrae LocalTime | `LocalTime` |

### ZonedDateTime - Metodi Principali

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `now(ZoneId)` | Con timezone | `ZonedDateTime.now(ZoneId.of("Europe/Rome"))` |
| `withZoneSameInstant(ZoneId)` | Converti timezone | `zdt.withZoneSameInstant(ZoneId.of("America/New_York"))` |

### Instant - Metodi Principali

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `now()` | Timestamp corrente | `Instant.now()` |
| `ofEpochSecond(seconds)` | Da epoch seconds | `Instant.ofEpochSecond(1000000000)` |
| `ofEpochMilli(millis)` | Da epoch millis | `Instant.ofEpochMilli(System.currentTimeMillis())` |
| `atZone(ZoneId)` | A ZonedDateTime | `instant.atZone(ZoneId.systemDefault())` |
| `toEpochMilli()` | A milliseconds | `1234567890000L` |

### Duration - Metodi Principali

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `ofHours(h)` | Durata in ore | `Duration.ofHours(2)` |
| `ofMinutes(m)` | Durata in minuti | `Duration.ofMinutes(30)` |
| `between(start, end)` | Tra due tempi | `Duration.between(time1, time2)` |
| `toHours()` | Converti a ore | `2` |
| `toMinutes()` | Converti a minuti | `120` |

### Period - Metodi Principali

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `ofYears(y)` | Periodo in anni | `Period.ofYears(1)` |
| `ofMonths(m)` | Periodo in mesi | `Period.ofMonths(6)` |
| `between(start, end)` | Tra due date | `Period.between(date1, date2)` |
| `getYears()` | Estrae anni | `1` |
| `getMonths()` | Estrae mesi | `6` |
| `getDays()` | Estrae giorni | `15` |

## 🎨 DateTimeFormatter - Pattern Symbols

| Symbol | Significato | Esempio Output |
|--------|-------------|----------------|
| `yyyy` | Anno (4 cifre) | `2026` |
| `yy` | Anno (2 cifre) | `26` |
| `MM` | Mese (numero 2 cifre) | `02` |
| `MMM` | Mese (nome breve) | `Feb` |
| `MMMM` | Mese (nome completo) | `Febbraio` |
| `dd` | Giorno (2 cifre) | `23` |
| `d` | Giorno | `23` |
| `EEE` | Giorno settimana (breve) | `Dom` |
| `EEEE` | Giorno settimana (completo) | `Domenica` |
| `HH` | Ora 24h (2 cifre) | `14` |
| `hh` | Ora 12h (2 cifre) | `02` |
| `mm` | Minuti (2 cifre) | `30` |
| `ss` | Secondi (2 cifre) | `45` |
| `SSS` | Millisecondi | `123` |
| `a` | AM/PM | `PM` |
| `z` | Timezone | `CET` |
| `Z` | Timezone offset | `+0100` |

### Formatter Predefiniti

| Formatter | Pattern Equivalente | Esempio Output |
|-----------|---------------------|----------------|
| `ISO_LOCAL_DATE` | `yyyy-MM-dd` | `2026-02-23` |
| `ISO_LOCAL_TIME` | `HH:mm:ss` | `14:30:45` |
| `ISO_LOCAL_DATE_TIME` | `yyyy-MM-dd'T'HH:mm:ss` | `2026-02-23T14:30:45` |
| `ISO_DATE` | `yyyy-MM-dd` | `2026-02-23` |
| `ISO_TIME` | `HH:mm:ss` | `14:30:45` |
| `ISO_DATE_TIME` | `yyyy-MM-dd'T'HH:mm:ss` | `2026-02-23T14:30:45` |
| `ISO_INSTANT` | UTC instant | `2026-02-23T13:30:45Z` |
| `BASIC_ISO_DATE` | `yyyyMMdd` | `20260223` |

## 🛠️ TemporalAdjusters - Reference

| TemporalAdjuster | Descrizione | Esempio |
|------------------|-------------|---------|
| `firstDayOfMonth()` | Primo giorno del mese | `date.with(TemporalAdjusters.firstDayOfMonth())` |
| `lastDayOfMonth()` | Ultimo giorno del mese | `date.with(TemporalAdjusters.lastDayOfMonth())` |
| `firstDayOfNextMonth()` | Primo giorno mese prossimo | `date.with(TemporalAdjusters.firstDayOfNextMonth())` |
| `firstDayOfYear()` | Primo giorno dell'anno | `date.with(TemporalAdjusters.firstDayOfYear())` |
| `lastDayOfYear()` | Ultimo giorno dell'anno | `date.with(TemporalAdjusters.lastDayOfYear())` |
| `next(DayOfWeek)` | Prossimo giorno settimana | `date.with(TemporalAdjusters.next(DayOfWeek.MONDAY))` |
| `nextOrSame(DayOfWeek)` | Prossimo o stesso giorno | `date.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY))` |
| `previous(DayOfWeek)` | Precedente giorno settimana | `date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY))` |
| `previousOrSame(DayOfWeek)` | Precedente o stesso giorno | `date.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY))` |
| `firstInMonth(DayOfWeek)` | Primo giorno nel mese | `date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))` |
| `lastInMonth(DayOfWeek)` | Ultimo giorno nel mese | `date.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY))` |
| `dayOfWeekInMonth(n, DayOfWeek)` | N-esimo giorno nel mese | `date.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.WEDNESDAY))` |

## 🔄 Conversioni: API Vecchia ↔ Nuova

| Da | A | Metodo |
|----|---|--------|
| `Date` | `Instant` | `date.toInstant()` |
| `Instant` | `Date` | `Date.from(instant)` |
| `Date` | `LocalDateTime` | `date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()` |
| `LocalDateTime` | `Date` | `Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant())` |
| `Calendar` | `Instant` | `calendar.toInstant()` |
| `Calendar` | `LocalDateTime` | `calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()` |
| `LocalDate` | `java.sql.Date` | `java.sql.Date.valueOf(localDate)` |
| `java.sql.Date` | `LocalDate` | `sqlDate.toLocalDate()` |

## 💡 Esempi Pratici

### Esempio 1: Calcolo Età

```java
LocalDate birthDate = LocalDate.of(1990, 5, 15);
LocalDate today = LocalDate.now();
Period age = Period.between(birthDate, today);

System.out.println("Età: " + age.getYears() + " anni, " + 
                   age.getMonths() + " mesi, " + 
                   age.getDays() + " giorni");
```

### Esempio 2: Giorni Lavorativi in un Mese

```java
LocalDate firstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

long totalDays = ChronoUnit.DAYS.between(firstDay, lastDay) + 1;
long workDays = 0;

for (LocalDate date = firstDay; !date.isAfter(lastDay); date = date.plusDays(1)) {
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
        workDays++;
    }
}

System.out.println("Giorni lavorativi: " + workDays + " su " + totalDays);
```

### Esempio 3: Conversione Timezone per Meeting Internazionale

```java
// Meeting alle 15:00 a Roma
ZonedDateTime romeMeeting = ZonedDateTime.of(
    LocalDate.of(2026, 3, 15),
    LocalTime.of(15, 0),
    ZoneId.of("Europe/Rome")
);

// Stesso istante a New York
ZonedDateTime nyMeeting = romeMeeting.withZoneSameInstant(
    ZoneId.of("America/New_York")
);

// Stesso istante a Tokyo
ZonedDateTime tokyoMeeting = romeMeeting.withZoneSameInstant(
    ZoneId.of("Asia/Tokyo")
);

System.out.println("Roma:     " + romeMeeting.format(DateTimeFormatter.ofPattern("HH:mm")));
System.out.println("New York: " + nyMeeting.format(DateTimeFormatter.ofPattern("HH:mm")));
System.out.println("Tokyo:    " + tokyoMeeting.format(DateTimeFormatter.ofPattern("HH:mm")));
```

### Esempio 4: Durata Lavoro Giornaliero

```java
LocalTime startWork = LocalTime.of(9, 0);
LocalTime lunchStart = LocalTime.of(13, 0);
LocalTime lunchEnd = LocalTime.of(14, 0);
LocalTime endWork = LocalTime.of(18, 30);

Duration morningWork = Duration.between(startWork, lunchStart);
Duration afternoonWork = Duration.between(lunchEnd, endWork);
Duration totalWork = morningWork.plus(afternoonWork);

System.out.println("Lavoro mattutino: " + morningWork.toHours() + "h " + 
                   (morningWork.toMinutes() % 60) + "m");
System.out.println("Lavoro pomeridiano: " + afternoonWork.toHours() + "h " + 
                   (afternoonWork.toMinutes() % 60) + "m");
System.out.println("Totale: " + totalWork.toHours() + "h " + 
                   (totalWork.toMinutes() % 60) + "m");
```

### Esempio 5: Parsing Input Utente con Validazione

```java
String userInput = "23/02/2026";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

try {
    LocalDate date = LocalDate.parse(userInput, formatter);
    
    // Validazione: data non nel passato
    if (date.isBefore(LocalDate.now())) {
        System.out.println("Errore: data nel passato!");
    } else {
        System.out.println("Data valida: " + date);
    }
} catch (DateTimeParseException e) {
    System.out.println("Formato data invalido! Usa: dd/MM/yyyy");
}
```

### Esempio 6: Prossima Data Pagamento (15 del mese)

```java
LocalDate today = LocalDate.now();
LocalDate nextPayday = today.withDayOfMonth(15);

if (nextPayday.isBefore(today) || nextPayday.isEqual(today)) {
    // Se il 15 è già passato questo mese, vai al mese prossimo
    nextPayday = nextPayday.plusMonths(1);
}

long daysUntilPayday = ChronoUnit.DAYS.between(today, nextPayday);
System.out.println("Prossima data pagamento: " + nextPayday);
System.out.println("Giorni rimanenti: " + daysUntilPayday);
```

### Esempio 7: Scadenza Fattura (fine mese successivo)

```java
LocalDate invoiceDate = LocalDate.of(2026, 2, 15);
LocalDate dueDate = invoiceDate
    .with(TemporalAdjusters.lastDayOfMonth())
    .plusMonths(1);

System.out.println("Data fattura: " + invoiceDate);
System.out.println("Scadenza: " + dueDate);
```

## ✅ Best Practices

### 1. ✅ USA java.time.*, NON java.util.Date/Calendar

**Corretto:**
```java
LocalDate today = LocalDate.now();
LocalDateTime now = LocalDateTime.now();
```

**Evita:**
```java
Date date = new Date();  // Solo per legacy
Calendar cal = Calendar.getInstance();  // Solo per legacy
```

### 2. ✅ Scegli il Tipo Giusto

- **LocalDate**: Compleanno, scadenza, data evento (senza orario)
- **LocalTime**: Orario apertura, sveglia (senza data)
- **LocalDateTime**: Appuntamento locale (senza timezone)
- **ZonedDateTime**: Meeting internazionale (con timezone)
- **Instant**: Timestamp database, log (UTC)

### 3. ✅ Instant per Database Timestamp

**Corretto:**
```java
Instant timestamp = Instant.now();
// Salva nel DB come TIMESTAMP
```

**Evita:**
```java
LocalDateTime ldt = LocalDateTime.now();
// Ambiguo senza timezone!
```

### 4. ✅ Specifica Sempre Timezone

**Corretto:**
```java
ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Europe/Rome"));
```

**Attenzione:**
```java
ZonedDateTime.now();  // Usa timezone sistema (può variare!)
```

### 5. ✅ DateTimeFormatter per Parsing/Formatting

**Corretto:**
```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String formatted = date.format(formatter);
LocalDate parsed = LocalDate.parse("23/02/2026", formatter);
```

**Evita:**
```java
String s = date.toString();  // Formato fisso ISO
```

### 6. ✅ Gestisci DateTimeParseException

```java
try {
    LocalDate date = LocalDate.parse(userInput, formatter);
} catch (DateTimeParseException e) {
    // Gestisci input invalido
    System.err.println("Formato data invalido!");
}
```

### 7. ✅ TemporalAdjusters per Logica Complessa

**Corretto (leggibile):**
```java
LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
```

**Evita (manuale, error-prone):**
```java
int lastDayNum = date.getMonth().length(date.isLeapYear());
LocalDate lastDay = date.withDayOfMonth(lastDayNum);
```

### 8. ✅ ChronoUnit per Differenze

**Corretto:**
```java
long days = ChronoUnit.DAYS.between(start, end);
long hours = ChronoUnit.HOURS.between(startTime, endTime);
```

### 9. ✅ Valida Input Utente

```java
LocalDate birthDate = LocalDate.parse(input, formatter);

// Valida range
if (birthDate.isAfter(LocalDate.now())) {
    throw new IllegalArgumentException("Data nascita futura!");
}

// Valida età minima
if (ChronoUnit.YEARS.between(birthDate, LocalDate.now()) < 18) {
    throw new IllegalArgumentException("Età minima 18 anni!");
}
```

### 10. ✅ Clock Injectable per Testabilità

```java
public class BookingService {
    private final Clock clock;
    
    public BookingService(Clock clock) {
        this.clock = clock;
    }
    
    public Booking createBooking() {
        LocalDateTime now = LocalDateTime.now(clock);  // Testabile!
        // ...
    }
}

// Nei test:
Clock fixedClock = Clock.fixed(Instant.parse("2026-02-23T14:00:00Z"), ZoneId.of("UTC"));
BookingService service = new BookingService(fixedClock);
```

## 📝 Checklist Finale

Prima di lavorare con Date/Time, verifica:

- [ ] Sto usando `java.time.*` (NON `java.util.Date/Calendar`)?
- [ ] Ho scelto il tipo giusto (`LocalDate`/`LocalTime`/`LocalDateTime`/`ZonedDateTime`/`Instant`)?
- [ ] Per timestamp database, uso `Instant`?
- [ ] Per timezone, specifico esplicitamente `ZoneId`?
- [ ] Per formatting, uso `DateTimeFormatter`?
- [ ] Gestisco `DateTimeParseException` nel parsing?
- [ ] Per logica complessa, uso `TemporalAdjusters`?
- [ ] Per differenze, uso `ChronoUnit`?
- [ ] Valido input utente (range, formato)?
- [ ] Per test, considero `Clock` injectable?

## 🎯 Regola d'Oro

> **"Usa java.time.* (Java 8+), NON java.util.Date/Calendar."**
> 
> **"Instant per timestamp UTC, LocalDateTime per eventi locali."**
> 
> **"Specifica sempre timezone quando rilevante (ZonedDateTime)."**

## 🚀 Come Eseguire

### Opzione 1: Da Menu Principale
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.corso.demo.App"
# Seleziona: [7] Date & Time
```

### Opzione 2: Esecuzione Diretta
```bash
mvn exec:java -Dexec.mainClass="com.corso.samples.datatypes.DateTimeDemo" -Dexec.classpathScope=compile
```

## 📂 Struttura del Codice

```
DateTimeDemo
├── run()                               ← Metodo principale
│
├── demoIntroduction()                  ← Evoluzione API Date/Time
├── demoLegacyAPI()                     ← java.util.Date/Calendar (cenni)
├── demoLocalDate()                     ← Date senza orario
├── demoLocalTime()                     ← Orario senza data
├── demoLocalDateTime()                 ← Data + Orario
├── demoZonedDateTime()                 ← Con timezone
├── demoInstant()                       ← Timestamp UTC
├── demoDuration()                      ← Durata tra tempi
├── demoPeriod()                        ← Periodo tra date
├── demoFormatting()                    ← Parsing e Formatting
├── demoTemporalAdjusters()             ← Manipolazioni avanzate
├── demoComparisonsCalculations()       ← Confronti e calcoli
├── demoConversions()                   ← Vecchia ↔ Nuova API
├── demoBestPractices()                 ← Best Practices
│
└── Utility Methods
    ├── printHeader()
    ├── printSection()
    ├── printSubSection()
    ├── printFooter()
    └── waitForEnter()
```

## 📚 Riferimenti

- [Java Time API - Oracle Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/package-summary.html)
- [LocalDate JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDate.html)
- [LocalDateTime JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDateTime.html)
- [ZonedDateTime JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/ZonedDateTime.html)
- [Instant JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Instant.html)
- [DateTimeFormatter JavaDoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/format/DateTimeFormatter.html)
- [JSR 310: Date and Time API](https://jcp.org/en/jsr/detail?id=310)
- [Effective Java (3rd Edition) - Item 67: Use the standard Date and Time API](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/)

---

**📅 Data & Time in Java - La guida definitiva per padroneggiare l'API java.time!**
