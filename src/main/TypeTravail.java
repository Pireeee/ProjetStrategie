package main;

import java.util.Arrays;

public enum TypeTravail {
    FERMIER("👨‍🌾",TypeRessource.NOURRITURE),
    BUCHERON("🪓",TypeRessource.BOIS),
    MINEUR("⛏",TypeRessource.OR,TypeRessource.PIERRE),
    ;
    private final String symbole;
    private final TypeRessource[] typeRessource;

    TypeTravail(String symbole,TypeRessource... typeRessource) {
        this.symbole = symbole;
        this.typeRessource = typeRessource;
    }

    public boolean estBonOutil(TypeRessource typeRessource){
        return Arrays.stream(this.typeRessource).anyMatch(typeRessource1 -> typeRessource1 == typeRessource);
    }

    public TypeRessource[] getTypeRessource() {
        return typeRessource;
    }
    public String getSymbole() {
        return symbole;
    }
}
