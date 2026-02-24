# InterfaceDemo - Interfacce in Java 21

## Panoramica

`InterfaceDemo` mostra in modo completo l'utilizzo delle interfacce in Java con esempi pratici orientati al design OOP moderno.

- Package: `com.corso.samples.oop`
- Classe: `InterfaceDemo`
- Metodo di avvio: `run()`

## Obiettivi didattici

Al termine del modulo saprai:
1. definire e implementare interfacce;
2. usare il polimorfismo basato su contratto;
3. usare `default`, `static` e `private` methods nelle interfacce;
4. usare `@FunctionalInterface`, lambda e method reference;
5. applicare pattern comuni (Strategy, Adapter);
6. applicare ISP e DIP con interfacce;
7. evitare anti-pattern frequenti.

## Contenuto del modulo

1. Introduzione
2. Interfaccia base e implementazione
3. Polimorfismo tramite interfaccia
4. Default methods
5. Metodi static/private in interfaccia
6. Functional interface e lambda
7. Method reference
8. Strategy pattern
9. Adapter pattern
10. Comparable e Comparator
11. Marker/tagging scenario
12. Interface Segregation Principle
13. Dependency Inversion Principle
14. Best practices e anti-pattern

## Scenari pratici coperti

- pagamento con processor intercambiabili;
- canali notifica multipli (email/sms/push);
- esportazione dati con API evolvibile via default methods;
- scontistica runtime via lambda;
- algoritmi di spedizione sostituibili (strategy);
- integrazione legacy tramite adapter;
- repository segregati read/write;
- servizio applicativo dipendente da astrazione `Logger`.

## Best practices principali

- Progettare interfacce piccole e coese (ISP).
- Stabilizzare il contratto pubblico e documentarlo bene.
- Usare default methods per casi comuni e semplici.
- Preferire composizione + interfacce a ereditarietà eccessiva.
- Astrarre dipendenze di infrastruttura dietro interfacce (DIP).
- Testare implementazioni in modo sostituibile.

## Anti-pattern comuni

- interfacce troppo grandi e poco coese;
- astrazioni premature non necessarie;
- implementazioni accoppiate a dettagli concreti;
- default methods con logica eccessivamente complessa.

## Esecuzione

```bash
mvn clean compile
mvn exec:java
```

Dal menu selezionare: **Interfacce**.
