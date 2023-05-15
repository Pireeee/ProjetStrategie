package main.unite;

import main.TypeRessource;

import java.util.List;

public class UniteGroupe extends UniteAbstract{
    public List<UniteSimple> unites;

    public UniteGroupe(List<UniteSimple> unites) {
        this.unites = unites;
    }

    @Override
    public void consomerNourriture(int cout) {

    }

    @Override
    public void travailler() {
        for(UniteSimple unite : unites)
            unite.travailler();
    }

    @Override
    public void seDeplacer(int x, int y) {
    }

}
