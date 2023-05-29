package main;

public enum TypeRessource {
    BOIS(7,"B","du bois"),
    OR(8,"O","de l'or"),
    PIERRE(5, "P","de la pierre"),
    NOURRITURE(30,"N","de la nourriture"),
    RIEN(0," ",""),
    ;

    private final int tailleMax;
    private final String symbole;
    private final String recolte;

    TypeRessource( int tailleMax, String symbole, String recolte) {
        this.tailleMax = tailleMax;
        this.symbole = symbole;
        this.recolte = recolte;
    }

    public int getTailleMax() {
        return this.tailleMax;
    }

    public String getSymbole() {
        return symbole;
    }

    public String getRecolte() {
        return recolte;
    }
}

