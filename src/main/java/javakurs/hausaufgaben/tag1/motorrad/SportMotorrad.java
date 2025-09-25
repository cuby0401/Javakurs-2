package javakurs.hausaufgaben.tag1.motorrad;

public abstract class SportMotorrad extends Motorrad
{
    private int maxGeschwindigkeit;

    public int getMaxGeschwindigkeit()
    {
        return maxGeschwindigkeit;
    }

    public void setMaxGeschwindigkeit(int maxGeschwindigkeit)
    {
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }
}
