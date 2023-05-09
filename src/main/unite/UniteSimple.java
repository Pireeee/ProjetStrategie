package main.unite;

import main.Outil;
import main.TypeRessource;

public class UniteSimple {
    public String nom;
    public boolean expert;
    public boolean monte;
    public Outil outil;
    public int exp;

    public UniteSimple(String nom, TypeRessource typeRessource) {
        this.nom = nom;
        this.outil = new Outil(typeRessource);
        this.expert = false;
        this.monte = false;
        this.exp = 0;
    }
}
