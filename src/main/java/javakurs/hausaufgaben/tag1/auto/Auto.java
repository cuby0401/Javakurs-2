package javakurs.hausaufgaben.tag1.auto;

import javakurs.hausaufgaben.tag1.Fahrzeug;

public abstract class Auto extends Fahrzeug
{
    private int anzahlTueren;

    public Auto()
    {
        super();

    }

    public int getAnzahlTueren()
    {
        return anzahlTueren;
    }

    public void setAnzahlTueren(int anzahlTueren)
    {
        this.anzahlTueren = anzahlTueren;
    }
}
