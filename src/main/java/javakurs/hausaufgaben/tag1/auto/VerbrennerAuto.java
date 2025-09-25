package javakurs.hausaufgaben.tag1.auto;

public abstract class VerbrennerAuto extends Auto
{
    private double tankVolumen;

    public VerbrennerAuto(double tankVolumen)
    {
        this.tankVolumen = tankVolumen;
    }

    public double getTankVolumen()
    {
        return tankVolumen;
    }

    public void setTankVolumen(double tankVolumen)
    {
        this.tankVolumen = tankVolumen;
    }
}
