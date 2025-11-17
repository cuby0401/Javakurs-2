package javakurs.seb.tag5.vorbereitung.beverage;

public class Kaffee extends Beverage {
    public Kaffee(String name, double pricePerLiter, double amount) {
        super(name, pricePerLiter, amount);
    }

    public Kaffee(Beverage base, double amount) {
        super(base, amount);
    }

    @Override
    protected Beverage createPortion(Beverage beverage, double amount) {
        return null;
    }
}
