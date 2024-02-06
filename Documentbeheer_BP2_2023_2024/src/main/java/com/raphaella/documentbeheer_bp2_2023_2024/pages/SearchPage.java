package com.raphaella.documentbeheer_bp2_2023_2024.pages;

import com.raphaella.documentbeheer_bp2_2023_2024.classes.Database;
import com.raphaella.documentbeheer_bp2_2023_2024.classes.Document;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class SearchPage {


    private Database db = new Database();

    private Stage deStage = new Stage();

    private VBox root = new VBox();

    private Scene deScene = new Scene(root, 800, 600);

    public SearchPage() {
        loadDocuments();
    }

    private void loadDocuments() {
        List<Document> documents = db.getAllDocuments();

        for (Document document : documents) {
            VBox documentBox = document.show();

            Button downloadButton = new Button("Download");
            downloadButton.setOnAction(event -> {
                downloadDocument(document);
            });

            Button updateButton = new Button("Update");
            updateButton.setOnAction(event -> {
                UpdatePage updatePage = new UpdatePage();
                updatePage.show();

            });

            Button deleteButton = new Button("Delete");
            deleteButton.setOnAction(event -> {
                db.deleteDocument(document);
            });


            root.getChildren().addAll(documentBox, downloadButton, updateButton, deleteButton);
        }
    }
    private void downloadDocument(Document document) {
        String title = document.getTitle();
        String author = document.getAuthor();
        String information = document.getInformation();
        String date = document.getDate().toString();


        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Information: " + information);
        System.out.println("Date: " + date);
    }


    public void show() {
        deStage.setScene(deScene);
        deStage.show();
    }


}
