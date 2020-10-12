import java.util.Arrays;

/**
 * @author Niklas Diekhoener
 */

public class KomplexeZahl {

    private double a;
    private double b;

    /**
     * Konstruktor
     * @param a Realteil
     * @param b Imaginaerteil
     */
    public KomplexeZahl(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     *
     * @return gibt den Realteil zurueck
     */
    public double getA() {
        return this.a;
    }

    /**
     *
     * @return gibt den Imaginaerteil zurueck
     */
    public double getB() {
        return this.b;
    }

    /**
     * addiert this mit einer weiteren komplexen Zahl
     * @param z ist die zu addierende Zahl
     */
    public void addiere(KomplexeZahl z) {
        this.a += z.a;
        this.b += z.b;
    }

    /**
     * multipliziert this mit einer weiteren komplexen Zahl
     * @param z ist die zu multiplizierende Zahl
     */
    public void multipliziere(KomplexeZahl z) {
        double c;
        c = this.a;
        this.a = (this.a * z.a) - (this.b * z.b);
        this.b = (c * z.b) + (z.a * this.b);
    }

    /**
     * Diese Methode berechnet den Betrag einer komplexen Zahl.
     * @return gibt den Betrag zurueck
     */
    public double getBetrag() {
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    /**
     * Ueberschreibt die default toString Methode
     * @return textuelle Repraesentation der komplexen Zahl
     */
    public String toString() {
        if (this.b == 0) {
            return "" + this.a;
        }
        if (this.a == 0) {
            if (this.b == 1) {
                return "i";
            }
            return this.b + " i";
        }
        if (this.b == 1) {
            return this.a + " + i";
        }
        if (this.b == -1) {
            return this.a + " - i";
        }
        if (this.b < 0) {
            return this.a + " - " + Math.abs(this.b) + " i";
        }
        return this.a + " + " + this.b + " i";
    }

    /**
     *
     * @return gibt die Quadratwurzel einer komplexen Zahl zurueck
     */
    public KomplexeZahl[] getWurzel() {
        KomplexeZahl[] res = new KomplexeZahl[2];
        KomplexeZahl z1 = new KomplexeZahl(0, 0);
        KomplexeZahl z2 = new KomplexeZahl(0, 0);
        boolean schalter = true;
        double q = 0;
        if (this.a == 0) {
            z1 = new KomplexeZahl(0, Math.sqrt(Math.abs(this.b)));
            z2 = new KomplexeZahl(0, -Math.sqrt(Math.abs(this.b)));
            schalter = false;
        }
        if (this.b == 0) {
            if (this.a > 0) {
                z1 = new KomplexeZahl(Math.sqrt(this.a), 0);
                z2 = new KomplexeZahl(-Math.sqrt(this.a), 0);
            } else {
                z1 = new KomplexeZahl(0, Math.sqrt(Math.abs(this.a)));
                z2 = new KomplexeZahl(0, -Math.sqrt(Math.abs(this.a)));
            }
            schalter = false;
        }
        if (this.a > 0 && this.b > 0) {
            q = Math.atan(this.b / this.a);
        }
        if ((this.a < 0 && this.b > 0) || (this.a < 0 && this.b < 0)) {
            q = Math.atan(this.b / this.a) + Math.PI;
        }
        if (this.a > 0 && this.b < 0) {
            q = Math.atan(this.b / this.a) + 2 * Math.PI;
        }
        double r = this.getBetrag();
        if (schalter) {
            z1 = new KomplexeZahl(Math.sqrt(r) * Math.cos(q / 2), Math.sqrt(r) * Math.sin(q / 2));
            z2 = new KomplexeZahl(Math.sqrt(r) * Math.cos((q + 2 * Math.PI) / 2), Math.sqrt(r) * Math.sin((q + 2 * Math.PI) / 2));
        }
        res[0] = z1;
        res[1] = z2;
        return res;
    }

    /**
     * Berechnet die Summer zweiter komplexer Zahlen
     * @param z zu addierende komplexe Zahl
     * @return gibt die Summe als komplexe Zahl zurueck
     */
    public KomplexeZahl getSumme(KomplexeZahl z) {
        return new KomplexeZahl(this.a + z.a, this.b + z.b);
    }

    /**
     * Berechnet das Produkt zweiter komplexer Zahlen
     * @param z ist die zu multiplizierende Zahl
     * @return gibt das Produkt als komplexe Zahl zurueck
     */
    public KomplexeZahl getProdukt(KomplexeZahl z) {
        // gibt das Produkt zweiter komplexer Zahlen als komplexe Zahl zurueck
        return new KomplexeZahl(this.a * z.a - this.b * z.b, this.a * z.b + z.a * this.b);
    }

    public static void main(String[] args) {
        KomplexeZahl z = new KomplexeZahl(0, 0); // z := 0
        System.out.println("z = " + z);
        z = new KomplexeZahl(1, 0); // z := 1
        System.out.println("z = " + z);
        z = new KomplexeZahl(0, 1); // z := i
        System.out.println("z = " + z);
        z = new KomplexeZahl(-4, 0); // z := -4
        System.out.println("z = " + z);
        KomplexeZahl[] wurzeln = z.getWurzel(); // => 2i und -2i
        System.out.println("sqrt(z) = " + Arrays.toString(wurzeln));
        z = new KomplexeZahl(1, 1); // z := 1+i
        System.out.println("z = " + z);
        double betrag = z.getBetrag();
        System.out.println("|z| = " + betrag); // => sqrt(2) = 1.41...
        KomplexeZahl z2 = new KomplexeZahl(2, 1); // z2 := 2+i
        System.out.println("z2 = " + z2);
        z.addiere(z2);
        System.out.println("z nach Addition von z2 = " + z);
        z.multipliziere(z2);
        System.out.println("z nach Multiplikation von z2 = " + z);
        z2 = z.getProdukt(new KomplexeZahl(-1, 0)); // z2 := -z
        System.out.println("z2 = " + z2);
        KomplexeZahl summe = z.getSumme(z2); // z := z - z2 = 0
        System.out.println("summe = " + summe);

    }

}
