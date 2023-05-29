package main;

import main.batiment.Batiment;
import main.batiment.TypeBatiment;
import main.unite.UniteAbstract;
import main.unite.UniteSimple;

import java.util.*;

public class Main {
    private final Carte carte = Carte.getInstance(10, 10);
    private final Inventaire inventaire = Inventaire.getInstance();
    private int nbTour = 0;
    private List<UniteAbstract> unites = new ArrayList<>();
    private Main() {
        //ajoute 10 de chaque ressource
        for (TypeRessource typeRessource : TypeRessource.values()) {
            if (typeRessource != TypeRessource.RIEN)
                inventaire.ajouterRessource(typeRessource, 10);
        }
        //ajoute 20 nourritures
        inventaire.ajouterRessource(TypeRessource.NOURRITURE,  20);
    }

    private void run() {
        UniteSimple raf = new UniteSimple("Raphael",TypeTravail.FERMIER);
        UniteSimple max = new UniteSimple("Maximilien",TypeTravail.MINEUR);
        UniteSimple bebou = new UniteSimple("Henri",TypeTravail.BUCHERON);
        boucle();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void questionMenuPrincipal(){
        System.out.println("");
        System.out.println("Que voulez-vous faire ? [1-5]");
        System.out.println(" - Afficher Inventaire : [1] ");
        System.out.println(" - Afficher Carte : [2] ");
        System.out.println(" - Afficher une Case/Unitée : [3] ");
        System.out.println(" - Faire un tour de jeu : [4] ");
        System.out.println(" - Quitter : [5] ");
    }
    public void menuTour(){
        carte.afficher();
        StringBuilder menu = new StringBuilder();
        menu.append("Tour n°").append(nbTour)
                .append("\n")
                .append(" Nombre de déplacements restants :\n");
        for (UniteAbstract unite : unites) {
            menu.append(" - ")
                    .append(unite.nom)
                    .append(" ")
                    .append(unite.getOutil().getTypeTravail().getSymbole())
                    .append(" : ")
                    .append(unite.getDeplacementsRestants())
                    .append("\n");
        }
        menu.append("\n")
            .append("Que voulez-vous faire ? [1-3]\n")
            .append(" - Déplacer une unité Manuellent : [1] \n")
            .append(" - Lancer le déplacement automatique de toutes les unités vers les ressources appropriés les plus proches : [2] \n")
            .append(" - Finir le tour (faire travailler les unités sur leurs cases) : [3] \n");
        System.out.println(menu.toString());
    }

    public void boucle(){
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        questionMenuPrincipal();

        while (true) {
            reponse = scanner.nextLine().toLowerCase();
            clearConsole();
            if (reponse.equals("1")) {
                inventaire.afficher();
                questionMenuPrincipal();
            } else if (reponse.equals("2")) {
                carte.afficher();
                questionMenuPrincipal();

            } else if (reponse.equals("3")) {
                carte.afficher();
                System.out.println("Quelle case voulez-vous afficher ? [x,y]");
                try {
                    String[] coord = scanner.nextLine().split(",");
                    int x = Integer.parseInt(coord[0]);
                    int y = Integer.parseInt(coord[1]);
                    carte.getCase(x,y).afficher();
                    questionMenuPrincipal();
                }
                catch (Exception e){
                    System.err.println("Veuillez entrer des coordonnées valides, retour au menu");
                    questionMenuPrincipal();
                }
            } else if (reponse.equals("4")) {
                nbTour++;
                tour();
                questionMenuPrincipal();
            } else if (reponse.equals("5")) {
                    break;
            } else {
                questionMenuPrincipal();
                System.err.println("Veuillez entrer un nombre entre 1 et 4");
            }
        }
        System.out.println("Vous avez joué "+nbTour+" tours");
        scanner.close();
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    private void tour(){
        //initialisation des déplacements des unités
        for(int i = 0; i < carte.getX(); i++){
            for(int j = 0; j < carte.getY(); j++){
                if(carte.getCase(i,j).getUnite() != null) {
                    carte.getCase(i, j).getUnite().initDeplacementsRestants();
                    unites.add(carte.getCase(i, j).getUnite());
                }
            }
        }
        System.out.println("Début du Tour n°"+nbTour+" :");
        // phase de tour, on demande au joueur de faire ses actions
        Scanner scannerTour = new Scanner(System.in);
        String reponseTour = "";
        menuTour();
        boolean tour = true;
        while(tour) {
            reponseTour = scannerTour.nextLine().toLowerCase();
            clearConsole();
            switch (reponseTour) {
                case "1":
                    carte.afficher();
                    System.out.println("Quelle unité voulez-vous déplacer ? [x,y,{Haut,Bas,Gauche,Droite}] (ex: 1,2,Haut)");
                    String[] coord = scannerTour.nextLine().split(",");
                    int x = Integer.parseInt(coord[0]);
                    int y = Integer.parseInt(coord[1]);
                    if (coord[2].equalsIgnoreCase("haut"))
                        carte.getCase(x, y).getUnite().deplacerDeUnVersDirection(Direction.HAUT);
                    else if (coord[2].equalsIgnoreCase("has"))
                        carte.getCase(x, y).getUnite().deplacerDeUnVersDirection(Direction.BAS);
                    else if (coord[2].equalsIgnoreCase("gauche"))
                        carte.getCase(x, y).getUnite().deplacerDeUnVersDirection(Direction.GAUCHE);
                    else if (coord[2].equalsIgnoreCase("droite"))
                        carte.getCase(x, y).getUnite().deplacerDeUnVersDirection(Direction.DROITE);
                    else
                        System.out.println("Vos coordonés ou Votre direction ne sont pas valides, retour au menu du tour");
                        menuTour();
                    break;
                case "2":
                    carte.deplacerUnite();
                    menuTour();
                    break;
                case "3":
                    carte.travailler();
                    tour = false;
                    break;
                default:
                    System.out.println("Veuillez entrer un nombre entre 1 et 3");
                    menuTour();
            }
            updateListUnite();
        }
        System.out.println("Fin du tour n°"+nbTour);
    }
    public void updateListUnite(){
        unites.clear();
        for(int i = 0; i < carte.getX(); i++){
            for(int j = 0; j < carte.getY(); j++){
                if(carte.getCase(i,j).getUnite() != null)
                    unites.add(carte.getCase(i,j).getUnite());
            }
        }
    }

    public List<UniteAbstract> nourrirUnites(){
        List<UniteAbstract> unitesFaim = new ArrayList<>();
        for(UniteAbstract unite : unites){
            int faim = unite.getCout();
            if (!inventaire.possedeRessource(TypeRessource.NOURRITURE,faim)){
                System.out.println(unite.nom + " n'a pas assez de nourriture pour travailler");
                unitesFaim.add(unite);
            }
            else{
                inventaire.retirerRessource(TypeRessource.NOURRITURE,faim);
            }
        }
        return unitesFaim;
    }
}