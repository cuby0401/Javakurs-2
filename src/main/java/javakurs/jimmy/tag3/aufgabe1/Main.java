package javakurs.jimmy.tag3.aufgabe1;

public class Main {
    public static void main(String[] args) {
        Test test1 = new Test("erster", null);
        Test test2 = new Test("zweiter", test1);
        Test test3 = new Test("dritter", test2);
        Test test4 = new Test("vierter", test3);
    }
}
