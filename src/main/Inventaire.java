package main;

import main.batiment.PrixEnRessources;

import java.util.HashMap;
import java.util.Map;

public class Inventaire {

    private Map<TypeRessource,Integer> ressources;
    private static Inventaire instance;

    public static Inventaire getInstance() {
        if (instance == null)
            instance = new Inventaire();
        return instance;
    }
    private Inventaire() {
        this.ressources = new HashMap<TypeRessource,Integer>();
        this.ressources.put(TypeRessource.NOURRITURE,0);
        this.ressources.put(TypeRessource.OR,0);
        this.ressources.put(TypeRessource.BOIS,0);
        this.ressources.put(TypeRessource.PIERRE,0);
    }

    public void ajouterRessource(TypeRessource typeRessource, int quantite){
        ressources.put(typeRessource,ressources.get(typeRessource)+quantite);
    }
    public void retirerRessource(TypeRessource typeRessource, int quantite){
        ressources.put(typeRessource,ressources.get(typeRessource)-quantite);
    }
    public boolean possedeRessource(TypeRessource typeRessource, int quantite){
        return ressources.get(typeRessource) >= quantite;
    }
    public int get(TypeRessource typeRessource){
        return ressources.get(typeRessource);
    }
    public void afficher(){
        System.out.println("Inventaire :");
        for (TypeRessource typeRessource : TypeRessource.values()) {
            if (typeRessource != TypeRessource.RIEN){
                System.out.println(" - "+typeRessource + " : " + this.get(typeRessource));
            }
        }
    }
    public boolean peuxCréer(TypeTravail typeTravail){
        PrixEnRessources prix = typeTravail.getPrixEnRessources();
        return this.possedeRessource(TypeRessource.BOIS,prix.getPrix(TypeRessource.BOIS)) &&
                this.possedeRessource(TypeRessource.PIERRE,prix.getPrix(TypeRessource.PIERRE)) &&
                this.possedeRessource(TypeRessource.OR,prix.getPrix(TypeRessource.OR)) &&
                this.possedeRessource(TypeRessource.NOURRITURE,prix.getPrix(TypeRessource.NOURRITURE));
    }
}
