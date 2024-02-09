package com.raphaella.documentbeheer_bp2_2023_2024.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDate;

class DatabaseupdateTest {

    private Connection conn;

    @BeforeEach
    public void setUp() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://adainforma.tk:3306/bp2_documentbeheersysteem", "documentbeheersysteem", "I2l361gu_");
            if (conn.isValid(5)) System.out.println("Verbinding OK!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @Test
    void updateDocumentDetails() {
        Database db = new Database();

        // Assuming you have a document with known details for testing
        String currentTitle = "Sample Title";
        String currentAuthor = "Sample Author";
        String currentInformation = "Sample Information";
        Date currentDate = new Date(123, 0, 24); // Adjust year, month, and day as needed

        // Insert the reference document before testing the update
        insertSampleDocument(currentTitle, currentAuthor, currentInformation, currentDate);

        // Details to be updated
        String newTitle = "Updated Title";
        String newAuthor = "Updated Author";
        String newInformation = "Updated Information";
        LocalDate newDate = LocalDate.of(2023, 1, 25); // Updated to use LocalDate

        // Convert LocalDate to java.sql.Date
        java.sql.Date sqlNewDate = java.sql.Date.valueOf(newDate);

        // Perform the update operation
        db.updateDocumentDetails(currentTitle, newTitle, newAuthor, newInformation, sqlNewDate);

        // Check if the document details are updated successfully
        boolean documentUpdated = isDocumentUpdated(newTitle, newAuthor, newInformation, Date.valueOf(newDate));

        // Debug statements
        System.out.println("Current Title: " + currentTitle);
        System.out.println("New Title: " + newTitle);
        System.out.println("Current Author: " + currentAuthor);
        System.out.println("New Author: " + newAuthor);
        System.out.println("Current Information: " + currentInformation);
        System.out.println("New Information: " + newInformation);
        System.out.println("Current Date: " + currentDate);
        System.out.println("New Date: " + newDate);
        System.out.println("Document Updated: " + documentUpdated);

        // Assert
        Assertions.assertTrue(documentUpdated, "Document details should be updated successfully.");
    }


    private void insertSampleDocument(String title, String author, String information, Date date) {
        // Insert the document with known details
        String insertQuery = "INSERT INTO document (title, author, information, date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, title);
            insertStmt.setString(2, author);
            insertStmt.setString(3, information);

            // Convert LocalDate to java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(String.valueOf(date));

            insertStmt.setDate(4, sqlDate);
            insertStmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isDocumentUpdated(String title, String author, String information, Date date) {
        String selectQuery = "SELECT * FROM document WHERE title=? AND author=? AND information=? AND date=?";
        try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
            selectStmt.setString(1, title);
            selectStmt.setString(2, author);
            selectStmt.setString(3, information);
            selectStmt.setDate(4, new java.sql.Date(date.getTime()));
            ResultSet resultSet = selectStmt.executeQuery();

            if (resultSet.next()) {
                String currentTitle = resultSet.getString("title");
                String currentAuthor = resultSet.getString("author");
                String currentInformation = resultSet.getString("information");
                Date currentDate = resultSet.getDate("date");

                // Debug statements
                System.out.println("Current Title (from DB): " + currentTitle);
                System.out.println("Current Author (from DB): " + currentAuthor);
                System.out.println("Current Information (from DB): " + currentInformation);
                System.out.println("Current Date (from DB): " + currentDate);

                return currentTitle.equals(title)
                        && currentAuthor.equals(author)
                        && currentInformation.equals(information)
                        && currentDate.equals(date);
            } else {
                // Debug statement
                System.out.println("No matching record found in the database.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }
}