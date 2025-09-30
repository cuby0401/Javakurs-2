package javakurs.seb.tag2.aufgabe2.getraenk;

import javakurs.seb.tag2.aufgabe2.gefaess.Getraenk;

public class Gefaess {
    private Getraenk getraenk;

    protected Gefaess(Getraenk getraenk) {
        if (getraenk == null) {
            throw new IllegalArgumentException();
        }
        this.getraenk = getraenk;
    }
}