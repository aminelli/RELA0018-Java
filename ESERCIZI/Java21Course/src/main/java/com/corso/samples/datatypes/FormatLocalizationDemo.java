package com.corso.samples.datatypes;

import java.text.ChoiceFormat;
import java.text.Collator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Demo dettagliata su Format e Localization in Java.
 * 
 * Questa classe dimostra:
 * - NumberFormat per formattazione numeri, valute, percentuali
 * - DecimalFormat con pattern personalizzati
 * - String.format() e formatted() per formattazione stringhe
 * - MessageFormat per messaggi parametrizzati
 * - Locale per internazionalizzazione
 * - Currency per valute
 * - DateTimeFormatter con locale
 * - CompactNumberFormat per numeri compatti (1K, 1M)
 * - ChoiceFormat per pluralizzazione
 * - Collator per ordinamento localizzato
 * - Best practices per i18n (internationalization)
 * 
 * @author Java 21 Course
 */
public class FormatLocalizationDemo {

    // ANSI color codes for better console output
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    /**
     * Main entry point for the demo.
     */
    public static void run() {
        printHeader("FORMAT E LOCALIZATION IN JAVA");

        demoIntroduction();
        demoNumberFormatBasics();
        demoDecimalFormat();
        demoStringFormat();
        demoMessageFormat();
        demoLocaleBasics();
        demoNumberFormatLocale();
        demoCurrencyFormatLocale();
        demoDateTimeLocale();
        demoCompactNumberFormat();
        demoChoiceFormat();
        demoCollator();
        demoParsingNumbers();
        demoBestPractices();

        printFooter();
    }

    /**
     * Demo 1: Introduzione ai concetti di formatting e localization.
     */
    private static void demoIntroduction() {
        printSection("1. Introduzione a Format e Localization");

        System.out.println(CYAN + "Cosa sono Format e Localization?" + RESET);
        System.out.println("• " + GREEN + "Format" + RESET + ": Conversione di dati (numeri, date, valute) in stringhe leggibili");
        System.out.println("• " + GREEN + "Localization (L10n)" + RESET + ": Adattamento dell'applicazione a diverse lingue/culture");
        System.out.println("• " + GREEN + "Internationalization (i18n)" + RESET + ": Progettazione app per supportare multiple lingue");

        System.out.println();
        System.out.println(CYAN + "Perché sono importanti?" + RESET);
        System.out.println("• Migliorano l'esperienza utente globale");
        System.out.println("• Rispettano convenzioni culturali (separatori decimali, formati data)");
        System.out.println("• Facilitano l'espansione internazionale dell'applicazione");
        System.out.println("• Aumentano l'accessibilità e la comprensibilità");

        System.out.println();
        System.out.println(CYAN + "Principali API Java per Format e Localization:" + RESET);
        System.out.println("┌────────────────────────┬─────────────────────────────────────────┐");
        System.out.println("│ " + YELLOW + "Classe" + RESET + "                 │ " + YELLOW + "Scopo" + RESET + "                                   │");
        System.out.println("├────────────────────────┼─────────────────────────────────────────┤");
        System.out.println("│ NumberFormat           │ Formattazione numeri, valute, %         │");
        System.out.println("│ DecimalFormat          │ Pattern personalizzati per numeri       │");
        System.out.println("│ String.format()        │ Formattazione printf-style              │");
        System.out.println("│ MessageFormat          │ Messaggi con parametri sostituibili     │");
        System.out.println("│ Locale                 │ Rappresenta lingua/regione/cultura      │");
        System.out.println("│ DateTimeFormatter      │ Formattazione date/ore localizzate      │");
        System.out.println("│ CompactNumberFormat    │ Numeri compatti (1K, 1M, 1B)            │");
        System.out.println("│ ChoiceFormat           │ Pluralizzazione e scelte condizionali   │");
        System.out.println("│ Collator               │ Ordinamento stringhe locale-aware       │");
        System.out.println("│ ResourceBundle         │ Gestione risorse i18n (properties)      │");
        System.out.println("└────────────────────────┴─────────────────────────────────────────┘");

        System.out.println();
        System.out.println(CYAN + "Esempi pratici di localizzazione:" + RESET);
        double number = 1234567.89;
        System.out.println("Stesso numero " + YELLOW + number + RESET + " in diverse culture:");
        System.out.println("• Italia:      1.234.567,89  (punto per migliaia, virgola decimale)");
        System.out.println("• USA:         1,234,567.89  (virgola per migliaia, punto decimale)");
        System.out.println("• Germania:    1.234.567,89  (come Italia)");
        System.out.println("• Francia:     1 234 567,89  (spazio per migliaia, virgola decimale)");

        waitForEnter();
    }

    /**
     * Demo 2: NumberFormat - formattazione base di numeri, valute, percentuali.
     */
    private static void demoNumberFormatBasics() {
        printSection("2. NumberFormat - Formattazione Base");

        System.out.println(CYAN + "NumberFormat fornisce 3 tipi principali di formatter:" + RESET);
        System.out.println("• " + GREEN + "getInstance()" + RESET + ": Numeri generici");
        System.out.println("• " + GREEN + "getCurrencyInstance()" + RESET + ": Valute (€, $, £)");
        System.out.println("• " + GREEN + "getPercentInstance()" + RESET + ": Percentuali (%)");

        System.out.println();
        printSubSection("Formattazione Numeri Generici");
        
        double value = 123456.789;
        NumberFormat numberFormatter = NumberFormat.getInstance(Locale.ITALY);
        
        System.out.println("Valore originale: " + YELLOW + value + RESET);
        System.out.println("Formattato (Italia): " + GREEN + numberFormatter.format(value) + RESET);
        System.out.println("  → Usa punto per migliaia, virgola per decimali");

        System.out.println();
        printSubSection("Formattazione Valute");
        
        double price = 1299.99;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.ITALY);
        
        System.out.println("Prezzo: " + YELLOW + price + RESET);
        System.out.println("Formattato (Italia): " + GREEN + currencyFormatter.format(price) + RESET);
        System.out.println("  → Aggiunge simbolo € e formatta con virgola decimale");

        System.out.println();
        printSubSection("Formattazione Percentuali");
        
        double percentage = 0.789; // 78.9%
        NumberFormat percentFormatter = NumberFormat.getPercentInstance(Locale.ITALY);
        
        System.out.println("Valore decimale: " + YELLOW + percentage + RESET);
        System.out.println("Formattato (Italia): " + GREEN + percentFormatter.format(percentage) + RESET);
        System.out.println("  → Moltiplica per 100 e aggiunge %");

        // Controllo cifre decimali
        System.out.println();
        printSubSection("Controllo Cifre Decimali");
        
        double pi = Math.PI;
        NumberFormat customFormatter = NumberFormat.getInstance(Locale.ITALY);
        customFormatter.setMinimumFractionDigits(2); // Minimo 2 decimali
        customFormatter.setMaximumFractionDigits(5); // Massimo 5 decimali
        
        System.out.println("Valore di π: " + YELLOW + pi + RESET);
        System.out.println("Con 2-5 decimali: " + GREEN + customFormatter.format(pi) + RESET);
        System.out.println("  → setMinimumFractionDigits(2), setMaximumFractionDigits(5)");

        // Numeri interi vs decimali
        System.out.println();
        printSubSection("Controllo Parte Intera");
        
        double small = 7.5;
        NumberFormat intFormatter = NumberFormat.getInstance(Locale.ITALY);
        intFormatter.setMinimumIntegerDigits(4); // Minimo 4 cifre intere (padding con 0)
        
        System.out.println("Valore: " + YELLOW + small + RESET);
        System.out.println("Con 4 cifre intere: " + GREEN + intFormatter.format(small) + RESET);
        System.out.println("  → setMinimumIntegerDigits(4) aggiunge zeri a sinistra");

        waitForEnter();
    }

    /**
     * Demo 3: DecimalFormat - pattern personalizzati per formattazione numeri.
     */
    private static void demoDecimalFormat() {
        printSection("3. DecimalFormat - Pattern Personalizzati");

        System.out.println(CYAN + "DecimalFormat permette pattern di formattazione flessibili:" + RESET);
        System.out.println("• " + GREEN + "0" + RESET + " = Cifra obbligatoria (aggiunge 0 se necessario)");
        System.out.println("• " + GREEN + "#" + RESET + " = Cifra opzionale (non mostra se 0)");
        System.out.println("• " + GREEN + "." + RESET + " = Separatore decimale");
        System.out.println("• " + GREEN + "," + RESET + " = Separatore migliaia");
        System.out.println("• " + GREEN + "%" + RESET + " = Moltiplica per 100 e mostra %");
        System.out.println("• " + GREEN + "‰" + RESET + " = Moltiplica per 1000 e mostra ‰");
        System.out.println("• " + GREEN + "E" + RESET + " = Notazione scientifica");

        System.out.println();
        printSubSection("Pattern Base");
        
        double number = 1234.5;
        
        DecimalFormat df1 = new DecimalFormat("0000.00");
        System.out.println("Numero:           " + YELLOW + number + RESET);
        System.out.println("Pattern '0000.00': " + GREEN + df1.format(number) + RESET);
        System.out.println("  → Padda con 0 fino a 4 cifre intere, 2 decimali obbligatori");

        DecimalFormat df2 = new DecimalFormat("####.##");
        System.out.println("Pattern '####.##': " + GREEN + df2.format(number) + RESET);
        System.out.println("  → Cifre opzionali, non aggiunge 0");

        System.out.println();
        printSubSection("Pattern con Separatore Migliaia");
        
        double bigNumber = 1234567.89;
        
        DecimalFormat df3 = new DecimalFormat("#,###.00");
        System.out.println("Numero:             " + YELLOW + bigNumber + RESET);
        System.out.println("Pattern '#,###.00': " + GREEN + df3.format(bigNumber) + RESET);
        System.out.println("  → Aggiunge separatore migliaia (dipende da locale)");

        // Con locale italiano (usa punto per migliaia, virgola per decimali)
        DecimalFormat df4 = new DecimalFormat("#,###.00", DecimalFormatSymbols.getInstance(Locale.ITALY));
        System.out.println("Con locale ITALY:   " + GREEN + df4.format(bigNumber) + RESET);
        System.out.println("  → Punto per migliaia, virgola per decimali");

        System.out.println();
        printSubSection("Pattern per Valute");
        
        double price = 299.5;
        
        DecimalFormat df5 = new DecimalFormat("€ #,##0.00");
        System.out.println("Prezzo:                 " + YELLOW + price + RESET);
        System.out.println("Pattern '€ #,##0.00':   " + GREEN + df5.format(price) + RESET);
        System.out.println("  → Prefisso €, sempre almeno 1 cifra intera, 2 decimali");

        DecimalFormat df6 = new DecimalFormat("#,##0.00 €", DecimalFormatSymbols.getInstance(Locale.ITALY));
        System.out.println("Pattern '#,##0.00 €':   " + GREEN + df6.format(price) + RESET);
        System.out.println("  → Suffisso €, formato italiano");

        System.out.println();
        printSubSection("Pattern per Percentuali");
        
        double rate = 0.856; // 85.6%
        
        DecimalFormat df7 = new DecimalFormat("0.0%");
        System.out.println("Tasso:            " + YELLOW + rate + RESET);
        System.out.println("Pattern '0.0%':   " + GREEN + df7.format(rate) + RESET);
        System.out.println("  → Moltiplica x100, 1 decimale, aggiunge %");

        DecimalFormat df8 = new DecimalFormat("##0.00%");
        System.out.println("Pattern '##0.00%': " + GREEN + df8.format(rate) + RESET);
        System.out.println("  → 2 decimali obbligatori");

        System.out.println();
        printSubSection("Notazione Scientifica");
        
        double scientific = 123456789.123;
        
        DecimalFormat df9 = new DecimalFormat("0.###E0");
        System.out.println("Numero grande:        " + YELLOW + scientific + RESET);
        System.out.println("Pattern '0.###E0':    " + GREEN + df9.format(scientific) + RESET);
        System.out.println("  → Notazione scientifica con esponente");

        double tiny = 0.0000123;
        System.out.println("Numero piccolo:       " + YELLOW + tiny + RESET);
        System.out.println("Pattern '0.###E0':    " + GREEN + df9.format(tiny) + RESET);

        System.out.println();
        printSubSection("Pattern Positivi/Negativi Differenti");
        
        DecimalFormat df10 = new DecimalFormat("#,##0.00;(#,##0.00)", DecimalFormatSymbols.getInstance(Locale.ITALY));
        double positive = 1234.56;
        double negative = -1234.56;
        
        System.out.println("Pattern: '#,##0.00;(#,##0.00)'");
        System.out.println("  → Formato standard per positivi, parentesi per negativi");
        System.out.println();
        System.out.println("Positivo " + YELLOW + positive + RESET + ": " + GREEN + df10.format(positive) + RESET);
        System.out.println("Negativo " + YELLOW + negative + RESET + ": " + RED + df10.format(negative) + RESET);
        System.out.println("  → I negativi appaiono tra parentesi (stile contabilità)");

        waitForEnter();
    }

    /**
     * Demo 4: String.format() e formatted() per formattazione printf-style.
     */
    private static void demoStringFormat() {
        printSection("4. String.format() - Formattazione Printf-Style");

        System.out.println(CYAN + "String.format() usa specifiers printf-style:" + RESET);
        System.out.println("• " + GREEN + "%s" + RESET + " = String");
        System.out.println("• " + GREEN + "%d" + RESET + " = Integer (decimal)");
        System.out.println("• " + GREEN + "%f" + RESET + " = Float/Double");
        System.out.println("• " + GREEN + "%n" + RESET + " = Newline (platform-independent)");
        System.out.println("• " + GREEN + "%%" + RESET + " = Literal %");

        System.out.println();
        printSubSection("Formattazione Stringhe");
        
        String name = "Mario";
        String greeting = String.format("Ciao, %s! Benvenuto.", name);
        System.out.println(GREEN + greeting + RESET);
        System.out.println("  → String.format(\"Ciao, %s! Benvenuto.\", \"Mario\")");

        System.out.println();
        printSubSection("Formattazione Numeri Interi");
        
        int quantity = 42;
        String message = String.format("Hai %d messaggi non letti.", quantity);
        System.out.println(GREEN + message + RESET);
        System.out.println("  → %d per interi");

        // Padding con zeri
        int orderNumber = 157;
        String order = String.format("Ordine #%05d", orderNumber);
        System.out.println(GREEN + order + RESET);
        System.out.println("  → %05d padda con zeri fino a 5 cifre");

        System.out.println();
        printSubSection("Formattazione Numeri Decimali");
        
        double price = 19.99;
        String priceTag = String.format("Prezzo: €%.2f", price);
        System.out.println(GREEN + priceTag + RESET);
        System.out.println("  → %.2f = 2 cifre decimali");

        double pi = Math.PI;
        System.out.println("π con 2 decimali: " + GREEN + String.format("%.2f", pi) + RESET);
        System.out.println("π con 5 decimali: " + GREEN + String.format("%.5f", pi) + RESET);
        System.out.println("π con 10 decimali: " + GREEN + String.format("%.10f", pi) + RESET);

        System.out.println();
        printSubSection("Larghezza e Allineamento");
        
        System.out.println("Tabella con allineamento:");
        System.out.println(String.format("│%-15s│%10s│", "Prodotto", "Prezzo"));
        System.out.println(String.format("│%-15s│%10.2f│", "Laptop", 899.99));
        System.out.println(String.format("│%-15s│%10.2f│", "Mouse", 25.50));
        System.out.println(String.format("│%-15s│%10.2f│", "Tastiera", 75.00));
        System.out.println();
        System.out.println("  → %-15s = sinistra, 15 caratteri");
        System.out.println("  → %10.2f = destra, 10 caratteri, 2 decimali");

        System.out.println();
        printSubSection("Formattazione Multipli Argomenti");
        
        String fullName = "Andrea Rossi";
        int age = 30;
        double salary = 35000.50;
        
        String profile = String.format(
            "Nome: %s, Età: %d anni, Stipendio: €%.2f",
            fullName, age, salary
        );
        System.out.println(GREEN + profile + RESET);

        System.out.println();
        printSubSection("Argomenti Posizionali");
        
        String formatted = String.format(
            "Data: %2$d/%3$d/%1$d",
            2026, 23, 2  // anno, giorno, mese
        );
        System.out.println(GREEN + formatted + RESET);
        System.out.println("  → %2$d = secondo argomento, %3$d = terzo, %1$d = primo");
        System.out.println("  → Permette riordinamento argomenti");

        System.out.println();
        printSubSection("formatted() - Java 15+");
        
        // formatted() è un metodo instance su String (come format() ma più fluent)
        String template = "Totale: €%.2f (IVA: %.1f%%)";
        double total = 120.00;
        double vat = 22.0;
        String result = template.formatted(total, vat);
        System.out.println(GREEN + result + RESET);
        System.out.println("  → template.formatted(args) invece di String.format(template, args)");

        waitForEnter();
    }

    /**
     * Demo 5: MessageFormat per messaggi parametrizzati.
     */
    private static void demoMessageFormat() {
        printSection("5. MessageFormat - Messaggi Parametrizzati");

        System.out.println(CYAN + "MessageFormat è ideale per messaggi complessi con:" + RESET);
        System.out.println("• Parametri sostituibili {0}, {1}, {2}, ...");
        System.out.println("• Formattazione automatica basata su tipo (number, date, time, choice)");
        System.out.println("• Supporto per pluralizzazione");

        System.out.println();
        printSubSection("Messaggi Base con Parametri");
        
        // Attenzionecje gli apici devono essere scritti nel pattern come '' per essere interpretati come letterali
        // altri casi: parantesi {}, simboli di formattazione come #, ., ecc. devono essere usati con attenzione
        // Esempio con parantesi graffe: "{" diventa "'{'"
        String pattern = "L''utente {0} ha inviato {1} messaggi alle {2}.";
        MessageFormat mf = new MessageFormat(pattern, Locale.ITALY);
        
        Object[] args = {"Alice", 5, new Date()};
        String message = mf.format(args);
        
        System.out.println("Pattern: " + YELLOW + pattern + RESET);
        System.out.println("Risultato: " + GREEN + message + RESET);

        System.out.println();
        printSubSection("Formattazione Numeri con MessageFormat");
        
        String pattern2 = "Hai speso {0,number,currency} su un totale di {1,number,currency}.";
        MessageFormat mf2 = new MessageFormat(pattern2, Locale.ITALY);
        
        Object[] args2 = {75.50, 100.00};
        String message2 = mf2.format(args2);
        
        System.out.println("Pattern: " + YELLOW + pattern2 + RESET);
        System.out.println("Risultato: " + GREEN + message2 + RESET);
        System.out.println("  → {0,number,currency} formatta come valuta");

        System.out.println();
        printSubSection("Formattazione Percentuali");
        
        String pattern3 = "Il progetto è completo al {0,number,percent}.";
        MessageFormat mf3 = new MessageFormat(pattern3, Locale.ITALY);
        
        Object[] args3 = {0.856};
        String message3 = mf3.format(args3);
        
        System.out.println("Risultato: " + GREEN + message3 + RESET);
        System.out.println("  → {0,number,percent} formatta come percentuale");

        System.out.println();
        printSubSection("Formattazione Date");
        
        String pattern4 = "Appuntamento il {0,date,long} alle {0,time,short}.";
        MessageFormat mf4 = new MessageFormat(pattern4, Locale.ITALY);
        
        Object[] args4 = {new Date()};
        String message4 = mf4.format(args4);
        
        System.out.println("Risultato: " + GREEN + message4 + RESET);
        System.out.println("  → {0,date,long} per data, {0,time,short} per ora");
        System.out.println("  → Stesso parametro {0} può essere usato più volte");

        System.out.println();
        printSubSection("Metodo Statico format()");
        
        String quickMessage = MessageFormat.format(
            "Benvenuto {0}! Hai {1} notifiche.",
            "Marco",
            3
        );
        System.out.println(GREEN + quickMessage + RESET);
        System.out.println("  → MessageFormat.format(pattern, args...) per uso rapido");

        waitForEnter();
    }

    /**
     * Demo 6: Locale - rappresentazione di lingua/regione.
     */
    private static void demoLocaleBasics() {
        printSection("6. Locale - Lingua e Regione");

        System.out.println(CYAN + "Locale rappresenta una combinazione di:" + RESET);
        System.out.println("• " + GREEN + "Lingua" + RESET + " (ISO 639: it, en, de, fr, ...)");
        System.out.println("• " + GREEN + "Paese/Regione" + RESET + " (ISO 3166: IT, US, GB, DE, ...)");
        System.out.println("• " + GREEN + "Variante" + RESET + " (opzionale, per dialetti)");

        System.out.println();
        printSubSection("Creazione Locale");
        
        // Costanti predefinite
        Locale italy = Locale.ITALY;
        System.out.println("Locale.ITALY:              " + GREEN + italy + RESET + " → " + italy.getDisplayName(Locale.ITALY));
        
        Locale us = Locale.US;
        System.out.println("Locale.US:                 " + GREEN + us + RESET + " → " + us.getDisplayName(Locale.ITALY));
        
        Locale uk = Locale.UK;
        System.out.println("Locale.UK:                 " + GREEN + uk + RESET + " → " + uk.getDisplayName(Locale.ITALY));

        System.out.println();
        // Costruttore
        Locale custom1 = new Locale("it", "IT");
        System.out.println("new Locale(\"it\", \"IT\"):    " + GREEN + custom1 + RESET);
        
        // Builder (Java 7+)
        Locale custom2 = new Locale.Builder()
            .setLanguage("it")
            .setRegion("IT")
            .build();
        System.out.println("Locale.Builder():          " + GREEN + custom2 + RESET);

        // forLanguageTag (BCP 47)
        Locale custom3 = Locale.forLanguageTag("it-IT");
        System.out.println("forLanguageTag(\"it-IT\"):   " + GREEN + custom3 + RESET);

        System.out.println();
        printSubSection("Locale di Default");
        
        Locale defaultLocale = Locale.getDefault();
        System.out.println("Locale di default del sistema: " + GREEN + defaultLocale + RESET);
        System.out.println("Display name:                  " + GREEN + defaultLocale.getDisplayName() + RESET);
        System.out.println("Lingua:                        " + GREEN + defaultLocale.getLanguage() + RESET);
        System.out.println("Paese:                         " + GREEN + defaultLocale.getCountry() + RESET);

        System.out.println();
        printSubSection("Locale Comuni");
        
        System.out.println("┌──────────────┬──────────┬─────────────────────────────┐");
        System.out.println("│ " + YELLOW + "Costante" + RESET + "     │ " + YELLOW + "Codice" + RESET + "   │ " + YELLOW + "Nome" + RESET + "                        │");
        System.out.println("├──────────────┼──────────┼─────────────────────────────┤");
        System.out.println("│ Locale.ITALY │ it_IT    │ " + Locale.ITALY.getDisplayName(Locale.ITALY) + "        │");
        System.out.println("│ Locale.US    │ en_US    │ " + Locale.US.getDisplayName(Locale.ITALY) + "      │");
        System.out.println("│ Locale.UK    │ en_GB    │ " + Locale.UK.getDisplayName(Locale.ITALY) + "   │");
        System.out.println("│ Locale.FRANCE│ fr_FR    │ " + Locale.FRANCE.getDisplayName(Locale.ITALY) + "          │");
        System.out.println("│ Locale.GERMANY│ de_DE   │ " + Locale.GERMANY.getDisplayName(Locale.ITALY) + "         │");
        System.out.println("│ Locale.JAPAN │ ja_JP    │ " + Locale.JAPAN.getDisplayName(Locale.ITALY) + "         │");
        System.out.println("│ Locale.CHINA │ zh_CN    │ " + Locale.CHINA.getDisplayName(Locale.ITALY) + "           │");
        System.out.println("└──────────────┴──────────┴─────────────────────────────┘");

        System.out.println();
        printSubSection("Informazioni Locale");
        
        Locale france = Locale.FRANCE;
        System.out.println("Analisi di " + YELLOW + "Locale.FRANCE" + RESET + ":");
        System.out.println("• toString():              " + GREEN + france.toString() + RESET);
        System.out.println("• getLanguage():           " + GREEN + france.getLanguage() + RESET);
        System.out.println("• getCountry():            " + GREEN + france.getCountry() + RESET);
        System.out.println("• getDisplayLanguage():    " + GREEN + france.getDisplayLanguage(Locale.ITALY) + RESET);
        System.out.println("• getDisplayCountry():     " + GREEN + france.getDisplayCountry(Locale.ITALY) + RESET);
        System.out.println("• getDisplayName():        " + GREEN + france.getDisplayName(Locale.ITALY) + RESET);

        waitForEnter();
    }

    /**
     * Demo 7: Formattazione numeri con diversi locale.
     */
    private static void demoNumberFormatLocale() {
        printSection("7. NumberFormat con Diversi Locale");

        double number = 1234567.89;

        System.out.println(CYAN + "Stesso numero formattato in diverse culture:" + RESET);
        System.out.println("Numero originale: " + YELLOW + number + RESET);
        System.out.println();

        // Italia
        NumberFormat nfItaly = NumberFormat.getInstance(Locale.ITALY);
        System.out.println("🇮🇹 Italia (it_IT):      " + GREEN + nfItaly.format(number) + RESET);
        System.out.println("   → Punto per migliaia, virgola per decimali");

        // USA
        NumberFormat nfUS = NumberFormat.getInstance(Locale.US);
        System.out.println("🇺🇸 USA (en_US):          " + GREEN + nfUS.format(number) + RESET);
        System.out.println("   → Virgola per migliaia, punto per decimali");

        // Francia
        NumberFormat nfFrance = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println("🇫🇷 Francia (fr_FR):      " + GREEN + nfFrance.format(number) + RESET);
        System.out.println("   → Spazio per migliaia, virgola per decimali");

        // Germania
        NumberFormat nfGermany = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println("🇩🇪 Germania (de_DE):     " + GREEN + nfGermany.format(number) + RESET);
        System.out.println("   → Punto per migliaia, virgola per decimali");

        // UK
        NumberFormat nfUK = NumberFormat.getInstance(Locale.UK);
        System.out.println("🇬🇧 UK (en_GB):           " + GREEN + nfUK.format(number) + RESET);
        System.out.println("   → Virgola per migliaia, punto per decimali");

        System.out.println();
        printSubSection("Percentuali in Diversi Locale");
        
        double percentage = 0.856;
        System.out.println("Percentuale: " + YELLOW + percentage + RESET);
        System.out.println();
        
        NumberFormat pfItaly = NumberFormat.getPercentInstance(Locale.ITALY);
        System.out.println("Italia:   " + GREEN + pfItaly.format(percentage) + RESET);
        
        NumberFormat pfUS = NumberFormat.getPercentInstance(Locale.US);
        System.out.println("USA:      " + GREEN + pfUS.format(percentage) + RESET);
        
        NumberFormat pfFrance = NumberFormat.getPercentInstance(Locale.FRANCE);
        System.out.println("Francia:  " + GREEN + pfFrance.format(percentage) + RESET);

        System.out.println();
        System.out.println(YELLOW + "Nota:" + RESET + " Le differenze possono sembrare minime per %, ma sono cruciali per i18n!");

        waitForEnter();
    }

    /**
     * Demo 8: Formattazione valute con diversi locale.
     */
    private static void demoCurrencyFormatLocale() {
        printSection("8. Currency Format con Diversi Locale");

        double amount = 1299.99;

        System.out.println(CYAN + "Stesso importo formattato come valuta in diverse culture:" + RESET);
        System.out.println("Importo: " + YELLOW + amount + RESET);
        System.out.println();

        // Euro - Italia
        NumberFormat cfItaly = NumberFormat.getCurrencyInstance(Locale.ITALY);
        System.out.println("🇮🇹 Italia (€):      " + GREEN + cfItaly.format(amount) + RESET);

        // Dollar - USA
        NumberFormat cfUS = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("🇺🇸 USA ($):          " + GREEN + cfUS.format(amount) + RESET);

        // Pound - UK
        NumberFormat cfUK = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println("🇬🇧 UK (£):           " + GREEN + cfUK.format(amount) + RESET);

        // Yen - Japan
        NumberFormat cfJapan = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        System.out.println("🇯🇵 Giappone (¥):     " + GREEN + cfJapan.format(amount) + RESET);

        // Yuan - China
        NumberFormat cfChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("🇨🇳 Cina (¥):         " + GREEN + cfChina.format(amount) + RESET);

        // Franc - Svizzera
        Locale switzerland = new Locale("de", "CH");
        NumberFormat cfSwitzerland = NumberFormat.getCurrencyInstance(switzerland);
        System.out.println("🇨🇭 Svizzera (CHF):   " + GREEN + cfSwitzerland.format(amount) + RESET);

        System.out.println();
        printSubSection("Informazioni sulla Currency");
        
        // Currency per Locale
        Currency euroCurrency = Currency.getInstance(Locale.ITALY);
        System.out.println("Valuta Italia:");
        System.out.println("• Codice ISO:          " + GREEN + euroCurrency.getCurrencyCode() + RESET);
        System.out.println("• Simbolo:             " + GREEN + euroCurrency.getSymbol(Locale.ITALY) + RESET);
        System.out.println("• Decimali predefiniti: " + GREEN + euroCurrency.getDefaultFractionDigits() + RESET);
        System.out.println("• Nome visualizzato:   " + GREEN + euroCurrency.getDisplayName(Locale.ITALY) + RESET);

        System.out.println();
        Currency usdCurrency = Currency.getInstance(Locale.US);
        System.out.println("Valuta USA:");
        System.out.println("• Codice ISO:          " + GREEN + usdCurrency.getCurrencyCode() + RESET);
        System.out.println("• Simbolo:             " + GREEN + usdCurrency.getSymbol(Locale.US) + RESET);
        System.out.println("• Decimali predefiniti: " + GREEN + usdCurrency.getDefaultFractionDigits() + RESET);
        System.out.println("• Nome visualizzato:   " + GREEN + usdCurrency.getDisplayName(Locale.ITALY) + RESET);

        System.out.println();
        printSubSection("Impostare Currency Personalizzata");
        
        // Puoi forzare una currency diversa dal locale
        NumberFormat customCurrency = NumberFormat.getCurrencyInstance(Locale.US);
        customCurrency.setCurrency(Currency.getInstance("EUR"));
        
        System.out.println("Formato USA con currency EUR:");
        System.out.println(GREEN + customCurrency.format(amount) + RESET);
        System.out.println("  → Usa formato numerico americano (punto decimale)");
        System.out.println("  → Ma mostra simbolo EUR invece di $");

        waitForEnter();
    }

    /**
     * Demo 9: Formattazione date/time con locale.
     */
    private static void demoDateTimeLocale() {
        printSection("9. DateTime Format con Locale");

        System.out.println(CYAN + "DateTimeFormatter con locale per date/ore localizzate:" + RESET);

        LocalDateTime now = LocalDateTime.of(2026, 2, 23, 14, 30, 45);
        System.out.println("Data/ora: " + YELLOW + now + RESET);
        System.out.println();

        printSubSection("Stili Predefiniti per Date");
        
        LocalDate date = now.toLocalDate();
        
        // SHORT
        DateTimeFormatter shortIt = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.ITALY);
        DateTimeFormatter shortUS = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.US);
        System.out.println("SHORT:");
        System.out.println("  Italia: " + GREEN + date.format(shortIt) + RESET);
        System.out.println("  USA:    " + GREEN + date.format(shortUS) + RESET);

        System.out.println();
        // MEDIUM
        DateTimeFormatter mediumIt = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.ITALY);
        DateTimeFormatter mediumUS = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US);
        System.out.println("MEDIUM:");
        System.out.println("  Italia: " + GREEN + date.format(mediumIt) + RESET);
        System.out.println("  USA:    " + GREEN + date.format(mediumUS) + RESET);

        System.out.println();
        // LONG
        DateTimeFormatter longIt = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.ITALY);
        DateTimeFormatter longUS = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.US);
        System.out.println("LONG:");
        System.out.println("  Italia: " + GREEN + date.format(longIt) + RESET);
        System.out.println("  USA:    " + GREEN + date.format(longUS) + RESET);

        System.out.println();
        // FULL
        DateTimeFormatter fullIt = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.ITALY);
        DateTimeFormatter fullUS = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
        System.out.println("FULL:");
        System.out.println("  Italia: " + GREEN + date.format(fullIt) + RESET);
        System.out.println("  USA:    " + GREEN + date.format(fullUS) + RESET);

        System.out.println();
        printSubSection("Formattazione Mesi e Giorni Localizzati");
        
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
        
        System.out.println("Nome mese (Febbraio):");
        System.out.println("  Italiano:  " + GREEN + date.format(monthFormatter.withLocale(Locale.ITALY)) + RESET);
        System.out.println("  Inglese:   " + GREEN + date.format(monthFormatter.withLocale(Locale.US)) + RESET);
        System.out.println("  Francese:  " + GREEN + date.format(monthFormatter.withLocale(Locale.FRANCE)) + RESET);
        System.out.println("  Tedesco:   " + GREEN + date.format(monthFormatter.withLocale(Locale.GERMANY)) + RESET);

        System.out.println();
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EEEE");
        
        System.out.println("Nome giorno (Domenica):");
        System.out.println("  Italiano:  " + GREEN + date.format(dayFormatter.withLocale(Locale.ITALY)) + RESET);
        System.out.println("  Inglese:   " + GREEN + date.format(dayFormatter.withLocale(Locale.US)) + RESET);
        System.out.println("  Francese:  " + GREEN + date.format(dayFormatter.withLocale(Locale.FRANCE)) + RESET);
        System.out.println("  Tedesco:   " + GREEN + date.format(dayFormatter.withLocale(Locale.GERMANY)) + RESET);
        System.out.println("  Giapponese: " + GREEN + date.format(dayFormatter.withLocale(Locale.JAPAN)) + RESET);

        System.out.println();
        printSubSection("Pattern Personalizzati con Locale");
        
        DateTimeFormatter customIt = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy 'alle ore' HH:mm", Locale.ITALY);
        DateTimeFormatter customUS = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy 'at' h:mm a", Locale.US);
        
        System.out.println("Pattern personalizzato:");
        System.out.println("  Italia: " + GREEN + now.format(customIt) + RESET);
        System.out.println("  USA:    " + GREEN + now.format(customUS) + RESET);

        waitForEnter();
    }

    /**
     * Demo 10: CompactNumberFormat per numeri compatti (Java 12+).
     */
    private static void demoCompactNumberFormat() {
        printSection("10. CompactNumberFormat - Numeri Compatti");

        System.out.println(CYAN + "CompactNumberFormat (Java 12+) formatta numeri grandi in modo compatto:" + RESET);
        System.out.println("• 1,000 → 1K");
        System.out.println("• 1,000,000 → 1M");
        System.out.println("• 1,000,000,000 → 1B");

        System.out.println();
        printSubSection("Formato Compatto - Stile SHORT");
        
        NumberFormat shortFormat = NumberFormat.getCompactNumberInstance(Locale.ITALY, NumberFormat.Style.SHORT);
        
        System.out.println("Numeri formattati in stile SHORT:");
        long[] numbers = {
            500L,
            1_000L,
            1_500L,
            10_000L,
            100_000L,
            1_000_000L,
            5_500_000L,
            1_000_000_000L,
            7_800_000_000L
        };
        
        for (long num : numbers) {
            System.out.println(String.format("%,15d → %s", num, GREEN + shortFormat.format(num) + RESET));
        }

        System.out.println();
        printSubSection("Formato Compatto - Stile LONG");
        
        NumberFormat longFormat = NumberFormat.getCompactNumberInstance(Locale.ITALY, NumberFormat.Style.LONG);
        
        System.out.println("Numeri formattati in stile LONG:");
        long[] numbers2 = {
            1_000L,
            1_500L,
            10_000L,
            1_000_000L,
            5_500_000L,
            1_000_000_000L
        };
        
        for (long num : numbers2) {
            System.out.println(String.format("%,15d → %s", num, GREEN + longFormat.format(num) + RESET));
        }

        System.out.println();
        printSubSection("Differenze tra Locale");
        
        long bigNumber = 1_234_567_890L;
        System.out.println("Numero: " + YELLOW + String.format("%,d", bigNumber) + RESET);
        System.out.println();
        
        NumberFormat compactIT = NumberFormat.getCompactNumberInstance(Locale.ITALY, NumberFormat.Style.SHORT);
        System.out.println("Italia:   " + GREEN + compactIT.format(bigNumber) + RESET);
        
        NumberFormat compactUS = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println("USA:      " + GREEN + compactUS.format(bigNumber) + RESET);
        
        NumberFormat compactFR = NumberFormat.getCompactNumberInstance(Locale.FRANCE, NumberFormat.Style.SHORT);
        System.out.println("Francia:  " + GREEN + compactFR.format(bigNumber) + RESET);
        
        NumberFormat compactDE = NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT);
        System.out.println("Germania: " + GREEN + compactDE.format(bigNumber) + RESET);

        System.out.println();
        printSubSection("Uso Pratico");
        
        System.out.println("Ideale per:");
        System.out.println("• Dashboard con grandi numeri (utenti, visualizzazioni)");
        System.out.println("• Grafici e statistiche");
        System.out.println("• Social media (1.2M followers)");
        System.out.println("• Dimensioni file (15K, 2.3M)");

        waitForEnter();
    }

    /**
     * Demo 11: ChoiceFormat per pluralizzazione e scelte condizionali.
     */
    private static void demoChoiceFormat() {
        printSection("11. ChoiceFormat - Pluralizzazione");

        System.out.println(CYAN + "ChoiceFormat permette di scegliere messaggi basati su range numerici:" + RESET);
        System.out.println("• Utile per pluralizzazione (0 file, 1 file, 2+ files)");
        System.out.println("• Categorizzazione (basso, medio, alto)");

        System.out.println();
        printSubSection("Pluralizzazione Messaggi");
        
        // Limiti e messaggi corrispondenti
        double[] limits = {0, 1, 2};
        String[] messages = {"nessun messaggio", "un messaggio", "{0} messaggi"};
        
        ChoiceFormat choiceFormat = new ChoiceFormat(limits, messages);
        
        System.out.println("Pattern ChoiceFormat per messaggi:");
        System.out.println("  0:       'nessun messaggio'");
        System.out.println("  1:       'un messaggio'");
        System.out.println("  2+:      '{0} messaggi'");
        System.out.println();
        
        int[] counts = {0, 1, 2, 5, 10};
        for (int count : counts) {
            String formatted = choiceFormat.format(count);
            // Se il messaggio contiene {0}, lo sostituiamo manualmente
            formatted = formatted.replace("{0}", String.valueOf(count));
            System.out.println(count + " → " + GREEN + formatted + RESET);
        }

        System.out.println();
        printSubSection("Integrazione con MessageFormat");
        
        String pattern = "Hai {0,choice,0#nessun file|1#un file|2#{0} file} da caricare.";
        MessageFormat mf = new MessageFormat(pattern, Locale.ITALY);
        
        System.out.println("Pattern MessageFormat con choice:");
        System.out.println("  " + YELLOW + pattern + RESET);
        System.out.println();
        
        for (int count : counts) {
            String message = mf.format(new Object[]{count});
            System.out.println(count + " → " + GREEN + message + RESET);
        }

        System.out.println();
        printSubSection("Categorizzazione per Range");
        
        double[] scoreLimits = {0, 50, 70, 90};
        String[] scoreMessages = {"Insufficiente", "Sufficiente", "Buono", "Ottimo"};
        
        ChoiceFormat scoreFormat = new ChoiceFormat(scoreLimits, scoreMessages);
        
        System.out.println("Valutazione voti:");
        System.out.println("  0-49:  Insufficiente");
        System.out.println("  50-69: Sufficiente");
        System.out.println("  70-89: Buono");
        System.out.println("  90+:   Ottimo");
        System.out.println();
        
        double[] scores = {30, 50, 65, 75, 92, 100};
        for (double score : scores) {
            String evaluation = scoreFormat.format(score);
            System.out.println(String.format("Voto %.0f → %s", score, GREEN + evaluation + RESET));
        }

        System.out.println();
        printSubSection("Pattern String (Sintassi Alternativa)");
        
        // Sintassi: number1#message1|number2#message2|...
        ChoiceFormat fileFormat = new ChoiceFormat("0#nessun file|1#un file|2#molti file");
        
        System.out.println("Pattern: '0#nessun file|1#un file|2#molti file'");
        System.out.println();
        
        for (int i = 0; i <= 3; i++) {
            System.out.println(i + " → " + GREEN + fileFormat.format(i) + RESET);
        }

        waitForEnter();
    }

    /**
     * Demo 12: Collator per ordinamento stringhe locale-aware.
     */
    private static void demoCollator() {
        printSection("12. Collator - Ordinamento Localizzato");

        System.out.println(CYAN + "Collator permette ordinamento stringhe rispettando regole linguistiche:" + RESET);
        System.out.println("• Accenti e caratteri speciali");
        System.out.println("• Regole di sorting specifiche per lingua");
        System.out.println("• Case sensitivity configurabile");

        System.out.println();
        printSubSection("Ordinamento con Accenti (Italiano)");
        
        String[] words = {"café", "cafe", "école", "ecole", "élève", "eleve", "città", "citta"};
        
        System.out.println("Parole originali: " + Arrays.toString(words));
        System.out.println();
        
        // Ordinamento standard String (lessicografico, basato su Unicode)
        String[] wordsStandard = words.clone();
        Arrays.sort(wordsStandard);
        System.out.println("Ordinamento standard (String.compareTo):");
        System.out.println(YELLOW + Arrays.toString(wordsStandard) + RESET);
        System.out.println("  → Basato su valori Unicode, può non rispettare regole linguistiche");

        System.out.println();
        // Ordinamento con Collator
        String[] wordsCollator = words.clone();
        Collator italianCollator = Collator.getInstance(Locale.ITALY);
        Arrays.sort(wordsCollator, italianCollator);
        System.out.println("Ordinamento Collator (Locale.ITALY):");
        System.out.println(GREEN + Arrays.toString(wordsCollator) + RESET);
        System.out.println("  → Rispetta regole linguistiche, gestisce accenti correttamente");

        System.out.println();
        printSubSection("Livelli di Forza del Collator");
        
        String[] testWords = {"cote", "coté", "côte", "côté"};
        System.out.println("Parole di test: " + Arrays.toString(testWords));
        System.out.println();
        
        // PRIMARY: ignora accenti e case
        Collator primaryCollator = Collator.getInstance(Locale.FRANCE);
        primaryCollator.setStrength(Collator.PRIMARY);
        System.out.println("PRIMARY (ignora accenti e case):");
        System.out.println("  cote vs coté: " + (primaryCollator.compare("cote", "coté") == 0 ? GREEN + "uguali" : RED + "diversi") + RESET);
        System.out.println("  côte vs côté: " + (primaryCollator.compare("côte", "côté") == 0 ? GREEN + "uguali" : RED + "diversi") + RESET);

        System.out.println();
        // SECONDARY: considera accenti, ignora case
        Collator secondaryCollator = Collator.getInstance(Locale.FRANCE);
        secondaryCollator.setStrength(Collator.SECONDARY);
        System.out.println("SECONDARY (considera accenti, ignora case):");
        System.out.println("  cote vs côte: " + (secondaryCollator.compare("cote", "côte") == 0 ? GREEN + "uguali" : RED + "diversi") + RESET);
        System.out.println("  Cote vs cote: " + (secondaryCollator.compare("Cote", "cote") == 0 ? GREEN + "uguali" : RED + "diversi") + RESET);

        System.out.println();
        // TERTIARY: considera accenti e case
        Collator tertiaryCollator = Collator.getInstance(Locale.FRANCE);
        tertiaryCollator.setStrength(Collator.TERTIARY);
        System.out.println("TERTIARY (considera accenti e case):");
        System.out.println("  Cote vs cote: " + (tertiaryCollator.compare("Cote", "cote") == 0 ? GREEN + "uguali" : RED + "diversi") + RESET);

        System.out.println();
        printSubSection("Ordinamento Tedesco");
        
        String[] germanWords = {"Straße", "Strasse", "Straßen", "Strassen"};
        System.out.println("Parole tedesche: " + Arrays.toString(germanWords));
        System.out.println();
        
        String[] germanSorted = germanWords.clone();
        Collator germanCollator = Collator.getInstance(Locale.GERMANY);
        Arrays.sort(germanSorted, germanCollator);
        
        System.out.println("Ordinamento tedesco:");
        System.out.println(GREEN + Arrays.toString(germanSorted) + RESET);
        System.out.println("  → Gestisce correttamente ß (eszett)");

        System.out.println();
        printSubSection("Confronto Sensibilità Case");
        
        Collator caseInsensitive = Collator.getInstance(Locale.ITALY);
        caseInsensitive.setStrength(Collator.PRIMARY);
        
        System.out.println("Case-insensitive (PRIMARY):");
        System.out.println("  'Roma' vs 'roma': " + 
            (caseInsensitive.compare("Roma", "roma") == 0 ? GREEN + "uguali" : RED + "diversi") + RESET);
        
        Collator caseSensitive = Collator.getInstance(Locale.ITALY);
        caseSensitive.setStrength(Collator.TERTIARY);
        
        System.out.println("Case-sensitive (TERTIARY):");
        System.out.println("  'Roma' vs 'roma': " + 
            (caseSensitive.compare("Roma", "roma") == 0 ? GREEN + "uguali" : RED + "diversi") + RESET);

        waitForEnter();
    }

    /**
     * Demo 13: Parsing numeri da stringhe formattate.
     */
    private static void demoParsingNumbers() {
        printSection("13. Parsing - Da Stringhe Formattate a Numeri");

        System.out.println(CYAN + "NumberFormat può anche fare parsing (string → number):" + RESET);

        System.out.println();
        printSubSection("Parsing Numeri Localizzati");
        
        String italianNumber = "1.234.567,89";
        NumberFormat nfItaly = NumberFormat.getInstance(Locale.ITALY);
        
        try {
            Number parsed = nfItaly.parse(italianNumber);
            System.out.println("String italiana: " + YELLOW + italianNumber + RESET);
            System.out.println("Parsed:          " + GREEN + parsed + RESET);
            System.out.println("Tipo:            " + parsed.getClass().getSimpleName());
        } catch (ParseException e) {
            System.out.println(RED + "Errore parsing: " + e.getMessage() + RESET);
        }

        System.out.println();
        String usNumber = "1,234,567.89";
        NumberFormat nfUS = NumberFormat.getInstance(Locale.US);
        
        try {
            Number parsed = nfUS.parse(usNumber);
            System.out.println("String USA:      " + YELLOW + usNumber + RESET);
            System.out.println("Parsed:          " + GREEN + parsed + RESET);
        } catch (ParseException e) {
            System.out.println(RED + "Errore parsing: " + e.getMessage() + RESET);
        }

        System.out.println();
        printSubSection("Parsing Valute");
        
        String currency = "€ 1.299,99";
        NumberFormat cfItaly = NumberFormat.getCurrencyInstance(Locale.ITALY);
        
        try {
            Number parsed = cfItaly.parse(currency);
            System.out.println("String currency: " + YELLOW + currency + RESET);
            System.out.println("Parsed:          " + GREEN + parsed + RESET);
            System.out.println("  → Rimuove simbolo € e formattazione");
        } catch (ParseException e) {
            System.out.println(RED + "Errore parsing: " + e.getMessage() + RESET);
        }

        System.out.println();
        printSubSection("Parsing Percentuali");
        
        String percent = "85,6%";
        NumberFormat pfItaly = NumberFormat.getPercentInstance(Locale.ITALY);
        
        try {
            Number parsed = pfItaly.parse(percent);
            System.out.println("String percent:  " + YELLOW + percent + RESET);
            System.out.println("Parsed:          " + GREEN + parsed + RESET);
            System.out.println("  → Converte da % a decimale (85,6% → 0.856)");
        } catch (ParseException e) {
            System.out.println(RED + "Errore parsing: " + e.getMessage() + RESET);
        }

        System.out.println();
        printSubSection("Parsing con DecimalFormat");
        
        DecimalFormat df = new DecimalFormat("#,###.00", DecimalFormatSymbols.getInstance(Locale.ITALY));
        String formatted = "12.345,67";
        
        try {
            Number parsed = df.parse(formatted);
            System.out.println("String:          " + YELLOW + formatted + RESET);
            System.out.println("Parsed:          " + GREEN + parsed + RESET);
            System.out.println("Double value:    " + GREEN + parsed.doubleValue() + RESET);
        } catch (ParseException e) {
            System.out.println(RED + "Errore parsing: " + e.getMessage() + RESET);
        }

        System.out.println();
        printSubSection("Gestione Errori di Parsing");
        
        String invalid = "abc123";
        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        
        try {
            Number parsed = nf.parse(invalid);
            System.out.println("Parsed: " + parsed);
        } catch (ParseException e) {
            System.out.println("String invalida: " + YELLOW + invalid + RESET);
            System.out.println(RED + "ParseException: " + e.getMessage() + RESET);
            System.out.println("  → Sempre gestire ParseException quando si fa parsing!");
        }

        waitForEnter();
    }

    /**
     * Demo 14: Best practices per formatting e localization.
     */
    private static void demoBestPractices() {
        printSection("14. Best Practices - Format e Localization");

        System.out.println(CYAN + "Best Practices per Formatting e Internationalization:" + RESET);
        System.out.println();

        // Best Practice 1
        System.out.println(GREEN + "1. USA SEMPRE Locale per applicazioni internazionali" + RESET);
        System.out.println();
        System.out.println(RED + "✗ EVITA:" + RESET);
        System.out.println("  NumberFormat nf = NumberFormat.getInstance();");
        System.out.println("  // Usa locale di default del sistema, imprevedibile!");
        System.out.println();
        System.out.println(GREEN + "✓ CORRETTO:" + RESET);
        System.out.println("  NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);");
        System.out.println("  // Esplicito e prevedibile");
        System.out.println();

        // Best Practice 2
        System.out.println(GREEN + "2. NON concatenare stringhe per i18n" + RESET);
        System.out.println();
        System.out.println(RED + "✗ EVITA:" + RESET);
        System.out.println("  String msg = \"Hai \" + count + \" messaggi\";");
        System.out.println("  // Ordine parole varia tra lingue!");
        System.out.println();
        System.out.println(GREEN + "✓ CORRETTO:" + RESET);
        System.out.println("  String msg = MessageFormat.format(\"Hai {0} messaggi\", count);");
        System.out.println("  // Parametri sostituibili, ordine modificabile");
        System.out.println();

        // Best Practice 3
        System.out.println(GREEN + "3. Usa ResourceBundle per testi localizzati" + RESET);
        System.out.println();
        System.out.println(RED + "✗ EVITA:" + RESET);
        System.out.println("  String welcome = (lang.equals(\"it\")) ? \"Benvenuto\" : \"Welcome\";");
        System.out.println("  // Hardcoded, non scalabile");
        System.out.println();
        System.out.println(GREEN + "✓ CORRETTO:" + RESET);
        System.out.println("  ResourceBundle bundle = ResourceBundle.getBundle(\"messages\", locale);");
        System.out.println("  String welcome = bundle.getString(\"welcome.message\");");
        System.out.println("  // File properties separati per ogni lingua");
        System.out.println();

        // Best Practice 4
        System.out.println(GREEN + "4. Gestisci SEMPRE ParseException nel parsing" + RESET);
        System.out.println();
        System.out.println(RED + "✗ EVITA:" + RESET);
        System.out.println("  Number num = NumberFormat.getInstance().parse(input);");
        System.out.println("  // ParseException non gestita!");
        System.out.println();
        System.out.println(GREEN + "✓ CORRETTO:" + RESET);
        System.out.println("  try {");
        System.out.println("    Number num = NumberFormat.getInstance(locale).parse(input);");
        System.out.println("  } catch (ParseException e) {");
        System.out.println("    // Gestisci errore appropriatamente");
        System.out.println("  }");
        System.out.println();

        // Best Practice 5
        System.out.println(GREEN + "5. Usa DecimalFormat per pattern personalizzati complessi" + RESET);
        System.out.println();
        System.out.println(YELLOW + "QUANDO:" + RESET);
        System.out.println("  • Serve controllo preciso su formato (padding, simboli custom)");
        System.out.println("  • Pattern ripetuto in applicazione");
        System.out.println();
        System.out.println(GREEN + "✓ ESEMPIO:" + RESET);
        System.out.println("  DecimalFormat df = new DecimalFormat(\"#,##0.00 €\", symbols);");
        System.out.println();

        // Best Practice 6
        System.out.println(GREEN + "6. Considera CompactNumberFormat per UI moderne" + RESET);
        System.out.println();
        System.out.println(YELLOW + "IDEALE PER:" + RESET);
        System.out.println("  • Dashboard e analytics (1.2M views)");
        System.out.println("  • Social media (15K followers)");
        System.out.println("  • Grafici con numeri grandi");
        System.out.println();

        // Best Practice 7
        System.out.println(GREEN + "7. Usa ChoiceFormat per pluralizzazione" + RESET);
        System.out.println();
        System.out.println(RED + "✗ EVITA:" + RESET);
        System.out.println("  String msg = count == 1 ? \"1 file\" : count + \" files\";");
        System.out.println("  // Non funziona per tutte le lingue (russo ha 3+ forme plurali!)");
        System.out.println();
        System.out.println(GREEN + "✓ CORRETTO:" + RESET);
        System.out.println("  MessageFormat mf = new MessageFormat(");
        System.out.println("    \"{0,choice,0#no files|1#one file|2#{0} files}\");");
        System.out.println();

        // Best Practice 8
        System.out.println(GREEN + "8. Usa Collator per ordinamento internazionale" + RESET);
        System.out.println();
        System.out.println(RED + "✗ EVITA:" + RESET);
        System.out.println("  Arrays.sort(words); // String.compareTo, non locale-aware");
        System.out.println();
        System.out.println(GREEN + "✓ CORRETTO:" + RESET);
        System.out.println("  Collator collator = Collator.getInstance(locale);");
        System.out.println("  Arrays.sort(words, collator);");
        System.out.println("  // Rispetta regole linguistiche (accenti, ß tedesco, ecc.)");
        System.out.println();

        // Best Practice 9
        System.out.println(GREEN + "9. Testa con DIVERSI Locale" + RESET);
        System.out.println();
        System.out.println(YELLOW + "LOCALE DA TESTARE SEMPRE:" + RESET);
        System.out.println("  • Locale.ITALY (virgola decimale, punto migliaia)");
        System.out.println("  • Locale.US (punto decimale, virgola migliaia)");
        System.out.println("  • Locale.JAPAN (ideogrammi, nessun spazio)");
        System.out.println("  • Locale.forLanguageTag(\"ar\") (right-to-left!)");
        System.out.println();

        // Best Practice 10
        System.out.println(GREEN + "10. Separa logica da presentazione" + RESET);
        System.out.println();
        System.out.println(GREEN + "✓ PRINCIPIO:" + RESET);
        System.out.println("  • Lavora con Date, Number, BigDecimal internamente");
        System.out.println("  • Formatta SOLO per presentazione all'utente");
        System.out.println("  • Parsing SOLO da input utente (mai da dati interni)");
        System.out.println();

        // Checklist
        System.out.println();
        System.out.println(PURPLE + "═══════════════════════════════════════════════════════════" + RESET);
        System.out.println(YELLOW + "                    CHECKLIST I18N" + RESET);
        System.out.println(PURPLE + "═══════════════════════════════════════════════════════════" + RESET);
        System.out.println("☑ Tutti i NumberFormat usano Locale esplicito?");
        System.out.println("☑ Nessuna concatenazione di stringhe per messaggi utente?");
        System.out.println("☑ ResourceBundle configurato per tutte le lingue target?");
        System.out.println("☑ ParseException sempre gestita?");
        System.out.println("☑ Date/numeri formattati solo per UI, mai per storage?");
        System.out.println("☑ Ordinamento usa Collator per testo localizzato?");
        System.out.println("☑ Pluralizzazione gestita con ChoiceFormat/MessageFormat?");
        System.out.println("☑ Testing fatto con almeno 3 locale diversi?");
        System.out.println("☑ Currency corretta per ogni locale?");
        System.out.println("☑ Pattern DecimalFormat testati con locale simboli?");

        System.out.println();
        System.out.println(PURPLE + "═══════════════════════════════════════════════════════════" + RESET);
        System.out.println(YELLOW + "                    REGOLE D'ORO" + RESET);
        System.out.println(PURPLE + "═══════════════════════════════════════════════════════════" + RESET);
        System.out.println("» " + GREEN + "NumberFormat.getInstance(locale)" + RESET + " NON getInstance()");
        System.out.println("» " + GREEN + "MessageFormat" + RESET + " per messaggi, NON concatenazione stringhe");
        System.out.println("» " + GREEN + "Collator" + RESET + " per ordinare, NON Arrays.sort() diretto su String");

        waitForEnter();
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Stampa l'intestazione principale della demo.
     */
    private static void printHeader(String title) {
        System.out.println();
        System.out.println(PURPLE + "═══════════════════════════════════════════════════════════" + RESET);
        System.out.println(YELLOW + "           " + title + RESET);
        System.out.println(PURPLE + "═══════════════════════════════════════════════════════════" + RESET);
        System.out.println();
    }

    /**
     * Stampa l'intestazione di una sezione.
     */
    private static void printSection(String title) {
        System.out.println();
        System.out.println(CYAN + "┌───────────────────────────────────────────────────────────┐" + RESET);
        System.out.println(CYAN + "│ " + YELLOW + title + RESET);
        System.out.println(CYAN + "└───────────────────────────────────────────────────────────┘" + RESET);
        System.out.println();
    }

    /**
     * Stampa l'intestazione di una sottosezione.
     */
    private static void printSubSection(String title) {
        System.out.println(BLUE + "▶ " + title + RESET);
        System.out.println();
    }

    /**
     * Stampa il footer finale.
     */
    private static void printFooter() {
        System.out.println();
        System.out.println(PURPLE + "═══════════════════════════════════════════════════════════" + RESET);
        System.out.println(GREEN + "           Fine della demo Format e Localization!" + RESET);
        System.out.println(PURPLE + "═══════════════════════════════════════════════════════════" + RESET);
        System.out.println();
    }

    /**
     * Attende che l'utente prema INVIO per continuare.
     */
    private static void waitForEnter() {
        System.out.println();
        System.out.println(YELLOW + "Premi INVIO per continuare..." + RESET);
        try {
            new Scanner(System.in).nextLine();
        } catch (Exception e) {
            // Ignora errori
        }
    }

    /**
     * Main method per esecuzione diretta (opzionale).
     */
    public static void main(String[] args) {
        run();
    }
}
