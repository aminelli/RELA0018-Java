# StreamsDemo - Guida completa agli Streams (Java 21)

## Obiettivo
La classe `StreamsDemo` mostra in modo pratico e progressivo:
- creazione stream,
- operazioni intermedie e terminali,
- collector avanzati,
- `Optional` e primitive streams,
- uso consapevole dei parallel streams,
- best practices e anti-pattern.

## Package
`com.corso.samples.arrcoll`

## Entry Point
Metodo statico:
- `StreamsDemo.run()`

## Struttura della demo

### 1) Introduzione
Spiega cosa sono gli stream:
- pipeline dichiarative,
- elaborazione lazy,
- separazione tra sorgente dati e logica di trasformazione.

### 2) Creazione stream
Esempi da:
- collezioni (`collection.stream()`),
- valori (`Stream.of(...)`),
- range numerici (`IntStream.rangeClosed(...)`).

### 3) Operazioni intermedie
Mostra:
- `filter`,
- `map`,
- `peek` (per debug controllato).

### 4) Operazioni terminali
Mostra:
- `count`,
- `reduce`,
- `max`,
- `anyMatch`, `allMatch`,
- `forEachOrdered`.

### 5) `map` vs `flatMap`
- `map`: 1 elemento -> 1 elemento trasformato.
- `flatMap`: appiattisce strutture annidate (es. lista di array/stringhe).

### 6) Operazioni di slicing/ordinamento
Uso di:
- `distinct`,
- `sorted`,
- `skip`,
- `limit`.

### 7) Collectors base
Esempi con:
- `toList`,
- `toCollection(TreeSet::new)`,
- `toMap` con gestione collisioni.

### 8) Grouping e partitioning
- `groupingBy` per raggruppare per attributo.
- `partitioningBy` per separare in due gruppi booleani.
- `counting` come collector downstream.

### 9) Riduzioni e statistiche
- `reduce` su `BigDecimal` per totali.
- `summarizingInt`, `summarizingDouble` per statistiche aggregate.

### 10) Streams + Optional
Esempi con:
- `findFirst`,
- `findAny`,
- trasformazione sicura con `map(...).orElse(...)`.

### 11) Primitive streams
- `IntStream` per evitare boxing/unboxing.
- conversione con `boxed()` quando necessario.

### 12) Parallel streams
Confronto tra sequenziale e parallelo su workload numerico.

Nota: il parallelo non è automaticamente migliore; dipende da CPU, dimensione input e overhead.

### 13) Collector scenario avanzato
Uso di `collectingAndThen` per:
- post-processing del risultato,
- produzione di liste immutabili (`List.copyOf`).

### 14) Best practices e anti-pattern
Best practices principali:
- evitare side effect,
- mantenere pipeline leggibili,
- usare primitive streams per calcoli numerici,
- misurare performance prima di ottimizzare.

Anti-pattern comuni:
- pipeline troppo complesse e poco leggibili,
- mutazioni esterne in `map`/`forEach`,
- parallelismo usato senza criterio.

## Modello dati interno
La demo usa record interni per semplicità:
- `User(id, name, age, city)`
- `Order(id, total)`

Questo permette esempi realistici senza dipendenze esterne.

## Come eseguire
1. Avvia l'app principale.
2. Nel menu console seleziona la voce `streams`.
3. Leggi l'output sezione per sezione.

## Output atteso
Output testuale con:
- sezioni numerate,
- risultati delle pipeline stream,
- note su comportamento e best practices.

## Nota didattica
La demo privilegia chiarezza e copertura funzionale.
In contesti reali, estrai pipeline complesse in metodi dedicati e accompagna con test unitari mirati.
