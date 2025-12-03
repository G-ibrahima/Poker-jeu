package org.example;

import java.util.ArrayList;

public class MainJoueur {

    private ArrayList<Carte> cartes = new ArrayList<>();

    // Ajouter une carte à la main (max 5)
    public void ajouterCarte(Carte c) {
        if (cartes.size() < 5) {
            cartes.add(c);
        }
    }

    // Afficher les cartes de la main
    public void afficher() {
        for (Carte c : cartes) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Connaître le nombre de cartes
    public int nombreCartes() {
        return cartes.size();
    }
}
