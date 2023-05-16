package main;

import main.unite.UniteAbstract;
import main.unite.UniteSimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Carte carte = Carte.getInstance(10, 10);
    private final Inventaire inventaire = Inventaire.getInstance();

    private Main() {
        //ajoute 10 de chaque ressource
        for (TypeRessource typeRessource : TypeRessource.values()) {
            inventaire.ajouterRessource(typeRessource, 10);
        }
        //ajoute 20 nourritures
        inventaire.ajouterRessource(TypeRessource.NOURRITURE,  20);
    }

    private void run() {
        UniteSimple raf = new UniteSimple("Raphael",TypeTravail.FERMIER,carte.get(2,3));
        carte.get(2,3).setRessource(TypeRessource.NOURRITURE);
        carte.get(raf.getX(),raf.getY()).ajouterUnite(raf);
        tour();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void tour(){
        System.out.println("Début du Tour:");
        carte.afficher();
        inventaire.afficher();
        System.out.println("Phase de travail :");
        carte.travailler();
        System.out.println("Fin du tour");
    }
    private void tour(int nbTour){
        for (int i = 0; i < nbTour; i++) {
            tour();
        }
    }
}