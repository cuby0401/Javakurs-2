package javakurs.seb.tag3.aufgabe2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Main<TYPE> {
    private TYPE name;
    private Main<TYPE> nachfolger;

    public static void main(String[] args) {
        Main<Integer> tester = new Main<>(2, null);
        Main<Integer> tester2 = new Main<>(2, tester);
        Main<Double> tester3 = new Main<>(1.2, null);
        Main<String> tester4 = new Main<>("String1", null);
    }
}