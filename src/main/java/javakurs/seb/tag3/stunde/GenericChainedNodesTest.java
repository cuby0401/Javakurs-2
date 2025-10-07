package javakurs.seb.tag3.stunde;

public class GenericChainedNodesTest
{
   public static void main(String[] args)
   {
      final GenericChainedNodes<String> f1 = new GenericChainedNodes<>("Start");
      final GenericChainedNodes<String> f2 = new GenericChainedNodes<>("Mitte");
      final GenericChainedNodes<String> f3 = new GenericChainedNodes<>("Ende");
      f1.setNextNode(f2).setNextNode(f3);
      f1.printAllNodes();

      System.out.println("-----");

      final GenericChainedNodes<Double> d1 = new GenericChainedNodes<>(1.0);
      final GenericChainedNodes<Double> d2 = new GenericChainedNodes<>(2.0);
      final GenericChainedNodes<Double> d3 = new GenericChainedNodes<>(3.0);
      d1.setNextNode(d2).setNextNode(d3);
      d1.printAllNodes();
   }
}
