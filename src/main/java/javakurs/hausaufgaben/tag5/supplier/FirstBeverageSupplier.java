package javakurs.hausaufgaben.tag5.supplier;

import javakurs.hausaufgaben.tag5.beverage.*;

import java.util.Set;

/**
 * Vorgefertige Lieferartikel.
 */
public class FirstBeverageSupplier implements BeverageSupplier{
    @Override
    public Set<Beverage> supplyBeverages() {
        return Set.of(
                new Beer("Beer Classic", 3.50, 4.0),
                new Beer("Beer Dark", 4.20, 5.0),

                new Cola("Cola Original", 2.80, 6.0),
                new Cola("Cola Cherry", 3.00, 6.0),

                new EspressoMartini("Espresso Martini Standard", 10.00, 5.0),
                new EspressoMartini("Espresso Martini Vanilla", 11.00, 5.0),

                new Coffee("Coffee Mild", 2.50, 60.0),
                new Coffee("Coffee Dark", 2.80, 65.0),

                new Water("Water Still", 1.00, 8.0),
                new Water("Water Sparkling", 1.20, 8.0)
        );
    }
}
