package com.corso.samples.advanced;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Advanced demo on Java Reflection.
 *
 * <p>
 * This class demonstrates practical reflection scenarios used in frameworks,
 * diagnostic tooling and runtime metadata analysis.
 * </p>
 */
public final class ReflectionAdvancedDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private ReflectionAdvancedDemo() {
    }

    /**
     * Entry-point della demo reflection avanzata.
     */
    public static void run() {
        printHeader("ADVANCED REFLECTION IN JAVA");

        demoClassMetadata();
        demoConstructorsAndDynamicInstantiation();
        demoFieldsAndEncapsulationBoundaries();
        demoMethodsAndDynamicInvocation();
        demoAnnotationInspection();
        demoGenericTypeInspection();
        demoDynamicProxy();
        demoRecordsAndSealedMetadata();
        demoBestPracticesAndPitfalls();

        printFooter();
    }

    /**
     * Mostra come leggere metadati principali da un oggetto Class.
     */
    private static void demoClassMetadata() {
        printSection("1) Class Metadata");

        Class<?> target = DemoEntity.class;

        // Reflection parte sempre da Class<?>:
        // da qui è possibile accedere a nome, package, gerarchia, modificatori e membri.
        System.out.println("Class name: " + target.getName());
        System.out.println("Simple name: " + target.getSimpleName());
        System.out.println("Package: " + target.getPackageName());
        System.out.println("Superclass: " + target.getSuperclass().getSimpleName());
        System.out.println("Is record: " + target.isRecord());
        System.out.println("Is sealed: " + target.isSealed());
        System.out.println("Modifiers: " + Modifier.toString(target.getModifiers()));

        printSubSection("Declared fields");
        for (Field field : target.getDeclaredFields()) {
            System.out.println("- " + field.getName() + " : " + field.getType().getSimpleName());
        }
    }

    /**
     * Mostra recupero costruttori e creazione dinamica istanze.
     */
    private static void demoConstructorsAndDynamicInstantiation() {
        printSection("2) Constructors and Dynamic Instantiation");

        try {
            // Recuperiamo il costruttore pubblico con parametri specifici.
            Constructor<DemoEntity> constructor = DemoEntity.class
                    .getDeclaredConstructor(String.class, int.class);

            // newInstance crea un oggetto a runtime senza chiamata diretta nel codice sorgente.
            DemoEntity entity = constructor.newInstance("A-100", 42);
            System.out.println("Instance created via reflection -> " + entity);

            // Recuperiamo anche un costruttore privato per scopi didattici.
            Constructor<DemoEntity> privateConstructor = DemoEntity.class
                    .getDeclaredConstructor(String.class);
            privateConstructor.setAccessible(true);
            DemoEntity privateEntity = privateConstructor.newInstance("PRIVATE-ONLY");
            System.out.println("Instance from private ctor -> " + privateEntity);
        } catch (ReflectiveOperationException exception) {
            System.out.println("Constructor reflection error: " + exception.getMessage());
        }
    }

    /**
     * Mostra lettura/scrittura campi, inclusi campi privati.
     */
    private static void demoFieldsAndEncapsulationBoundaries() {
        printSection("3) Fields and Encapsulation Boundaries");

        try {
            DemoEntity entity = new DemoEntity("B-200", 10);

            // Accesso campo pubblico con getField (solo public, anche ereditati).
            Field categoryField = DemoEntity.class.getField("category");
            System.out.println("Public field initial value -> " + categoryField.get(entity));
            categoryField.set(entity, "REFLECTION-UPDATED");
            System.out.println("Public field updated value -> " + categoryField.get(entity));

            // Accesso campo privato con getDeclaredField + setAccessible(true).
            Field quantityField = DemoEntity.class.getDeclaredField("quantity");
            quantityField.setAccessible(true);
            int currentQty = (int) quantityField.get(entity);
            quantityField.set(entity, currentQty + 25);

            System.out.println("Private field updated quantity -> " + quantityField.get(entity));
            System.out.println("Entity after reflection write -> " + entity);
        } catch (ReflectiveOperationException exception) {
            System.out.println("Field reflection error: " + exception.getMessage());
        }
    }

    /**
     * Mostra invocazione metodi pubblici/privati e gestione parametri.
     */
    private static void demoMethodsAndDynamicInvocation() {
        printSection("4) Methods and Dynamic Invocation");

        try {
            DemoEntity entity = new DemoEntity("C-300", 5);

            Method addMethod = DemoEntity.class.getMethod("increase", int.class);
            addMethod.invoke(entity, 7);

            Method privateMethod = DemoEntity.class.getDeclaredMethod("auditLine", String.class);
            privateMethod.setAccessible(true);
            Object auditResult = privateMethod.invoke(entity, "manual-check");

            System.out.println("Entity after invoke -> " + entity);
            System.out.println("Private method result -> " + auditResult);

            printSubSection("Method parameters metadata");
            for (Method method : DemoEntity.class.getDeclaredMethods()) {
                Parameter[] parameters = method.getParameters();
                String signature = Arrays.stream(parameters)
                        .map(parameter -> parameter.getType().getSimpleName() + " " + parameter.getName())
                        .reduce((left, right) -> left + ", " + right)
                        .orElse("");
                System.out.println(method.getName() + "(" + signature + ")");
            }
        } catch (ReflectiveOperationException exception) {
            System.out.println("Method reflection error: " + exception.getMessage());
        }
    }

    /**
     * Mostra analisi di annotazioni custom a runtime.
     */
    private static void demoAnnotationInspection() {
        printSection("5) Annotation Inspection");

        Class<AnnotatedService> serviceClass = AnnotatedService.class;

        // Verifichiamo presenza annotazione a livello classe.
        if (serviceClass.isAnnotationPresent(UseCase.class)) {
            UseCase useCase = serviceClass.getAnnotation(UseCase.class);
            System.out.println("Class annotation -> " + useCase.value() + " | level=" + useCase.level());
        }

        // Verifichiamo annotazioni a livello metodo.
        for (Method method : serviceClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(UseCase.class)) {
                UseCase useCase = method.getAnnotation(UseCase.class);
                System.out.println("Method " + method.getName() + " -> " + useCase.value());
            }
        }
    }

    /**
     * Mostra introspezione tipi generici tramite ParameterizedType.
     */
    private static void demoGenericTypeInspection() {
        printSection("6) Generic Type Inspection");

        try {
            Field tagsField = GenericHolder.class.getDeclaredField("tags");
            var genericType = tagsField.getGenericType();

            if (genericType instanceof ParameterizedType parameterizedType) {
                System.out.println("Raw type -> " + parameterizedType.getRawType().getTypeName());
                System.out.println("Type arguments -> " + Arrays.toString(parameterizedType.getActualTypeArguments()));
            }

            Field cacheField = GenericHolder.class.getDeclaredField("scoreById");
            var cacheType = cacheField.getGenericType();
            if (cacheType instanceof ParameterizedType parameterizedType) {
                System.out.println("Map generic declaration -> " + parameterizedType);
            }
        } catch (NoSuchFieldException exception) {
            System.out.println("Generic reflection error: " + exception.getMessage());
        }
    }

    /**
     * Mostra Dynamic Proxy con InvocationHandler.
     */
    private static void demoDynamicProxy() {
        printSection("7) Dynamic Proxy");

        InvocationHandler handler = (proxy, method, args) -> {
            // Intercettiamo ogni chiamata per logging, sicurezza o metriche.
            System.out.println("Proxy intercept -> " + method.getName() + " args=" + Arrays.toString(args));

            if (method.getName().equals("formatUser") && args != null && args.length == 1) {
                return "USER::" + String.valueOf(args[0]).toUpperCase();
            }

            if (method.getName().equals("ping")) {
                return "pong";
            }

            return null;
        };

        UserFormatter formatter = (UserFormatter) Proxy.newProxyInstance(
                UserFormatter.class.getClassLoader(),
                new Class<?>[] { UserFormatter.class },
                handler);

        System.out.println("Proxy call formatUser -> " + formatter.formatUser("mario"));
        System.out.println("Proxy call ping -> " + formatter.ping());
    }

    /**
     * Mostra metadata reflection su record e sealed interfaces.
     */
    private static void demoRecordsAndSealedMetadata() {
        printSection("8) Records and Sealed Metadata");

        Class<?> recordClass = AuditRecord.class;
        System.out.println("Is record: " + recordClass.isRecord());

        // Nei record possiamo enumerare i componenti con API dedicate.
        Arrays.stream(recordClass.getRecordComponents())
                .forEach(component -> System.out.println("Record component -> " + component.getName() + " : "
                        + component.getType().getSimpleName()));

        Class<?> sealedType = PaymentEvent.class;
        System.out.println("Is sealed: " + sealedType.isSealed());

        // Permitted subclasses rende esplicito il modello chiuso dei tipi.
        Arrays.stream(sealedType.getPermittedSubclasses())
            .forEach(desc -> System.out.println("Permitted subtype -> " + desc.getSimpleName()));
    }

    /**
     * Riassume best practices operative e principali rischi.
     */
    private static void demoBestPracticesAndPitfalls() {
        printSection("9) Best Practices and Pitfalls");

        String[] practices = {
                "Use reflection for framework-level concerns, not as default application logic.",
                "Cache reflective lookups (Field/Method/Constructor) in hot paths.",
                "Prefer MethodHandles in performance-critical scenarios.",
                "Validate types before invocation to avoid ClassCastException at runtime.",
                "Limit setAccessible(true) usage and document its purpose.",
                "Wrap reflective calls with explicit error handling and context-rich messages.",
                "Be aware of security/module boundaries when accessing non-public members." };

        for (int i = 0; i < practices.length; i++) {
            System.out.printf("%d) %s%n", i + 1, practices[i]);
        }

        printSubSection("Common anti-patterns");
        System.out.println("- Overusing reflection where direct typed calls are simpler and safer");
        System.out.println("- Ignoring performance impact in loops with repeated lookups");
        System.out.println("- Mutating private state without validation contracts");
        System.out.println("- Swallowing reflective exceptions without actionable diagnostics");
    }

    /**
     * Rendering header principale.
     */
    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(CYAN + "=".repeat(92) + RESET);
        System.out.println(BLUE + " " + title + RESET);
        System.out.println(CYAN + "=".repeat(92) + RESET);
    }

    /**
     * Rendering sezione principale.
     */
    private static void printSection(String title) {
        System.out.println();
        System.out.println(MAGENTA + "► " + title + RESET);
        System.out.println(YELLOW + "-".repeat(92) + RESET);
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
        System.out.println(GREEN + "Demo completed: advanced reflection scenarios executed." + RESET);
        System.out.println(CYAN + "=".repeat(92) + RESET);
    }

    /**
     * Entità di supporto per esempi reflection su campi/metodi/costruttori.
     */
    public static class DemoEntity {
        public String category = "DEFAULT";
        private String id;
        private int quantity;

        public DemoEntity(String id, int quantity) {
            this.id = id;
            this.quantity = quantity;
        }

        @SuppressWarnings("unused")
        private DemoEntity(String id) {
            this(id, 0);
        }

        public void increase(int amount) {
            this.quantity += amount;
        }

        @SuppressWarnings("unused")
        private String auditLine(String reason) {
            return "Audit[id=" + id + ", quantity=" + quantity + ", reason=" + reason + "]";
        }

        @Override
        public String toString() {
            return "DemoEntity{id='" + id + "', quantity=" + quantity + ", category='" + category + "'}";
        }
    }

    /**
     * Annotazione custom per esempi di introspezione metadata.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.TYPE, ElementType.METHOD })
    public @interface UseCase {
        String value();

        int level() default 1;
    }

    /**
     * Classe annotata per demo di annotation processing manuale.
     */
    @UseCase(value = "Sample annotated service", level = 2)
    public static class AnnotatedService {

        @UseCase("Method-level annotation demo")
        public void execute() {
        }
    }

    /**
     * Classe con campi generici per introspezione ParameterizedType.
     */
    public static class GenericHolder {
        @SuppressWarnings("unused")
        private final List<String> tags = List.of("java", "reflection");

        @SuppressWarnings("unused")
        private final java.util.Map<String, Integer> scoreById = java.util.Map.of("A", 10);
    }

    /**
     * Interfaccia per demo di dynamic proxy.
     */
    public interface UserFormatter {
        String formatUser(String input);

        String ping();
    }

    /**
     * Record di supporto per metadata reflection.
     */
    public record AuditRecord(String actor, LocalDate at, String action) {
    }

    /**
     * Sealed hierarchy di supporto per demo metadata.
     */
    public sealed interface PaymentEvent permits PaymentCreated, PaymentFailed {
    }

    public static final class PaymentCreated implements PaymentEvent {
    }

    public static final class PaymentFailed implements PaymentEvent {
    }
}