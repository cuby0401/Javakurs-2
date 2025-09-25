package javakurs.hausaufgaben.tag1.auto;

import javakurs.hausaufgaben.tag1.Fahrzeug;

public abstract class Auto extends Fahrzeug
{
    protected int anzahlTueren;

    /**
     * Konstruktor mit super aufruf.
     */
    protected Auto()
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
