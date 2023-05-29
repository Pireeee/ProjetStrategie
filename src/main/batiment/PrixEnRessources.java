package main.batiment;

import main.TypeRessource;
import java.util.HashMap;
import java.util.Map;

public class PrixEnRessources {
    private Map<TypeRessource, Integer> prix;

    public static class Builder {
        private Map<TypeRessource, Integer> prix;

        public Builder() {
            prix = new HashMap<>();
        }

        public Builder prixBois(int prixBois) {
            prix.put(TypeRessource.BOIS, prixBois);
            return this;
        }

        public Builder prixPierre(int prixPierre) {
            prix.put(TypeRessource.PIERRE, prixPierre);
            return this;
        }

        public Builder prixOr(int prixOr) {
            prix.put(TypeRessource.OR, prixOr);
            return this;
        }

        public Builder prixNouriture(int prixNouriture) {
            prix.put(TypeRessource.NOURRITURE, prixNouriture);
            return this;
        }

        public PrixEnRessources build() {
            return new PrixEnRessources(this);
        }
    }

    private PrixEnRessources(Builder builder) {
        prix = builder.prix;
    }

    public int getPrix(TypeRessource typeRessource) {
        return prix.getOrDefault(typeRessource, 0);
    }
}

