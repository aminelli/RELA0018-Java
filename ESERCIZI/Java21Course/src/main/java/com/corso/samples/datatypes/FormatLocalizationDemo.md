# FormatLocalizationDemo - Format e Localization in Java

## Panoramica

Questa demo fornisce una guida completa e dettagliata su **formattazione** e **localizzazione** in Java, elementi essenziali per creare applicazioni internazionali e user-friendly.

- **Package**: `com.corso.samples.datatypes`
- **Classe**: `FormatLocalizationDemo`
- **Metodo principale**: `run()`
- **Scopo**: Insegnare come formattare e localizzare numeri, valute, percentuali, date, stringhe per utenti di diverse culture e lingue

## Obiettivi di apprendimento

Al termine di questa demo, sarai in grado di:

1. Comprendere i concetti di **Formatting**, **Localization (L10n)** e **Internationalization (i18n)**
2. Usare **NumberFormat** per formattare numeri, valute e percentuali
3. Creare **pattern personalizzati** con DecimalFormat
4. Applicare **String.format()** per formattazione printf-style
5. Gestire **MessageFormat** per messaggi parametrizzati
6. Lavorare con **Locale** per rappresentare lingua e regione
7. Formattare **numeri** in diverse culture (Italia, USA, Francia, Germania)
8. Gestire **valute** con Currency e CurrencyInstance
9. Formattare **date/time** localizzate con DateTimeFormatter
10. Usare **CompactNumberFormat** per numeri compatti (1K, 1M, 1B)
11. Implementare **pluralizzazione** con ChoiceFormat
12. Ordinare stringhe con **Collator** (locale-aware)
13. Fare **parsing** da stringhe formattate a numeri
14. Applicare **best practices** per i18n e l10n

## Contenuto del modulo

### 1. Introduzione a Format e Localization
- Cosa sono Formatting, Localization (L10n), Internationalization (i18n)
- Perché sono importanti per applicazioni globali
- Panoramica delle API Java: NumberFormat, DecimalFormat, String.format(), MessageFormat, Locale, DateTimeFormatter, CompactNumberFormat, ChoiceFormat, Collator, ResourceBundle
- Esempi di differenze culturali nella formattazione (Italia vs USA vs Germania vs Francia)

### 2. NumberFormat - Formattazione Base
- `getInstance()`: formattazione numeri generici
- `getCurrencyInstance()`: formattazione valute con simboli (€, $, £)
- `getPercentInstance()`: formattazione percentuali
- Controllo cifre decimali: `setMinimumFractionDigits()`, `setMaximumFractionDigits()`
- Controllo cifre intere: `setMinimumIntegerDigits()` (padding con zeri)

### 3. DecimalFormat - Pattern Personalizzati
- Simboli pattern: `0` (cifra obbligatoria), `#` (cifra opzionale), `.` (decimale), `,` (migliaia), `%`, `‰`, `E` (notazione scientifica)
- Pattern base: `0000.00` vs `####.##`
- Separatori migliaia: `#,###.00`
- Pattern per valute: `€ #,##0.00`, `#,##0.00 €`
- Pattern per percentuali: `0.0%`, `##0.00%`
- Notazione scientifica: `0.###E0`
- Pattern differenziati positivi/negativi: `#,##0.00;(#,##0.00)`
- DecimalFormatSymbols per controllo locale

### 4. String.format() - Formattazione Printf-Style
- Specifier: `%s` (String), `%d` (Integer), `%f` (Float/Double), `%n` (newline), `%%` (literal %)
- Formattazione stringhe: `String.format("Ciao, %s!", name)`
- Formattazione numeri interi: `%d`, `%05d` (padding con zeri)
- Formattazione decimali: `%.2f`, `%.5f`, `%.10f`
- Larghezza e allineamento: `%-15s` (sinistra), `%10.2f` (destra)
- Argomenti multipli e posizionali: `%2$d/%3$d/%1$d`
- `formatted()` (Java 15+): metodo instance più fluent

### 5. MessageFormat - Messaggi Parametrizzati
- Parametri sostituibili: `{0}`, `{1}`, `{2}`, ...
- Formattazione automatica: `{0,number,currency}`, `{0,number,percent}`
- Formattazione date: `{0,date,long}`, `{0,time,short}`
- Riutilizzo parametri: stesso `{0}` più volte
- Metodo statico `MessageFormat.format()` per uso rapido

### 6. Locale - Lingua e Regione
- Componenti: Lingua (ISO 639: it, en, de), Paese (ISO 3166: IT, US, GB), Variante
- Creazione: costanti predefinite (`Locale.ITALY`, `Locale.US`), costruttore `new Locale("it", "IT")`, builder, `forLanguageTag("it-IT")`
- Locale di default: `Locale.getDefault()`
- Locale comuni: ITALY, US, UK, FRANCE, GERMANY, JAPAN, CHINA
- Informazioni locale: `getLanguage()`, `getCountry()`, `getDisplayName()`, `getDisplayLanguage()`, `getDisplayCountry()`

### 7. NumberFormat con Diversi Locale
- Stesso numero formattato in culture diverse
- Italia: punto migliaia, virgola decimali (1.234.567,89)
- USA: virgola migliaia, punto decimali (1,234,567.89)
- Francia: spazio migliaia, virgola decimali (1 234 567,89)
- Germania: come Italia
- UK: come USA
- Percentuali in diversi locale

### 8. Currency Format con Diversi Locale
- Euro (€) - Italia
- Dollar ($) - USA
- Pound (£) - UK
- Yen (¥) - Japan
- Yuan (¥) - China
- Franc (CHF) - Svizzera
- Classe Currency: `getCurrencyCode()`, `getSymbol()`, `getDefaultFractionDigits()`, `getDisplayName()`
- Impostare currency personalizzata: `setCurrency()`

### 9. DateTime Format con Locale
- Stili predefiniti: SHORT, MEDIUM, LONG, FULL
- Formattazione date con `DateTimeFormatter.ofLocalizedDate()`
- Nomi mesi localizzati: "febbraio" (IT), "February" (EN), "février" (FR), "Februar" (DE)
- Nomi giorni localizzati: "domenica", "Sunday", "dimanche", "Sonntag", "日曜日" (JP)
- Pattern personalizzati con locale: `ofPattern("EEEE d MMMM yyyy", locale)`

### 10. CompactNumberFormat - Numeri Compatti
- Stile SHORT: 1K, 1M, 1B (Java 12+)
- Stile LONG: 1 migliaio, 1 milione, 1 miliardo
- Differenze tra locale (Mrd, Bn, etc.)
- Uso pratico: dashboard, social media, grafici, dimensioni file

### 11. ChoiceFormat - Pluralizzazione
- Range numerici: `{0, 1, 2}` → `{"nessun messaggio", "un messaggio", "{0} messaggi"}`
- Integrazione con MessageFormat: `{0,choice,0#no files|1#one file|2#{0} files}`
- Categorizzazione per range: insufficiente/sufficiente/buono/ottimo
- Sintassi pattern string: `"0#nessun file|1#un file|2#molti file"`

### 12. Collator - Ordinamento Localizzato
- Ordinamento stringhe rispettando regole linguistiche
- Gestione accenti e caratteri speciali (café vs cafe)
- Livelli di forza: PRIMARY (ignora accenti/case), SECONDARY (considera accenti), TERTIARY (considera accenti e case)
- Ordinamento tedesco con ß (eszett)
- Case sensitivity configurabile
- Confronto con ordinamento standard String.compareTo()

### 13. Parsing - Da Stringhe Formattate a Numeri
- `NumberFormat.parse()`: da string localizzata a Number
- Parsing valute: rimuove simbolo € e formattazione
- Parsing percentuali: converte da % a decimale (85,6% → 0.856)
- Parsing con DecimalFormat
- Gestione ParseException (obbligatoria!)

### 14. Best Practices
- Usa SEMPRE Locale esplicito per applicazioni internazionali
- NON concatenare stringhe per i18n (usa MessageFormat)
- Usa ResourceBundle per testi localizzati
- Gestisci SEMPRE ParseException nel parsing
- Usa DecimalFormat per pattern personalizzati complessi
- Considera CompactNumberFormat per UI moderne
- Usa ChoiceFormat per pluralizzazione (non if/else semplici)
- Usa Collator per ordinamento internazionale
- Testa con DIVERSI Locale (IT, US, JP, ar)
- Separa logica da presentazione

## Caratteristiche Fondamentali

### Concetti Chiave

| Concetto | Descrizione | Esempio |
|----------|-------------|---------|
| **Formatting** | Conversione dati → stringhe leggibili | 1234.56 → "1.234,56 €" |
| **Localization (L10n)** | Adattamento app a lingue/culture diverse | "Welcome" → "Benvenuto" |
| **Internationalization (i18n)** | Progettazione app per supportare multiple lingue | Uso Locale, ResourceBundle |
| **Locale** | Combinazione lingua + regione + variante | `it_IT`, `en_US`, `fr_FR` |
| **Currency** | Rappresentazione valuta con codice ISO | EUR (€), USD ($), GBP (£) |

## Reference Rapido - API Principali

### NumberFormat

| Metodo | Descrizione | Esempio |
|--------|-------------|---------|
| `getInstance(locale)` | Formatta numeri generici | `1234567.89` → `"1.234.567,89"` (IT) |
| `getCurrencyInstance(locale)` | Formatta valute | `1299.99` → `"€ 1.299,99"` (IT) |
| `getPercentInstance(locale)` | Formatta percentuali | `0.789` → `"79%"` (IT) |
| `getCompactNumberInstance(locale, style)` | Formatta numeri compatti | `1000000` → `"1 Mln"` (IT) |
| `setMinimumFractionDigits(n)` | Minimo cifre decimali | Almeno n decimali |
| `setMaximumFractionDigits(n)` | Massimo cifre decimali | Al massimo n decimali |
| `setMinimumIntegerDigits(n)` | Minimo cifre intere (padding) | `7.5` → `"0007,5"` con n=4 |
| `parse(string)` | Parsing string → Number | `"1.234,56"` → `1234.56` (IT) |

### DecimalFormat - Simboli Pattern

| Simbolo | Significato | Esempio Pattern | Input | Output |
|---------|-------------|-----------------|-------|--------|
| `0` | Cifra obbligatoria | `0000.00` | `12.5` | `0012,50` |
| `#` | Cifra opzionale | `####.##` | `12.5` | `12,5` |
| `.` | Separatore decimale | `#.00` | `12.5` | `12,50` |
| `,` | Separatore migliaia | `#,##0` | `1234` | `1.234` |
| `%` | Percentuale (×100) | `0.0%` | `0.856` | `85,6%` |
| `‰` | Per-mille (×1000) | `0.0‰` | `0.0856` | `85,6‰` |
| `E` | Notazione scientifica | `0.0E0` | `1234` | `1,2E3` |
| `;` | Separatore pos/neg | `#,##0;(#,##0)` | `-1234` | `(1.234)` |

### String.format() - Specifier

| Specifier | Tipo | Esempio | Output |
|-----------|------|---------|--------|
| `%s` | String | `String.format("%s", "Mario")` | `"Mario"` |
| `%d` | Integer | `String.format("%d", 42)` | `"42"` |
| `%05d` | Integer padded | `String.format("%05d", 42)` | `"00042"` |
| `%f` | Float/Double | `String.format("%.2f", 3.14159)` | `"3.14"` |
| `%-15s` | String left-aligned | `String.format("%-15s", "Java")` | `"Java           "` |
| `%10.2f` | Float right-aligned | `String.format("%10.2f", 3.14)` | `"      3.14"` |
| `%n` | Newline | `String.format("Line1%nLine2")` | `"Line1\nLine2"` |
| `%%` | Literal % | `String.format("100%%")` | `"100%"` |
| `%2$d` | Positional argument | `String.format("%2$d-%1$d", 12, 31)` | `"31-12"` |

### MessageFormat - Pattern

| Pattern | Descrizione | Esempio |
|---------|-------------|---------|
| `{0}` | Parametro 0 | `"Ciao {0}!"` → `"Ciao Mario!"` |
| `{0,number}` | Numero | `"{0,number}"` → `"1.234"` |
| `{0,number,currency}` | Valuta | `"{0,number,currency}"` → `"€ 1.234,56"` |
| `{0,number,percent}` | Percentuale | `"{0,number,percent}"` → `"79%"` |
| `{0,date,short}` | Data breve | `"{0,date,short}"` → `"23/02/26"` |
| `{0,date,long}` | Data estesa | `"{0,date,long}"` → `"23 febbraio 2026"` |
| `{0,time,short}` | Ora breve | `"{0,time,short}"` → `"14:30"` |
| `{0,choice,pattern}` | Scelta condizionale | `"{0,choice,0#zero|1#uno|2#molti}"` |

### Locale - Costanti Comuni

| Costante | Codice | Display Name (IT) | Lingua | Paese |
|----------|--------|-------------------|--------|-------|
| `Locale.ITALY` | `it_IT` | italiano (Italia) | it | IT |
| `Locale.US` | `en_US` | inglese (Stati Uniti) | en | US |
| `Locale.UK` | `en_GB` | inglese (Regno Unito) | en | GB |
| `Locale.FRANCE` | `fr_FR` | francese (Francia) | fr | FR |
| `Locale.GERMANY` | `de_DE` | tedesco (Germania) | de | DE |
| `Locale.JAPAN` | `ja_JP` | giapponese (Giappone) | ja | JP |
| `Locale.CHINA` | `zh_CN` | cinese (Cina) | zh | CN |

### Collator - Livelli di Forza

| Forza | Valore | Accenti | Case | Esempio Uguaglianza |
|-------|--------|---------|------|---------------------|
| PRIMARY | 0 | ✗ Ignora | ✗ Ignora | `"cote"` = `"côté"` |
| SECONDARY | 1 | ✓ Considera | ✗ Ignora | `"cote"` ≠ `"côte"`, `"Cote"` = `"cote"` |
| TERTIARY | 2 | ✓ Considera | ✓ Considera | `"Cote"` ≠ `"cote"` |
| IDENTICAL | 3 | ✓ Considera | ✓ Considera | Confronto identico carattere per carattere |

## Tabella Formattazione per Locale

### Numero: 1234567.89

| Locale | Formato | Descrizione |
|--------|---------|-------------|
| 🇮🇹 Italia (it_IT) | `1.234.567,89` | Punto migliaia, virgola decimale |
| 🇺🇸 USA (en_US) | `1,234,567.89` | Virgola migliaia, punto decimale |
| 🇫🇷 Francia (fr_FR) | `1 234 567,89` | Spazio migliaia, virgola decimale |
| 🇩🇪 Germania (de_DE) | `1.234.567,89` | Punto migliaia, virgola decimale |
| 🇬🇧 UK (en_GB) | `1,234,567.89` | Virgola migliaia, punto decimale |
| 🇯🇵 Giappone (ja_JP) | `1,234,567.89` | Virgola migliaia, punto decimale |

### Valuta: 1299.99

| Locale | Currency | Formato | Simbolo |
|--------|----------|---------|---------|
| 🇮🇹 Italia | EUR | `€ 1.299,99` | € |
| 🇺🇸 USA | USD | `$1,299.99` | $ |
| 🇬🇧 UK | GBP | `£1,299.99` | £ |
| 🇯🇵 Giappone | JPY | `¥1,300` | ¥ (0 decimali) |
| 🇨🇳 Cina | CNY | `¥1,299.99` | ¥ |
| 🇨🇭 Svizzera | CHF | `CHF 1'299.99` | CHF |

## Esempi Pratici

### Esempio 1: Formattazione Numeri Multi-Locale

```java
double value = 1234567.89;

// Italia
NumberFormat nfIT = NumberFormat.getInstance(Locale.ITALY);
System.out.println("Italia:  " + nfIT.format(value));  // 1.234.567,89

// USA
NumberFormat nfUS = NumberFormat.getInstance(Locale.US);
System.out.println("USA:     " + nfUS.format(value));  // 1,234,567.89

// Francia
NumberFormat nfFR = NumberFormat.getInstance(Locale.FRANCE);
System.out.println("Francia: " + nfFR.format(value));  // 1 234 567,89
```

### Esempio 2: Formattazione Valute

```java
double amount = 1299.99;
Locale[] locales = {Locale.ITALY, Locale.US, Locale.UK, Locale.JAPAN};

for (Locale locale : locales) {
    NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
    System.out.println(locale + ": " + cf.format(amount));
}
// Output:
// it_IT: € 1.299,99
// en_US: $1,299.99
// en_GB: £1,299.99
// ja_JP: ¥1,300
```

### Esempio 3: Pattern DecimalFormat Personalizzato

```java
double price = 19.99;
DecimalFormat df = new DecimalFormat("€ #,##0.00", 
    DecimalFormatSymbols.getInstance(Locale.ITALY));

System.out.println(df.format(price));  // € 19,99
```

### Esempio 4: MessageFormat per Messaggi Parametrizzati

```java
String pattern = "Hai {0,choice,0#nessun file|1#un file|2#{0} file} da caricare.";
MessageFormat mf = new MessageFormat(pattern, Locale.ITALY);

System.out.println(mf.format(new Object[]{0}));  // Hai nessun file da caricare.
System.out.println(mf.format(new Object[]{1}));  // Hai un file da caricare.
System.out.println(mf.format(new Object[]{5}));  // Hai 5 file da caricare.
```

### Esempio 5: CompactNumberFormat per Dashboard

```java
long views = 1_234_567L;
NumberFormat compact = NumberFormat.getCompactNumberInstance(
    Locale.ITALY, NumberFormat.Style.SHORT);

System.out.println(compact.format(views));  // 1 Mln
// Ideale per dashboard: "1.2M views" invece di "1,234,567 views"
```

### Esempio 6: Ordinamento Localizzato con Collator

```java
String[] words = {"élève", "école", "ecole", "cafe", "café"};

// Ordinamento standard (sbagliato per locale)
Arrays.sort(words);
System.out.println("Standard: " + Arrays.toString(words));
// [cafe, café, ecole, eleve, école, élève]  ← NON rispetta regole francesi!

// Ordinamento con Collator (corretto)
Collator collator = Collator.getInstance(Locale.FRANCE);
Arrays.sort(words, collator);
System.out.println("Collator: " + Arrays.toString(words));
// [cafe, café, ecole, école, eleve, élève]  ← Rispetta accenti!
```

### Esempio 7: Parsing da String Formattata

```java
String italianPrice = "€ 1.234,56";
NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.ITALY);

try {
    Number parsed = cf.parse(italianPrice);
    double amount = parsed.doubleValue();
    System.out.println("Parsed: " + amount);  // 1234.56
} catch (ParseException e) {
    System.err.println("Errore parsing: " + e.getMessage());
}
```

### Esempio 8: Date Localizzate

```java
LocalDate date = LocalDate.of(2026, 2, 23);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
    "EEEE d MMMM yyyy", Locale.ITALY);

System.out.println(date.format(formatter));  
// domenica 23 febbraio 2026

formatter = formatter.withLocale(Locale.US);
System.out.println(date.format(formatter));  
// Sunday 23 February 2026
```

## Best Practices

### 1. Usa SEMPRE Locale Esplicito

**✓ CORRETTO:**
```java
NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
// Esplicito e prevedibile
```

**✗ EVITA:**
```java
NumberFormat nf = NumberFormat.getInstance();
// Usa locale di default del sistema, imprevedibile!
```

### 2. NON Concatenare Stringhe per i18n

**✓ CORRETTO:**
```java
String msg = MessageFormat.format("Hai {0} messaggi", count);
// Parametri sostituibili, ordine modificabile
```

**✗ EVITA:**
```java
String msg = "Hai " + count + " messaggi";
// Ordine parole varia tra lingue!
```

### 3. Usa ResourceBundle per Testi Localizzati

**✓ CORRETTO:**
```java
ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
String welcome = bundle.getString("welcome.message");
// File properties separati per ogni lingua
```

**✗ EVITA:**
```java
String welcome = (lang.equals("it")) ? "Benvenuto" : "Welcome";
// Hardcoded, non scalabile
```

### 4. Gestisci SEMPRE ParseException

**✓ CORRETTO:**
```java
try {
    Number num = NumberFormat.getInstance(locale).parse(input);
} catch (ParseException e) {
    // Gestisci errore appropriatamente
}
```

**✗ EVITA:**
```java
Number num = NumberFormat.getInstance().parse(input);
// ParseException non gestita!
```

### 5. Usa DecimalFormat per Pattern Complessi

**QUANDO:**
- Serve controllo preciso su formato (padding, simboli custom)
- Pattern ripetuto in applicazione

**✓ ESEMPIO:**
```java
DecimalFormat df = new DecimalFormat("#,##0.00 €", symbols);
```

### 6. Considera CompactNumberFormat per UI

**IDEALE PER:**
- Dashboard e analytics (1.2M views)
- Social media (15K followers)
- Grafici con numeri grandi

### 7. Usa ChoiceFormat per Pluralizzazione

**✓ CORRETTO:**
```java
MessageFormat mf = new MessageFormat(
    "{0,choice,0#no files|1#one file|2#{0} files}");
```

**✗ EVITA:**
```java
String msg = count == 1 ? "1 file" : count + " files";
// Non funziona per tutte le lingue (russo ha 3+ forme plurali!)
```

### 8. Usa Collator per Ordinamento

**✓ CORRETTO:**
```java
Collator collator = Collator.getInstance(locale);
Arrays.sort(words, collator);
// Rispetta regole linguistiche (accenti, ß tedesco, ecc.)
```

**✗ EVITA:**
```java
Arrays.sort(words); // String.compareTo, non locale-aware
```

### 9. Testa con DIVERSI Locale

**LOCALE DA TESTARE SEMPRE:**
- `Locale.ITALY` (virgola decimale, punto migliaia)
- `Locale.US` (punto decimale, virgola migliaia)
- `Locale.JAPAN` (ideogrammi, nessun spazio)
- `Locale.forLanguageTag("ar")` (right-to-left!)

### 10. Separa Logica da Presentazione

**✓ PRINCIPIO:**
- Lavora con `Date`, `Number`, `BigDecimal` internamente
- Formatta SOLO per presentazione all'utente
- Parsing SOLO da input utente (mai da dati interni)

## Checklist Finale

Prima di rilasciare codice internazionale, verifica:

- ☑ Tutti i NumberFormat usano Locale esplicito?
- ☑ Nessuna concatenazione di stringhe per messaggi utente?
- ☑ ResourceBundle configurato per tutte le lingue target?
- ☑ ParseException sempre gestita?
- ☑ Date/numeri formattati solo per UI, mai per storage?
- ☑ Ordinamento usa Collator per testo localizzato?
- ☑ Pluralizzazione gestita con ChoiceFormat/MessageFormat?
- ☑ Testing fatto con almeno 3 locale diversi?
- ☑ Currency corretta per ogni locale?
- ☑ Pattern DecimalFormat testati con locale simboli?

## Regola d'oro

> **"NumberFormat.getInstance(locale) NON getInstance()"**
> 
> **"MessageFormat per messaggi, NON concatenazione stringhe"**
> 
> **"Collator per ordinare, NON Arrays.sort() diretto su String"**

## Come eseguire

### Opzione 1: Dal menu dell'applicazione

```bash
mvn clean compile
mvn exec:java
# Seleziona l'opzione [9] Format e Localization dal menu
```

### Opzione 2: Esecuzione diretta

```bash
mvn exec:java -Dexec.mainClass="com.corso.samples.datatypes.FormatLocalizationDemo"
```

## Struttura del codice

```
FormatLocalizationDemo
├── run()                               // Metodo principale
├── demoIntroduction()                  // 1. Introduzione concetti
├── demoNumberFormatBasics()            // 2. NumberFormat base
├── demoDecimalFormat()                 // 3. Pattern DecimalFormat
├── demoStringFormat()                  // 4. String.format()
├── demoMessageFormat()                 // 5. MessageFormat
├── demoLocaleBasics()                  // 6. Locale
├── demoNumberFormatLocale()            // 7. Numeri multi-locale
├── demoCurrencyFormatLocale()          // 8. Valute multi-locale
├── demoDateTimeLocale()                // 9. Date/Time localizzate
├── demoCompactNumberFormat()           // 10. CompactNumberFormat
├── demoChoiceFormat()                  // 11. ChoiceFormat
├── demoCollator()                      // 12. Collator
├── demoParsingNumbers()                // 13. Parsing
├── demoBestPractices()                 // 14. Best practices
└── Utility methods:
    ├── printHeader()                   // Intestazione principale
    ├── printSection()                  // Sezione
    ├── printSubSection()               // Sottosezione
    ├── printFooter()                   // Footer
    └── waitForEnter()                  // Pausa per utente
```

## Riferimenti

- [Java NumberFormat Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/text/NumberFormat.html)
- [Java DecimalFormat Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/text/DecimalFormat.html)
- [Java MessageFormat Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/text/MessageFormat.html)
- [Java Locale Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Locale.html)
- [Java Collator Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/text/Collator.html)
- [Java ChoiceFormat Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/text/ChoiceFormat.html)
- [Java Internationalization Tutorial](https://docs.oracle.com/javase/tutorial/i18n/)
- [Java Formatter and Format Strings](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Formatter.html)
