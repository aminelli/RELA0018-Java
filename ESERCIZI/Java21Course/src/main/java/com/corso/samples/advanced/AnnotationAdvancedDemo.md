# AnnotationAdvancedDemo

## Panoramica

`AnnotationAdvancedDemo` è una demo didattica completa sull'uso avanzato delle annotation in Java.

Requisiti rispettati:

- codice in inglese
- commenti tecnici in italiano
- esempi pratici e best practices per apprendimento

## Contenuti trattati

1. **Introduzione e meta-annotation**
   - `@Target`, `@Retention`, `@Documented`, `@Inherited`
   - differenze tra retention `SOURCE`, `CLASS`, `RUNTIME`

2. **Annotation su classi, metodi e campi**
   - introspezione runtime con reflection
   - lettura di attributi custom

3. **Annotation ripetibili**
   - `@Repeatable`
   - contenitore (`@Tags`) e lettura con `getAnnotationsByType(...)`

4. **Comportamento con ereditarietà**
   - propagazione annotation class-level tramite `@Inherited`

5. **Annotation su parametri**
   - analisi parametri (`Method`, `Parameter`)
   - invocazione dinamica di metodo annotato

6. **Motore di validazione semplice**
   - regole basate su `@NotBlank` e `@IntRange`
   - scansione campi via reflection

7. **Best practices e anti-pattern**
   - progettazione semantica delle annotation
   - gestione performance e diagnostica errori

## Tipi di supporto inclusi nella demo

- annotation custom: `@UseCase`, `@AuditAction`, `@NotBlank`, `@IntRange`, `@Tag`, `@Tags`, `@DomainModel`
- classi di esempio annotate
- record `CreateProductRequest` con vincoli dichiarativi

## Integrazione menu

La demo è associata a una nuova voce del menu console e invoca:

- `com.corso.samples.generated.AnnotationAdvancedDemo.run()`
