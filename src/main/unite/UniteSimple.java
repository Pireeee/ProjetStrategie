package main.unite;

import main.*;

public class UniteSimple extends UniteAbstract{
    private boolean expert;
    private int exp;

    public UniteSimple(String nom, TypeTravail typeTravail, Case position) {
        this.nom = nom;
        this.setOutil(new Outil(typeTravail));
        this.expert = false;
        this.exp = 0;
        this.setPosition(position);
        this.setVitesse(1);
        this.setCout(1);
    }

    @Override
    public void travailler() {
        Inventaire inventaire = Inventaire.getInstance();
        //mange de la nourriture suivant l'apetit de l'unitée
        int faim = this.isExpert() ? this.getCout(): this.getCout()*2;
        if (!inventaire.possedeRessource(TypeRessource.NOURRITURE,faim)){
            System.out.println(nom + " n'a pas assez de nourriture pour travailler");
            return;
        }
        System.out.print(nom + "(" + this.getPosition().getX() + "," + this.getPosition().getY() + ") :");
        //l'unité essaye de consomer la ressource sur laquelle elle est.
        if(this.getPosition().consomerRessource(this.getOutil(),this.isExpert())){
            levelUp();
        }

    }

    @Override
    public void afficher() {
        System.out.println(" - Unite "+ nom + ":");
        getOutil().afficher();
        if(this.isExpert())
            System.out.println("    - Unité Experte ");
        System.out.println("     - Expérience : " + this.exp);
        System.out.println("     - Vitesse : " + this.getVitesse());
    }

    public boolean isExpert() {
        return this.expert;
    }

    public void levelUp(){
        if (this.expert)
            return;
        this.exp++;
        if (this.exp == 5){
            this.expert = true;
            this.setVitesse(2);
        }
    }

}
