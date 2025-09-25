package javakurs.hausaufgaben.tag1;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fahrer
{
    private final List<Fahrzeug> fahrzeuge = new LinkedList<>();
    private String name;
    private int fuehrerscheinNr;

    public Fahrer()
    {
        final Fahrzeug erstesFahrzeug = new Fahrzeug(this)
        {
            @Override
            public void fahre()
            {

            }
        };
        fahrzeuge.add(erstesFahrzeug);
    }

    public List<Fahrzeug> getFahrzeuge()
    {
        return Collections.unmodifiableList(fahrzeuge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getFuehrerscheinNr()
    {
        return fuehrerscheinNr;
    }

    public void setFuehrerscheinNr(int fuehrerscheinNr)
    {
        this.fuehrerscheinNr = fuehrerscheinNr;
    }
}