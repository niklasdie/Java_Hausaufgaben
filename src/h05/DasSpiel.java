package h05;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DasSpiel {

    public static void main(String[] args) {
        int auswahl;
        System.out.println("        --------- Gefangenendilemma ---------" + "\n");
        System.out.println("1 = Selbst spielen (Multiplayer)" + "\n" + "2 = Vorgegebene Strategien testen (Aufgabe)"
                + "\n" + "0 = Abbrechen" + "\n");
        System.out.print("Auswahl (int): ");
        while (true) {
            try (Scanner sc = new Scanner(System.in)) {
                auswahl = sc.nextInt();
                if (auswahl != 1 && auswahl != 2 && auswahl != 0)
                    throw new InputMismatchException("");
                sc.close();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Fehler: die Eingabe muss 0 oder 1 sein! Nochmal probieren: ");
            }
        }
        if (auswahl == 2) {
            strategien();
        } else {
            if(auswahl == 1)
            selbstSpeielen();
        }
        System.out.println("\n" + "Spiel beendet");
    }

    private static void strategien() {
        //Neues Objekt vom Typ GefangenenDilemma mit 2 Spielern
        GefangenenDilemma gd = new GefangenenDilemma(new TitForTat(), new Random());
        //100 mal spielen
        gd.spiele(100);
    }

    private static void selbstSpeielen() {
        String name1;
        String name2;
        int runden;
        System.out.println("\n" + "    _____   Das Spiel beginnt   ____" + "\n");
        while (true) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.print("Name von Spieler 1: ");
                name1 = sc.nextLine();
                System.out.print("\n" + "\n" + "Name von Spieler 2: ");
                name2 = sc.nextLine();
                System.out.print("\n" + "\n" + "Anzahl der Runden (int): ");
                runden = Integer.parseInt(sc.nextLine());
                if (runden < 0)
                    throw new InputMismatchException("");
                break;
            } catch (InputMismatchException e) {
                System.out.print("Runde muss in einem positiven Integer eingegeben werden, nochmal probieren:");
            }
        }
        GefangenenDilemma gd = new GefangenenDilemma(name1, name2, runden);
    }
}
