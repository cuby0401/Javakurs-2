package javakurs.hausaufgaben.tag5.supplier;

import javakurs.hausaufgaben.tag5.automat.VendingMachine;

import java.util.List;


/**
 * Allgemeine Definition für einen Automatenzulieferer.
 *
 * @author Christoph Gragert (cgr@shd.de)
 */
@FunctionalInterface
public interface VendingMachineSupplier
{
   List<VendingMachine> supplyVendingMachines();
}
