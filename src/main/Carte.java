package main;

import main.unite.UniteAbstract;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carte {
    public int x;
    public int y;
    public List<List<Case>> cases;
    private int nbRessource;
    private static Carte instance;

    public Carte(int largeur, int hauteur, List<List<Case>> cases) {
        this.x = largeur;
        this.y = hauteur;
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
    public static Carte getInstance() {
        if (instance != null)
            return instance;
        else{
            System.err.println("Carte non initialisé");
            return null;
        }
    }

    public void afficher(){
        System.out.println("Carte :");
        System.out.print("  ");
        for (int longeur = 0; longeur < this.y; longeur++) {
            System.out.print(longeur);
            System.out.print("   ");
        }
        System.out.println("");
        for (int i = 0; i < this.x; i++) {
            System.out.print(i);
            for (int j = 0; j < this.y; j++) {
                System.out.print("[");
                if (this.get(i,j).getRessource() == null)
                    System.out.print(" ");
                else{
                    nbRessource++;
                    switch (this.get(i,j).getRessource().type) {
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
                if (this.get(i,j).getUnite() != null)
                    System.out.print("¤");
                else
                    System.out.print(" ");
                System.out.print("]");
            }
            System.out.println("");
        }
    }
    public Case get(int x, int y){
        return this.cases.get(y).get(x);
    }

    public void afficherCase(int x, int y){
        this.get(x,y).afficher();
    }

    public void travailler(){
        for(int i = 0; i < this.x; i++){
            for(int j = 0; j < this.y; j++){
                if(this.get(i,j).getUnite() != null)
                    this.get(i,j).getUnite().travailler();
            }
        }
    }
    //déplace les unités
    public void deplacer() {
        List<List<Case>> carteTemp = this.cases;
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (carteTemp.get(j).get(i).getUnite() != null) {
                    this.get(i, j).getUnite().deplacer();
                }
            }
        }
    }



    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
