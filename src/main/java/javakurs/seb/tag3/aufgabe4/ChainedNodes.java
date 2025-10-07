package javakurs.seb.tag3.aufgabe4;

/**
 * This class contains an element and links to another class
 */
public interface ChainedNodes
{
   /**
    * Retrieves the current element in this ChainedList
    */
   Object getData();

   /**
    * Retrieves the next element in this ChainedList. Returns null if this is the end of the chain.
    */
   ChainedNodes getNextNode();

   /**
    * Changes the next element in this ChainedList.
    */
   ChainedNodes setNextNode(final ChainedNodes newNextNode);

   /**
    * Returns true if and only if this ChainedList contains more nested elements
    */
   default boolean hasNextNode()
   {
      return getNextNode() != null;
   }

   /**
    * Prints all this and all nested nodes into the console
    */
   default void printAllNodes()
   {
      System.out.println(getData());
      if(getNextNode() != null)
      {
         getNextNode().printAllNodes();
      }
   }
}
