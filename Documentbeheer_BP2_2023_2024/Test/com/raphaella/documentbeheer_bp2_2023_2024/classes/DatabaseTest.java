package com.raphaella.documentbeheer_bp2_2023_2024.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

class DatabaseTest {

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
    void testUploadDocument() {
        String title = "Sample Title";
        String author = "Sample Author";
        String information = "Sample Information";
        Date date = new Date(123, 0, 24); // Adjust the date instantiation as needed

        uploadDocument(title, author, information, date);

        boolean documentUploaded = isDocumentUploaded(title, author, information, date);
        Assertions.assertTrue(documentUploaded, "Document should be uploaded successfully.");
    }

    @Test
    void testUploadDocumentMissingData() {
        String title = "Sample Title";
        String author = "";
        String information = "Sample Information";
        Date date = new Date(123, 3, 24); // Adjust the date instantiation as needed

        uploadDocument(title, author, information, date);

        boolean documentUploaded = isDocumentUploaded(title, author, information, date);
        Assertions.assertFalse(documentUploaded, "Document with missing data should not be uploaded.");
    }

    private void uploadDocument(String title, String author, String information, Date date) {
        // Call the actual uploadDocument method here
        Database db = new Database();
        db.uploadDocument(title, author, information, date);
    }

    private boolean isDocumentUploaded(String title, String author, String information, Date date) {
        String selectQuery = "SELECT * FROM document WHERE title=? AND author=? AND information=? AND date=?";
        try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
            selectStmt.setString(1, title);
            selectStmt.setString(2, author);
            selectStmt.setString(3, information);
            selectStmt.setDate(4, new java.sql.Date(date.getTime()));
            ResultSet resultSet = selectStmt.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}