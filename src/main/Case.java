package main;
import main.unite.UniteAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

public class Case {
    private int x;
    private int y;
    private Ressource ressource;
    private final List<UniteAbstract> listeUnites = new ArrayList<>();

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        Random rand = new Random();
        if (rand.nextInt(3) == 0) {
            this.ressource = new Ressource(TypeRessource.values()[rand.nextInt(TypeRessource.values().length)]);
        }
    }
    public void consomerRessource(Outil outil){
        if (ressource != null) {
            if(outil.estBonOutil(ressource.type)) {
                ressource.quantite--;
                System.out.println("Ressource consomée, il en reste " + ressource.quantite);
            }
            else {
                System.out.println("Mauvais outil");
                return;
            }
        }
        else
            System.out.println("Pas de ressource");
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Ressource getRessource() {
        return this.ressource;
    }

    public List<UniteAbstract> getListeUnites() {
        return this.listeUnites;
    }
    public void ajouterUnite(UniteAbstract unite){
        this.listeUnites.add(unite);
    }
}


