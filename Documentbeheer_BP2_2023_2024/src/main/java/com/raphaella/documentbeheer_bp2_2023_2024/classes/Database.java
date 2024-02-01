package com.raphaella.documentbeheer_bp2_2023_2024.classes;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Connection conn;

    public Database(){
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/documentbeheer",
                    "root", "");
            if(conn.isValid(5)) System.out.println("Verbinding OK!");
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public void uploadDocument(String title, String author, String information, Date date){


        if (title == null || title.isEmpty() || author == null || author.isEmpty() || information == null || information.isEmpty() || date == null) {
            System.out.println("Waarschuwing: Enter data in all fields and try again!");
            return;
        }

        String sql = "INSERT INTO document (title, author, information, date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, information);
            pstmt.setDate(4, date);


            pstmt.executeUpdate();


            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long fileId = generatedKeys.getLong(1);
                    System.out.println("Gelukt!! ");
                }
            }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

    public List<Document> getAllDocuments() {
        List<Document> documents = new ArrayList<>();


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/documentbeheer", "root", "");
             Statement statement = connection.createStatement()) {


            String query = "SELECT * FROM document";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                int id = resultSet.getInt("document_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String information = resultSet.getString("information");
                Date date = resultSet.getDate("date");

                Document document = new Document(id, title, author, information, date);
                documents.add(document);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return documents;
    }


    public void deleteDocument(Document document) {
        String deleteQuery = "DELETE FROM document WHERE document_id=?";

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);



        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {

                    preparedStatement.setInt(1, document.getId());

                    preparedStatement.executeUpdate();

                    System.out.println("Document deleted successfully!");

                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("An error occurred while deleting the document.");
                }
            }
        });
    }

    public void updateDocumentDetails(long documentId, String newTitle, String newAuthor, String newInformation, Date newDate) {
        if (documentId <= 0) {
            System.out.println("Invalid document ID.");
            return;
        }

        // Implement the update logic here
        String updateQuery = "UPDATE document SET title=?, author=?, information=?, date=? WHERE document_id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, newTitle);
            pstmt.setString(2, newAuthor);
            pstmt.setString(3, newInformation);
            pstmt.setDate(4, newDate);
            pstmt.setLong(5, documentId);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Document details updated successfully!");
            } else {
                System.out.println("Failed to update document details.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}