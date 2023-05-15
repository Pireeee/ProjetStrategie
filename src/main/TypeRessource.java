package main;

public enum TypeRessource {
    BOIS(12,3),
    OR(1,1),
    PIERRE(1,1),
    NOURRITURE(1,1),
    ;
    private final float chance;
    private final int tailleMax;

    TypeRessource(float chance, int tailleMax) {
        this.chance = chance;
        this.tailleMax = tailleMax;
    }

    public float getChance() {
        return this.chance;
    }

    public int getTailleMax() {
        return this.tailleMax;
    }
}

