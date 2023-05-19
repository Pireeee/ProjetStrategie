package main;

public class Outil {
    public int niveau;
    public TypeTravail type;

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
}
