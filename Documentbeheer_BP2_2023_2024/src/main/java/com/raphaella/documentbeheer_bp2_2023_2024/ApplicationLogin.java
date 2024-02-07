package com.raphaella.documentbeheer_bp2_2023_2024;

import com.raphaella.documentbeheer_bp2_2023_2024.pages.HomeScreen;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationLogin extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        GridPane root = new GridPane();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setVgap(10);
        root.setHgap(10);


        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Enter your username");
        GridPane.setConstraints(usernameInput, 1, 0);


        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Enter your password");
        GridPane.setConstraints(passwordInput, 1, 1);


        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);


        loginButton.setOnAction(e -> {
            if (authenticate(usernameInput.getText(), passwordInput.getText())) {
                System.out.println("Login successful!");

                HomeScreen homeScreen = new HomeScreen();


                Stage staGe = (Stage) loginButton.getScene().getWindow();


                stage.close();


                homeScreen.show();
            } else {
                System.out.println("Login failed. Please check your credentials.");
            }
        });


        root.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);


        stage.setTitle("Login Page");
        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }

    public boolean authenticate(String username, String password) {

        return username.equals("SystemGuardian") && password.equals("Pro2024@Secure!");
    }

    public static void main(String[] args) {
        launch();
    }

}