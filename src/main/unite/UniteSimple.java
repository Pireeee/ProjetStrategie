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
}
