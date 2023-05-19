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

    public abstract void travailler();

    public void seDeplacer(int x,int y){
        this.getPosition().setX(x);
        this.getPosition().setY(y);
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
        carte.get(this.getX(),this.getY()).getListeUnites().remove(this);
        carte.get(x,y).getListeUnites().add(this);
        //on met à jour les coordonnées de l'unité
        this.seDeplacer(x, y);
    }

}

