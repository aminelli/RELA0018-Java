# LambdaDemo - Lambda Function in Java 21

## Panoramica

`LambdaDemo` mostra in dettaglio l'uso delle lambda function in Java con esempi pratici e scenari reali.

- Package: `com.corso.samples.arrcoll`
- Classe: `LambdaDemo`
- Entry point: `run()`

## Obiettivi didattici

Al termine della demo saprai:
1. scrivere lambda in diverse forme sintattiche;
2. usare functional interfaces standard (`Predicate`, `Function`, `Consumer`, `Supplier`, ecc.);
3. usare method reference e constructor reference;
4. combinare lambda con Stream API e Optional;
5. comporre funzioni e predicati (`andThen`, `compose`, `and`, `or`);
6. gestire eccezioni e best practices per codice leggibile.

## Contenuti della demo

1. Introduzione
2. Sintassi lambda
3. Functional interfaces core
4. Functional interface custom
5. Method references
6. Constructor references
7. Streams con lambda
8. Comparator e sorting
9. Optional + lambda
10. Composizione/chaining
11. Capture effectively final
12. Primitive-specialized interfaces
13. Gestione eccezioni
14. Best practices e anti-pattern

## Scenari pratici inclusi

- policy dinamiche (pricing/strategy);
- pipeline stream (`filter`, `map`, `reduce`);
- ordinamento dichiarativo con comparator lambda;
- fallback dinamico con `Optional.orElseGet`;
- parsing sicuro con wrapper lambda.

## Best practices principali

- lambda brevi e leggibili;
- estrarre in metodi dedicati se la logica cresce;
- preferire method reference quando più chiara;
- minimizzare side-effect nelle pipeline;
- usare primitive specializations su percorsi hot.

## Esecuzione

```bash
mvn clean compile
mvn exec:java
```

Dal menu selezionare: **Lamda**.
