package main.unite;

import main.Outil;
import main.TypeRessource;
import main.TypeTravail;

public class UniteSimple extends UniteAbstract{
    public String nom;
    public boolean expert;
    public boolean monte;
    public Outil outil;
    public int exp;

    public UniteSimple(String nom, TypeTravail typeTravail) {
        this.nom = nom;
        this.outil = new Outil(typeTravail);
        this.expert = false;
        this.monte = false;
        this.exp = 0;
    }

    @Override
    public void ConsomerNourriture(int cout) {
    }

    @Override
    public void travailler() {
        position.consomerRessource(outil);
        if (exp<5)
            exp++;
        else {
            expert = true;
            position.consomerRessource(outil);
        }
    }

    @Override
    public void seDeplacer(int x, int y) {

    }

}
