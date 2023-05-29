package main.Batiment;

public class BatimentFactory extends Batiment {
    public BatimentFactory(TypeBatiment type, PrixEnRessources prixEnRessources) {
        super(type, prixEnRessources);
    }

    public Batiment creationBatiment() {
        return new Batiment(getTypeBatiment(), getPrixEnRessources());
    }
}

