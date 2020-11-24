package h07;

public class SchiebAlg1 implements Loesungsalgorithmus {

    /**
     * Verschiebt so lange zufaellig bis die 1 an der oberen linken Position steht.
     * @param schiebepuzzle Eingabepuzzle welches geloest werden soll.
     */
    @Override
    public void loese(Schiebepuzzle schiebepuzzle) {
        int random;
        while ((schiebepuzzle.finde(1)[0] != 0) || (schiebepuzzle.finde(1)[1] != 0)) {
            do {
                random = ((int) (Math.random() * 10000)) % 14 + 1;
            } while (!schiebepuzzle.istVerschiebbar(random));
            schiebepuzzle.schiebe(random);
        }
    }
}
