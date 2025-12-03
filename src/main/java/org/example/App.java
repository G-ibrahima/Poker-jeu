package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        JeuPoker jeu = new JeuPoker();

        jeu.distribuer();
        jeu.afficherJeu();
        jeu.comparer();
    }
}
