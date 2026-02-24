# OptionalDemo - Guida completa

## Obiettivo
La classe `OptionalDemo` mostra in dettaglio come usare `Optional` in Java per modellare in modo esplicito la presenza/assenza di un valore, riducendo il rischio di `NullPointerException`.

## Package
`com.corso.samples.oop`

## Entry Point
- `OptionalDemo.run()`

## Contenuti della demo

### 1) Perché Optional
- Contratto API più chiaro rispetto al semplice `null`.
- Flussi più leggibili e sicuri.

### 2) Creazione
- `Optional.of(value)`
- `Optional.ofNullable(value)`
- `Optional.empty()`

Nota: `Optional.of(null)` lancia eccezione.

### 3) Lettura e fallback
- `orElse(...)`
- `orElseGet(...)`
- differenze operative e impatto performance.

### 4) Trasformazioni
- `map(...)`
- `flatMap(...)`
- composizione di accessi annidati (`User -> Address -> city`).

### 5) Validazione condizionale
- `filter(...)` per mantenere/scartare valori opzionali.

### 6) Azioni condizionali
- `ifPresent(...)`
- `ifPresentOrElse(...)`

### 7) Pattern avanzati
- `or(...)` per fallback tra Optional.
- `orElseThrow(...)` quando un valore è obbligatorio.

### 8) Optional con Streams
- Pipeline con parsing sicuro (`flatMap(Optional::stream)`).
- Composizione con `findFirst()`.

### 9) Primitive Optional
- `OptionalInt`, `OptionalDouble` per evitare boxing.

### 10) Scenario realistico
- Repository + Service con catena `filter/map/flatMap`.
- Fallback finale (`orElse(BigDecimal.ZERO)`).

### 11) Best Practices
- Usare Optional soprattutto come **return type**.
- Evitare `get()` diretto.
- Preferire `orElseGet` per fallback costosi.
- Non usarlo indiscriminatamente come campo o parametro.

### 12) Anti-pattern
- `Optional<Optional<T>>`
- null-check misti e conversioni inutili
- abuso di `get()`

## Come eseguire
1. Avvia l'applicazione.
2. Seleziona dal menu la voce `Optional`.
3. Segui l'output sezione per sezione.
