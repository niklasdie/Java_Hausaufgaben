package h02;

public class Goldtagespreis {

    public String datum;
    public double preis;

    /**
     * erzeugt ein neues Objekt der Klasse Goldtagespreis
     * @param datum eines Preises
     * @param preis an einem Datum
     */
    public Goldtagespreis(String datum, double preis){
        this.datum = datum;
        this.preis = preis;
    }

    public String toString(){
        return datum + ": " + preis + " Euro";
    }
}
