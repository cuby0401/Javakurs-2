package javakurs.hausaufgaben.tag1.auto;

public class Tesla extends Elektroauto
{
    private boolean autopilot;

    public Tesla(double akkuKapazitaet)
    {
        super(akkuKapazitaet);
    }

    @Override
    public void fahre()
    {

    }

    public boolean isAutopilot()
    {
        return autopilot;
    }

    public void setAutopilot(boolean autopilot)
    {
        this.autopilot = autopilot;
    }
}