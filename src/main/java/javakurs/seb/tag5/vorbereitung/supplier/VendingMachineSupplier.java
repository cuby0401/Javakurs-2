package javakurs.seb.tag5.vorbereitung.supplier;

import java.util.List;

import javakurs.seb.tag5.vorbereitung.automat.VendingMachine;


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
