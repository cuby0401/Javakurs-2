package javakurs.seb.tag3.aufgabe4;

public class ChainedNodesTest
{
   public static void main(String[] args)
   {
      final DoubleChainedNodes d1 = new DoubleChainedNodes(1.0);
      final DoubleChainedNodes d2 = new DoubleChainedNodes(2.0);
      final DoubleChainedNodes d3 = new DoubleChainedNodes(3.0);
      d1.setNextNode(d2).setNextNode(d3);
      d1.printAllNodes();

      System.out.println("-----");

      final IntegerChainedNodes i1 = new IntegerChainedNodes(1);
      final IntegerChainedNodes i2 = new IntegerChainedNodes(2);
      final IntegerChainedNodes i3 = new IntegerChainedNodes(3);
      i1.setNextNode(i2).setNextNode(i3);
      i1.printAllNodes();

      System.out.println("-----");

      final StringChainedNodes s1 = new StringChainedNodes("A");
      final StringChainedNodes s2 = new StringChainedNodes("B");
      final StringChainedNodes s3 = new StringChainedNodes("C");
      s1.setNextNode(s2).setNextNode(s3);
      s1.printAllNodes();
   }
}
