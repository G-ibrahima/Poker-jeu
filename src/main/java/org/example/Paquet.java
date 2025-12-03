package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {

    private ArrayList<Carte> cartes = new ArrayList<>();

    public Paquet() {

        String[] valeurs = {"A","2","3","4","5","6","7","8","9","10","V","D","R"};
        String[] sortes = {"♣","♦","♥","♠"};

        for (String s : sortes) {
            for (String v : valeurs) {
                cartes.add(new Carte(v, s));
            }
        }
    }

    // Mélanger le paquet
    public void melanger() {
        Collections.shuffle(cartes);
    }

    // Tirer une carte (enlever la première du paquet)
    public Carte tirerCarte() {
        return cartes.remove(0);
    }

    // Juste pour vérifier le nombre de cartes
    public int nombreCartes() {
        return cartes.size();
    }
}
