package main.unite;
import main.Case;
import main.TypeRessource;

public abstract class UniteAbstract {
    public String nom;
    public int vitesse;
    public int cout;
    public Case position;

    public abstract void ConsomerNourriture(int cout);
    public abstract void travailler();
    public abstract void seDeplacer(int x,int y);
}

