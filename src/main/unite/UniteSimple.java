package main.unite;

import main.Case;
import main.Outil;
import main.TypeRessource;
import main.TypeTravail;

import javax.swing.text.Position;

public class UniteSimple extends UniteAbstract{
    public boolean expert;
    public boolean monte;
    public Outil outil;
    public int exp;

    public UniteSimple(String nom, TypeTravail typeTravail, Case position) {
        this.nom = nom;
        this.outil = new Outil(typeTravail);
        this.expert = false;
        this.monte = false;
        this.exp = 0;
        this.position = position;
        this.vitesse = 1;
        this.cout = 1;
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
