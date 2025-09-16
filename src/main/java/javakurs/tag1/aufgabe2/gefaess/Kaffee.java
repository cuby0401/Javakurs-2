package javakurs.tag1.aufgabe2.gefaess;

import javakurs.tag1.aufgabe2.getraenk.Gefaess;

public class Kaffee extends Heißgetraenk {
    protected String herkunft;

    public Kaffee(double temperatur, double menge, boolean zucker, Gefaess gefaess, String herkunft) {
        super(temperatur, menge, zucker, gefaess);
        this.herkunft = herkunft;
    }
}
