package javakurs.seb.tag3.aufgabe2;

public class Temp<TYPE extends Number> extends Main<TYPE> {
    public Temp(TYPE name, Main<TYPE> nachfolger) {
        super(name, nachfolger);
    }
}