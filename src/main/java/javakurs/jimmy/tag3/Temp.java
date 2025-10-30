package javakurs.jimmy.tag3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Temp<TYPE> {
    private TYPE data;
    private Temp<TYPE> nextElement;

    public static void main(String[] args) {
        Temp<Integer> I1 = new Temp<>(1, null);
        Temp<String> S1 = new Temp<>("Hallo", null);
    }
}
