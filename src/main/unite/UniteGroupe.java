package main.unite;

import main.Direction;
import main.TypeRessource;

import java.util.List;

public class UniteGroupe extends UniteAbstract{
    public List<UniteSimple> unites;

    public UniteGroupe(List<UniteSimple> unites) {
        this.unites = unites;
    }

    @Override
    public void travailler() {
        for(UniteSimple unite : unites)
            unite.travailler();
    }

    @Override
    public void seDeplacer(int x, int y) {
    }

    @Override
    public int getVitesse() {
        int vitesse = 0;
        for(UniteSimple unite : unites)
            if (unite.getVitesse() > vitesse)
                vitesse = unite.getVitesse();
        return vitesse;
    }
    @Override
    public void deplacer(){
        for(UniteSimple unite : unites)
            unite.deplacer();
    }
}
