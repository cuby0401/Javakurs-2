package javakurs.seb.tag2.aufgabe1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Tier {
    protected String rasse;
    protected int beine;
    protected boolean raubtier;

    public void essen() {

    }
}
