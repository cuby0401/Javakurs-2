package javakurs.jimmy.tag2.aufgabe2;

public class Gluehwein extends Heissgetraenk implements AlkoholischesGetraenk {
    private double alkoholgehalt;

    @Override
    public double getAlkoholgehalt() {
        return alkoholgehalt;
    }
}
