package main;

import main.unite.UniteAbstract;
import main.unite.UniteSimple;

import java.util.ArrayList;
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
    public void afficher(){
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
                if (!this.get(i,j).getListeUnites().isEmpty())
                    System.out.print("¤");
                else
                    System.out.print(" ");
                System.out.print("]");
            }
            System.out.println("");
        }
        System.out.println("Nombre de ressource : " + nbRessource);
    }
    public Case get(int x, int y){
        return this.cases.get(y).get(x);
    }
    public void travailler(){
        for(int i = 0; i < this.x; i++){
            for(int j = 0; j < this.y; j++){
                for(UniteAbstract unite : this.cases.get(i).get(j).getListeUnites()){
                    unite.travailler();
                }
            }
        }
    }
    public void deplacer(){
        /*for(int i = 0; i < this.x; i++){
            for(int j = 0; j < this.y; j++){
                for(UniteAbstract unite : this.cases.get(i).get(j).getListeUnites()){
                    unite.deplacer();
                }
            }
        }*/
        deplacerUnite(this.get(2,3).getListeUnites().get(0),3,3);
    }
    public void deplacerUnite(UniteAbstract unite, int x, int y){
        this.get(unite.getX(),unite.getY()).getListeUnites().remove(unite);
        this.get(x,y).getListeUnites().add(unite);
        unite.seDeplacer(x, y);
    }
}
