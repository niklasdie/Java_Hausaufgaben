package h05;

/**
 * Erweitert das Interface GefangenenStrategie und implementiert die Strategie Spite.
 */
public class Spite implements GefangenenStrategie {

    private boolean opponentsLastDecision = false;
    private boolean trigger = false;

    @Override
    public boolean getNextDecision() {
        if(trigger){
            return true;
        }
        if (!opponentsLastDecision && !trigger) {
            trigger = true;
            return false;
        }
        return true;
    }

    @Override
    public void setOpponentsLastDecision(boolean opponentsLastDecision) {
        this.opponentsLastDecision = opponentsLastDecision;
    }
}
