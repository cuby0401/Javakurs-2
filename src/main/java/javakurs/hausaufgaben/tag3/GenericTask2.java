package javakurs.hausaufgaben.tag3;

import java.util.Arrays;

@SuppressWarnings("LombokGetterMayBeUsed")
public class GenericTask2<TYPE extends Comparable<? super TYPE>>
{
    private final TYPE[] array;

    public GenericTask2(final TYPE[] array)
    {
        this.array = array;
    }

    public TYPE[] getType()
    {
        return array;
    }

    public void sort()
    {
        Arrays.sort(array);
    }
}


