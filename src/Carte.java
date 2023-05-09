public class Carte {
    public int largeur;
    public int hauteur;
    public Case[][] cases;

    public Carte(int largeur, int hauteur, Case[][] cases) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.cases = cases;
    }
    public void afficher(){
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                System.out.print("[");
                if (this.cases[i][j].ressource == null)
                    System.out.print("0");
                else{
                    switch (this.cases[i][j].ressource.type) {
                        case NOURRITURE:
                            System.out.print("N");
                            break;
                        caseBOIS:
                            System.out.print("B");
                            break;
                        case OR:
                            System.out.print("O");
                            break;
                        case PIERRE:
                            System.out.print("P");
                            break;
                    }
                }
                System.out.println("]");
            }
            System.out.println("\n");
        }
    }
}
