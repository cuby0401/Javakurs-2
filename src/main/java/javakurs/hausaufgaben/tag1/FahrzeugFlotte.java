package javakurs.hausaufgaben.tag1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FahrzeugFlotte
{
    private String flottenName;

    private final List<Fahrzeug> fahrzeuge = new LinkedList<>();

    public FahrzeugFlotte()
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

    public void setFlottenName(String flottenName)
    {
        this.flottenName = flottenName;
    }

    public String getFlottenName()
    {
        return flottenName;
    }

    public List<Fahrzeug> getFahrzeuge()
    {
        return Collections.unmodifiableList(fahrzeuge);
    }
}