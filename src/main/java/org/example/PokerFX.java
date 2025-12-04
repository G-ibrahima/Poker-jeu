package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PokerFX extends Application {

    JeuPoker jeu = new JeuPoker();

    @Override
    public void start(Stage stage) {
        Label titre = new Label("Jeu de Poker");
        Label capitalLabel = new Label("Capital: " + jeu.getCapital() + "$");
        Label mainLabel = new Label("Clique pour jouer");

        Button jouerBtn = new Button("Jouer une main");

        jouerBtn.setOnAction(e -> {

            // Si plus d'argent → on bloque
            if (jeu.getCapital() <= 0) {
                mainLabel.setText("Vous n'avez plus d'argent pour jouer !");
                jouerBtn.setDisable(true);
                return;
            }

            // Distribuer une main
            jeu.distribuerCartes();

            // Main du joueur sous forme texte
            String cartes = jeu.getMainJoueur().toString();

            // Type de main (Paire, Full, etc.)
            String resultat = jeu.getMainJoueur().evaluerMain();

            // Gain selon la main
            int gain = jeu.calculerGain();

            // Mise à jour du capital
            jeu.setCapital(jeu.getCapital() + gain);

            // Mise à jour affichage
            mainLabel.setText(
                    "Cartes : " + cartes +
                            "\nRésultat : " + resultat +
                            "\nGain : " + gain + "$"
            );

            capitalLabel.setText("Capital : " + jeu.getCapital() + "$");
        });


        VBox root = new VBox(15, titre, capitalLabel, mainLabel, jouerBtn);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Poker JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
