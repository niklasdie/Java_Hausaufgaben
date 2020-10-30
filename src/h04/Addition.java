package h04;

public class Addition implements Rechenoperation {

    private final double a;

    /**
     * Konstruiert ein Objekt der Klasse Addition welche Rechenoperation erweitert.
     * @param a die zu addierende Zahl
     */
    public Addition(double a) {
        this.a = a;
    }

    /**
     * Addiert die uebergebene Zahl mit der vorher definierten Zahl und gibt diese zurueck.
     * @param x wird mit der vorher festgelegten Zahl addiert.
     * @return das Ergebnis der Addition.
     */
    @Override
    public double berechne(double x) {
        return x + this.a;
    }
}
