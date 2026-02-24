# SwitchAvanzatiDemo

## Obiettivo
La classe `SwitchAvanzatiDemo` mostra in dettaglio l'uso avanzato di `switch` in Java 21, con focus su varianti moderne, pattern matching, gestione del `null`, guardie `when` e best practices.

## Package
`com.corso.samples.generated`

## Entry Point
- `SwitchAvanzatiDemo.run()`

## Contenuti principali

### 1) Introduzione
- Ruolo dello switch nel controllo del flusso.
- Differenza tra switch statement e switch expression.

### 2) Switch statement classico
- Uso di `case`, `break`, `default`.
- Rischio di fall-through involontario.

### 3) Switch expression
- Sintassi `->`.
- Restituzione diretta di valori.
- Riduzione degli errori dovuti a `break` mancanti.

### 4) Uso di `yield`
- Blocchi multi-step in switch expression.
- Restituzione esplicita del risultato del `case`.

### 5) Switch su enum
- Mapping robusto su domini chiusi.
- Maggiore leggibilità e supporto del compilatore.

### 6) Switch su String con normalizzazione input
- `trim()` e `toLowerCase(Locale.ROOT)` prima del branching.
- Gestione input utente rumoroso.

### 7) Pattern matching switch
- Match su tipo runtime (`Integer`, `String`, `Boolean`, ...).
- Alternativa moderna a catene `if/instanceof`.

### 8) Gestione esplicita del null
- Uso di `case null` in Java 21.
- Riduzione di null-check esterni in alcuni scenari.

### 9) Guardie con `when`
- Match più preciso con condizioni aggiuntive.
- Classificazione avanzata di valori eterogenei.

### 10) Use case business
- Routing eventi con switch expression.
- Scelta handler per tipo evento.

### 11) Best practices e anti-pattern
- Linee guida operative per codice manutenibile.
- Errori comuni da evitare in switch classico e moderno.

## Nota didattica
La demo include commenti tecnici in italiano, blocco per blocco, con spiegazioni orientate all'apprendimento e alla manutenzione del codice.

## Come eseguire
1. Avvia l'applicazione.
2. Seleziona la voce menu `Switch Avanzati`.
3. Segui l'output sezione per sezione.
