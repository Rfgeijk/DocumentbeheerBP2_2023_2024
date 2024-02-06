package com.raphaella.documentbeheer_bp2_2023_2024.classes;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

class DatabasedeleteTest {

    private static Connection conn;
    private Document document;
    
    @BeforeAll
    public static void setUp() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/documentbeheer", "root", "");
            if (conn.isValid(5)) System.out.println("Verbinding OK!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @AfterAll
    public static void tearDown() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ... other test methods ...

    @Test
    void deleteDocument() {
        this.document = new Document();

        String deleteQuery = "DELETE FROM document WHERE document_id=?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, document.getId());  // Set the integer parameter

            preparedStatement.executeUpdate();

            System.out.println("Document deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while deleting the document.");
        }
    }

    private boolean isDocumentExists(int documentId) {
        String selectQuery = "SELECT * FROM document WHERE document_id = ?";

        try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
            selectStmt.setInt(1, documentId);
            ResultSet resultSet = selectStmt.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}