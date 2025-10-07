package javakurs.seb.tag3.stunde;

public class DoubleChainedNodes implements ChainedNodes
{
   private final double node;
   private DoubleChainedNodes nextNode;

   public DoubleChainedNodes(final Double node)
   {
      this.node = node;
   }

   @Override
   public Double getData()
   {
      return node;
   }

   @Override
   public DoubleChainedNodes getNextNode()
   {
      return nextNode;
   }

   @Override
   public DoubleChainedNodes setNextNode(ChainedNodes newNextNode)
   {
      if(newNextNode instanceof final DoubleChainedNodes newDoubleNextNode)
      {
         this.nextNode = newDoubleNextNode;
         return nextNode;
      }
      throw new IllegalStateException("ChainedNodes is not of type DoubleChainedNodes");
   }
}
