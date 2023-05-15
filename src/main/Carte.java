package main;

import main.unite.UniteAbstract;
import main.unite.UniteSimple;

import java.util.ArrayList;
import java.util.List;

public class Carte {
    public int largeur;
    public int hauteur;
    public List<List<Case>> cases;
    private int nbRessource;
    private static Carte instance;

    public Carte(int largeur, int hauteur, List<List<Case>> cases) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.cases = cases;
    }

    public static Carte getInstance(int largeur, int hauteur) {
        if (instance == null) {
            List<List<Case>> colonnes = new ArrayList<>();
            for (int i = 0; i < largeur; i++) {
                List<Case> ligne = new ArrayList<>();
                for (int j = 0; j < hauteur; j++) {
                    Case position = new Case(j, i);
                    ligne.add(j, position);
                }
                colonnes.add(i, ligne);
            }
            instance = new Carte(largeur, hauteur, colonnes);
        }
        return instance;
    }
    public void afficher(){
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                System.out.print("[");
                if (this.cases.get(i).get(j).getRessource() == null)
                    System.out.print(" ");
                else{
                    nbRessource++;
                    switch (this.cases.get(i).get(j).getRessource().type) {
                        case NOURRITURE:
                            System.out.print("N");
                            break;
                        case BOIS:
                            System.out.print("B");
                            break;
                        case OR:
                            System.out.print("O");
                            break;
                        case PIERRE:
                            System.out.print("P");
                            break;
                    }
                }
                if (!this.cases.get(i).get(j).getListeUnites().isEmpty())
                    System.out.print("¤");
                System.out.print("]");
            }
            System.out.println("");
        }
        System.out.println("Nombre de ressource : " + nbRessource);
    }
    public Case get(int x, int y){
        return this.cases.get(x).get(y);
    }
}
