package h02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Goldpreis {

    private ArrayList<Goldtagespreis> list;

    /**
     * erzeugt ein neues Objekt der Klasse Goldpreis und ruft Methode generateArrayList auf
     *
     * @param dateiname aus dieser Datei werden die Informationen entnommen
     */
    public Goldpreis(String dateiname) {
        this.generateArrayList(dateiname);
    }

    /**
     * genertiert eine ArrayList mit Elementen der Klasse Goldtagespreis und wird nur vom Konstruktor genutzt
     *
     * @param dateiname aus dieser Datei werden die Informationen entnommen
     */
    private void generateArrayList(String dateiname) {
        Scanner sc;
        File gold;
        list = new ArrayList<>();
        try {
            gold = new File(dateiname);
            sc = new Scanner(gold);
            while (sc.hasNextLine()) {
                String res = sc.nextLine();
                String[] temp = res.split("\t");
                double preis;
                try {
                    preis = (Double.parseDouble(temp[1].substring(0, 6)) * 1000);
                } catch (NumberFormatException e) {
                    preis = -1;
                }
                Goldtagespreis goldtagespreis = new Goldtagespreis(temp[0], preis);
                list.add(goldtagespreis);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * gibt den Goldpreis eines bestimmten Datums zurueck
     *
     * @param datum Datum in Form von jjjj-mm-tt
     * @return den Goldpreis des angegebenen Datums
     */
    public double getPreis(String datum) {
        try { // testen auf Korrektheit des Datums, sonst NumberFormatExeption
            int test = Integer.parseInt(datum.substring(0, 4));
            test = Integer.parseInt(datum.substring(5, 7));
            test = Integer.parseInt(datum.substring(8, 10));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Datum hat falsches Format!");
        }
        for (int i = 0; i < list.size(); i++) {
            if (datum.substring(8, 10).equals(list.get(i).datum.substring(8, 10))) {
                if (datum.substring(5, 7).equals(list.get(i).datum.substring(5, 7))) {
                    if (datum.substring(0, 4).equals(list.get(i).datum.substring(0, 4))) {
                        return list.get(i).preis;
                    }
                }
            }
        }
        throw new NumberFormatException("Datum nicht vorhanden");
    }

    /**
     * gibt den minimalen und den maximalen Goldpreis mit Datum in die Konsole aus
     */
    public void printMinMax() {
        double min = list.get(0).preis;
        double max = min;
        int indexMin = 0;
        int indexMax = 0;
        for (Goldtagespreis elem : list) {
            if (elem.preis < min && elem.preis > 0) {
                min = elem.preis;
                indexMin = list.indexOf(elem);
            }
            if (elem.preis > max && elem.preis > 0) {
                max = elem.preis;
                indexMax = list.indexOf(elem);
            }
        }
        System.out.println("Den niedrigsten Goldpreis von " + min + " gab es an folgenden Tagen:\n" + list.get(indexMin).datum);
        System.out.println("Den hoechsten Goldpreis von " + max + " gab es an folgenden Tagen:\n" + list.get(indexMax).datum);
    }

    public static void main(String[] args) {
        try {
//            Goldpreis test = new Goldpreis("/Users/niklasdiekhoner/IdeaProjects/Java_Hausaufgaben/src/h02/gold.txt");
            Goldpreis test = new Goldpreis("C:\\Users\\ndiekhoener\\IdeaProjects\\Java_Hausaufgaben\\src\\h02\\gold.txt");
//            Goldpreis test = new Goldpreis("gold.txt");
            System.out.println(test.getPreis("2009-10-20")); // 22870.0
            System.out.println(test.getPreis("2009-02-07")); // -1
            test.printMinMax();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
