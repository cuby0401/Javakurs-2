package javakurs.hausaufgaben.tag5.vendor;

import javakurs.hausaufgaben.tag5.automat.VendingMachine;
import javakurs.hausaufgaben.tag5.beverage.Beer;
import javakurs.hausaufgaben.tag5.beverage.Beverage;
import javakurs.hausaufgaben.tag5.supplier.BeverageSupplier;
import javakurs.hausaufgaben.tag5.supplier.FirstBeverageSupplier;
import javakurs.hausaufgaben.tag5.supplier.SecondBeverageSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class VendorTest {

    private Vendor vendor;

    @BeforeEach
    void setup() {
        vendor = new Vendor();

        // BeverageSupplier für Automat 1
        BeverageSupplier supplier1 = new FirstBeverageSupplier();

        // BeverageSupplier für Automat 2
        BeverageSupplier supplier2 = new SecondBeverageSupplier();

        // Automaten erzeugen und Supplier setzen
        VendingMachine vm1 = new VendingMachine();
        vm1.setBeverageSupplier(supplier1);

        VendingMachine vm2 = new VendingMachine();
        vm2.setBeverageSupplier(supplier2);

        // Vendor bekommt Supplier für die Automaten
        vendor.supplyVendingMachines(() -> List.of(vm1, vm2));

        // Automaten befüllen
        vendor.restock();
    }

    @Test
    void testGetBeveragesOfAllVendingMachines() {
        Set<Beverage> beverages = vendor.getBeveragesOfAllVendingMachines();

        // Nur prüfen, dass erwartete Namen enthalten sind
        Set<String> names = beverages.stream().map(Beverage::getName).collect(Collectors.toSet());

        assertTrue(names.contains("Beer Classic"));
        assertTrue(names.contains("Beer Dark"));
        assertTrue(names.contains("Cola Original"));
        assertTrue(names.contains("Cola Cherry"));
        assertTrue(names.contains("Espresso Martini Standard"));
        assertTrue(names.contains("Espresso Martini Vanilla"));
        assertTrue(names.contains("Coffee Mild"));
        assertTrue(names.contains("Coffee Dark"));
        assertTrue(names.contains("Water Still"));
        assertTrue(names.contains("Water Sparkling"));
        assertTrue(names.contains("Water Medium"));
        assertTrue(names.contains("Water Classic"));
    }

    @Test
    void testCountNumberOfAllBeveragesIncludingDuplicates() {
        long count = vendor.countNumberOfBeveragesOfAllVendingMachines();

        // 2 Automaten, erste liefert 10 Getränke, zweite liefert 7 → insgesamt 17
        assertEquals(17, count);
    }

    @Test
    void testCountNumberOfDistinctBeverages() {
        long count = vendor.countNumberOfBeveragesDistinctOfAllVendingMachines();

        // Alle verschiedenen Getränke: 12 distinct
        assertEquals(12, count);
    }

    @Test
    void testVendingMachineWithTheMostBeverages() {
        VendingMachine result = vendor.getVendingMachineWithTheMostBeverages();

        // FirstBeverageSupplier liefert 10 Getränke → muss gewählt werden
        assertEquals(10, result.getBeverages().size());
    }

    @Test
    void testFindCheapestNonAlcoholicBeverage() {
        Beverage cheapest = vendor.findTheCheapestNonAlcoholicBeverage();

        // Günstigstes nicht-alkoholisches Getränk laut Supplier: "Water Still" = 1.00
        assertEquals("Water Still", cheapest.getName());
    }

    @Test
    void testFindCheapestNonAlcoholicBeverage_ThrowsIfNone() {
        Vendor vendor2 = new Vendor();

        // Nur alkoholische Getränke
        Beverage beer2 = new Beer("TestBeer", 1.0, 8);

        VendingMachine vm = new VendingMachine();
        vm.setBeverageSupplier(() -> Set.of(beer2));

        vendor2.supplyVendingMachines(() -> List.of(vm));
        vendor2.restock();

        assertThrows(
                java.util.NoSuchElementException.class,
                vendor2::findTheCheapestNonAlcoholicBeverage
        );
    }
}