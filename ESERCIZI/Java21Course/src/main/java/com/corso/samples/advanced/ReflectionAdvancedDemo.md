# ReflectionAdvancedDemo

## Panoramica

`ReflectionAdvancedDemo` è una demo completa sull'uso avanzato della reflection in Java.

Caratteristiche richieste rispettate:

- codice in inglese
- commenti in italiano con taglio didattico e tecnico
- esempi pratici orientati a casi reali

## Contenuti coperti

1. **Metadati di classe**
   - `Class<?>`, package, superclass, modificatori, campi dichiarati

2. **Costruttori e istanziazione dinamica**
   - recupero costruttori pubblici/privati
   - `newInstance(...)` e gestione eccezioni reflection

3. **Accesso ai campi**
   - campi pubblici con `getField`
   - campi privati con `getDeclaredField` + `setAccessible(true)`

4. **Invocazione dinamica metodi**
   - invocazione metodi pubblici e privati
   - analisi metadati parametri

5. **Introspezione annotazioni runtime**
   - annotazione custom `@UseCase`
   - lettura annotazioni su classe e metodi

6. **Ispezione tipi generici**
   - `ParameterizedType` su `List<String>` e `Map<String, Integer>`

7. **Dynamic Proxy**
   - `Proxy.newProxyInstance(...)`
   - `InvocationHandler` per intercettazione chiamate

8. **Metadata moderni (record e sealed)**
   - `isRecord()`, `getRecordComponents()`
   - `isSealed()`, `getPermittedSubclasses()`

9. **Best practices e anti-pattern**
   - uso reflection in contesti framework/tooling
   - caching lookup riflessivi
   - attenzione a performance, sicurezza e manutenibilità

## Integrazione menu

Nel menu console viene aggiunta una nuova voce dedicata alla reflection avanzata,
associata al metodo:

- `com.corso.samples.generated.ReflectionAdvancedDemo.run()`
