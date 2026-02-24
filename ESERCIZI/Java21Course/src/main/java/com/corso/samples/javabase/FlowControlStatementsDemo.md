# FlowControlStatementsDemo

## Panoramica

La classe `FlowControlStatementsDemo` mostra in modo pratico e completo i principali **Flow Control Statements** in Java 21.

Package: `com.corso.samples.basejava`

Argomenti coperti:
- `if / else if / else`
- `switch` classico e `switch expression`
- operatore ternario `?:`
- cicli `for`, `enhanced for`, `while`, `do-while`
- `break`, `continue`, label
- `return` come controllo del flusso
- short-circuit booleano (`&&`, `||`)
- best practices e anti-pattern

## Obiettivi di apprendimento

Al termine della demo saprai:
1. scegliere correttamente tra costrutti condizionali diversi;
2. usare la `switch expression` moderna con `yield`;
3. applicare i loop in base allo scenario;
4. gestire uscita/interruzione dei cicli in modo leggibile;
5. usare guard clauses per ridurre annidamenti;
6. evitare errori comuni di manutenibilità.

## Struttura della demo

La demo esegue 15 sezioni:

1. Introduzione ai flow control statements
2. if / else if / else
3. if annidati e guard clauses
4. switch statement classico
5. switch expression moderna
6. operatore ternario
7. for loop
8. enhanced for loop
9. while loop
10. do-while loop
11. break e continue
12. labeled break/continue
13. return come controllo del flusso
14. short-circuit e logica booleana
15. best practices e anti-pattern

## Linee guida rapide

### if vs switch
- usa `if` per condizioni booleane complesse o range;
- usa `switch` per valori discreti (enum, codici, stati).

### for vs while vs do-while
- `for`: numero iterazioni noto o contatore esplicito;
- `while`: condizione aperta, pre-test;
- `do-while`: serve almeno un passaggio garantito.

### break / continue
- `break`: interrompe il ciclo;
- `continue`: salta iterazione corrente;
- label: solo quando semplifica davvero il codice.

## Best Practices principali

1. Preferire leggibilità e chiarezza del flusso.
2. Usare graffe sempre, anche per blocchi a singola riga.
3. Ridurre annidamenti con guard clauses (`return` anticipato).
4. Usare `switch expression` per assegnazioni pulite.
5. Limitare ternari annidati.
6. Rendere evidente la condizione di uscita dei cicli.
7. Evitare logica di controllo troppo frammentata con molti `break/continue`.
8. Spezzare condizioni booleane lunghe in variabili intermedie.

## Come eseguire

Dal menu principale dell'app:
- avvia l'applicazione;
- seleziona la voce **Flow Control Statements**.

Oppure via compilazione/esecuzione progetto:

```bash
mvn clean compile
mvn exec:java
```

## Riferimenti utili

- Java Language Specification - Statements
- Java Language Specification - Switch Expressions
- Java Tutorials - Control Flow Statements
