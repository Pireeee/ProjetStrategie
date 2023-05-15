package main;

import main.unite.UniteAbstract;
import main.unite.UniteSimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Carte carte;
    private final List<UniteAbstract> listeUnite = new ArrayList<>();
    private final Inventaire inventaire = Inventaire.getInstance();

    private Main() {
        carte = new Carte(10, 10);
        //ajoute 10 de chaque ressource
        for (TypeRessource typeRessource : TypeRessource.values()) {
            inventaire.ajouterRessource(typeRessource, 10);
        }
        //ajoute 20 nourritures
        inventaire.ajouterRessource(TypeRessource.NOURRITURE,  20);
    }

    private void run() {
        UniteSimple raf = new UniteSimple("Raphael",TypeTravail.FERMIER,carte.cases[5][6]);
        listeUnite.add(raf);
        carte.afficher(listeUnite);
        tour();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void tour(){
        for (UniteAbstract unite : listeUnite) {
            unite.travailler();
        }
        inventaire.afficher();
    }
    private void tour(int nbTour){
        for (int i = 0; i < nbTour; i++) {
            tour();
        }
    }
}