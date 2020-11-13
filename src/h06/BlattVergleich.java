package h06;

import java.util.Comparator;

public class BlattVergleich implements Comparator<Blatt> {

    /**
     * Vergleicht die Blätter miteinander und gibt zurueck welches gewonnen bzw verloren hat oder
     * ob ein Unentschieden existiert.
     *
     * @param o1 Blatt 1 welches mit dem anderen Blatt verglichen wird.
     * @param o2 Blatt 2 welches mit dem anderen Blatt verglichen wird.
     * @return das Ergebnis des Vergleiches
     */
    @Override
    public int compare(Blatt o1, Blatt o2) {
        return getBlattWert(o1) - getBlattWert(o2);
    }

    /**
     * Hilfsmethode welche einem Blatt anhand der Karten einen Wert zuweist bzw zurueck gibt, welcher
     * zum Vergleich zweier Blätter dient.
     *
     * @param b Blatt von dem der Wert ermittelt werden soll
     * @return den Wert des Blattes
     */
    private int getBlattWert(Blatt b) {
        if (b.getKarte(0) == b.getKarte(1) &&
                b.getKarte(1) == b.getKarte(2)) {
            return 1000 + b.getKarte(0) + b.getKarte(1) + b.getKarte(2);
            // Drilling
        } else {
            if (b.getKarte(0) == b.getKarte(1)) {
                return b.getKarte(0) * 8 + b.getKarte(1) * 8 + b.getKarte(2);
            } else {
                if (b.getKarte(1) == b.getKarte(2)) {
                    return b.getKarte(1) * 8 + b.getKarte(2) * 8 + b.getKarte(0);
                } else {
                    if (b.getKarte(0) == b.getKarte(2)) {
                        return b.getKarte(0) * 8 + b.getKarte(2) * 8 + b.getKarte(1);
                        // Paar
                    } else {
                        return b.getKarte(0) + b.getKarte(1) + b.getKarte(2);
                        // alle unterschiedlich
                    }
                }
            }
        }
    }
}