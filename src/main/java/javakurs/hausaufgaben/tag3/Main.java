package javakurs.hausaufgaben.tag3;

public class Main
{
    public static void main(String[] args)
    {
        GenericTask1<Number, Integer> obj = new GenericTask1<>(3.14, 42);
        Number n = GenericTask1.getFirstElement(obj);
        System.out.println(n);

        final GenericChainedNodesIterable<String> f1 = new GenericChainedNodesIterable<>("Start");
        final GenericChainedNodesIterable<String> f2 = new GenericChainedNodesIterable<>("Mitte");
        final GenericChainedNodesIterable<String> f3 = new GenericChainedNodesIterable<>("Ende");
        f1.setNextNode(f2).setNextNode(f3);

        for (final String nextElement : f1) {
            System.out.println(nextElement);
        }
    }
    /**
     * Aufgabe 4:
     *
     * GenericChainedNodes<Object> bedeutet, dass die Kette nur Elemente vom Typ Object enthält.
     * Man kann also alles einfügen, weil in Java alles von Object erbt.
     * GenericChainedNodes<?> dagegen hat einen unbekannten Typ.
     * Man weiß nicht, welcher Typ darin steckt – deshalb kann man nur lesen, aber keine neuen Werte einfügen.
     * Kurz gesagt: Object ist ein fester Typ, ? ist ein unbekannter Typ.
     *
     *
     * Aufgabe 5:
     *
     * <? extends T> bedeutet, dass der Typ ein Untertyp von T ist. Man kann daraus lesen, aber nichts hineinschreiben.
     * <? super T> bedeutet, dass der Typ ein Obertyp von T ist. Man kann also hineinschreiben, aber nur als Object wieder auslesen.
     * Kurz gesagt: extends = lesen, super = schreiben und lesen.
     *
     *
     */
}
