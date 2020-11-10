package h05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DasSpiel {

    public static void main(String[] args) {
        neuesSpiel();
    }

    /**
     * Wird vom Konstruktor aufgerufen und gibt das Anfangsmenue aus und verarbeitet die erste Eingabe.
     * Ruft danach strategie() oder selbstSpielen() auf.
     */
    private static void neuesSpiel() {
        int auswahl;
        System.out.println("\n" + "       --------- Gefangenendilemma ---------" + "\n");
        System.out.println("1 = Selbst spielen (Extra)" + "\n" + "2 = Vorgegebene Strategien testen (Aufgabe)"
                + "\n" + "0 = Abbrechen" + "\n");
        System.out.print("Auswahl (int): ");
        try {
            Scanner sc = new Scanner(System.in); // kein sc.close() damit System.in nicht geschlossen wird
            if (sc.hasNextLine()) {
                auswahl = sc.nextInt();
                if (auswahl != 1 && auswahl != 2 && auswahl != 0) {
                    throw new InputMismatchException("");
                }
                if (auswahl == 2) {
                    strategien();
                } else {
                    if (auswahl == 1) {
                        selbstSpeielen();
                    }
                }
                System.out.println("\n" + "Spiel beendet");
            }
        } catch (InputMismatchException e) {
            System.out.print("Eingabefehler, nochmal probieren ..." + "\n");
            neuesSpiel();
        }
    }

    /**
     * Hier faengt der eigentliche Hausaufgabenteil an.
     * Es werden die Strategien ausgegeben, die Eingabe der Auswahl verarbeitet und das Spiel wird gestartet.
     */
    private static void strategien() {
        int auswahl;
        System.out.println("\n" + "Es werden immer 100 Runden gespielt!");
        System.out.print("Strategieauswahl:" + "\n" + "1 = TitForTat" + "\n" + "2 = Spite" + "\n" + "3 = Pavlov"
                + "\n" + "4 = Random" + "\n" + "5 = PerKind" + "\n" + "\n" + "Auswahl: ");
        try {
            Scanner sc = new Scanner(System.in); // kein sc.close() damit System.in nicht geschlossen wird
            if (sc.hasNextInt()) {
                auswahl = sc.nextInt();
                GefangenenStrategie s1 = getStrategie(auswahl);
                System.out.print("und: ");
                auswahl = sc.nextInt();
                GefangenenStrategie s2 = getStrategie(auswahl);
                GefangenenDilemma gd = new GefangenenDilemma(s1, s2);
                System.out.println("\n");
                gd.spiele(100);
            }
        } catch (NumberFormatException | IllegalStateException e) {
            System.out.println("Eingabefehler, nochmal probieren ..." + "\n");
            strategien();
        }
    }

    /**
     * Hilfsfunktion die in strategie() und selbstSpielen() genutzt wird, die das erzeugen einer ausgewaehlten
     * Strategie vereinfacht.
     * @param i die eingegeben Auswahl
     * @return eine neue Gefangenenstrategie
     */
    private static GefangenenStrategie getStrategie(int i) {
        switch (i) {
            case 1:
                return new TitForTat();
            case 2:
                return new Spite();
            case 3:
                return new Pavlov();
            case 4:
                return new Random();
            case 5:
                return new PerKind();
            default:
                throw new IllegalStateException("");
        }
    }

    /**
     * Zusaetzlich zur Hausaufgabe
     * Es wird eine Gegnerstrategie und die Rundenanzahl gewaehlt fuer ein Spiel, welches man gegen eine
     * vorprogrammierte Strategie spielt, danach wird das Spiel gestartet.
     */
    private static void selbstSpeielen() {
        int auswahl;
        System.out.println("\n" + "\n" + "       ------   Das Spiel   ------");
        while (true) {
            try {
                System.out.println("\n" + "Waehle deine Gegnerstrategie: ");
                System.out.print("Strategieauswahl:" + "\n" + "1 = TitForTat" + "\n" + "2 = Spite" + "\n" +
                        "3 = Pavlov" + "\n" + "4 = Random" + "\n" + "5 = PerKind" + "\n" + "\n" + "Auswahl: ");
                Scanner sc = new Scanner(System.in); // kein sc.close() damit System.in nicht geschlossen wird
                if (sc.hasNextInt()) {
                    auswahl = sc.nextInt();
                    GefangenenStrategie s = getStrategie(auswahl);
                    System.out.print("Anzahl der Runden (int): ");
                    auswahl = sc.nextInt();
                    if (auswahl < 0)
                        throw new InputMismatchException("");
                    GefangenenDilemma gd = new GefangenenDilemma(new SpielerStrategie(), s);
                    System.out.println("\n" + "\n" + "       ------   Das Spiel beginnt   ------" + "\n" +
                            "(Du bist P1)");
                    gd.spiele(auswahl);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Eingabefehler, nochmal probieren ..." + "\n");
                selbstSpeielen();
            }
        }
    }
}
