package javakurs.seb.tag2.aufgabe2.gefaess;

import javakurs.seb.tag2.aufgabe2.getraenk.Gefaess;

public class Kakao extends Heißgetraenk {
    private double kakaoanteil;
    private double milchanteil;

    public Kakao(double temperatur, double menge, boolean zucker, Gefaess gefaess, double kakaoanteil, double milchanteil) {
        super(temperatur, menge, zucker, gefaess);
        this.kakaoanteil = kakaoanteil;
        this.milchanteil = milchanteil;
    }
}
