package javakurs.hausaufgaben.tag1;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fahrer
{
    private final List<Fahrzeug> fahrzeuge = new LinkedList<>();

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

    private String name;
    private String fuehrerscheinNr;

}
