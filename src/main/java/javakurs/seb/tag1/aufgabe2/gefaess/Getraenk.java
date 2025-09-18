package javakurs.seb.tag1.aufgabe2.gefaess;

import javakurs.seb.tag1.aufgabe2.getraenk.Gefaess;

public abstract class Getraenk {
    protected double temperatur;
    protected double menge;
    protected boolean zucker;
    private Gefaess gefaess;

    protected Getraenk(double temperatur, double menge, boolean zucker, Gefaess gefaess) {
        this.temperatur = temperatur;
        this.menge = menge;
        this.zucker = zucker;
        this.gefaess = gefaess;
    }
}