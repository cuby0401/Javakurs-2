package javakurs.hausaufgaben.tag5.automat;

import javakurs.hausaufgaben.tag5.beverage.*;
import javakurs.hausaufgaben.tag5.container.Bottle;
import javakurs.hausaufgaben.tag5.supplier.BeverageSupplier;

import java.util.*;
import java.util.function.Predicate;
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
public class VendingMachine implements VendingMachineDisplayFunctionality, VendingMachineFilterOneFunctionality, VendingMachineSalesFunctionality,VendingMachineFilterTwoFunctionality, VendingMachineStatisticsFunctionality
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
                .orElseThrow(VendingMachineException::new);
        return Bottle.PRICE_FOR_BOTTLE + Bottle.MAX_AMOUNT_IN_LITER * base.getPricePerLiter();
    }

    @Override
    public VendingMachinePurchase buyBeverage(String name, double money)
    {
        Optional<Beverage> beverageOptional = findBeverage(name);

        if(beverageOptional.isPresent())
        {
            Beverage beverage = beverageOptional.get();

            double preisBeverage = calculatePriceForOneBottleOf(name);

            if(preisBeverage > money)
            {
                System.out.println("Zu wenig Geld.");
                throw new VendingMachineException();
            }

            if(beverage.getAmount() <= 0)
            {
                System.out.println("Dieses Getränk ist leer");
                throw new InsufficientBeverageException();
            }

            double restGeld = money - preisBeverage;

            beverage.setAmount(beverage.getAmount() - 0.5);

            return new VendingMachinePurchase(new Bottle<>(beverage),restGeld);
        }

        else
        {
            System.out.println("Das gesuchte Getränk konnte nicht gefunden werden!");
            throw new VendingMachineException();
        }
    }

    @Override
    public double calculatePriceForBottlesOf(final String name, final int numberOfBottles) {
        if (numberOfBottles < 0) {
            throw new VendingMachineException();
        }
        double singlePrice = calculatePriceForOneBottleOf(name);
        return singlePrice * numberOfBottles;
    }

    @Override
    public Map<Class<? extends Beverage>, List<Beverage>> getBeveragesGroupedByClass() {
        return beverages.stream()
                .collect(Collectors.groupingBy(Beverage::getClass));
    }

    @Override
    public List<Beverage> getAllBeveragesWithAmountBelowThreshold(int threshold) {
        return beverages.stream()
                .filter(b -> b.getAmount() < threshold)
                .toList();
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
        return beverages.stream()
                .sorted(Comparator.comparingDouble(Beverage::getAmount))
                .limit(5)
                .sorted(Comparator.comparingDouble(Beverage::getAmount).reversed())
                .toList();
    }

    @Override
    public double calculateTotalValueOfAllBeverages() {
        return beverages.stream()
                .mapToDouble(b -> b.getPricePerLiter() * b.getAmount())
                .sum();
    }

    @Override
    public double calculateTotalValueOfAllAlcoholicBeverages() {
        return beverages
                .stream()
                .filter(beverage -> beverage instanceof Alcoholic)
                .mapToDouble(beverage -> beverage.getAmount() * beverage.getPricePerLiter())
                .sum();
    }

    @Override
    public double calculateAverageTemperatureOfAllBeverages() {
        return beverages.stream()
                .mapToDouble(Beverage::getTemperature)
                .average()
                .orElse(0.0);
    }

    @Override
    public double calculateAverageAlcoholicStrengthOfAllAlcoholicBeverages() {
        return beverages.stream()
                .filter(b -> b instanceof Alcoholic)
                .map(b -> (Alcoholic) b)
                .mapToDouble(Alcoholic::getAlcoholStrength)
                .average()
                .orElse(0.0);
    }

    @Override
    public double getMultipliedAmountsOfBeverages() {
        return beverages.stream()
                .map(Beverage::getAmount)
                .reduce(1.0, (a, b) -> a * b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VendingMachine: ").append(beverages.size()).append(" Getränke\n");

        // Sortiert nach Name
        beverages.stream()
                .sorted(Comparator.comparing(Beverage::getName))
                .forEach(b -> {
                    sb.append(" - ").append(b.getName())
                            .append(" | Menge: ").append(String.format("%.2f L", b.getAmount()))
                            .append(" | Preis/L: €").append(String.format("%.2f", b.getPricePerLiter()));

                    if (b instanceof Alcoholic) {
                        sb.append(" | Alkohol: ").append(String.format("%.1f%%", ((Alcoholic)b).getAlcoholStrength()));
                    }
                    sb.append(" | Temp: ").append(String.format("%.1f°C", (double)b.getTemperature()));
                    sb.append("\n");
                });

        double totalValue = calculateTotalValueOfAllBeverages();
        sb.append("Gesamtwert aller Getränke: €").append(String.format("%.2f", totalValue));

        return sb.toString();
    }
}