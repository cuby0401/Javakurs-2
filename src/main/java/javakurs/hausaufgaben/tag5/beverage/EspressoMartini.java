package javakurs.hausaufgaben.tag5.beverage;

public class EspressoMartini extends Beverage implements Alcoholic, Caffeinated{

    public EspressoMartini(String name, double pricePerLiter, double amount) {
        super(name, pricePerLiter, amount);
    }

    protected EspressoMartini(Beverage base, double amount) {
        super(base, amount);
    }

    @Override
    protected Beverage createPortion(Beverage beverage, double amount) {
        return null;
    }

    @Override
    public double getAlcoholStrength() {
        return 20;
    }

    @Override
    public double getCaffeineStrength() {
        return 50;
    }
}
