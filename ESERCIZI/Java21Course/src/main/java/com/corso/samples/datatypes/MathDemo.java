package com.corso.samples.datatypes;

import java.util.List;

/**
 * Demo completa per l'apprendimento della classe Math in Java.
 */
public class MathDemo {

    private MathDemo() {
    }

    public static void run() {
        printHeader("MATH IN JAVA");

        demoConstantsAndBasics();
        demoAbsSignMinMax();
        demoRounding();
        demoPowersRootsLogs();
        demoTrigonometry();
        demoRandomAndRange();
        demoExactArithmetic();
        demoFloatingPointSpecials();
        demoUtilityMethods();
        demoBestPractices();

        printFooter();
    }

    private static void demoConstantsAndBasics() {
        printSection("1) Costanti e operazioni base");

        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.E  = " + Math.E);

        double a = 12.5;
        double b = 3.2;

        System.out.println("max(" + a + ", " + b + ") = " + Math.max(a, b));
        System.out.println("min(" + a + ", " + b + ") = " + Math.min(a, b));
        System.out.println("abs(-42) = " + Math.abs(-42));
    }

    private static void demoAbsSignMinMax() {
        printSection("2) abs, signum, min, max");

        double value = -17.75;
        System.out.println("value = " + value);
        System.out.println("abs(value) = " + Math.abs(value));
        System.out.println("signum(value) = " + Math.signum(value));
        System.out.println("signum(0.0) = " + Math.signum(0.0));
        System.out.println("signum(8.2) = " + Math.signum(8.2));

        List<Integer> scores = List.of(18, 30, 22, 27, 25);
        int min = scores.stream().min(Integer::compareTo).orElse(0);
        int max = scores.stream().max(Integer::compareTo).orElse(0);
        System.out.println("scores = " + scores + " -> min=" + min + ", max=" + max);
    }

    private static void demoRounding() {
        printSection("3) Arrotondamento");

        double x = 12.49;
        double y = 12.50;
        double z = -12.50;

        System.out.println("floor(" + x + ") = " + Math.floor(x));
        System.out.println("ceil(" + x + ") = " + Math.ceil(x));
        System.out.println("round(" + x + ") = " + Math.round(x));
        System.out.println("round(" + y + ") = " + Math.round(y));
        System.out.println("round(" + z + ") = " + Math.round(z));
        System.out.println("rint(2.5) = " + Math.rint(2.5) + " (banker's rounding)");
        System.out.println("rint(3.5) = " + Math.rint(3.5) + " (banker's rounding)");
    }

    private static void demoPowersRootsLogs() {
        printSection("4) Potenze, radici, logaritmi, esponenziali");

        double base = 2.0;
        double exp = 10.0;

        System.out.println("pow(" + base + ", " + exp + ") = " + Math.pow(base, exp));
        System.out.println("sqrt(81) = " + Math.sqrt(81));
        System.out.println("cbrt(27) = " + Math.cbrt(27));
        System.out.println("hypot(3, 4) = " + Math.hypot(3, 4));

        System.out.println("exp(1) = " + Math.exp(1));
        System.out.println("log(E) = " + Math.log(Math.E));
        System.out.println("log10(1000) = " + Math.log10(1000));
    }

    private static void demoTrigonometry() {
        printSection("5) Trigonometria");

        double degrees = 60.0;
        double radians = Math.toRadians(degrees);

        System.out.println(degrees + "° in radianti = " + radians);
        System.out.println("sin(" + degrees + "°) = " + Math.sin(radians));
        System.out.println("cos(" + degrees + "°) = " + Math.cos(radians));
        System.out.println("tan(" + degrees + "°) = " + Math.tan(radians));

        double backToDeg = Math.toDegrees(Math.PI / 3);
        System.out.println("PI/3 in gradi = " + backToDeg);
    }

    private static void demoRandomAndRange() {
        printSection("6) random e controllo range");

        double random01 = Math.random();
        int random0to9 = (int) (Math.random() * 10);
        int random10to20 = 10 + (int) (Math.random() * 11);

        System.out.println("Math.random() [0,1) = " + random01);
        System.out.println("Intero [0,9] = " + random0to9);
        System.out.println("Intero [10,20] = " + random10to20);

        int value = 130;
        int clamped = Math.clamp(value, 0, 100);
        System.out.println("clamp(" + value + ", 0, 100) = " + clamped);
    }

    private static void demoExactArithmetic() {
        printSection("7) Aritmetica esatta e overflow safety");

        System.out.println("addExact, subtractExact, multiplyExact intercettano overflow.");

        int a = 1_500_000_000;
        int b = 1_500_000_000;

        try {
            int sum = Math.addExact(a, b);
            System.out.println("Somma esatta: " + sum);
        } catch (ArithmeticException ex) {
            System.out.println("Overflow rilevato con addExact(" + a + ", " + b + ")");
        }

        try {
            int mul = Math.multiplyExact(100_000, 100_000);
            System.out.println("Prodotto esatto: " + mul);
        } catch (ArithmeticException ex) {
            System.out.println("Overflow rilevato con multiplyExact(100000, 100000)");
        }

        long inc = Math.incrementExact(9L);
        long dec = Math.decrementExact(9L);
        long neg = Math.negateExact(-9L);

        System.out.println("incrementExact(9) = " + inc);
        System.out.println("decrementExact(9) = " + dec);
        System.out.println("negateExact(-9) = " + neg);
    }

    private static void demoFloatingPointSpecials() {
        printSection("8) NaN, infinito e confronto floating-point");

        double nan = 0.0 / 0.0;
        double inf = 1.0 / 0.0;
        double negInf = -1.0 / 0.0;

        System.out.println("NaN = " + nan + ", isNaN: " + Double.isNaN(nan));
        System.out.println("+Inf = " + inf + ", isInfinite: " + Double.isInfinite(inf));
        System.out.println("-Inf = " + negInf + ", isInfinite: " + Double.isInfinite(negInf));

        double computed = 0.1 + 0.2;
        double expected = 0.3;
        double epsilon = 1e-10;
        boolean equal = Math.abs(computed - expected) < epsilon;

        System.out.println("0.1 + 0.2 = " + computed);
        System.out.println("Confronto con epsilon(" + epsilon + "): " + equal);
    }

    private static void demoUtilityMethods() {
        printSection("9) Utility utili meno note");

        double angle = -725.0;
        double normalized = Math.floorMod((int) angle, 360);
        System.out.println("Normalizzazione angolo -725° -> " + normalized + "°");

        System.out.println("copySign(5.0, -2.0) = " + Math.copySign(5.0, -2.0));
        System.out.println("ulp(1.0) = " + Math.ulp(1.0));
        System.out.println("nextUp(1.0) = " + Math.nextUp(1.0));
        System.out.println("nextDown(1.0) = " + Math.nextDown(1.0));

        int floorDiv = Math.floorDiv(-7, 3);
        int floorMod = Math.floorMod(-7, 3);
        System.out.println("floorDiv(-7,3) = " + floorDiv);
        System.out.println("floorMod(-7,3) = " + floorMod);
    }

    private static void demoBestPractices() {
        printSection("10) Best practices e anti-pattern");

        String[] best = {
                "Usa Math.addExact/multiplyExact su interi quando l'overflow è critico.",
                "Per confronti double usa una tolleranza (epsilon), non == diretto.",
                "Per soldi preferisci BigDecimal, non double.",
                "Usa toRadians/toDegrees per evitare errori unità in trigonometria.",
                "Preferisci hypot(a,b) a sqrt(a*a+b*b) per stabilità numerica.",
                "Usa floorDiv/floorMod con numeri negativi per risultati matematicamente coerenti.",
                "Usa clamp per imporre limiti in input utente o configurazioni.",
                "Per random in produzione/simulazioni avanzate preferisci Random/SplittableRandom." };

        for (int i = 0; i < best.length; i++) {
            System.out.printf("%d) %s%n", i + 1, best[i]);
        }

        printSubSection("Anti-pattern comuni");
        System.out.println("- Usare double per calcoli monetari.");
        System.out.println("- Confrontare floating-point con == senza epsilon.");
        System.out.println("- Ignorare overflow in somme/moltiplicazioni su int/long.");
        System.out.println("- Dimenticare conversione gradi/radianti nelle funzioni trigonometrie.");
    }

    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-58s ║%n", title);
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }

    private static void printSection(String title) {
        System.out.println();
        System.out.println("-".repeat(60));
        System.out.println(title);
        System.out.println("-".repeat(60));
    }

    private static void printSubSection(String title) {
        System.out.println();
        System.out.println("▶ " + title);
    }

    private static void printFooter() {
        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println("Fine demo Math");
        System.out.println("=".repeat(60));
    }
}
