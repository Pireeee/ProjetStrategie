package main.Batiment;

public class BatimentProduction extends Batiment {
    private int intervalProduction;

    public BatimentProduction(TypeBatiment type, PrixEnRessources prixEnRessources, int intervalProduction) {
        super(type, prixEnRessources);
        this.intervalProduction = intervalProduction;
    }

    public int getIntervalProduction() {
        return intervalProduction;
    }
}

