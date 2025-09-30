package javakurs.seb.tag2.aufgabe2.gefaess;

import javakurs.seb.tag2.aufgabe2.getraenk.Gefaess;

public class Milchkaffee extends Kaffee {
    private double milchmenge;
    private boolean fettarm;

    public Milchkaffee(double temperatur, double menge, boolean zucker, Gefaess gefaess, String herkunft, double milchmenge, boolean fettarm) {
        super(temperatur, menge, zucker, gefaess, herkunft);
        this.milchmenge = milchmenge;
        this.fettarm = fettarm;
    }
}
