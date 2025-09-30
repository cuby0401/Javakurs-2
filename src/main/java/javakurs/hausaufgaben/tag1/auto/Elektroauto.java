package javakurs.hausaufgaben.tag1.auto;

public abstract class Elektroauto extends Auto
{
    protected double akkuKapazitaet;

    protected Elektroauto(double akkuKapazitaet)
    {
        this.akkuKapazitaet = akkuKapazitaet;
    }

    public double getAkkuKapazitaet()
    {
        return akkuKapazitaet;
    }

    public void setAkkuKapazitaet(double akkuKapazitaet)
    {
        this.akkuKapazitaet = akkuKapazitaet;
    }
}