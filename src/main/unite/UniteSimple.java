package main.unite;

import main.*;

public class UniteSimple extends UniteAbstract{
    public boolean expert;
    public boolean monte;
    public int exp;

    public UniteSimple(String nom, TypeTravail typeTravail, Case position) {
        this.nom = nom;
        this.setOutil(new Outil(typeTravail));
        this.expert = false;
        this.monte = false;
        this.exp = 0;
        this.setPosition(position);
        this.setVitesse(1);
        this.cout = 1;
    }

    @Override
    public void travailler() {
        try {
            consomerNourriture(cout);
        }
        catch (Exception e){
            System.out.println(nom + " n'a pas assez de nourriture pour travailler");
            return;
        }
        System.out.print(nom + "(" + this.getPosition().getX() + "," + this.getPosition().getY() + ") :");
        this.getPosition().consomerRessource(this.getOutil());
        if (exp<5)
            exp++;
        else {
            expert = true;
            this.getPosition().consomerRessource(this.getOutil());
        }

    }
    @Override
    public void deplacerDeUnVersDirection(){
        this.cheminLePlusCourt(this.ressouceLaPlusProche(this.getOutil().getTypeRessource()));
    }

    @Override
    public void afficher() {
        System.out.println("    Unite "+ nom + ":");
        getOutil().afficher();
        System.out.println("     - Expert : " + expert);
        System.out.println("     - Monté : " + monte);
        System.out.println("     - Expérience : " + exp);
        System.out.println("     - Vitesse : " + this.getVitesse());
    }


}
