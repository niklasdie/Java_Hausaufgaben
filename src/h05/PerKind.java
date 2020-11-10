package h05;

/**
 * Erweitert das Interface GefangenenStrategie und implementiert die Strategie PerKind.
 */
public class PerKind implements GefangenenStrategie {

    private int i = 0;

    @Override
    public boolean getNextDecision() {
        if(i < 2) {
            i++;
            return false;
        }
        i = 0;
        return true;
    }

    @Override
    public void setOpponentsLastDecision(boolean opponentsLastDecision) {
    }
}
