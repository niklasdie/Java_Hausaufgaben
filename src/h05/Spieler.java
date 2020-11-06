package h05;

public class Spieler {

    private String name;
    private int punkte = 0;

    public Spieler(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addPunkte(int p){
        this.punkte += p;
    }

    public int getPunkte(){
        return this.punkte;
    }
}
