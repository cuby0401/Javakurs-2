package javakurs.hausaufgaben.tag5.supplier;

import javakurs.hausaufgaben.tag5.automat.VendingMachine;

import java.util.List;

public class FirstVendingMachineSupplier implements VendingMachineSupplier {
    @Override
    public List<VendingMachine> supplyVendingMachines() {

        BeverageSupplier beverageSupplier1 = new FirstBeverageSupplier();
        BeverageSupplier beverageSupplier2 = new SecondBeverageSupplier();

        VendingMachine vm1 = new VendingMachine();
        vm1.setBeverageSupplier(beverageSupplier1);
        vm1.restock();

        VendingMachine vm2 = new VendingMachine();
        vm2.setBeverageSupplier(beverageSupplier2);
        vm2.restock();

        return List.of(vm1, vm2);
    }
}