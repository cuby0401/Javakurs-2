package javakurs.hausaufgaben.tag1.motorrad;

import javakurs.hausaufgaben.tag1.Fahrzeug;

public abstract class Motorrad extends Fahrzeug
{
    private boolean hatBeiwagen;

    public Motorrad()
    {
        super();
    }

    public boolean isHatBeiwagen()
    {
        return hatBeiwagen;
    }

    public void setHatBeiwagen(boolean hatBeiwagen)
    {
        this.hatBeiwagen = hatBeiwagen;
    }
}
