package main.Batiment;

public class BatimentCreationFactory extends BatimentFactory {
    private TypeBatiment type;
    private PrixEnRessources prixEnRessources;
    private int interval;
    private int coutEnRessource;

    public BatimentCreationFactory(TypeBatiment type, PrixEnRessources prixEnRessources, int interval, int coutEnRessource) {
        this.type = type;
        this.prixEnRessources = prixEnRessources;
        this.interval = interval;
        this.coutEnRessource = coutEnRessource;
    }

    public TypeBatiment getType() {
        return type;
    }

    public PrixEnRessources getPrixEnRessources() {
        return prixEnRessources;
    }

    public int getInterval() {
        return interval;
    }

    public int getCoutEnRessource() {
        return coutEnRessource;
    }

    public TypeBatiment method() {
        return getType();
    }
}

