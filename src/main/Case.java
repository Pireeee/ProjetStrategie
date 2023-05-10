package main;
import java.util.Random;

import static java.lang.Math.random;

public class Case {
    public int x;
    public int y;
    public Ressource ressource;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        Random rand = new Random();
        if (rand.nextInt(3) == 0) {
            this.ressource = new Ressource(TypeRessource.values()[rand.nextInt(TypeRessource.values().length)]);
        }
    }
    public void consomerRessource(Outil outil){
        if (ressource != null) {
            if(outil.estBonOutil(ressource.type)) {
                ressource.quantite--;
                System.out.println("Ressource consomée, il en reste " + ressource.quantite);
            }
            else {
                System.out.println("Mauvais outil");
                return;
            }
        }
        else
            System.out.println("Pas de ressource");
    }


}


