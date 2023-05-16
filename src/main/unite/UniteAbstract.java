package main.unite;
import main.Case;
import main.Inventaire;
import main.TypeRessource;

public abstract class UniteAbstract {
    public String nom;
    public int vitesse;
    public int cout;
    private Case position;

    public void consomerNourriture(int cout) {
        Inventaire.getInstance().retirerRessource(TypeRessource.NOURRITURE, cout);
    }
    public abstract void travailler();
    public abstract void seDeplacer(int x,int y);

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
}

