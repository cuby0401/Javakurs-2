package javakurs.hausaufgaben.tag1;

public abstract class Fahrzeug
{
    private Fahrer fahrer;

    protected Fahrzeug(Fahrer fahrer)
    {
        this.fahrer = fahrer;
    }

    public Fahrzeug() {}

    public Fahrer getFahrer()
    {
        return fahrer;
    }

    private static int baujahr;
    private static String marke;

    public abstract void fahre();
}
