package javakurs.seb.tag3.aufgabe1;

public class Verkettung {
    private String name;
    private Verkettung nachfolger;

    public Verkettung(String name, Verkettung nachfolger) {
        this.name = name;
        this.nachfolger = nachfolger;
    }
}