package h09;

/**
 * Hilfklasse die einen Punkt darstellt.
 */
public class Point {

    private final double x;
    private final double y;

    /**
     * Konstruktor erzeugt einen neuen Punkt.
     * @param x Koordinate
     * @param y Koordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter welcher die Koordinaten in einem Array zurueck gibt.
     * @return Array der laenge 2
     */
    public double[] get(){
        return new double[]{x,y};
    }

    /**
     * Darstellung eines Punktes als String.
     * @return Punkt als String
     */
    public String toString(){
        return "(" + this.x + "/" + this.y + ")";
    }
}
