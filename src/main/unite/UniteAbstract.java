package main.unite;
import main.Case;
import main.TypeRessource;

public abstract class UniteAbstract {
    public int vitesse;
    public int cout;
    public Case position;

    public abstract int ConsomerNourriture(int cout);
    public abstract void travailler();
    public abstract void seDeplacer(int x,int y);
    public abstract void getRessource(TypeRessource typeRessource);
}

