import static java.lang.Math.random;

public class Ressource {
    public TypeRessource type;
    public int quantite;

    public Ressource(TypeRessource type) {
        this.type = type;
        this.quantite = (int) (random()*10);
    }


}
