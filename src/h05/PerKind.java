package h05;

public class PerKind implements GefangenenStrategie {

    private boolean opponentsLastDecision = false;
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
        this.opponentsLastDecision = opponentsLastDecision;
    }
}
