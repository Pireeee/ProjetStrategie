public class Carte {
    public int largeur;
    public int hauteur;
    public Case[][] cases;

    public Carte(int largeur, int hauteur, Case[][] cases) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.cases = cases;
    }
}
