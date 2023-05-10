package main;

import main.unite.UniteAbstract;
import main.unite.UniteSimple;

import java.util.List;

public class Carte {
    public int largeur;
    public int hauteur;
    public Case[][] cases;
    private int nbRessource;

    public Carte(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.cases = new Case[this.hauteur][this.largeur];
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                this.cases[i][j] = new Case(i,j);
            }
        }
    }
    public void afficher(){
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                System.out.print("[");
                if (this.cases[i][j].ressource == null)
                    System.out.print(" ");
                else{
                    nbRessource++;
                    switch (this.cases[i][j].ressource.type) {
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
                System.out.print("]");
            }
            System.out.println("");
        }
        System.out.println("Nombre de ressource : " + nbRessource);
    }
    public void afficher(List<UniteAbstract> unites){
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                System.out.print("[");
                if (this.cases[i][j].ressource == null)
                    System.out.print(" ");
                else{
                    nbRessource++;
                    switch (this.cases[i][j].ressource.type) {
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
                for (UniteAbstract unite : unites) {
                    if (unite.position.x == i && unite.position.y == j) {
                        if(unite instanceof UniteSimple)
                            System.out.print("¤");
                        else
                            System.out.print("@");
                    }

                }
                System.out.print("]");
            }
            System.out.println("");
        }
        System.out.println("Nombre de ressource : " + nbRessource);
    }

}
