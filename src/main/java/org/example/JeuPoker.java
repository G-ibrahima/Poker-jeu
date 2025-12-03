package org.example;


public class JeuPoker {

    private Paquet paquet = new Paquet();
    private MainJoueur joueur1 = new MainJoueur();
    private MainJoueur joueur2 = new MainJoueur();

    public void distribuer() {

        paquet.melanger();

        for (int i = 0; i < 5; i++) {
            joueur1.ajouterCarte(paquet.tirerCarte());
            joueur2.ajouterCarte(paquet.tirerCarte());
        }
    }

    public void afficherJeu() {
        System.out.println("Joueur 1 : ");
        joueur1.afficher();
        System.out.println(" -> " + joueur1.evaluerMain());

        System.out.println("\nJoueur 2 : ");
        joueur2.afficher();
        System.out.println(" -> " + joueur2.evaluerMain());
    }

    public void comparer() {

        int valeur1 = valeurMain(joueur1.evaluerMain());
        int valeur2 = valeurMain(joueur2.evaluerMain());

        if (valeur1 > valeur2)
            System.out.println("\n✅ Joueur 1 GAGNE !");
        else if (valeur2 > valeur1)
            System.out.println("\n✅ Joueur 2 GAGNE !");
        else
            System.out.println("\n Égalité !");
    }

    private int valeurMain(String main) {
        return switch (main) {
            case "Carte haute" -> 1;
            case "Paire" -> 2;
            case "Deux paires" -> 3;
            case "Brelan" -> 4;
            case "Suite (Straight)" -> 5;
            case "Couleur (Flush)" -> 6;
            case "Full House" -> 7;
            case "Carré" -> 8;
            case "Quinte Flush" -> 9;
            default -> 0;
        };
    }
}
