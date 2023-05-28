package main;

import main.unite.UniteAbstract;
import main.unite.UniteGroupe;

import java.util.ArrayList;
import java.util.List;

public class Carte {
    public int x;
    public int y;
    public List<List<Case>> cases;
    private static Carte instance;

    private Carte(int largeur, int hauteur, List<List<Case>> cases) {
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
        StringBuilder carte = new StringBuilder();
        carte.append("Carte :\n");
        carte.append("  ");
        for (int longeur = 0; longeur < this.y; longeur++) {
            carte.append(longeur);
            carte.append("   ");
        }
        carte.append("<-x \n");
        for (int i = 0; i < this.x; i++) {
            carte.append(i);
            for (int j = 0; j < this.y; j++) {
                carte.append("[");
                if (this.getCase(i,j).getRessource().type == TypeRessource.RIEN){
                    carte.append(" ");}
                else{
                    carte.append(this.getCase(i,j).getRessource().type.getSymbole());
                }
                if (this.getCase(i,j).getUnite() != null){
                    if (this.getCase(i,j).getUnite().getClass().equals(UniteGroupe.class)){
                        carte.append("@");
                    }
                    else{
                        carte.append("¤");
                    }
                }
                else{
                    carte.append(" ");}
                carte.append("]");
            }
            carte.append("\n");
        }
        carte.append("^\n");
        carte.append("|\n");
        carte.append("y\n");
        System.out.println(carte.toString());
    }

    public void travailler(){
        for(int i = 0; i < this.x; i++){
            for(int j = 0; j < this.y; j++){
                if(this.getCase(i,j).getUnite() != null)
                    this.getCase(i,j).getUnite().travailler();
            }
        }
    }
    //déplace les unités
    public void deplacerUnite() {
        List<List<Case>> carteTemp = this.cases;
        List<UniteAbstract> uniteDeplacees = new ArrayList<>();
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (carteTemp.get(j).get(i).getUnite() != null) {
                    UniteAbstract unite = this.getCase(i, j).getUnite();
                    if (!uniteDeplacees.contains(unite)) {
                        unite.deplacer();
                        uniteDeplacees.add(unite);
                    }
                }
            }
        }
    }


    public Case getCase(int x, int y){
        return this.cases.get(y).get(x);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
