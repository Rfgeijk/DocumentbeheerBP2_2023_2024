package com.raphaella.documentbeheer_bp2_2023_2024.pages;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HomeScreen {

    private Scene scene;

    public HomeScreen() {


        GridPane root = new GridPane();

        FlowPane welcome = new FlowPane();
        welcome.setPrefSize(300,70);
        welcome.setStyle("-fx-background-color: #59D7BF");
        welcome.setPadding(new Insets(20, 20, 20, 20));

        Text welcomeText = new Text();
        welcomeText.setText("Welcome! Search for documents or upload one down below!");
        welcomeText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        welcomeText.setTextAlignment(TextAlignment.CENTER);

        welcome.getChildren().add(welcomeText);

        Button documentsPage = new Button("You can look for documents here!");
        documentsPage.setOnAction(a->{
            SearchPage searchPage = new SearchPage();
            searchPage.show();

        });


        Button addDocument = new Button("Add document");
        addDocument.setPrefSize(90,30);
        addDocument.setPadding(new Insets(0, 0, 0, 0));

        addDocument.setOnAction(a->{
            UploadPage up = new UploadPage();
            UploadPage.show();
        });




        root.add(welcome,0 ,0 );
        root.add(documentsPage, 0, 1);
        root.add(addDocument, 0, 2);
        root.getChildren();

        scene = new Scene(root, 800, 250);
        Stage stage = new Stage();
        stage.setTitle("Home Screen");
        stage.setScene(getScene());
        stage.show();

    }

    public Scene getScene() {
        return scene;
    }

    public void show() {
    }
}
