package main.Batiment;

public class BatimentCreation extends Batiment {
    private int intervalProduction;

    public BatimentCreation(TypeBatiment type, PrixEnRessources prixEnRessources, int intervalProduction) {
        super(type, prixEnRessources);
        this.intervalProduction = intervalProduction;
    }

    public int getIntervalProduction() {
        return intervalProduction;
    }
}

