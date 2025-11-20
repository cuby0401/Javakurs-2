package javakurs.hausaufgaben.tag5;

import javakurs.hausaufgaben.tag5.automat.VendingMachine;
import javakurs.hausaufgaben.tag5.supplier.BeverageSupplier;
import javakurs.hausaufgaben.tag5.supplier.FirstBeverageSupplier;
import javakurs.hausaufgaben.tag5.supplier.SecondBeverageSupplier;
import javakurs.hausaufgaben.tag5.vendor.Vendor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vendor vendor = new Vendor();

        vendor.supplyVendingMachines(() -> List.of(
                createVM(new FirstBeverageSupplier()),
                createVM(new SecondBeverageSupplier())
        ));

        vendor.restock();

        // Automaten befüllen (ruft intern auch restock() der einzelnen Automaten auf)
        vendor.restock();

        System.out.println("Alle Getränke:");
        vendor.getBeveragesOfAllVendingMachines()
                .forEach(b -> System.out.println(" - " + b.getName()));

        System.out.println("\nAnzahl aller Getränke (inkl. Duplikate): "
                + vendor.countNumberOfBeveragesOfAllVendingMachines());

        System.out.println("Anzahl an verschiedenen Getränken: "
                + vendor.countNumberOfBeveragesDistinctOfAllVendingMachines());

        System.out.println("\nAutomat mit den meisten Getränken:");
        System.out.println(vendor.getVendingMachineWithTheMostBeverages());

        System.out.println("\nGünstigstes nicht-alkoholisches Getränk:");
        System.out.println(vendor.findTheCheapestNonAlcoholicBeverage());
    }

    private static VendingMachine createVM(BeverageSupplier s) {
        VendingMachine vm = new VendingMachine();
        vm.setBeverageSupplier(s);
        return vm;
    }
}
