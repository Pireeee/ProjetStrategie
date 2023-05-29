package main.unite;
import main.*;

public abstract class UniteAbstract extends Produit {
    public String nom;
    private int vitesse;
    int cout;
    private Case position;
    private Outil outil;
    private int deplacementsRestants = 0;
    private boolean nourie = false;

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
            System.out.println(nom + " est sur une bonne ressource il ne se déplace pas");
            return;
        }
        Case ressourceLaPlusProche = ressouceLaPlusProche(this.getOutil().getTypeRessource());
        if (ressourceLaPlusProche == null) {
            System.out.println(nom + " ne peut pas se déplacer car il n'y a plus de ressource adéquate ");
            return;
        }
        while (this.getDeplacementsRestants() > 0) {
            if (this.getPosition().equals(ressourceLaPlusProche)) {
                return;

            }
            this.deplacerDeUnVersDirection(cheminLePlusCourt(ressourceLaPlusProche));
        }
    }

    public void deplacerDeUnVersDirection(Direction direction) {
        int x = this.getX();
        int y = this.getY();
        switch (direction) {
            case HAUT -> {
                if (x < 0) {
                    System.out.println(nom + " ne peut pas se déplacer car il est en haut de la carte");
                    return;
                }
                x--;
            }
            case BAS -> {
                if (x >= Carte.getInstance().getX()) {
                    System.out.println(nom + " ne peut pas se déplacer car il est en bas de la carte");
                    return;
                }
                x++;
            }
            case GAUCHE -> {
                if (y < 0) {
                    System.out.println(nom + " ne peut pas se déplacer car il est à gauche de la carte");
                    return;
                }
                y--;
            }
            case DROITE -> {
                if (y >= Carte.getInstance().getY()) {
                    System.out.println(nom + " ne peut pas se déplacer car il est à droite de la carte");
                    return;
                }
                y++;
            }
        }
        Case caseDestination = Carte.getInstance().getCase(x, y);
        if (caseDestination.aUneUnite()) {
            System.out.println(nom + " ne peut pas se déplacer car il y a une unité sur la case de destination");
        }
        else {
            //il n'y a pas d'unité
            this.teleporter(x, y);
            this.deplacementsRestants--;
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
        System.out.println(nom +" "+getOutil().getTypeTravail().getSymbole()+ " : je me suis déplacé en ("+x+","+y+")");
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

    public int getCout() {
        return this.cout;
    }
    public void setCout(int cout) {
        this.cout = cout;
    }
    public void initDeplacementsRestants(){
        this.deplacementsRestants = this.getVitesse();
    }
    public void finDeplacement(){
        this.deplacementsRestants = 0;
    }
    public int getDeplacementsRestants(){
        return this.deplacementsRestants;
    }



}

