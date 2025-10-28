package javakurs.hausaufgaben.tag3;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class GenericChainedNodesIterable<TYPE> extends GenericChainedNodes<TYPE> implements Iterable<TYPE>
{

    public GenericChainedNodesIterable(TYPE data) {
        super(data);
    }

    @Override
    public Iterator<TYPE> iterator() {
        return new Iterator<TYPE>() {
            private GenericChainedNodes<TYPE> current = GenericChainedNodesIterable.this;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public TYPE next() {
                TYPE data = current.getData();
                current = current.getNextNode();
                return data;
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
