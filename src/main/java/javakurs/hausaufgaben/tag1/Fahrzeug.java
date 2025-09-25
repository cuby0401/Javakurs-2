package javakurs.hausaufgaben.tag1;

public abstract class Fahrzeug
{
    private Fahrer fahrer;
    private static int baujahr;
    private static String marke;
    public abstract void fahre();

    protected Fahrzeug()
    {

    }

    protected Fahrzeug(FahrzeugFlotte fahrzeugFlotte)
    {
        if (fahrzeugFlotte == null) {
            throw new IllegalArgumentException();
        }
    }

    protected Fahrzeug(Fahrer fahrer)
    {
        this.fahrer = fahrer;
        if (fahrer == null)
        {
            throw new IllegalArgumentException();
        }
    }

    public void setFahrer(Fahrer fahrer)
    {
        this.fahrer = fahrer;
    }

    public static int getBaujahr()
    {
        return baujahr;
    }

    public static void setBaujahr(int baujahr)
    {
        Fahrzeug.baujahr = baujahr;
    }

    public static String getMarke()
    {
        return marke;
    }

    public static void setMarke(String marke)
    {
        Fahrzeug.marke = marke;
    }

    public Fahrer getFahrer()
    {
        return fahrer;
    }
}