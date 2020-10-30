package h04;

public class Quadrat implements Rechenoperation {

    /**
     * Berechnet das Quadrat der eingegebenen Zahl und gibt diese zurück.
     * @param x Zahl die Quadriert werden soll.
     * @return die Quadrierte Zahl.
     */
    @Override
    public double berechne(double x) {
        return x * x;
    }
}
