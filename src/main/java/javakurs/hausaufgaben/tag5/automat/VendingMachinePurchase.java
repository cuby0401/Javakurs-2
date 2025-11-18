package javakurs.hausaufgaben.tag5.automat;


import javakurs.hausaufgaben.tag5.beverage.Beverage;
import javakurs.hausaufgaben.tag5.container.Bottle;

/**
 * Wrapper für den Kauf einer Flasche bei einem Getränkeautomaten.
 *
 * @param bottle Flasche, die gekauft wurde
 * @param change Restgeld
 * @author Christoph Gragert (cgr@shd.de)
 */
public record VendingMachinePurchase(Bottle<Beverage> bottle, double change)
{
}
