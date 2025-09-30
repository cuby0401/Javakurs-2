package javakurs.seb.tag2.aufgabe2.gefaess;

import javakurs.seb.tag2.aufgabe2.getraenk.Gefaess;

abstract class Heißgetraenk extends Getraenk {
    protected Heißgetraenk(double temperatur, double menge, boolean zucker, Gefaess gefaess) {
        super(temperatur, menge, zucker, gefaess);
    }

    public Heißgetraenk() {
        super();
    }

    public boolean erwärmen(double temperatur) {
        return true;
    }
}
