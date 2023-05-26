package main.unite;

import main.Outil;

import java.util.ArrayList;
import java.util.List;

public class UniteGroupe extends UniteAbstract{
    private final List<UniteSimple> unites;

    public UniteGroupe(UniteAbstract unite) {
        this.unites = new ArrayList<>();
        if(unite.getClass().isInstance(UniteGroupe.class)){
            UniteGroupe uniteGroupe = (UniteGroupe) unite;
            unites.addAll(uniteGroupe.unites);
        }
        else{
            //TODO demande un nom de groupe au joueur
            unites.add((UniteSimple) unite);
        }
    }
    @Override
    public void travailler() {
        for(UniteSimple unite : unites)
            unite.travailler();
    }

    @Override
    public int getVitesse() {
        int vitesse = 0;
        for(UniteSimple unite : unites){
            if (unite.getVitesse() > vitesse) {
                vitesse = unite.getVitesse();
            }
        }
        return vitesse;
    }
    @Override
    public void deplacerDeUnVersDirection(){
        for(UniteSimple unite : unites)
            unite.deplacerDeUnVersDirection();
    }

    @Override
    public void afficher() {
        System.out.println(" - Groupe "+this.nom+" :");
        for(UniteSimple unite : unites)
            unite.afficher();
    }

    @Override
    public Outil getOutil() {
        return unites.get(0).getOutil();
    }
    public void addUnite(UniteAbstract unite){
        if(unite.getClass().isInstance(UniteGroupe.class)){
            UniteGroupe uniteGroupe = (UniteGroupe) unite;
            for(UniteSimple uniteSimple : uniteGroupe.unites){
                unites.add(uniteSimple);
            }
        }
        else{
            unites.add((UniteSimple) unite);
        }
    }
}
