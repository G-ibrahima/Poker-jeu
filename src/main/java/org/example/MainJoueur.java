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

    public String evaluerMain() {

        int compteur = 0;

        for (int i = 0; i < cartes.size(); i++) {
            for (int j = i + 1; j < cartes.size(); j++) {

                // Si deux cartes ont la même valeur = PAIRE
                if (cartes.get(i).getValeur().equals(cartes.get(j).getValeur())) {
                    compteur++;
                }
            }
        }

        if (compteur == 1)
            return "Paire";
        else if (compteur == 3)
            return "Double paire";
        else if (compteur == 6)
            return "Brelan ou mieux";

        return "Aucune combinaison";
    }

}
