package main.Batiment;

public class PrixEnRessources {
    private int prixBois;
    private int prixPierre;
    private int prixOr;
    private int prixNourriture;

    public PrixEnRessources(int prixBois, int prixPierre, int prixOr, int prixNourriture) {
        this.prixBois = prixBois;
        this.prixPierre = prixPierre;
        this.prixOr = prixOr;
        this.prixNourriture = prixNourriture;
    }

    public int getPrixBois() {
        return prixBois;
    }

    public int getPrixPierre() {
        return prixPierre;
    }

    public int getPrixOr() {
        return prixOr;
    }

    public int getPrixNourriture() {
        return prixNourriture;
    }
}

