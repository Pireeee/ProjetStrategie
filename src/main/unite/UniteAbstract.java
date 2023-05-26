package main.unite;
import main.*;

public abstract class UniteAbstract {
    public String nom;
    private int vitesse;
    public int cout;
    private Case position;
    private Outil outil;

    public abstract void deplacerDeUnVersDirection();

    public abstract void afficher();

    public abstract void travailler();

    public Outil getOutil() {
        return outil;
    }

    public void setOutil(Outil outil) {
        this.outil = outil;
    }

    public void deplacer(){
        //regarde si il est sur une bonne case
        if(this.getOutil().estBonOutil(this.getPosition().getTypeRessource())){
            return;
        }
        Case ressourceLaPlusProche = ressouceLaPlusProche(this.getOutil().getTypeRessource());
        for (int i = 0; i < this.getVitesse(); i++) {
            this.deplacerDeUnVersDirection(cheminLePlusCourt(ressourceLaPlusProche));
        }
    }

    public void deplacerDeUnVersDirection(Direction direction) {
        int x = this.getX();
        int y = this.getY();
        switch (direction) {
            case HAUT -> y--;
            case BAS -> y++;
            case GAUCHE -> x--;
            case DROITE -> x++;
        }
        Case caseDestination = Carte.getInstance().getCase(x, y);
        if (caseDestination.aUneUnite()) {
            //il y a une unité
            if (caseDestination.getUnite().getOutil() == this.getOutil()) {
                //même outil
                if (caseDestination.getUnite().getClass().isInstance(UniteGroupe.class)) {
                    //il y a un groupe
                    UniteGroupe uniteGroupe = (UniteGroupe) caseDestination.getUnite();
                    uniteGroupe.addUnite(this);
                } else {
                    //il n'y a pas de groupe
                    UniteGroupe uniteGroupe = new UniteGroupe(this);
                    uniteGroupe.addUnite(caseDestination.getUnite());
                    uniteGroupe.teleporter(caseDestination.getX(), caseDestination.getY());
                }
            } else {
                System.out.println(nom+" ne peut pas aller sur la case ("+x+","+y+") car il y a une unité avec un outil différent");
            }
        }
        else {
            //il n'y a pas d'unité
            this.teleporter(x, y);
        }
    }

    public Case ressouceLaPlusProche(TypeRessource[] typeRessources){
        Case caseRessource = null;
        int distanceMin = 1000000;
        for(int i = 0; i < Carte.getInstance().getX(); i++){
            for(int j = 0; j < Carte.getInstance().getY(); j++){
                for (TypeRessource typeRessource : typeRessources) {
                    if (Carte.getInstance().getCase(i, j).getRessource() != null && Carte.getInstance().getCase(i, j).getTypeRessource() == typeRessource) {
                        int distance = Math.abs(this.getX() - i) + Math.abs(this.getY() - j);
                        if (distance < distanceMin) {
                            distanceMin = distance;
                            caseRessource = Carte.getInstance().getCase(i, j);
                        }
                    }
                }
            }
        }
        return caseRessource;
    }

    public Direction cheminLePlusCourt(Case destination){
        int x = this.getX();
        int y = this.getY();
        int xDestination = destination.getX();
        int yDestination = destination.getY();
        int xDistance = xDestination - x;
        int yDistance = yDestination - y;
        if (xDistance > 0){
            return Direction.DROITE;
        }
        else if (xDistance < 0){
            return Direction.GAUCHE;
        }
        else if (yDistance > 0){
            return Direction.BAS;
        }
        else if (yDistance < 0){
            return Direction.HAUT;
        }
        return null;
    }

    public void teleporter(int x, int y){
        Carte carte = Carte.getInstance();
        //on met l'unité dans la case de destination
        assert carte != null;
        carte.getCase(x,y).setUnite(this);
        carte.getCase(this.getX(),this.getY()).setUnite(null);
        //on met à jour les coordonnées de l'unité
        this.setPosition(carte.getCase(x,y));
        System.out.println(nom + ": je me suis déplacé en ("+x+","+y+")");
    }
    public void consomerNourriture(int cout) {
        Inventaire.getInstance().retirerRessource(TypeRessource.NOURRITURE, cout);
    }
    public Case getPosition() {
        return this.position;
    }
    public void setPosition(Case position) {
        this.position = position;
    }
    public int getX(){
        return this.position.getX();
    }
    public int getY(){
        return this.position.getY();
    }
    public int getVitesse() {
        return this.vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }





}

