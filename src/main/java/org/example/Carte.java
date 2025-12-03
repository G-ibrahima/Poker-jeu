package org.example;

public class Carte {

    // Attributs de la carte
    private String valeur;
    private String sorte;

    // Constructeur
    public Carte(String valeur, String sorte) {
        this.valeur = valeur;
        this.sorte = sorte;
    }

    // Getters
    public String getValeur() {
        return valeur;
    }

    public String getSorte() {
        return sorte;
    }

    // Pour afficher la carte facilement
    @Override
    public String toString() {
        return valeur + sorte;
    }
}
