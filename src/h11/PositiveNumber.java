package h11;

/**
 * Diese Klasse kann Zahlen aus dem Binaer-, Dezimal- und Hexadezimalsystem erhalten
 * und diese in eins der anderen umrechnen und zurueckgeben.
 */
public class PositiveNumber {
    private final String hexDigits = "0123456789ABCDEF";
    private int value; // es wird immer die Dezimalzahl gespeichert

    /**
     * Konstruktor der ein neues PositiveNumber Objekt erzeugt.
     */
    public PositiveNumber() {
        this.value = 0;
    }

    // Testen
    public static void main(String[] args) {
        PositiveNumber zs = new PositiveNumber();
        zs.setDecimal("144");
        System.out.println("Binaer: " + zs.getBinary());
        zs.setHexadecimal("affe");
        System.out.println("Dezimal: " + zs.getDecimal());
        zs.setBinary("1000101011");
        System.out.println("Hexadezimal: " + zs.getHexadecimal());
    }

    /**
     * Gibt die Zahl als Dezimalzahl zurueck.
     *
     * @return Dezimalzahl als String
     */
    public String getDecimal() {
        return "" + value;
    }

    /**
     * Setzt die Zahl aus der Dezimalzahl.
     *
     * @param s Dezimalzahl als String
     */
    public void setDecimal(String s) {
        this.value = 0;
        proof(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = hexDigits.indexOf(c);
            value = value * 10 + d;
        }
    }

    /**
     * Gibt die Zahl als Hexadezimalzahl zurueck.
     *
     * @return Hexadezimalzahl als String
     */
    public String getHexadecimal() {
        String binary = decimalToBinary(value);
        StringBuilder res = new StringBuilder();
        for (int i = binary.length() - 4; i >= 0; i -= 4) {
            res.insert(0, hexDigits.charAt(binaryToDecimal(binary.substring(i, i + 4))));
        }
        return res.toString();
    }

    /**
     * Setzt die Zahl aus der Hexadezimalzahl.
     *
     * @param s Hexadezimalzahl als String
     */
    public void setHexadecimal(String s) {
        this.value = 0;
        s = s.toUpperCase();
        proof(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = hexDigits.indexOf(c);
            value = value * 16 + d;
        }
    }

    /**
     * Gibt die Zahl als Binaerzahl zurueck.
     *
     * @return Binaerzahl als String
     */
    public String getBinary() {
        return this.decimalToBinary(value);
    }

    /**
     * Setzt die Zahl aus der Binaerzahl.
     *
     * @param s Binaerzahl als String
     */
    public void setBinary(String s) {
        this.value = 0;
        proof(s);
        value = this.binaryToDecimal(s);
    }

    /**
     * Hilfsmethode die von dezimal in binaer umrechnet.
     *
     * @param x Dezimalzahl als int
     * @return Binaerzahl als String
     */
    private String decimalToBinary(int x) {
        StringBuilder res = new StringBuilder();
        while (x > 0) {
            res.insert(0, x % 2 == 0 ? "0" : "1");
            x /= 2;
        }
        while (res.length() % 4 != 0) {
            res.insert(0, 0);
        }
        return res.toString();
    }

    /**
     * Hilfsmethode die von binear in dezimal umrechnet.
     *
     * @param s Binaerzahl als String
     * @return Dezimalzahl als int
     */
    private int binaryToDecimal(String s) {
        int res = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            res += (s.charAt(i) - 48) * (int) Math.pow(2, s.length() - 1 - i);
        }
        return res;
    }

    /**
     * Hilfsmethode die prueft ob eine Zahl die eingegeben wurde negativ ist.
     *
     * @param s Zahl als String
     */
    private void proof(String s) {
        if (s.charAt(0) == '-') {
            throw new NumberFormatException("Nur positive Zahlen");
        }
    }
}
