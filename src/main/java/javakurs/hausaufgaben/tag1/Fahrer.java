package javakurs.hausaufgaben.tag1;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fahrer
{
    private final List<Fahrzeug> fahrzeuge = new LinkedList<>();
    private String name;
    private int fuehrerscheinNr;

    /**
     * Konstruktor für den abstrakten Methoden Zugriff.
     */
    protected Fahrer()
    {
        final Fahrzeug fahrzeug = new Fahrzeug(this)
        {
            @Override
            public void fahre()
            {

            }
        };
        fahrzeuge.add(fahrzeug);
    }

    protected List<Fahrzeug> getFahrzeuge()
    {
        return Collections.unmodifiableList(fahrzeuge);
    }

    public String getName()
    {
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