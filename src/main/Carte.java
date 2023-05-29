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
                    Case position = new Case(i,j);
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
        List<UniteAbstract> unites = new ArrayList<>();
        carte.append("Légende :\n");
        carte.append(" - [ ] : Rien\n");
        carte.append(" - [B] : Bois\n");
        carte.append(" - [N] : Nourriture\n");
        carte.append(" - [P] : Pierre\n");
        carte.append(" - [O] : Or\n");
        carte.append(" - [¤] : Unité Simple\n");
        carte.append(" - [@] : Unité Groupe\n");
        carte.append("Carte :\n");
        carte.append("  ");
        for (int longeur = 0; longeur < this.y; longeur++) {
            carte.append(longeur);
            carte.append("   ");
        }
        carte.append("< y \n");
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
                    unites.add(this.getCase(i,j).getUnite());
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
        carte.append("x\n");
        carte.append("Unites :\n");
        for (UniteAbstract unite : unites){
            carte.append(" - ").append(unite.nom).append(" ").append(unite.getOutil().getTypeTravail().getSymbole());
            carte.append(" (");
            carte.append(unite.getX());
            carte.append(",");
            carte.append(unite.getY());
            carte.append(")");
            carte.append("\n");
        }
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
        System.out.println("Déplacement Automatique des unités : ");
        System.out.println("");
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (carteTemp.get(i).get(j).getUnite() != null) {
                    UniteAbstract unite = this.getCase(i, j).getUnite();
                    if (!uniteDeplacees.contains(unite)) {
                        unite.deplacer();
                        uniteDeplacees.add(unite);
                    }
                }
            }
        }
        System.out.println("");
        System.out.println("Toutes les unités ont été déplacées");
        System.out.println("");
    }


    public Case getCase(int x, int y){
        return this.cases.get(x).get(y);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
