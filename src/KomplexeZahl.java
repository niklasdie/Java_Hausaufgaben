import java.util.Arrays;

/**
 * @author Niklas Diekhoener
 */

public class KomplexeZahl {

    /**
     * @param x Realteil
     * @param y Imaginaerteil
     */
    private double x;
    private double y;

    /**
     * Konstruktor
     *
     * @param x Realteil
     * @param y Imaginaerteil
     */
    public KomplexeZahl(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * @return gibt den Realteil zurueck
     */
    public double getRealteil() {
        return this.x;
    }

    /**
     * @return gibt den Imaginaerteil zurueck
     */
    public double getImaginaerteil() {
        return this.y;
    }

    /**
     * addiert this mit einer weiteren komplexen Zahl
     *
     * @param z ist die zu addierende Zahl
     */
    public void addiere(KomplexeZahl z) {
        this.x += z.getRealteil();
        this.y += z.getImaginaerteil();
    }

    /**
     * multipliziert this mit einer weiteren komplexen Zahl
     *
     * @param z ist die zu multiplizierende Zahl
     */
    public void multipliziere(KomplexeZahl z) {
        double tempX = this.x; // temporaere Speicherung vom Realteil
        this.x = (this.x * z.getRealteil()) - (this.y * z.getImaginaerteil());
        this.y = (tempX * z.getImaginaerteil()) + (z.getRealteil() * this.y);
    }

    /**
     * Diese Methode berechnet den Betrag einer komplexen Zahl.
     *
     * @return gibt den Betrag zurueck
     */
    public double getBetrag() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    /**
     * Ueberschreibt die default toString Methode
     *
     * @return textuelle Repraesentation der komplexen Zahl
     */
    public String toString() {
        String res = new String();
        if (this.y == 0) {
            res += this.x;
        } else {
            if (this.x == 0) {
                if (this.y == 1) {
                    res += "i";
                } else {
                    res += this.y + " i";
                }
            } else {
                if (this.y == 1) {
                    res += this.x + " + i";
                } else {
                    if (this.y == -1) {
                        res += this.x + " - i";
                    } else {
                        if (this.y < 0) {
                            res += this.x + " - " + Math.abs(this.y) + " i";
                        } else {
                            res += this.x + " + " + this.y + " i";
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * @return gibt die Quadratwurzel einer komplexen Zahl zurueck
     */
    public KomplexeZahl[] getWurzel() {
        KomplexeZahl[] res = new KomplexeZahl[2];
        KomplexeZahl z1 = new KomplexeZahl(0, 0);
        KomplexeZahl z2 = new KomplexeZahl(0, 0);
        boolean schalter = true;
        double q = 0;
        if (this.x == 0) {
            z1 = new KomplexeZahl(0, Math.sqrt(Math.abs(this.y)));
            z2 = new KomplexeZahl(0, -Math.sqrt(Math.abs(this.y)));
            schalter = false;
        } else {
            if (this.y == 0) {
                if (this.x > 0) {
                    z1 = new KomplexeZahl(Math.sqrt(Math.abs(this.x)), 0);
                    z2 = new KomplexeZahl(-Math.sqrt(Math.abs(this.x)), 0);
                } else {
                    z1 = new KomplexeZahl(0, Math.sqrt(Math.abs(this.x)));
                    z2 = new KomplexeZahl(0, -Math.sqrt(Math.abs(this.x)));
                }
                schalter = false;
            }
        }
        if (this.x > 0 && this.y > 0) {
            q = Math.atan(this.y / this.x);
        } else {
            if ((this.x < 0 && this.y > 0) || (this.x < 0 && this.y < 0)) {
                q = Math.atan(this.y / this.x) + Math.PI;
            } else {
                if (this.x > 0 && this.y < 0) {
                    q = Math.atan(this.y / this.x) + 2 * Math.PI;
                }
            }
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
     *
     * @param z zu addierende komplexe Zahl
     * @return gibt die Summe als komplexe Zahl zurueck
     */
    public KomplexeZahl getSumme(KomplexeZahl z) {
        return new KomplexeZahl(this.x + z.getRealteil(), this.y + z.getImaginaerteil());
    }

    /**
     * Berechnet das Produkt zweiter komplexer Zahlen
     *
     * @param z ist die zu multiplizierende Zahl
     * @return gibt das Produkt als komplexe Zahl zurueck
     */
    public KomplexeZahl getProdukt(KomplexeZahl z) {
        // gibt das Produkt zweiter komplexer Zahlen als komplexe Zahl zurueck
        return new KomplexeZahl(this.x * z.getRealteil() - this.y * z.getImaginaerteil(), this.x * z.getImaginaerteil() + z.getRealteil() * this.y);
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
