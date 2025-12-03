package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Paquet paquet = new Paquet();
        paquet.melanger();

        MainJoueur main = new MainJoueur();

        // Donner 5 cartes au joueur
        for (int i = 0; i < 5; i++) {
            main.ajouterCarte(paquet.tirerCarte());
        }

        System.out.println("Main du joueur : ");
        main.afficher();

        System.out.println("Cartes restantes dans le paquet : " + paquet.nombreCartes());
    }
}
