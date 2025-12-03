package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

        if (cartes.size() != 5) {
            return "Main incomplète";
        }

        if (estUneCouleur() && estUneSuite()) {
            return "Quinte Flush";
        }

        if (estUnFull()) {
            return "Full House";
        }

        if (estUneCouleur()) {
            return "Couleur (Flush)";
        }

        if (estUneSuite()) {
            return "Suite (Straight)";
        }

        HashMap<String, Integer> compteur = new HashMap<>();

        for (Carte c : cartes) {
            compteur.put(c.getValeur(), compteur.getOrDefault(c.getValeur(), 0) + 1);
        }

        if (compteur.containsValue(4)) {
            return "Carré";
        }

        if (compteur.containsValue(3)) {
            return "Brelan";
        }

        if (compteur.size() == 3) {
            return "Deux paires";
        }

        if (compteur.size() == 4) {
            return "Paire";
        }

        return "Aucune Combinaison";
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

    // Vérifier si c'est un Full House
    public boolean estUnFull() {

        if (cartes.size() != 5) return false;

        HashMap<String, Integer> compteur = new HashMap<>();

        for (Carte c : cartes) {
            String valeur = c.getValeur();

            if (compteur.containsKey(valeur)) {
                compteur.put(valeur, compteur.get(valeur) + 1);
            } else {
                compteur.put(valeur, 1);
            }
        }

        if (compteur.size() != 2) return false;

        return compteur.containsValue(3) && compteur.containsValue(2);
    }

}
