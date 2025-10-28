package javakurs.hausaufgaben.tag3;

@SuppressWarnings("LombokGetterMayBeUsed")
public class GenericTask1<TYPE_1, TYPE_2 extends TYPE_1>

{
    private final TYPE_1 element1;
    private final TYPE_2 element2;

    public GenericTask1(final TYPE_1 element1, final TYPE_2 element2)
    {
        this.element1 = element1;
        this.element2 = element2;
    }

    public TYPE_1 getElement1() { return element1; }

    public TYPE_2 getElement2() { return element2; }

    public static <TYPE_1, TYPE_2 extends TYPE_1> GenericTask1<TYPE_1, TYPE_2> of(final TYPE_1 element1, final TYPE_2 element2) {
        return new GenericTask1<>(element1, element2);
    }

    public static <T> T getFirstElement(GenericTask1<T, ? extends T> task) {
        return task.getElement1();
    }
}
