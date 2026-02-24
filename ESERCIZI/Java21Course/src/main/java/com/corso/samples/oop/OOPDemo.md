# OOPDemo - Incapsulamento, Ereditarietà e Polimorfismo

## Panoramica

`OOPDemo` è una demo completa sui pilastri OOP in Java:
- **Incapsulamento**
- **Ereditarietà**
- **Polimorfismo**

Con sezione specifica su differenza tra:
- **Polimorfismo implicito** (runtime/dynamic dispatch con override)
- **Polimorfismo esplicito** (overload/cast/pattern matching scelti dal chiamante)

- Package: `com.corso.samples.oop`
- Classe: `OOPDemo`
- Metodo di avvio: `run()`

## Obiettivi didattici

Al termine del modulo saprai:
1. progettare classi incapsulate con invarianti robuste;
2. usare ereditarietà in modo corretto e sostenibile;
3. distinguere composizione ed ereditarietà;
4. comprendere il polimorfismo runtime implicito;
5. comprendere quando usare il polimorfismo esplicito;
6. applicare best practices per design OOP manutenibile.

## Contenuti della demo

1. Introduzione OOP
2. Incapsulamento base
3. Incapsulamento con validazione
4. Incapsulamento con viste read-only
5. Ereditarietà base
6. Ereditarietà con `super` e `override`
7. Composizione vs ereditarietà
8. Polimorfismo implicito (runtime)
9. Polimorfismo esplicito (overloading)
10. Polimorfismo esplicito (cast/pattern matching)
11. Classe astratta + interfaccia
12. Liskov substitution idea
13. Best practices e anti-pattern

## Differenza: Polimorfismo Implicito vs Esplicito

### Polimorfismo implicito
- Avviene quando usi riferimento base + oggetto derivato.
- Java sceglie automaticamente a runtime il metodo override corretto.
- Esempio tipico: `Animal a = new Dog(); a.sound();`

### Polimorfismo esplicito
- Il chiamante decide esplicitamente il comportamento:
  - scegliendo una firma overload;
  - usando cast/pattern matching su tipo concreto.
- Utile in casi specifici, da non abusare.

## Best practices principali

- Campi `private` e metodi con validazione.
- Ereditarietà solo per vera relazione **is-a**.
- Preferire composizione quando più flessibile.
- Usare il polimorfismo implicito come default.
- Usare cast/`instanceof` solo quando realmente necessario.
- Evitare gerarchie profonde e fragili.

## Esecuzione

```bash
mvn clean compile
mvn exec:java
```

Dal menu selezionare: **OOP**.
