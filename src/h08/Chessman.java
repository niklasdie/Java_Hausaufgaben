package h08;

import java.util.ArrayList;

public abstract class Chessman {

    Position pos;

    /**
     * Konstruktor erzeugt ein neues Chessman Objekt.
     *
     * @param pos Ausgangsposition der Schachfigur.
     */
    public Chessman(Position pos) {
        this.pos = pos;
    }

    /**
     * Abstrakte Methode welche in der erbenden Klasse inizialisiert wird.
     * Soll die moeglichen Zuege einer bestimmten Figur ermitteln und sie in einer ArrayList zurueckgeben.
     *
     * @return eine Arraylist mit den moeglichen Schritten
     */
    public abstract ArrayList<Position> getMoveList();

    /**
     * Gibt die momentane Position der Schachfigur zurueck.
     *
     * @return die momentane Position
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Bewegt die Figur zur angegebenen Position.
     *
     * @param pos Position, zu der sich die Figur begen soll.
     */
    public void moveTo(Position pos) {
        if (this.canMoveTo(pos)) {
            this.pos = pos;
        } else {
            throw new IndexOutOfBoundsException("Move nicht moeglich!");
        }
    }

    /**
     * Ermittelt ob sich die gegebene Figur auf das angegebene Feld bewegen kann und gibt das Ergebnis zurueck.
     *
     * @param pos die zu ueberpruefene Position
     * @return Wahrheitswert ob der Zug moeglich ist oder nicht.
     */
    public boolean canMoveTo(Position pos) {
        return this.getMoveList().contains(pos);
    }
}
