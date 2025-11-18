package javakurs.hausaufgaben.tag5.supplier;

import javakurs.hausaufgaben.tag5.beverage.Beverage;

import java.util.Set;


/**
 * Allgemeine Definition für einen Getränkezulieferer.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@FunctionalInterface
public interface BeverageSupplier
{
   Set<Beverage> supplyBeverages();
}
