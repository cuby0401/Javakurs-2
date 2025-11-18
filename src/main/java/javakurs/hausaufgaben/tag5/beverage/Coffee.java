package javakurs.hausaufgaben.tag5.beverage;

public class Coffee extends Beverage implements Caffeinated {
    public Coffee(String name, double pricePerLiter, double amount) {
        super(name, pricePerLiter, amount);
    }

    public Coffee(Beverage base, double amount) {
        super(base, amount);
    }

    @Override
    protected Beverage createPortion(Beverage beverage, double amount) {
        return null;
    }

    @Override
    public double getCaffeineStrength() {
        return 60;
    }
}
