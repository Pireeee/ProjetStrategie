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
    private final Map<TypeRessource, Integer> banque;

    private Main() {
        carte = new Carte(10, 10);
        banque = new HashMap<>();
        for (TypeRessource typeRessource : TypeRessource.values()) {
            banque.put(typeRessource, 10);
        }
        //ajoute 20 nourritures
        banque.put(TypeRessource.NOURRITURE, banque.get(TypeRessource.NOURRITURE) + 20);
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
    public void afficherBanque(){
        System.out.println("Banque :");
        for (TypeRessource typeRessource : TypeRessource.values()) {
            System.out.println(typeRessource + " : " + banque.get(typeRessource));
        }
    }
    private void tour(){
        for (UniteAbstract unite : listeUnite) {
            unite.travailler();
        }
        afficherBanque();
    }
    private void tour(int nbTour){
        for (int i = 0; i < nbTour; i++) {
            tour();
        }
    }
}