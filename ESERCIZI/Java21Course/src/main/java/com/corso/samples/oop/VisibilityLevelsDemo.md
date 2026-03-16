# VisibilityLevelsDemo - Livelli di Visibilità

## Panoramica

`VisibilityLevelsDemo` mostra in dettaglio i livelli di visibilità in Java applicati a:
- classi;
- costruttori;
- metodi;
- proprietà (campi).

Include anche esempi delle principali tipologie di classi dichiarabili e relativi scenari d'uso.

- Package: `com.corso.samples.oop`
- Classe: `VisibilityLevelsDemo`
- Entry point: `run()`

## Obiettivi

Al termine della demo saprai:
1. distinguere `public`, `protected`, `package-private`, `private`;
2. applicare la visibilità corretta a classi top-level e annidate;
3. progettare costruttori con visibilità adeguata (factory pattern);
4. proteggere stato e invarianti con proprietà private;
5. usare visibilità e tipologia di classe in modo coerente al dominio;
6. evitare anti-pattern comuni legati all'esposizione eccessiva.

## Contenuto del modulo

1. Introduzione ai livelli di visibilità
2. Matrice accessi
3. Classi top-level (`public`, package-private)
4. Visibilità membri
5. Visibilità costruttori
6. Visibilità metodi
7. Visibilità proprietà
8. `protected` ed ereditarietà
9. Visibilità classi annidate
10. Tipologie classi dichiarabili
11. Astratte e final
12. Gerarchie sealed
13. Classi locali e anonime
14. Record
15. Utility class pattern
16. Best practices e anti-pattern

## Matrice rapida

- `public`: ovunque
- `protected`: stesso package + sottoclassi
- `package-private` (default): solo package
- `private`: solo classe dichiaratrice

> Nota: per classi top-level Java ammette solo `public` e package-private.

## Tipologie di classi coperte

- concreta
- astratta
- final
- sealed / non-sealed
- annidata statica
- inner
- locale
- anonima
- record

## Best practices principali

- Esporre il minimo necessario (`principle of least privilege`).
- Campi quasi sempre `private`.
- Evitare API pubbliche superflue.
- Usare `protected` solo in gerarchie ben progettate.
- Valutare `sealed` per domini con varianti finite.
- Preferire `record` per dati immutabili.
- Utility class: `final` + costruttore `private`.

## Esecuzione

```bash
mvn clean compile
mvn exec:java
```

Dal menu seleziona: **Livelli Visibilità**.
