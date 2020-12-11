package h10;

import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zahlwort {

    /**
     * Diese Funktion gibt für alle natürlichen Zahlen (von 1 bis 9999) das deutsche Zahlwort zurueck.
     * @param x Zahl die als String zurueck gegeben werden soll
     * @return String
     */
    public static String getZahlwort(int x) {
        if (x < 1 || x > 9999) {
            throw new ArithmeticException("Zahl muss zwischen 1 und 9999 liegen!");
        } else {
            return buildZahlwort(x, length(x));
        }
    }

    /**
     * Gibt alle Zahlen zwischen dem Startwert und Endwert als Zahlwort zurueck.
     * @param start Startwert
     * @param stop Endwert
     * @return Stream aus Zahlwoertern
     */
    public static Stream<String> getZahlStream(int start, int stop) {
        return IntStream.rangeClosed(start, stop).mapToObj(Zahlwort::getZahlwort);
    }

    /**
     * Hilfsfunktion die das Zahlwort aufbaut.
     * @param x Zahl
     * @param length Anzahl der Ziffern
     * @return Zahl als Zahlwort
     */
    private static String buildZahlwort(int x, int length) {
        String res = "";
        switch (length) {
            case 1:
                if (x == 1) {
                    res += "eins";
                } else {
                    res += getZahl(x);
                }
                break;
            case 2:
                if (x % 10 == 0) {
                    if (x == 10) {
                        res += "zehn";
                    } else {
                        if (x / 10 == 7) {
                            res += "siebzig";
                        } else {
                            res += getZahl(x / 10) + "zig";
                        }

                    }
                } else {
                    if (x < 20) {
                        if (x % 10 == 7) {
                            res += "siebzehn";
                        } else {
                            if (x < 13) {
                                res += getZahl(x);
                            } else {
                                res += getZahl(x % 10) + "zehn";
                            }
                        }
                    } else {
                        if (x / 10 == 7) {
                            res += getZahl(x % 10) + "und" + "siebzig";
                        } else {
                            res += getZahl(x % 10) + "und" + getZahl(x / 10) + "zig";
                        }
                    }
                }
                break;
            case 3:
                res += getZahl(x / 100) + "hundert";
                res += buildZahlwort(x % 100, length - 1);
                break;
            case 4:
                res += getZahl(x / 1000) + "tausend";
                res += buildZahlwort(x % 1000, length - 1);
                break;
        }
        return res;
    }

    /**
     * Hilfsfunktion die die Laenge bzw die Anzahl der Ziffern einer Zahl bestimmt und zurueck gibt.
     * @param x Zahl
     * @return Laenge als int
     */
    private static int length(int x) {
        int res = 0;
        while (x != 0) {
            x /= 10;
            res++;
        }
        return res;
    }

    /**
     * Hilfsfunktion die die Informationen fuer den String liefert.
     * @param x Zahl die als String zurueck gegeben wird
     * @return Zahlwort
     */
    private static String getZahl(int x) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "ein");
        map.put(2, "zwei");
        map.put(3, "drei");
        map.put(4, "vier");
        map.put(5, "fuenf");
        map.put(6, "sechs");
        map.put(7, "sieben");
        map.put(8, "acht");
        map.put(9, "neun");
        map.put(10, "zehn");
        map.put(11, "elf");
        map.put(12, "zwoelf");
        map.put(20, "zwan");

        return map.get(x);
    }

    //testen
    public static void main(String[] args) {
        // testen, ob ein paar typische Zahlwoerter richtig herauskommen:
        System.out.println();
        System.out.println("Test 1:");
        int[] testtabelle = {1, 10, 11, 12, 16, 17, 20, 38, 69,
                70, 131, 195, 201, 202, 211, 1111, 2345};
        for (int z : testtabelle) {
            String zahlwort = Zahlwort.getZahlwort(z);
            System.out.println("zahl = " + z + " --> " + zahlwort);
        }

        // testen, ob die Stream-Methode ordentlich funktioniert:
        System.out.println();
        System.out.println("Test 2:");
        int start = 8;
        int stop = 12;
        Stream<String> ss = Zahlwort.getZahlStream(start, stop);
        ss.limit(stop - start + 1).forEach(System.out::println);

        // sollte eine Ausnahme produzieren:
        System.out.println();
        System.out.println("Test 3:");
        int zahl = 10000;
        String wort = Zahlwort.getZahlwort(zahl);
    }
}
