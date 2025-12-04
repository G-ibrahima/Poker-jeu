package org.example;

import java.util.Scanner;

public class JeuPoker{

    private static final int CAPITAL_DEPART = 100;
    private int capital;
    private Paquet paquet;
    private MainJoueur mainJoueur;
    private Scanner scanner;

    public JeuPoker() {
        this.capital = CAPITAL_DEPART;
        this.paquet = new Paquet();
        this.mainJoueur = new MainJoueur();
        this.scanner = new Scanner(System.in);
    }

    // Méthode pour afficher les règles et le capital
    public void afficherRegles() {
        System.out.println("=== Jeu de Poker INF1120 ===");
        System.out.println("Capital de départ : " + capital + "$");
        System.out.println("Gains selon les cartes obtenues :");
        System.out.println("- Cartes toutes différentes : -10$");
        System.out.println("- Paire : 0$");
        System.out.println("- Deux paires : 20$");
        System.out.println("- Brelan : 35$");
        System.out.println("- Suite (Quinte) : 50$");
        System.out.println("- Full : 75$");
        System.out.println("- Couleur : 100$");
        System.out.println("- Carré : 150$");
        System.out.println("- Quinte Royale : 500$");
        System.out.println("==============================");
    }

    // Méthode pour distribuer les cartes
    public void distribuerCartes() {
        mainJoueur = new MainJoueur(); // réinitialiser la main
        paquet = new Paquet();

        for (int i = 0; i < 5; i++) {
            paquet.melanger();
            mainJoueur.ajouterCarte(paquet.tirerCarte());
        }
    }

    // Méthode pour calculer le gain selon la main
    public int calculerGain() {
        String main = mainJoueur.evaluerMain();
        int gain = switch (main) {
            case "Aucune Combinaison" -> -10;
            case "Paire" -> 5;
            case "Deux paires" -> 20;
            case "Brelan" -> 35;
            case "Suite (Straight)" -> 50;
            case "Full House" -> 75;
            case "Couleur (Flush)" -> 100;
            case "Carré" -> 150;
            case "Quinte Flush" -> 500;
            default -> 0;
        };
        System.out.println("Main obtenue : " + main + " => Gain : " + gain + "$");
        return gain;
    }
    // Boucle principale du jeu
    public void jouer() {
        afficherRegles();

        boolean continuer = true;

        while (capital > 0 && continuer) {

            // On distribue une nouvelle main
            distribuerCartes();

            // On affiche la main
            System.out.println("\nNouvelle main : ");
            mainJoueur.afficher();

            // On calcule le gain
            int gain = calculerGain();

            // On met à jour le capital
            capital += gain;

            System.out.println("Capital actuel : " + capital + "$");

            if (capital <= 0) {
                System.out.println("Vous avez perdu ! Plus d'argent pour continuer.");
                break;
            }

            // Question pour continuer
            System.out.print("Voulez-vous continuer ? (o/n) : ");
            String reponse = scanner.nextLine().toLowerCase();

            if (!reponse.equals("o")) {
                continuer = false;
            }

            System.out.println("-----------------------------");
        }

        System.out.println("Merci d'avoir joué ! Capital final : " + capital + "$");
    }


}
