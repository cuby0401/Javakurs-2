package javakurs.seb.tag3.aufgabe4;

public class GenericChainedNodesUtil {
    private <TYPE> TYPE size(GenericChainedNodes<TYPE> node) {
        return node.printAllNodes();
    }
}
