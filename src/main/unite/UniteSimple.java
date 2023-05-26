package main.unite;

import main.*;

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
        this.getPosition().consomerRessource(outil);
        if (exp<5)
            exp++;
        else {
            expert = true;
            this.getPosition().consomerRessource(outil);
        }

    }
    @Override
    public void deplacer(){
        this.cheminLePlusCourt(this.ressouceLaPlusProche(this.outil.getTypeRessource()));
    }

    @Override
    public void afficher() {
        System.out.println("    Unite "+ nom + ":");
        outil.afficher();
        System.out.println("     - Expert : " + expert);
        System.out.println("     - Monté : " + monte);
        System.out.println("     - Expérience : " + exp);
        System.out.println("     - Vitesse : " + this.getVitesse());
    }

    public void deplacer(Direction direction) {
        int x = this.getX();
        int y = this.getY();
        switch (direction) {
            case HAUT -> y--;
            case BAS -> y++;
            case GAUCHE -> x--;
            case DROITE -> x++;
        }
        this.teleporter(x, y);
    }

    public Case ressouceLaPlusProche(TypeRessource[] typeRessources){
        Case caseRessource = null;
        int distanceMin = 1000000;
        for(int i = 0; i < Carte.getInstance().getX(); i++){
            for(int j = 0; j < Carte.getInstance().getY(); j++){
                for (TypeRessource typeRessource : typeRessources) {
                    if (Carte.getInstance().get(i, j).getRessource() != null && Carte.getInstance().get(i, j).getTypeRessource() == typeRessource) {
                        int distance = Math.abs(this.getX() - i) + Math.abs(this.getY() - j);
                        if (distance < distanceMin) {
                            distanceMin = distance;
                            caseRessource = Carte.getInstance().get(i, j);
                        }
                    }
                }
            }
        }
        return caseRessource;
    }

    public void cheminLePlusCourt(Case destination){
        int x = this.getX();
        int y = this.getY();
        int xDestination = destination.getX();
        int yDestination = destination.getY();
        int xDistance = xDestination - x;
        int yDistance = yDestination - y;
        if (xDistance > 0){
            this.deplacer(Direction.DROITE);
        }
        else if (xDistance < 0){
            this.deplacer(Direction.GAUCHE);
        }
        else if (yDistance > 0){
            this.deplacer(Direction.BAS);
        }
        else if (yDistance < 0){
            this.deplacer(Direction.HAUT);
        }
    }
}
