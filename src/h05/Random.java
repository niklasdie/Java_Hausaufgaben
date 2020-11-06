package h05;

public class Random implements GefangenenStrategie {

    @Override
    public boolean getNextDecision() {
        int i = (int) (Math.random() * 10);
        if (i < 5) {
            return false;
        }
        return true;
    }

    @Override
    public void setOpponentsLastDecision(boolean opponentsLastDecision) {
    }
}
