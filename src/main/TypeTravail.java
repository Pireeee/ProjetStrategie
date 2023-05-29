package main;

import main.batiment.PrixEnRessources;

import java.util.Arrays;

public enum TypeTravail {
    FERMIER(new PrixEnRessources.Builder().prixNouriture(10).prixOr(5).build(),"👨‍🌾",TypeRessource.NOURRITURE),
    BUCHERON(new PrixEnRessources.Builder().prixBois(10).prixOr(5).build(),"🪓",TypeRessource.BOIS),
    MINEUR(new PrixEnRessources.Builder().prixPierre(10).prixOr(5).build(),"⛏",TypeRessource.OR,TypeRessource.PIERRE),
    ;
    private final PrixEnRessources prixEnRessources;
    private final String symbole;
    private final TypeRessource[] typeRessource;

    TypeTravail(PrixEnRessources prixEnRessources, String symbole,TypeRessource... typeRessource) {
        this.prixEnRessources = prixEnRessources;
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

    public PrixEnRessources getPrixEnRessources() {
        return prixEnRessources;
    }
}
