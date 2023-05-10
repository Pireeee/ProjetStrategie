package main;

import main.unite.UniteAbstract;
import main.unite.UniteSimple;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final Carte carte;
    private final List<UniteAbstract> listeUnite = new ArrayList<>();

    private Main() {
        carte = new Carte(10, 10);
    }

    private void run() {
        UniteSimple raf = new UniteSimple("Raphael",TypeTravail.FERMIER,carte.cases[5][6]);
        listeUnite.add(raf);
        carte.afficher(listeUnite);
        raf.travailler();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}