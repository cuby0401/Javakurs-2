package javakurs.seb.tag3.aufgabe1;

public class Main {
    public static void main(String[] args) {
        Verkettung test1 = new Verkettung("erster", null);
        Verkettung test2 = new Verkettung("zweiter", test1);
        Verkettung test3 = new Verkettung("dritter", test2);
        Verkettung test4 = new Verkettung("vierter", test3);
    }
}