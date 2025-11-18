package javakurs.hausaufgaben.tag5.beverage;

public class Water extends Beverage {

    public Water(String name, double pricePerLiter, double amount) {
        super(name, pricePerLiter, amount);
    }

    protected Water(Beverage base, double amount) {
        super(base, amount);
    }

    @Override
    protected Beverage createPortion(Beverage beverage, double amount) {
        return null;
    }
}
