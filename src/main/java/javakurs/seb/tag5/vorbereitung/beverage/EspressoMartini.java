package javakurs.seb.tag5.vorbereitung.beverage;

public class EspressoMartini extends Beverage {

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
}
