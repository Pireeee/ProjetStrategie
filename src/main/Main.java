package main;

import main.unite.UniteSimple;

public class Main {
    public static Carte carte;
    public static void main(String[] args) {
        carte = new Carte(10, 10, new Case[10][10]);
        UniteSimple unite = new UniteSimple("Raphael",TypeTravail.FERMIER);
        carte.afficher();
    }
}