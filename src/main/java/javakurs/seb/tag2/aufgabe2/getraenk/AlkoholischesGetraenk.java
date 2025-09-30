package javakurs.seb.tag2.aufgabe2.getraenk;

public interface AlkoholischesGetraenk {
    default double getAlkoholgehalt() {
        return 1;
    }
}
