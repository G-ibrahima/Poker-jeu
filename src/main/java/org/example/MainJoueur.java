package org.example;

import java.util.ArrayList;
import java.util.Collections;

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

        if (estUneCouleur() && estUneSuite()) {
            return "Quinte Flush";
        }

        if (estUneCouleur()) {
            return "Couleur (Flush)";
        }

        if (estUneSuite()) {
            return "Suite (Straight)";
        }

        int compteur = 0;

        for (int i = 0; i < cartes.size(); i++) {
            for (int j = i + 1; j < cartes.size(); j++) {
                if (cartes.get(i).getValeur().equals(cartes.get(j).getValeur())) {
                    compteur++;
                }
            }
        }

        if (compteur == 1)
            return "Paire";
        else if (compteur == 2)
            return "Deux paires";
        else if (compteur == 3)
            return "Brelan";
        else if (compteur == 6)
            return "Carré";

        return "Aucune combinaison";
    }


    // Vérifier s'il y a une couleur (Flush)
    public boolean estUneCouleur() {

        if (cartes.size() != 5) return false;

        String sorteDeReference = cartes.get(0).getSorte();

        for (Carte c : cartes) {
            if (!c.getSorte().equals(sorteDeReference)) {
                return false;
            }
        }

        return true;
    }
    // Vérifier si les cartes forment une suite
    public boolean estUneSuite() {
        if (cartes.size() != 5) return false;

        // Transformer les valeurs en nombres
        ArrayList<Integer> valeurs = new ArrayList<>();

        for (Carte c : cartes) {
            valeurs.add(convertirValeur(c.getValeur()));
        }

        Collections.sort(valeurs);

        for (int i = 0; i < valeurs.size() - 1; i++) {
            if (valeurs.get(i + 1) - valeurs.get(i) != 1) {
                return false;
            }
        }

        return true;
    }

    private int convertirValeur(String v) {
        return switch (v) {
            case "A" -> 14;
            case "R" -> 13;
            case "D" -> 12;
            case "V" -> 11;
            default -> Integer.parseInt(v);
        };
    }

}
