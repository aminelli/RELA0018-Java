# MethodsPropertiesDemo - Costruttori, Metodi e Proprietà delle Classi

## Panoramica

`MethodsPropertiesDemo` è una demo completa dedicata a:
- costruttori delle classi;
- proprietà/campi e incapsulamento;
- metodi (instance, static, overload, override, generic, fluent);
- tipologie di classi dichiarabili in Java e scenari d'uso.

Package: `com.corso.samples.oop`

## Obiettivi didattici

Al termine del modulo saprai:
1. progettare costruttori robusti (default, parametrico, copy, factory);
2. applicare proprietà con validazione e invarianti;
3. distinguere metodi di istanza e statici;
4. usare overload e override in modo corretto;
5. applicare classi annidate, inner, locali, anonime, record e sealed;
6. riconoscere best practices e anti-pattern comuni.

## Contenuti della demo

1. Introduzione
2. Costruttori base
3. Overload + constructor chaining
4. Copy constructor + factory methods
5. Proprietà e encapsulation
6. Proprietà calcolate
7. Metodi instance/static/overload
8. Override e polimorfismo
9. Varargs e metodi generici
10. Fluent API
11. Tipologie di classi dichiarabili
12. Static nested + inner class
13. Classe locale + classe anonima
14. Record class
15. Gerarchia sealed
16. Best practices e anti-pattern

## Tipologie di classi coperte

- Classe concreta
- Classe astratta
- Classe final
- Classe annidata statica
- Classe inner
- Classe locale
- Classe anonima
- Record
- Gerarchia sealed (con varianti final)

## Regole pratiche

- Costruttori: sempre validazione fail-fast.
- Proprietà: campi `private`, API pubblica minima.
- Metodi: nomi orientati al dominio.
- Overload: evitare ambiguità semantica.
- Static: solo per comportamento senza stato d'istanza.
- Record: perfetto per DTO/value object semplici.
- Sealed: utile per insiemi chiusi di varianti.

## Esecuzione

```bash
mvn clean compile
mvn exec:java
```

Poi dal menu selezionare: **Metodi e properietà**.

## Nota

Il modulo è pensato per apprendimento progressivo e include esempi pratici con focus su qualità del design OOP.
