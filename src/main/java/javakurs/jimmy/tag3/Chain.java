package javakurs.jimmy.tag3;

public class Chain<T> {
    private T value;
    private Chain<T> next;

    public Chain(T value) {
        this.value = value;
    }

    public Chain<T> link(T nextValue) {
        this.next = new Chain<>(nextValue);
        return this.next;
    }

    public T getValue() {
        return value;
    }

    public Chain<T> getNext() {
        return next;
    }
}
