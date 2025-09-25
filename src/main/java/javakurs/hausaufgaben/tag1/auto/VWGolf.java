package javakurs.hausaufgaben.tag1.auto;

public class VWGolf extends VerbrennerAuto
{
    private String abgasnorm;

    public VWGolf(double tankVolumen)
    {
        super(tankVolumen);
    }

    public String getAbgasnorm()
    {
        return abgasnorm;
    }

    public void setAbgasnorm(String abgasnorm)
    {
        this.abgasnorm = abgasnorm;
    }

    @Override
    public void fahre()
    {

    }
}