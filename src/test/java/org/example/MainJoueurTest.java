package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainJoueurTest {

    @Test
    public void testPaire() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("2","♠"));
        main.ajouterCarte(new Carte("2","♦"));
        main.ajouterCarte(new Carte("5","♣"));
        main.ajouterCarte(new Carte("7","♥"));
        main.ajouterCarte(new Carte("9","♠"));

        assertEquals("Paire", main.evaluerMain());
    }

    @Test
    public void testDeuxPaires() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("3","♠"));
        main.ajouterCarte(new Carte("3","♦"));
        main.ajouterCarte(new Carte("5","♣"));
        main.ajouterCarte(new Carte("5","♥"));
        main.ajouterCarte(new Carte("9","♠"));

        assertEquals("Deux paires", main.evaluerMain());
    }

    @Test
    public void testBrelan() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("V","♠"));
        main.ajouterCarte(new Carte("V","♦"));
        main.ajouterCarte(new Carte("V","♣"));
        main.ajouterCarte(new Carte("7","♥"));
        main.ajouterCarte(new Carte("9","♠"));

        assertEquals("Brelan", main.evaluerMain());
    }

    @Test
    public void testCarré() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("8","♠"));
        main.ajouterCarte(new Carte("8","♦"));
        main.ajouterCarte(new Carte("8","♣"));
        main.ajouterCarte(new Carte("8","♥"));
        main.ajouterCarte(new Carte("9","♠"));

        assertEquals("Carré", main.evaluerMain());
    }

    @Test
    public void testFull() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("R","♠"));
        main.ajouterCarte(new Carte("R","♦"));
        main.ajouterCarte(new Carte("R","♣"));
        main.ajouterCarte(new Carte("V","♥"));
        main.ajouterCarte(new Carte("V","♠"));

        assertEquals("Full House", main.evaluerMain());
    }

    @Test
    public void testSuite() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("5","♠"));
        main.ajouterCarte(new Carte("6","♦"));
        main.ajouterCarte(new Carte("7","♣"));
        main.ajouterCarte(new Carte("8","♥"));
        main.ajouterCarte(new Carte("9","♠"));

        assertEquals("Suite (Straight)", main.evaluerMain());
    }

    @Test
    public void testCouleur() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("2","♣"));
        main.ajouterCarte(new Carte("5","♣"));
        main.ajouterCarte(new Carte("8","♣"));
        main.ajouterCarte(new Carte("V","♣"));
        main.ajouterCarte(new Carte("R","♣"));

        assertEquals("Couleur (Flush)", main.evaluerMain());
    }

    @Test
    public void testQuinteFlush() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("5","♦"));
        main.ajouterCarte(new Carte("6","♦"));
        main.ajouterCarte(new Carte("7","♦"));
        main.ajouterCarte(new Carte("8","♦"));
        main.ajouterCarte(new Carte("9","♦"));

        assertEquals("Quinte Flush", main.evaluerMain());
    }

    @Test
    public void testAucuneCombinaison() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("2","♠"));
        main.ajouterCarte(new Carte("4","♦"));
        main.ajouterCarte(new Carte("6","♣"));
        main.ajouterCarte(new Carte("8","♥"));
        main.ajouterCarte(new Carte("10","♠"));

        assertEquals("Aucune Combinaison", main.evaluerMain());
    }

    @Test
    public void testMainIncomplète() {
        MainJoueur main = new MainJoueur();
        main.ajouterCarte(new Carte("2","♠"));
        main.ajouterCarte(new Carte("4","♦"));

        assertEquals("Main incomplète", main.evaluerMain());
    }
}
