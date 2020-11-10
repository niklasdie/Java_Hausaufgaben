package h05;

/**
 * Erweitert das Interface GefangenenStrategie und implementiert die Strategie TitForTat.
 */
public class TitForTat implements GefangenenStrategie {

    private boolean opponentsLastDecision = false;

    @Override
    public boolean getNextDecision() {
        boolean trigger = false;
        if (!opponentsLastDecision && !trigger) {
            return false;
        }
        trigger = true;
        return true;
    }

    @Override
    public void setOpponentsLastDecision(boolean opponentsLastDecision) {
        this.opponentsLastDecision = opponentsLastDecision;
    }
}