package com.raphaella.documentbeheer_bp2_2023_2024.pages;

import com.raphaella.documentbeheer_bp2_2023_2024.classes.Database;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Date;

public class UploadPage {

    public UploadPage(){

        Database db = new Database();

        //Stap 1: Maken van de stage
        Stage deStage = new Stage();

        //Stap 2: Maken van een Layout
        GridPane root = new GridPane();

        //Stap 2a: Toevoegen van controls
        TextField txtTitle = new TextField("Title");
        txtTitle.setPromptText("Title");
        TextField txtInformation = new TextField();
        txtInformation.setPromptText("Information (max 255 words)");
        txtInformation.setPrefSize(400, 400);
        TextField txtAuthor = new TextField();
        txtAuthor.setPromptText("Author");
        DatePicker uploadDate = new DatePicker();
        Button btnOpslaan = new Button("Upload");



        //Stap 3:Maken van Scene
        Scene deScene = new Scene(root, 800, 600);

        //Stap 4: Scene koppelen aan layout
        deStage.setScene(deScene);
        deStage.show();

        btnOpslaan.setOnAction(a->{
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String information = txtInformation.getText();
            String datum = uploadDate.getValue().toString();

            db.uploadDocument(title, author, information, Date.valueOf(datum));

            System.out.println("Titel: " + title);
            System.out.println("Auteur: " + author);
            System.out.println("Informatie: " + information);
            System.out.println("Datum: " + datum);



        });

        root.add(txtTitle, 0, 1);
        root.add(txtAuthor, 0, 2);
        root.add(txtInformation, 0, 3);
        root.add(uploadDate, 0, 4);
        root.add(btnOpslaan, 0, 5);


    }

    public static void show() {
    }

}
