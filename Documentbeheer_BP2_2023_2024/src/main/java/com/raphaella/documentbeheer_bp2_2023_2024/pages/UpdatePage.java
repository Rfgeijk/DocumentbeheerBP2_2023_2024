package com.raphaella.documentbeheer_bp2_2023_2024.pages;

import com.raphaella.documentbeheer_bp2_2023_2024.classes.Database;
import com.raphaella.documentbeheer_bp2_2023_2024.classes.Document;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Date;

public class UpdatePage {

        public UpdatePage(){

            Database db = new Database();

            Stage deStage = new Stage();

            GridPane root = new GridPane();

            TextField txtTitle = new TextField("Title");
            txtTitle.setPromptText("Title");
            TextField txtInformation = new TextField();
            txtInformation.setPromptText("Information (max 255 words)");
            txtInformation.setPrefSize(400, 400);
            TextField txtAuthor = new TextField();
            txtAuthor.setPromptText("Author");
            DatePicker uploadDate = new DatePicker();
            Button btnUpdate = new Button("Update");




            Scene deScene = new Scene(root, 800, 600);


            deStage.setScene(deScene);
            deStage.show();

            btnUpdate.setOnAction(a -> {
                String title = txtTitle.getText();
                String author = txtAuthor.getText();
                String information = txtInformation.getText();
                String datum = uploadDate.getValue().toString();

                // Assuming you have the documentId stored in a variable in your UpdatePage class
                long documentId = 1;

                db.updateDocumentDetails(documentId, title, author, information, Date.valueOf(datum));
            });

            root.add(txtTitle, 0, 1);
            root.add(txtAuthor, 0, 2);
            root.add(txtInformation, 0, 3);
            root.add(uploadDate, 0, 4);
            root.add(btnUpdate, 0, 5);


        }

        public static void show() {
        }
}
