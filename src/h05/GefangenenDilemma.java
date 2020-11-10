package h05;

public class GefangenenDilemma {

    private final GefangenenStrategie strategie1;
    private final GefangenenStrategie strategie2;
    private int strategie1Punkte = 0;
    private int strategie2Punkte = 0;

    public GefangenenDilemma(GefangenenStrategie strategie1, GefangenenStrategie strategie2) {
        this.strategie1 = strategie1;
        this.strategie2 = strategie2;
    }

    /**
     * Druch diese Methode wird das Spiel letztendlich durchgefuehrt. Der Gewinner wird am Ende ausgegeben.
     * @param n Rundenanzahl wie lange das Spiel laufen soll.
     */
    public void spiele(int n) {
        boolean entscheidung1;
        boolean entscheidung2;
        for (int i = 0; i < n; i++) {
            entscheidung1 = strategie1.getNextDecision();
            entscheidung2 = strategie2.getNextDecision();
            punkteVerteilen(entscheidung1, entscheidung2);
            strategie1.setOpponentsLastDecision(entscheidung2);
            strategie2.setOpponentsLastDecision(entscheidung1);
            System.out.println("P1: " + entscheidungToString(entscheidung1) + " mit " + strategie1Punkte + " Punkten");
            System.out.println("P2: " + entscheidungToString(entscheidung2) + " mit " + strategie2Punkte + " Punkten");
        }
        System.out.println("\n" + getWinner(strategie1Punkte, strategie2Punkte));
    }

    /**
     * Hilfsmehtode die eine Entscheidung (boolean) als einen String zurueck gibt.
     * @param b Entscheidung nachdem der richtige String zurueckgegeben wird
     * @return einen String basierent auf der Entscheidung
     */
    private String entscheidungToString(boolean b){
        if(!b){
            return "kooperiert";
        } else {
            return "betruegt";
        }
    }

    /**
     * Hilfsmethode die den Gewinner anhand eines Punktestandes ermittelt.
     * @param p1 Punktestand Spieler 1
     * @param p2 Punktestand Spieler 2
     * @return Gibt das Ergebnis einer Runde als String zurueck.
     */
    private String getWinner(int p1, int p2) {
        if(p1 == p2)
            return "Gleichstand!";
        if (p1 < p2)
            return "P1 hat gewonnen!";
        return "P2 hat gewonnen!";
    }

    /**
     * Hilfsmethode die anhand zwei Entscheidungen die Punke verteilt.
     * @param entscheidung1 Entscheidung von Spieler 1
     * @param entscheidung2 Entscheidung von Spieler 2
     */
    private void punkteVerteilen(boolean entscheidung1, boolean entscheidung2) {
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
}