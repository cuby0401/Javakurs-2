package javakurs.hausaufgaben.tag5.beverage;

public class Beer extends Beverage {

    public Beer(String name, double pricePerLiter, double amount) {
        super(name, pricePerLiter, amount);
    }

    protected Beer(Beverage base, double amount) {
        super(base, amount);
    }

    @Override
    protected Beverage createPortion(Beverage beverage, double amount) {
        return null;
    }
}
