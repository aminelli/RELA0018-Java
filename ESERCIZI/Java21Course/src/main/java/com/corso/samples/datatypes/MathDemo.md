# MathDemo - Guida completa alla classe Math

## Obiettivo
La classe `MathDemo` mostra in modo dettagliato la classe `Math` in Java: funzioni numeriche principali, gestione overflow, floating-point, utilità avanzate e best practices.

## Package
`com.corso.samples.datatypes`

## Entry Point
- `MathDemo.run()`

## Argomenti coperti

### 1) Costanti e funzioni base
- `Math.PI`, `Math.E`
- `max`, `min`, `abs`

### 2) Segno e range
- `signum`
- applicazione pratica con min/max su collezioni

### 3) Arrotondamenti
- `floor`, `ceil`, `round`, `rint`
- differenze operative e casi con numeri negativi

### 4) Potenze, radici e logaritmi
- `pow`, `sqrt`, `cbrt`, `hypot`
- `exp`, `log`, `log10`

### 5) Trigonometria
- `sin`, `cos`, `tan`
- conversioni con `toRadians` / `toDegrees`

### 6) Random e limiti
- `Math.random()`
- mapping a intervalli interi
- `Math.clamp(...)` per forzare un valore in un range

### 7) Sicurezza overflow
- `addExact`, `multiplyExact`, `incrementExact`, `decrementExact`, `negateExact`
- gestione `ArithmeticException`

### 8) Floating-point speciali
- `NaN`, `Infinity`
- confronto con epsilon (`abs(a-b) < epsilon`)

### 9) Utility avanzate
- `copySign`, `ulp`, `nextUp`, `nextDown`
- `floorDiv`, `floorMod` con negativi

### 10) Best practices
- usare `BigDecimal` per importi monetari
- evitare confronti `==` sui floating-point
- proteggere gli interi da overflow quando necessario
- usare le funzioni dedicate di `Math` invece di implementazioni manuali fragili

## Come eseguire
1. Avvia l'applicazione.
2. Seleziona la voce menu `Math`.
3. Segui l'output sezione per sezione.

## Nota didattica
La demo usa esempi concreti orientati alla pratica; per scenari statistici avanzati o random ad alte prestazioni, integrare con API dedicate (`Random`, `SplittableRandom`, librerie numeriche).
