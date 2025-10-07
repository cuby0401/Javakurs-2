package javakurs.seb.tag3.stunde;

public class StringChainedNodes implements ChainedNodes
{
   private final String node;
   private StringChainedNodes nextNode;

   public StringChainedNodes(final String node)
   {
      this.node = node;
   }

   @Override
   public String getData()
   {
      return node;
   }

   @Override
   public StringChainedNodes getNextNode()
   {
      return nextNode;
   }

   @Override
   public StringChainedNodes setNextNode(final ChainedNodes newNextNode)
   {
      if(newNextNode instanceof StringChainedNodes newNextStringNode)
      {
         this.nextNode = newNextStringNode;
         return nextNode;
      }
      throw new IllegalStateException("ChainedNodes is not of type StringChainedNodes");
   }
}
