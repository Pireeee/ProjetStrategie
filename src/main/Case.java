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


}


