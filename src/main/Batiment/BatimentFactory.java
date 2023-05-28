package main.Batiment;

public class BatimentFactory extends BatimentProductionFactory {
    public BatimentFactory() {
        super();
    }

    public Batiment creationBatiment() {
        return new Batiment(getType(), getPrixEnRessources());
    }
}
