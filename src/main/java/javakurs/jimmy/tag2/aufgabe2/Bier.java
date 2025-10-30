package javakurs.jimmy.tag2.aufgabe2;

public class Bier extends Getraenk implements AlkoholischesGetraenk
{
    private double alkoholgehalt;

    @Override
    public double getAlkoholgehalt()
    {
        return alkoholgehalt;
    }
}
