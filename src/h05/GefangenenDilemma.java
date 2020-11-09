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
        System.out.println("\n" + getWinner(strategie1Punkte, strategie2Punkte));
    }

    public String getWinner(int p1, int p2) {
        if(p1 == p2)
            return "Gleichstand!";
        if (p1 < p2)
            return "P1 hat gewonnen!";
        return "P2 hat gewonnen!";
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
}
