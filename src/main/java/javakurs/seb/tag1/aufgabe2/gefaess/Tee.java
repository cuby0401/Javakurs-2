package javakurs.seb.tag1.aufgabe2.gefaess;

import javakurs.seb.tag1.aufgabe2.getraenk.Gefaess;

public class Tee extends Heißgetraenk {
    private String sorte;
    private int ziehzeit;

    public Tee(double temperatur, double menge, boolean zucker, Gefaess gefaess, String sorte, int ziehzeit) {
        super(temperatur, menge, zucker, gefaess);
        this.sorte = sorte;
        this.ziehzeit = ziehzeit;
    }
}
