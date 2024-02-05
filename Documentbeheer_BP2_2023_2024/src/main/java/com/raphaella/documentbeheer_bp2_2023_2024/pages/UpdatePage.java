package com.raphaella.documentbeheer_bp2_2023_2024.pages;

import com.raphaella.documentbeheer_bp2_2023_2024.classes.Database;
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

            TextField txtTitle = new TextField();
            txtTitle.setPromptText("Fill in title of the document you want to Update");
            TextField txtInformation = new TextField();
            txtInformation.setPromptText("Information (max 255 words)");
            txtInformation.setPrefSize(400, 400);
            TextField txtAuthor = new TextField();
            txtAuthor.setPromptText("Author");
            DatePicker uploadDate = new DatePicker();
            Button btnUpdate = new Button("Update Document");




            Scene deScene = new Scene(root, 800, 600);


            deStage.setScene(deScene);
            deStage.show();
            btnUpdate.setOnAction(event ->{
                // Retrieve the title from the text field
                String currentTitle = txtTitle.getText();

                // Retrieve other fields
                String newTitle = txtTitle.getText();
                String newAuthor = txtAuthor.getText();
                String newInformation = txtInformation.getText();
                Date newDate = Date.valueOf(uploadDate.getValue());

                // Call the updateDocumentDetails method with the parameters
                db.updateDocumentDetails(currentTitle, newTitle, newAuthor, newInformation, newDate);
            });

            root.add(txtTitle, 0, 1);
            root.add(txtAuthor, 0, 2);
            root.add(txtInformation, 0, 3);
            root.add(uploadDate, 0, 4);
            root.add(btnUpdate, 0, 5);


    }
    public static void show() {}
}
