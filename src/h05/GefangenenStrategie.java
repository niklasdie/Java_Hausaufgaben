package h05;

public interface GefangenenStrategie {

    /**
     * Es wird die Entscheidung der einzelnen Strategien ermittelt und zurueck gegeben.
     * @return die Entscheidung
     */
    boolean getNextDecision();

    /**
     * Es wird die vorherige Entscheidung des Gegners gespeichert.
     * @param decision die Entscheidung des Gegners
     */
    void setOpponentsLastDecision(boolean decision);
}