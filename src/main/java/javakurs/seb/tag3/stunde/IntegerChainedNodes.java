package javakurs.seb.tag3.stunde;

public class IntegerChainedNodes implements ChainedNodes
{
   private final int node;
   private IntegerChainedNodes nextNode;

   public IntegerChainedNodes(final int node)
   {
      this.node = node;
   }

   @Override
   public Integer getData()
   {
      return node;
   }

   @Override
   public IntegerChainedNodes getNextNode()
   {
      return nextNode;
   }

   @Override
   public IntegerChainedNodes setNextNode(ChainedNodes newNextNode)
   {
      if(newNextNode instanceof final IntegerChainedNodes newNextIntegerNode)
      {
         this.nextNode = newNextIntegerNode;
         return nextNode;
      }
      throw new IllegalStateException("ChainedNodes is not of type IntegerChainedNodes");
   }
}
