package main.batiment;

import main.*;
import main.unite.UniteAbstract;
import main.unite.UniteSimple;

import java.util.Random;

public class UsineUnite extends Batiment{

        public UsineUnite() {
            super();
        }
        public UsineUnite Créer(TypeTravail typeTravail){
            Inventaire inventaire = Inventaire.getInstance();
            if (inventaire.peuxCréer(typeTravail)){
                inventaire.retirerRessource(TypeRessource.BOIS,typeTravail.getPrixEnRessources().getPrix(TypeRessource.BOIS));
                inventaire.retirerRessource(TypeRessource.PIERRE,typeTravail.getPrixEnRessources().getPrix(TypeRessource.PIERRE));
                inventaire.retirerRessource(TypeRessource.OR,typeTravail.getPrixEnRessources().getPrix(TypeRessource.OR));
                inventaire.retirerRessource(TypeRessource.NOURRITURE,typeTravail.getPrixEnRessources().getPrix(TypeRessource.NOURRITURE));
                return new UsineUnite();
            }
            else {
                System.out.println("Vous n'avez pas assez de ressources pour créer cette Usine");
                return null;
            }
        }

        public void CréerProduit(){
            Carte carte = Carte.getInstance();
            UniteSimple unite = new UniteSimple("test", TypeTravail.FERMIER);
        }
}
