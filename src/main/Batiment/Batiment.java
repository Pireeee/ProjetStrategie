package main.Batiment;

public class Batiment {
    public TypeBatiment type;
    public PrixEnRessources prixEnRessources;

    public Batiment(TypeBatiment type, PrixEnRessources prixEnRessources) {
        this.type = type;
        this.prixEnRessources = prixEnRessources;
    }

    public TypeBatiment getTypeBatiment() {
        return type;
    }

    public PrixEnRessources getPrixEnRessources() {
        return prixEnRessources;
    }
}

