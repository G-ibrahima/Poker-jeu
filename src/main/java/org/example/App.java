package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Paquet paquet = new Paquet();

        System.out.println("Nombre de cartes : " + paquet.nombreCartes());

        paquet.melanger();

        System.out.println("Carte tirée : " + paquet.tirerCarte());
        System.out.println("Carte tirée : " + paquet.tirerCarte());

        System.out.println("Cartes restantes : " + paquet.nombreCartes());
    }
}
