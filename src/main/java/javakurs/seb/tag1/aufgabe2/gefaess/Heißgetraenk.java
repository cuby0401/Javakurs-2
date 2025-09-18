package javakurs.seb.tag1.aufgabe2.gefaess;

import javakurs.seb.tag1.aufgabe2.getraenk.Gefaess;

abstract class Heißgetraenk extends Getraenk {
    protected Heißgetraenk(double temperatur, double menge, boolean zucker, Gefaess gefaess) {
        super(temperatur, menge, zucker, gefaess);
    }

    public boolean erwärmen(double temperatur)
    {
        return true;
    }
}
