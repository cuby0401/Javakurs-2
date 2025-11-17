package javakurs.seb.tag5.vorbereitung.automat;


import javakurs.seb.tag5.vorbereitung.beverage.Beverage;
import javakurs.seb.tag5.vorbereitung.container.Bottle;

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
