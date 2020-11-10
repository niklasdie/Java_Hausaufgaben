package h05;

/**
 * Erweitert das Interface GefangenenStrategie und implementiert die Strategie Random.
 */
public class Random implements GefangenenStrategie {

    @Override
    public boolean getNextDecision() {
        int i = (int) (Math.random() * 10);
        if (i < 5) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void setOpponentsLastDecision(boolean opponentsLastDecision) {
    }
}