package main;
import main.unite.UniteAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static main.TypeRessource.NOURRITURE;

public class Case {
    private final int x;
    private final int y;
    private Ressource ressource;
    private UniteAbstract Unite ;

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
                System.out.println("j'ai récolté "+
                        switch (ressource.type) {
                            case NOURRITURE -> "de la nourriture";
                            case BOIS -> "du bois";
                            case OR -> "de l'or";
                            case PIERRE -> "de la pierre";
                        }
                        +", il en reste " + ressource.quantite);
                if (ressource.quantite == 0) {
                    System.out.println("Il n'y a plus de ressource sur cette case");
                    ressource = null;
                }
                Inventaire.getInstance().ajouterRessource(ressource.type, 1);
            }
            else {
                System.out.println("Mauvais outil");
                return;
            }
        }
        else
            System.out.println("Pas de ressource");
    }

    public void afficher(){
        System.out.println("Case ("+this.x+","+this.y+"): ");
        if (ressource != null)
            System.out.println(" - Ressource : "+ressource.type+" ("+ressource.quantite+")");
        else System.out.println(" - Ressource : Aucune");
        if (Unite != null)
            this.Unite.afficher();
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

    public UniteAbstract getUnite() {
        return this.Unite;
    }
    public void setUnite(UniteAbstract unite){
        this.Unite = unite;
    }

    public TypeRessource getTypeRessource() {
        return this.ressource.type;
    }
}


