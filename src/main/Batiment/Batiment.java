package main.Batiment;
import main.Case;

public class Batiment {
    private TypeBatiment type;
    private PrixEnRessources prixEnRessources;
    private Case position;

    public Batiment(TypeBatiment type, PrixEnRessources prixEnRessources, Case position) {
        this.type = type;
        this.prixEnRessources = prixEnRessources;
        this.position = position;
    }

    public Batiment(TypeBatiment type, PrixEnRessources prixEnRessources) {
    }

    public TypeBatiment getTypeBatiment() {
        return type;
    }

    public PrixEnRessources getPrixEnRessources() {
        return prixEnRessources;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    // Ajoutez d'autres méthodes spécifiques aux bâtiments si nécessaire
}


