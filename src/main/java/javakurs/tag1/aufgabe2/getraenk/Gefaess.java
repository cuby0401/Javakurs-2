package javakurs.tag1.aufgabe2.getraenk;

import javakurs.tag1.aufgabe2.gefaess.Getraenk;

public class Gefaess {
    private Getraenk getraenk;

    protected Gefaess(Getraenk getraenk) {
        if (getraenk == null) {
            throw new IllegalArgumentException();
        }
            this.getraenk = getraenk;
    }
}