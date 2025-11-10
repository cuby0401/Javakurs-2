package javakurs.seb.tag5.supplier;

import java.util.List;

import javakurs.seb.tag5.automat.VendingMachine;


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
