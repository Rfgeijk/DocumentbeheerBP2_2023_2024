package com.raphaella.documentbeheer_bp2_2023_2024.pages;

import com.raphaella.documentbeheer_bp2_2023_2024.classes.Database;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchPage {

    Database db = new Database();

    // Stap 1: Maken van de stage
    Stage deStage = new Stage();

    // Stap 2: Maken van een Layout
    VBox root = new VBox();

    Button download = new Button();

    // Stap 3: Maken van Scene
    Scene deScene = new Scene(root, 800, 600);

}
