package javakurs.seb.tag5.supplier;

import java.util.Set;

import javakurs.seb.tag5.beverage.Beverage;


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
