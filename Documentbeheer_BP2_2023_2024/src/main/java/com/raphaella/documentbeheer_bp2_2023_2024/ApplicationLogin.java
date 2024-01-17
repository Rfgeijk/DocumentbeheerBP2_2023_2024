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

        // Username label and text field
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Enter your username");
        GridPane.setConstraints(usernameInput, 1, 0);

        // Password label and password field
        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Enter your password");
        GridPane.setConstraints(passwordInput, 1, 1);

        // Login button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        // Action for the login button
        loginButton.setOnAction(e -> {
            if (authenticate(usernameInput.getText(), passwordInput.getText())) {
                System.out.println("Login successful!");
                // Maak een nieuw homescherm aan
                HomeScreen homeScreen = new HomeScreen();

                // Haal het podium op van de knop (loginButton)
                Stage staGe = (Stage) loginButton.getScene().getWindow();

                // Sluit het huidige scherm
                stage.close();

                // Laat het nieuwe scherm zien
                homeScreen.show();
            } else {
                System.out.println("Login failed. Please check your credentials.");
            }
        });

        // Add controls to the grid
        root.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);


        stage.setTitle("Login Page");
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }

    // Dummy authentication method
    private boolean authenticate(String username, String password) {
        // Implement your authentication logic here
        // For simplicity, this example uses a hardcoded username and password
        return username.equals("user") && password.equals("password");
    }



    public static void main(String[] args) {
        launch();
    }
}