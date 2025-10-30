package javakurs.jimmy.tag3.aufgabe2;

public class Main {
    public static void main(String[] args) {
        Test<String> test1 = new Test<>("erster");
        Test<String> test2 = test1.link("zweiter");
        Test<String> test3 = test2.link("dritter");
        Test<String> test4 = test3.link("vierter");

        Test<Integer> test5 = new Test<>(1);
        Test<Integer> test6 = test5.link(2);
        Test<Integer> test7 = test6.link(3);
        Test<Integer> test8 = test7.link(4);
    }
}
