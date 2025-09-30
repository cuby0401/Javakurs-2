package javakurs.seb.tag2.aufgabe2.getraenk;

import javakurs.seb.tag1.aufgabe2.gefaess.Getraenk;
import javakurs.seb.tag1.aufgabe2.getraenk.Gefaess;

public class Bier extends Getraenk {
    double alkoholischesGetraenk;

    public double getAlkoholischesGetraenk() {
        return alkoholischesGetraenk;
    }

    public void setAlkoholischesGetraenk(double alkoholischesGetraenk) {
        this.alkoholischesGetraenk = alkoholischesGetraenk;
    }

    protected Bier(double temperatur, double menge, boolean zucker, Gefaess gefaess) {
        super(temperatur, menge, zucker, gefaess);
    }
}
