package main.unite;
import main.*;

public abstract class UniteAbstract {
    public String nom;
    private int vitesse;
    public int cout;
    private Case position;

    public void consomerNourriture(int cout) {
        Inventaire.getInstance().retirerRessource(TypeRessource.NOURRITURE, cout);
    }

    public abstract void deplacer();

    public abstract void afficher();

    public abstract void travailler();

    public void seDeplacer(Case position) {
        this.setPosition(position);
    }

    public Case getPosition() {
        return this.position;
    }
    public void setPosition(Case position) {
        this.position = position;
    }
    public int getX(){
        return this.position.getX();
    }
    public int getY(){
        return this.position.getY();
    }
    public int getVitesse() {
        return this.vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public void teleporter(int x, int y){
        Carte carte = Carte.getInstance();
        //on met l'unité dans la case de destination
        assert carte != null;
        carte.get(x,y).setUnite(this);
        carte.get(this.getX(),this.getY()).setUnite(null);
        //on met à jour les coordonnées de l'unité
        this.seDeplacer(carte.get(x,y));
        System.out.println(nom + ": je me suis déplacé en ("+x+","+y+")");
    }



}

