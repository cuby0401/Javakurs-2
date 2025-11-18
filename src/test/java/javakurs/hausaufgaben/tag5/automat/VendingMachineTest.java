package javakurs.hausaufgaben.tag5.automat;

import javakurs.hausaufgaben.tag5.beverage.Alcoholic;
import javakurs.hausaufgaben.tag5.beverage.Beverage;
import javakurs.hausaufgaben.tag5.container.Bottle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    private VendingMachine vendingMachine;

    @BeforeEach
    void init() {
        vendingMachine = new VendingMachine();
        vendingMachine.setBeverageSupplier(vendingMachine);
        vendingMachine.restock();
    }

    @Test
    void restockShouldFill10Beverages() {
        assertEquals(10, vendingMachine.getBeverages().size());
    }

    @Test
    void shouldDisplayAllNames() {
        var names = vendingMachine.displayNamesOfAllBeverages();
        assertEquals(10, names.size());
        assertTrue(names.contains("Cola Original"));
    }

    @Test
    void shouldReturnOnlyAlcoholic() {
        var alcoholic = vendingMachine.getAllAlcoholicBeverages();
        assertFalse(alcoholic.isEmpty());
        assertTrue(alcoholic.stream().allMatch(b -> b instanceof Alcoholic));
    }

    @Test
    void shouldReturnOnlyCaffeinated() {
        var caffeinated = vendingMachine.getAllCaffeinatedBeverages();
        assertFalse(caffeinated.isEmpty());
    }

    @Test
    void shouldReturnColdBeverages() {
        var cold = vendingMachine.getOnlyColdBeverages();
        assertFalse(cold.isEmpty());
        assertTrue(cold.stream().allMatch(b -> b.getTemperature() < 10));
    }

    @Test
    void shouldReturnHotBeverages() {
        Beverage coffee = vendingMachine.findBeverage("Coffee Mild").orElseThrow();
        coffee.setAmount(1);
        coffee.setAmount(1);
        coffee.setAmount(1);

        try {
            var field = coffee.getClass().getSuperclass().getDeclaredField("temperature");
            field.setAccessible(true);
            field.setInt(coffee, 55);
        } catch (Exception e) {
            fail("Could not set temperature");
        }

        var hot = vendingMachine.getOnlyHotBeverages();
        assertTrue(hot.stream().anyMatch(b -> b.getName().equals("Coffee Mild")));
    }

    @Test
    void calculatePriceForOneBottleShouldBeCorrect() {
        double price = vendingMachine.calculatePriceForOneBottleOf("Cola Original");
        double expected = Bottle.PRICE_FOR_BOTTLE + Bottle.MAX_AMOUNT_IN_LITER * 2.80;
        assertEquals(expected, price);
    }

    @Test
    void calculatePriceForBottlesShouldMultiplyCorrectly() {
        double price = vendingMachine.calculatePriceForBottlesOf("Cola Original", 3);
        double single = vendingMachine.calculatePriceForOneBottleOf("Cola Original");
        assertEquals(single * 3, price);
    }

    @Test
    void calculatePriceForNegativeNumberShouldThrowException() {
        assertThrows(VendingMachineException.class,
                () -> vendingMachine.calculatePriceForBottlesOf("Cola Original", -1));
    }

    @Test
    void findBeverageShouldReturnCorrectItem() {
        var beverage = vendingMachine.findBeverage("Cola Original");
        assertTrue(beverage.isPresent());
        assertEquals("Cola Original", beverage.get().getName());
    }

    @Test
    void findNonExistingBeverageShouldBeEmpty() {
        assertTrue(vendingMachine.findBeverage("Vodka").isEmpty());
    }

    @Test
    void buyBeverageShouldBeImplemented() {
        assertThrows(NullPointerException.class, () -> vendingMachine.buyBeverage("Cola Original", 5));
        // Sobald buyBeverage implementiert wird, Test anpassen
    }
}