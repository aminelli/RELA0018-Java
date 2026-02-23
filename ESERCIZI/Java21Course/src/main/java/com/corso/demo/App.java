package com.corso.demo;

import com.corso.samples.datatypes.BigDecimalBigIntegerDemo;
import com.corso.samples.datatypes.MathDemo;
import com.corso.samples.datatypes.PrimitiveTypesDemo;
import com.corso.samples.datatypes.StringDemo;
import com.corso.samples.datatypes.WrapperTypesDemo;

/**
 * Classe principale dell'applicazione Java21 Course
 * Implementa un sistema di menu TUI per l'apprendimento di Java 21
 */
public class App {
    /**
     * Metodo principale che avvia l'applicazione
     * 
     * @param args Argomenti della riga di comando
     */
    public static void main(String[] args) {
        // Crea un'istanza del menu TUI con il titolo dell'applicazione
        MenuTUI menu = new MenuTUI("Java 21 Course - Menu Principale");

        // Aggiunge le voci di menu per le varie demo
        addMenuItemPrimitiveTypes(menu);
        addMenuItemWrapperTypes(menu);
        addMenuItemBigDecimalBigInteger(menu);
        addMenuItemMath(menu);
        addMenuItemString(menu);

        // Aggiunge la voce per uscire dall'applicazione
        // Quando selezionata, questa voce termina il programma
        addMenuItemExit(menu);
        
        // Avvia il loop principale del menu
        // Il programma rimarrà in esecuzione finché l'utente non seleziona l'opzione di
        // uscita
        menu.start();
    }

    /**
     * Aggiunge al menu la voce per la demo dei Tipi Primitivi
     *
     * @param menu Il menu a cui aggiungere la voce
     */
    private static void addMenuItemPrimitiveTypes(MenuTUI menu) {
        menu.addMenuItem("Tipi Primitivi", () -> {
            // Esegue la demo completa dei tipi primitivi
            PrimitiveTypesDemo.run();

            // Attende che l'utente prema INVIO prima di tornare al menu
            menu.waitForEnter();
        });
    }

    /**
     * Aggiunge al menu la voce per la demo dei Tipi Wrapper
     *
     * @param menu Il menu a cui aggiungere la voce
     */
    private static void addMenuItemWrapperTypes(MenuTUI menu) {
        menu.addMenuItem("Tipi Wrapper", () -> {
            // Esegue la demo completa dei tipi wrapper
            WrapperTypesDemo.run();

            // Attende che l'utente prema INVIO prima di tornare al menu
            menu.waitForEnter();
        });
    }

        /**
     * Aggiunge al menu la voce per la demo di BigDecimal e BigInteger
     * 
     * @param menu Il menu a cui aggiungere la voce
     */
    private static void addMenuItemBigDecimalBigInteger(MenuTUI menu) {
        menu.addMenuItem("BigDecimal e BigInteger", () -> {
            // Esegue la demo completa di BigDecimal e BigInteger
            BigDecimalBigIntegerDemo.run();
            
            // Attende che l'utente prema INVIO prima di tornare al menu
            menu.waitForEnter();
        });
    }


    /**
     * Aggiunge al menu la voce per la demo di Math
     *
     * @param menu Il menu a cui aggiungere la voce
     */
    private static void addMenuItemMath(MenuTUI menu) {
        menu.addMenuItem("Math", () -> {
            // Esegue la demo completa della classe Math
            MathDemo.run();

            // Attende che l'utente prema INVIO prima di tornare al menu
            menu.waitForEnter();
        });
    }

    /**
     * Aggiunge al menu la voce per la demo del tipo String
     * 
     * @param menu Il menu a cui aggiungere la voce
     */
    private static void addMenuItemString(MenuTUI menu) {
        menu.addMenuItem("String", () -> {
            // Esegue la demo completa del tipo String
            StringDemo.run();
            
            // Attende che l'utente prema INVIO prima di tornare al menu
            menu.waitForEnter();
        });
    }


    /**
     * Aggiunge al menu la voce per uscire dall'applicazione
     *
     * @param menu Il menu a cui aggiungere la voce
     */
    private static void addMenuItemExit(MenuTUI menu) {
        menu.addMenuItem("Esci dall'applicazione", () -> {
            // Pulisce lo schermo
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Definisce i colori
            String yellow = "\033[93m";
            String cyan = "\033[96m";
            String reset = "\033[0m";

            // Definisce i messaggi
            String msg1 = "Grazie per aver utilizzato Java 21 Course!";
            String msg2 = "Buono studio e buon coding! ";

            // Calcola il padding per centrare i messaggi (larghezza = 60)
            int width = 60;
            int padding1 = (width - msg1.length()) / 2;
            int padding2 = (width - msg2.length()) / 2;

            // Mostra un messaggio di commiato colorato con cornici allineate
            System.out.println("\n");
            System.out.println("╔════════════════════════════════════════════════════════════╗");
            System.out.println("║                                                            ║");
            System.out.printf("║%s%s%s%s%s%s║%n",
                    " ".repeat(padding1),
                    yellow,
                    msg1,
                    reset,
                    " ".repeat(width - msg1.length() - padding1),
                    "");
            System.out.println("║                                                            ║");
            System.out.printf("║%s%s%s%s%s%s║%n",
                    " ".repeat(padding2),
                    cyan,
                    msg2,
                    reset,
                    " ".repeat(width - msg2.length() - padding2),
                    "");
            System.out.println("║                                                            ║");
            System.out.println("╚════════════════════════════════════════════════════════════╝\n");

            // Chiude le risorse del menu
            menu.close();

            // Termina il menu
            menu.stop();
        });
    }

}
