package h05;

/**
 * Erweitert das Interface GefangenenStrategie und implementiert die Strategie Pavlov.
 */
public class Pavlov implements GefangenenStrategie {

    private boolean opponentsLastDecision = false;
    private boolean ownLastDecision = false;

    @Override
    public boolean getNextDecision() {
        boolean trigger = false;
        if (!opponentsLastDecision && !trigger) {
            trigger = true;
            ownLastDecision = false;
            return false;
        }
        if (opponentsLastDecision != ownLastDecision) {
            ownLastDecision = true;
            return true;
        }
        ownLastDecision = false;
        return false;
    }

    @Override
    public void setOpponentsLastDecision(boolean opponentsLastDecision) {
        this.opponentsLastDecision = opponentsLastDecision;
    }
}
