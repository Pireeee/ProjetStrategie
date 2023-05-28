package main.Batiment;

public class BatimentProductionFactory {
    private TypeBatiment type;
    private PrixEnRessources prixEnRessources;
    private int intervalParUnite;
    private int coutUnite;

    public BatimentProductionFactory() {

    }


    public static class Builder {
        private TypeBatiment type;
        private PrixEnRessources prixEnRessources;
        private int intervalParUnite;
        private int coutUnite;

        public Builder creationBatiment(TypeBatiment type, PrixEnRessources prix, int interval, int coutUnite) {
            this.type = type;
            this.prixEnRessources = prix;
            this.intervalParUnite = interval;
            this.coutUnite = coutUnite;
            return this;
        }

        public BatimentProductionFactory build() {
            return new BatimentProductionFactory(this);
        }
    }

    private BatimentProductionFactory(Builder builder) {
        this.type = builder.type;
        this.prixEnRessources = builder.prixEnRessources;
        this.intervalParUnite = builder.intervalParUnite;
        this.coutUnite = builder.coutUnite;
    }

    public TypeBatiment getType() {
        return type;
    }

    public PrixEnRessources getPrixEnRessources() {
        return prixEnRessources;
    }

    public int getIntervalParUnite() {
        return intervalParUnite;
    }

    public int getCoutUnite() {
        return coutUnite;
    }
}

