package com.corso.samples.advanced;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Advanced demo on Java annotations.
 *
 * <p>
 * This class shows annotation design, runtime inspection, repeatable annotations,
 * inheritance behavior, parameter constraints and a tiny validation engine.
 * </p>
 */
public final class AnnotationAdvancedDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private AnnotationAdvancedDemo() {
    }

    /**
     * Entry-point della demo.
     */
    public static void run() {
        printHeader("ADVANCED ANNOTATIONS IN JAVA");

        demoIntroductionAndMetaAnnotations();
        demoClassMethodFieldAnnotations();
        demoRepeatableAnnotations();
        demoInheritedAnnotationBehavior();
        demoParameterAnnotationsAndInvocation();
        demoSimpleValidationEngine();
        demoBestPracticesAndAntiPatterns();

        printFooter();
    }

    /**
     * Introduzione: mostra concetti e metadati fondamentali delle annotation.
     */
    private static void demoIntroductionAndMetaAnnotations() {
        printSection("1) Introduction and Meta-Annotations");

        // Le annotation sono metadata strutturati associati a tipi/membri/parametri.
        // Vengono usate da compiler, tool, framework e runtime engine.
        System.out.println("Annotations provide structured metadata for code elements.");

        // Le meta-annotation più importanti:
        // - @Target: dove può essere applicata
        // - @Retention: durata del metadata (SOURCE, CLASS, RUNTIME)
        // - @Documented: inclusione in JavaDoc
        // - @Inherited: propagazione su sottoclassi (solo class-level)
        System.out.println("Core meta-annotations: @Target, @Retention, @Documented, @Inherited.");

        printSubSection("Retention behavior");
        System.out.println("SOURCE -> visible only to compiler tooling.");
        System.out.println("CLASS  -> in bytecode, not visible via runtime reflection.");
        System.out.println("RUNTIME -> visible via reflection APIs.");
    }

    /**
     * Mostra annotation su classe, campo e metodo con introspezione reflection.
     */
    private static void demoClassMethodFieldAnnotations() {
        printSection("2) Class, Method and Field Annotations");

        Class<AnnotatedInventoryService> targetClass = AnnotatedInventoryService.class;

        // Lettura annotation a livello classe.
        if (targetClass.isAnnotationPresent(UseCase.class)) {
            UseCase useCase = targetClass.getAnnotation(UseCase.class);
            System.out.println("Class @UseCase -> name=" + useCase.name() + ", priority=" + useCase.priority());
        }

        // Lettura annotation su metodi dichiarati.
        for (Method method : targetClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AuditAction.class)) {
                AuditAction auditAction = method.getAnnotation(AuditAction.class);
                System.out.println("Method @AuditAction -> " + method.getName() + " action=" + auditAction.value());
            }
        }

        // Lettura annotation su campi.
        for (Field field : targetClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(NotBlank.class)) {
                System.out.println("Field @NotBlank -> " + field.getName());
            }
        }
    }

    /**
     * Mostra uso di annotation ripetibili e recupero dei valori aggregati.
     */
    private static void demoRepeatableAnnotations() {
        printSection("3) Repeatable Annotations");

        Class<AnnotatedInventoryService> targetClass = AnnotatedInventoryService.class;

        // getAnnotationsByType gestisce automaticamente il contenitore @Tags.
        Tag[] tags = targetClass.getAnnotationsByType(Tag.class);
        System.out.println("Repeatable tags count -> " + tags.length);

        for (Tag tag : tags) {
            System.out.println("- tag=" + tag.value());
        }
    }

    /**
     * Mostra differenza fra annotation ereditabili e non ereditabili.
     */
    private static void demoInheritedAnnotationBehavior() {
        printSection("4) Inherited Annotation Behavior");

        Class<BaseDomainModel> baseType = BaseDomainModel.class;
        Class<SpecializedDomainModel> childType = SpecializedDomainModel.class;

        // @DomainModel è marcata @Inherited, quindi la sottoclasse la vede.
        DomainModel baseAnnotation = baseType.getAnnotation(DomainModel.class);
        DomainModel childAnnotation = childType.getAnnotation(DomainModel.class);

        System.out.println("Base class domain -> " + (baseAnnotation != null ? baseAnnotation.value() : "none"));
        System.out.println("Child class domain -> " + (childAnnotation != null ? childAnnotation.value() : "none"));

        // Nota tecnica: @Inherited funziona solo per annotation a livello classe,
        // non per metodi, campi o costruttori.
        System.out.println("@Inherited applies only to class-level annotations.");
    }

    /**
     * Mostra annotation su parametri e invocazione guidata da metadata.
     */
    private static void demoParameterAnnotationsAndInvocation() {
        printSection("5) Parameter Annotations and Invocation");

        try {
            Method method = AnnotatedInventoryService.class
                    .getDeclaredMethod("registerStock", String.class, int.class, LocalDate.class);

            // Ispezione parametri e annotation associate.
            for (Parameter parameter : method.getParameters()) {
                Annotation[] annotations = parameter.getAnnotations();
                String annotationNames = Arrays.stream(annotations)
                        .map(annotation -> annotation.annotationType().getSimpleName())
                        .reduce((left, right) -> left + ", " + right)
                        .orElse("none");

                System.out.println("Parameter -> " + parameter.getName() + " : "
                        + parameter.getType().getSimpleName() + " annotations=" + annotationNames);
            }

            // Invocazione dinamica di metodo annotato con dati validi.
            AnnotatedInventoryService service = new AnnotatedInventoryService();
            method.invoke(service, "SKU-900", 12, LocalDate.now().plusDays(1));
        } catch (ReflectiveOperationException exception) {
            System.out.println("Parameter annotation demo error: " + exception.getMessage());
        }
    }

    /**
     * Esegue una semplice validazione runtime basata su annotation custom.
     */
    private static void demoSimpleValidationEngine() {
        printSection("6) Simple Validation Engine");

        CreateProductRequest validRequest = new CreateProductRequest("SKU-1", 20, "Core item");
        CreateProductRequest invalidRequest = new CreateProductRequest("", 0, "");

        // Usiamo reflection per leggere le annotation sui campi e applicare regole.
        List<String> validIssues = validateObject(validRequest);
        List<String> invalidIssues = validateObject(invalidRequest);

        System.out.println("Valid request issues -> " + validIssues);
        System.out.println("Invalid request issues -> " + invalidIssues);
    }

    /**
     * Riassume linee guida e anti-pattern nell'uso delle annotation.
     */
    private static void demoBestPracticesAndAntiPatterns() {
        printSection("7) Best Practices and Anti-Patterns");

        String[] practices = {
                "Design annotations with clear semantic meaning and minimal attributes.",
                "Use RUNTIME retention only when runtime inspection is really required.",
                "Document annotation contracts with examples and failure modes.",
                "Keep processors/validators deterministic and side-effect free when possible.",
                "Prefer composition of small annotations over one overloaded annotation." };

        for (int i = 0; i < practices.length; i++) {
            System.out.printf("%d) %s%n", i + 1, practices[i]);
        }

        printSubSection("Common anti-patterns");
        System.out.println("- Creating ambiguous annotations with unclear business intent");
        System.out.println("- Using reflection-heavy scanning inside critical hot paths");
        System.out.println("- Declaring many RUNTIME annotations without real runtime usage");
        System.out.println("- Hiding validation failures without actionable diagnostics");
    }

    /**
     * Valida un oggetto leggendo annotation su ciascun campo.
     */
    private static List<String> validateObject(Object target) {
        List<String> issues = new ArrayList<>();

        for (Field field : target.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            try {
                Object value = field.get(target);

                if (field.isAnnotationPresent(NotBlank.class) && value instanceof String text) {
                    if (text.isBlank()) {
                        issues.add(field.getName() + " must not be blank");
                    }
                }

                if (field.isAnnotationPresent(IntRange.class) && value instanceof Integer number) {
                    IntRange range = field.getAnnotation(IntRange.class);
                    if (number < range.min() || number > range.max()) {
                        issues.add(field.getName() + " out of range [" + range.min() + ", " + range.max() + "]");
                    }
                }
            } catch (IllegalAccessException exception) {
                issues.add("Cannot access field: " + field.getName() + " -> " + exception.getMessage());
            }
        }

        return issues;
    }

    /**
     * Rendering header.
     */
    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(CYAN + "=".repeat(94) + RESET);
        System.out.println(BLUE + " " + title + RESET);
        System.out.println(CYAN + "=".repeat(94) + RESET);
    }

    /**
     * Rendering sezione principale.
     */
    private static void printSection(String title) {
        System.out.println();
        System.out.println(MAGENTA + "► " + title + RESET);
        System.out.println(YELLOW + "-".repeat(94) + RESET);
    }

    /**
     * Rendering sotto-sezione.
     */
    private static void printSubSection(String title) {
        System.out.println();
        System.out.println(CYAN + "  • " + title + RESET);
    }

    /**
     * Rendering footer.
     */
    private static void printFooter() {
        System.out.println();
        System.out.println(GREEN + "Demo completed: advanced annotations scenarios executed." + RESET);
        System.out.println(CYAN + "=".repeat(94) + RESET);
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface UseCase {
        String name();

        int priority() default 1;
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.METHOD, ElementType.CONSTRUCTOR })
    public @interface AuditAction {
        String value();
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.PARAMETER })
    public @interface NotBlank {
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.PARAMETER })
    public @interface IntRange {
        int min();

        int max();
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Repeatable(Tags.class)
    public @interface Tag {
        String value();
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Tags {
        Tag[] value();
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface DomainModel {
        String value();
    }

    @UseCase(name = "Inventory annotated service", priority = 2)
    @Tag("inventory")
    @Tag("annotation-demo")
    public static class AnnotatedInventoryService {

        @SuppressWarnings("unused")
        @NotBlank
        private final String serviceName = "InventoryService";

        @AuditAction("register-stock")
        public void registerStock(
                @NotBlank String sku,
                @IntRange(min = 1, max = 10_000) int quantity,
                LocalDate expiryDate) {
            System.out.println("registerStock called -> sku=" + sku
                    + ", quantity=" + quantity + ", expiry=" + expiryDate);
        }
    }

    @DomainModel("base-domain")
    public static class BaseDomainModel {
    }

    public static class SpecializedDomainModel extends BaseDomainModel {
    }

    public record CreateProductRequest(
            @NotBlank String sku,
            @IntRange(min = 1, max = 5000) int quantity,
            @NotBlank String description) {
    }
}