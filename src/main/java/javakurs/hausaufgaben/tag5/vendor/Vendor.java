package javakurs.hausaufgaben.tag5.vendor;

import javakurs.hausaufgaben.tag5.automat.VendingMachine;
import javakurs.hausaufgaben.tag5.beverage.Alcoholic;
import javakurs.hausaufgaben.tag5.beverage.Beverage;
import javakurs.hausaufgaben.tag5.container.Bottle;
import javakurs.hausaufgaben.tag5.supplier.VendingMachineSupplier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * <h3>Repräsentation für einen Verkäufer/Sammlung von Getränkeautomaten</h3>
 * <p>
 * Analog zu {@link VendingMachine#beverageSupplier} gibt für den Verkäufer auch einen {@link #vendingMachineSupplier}, der ihn mit
 * einer Auswahl an unterschiedlichen Getränkeautomaten beliefert. Die Automaten werden in {@link #vendingMachines} verwaltet. Das Sortiment an
 * Getränkeautomaten wird nur gefüllt, wenn {@link #restock()} aufgerufen wird.
 * </p>
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@SuppressWarnings("JavadocReference")
public class Vendor implements VendorFunctionality
{
   private List<VendingMachine> vendingMachines = new ArrayList<>();
   private VendingMachineSupplier vendingMachineSupplier;

   public void supplyVendingMachines(final VendingMachineSupplier vendingMachineSupplier)
   {
      this.vendingMachineSupplier = vendingMachineSupplier;
   }

   public void restock()
   {
      vendingMachines = vendingMachineSupplier.supplyVendingMachines();
      vendingMachines.forEach(VendingMachine::restock);
   }

    @Override
    public Set<Beverage> getBeveragesOfAllVendingMachines() {
        return vendingMachines.stream()
                .flatMap(vm -> vm.getBeverages().stream())
                .collect(Collectors.toSet());
    }

    @Override
    public long countNumberOfBeveragesOfAllVendingMachines() {
        return vendingMachines.stream()
                .mapToLong(vm -> vm.getBeverages().size())
                .sum();
    }

    @Override
    public long countNumberOfBeveragesDistinctOfAllVendingMachines() {
        return vendingMachines.stream()
                .flatMap(vm -> vm.getBeverages().stream())
                .map(Beverage::getName)
                .distinct()
                .count();
    }

    @Override
    public VendingMachine getVendingMachineWithTheMostBeverages() {
        return vendingMachines.stream()
                .max(Comparator.comparingInt(vm -> vm.getBeverages().size()))
                .orElseThrow();
    }

    @Override
    public Beverage findTheCheapestNonAlcoholicBeverage() {
        return vendingMachines.stream()
                .flatMap(vm -> vm.getBeverages().stream())
                .filter(b -> !(b instanceof Alcoholic))
                .min(Comparator.comparingDouble(b -> Bottle.PRICE_FOR_BOTTLE + Bottle.MAX_AMOUNT_IN_LITER * b.getPricePerLiter()))
                .orElseThrow();
    }
}