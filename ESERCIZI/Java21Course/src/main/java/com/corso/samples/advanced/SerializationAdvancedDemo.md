# SerializationAdvancedDemo

## Panoramica

`SerializationAdvancedDemo` è una demo completa sull'uso avanzato della serializzazione in Java.

La classe rispetta i requisiti richiesti:

- codice in inglese
- commenti tecnici in italiano
- scenari didattici completi con best practices e anti-pattern

## Scenari coperti

1. **Default Serialization**
   - serializzazione/deserializzazione standard di classi `Serializable`

2. **Transient fields**
   - esclusione dei campi sensibili dal payload serializzato

3. **Custom protocol (`writeObject` / `readObject`)**
   - personalizzazione del formato e validazione in deserializzazione

4. **`serialVersionUID`**
   - gestione compatibilità tra versioni della classe

5. **`Externalizable`**
   - controllo totale su ordine e contenuto dei dati serializzati

6. **`readResolve`**
   - preservazione invarianti (scenario singleton)

7. **Deserialization filter (`ObjectInputFilter`)**
   - mitigazione rischi di sicurezza su input non affidabile

8. **Best practices e anti-pattern**
   - linee guida pratiche per codice robusto e sicuro

## Tipi di supporto inclusi

- `CustomerRecord`
- `SessionContext`
- `SecuredAccount`
- `ExternalOrder`
- `AppConfiguration`

## Integrazione menu

La demo viene collegata a una nuova voce del menu console e invoca:

- `com.corso.samples.generated.SerializationAdvancedDemo.run()`
