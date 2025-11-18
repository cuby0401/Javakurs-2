package javakurs.hausaufgaben.tag5.automat;

import javakurs.hausaufgaben.tag5.beverage.*;
import javakurs.hausaufgaben.tag5.container.Bottle;
import javakurs.hausaufgaben.tag5.supplier.BeverageSupplier;
import javakurs.hausaufgaben.tag5.automat.VendingMachineSalesFunctionality;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * <h3>Repräsentation eines Getränkeautomats</h3>
 * Dieser soll wie folgt funktionieren:
 * <p>
 * Über den {@link BeverageSupplier} (Getränkezulieferer) kann der Automat mit ein Sortiment von Getränken bestückt werden. Hierbei wird eine
 * Menge des Getränks {@link Beverage#getAmount()} in den Automaten abgefüllt. Dieser lagert das Getränk in einem Behälter analog zu:<br>
 * <br><img src="vendingmachine.png" width="242" height="271"></img>
 * </p>
 * <p>
 * Die Getränke werden über {@link #beverages} verwaltet. Die "Behälter" des Getränkeautomats werden nur befüllt, wenn die {@link #restock()}
 * Methode aufgerufen wird.
 * </p>
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
public class VendingMachine implements VendingMachineDisplayFunctionality, VendingMachineFilterOneFunctionality, VendingMachineSalesFunctionality, BeverageSupplier,VendingMachineFilterTwoFunctionality, VendingMachineStatisticsFunctionality
{
    /**
    * Getränke, mit denen der Automat befüllt wurde.
    */
   private Set<Beverage> beverages = new HashSet<>();
   /**
    * Getränkezulieferer
    */
   private BeverageSupplier beverageSupplier;

   public void setBeverageSupplier(BeverageSupplier beverageSupplier)
   {
      this.beverageSupplier = beverageSupplier;
   }

   public void restock()
   {
      beverages = beverageSupplier.supplyBeverages();
   }

   public Set<Beverage> getBeverages()
   {
      return beverages;
   }

    @Override
    public List<String> displayNamesOfAllBeverages() {
        return beverages.stream()
                .map(Beverage::getName)
                .toList();
    }

    @Override
    public Set<String> displayNamesOfAllAlcoholicBeverages() {
        return beverages.stream()
                .filter(b -> b instanceof Alcoholic)
                .map(Beverage::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public List<String> displayNamesOfAllNonAlcoholicBeverages() {
        return beverages.stream()
                .filter(b -> !(b instanceof Alcoholic))
                .map(Beverage::getName)
                .toList();
    }

    @Override
    public String displayAllBeverageNamesSeparatedByComma() {
        return beverages.stream()
                .map(this::mapToName)
                .collect(Collectors.joining(", "));
    }

    private String mapToName(Beverage beverage) {
       if (beverage instanceof Alcoholic) {
           return beverage.getName() + "(alkoholisch)";
       }
       return beverage.getName();
    }

    @Override
    public boolean isBeverageListed(String name) {
        return beverages.stream()
                .map(Beverage::getName)
                .anyMatch(name::equals);
    }

    @Override
    public Optional<Beverage> findBeverage(String name) {
        return (beverages.stream()
                .filter(b -> b.getName().startsWith(name))
                .findFirst());
    }

    @Override
    public Set<Beverage> getAllAlcoholicBeverages() {
        return beverages.stream()
                .filter(b -> b instanceof Alcoholic)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Beverage> getAllCaffeinatedBeverages() {
        return beverages.stream()
                .filter(b -> b instanceof Caffeinated)
                .collect(Collectors.toSet());
    }

    @Override
    public List<Beverage> getOnlyColdBeverages() {
        return beverages.stream()
                .filter(b -> b.getTemperature() < 10)
                .toList();
    }

    @Override
    public List<Beverage> getOnlyHotBeverages() {
        return beverages.stream()
                .filter(b -> b.getTemperature() > 50)
                .toList();
    }

    @Override
    public double calculatePriceForOneBottleOf(String name) {
        Beverage base = findBeverage(name)
                .orElseThrow(() -> new VendingMachineException("Getränk nicht gefunden: " + name));
        return Bottle.PRICE_FOR_BOTTLE + Bottle.MAX_AMOUNT_IN_LITER * base.getPricePerLiter();
    }

    @Override
    public VendingMachinePurchase buyBeverage(final String name, final double money) {
        {
//            // Getränk suchen
//            Beverage beverage = beverages.stream()
//                    .filter(b -> b.getName().equalsIgnoreCase(name))
//                    .findFirst()
//                    .orElseThrow(() -> new IllegalArgumentException("Getränk nicht gefunden: " + name));
//
//            // Preis für die Flasche berechnen
//            double price = calculatePriceForBottlesOf(beverage, 1);
//
//            if (money < price)
//            {
//                throw new IllegalArgumentException("Nicht genug Geld eingeworfen! Preis: " + price);
//            }
//
//            double change = money - price;
//
//            // Bottle erzeugen
//            Bottle<Beverage> bottle = new Bottle<>(beverage);
//
//            // Ergebnis zurückgeben
//            return new VendingMachinePurchase(bottle, change);
            return null;
        }
    }

    @Override
    public double calculatePriceForBottlesOf(final String name, final int numberOfBottles) {
        if (numberOfBottles < 0) {
            throw new VendingMachineException("numberOfBottles must be >= 0");
        }
        double singlePrice = calculatePriceForOneBottleOf(name);
        return singlePrice * numberOfBottles;
    }

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

    @Override
    public Map<Class<? extends Beverage>, List<Beverage>> getBeveragesGroupedByClass() {
        return beverages.stream()
                .collect(Collectors.groupingBy(Beverage::getClass));
    }

    @Override
    public List<Beverage> getAllBeveragesWithAmountBelowThreshold(int threshold) {
        return List.of();
    }

    @Override
    public Map<String, Beverage> getAllBeveragesMappedByName() {
        return beverages.stream()
                .collect(Collectors.toMap(Beverage::getName, b -> b));
    }

    @Override
    public List<Beverage> getListByFilter(Predicate<Beverage> filter) {
        return beverages.stream()
                .filter(filter)
                .toList();
    }

    @Override
    public List<Double> getListOfCurrentAmountsOfBeverages() {
        return beverages.stream()
                .map(Beverage::getAmount)
                .distinct()
                .toList();
    }

    @Override
    public List<Beverage> findAllAffordableBeverages(final double budget) {
        return beverages.stream()
                .filter(b -> calculatePriceForOneBottleOf(b.getName()) <= budget)
                .sorted((b1, b2) ->
                        Double.compare(calculatePriceForOneBottleOf(b1.getName()),
                                calculatePriceForOneBottleOf(b2.getName())))
                .toList();
   }

    @Override
    public List<Beverage> getTopFiveBeveragesWithTheLeastAmountOrderedByAmountDescending() {
        return List.of();
    }

    @Override
    public double calculateTotalValueOfAllBeverages() {
        return 0;
    }

    @Override
    public double calculateTotalValueOfAllAlcoholicBeverages() {
        return 0;
    }

    @Override
    public double calculateAverageTemperatureOfAllBeverages() {
        return 0;
    }

    @Override
    public double calculateAverageAlcoholicStrengthOfAllAlcoholicBeverages() {
        return 0;
    }

    @Override
    public double getMultipliedAmountsOfBeverages() {
        return 0;
    }

    // was macht flat map on Stream & Optional
    //wichtig ist für Stream
    //die Tests dürfen mit JUnit geschrieben werden
}