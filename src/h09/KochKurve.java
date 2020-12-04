package h09;

public class KochKurve {

    public static void kochKurve(double ax, double ay, double bx, double by, int rek) {
        System.out.print("Rekursionstiefe " + rek + ": ");
        kochKurveRek(ax, ay, bx, by, rek);
        System.out.printf("(" + "%.1f" + "/" + "%.1f" + ")" + "\n", bx, by);
    }

    private static void kochKurveRek(double ax, double ay, double bx, double by, int rek) {
        if (rek == 0) {
            System.out.printf("(" + "%.1f" + "/" + "%.1f" + ")", ax, ay);
        } else {
            double p1x, p1y;
            double p2x, p2y;
            double p3x, p3y;

            double axmbx = Math.abs(bx - ax);
            double aymby = Math.abs(by - ay);

            p1x = ax + (axmbx / 3);
            p1y = ay + (aymby / 3);
            p2x = p1x + (axmbx / 2) - (axmbx / 3);
            p2y = p1y + (aymby / 2) - (aymby / 3);
            p3x = ax + (axmbx / 3) * 2;
            p3y = ay + (aymby / 3) * 2;

            kochKurveRek(ax, ay, p1x, p1y, rek - 1);
            kochKurveRek(p1x, p1y, p2x, p2y, rek - 1);
            kochKurveRek(p2x, p2y, p3x, p3y, rek - 1);
            kochKurveRek(p3x, p3y, bx, by, rek - 1);
        }
    }

    public static void main(String[] args) {
        // Test
        kochKurve(0, 500, 500, 500, 0);
        kochKurve(0, 500, 500, 500, 1);
        kochKurve(0, 500, 500, 500, 2);
    }
}
