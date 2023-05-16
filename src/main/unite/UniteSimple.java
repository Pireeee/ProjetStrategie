package main.unite;

import main.*;

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
        this.setPosition(position);
        this.vitesse = 1;
        this.cout = 1;
    }



    @Override
    public void travailler() {
        try {
            consomerNourriture(cout);
        }
        catch (Exception e){
            System.out.println(nom + " n'a pas assez de nourriture pour travailler");
        }
        System.out.print(nom + "(" + this.getPosition().getX() + "," + this.getPosition().getY() + ") :");
        this.getPosition().consomerRessource(outil);
        if (exp<5)
            exp++;
        else {
            expert = true;
            this.getPosition().consomerRessource(outil);
        }

    }

    @Override
    public void seDeplacer(int x, int y) {

    }

}
