package com.raphaella.documentbeheer_bp2_2023_2024;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationLoginTest {

    @BeforeAll
    static void initJavaFX() {
        // Initialize JavaFX Toolkit
        Platform.startup(() -> new Application() {
            @Override
            public void start(Stage primaryStage) {
                // No need to do anything here
            }
        });
    }

    @Test
    void testLogin() {
        // Arrange
        ApplicationLogin loginScreen = new ApplicationLogin();

        // Act
        boolean result = loginScreen.authenticate("SystemGuardian", "Pro2024@Secure!");

        // Assert
        assertTrue(result, "Authentication should succeed with correct credentials");
    }

    @Test
    void testLoginFailure() {
        // Arrange
        ApplicationLogin loginScreen = new ApplicationLogin();

        // Act
        boolean result = loginScreen.authenticate("wrongUser", "wrongPassword");

        // Assert
        assertFalse(result, "Authentication should fail with incorrect credentials");
    }

    @Test
    void testUIComponents() {
        // Arrange & Act
        Platform.runLater(() -> {
            ApplicationLogin loginScreen = new ApplicationLogin();
            Stage stage = new Stage();

            // Assert
            assertNotNull(stage.getScene(), "Scene should be set");
            assertEquals("Login Page", stage.getTitle(), "Title should be 'Login Page'");
            assertFalse(stage.isResizable(), "Stage should not be resizable");
        });
    }
}