package javakurs.jimmy.tag3.aufgabe2;

public class Test<E> {
    private E name;
    private Test<E> nextElement;

    public Test(E name) {
        this.name = name;
    }

    public Test<E> link(E nextName) {
        this.nextElement = new Test<>(nextName);
        return this.nextElement;
    }

    public E getName() {
        return name;
    }

    public Test<E> getNextElement() {
        return nextElement;
    }
}
