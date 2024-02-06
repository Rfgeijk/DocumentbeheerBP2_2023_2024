package com.raphaella.documentbeheer_bp2_2023_2024.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Databasegetalldocumentstest {

    private Connection conn;

    @BeforeEach
    public void setUp() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/documentbeheer", "root", "");
            if (conn.isValid(5)) System.out.println("Verbinding OK!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllDocuments() {

        Database db = new Database();

        // Assuming you have some documents in your database for testing
        List<Document> documents = db.getAllDocuments();

        // Check if the returned list is not null and contains at least one document
        Assertions Assertions;
        Assertions = null;
        Assertions.assertNotNull(documents);
        Assertions.assertTrue(((List<?>) documents).size() > 0);

        // Optionally, you can check specific details of the first document in the list
        Document firstDocument = documents.get(0);
        Assertions.assertNotNull(firstDocument);
        Assertions.assertNotNull(firstDocument.getTitle());
        Assertions.assertNotNull(firstDocument.getAuthor());
        Assertions.assertNotNull(firstDocument.getInformation());
        Assertions.assertNotNull(firstDocument.getDate());
    }

}