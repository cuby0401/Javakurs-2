package javakurs.hausaufgaben.tag1.auto;

public abstract class Elektroauto extends Auto
{
    private double akkuKapazitaet;

    public Elektroauto(double akkuKapazitaet)
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