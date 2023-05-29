package main.batiment;

public enum TypeBatiment {
    BUCHERONS(new PrixEnRessources.Builder().prixBois(10).prixOr(5).build()),
    MINEURS(new PrixEnRessources.Builder().prixPierre(10).prixOr(5).build()),
    PAYSANS(new PrixEnRessources.Builder().prixNouriture(10).prixOr(5).build()),
    OUTILS_BUCHERONS(new PrixEnRessources.Builder().prixBois(10).prixOr(5).build()),
    OUTILS_MINEURS(new PrixEnRessources.Builder().prixPierre(10).prixOr(5).build()),
    OUTILS_PAYSANS(new PrixEnRessources.Builder().prixNouriture(10).prixOr(5).build());

    private final PrixEnRessources prixEnRessources;

    TypeBatiment(PrixEnRessources prixEnRessources) {
        this.prixEnRessources = prixEnRessources;
    }

    public PrixEnRessources getPrixEnRessources() {
        return prixEnRessources;
    }
}

