package main;

public class Outil extends Produit {
    private int niveau;
    private TypeTravail type;

    public Outil(TypeTravail typeTravail) {
        this.type = typeTravail;
        this.niveau = 1;
    }
    public boolean estBonOutil(TypeRessource typeRessource){
        return type.estBonOutil(typeRessource);
    }
    public TypeRessource[] getTypeRessource() {
        return type.getTypeRessource();
    }
    public void afficher(){
        System.out.println("    - Travail :");
        System.out.println("        . Type : " + this.type);
        System.out.println("        . Niveau d'experience de l'outil: " + this.niveau);
    }
    public void ameliorer(){
        if (this.niveau < 10){
            this.niveau++;
        }
    }
    public int getNiveau() {
        return niveau;
    }
    public TypeTravail getTypeTravail() {
        return type;
    }
}
