package javakurs.seb.tag2.aufgabe1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spinne extends Tier implements Wildtier, Haustier {
    public void einspinnen() {

    }

    @Override
    public void haustierSachenMachen() {
        Haustier.super.haustierSachenMachen();
    }

    @Override
    public void wildtierSachenMachen() {
        Wildtier.super.wildtierSachenMachen();
    }
}