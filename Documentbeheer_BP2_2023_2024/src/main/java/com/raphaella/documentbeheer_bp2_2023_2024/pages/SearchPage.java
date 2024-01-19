package com.raphaella.documentbeheer_bp2_2023_2024.pages;

import com.raphaella.documentbeheer_bp2_2023_2024.classes.Database;
import com.raphaella.documentbeheer_bp2_2023_2024.classes.Document;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchPage {


    private Database db = new Database();

    // Stap 1: Maken van de stage
    private Stage deStage = new Stage();

    // Stap 2: Maken van een Layout

    private VBox root = new VBox();

    private Button download = new Button("Download");

    // Stap 3: Maken van Scene
    private Scene deScene = new Scene(root, 800, 600);

    public SearchPage() {
        // Voeg de downloadknop toe aan de root VBox
        root.getChildren().add(download);

        // Laad documenten uit de database en voeg ze toe aan de root VBox
        loadDocuments();
    }

    private void loadDocuments() {
        // Haal documenten op uit de database (dummy implementatie, vervang dit met je eigen logica)
        List<Document> documents = db.getAllDocuments();

        // Maak VBox voor elk document en voeg deze toe aan de root VBox
        for (Document document : documents) {
            root.getChildren().add(document.show());
        }
    }


    public void show() {
        deStage.setScene(deScene);
        deStage.show();
    }


}
