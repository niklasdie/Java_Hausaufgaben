package h05;

import java.util.Scanner;

public class GefangenenDilemma {

    private int runden;
    Spieler spieler1;
    Spieler spieler2;

    private GefangenenStrategie strategie1;
    private GefangenenStrategie strategie2;
    private int strategie1Punkte = 0;
    private int strategie2Punkte = 0;

    public GefangenenDilemma(GefangenenStrategie strategie1, GefangenenStrategie strategie2) {
        this.strategie1 = strategie1;
        this.strategie2 = strategie2;
    }

    public void spiele(int n) {
        boolean entscheidung1;
        boolean entscheidung2;
        for (int i = 0; i < n; i++) {
            entscheidung1 = strategie1.getNextDecision();
            entscheidung2 = strategie2.getNextDecision();
            punkteVerteilen(entscheidung1, entscheidung2);
            strategie1.setOpponentsLastDecision(entscheidung2);
            strategie2.setOpponentsLastDecision(entscheidung1);
            System.out.println("P1:" + strategie1Punkte + " " + entscheidung1);
            System.out.println("P2:" + strategie2Punkte + " " + entscheidung2);
        }
        System.out.println(getWinner(strategie1Punkte, strategie2Punkte));
    }

    public String getWinner(int p1, int p2) {
        if(p1 == p2)
            return "Gleichstand!";
        if (p1 < p2)
            return "Spieler 1 hat gewonnen!";
        return "Spieler 2 hat gewonnen!";
    }

    public GefangenenDilemma(String name1, String name2, int runden) {
        spieler1 = new Spieler(name1);
        spieler2 = new Spieler(name2);
        this.runden = runden;
    }

    public void nächsteRunde() {
        System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
        System.out.println("Runde " + runden + "\n" + "\n");
        System.out.println("    0 = koperieren ; 1 = betruegen");
        System.out.println(spieler1.getName() + " ist dran: ");
        System.out.println(getWinner(strategie1Punkte, strategie2Punkte));
    }

    public void punkteVerteilen(boolean entscheidung1, boolean entscheidung2) {
        if (entscheidung1 == entscheidung2) {
            if (!entscheidung1) {
                strategie1Punkte += 2;
                strategie2Punkte += 2;
            } else {
                strategie1Punkte += 4;
                strategie2Punkte += 4;
            }
        } else {
            if (!entscheidung1) {
                strategie1Punkte += 6;
                strategie2Punkte += 1;
            } else {
                strategie1Punkte += 1;
                strategie2Punkte += 6;
            }
        }
    }

    public static boolean input() {
        String input;
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                input = sc.nextLine();
                if (input.equals("0") || input.equals("1"))
                    break;
                System.out.println("Fehler: nur '0' und '1' zulässig! Nochmal probieren bitte: ");
            }
        }
        if (input.equals("0"))
            return false;
        if (input.equals("1"))
            return true;
        throw new RuntimeException("Input fehlgeschlagen!");
    }

    public String getWinner(Spieler s1, Spieler s2) {
        if(s1.getPunkte() == s2.getPunkte())
            return "Gleichstand!";
        if (s1.getPunkte() < s2.getPunkte())
            return s1.getName() + "hat gewonnen!";
        return s2.getName() + "hat gewonnen!";
    }

}
