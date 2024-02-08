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

        Stage deStage = new Stage();

        GridPane root = new GridPane();

        TextField txtTitle = new TextField();
        txtTitle.setPromptText("Title");
        TextField txtInformation = new TextField();
        txtInformation.setPromptText("Information (max 255 words)");
        txtInformation.setPrefSize(400, 400);
        TextField txtAuthor = new TextField();
        txtAuthor.setPromptText("Author");
        DatePicker uploadDate = new DatePicker();
        Button btnOpslaan = new Button("Upload");


        Scene deScene = new Scene(root, 800, 600);

        deStage.setScene(deScene);
        deStage.show();

        btnOpslaan.setOnAction(a->{
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String information = txtInformation.getText();
            String datum = uploadDate.getValue().toString();

            db.uploadDocument(title, author, information, Date.valueOf(datum));

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
