package javakurs.jimmy.tag2.aufgabe1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public abstract class Tier {
    @Getter
    @Setter
    protected String rasse;
    protected int beine;
    protected boolean raubtier;

    public void essen() {
    }

}
