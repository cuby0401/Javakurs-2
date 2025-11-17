package javakurs.seb.tag5.vorbereitung.automat;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javakurs.seb.tag5.vorbereitung.beverage.Alcoholic;
import javakurs.seb.tag5.vorbereitung.beverage.Beverage;
import javakurs.seb.tag5.vorbereitung.supplier.BeverageSupplier;


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
public class VendingMachine implements VendingMachineDisplayFunctionality, VendingMachineFilterOneFunctionality
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
        return false;
    }

    @Override
    public Optional<Beverage> findBeverage(String name) {
        return Optional.empty();
    }

    @Override
    public Set<Beverage> getAllAlcoholicBeverages() {
        return Set.of();
    }

    @Override
    public Set<Beverage> getAllCaffeinatedBeverages() {
        return Set.of();
    }

    @Override
    public List<Beverage> getOnlyColdBeverages() {
        return List.of();
    }

    @Override
    public List<Beverage> getOnlyHotBeverages() {
        return List.of();
    }

    // was macht Flat map on Stream & Optional
    //Wichtig ist für Stream
    //die Tests dürfen mit JUnit geschrieben werden
}