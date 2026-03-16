package com.corso.samples.oop;

import java.util.List;
import java.util.Objects;

/**
 * Demo completa sui livelli di visibilità per classi, costruttori, metodi e proprietà.
 *
 * <p>
 * Copre anche le tipologie principali di classi dichiarabili e i relativi scenari d'uso.
 * </p>
 */
public class VisibilityLevelsDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private VisibilityLevelsDemo() {
    }

    public static void run() {
        printHeader("LIVELLI DI VISIBILITA - CLASSI, COSTRUTTORI, METODI, PROPRIETA");

        demoIntroduction();
        demoVisibilityMatrix();
        demoTopLevelClassVisibility();
        demoMemberVisibility();
        demoConstructorVisibility();
        demoMethodsVisibility();
        demoPropertiesVisibility();
        demoInheritanceAndProtected();
        demoNestedClassVisibilities();
        demoDeclaredClassTypesOverview();
        demoAbstractAndFinalClasses();
        demoSealedHierarchy();
        demoLocalAndAnonymousClassScenario();
        demoRecordVisibilityAndUse();
        demoUtilityClassVisibilityPattern();
        demoBestPractices();

        printFooter();
    }

    private static void demoIntroduction() {
        printSection("1) Introduzione");

        System.out.println("I livelli di visibilità controllano chi può accedere a classi e membri.");
        System.out.println("In Java i principali modificatori sono: public, protected, package-private, private.");

        printSubSection("Perché è importante");
        System.out.println("- Riduce accoppiamento tra componenti");
        System.out.println("- Protegge invarianti e stato interno");
        System.out.println("- Rende l'API più chiara e sicura");
    }

    private static void demoVisibilityMatrix() {
        printSection("2) Matrice di visibilità");

        System.out.println("public          -> accessibile ovunque");
        System.out.println("protected       -> stesso package + sottoclassi (anche altri package)");
        System.out.println("package-private -> stesso package (nessun modificatore)");
        System.out.println("private         -> solo dentro la stessa classe");

        printSubSection("Nota top-level class");
        System.out.println("Per classi top-level sono ammessi solo: public e package-private.");
    }

    private static void demoTopLevelClassVisibility() {
        printSection("3) Visibilità classi top-level");

        PublicApiService apiService = new PublicApiService("payments");
        PackageLocalHelper helper = new PackageLocalHelper();

        System.out.println("Top-level public: " + apiService.describe());
        System.out.println("Top-level package-private: " + helper.help());

        printSubSection("Scenario");
        System.out.println("Esponi solo le classi che fanno parte dell'API del package.");
        System.out.println("Le classi di supporto interne al package meglio package-private.");
    }

    private static void demoMemberVisibility() {
        printSection("4) Visibilità membri (campi/metodi)");

        VisibilityBox box = new VisibilityBox("demo-box", 10);
        box.increment();
        box.increment();

        System.out.println("public getter -> " + box.getName());
        System.out.println("protected method via public facade -> " + box.protectedStatus());
        System.out.println("package-private method via public facade -> " + box.packageStatus());
        System.out.println("private field snapshot -> " + box.privateSnapshot());
    }

    private static void demoConstructorVisibility() {
        printSection("5) Visibilità dei costruttori");

        ConstructorVisibilitySample byPublic = new ConstructorVisibilitySample("public-ctor");
        ConstructorVisibilitySample byProtected = new ConstructorVisibilitySample(7);
        ConstructorVisibilitySample byPackage = new ConstructorVisibilitySample(true);
        ConstructorVisibilitySample byFactory = ConstructorVisibilitySample.withInternalSeed("factory");

        System.out.println("Costruttore public: " + byPublic.label());
        System.out.println("Costruttore protected: " + byProtected.label());
        System.out.println("Costruttore package-private: " + byPackage.label());
        System.out.println("Factory su costruttore private: " + byFactory.label());

        printSubSection("Pattern comune");
        System.out.println("Costruttore private + factory method per controllo creazione e validazione.");
    }

    private static void demoMethodsVisibility() {
        printSection("6) Visibilità dei metodi");

        AccessWorkflow workflow = new AccessWorkflow();

        System.out.println("Metodo public: " + workflow.start());
        System.out.println("Metodo protected (indiretto): " + workflow.exposeProtectedStep());
        System.out.println("Metodo package-private (indiretto): " + workflow.exposePackageStep());

        printSubSection("Metodo private");
        System.out.println("Il metodo private orchestrato internamente garantisce coerenza del flusso.");
    }

    private static void demoPropertiesVisibility() {
        printSection("7) Visibilità delle proprietà (campi)");

        SecureCounter counter = new SecureCounter();
        counter.increase();
        counter.increase();

        System.out.println("Valore esposto in sola lettura: " + counter.getValue());
        System.out.println("Motivo: il campo è private, modificabile solo tramite metodi controllati.");

        printSubSection("Anti-pattern");
        System.out.println("Evitare campi public mutabili: espongono stato inconsistente.");
    }

    private static void demoInheritanceAndProtected() {
        printSection("8) protected e ereditarietà");

        AuditChildService child = new AuditChildService("audit-engine");
        System.out.println("Child service -> " + child.runAudit());

        printSubSection("Regola protected");
        System.out.println("Una sottoclasse può usare membri protected della base.");
    }

    private static void demoNestedClassVisibilities() {
        printSection("9) Visibilità classi annidate");

        Container container = new Container("CORE");
        Container.PublicNested p = new Container.PublicNested("public nested");
        Container.PackageNested q = new Container.PackageNested("package nested");
        Container.ProtectedNested r = new Container.ProtectedNested("protected nested");
        Container.PrivateNested s = container.new PrivateNested("private nested");

        System.out.println(p.describe());
        System.out.println(q.describe());
        System.out.println(r.describe());
        System.out.println(s.describe());
    }

    private static void demoDeclaredClassTypesOverview() {
        printSection("10) Tipologie di classi dichiarabili");

        System.out.println("- Classe concreta (ConcreteService)");
        System.out.println("- Classe astratta (AbstractProcessor)");
        System.out.println("- Classe final (FinalToken)");
        System.out.println("- Classe sealed/non-sealed/final (OperationBase)");
        System.out.println("- Classe annidata statica e inner (Container.*)");
        System.out.println("- Classe locale (LocalValidator)");
        System.out.println("- Classe anonima (anonymous formatter)");
        System.out.println("- Record (AuditRecord)");

        ConcreteService concrete = new ConcreteService();
        System.out.println("ConcreteService sample -> " + concrete.execute());
    }

    private static void demoAbstractAndFinalClasses() {
        printSection("11) Classe astratta e final");

        AbstractProcessor p1 = new CsvProcessor();
        AbstractProcessor p2 = new JsonProcessor();
        FinalToken token = new FinalToken("tk-2026");

        System.out.println(p1.process("csv-input"));
        System.out.println(p2.process("json-input"));
        System.out.println("Final token: " + token.value());

        printSubSection("Scenario");
        System.out.println("Abstract per contratto base + logica comune; final per bloccare estensioni non desiderate.");
    }

    private static void demoSealedHierarchy() {
        printSection("12) Gerarchia sealed");

        List<OperationBase> operations = List.of(
                new AddOperation(10, 5),
                new MultiplyOperation(7, 3),
                new CustomOperation(20, 4));

        for (OperationBase op : operations) {
            System.out.println(op.describe() + " -> " + op.apply());
        }

        printSubSection("Scenario");
        System.out.println("Sealed ottimo per domini con set di varianti controllato e prevedibile.");
    }

    private static void demoLocalAndAnonymousClassScenario() {
        printSection("13) Classe locale e classe anonima");

        int okCount = countValidCodes(List.of("A01", "B99", "BAD", "C77"));
        System.out.println("Valid codes (local class): " + okCount);

        NameFormatter formatter = new NameFormatter() {
            @Override
            String format(String value) {
                return "[ANON-FMT] " + value.trim().toUpperCase();
            }
        };

        System.out.println(formatter.format("  mario rossi "));
    }

    private static void demoRecordVisibilityAndUse() {
        printSection("14) Record e visibilità");

        AuditRecord rec = new AuditRecord("U100", "LOGIN", true);
        System.out.println("Record -> " + rec);
        System.out.println("Accessor impliciti -> userId=" + rec.userId() + ", action=" + rec.action());

        printSubSection("Nota");
        System.out.println("I componenti del record sono final: ideale per dati immutabili.");
    }

    private static void demoUtilityClassVisibilityPattern() {
        printSection("15) Utility class e visibilità");

        String normalized = TextTools.normalize("   Java   Visibility   Demo   ");
        System.out.println("normalize -> '" + normalized + "'");

        printSubSection("Pattern");
        System.out.println("Utility class: final, costruttore private, soli metodi static.");
    }

    private static void demoBestPractices() {
        printSection("16) Best practices e anti-pattern");

        List<String> tips = List.of(
                "Esporre solo ciò che serve: default su private/package-private.",
                "Campi quasi sempre private; modifiche tramite metodi con regole.",
                "Usare protected solo quando c'è una gerarchia reale da estendere.",
                "Limitare public API per ridurre accoppiamento e breaking changes.",
                "Usare costruttori private + factory per creazioni complesse.",
                "Documentare chiaramente i contratti dei metodi public/protected.",
                "Preferire record/final per oggetti di solo dato.",
                "Usare sealed per limitare estensioni non controllate.",
                "Evitare campi public mutabili.",
                "Rivedere periodicamente visibilità troppo ampia.");

        for (int i = 0; i < tips.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, tips.get(i));
        }

        printSubSection("Anti-pattern comuni");
        System.out.println("- Tutto public senza motivo");
        System.out.println("- Setter pubblici che rompono invarianti");
        System.out.println("- protected usato come scorciatoia invece di API ben definite");
        System.out.println("- classi helper pubbliche quando bastava package-private");
    }

    private static int countValidCodes(List<String> codes) {
        class LocalValidator {
            boolean isValid(String code) {
                return code != null
                        && code.length() == 3
                        && Character.isUpperCase(code.charAt(0))
                        && Character.isDigit(code.charAt(1))
                        && Character.isDigit(code.charAt(2));
            }
        }

        LocalValidator validator = new LocalValidator();
        int count = 0;
        for (String code : codes) {
            if (validator.isValid(code)) {
                count++;
            }
        }
        return count;
    }

    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════╗" + RESET);
        System.out.printf(CYAN + "║ %-58s ║%n" + RESET, title);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    private static void printSection(String title) {
        System.out.println();
        System.out.println(BLUE + "────────────────────────────────────────────────────────────" + RESET);
        System.out.println(GREEN + title + RESET);
        System.out.println(BLUE + "────────────────────────────────────────────────────────────" + RESET);
    }

    private static void printSubSection(String subtitle) {
        System.out.println();
        System.out.println(MAGENTA + "▶ " + subtitle + RESET);
    }

    private static void printFooter() {
        System.out.println();
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
        System.out.println(YELLOW + " Fine demo: Livelli Visibilità" + RESET);
        System.out.println(YELLOW + "════════════════════════════════════════════════════════════" + RESET);
    }

    public static class PublicApiService {
        private final String domain;

        public PublicApiService(String domain) {
            this.domain = Objects.requireNonNull(domain);
        }

        public String describe() {
            return "PublicApiService(" + domain + ")";
        }
    }

    static class PackageLocalHelper {
        String help() {
            return "PackageLocalHelper active";
        }
    }

    private static class VisibilityBox {
        private final String name;
        private int counter;

        private VisibilityBox(String name, int start) {
            this.name = Objects.requireNonNull(name);
            this.counter = start;
        }

        public String getName() {
            return name;
        }

        public void increment() {
            incrementInternal();
        }

        protected String protectedStatus() {
            return protectedDescribe();
        }

        String packageStatus() {
            return packageDescribe();
        }

        public String privateSnapshot() {
            return "counter=" + counter + ", secret=" + secretTag();
        }

        private void incrementInternal() {
            counter++;
        }

        protected String protectedDescribe() {
            return "protected: box=" + name;
        }

        String packageDescribe() {
            return "package: value=" + counter;
        }

        private String secretTag() {
            return "VBOX-" + counter;
        }
    }

    private static class ConstructorVisibilitySample {
        private final String seed;

        public ConstructorVisibilitySample(String seed) {
            this.seed = Objects.requireNonNull(seed);
        }

        protected ConstructorVisibilitySample(int number) {
            this.seed = "protected-" + number;
        }

        ConstructorVisibilitySample(boolean enabled) {
            this.seed = enabled ? "pkg-true" : "pkg-false";
        }

        private ConstructorVisibilitySample(String prefix, int id) {
            this.seed = prefix + "-" + id;
        }

        public static ConstructorVisibilitySample withInternalSeed(String prefix) {
            return new ConstructorVisibilitySample(prefix, 99);
        }

        public String label() {
            return "ConstructorVisibilitySample(" + seed + ")";
        }
    }

    private static class AccessWorkflow {
        public String start() {
            return "start -> " + privateCoreStep();
        }

        public String exposeProtectedStep() {
            return protectedStep();
        }

        public String exposePackageStep() {
            return packageStep();
        }

        protected String protectedStep() {
            return "protected-step";
        }

        String packageStep() {
            return "package-step";
        }

        private String privateCoreStep() {
            return "private-core";
        }
    }

    private static class SecureCounter {
        private int value;

        public int getValue() {
            return value;
        }

        public void increase() {
            value++;
        }
    }

    private static class AuditBaseService {
        protected final String serviceName;

        protected AuditBaseService(String serviceName) {
            this.serviceName = Objects.requireNonNull(serviceName);
        }

        protected String protectedAuditMessage() {
            return "audit-by=" + serviceName;
        }
    }

    private static class AuditChildService extends AuditBaseService {
        AuditChildService(String serviceName) {
            super(serviceName);
        }

        String runAudit() {
            return "child-access -> " + protectedAuditMessage();
        }
    }

    private static class Container {
        private final String scope;

        Container(String scope) {
            this.scope = Objects.requireNonNull(scope);
        }

        public static class PublicNested {
            private final String label;

            public PublicNested(String label) {
                this.label = label;
            }

            public String describe() {
                return "PublicNested(" + label + ")";
            }
        }

        static class PackageNested {
            private final String label;

            PackageNested(String label) {
                this.label = label;
            }

            String describe() {
                return "PackageNested(" + label + ")";
            }
        }

        protected static class ProtectedNested {
            private final String label;

            protected ProtectedNested(String label) {
                this.label = label;
            }

            protected String describe() {
                return "ProtectedNested(" + label + ")";
            }
        }

        private class PrivateNested {
            private final String label;

            private PrivateNested(String label) {
                this.label = label;
            }

            private String describe() {
                return "PrivateNested(" + label + ") in scope=" + scope;
            }
        }
    }

    private static class ConcreteService {
        String execute() {
            return "ConcreteService.execute()";
        }
    }

    private abstract static class AbstractProcessor {
        public String process(String input) {
            return prefix() + transform(input);
        }

        protected abstract String prefix();

        protected abstract String transform(String input);
    }

    private static final class CsvProcessor extends AbstractProcessor {
        @Override
        protected String prefix() {
            return "CSV:";
        }

        @Override
        protected String transform(String input) {
            return input.trim().toLowerCase();
        }
    }

    private static final class JsonProcessor extends AbstractProcessor {
        @Override
        protected String prefix() {
            return "JSON:";
        }

        @Override
        protected String transform(String input) {
            return "{\"payload\":\"" + input + "\"}";
        }
    }

    private static final class FinalToken {
        private final String value;

        FinalToken(String value) {
            this.value = Objects.requireNonNull(value);
        }

        String value() {
            return value;
        }
    }

    private sealed abstract static class OperationBase permits AddOperation, MultiplyOperation, CustomOperation {
        protected final int left;
        protected final int right;

        protected OperationBase(int left, int right) {
            this.left = left;
            this.right = right;
        }

        abstract int apply();

        String describe() {
            return getClass().getSimpleName() + "(" + left + "," + right + ")";
        }
    }

    private static final class AddOperation extends OperationBase {
        private AddOperation(int left, int right) {
            super(left, right);
        }

        @Override
        int apply() {
            return left + right;
        }
    }

    private static final class MultiplyOperation extends OperationBase {
        private MultiplyOperation(int left, int right) {
            super(left, right);
        }

        @Override
        int apply() {
            return left * right;
        }
    }

    private static non-sealed class CustomOperation extends OperationBase {
        private CustomOperation(int left, int right) {
            super(left, right);
        }

        @Override
        int apply() {
            return left - right;
        }
    }

    private abstract static class NameFormatter {
        abstract String format(String value);
    }

    private record AuditRecord(String userId, String action, boolean ok) {
        private AuditRecord {
            Objects.requireNonNull(userId);
            Objects.requireNonNull(action);
        }
    }

    private static final class TextTools {
        private TextTools() {
            throw new AssertionError("Utility class non istanziabile");
        }

        static String normalize(String value) {
            if (value == null) {
                return "";
            }
            return value.trim().replaceAll("\\s+", " ");
        }
    }
}
