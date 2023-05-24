package main;

import com.sun.source.tree.WhileLoopTree;
import main.unite.UniteAbstract;
import main.unite.UniteSimple;

import java.util.*;

public class Main {
    private final Carte carte = Carte.getInstance(10, 10);
    private final Inventaire inventaire = Inventaire.getInstance();
    private int tour = 0;
    private Main() {
        //ajoute 10 de chaque ressource
        for (TypeRessource typeRessource : TypeRessource.values()) {
            inventaire.ajouterRessource(typeRessource, 10);
        }
        //ajoute 20 nourritures
        inventaire.ajouterRessource(TypeRessource.NOURRITURE,  20);
    }

    private void run() {
        UniteSimple raf = new UniteSimple("Raphael",TypeTravail.FERMIER,carte.get(2,3));
        carte.get(raf.getX(),raf.getY()).setUnite(raf);
        boucle();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void question(){
        System.out.println("");
        System.out.println("Que voulez-vous faire ? [1-5]");
        System.out.println(" - Afficher Inventaire : [1] ");
        System.out.println(" - Afficher Carte : [2] ");
        System.out.println(" - Faire un tour de jeu : [3] ");
        System.out.println(" - Afficher une Case : [4] ");
        System.out.println(" - Quitter : [5] ");
    }

    public void boucle(){
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        question();

        while (true) {
            reponse = scanner.nextLine().toLowerCase();
            clearConsole();
            if (reponse.equals("1")) {
                inventaire.afficher();
                question();
            } else if (reponse.equals("2")) {
                carte.afficher();
                question();
            } else if (reponse.equals("3")) {
                tour++;
                tour();
                question();
            } else if (reponse.equals("4")) {
                carte.afficher();
                System.out.println("Quelle case voulez-vous afficher ? [x,y]");
                String[] coord = scanner.nextLine().split(",");
                int x = Integer.parseInt(coord[0]);
                int y = Integer.parseInt(coord[1]);
                carte.get(x,y).afficher();
                question();

            } else if (reponse.equals("5")) {
                    break;
            } else {
                System.out.println("Veuillez entrer un nombre entre 1 et 4");
            }
        }
        System.out.println("Vous avez joué "+tour+" tours");
        scanner.close();
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    private void tour(){
        System.out.println("Début du Tour n°"+tour+" :");
        System.out.println("");
        System.out.println("Phase de travail :");
        carte.travailler();
        System.out.println("");
        System.out.println("Phase de déplacement :");
        carte.deplacer();
        System.out.println("");
        System.out.println("Fin du tour n°"+tour);
    }

    private void tour(int nbTour){
        for (int i = 0; i < nbTour; i++) {
            System.out.println("Tour n°"+(i+1)+":");
            tour();
            System.out.println("");
        }
    }
}