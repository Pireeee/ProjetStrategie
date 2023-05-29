package main.unite;

import main.*;

public class UniteSimple extends UniteAbstract{
    private boolean expert;
    private int exp;
    private int fatigue;

    public UniteSimple(String nom, TypeTravail typeTravail, Case position) {
        Carte carte = Carte.getInstance();
        this.nom = nom;
        this.setOutil(new Outil(typeTravail));
        this.expert = false;
        this.exp = 0;
        this.setPosition(position);
        this.setVitesse(1);
        this.setCout(1);
        carte.getCase(this.getX(),this.getY()).setUnite(this);
    }
    public UniteSimple(String nom, TypeTravail typeTravail) {
        this.nom = nom;
        this.setOutil(new Outil(typeTravail));
        this.expert = false;
        this.exp = 0;
        Carte carte = Carte.getInstance();
        this.setPosition(carte.getCase((int)(Math.random()* carte.getX()),(int)(Math.random()* carte.getY())));
        this.setVitesse(1);
        this.setCout(1);
        carte.getCase(this.getX(),this.getY()).setUnite(this);
    }
    @Override
    public void travailler() {
        Inventaire inventaire = Inventaire.getInstance();
        //mange de la nourriture suivant l'apetit de l'unitée
        int faim = this.isExpert() ? this.getCout()*2 : this.getCout();
        if (!inventaire.possedeRessource(TypeRessource.NOURRITURE,faim)){
            System.out.println(nom + " n'a pas assez de nourriture pour travailler");
            checkExpert();
            return;
        }
        System.out.print(nom + "(" + this.getPosition().getX() + "," + this.getPosition().getY() + ") :");
        //l'unité essaye de consomer la ressource sur laquelle elle est.
        if(this.getPosition().consomerRessource(this.getOutil(),this.isExpert())){
            levelUp();
        }
        else {
            checkExpert();
        }

    }
    @Override
    public void afficher() {
        System.out.println(" - Unite "+ nom +" " +getOutil().getTypeTravail().getSymbole()+ ":");
        System.out.println("     - Niveau d'outil : " + this.getOutil().getNiveau());
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
            this.setVitesse(this.getVitesse()+1);
        }
    }

    public void checkExpert(){
        if (isExpert()){
            fatigue++;
            if (fatigue == 3){
                System.out.println(nom + " devient une unité simple");
                this.expert = false;
                this.exp = 0;
                this.setVitesse(1);
                this.setCout(1);
            }
        }
    }

    @Override
    public int getCout() {
        return this.isExpert() ? this.cout*2 : this.cout;
    }
}
