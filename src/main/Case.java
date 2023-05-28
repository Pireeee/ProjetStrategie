package main;
import main.unite.UniteAbstract;

import java.util.Random;

import static main.TypeRessource.RIEN;

public class Case {
    private final int x;
    private final int y;
    private Ressource ressource;
    private UniteAbstract unite;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        Random rand = new Random();
        if (rand.nextInt(3) == 0) {
            this.ressource = new Ressource(TypeRessource.values()[rand.nextInt(TypeRessource.values().length)]);
        }
        else {
            this.ressource= new Ressource(RIEN);
        }
    }

    public boolean consomerRessource(Outil outil, boolean expert){
        if (ressource == null||ressource.type == RIEN) {
            System.out.println("Pas de ressource");
            return false;
        }
        if(outil.estBonOutil(ressource.type)) {
            this.checkRessource();
            int forceDeTravail = expert ? outil.getNiveau()*2 : outil.getNiveau();
            ressource.quantite -= forceDeTravail;
            System.out.println("j'ai récolté "+ ressource.type.getRecolte() +", il en reste " + ressource.quantite);
            Inventaire.getInstance().ajouterRessource(ressource.type, forceDeTravail);
            this.checkRessource();
            outil.ameliorer();
        }
        else {
            System.out.println("Mauvais outil");
        }
        return true;
    }

    public void afficher(){
        System.out.println("Case ("+this.x+","+this.y+"): ");
        System.out.println(" - Ressource : "+ressource.type+" ("+ressource.quantite+")");
        if (unite != null)
            this.unite.afficher();
    }

    public boolean aUneUnite() {
        return this.unite != null;
    }

    public void checkRessource(){
        if (ressource.quantite <= 0) {
            ressource = new Ressource(RIEN);
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Ressource getRessource() {
        return this.ressource;
    }

    public UniteAbstract getUnite() {
        return this.unite;
    }

    public void setUnite(UniteAbstract unite){
        this.unite = unite;
    }

    public TypeRessource getTypeRessource() {
        return this.ressource.type;
    }

}


