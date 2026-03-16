# GenericsDemo - Generics in Java 21

## Panoramica

`GenericsDemo` mostra in dettaglio l'uso dei generics in Java, con esempi pratici orientati a type-safety, riuso e design pulito.

- Package: `com.corso.samples.oop`
- Classe: `GenericsDemo`
- Metodo di avvio: `run()`

## Obiettivi didattici

Al termine della demo saprai:
1. creare classi e metodi generici;
2. usare inferenza di tipo e diamond operator;
3. applicare bounded type parameters;
4. usare wildcard `?`, `? extends`, `? super`;
5. applicare la regola PECS;
6. capire type erasure e principali limitazioni;
7. evitare anti-pattern comuni con i generics.

## Contenuti della demo

1. Introduzione
2. Classe generica base
3. Metodi generici
4. Type inference e diamond
5. Bounded type parameters
6. Multiple bounds
7. Wildcard unbounded
8. Wildcard extends/super
9. PECS
10. Interfaccia generica + repository
11. Type erasure
12. Restrizioni comuni
13. Best practices e anti-pattern

## Concetti chiave

- `Box<T>`: tipo parametrico base
- `Pair<K,V>`: due parametri di tipo
- `StatsBox<T extends Number>`: vincolo su tipo numerico
- `maxOf<T extends Comparable<T> & Named>`: multiple bounds
- `List<?>`, `List<? extends T>`, `List<? super T>`

## PECS (Producer Extends, Consumer Super)

- Se una struttura **produce** elementi da leggere: usa `? extends T`
- Se una struttura **consuma** elementi da scrivere: usa `? super T`

## Restrizioni importanti

- no `new T()`
- no primitive dirette come tipo generico (`int` -> usare `Integer`)
- no array di tipo parametrico (`new T[]`)
- attenzione a cast non sicuri e type erasure

## Best practices principali

- evitare raw types;
- mantenere API generiche semplici;
- usare bounds solo quando necessari;
- documentare il contratto di tipo nelle API pubbliche;
- preferire type inference leggibile.

## Esecuzione

```bash
mvn clean compile
mvn exec:java
```

Dal menu selezionare: **Generics**.
