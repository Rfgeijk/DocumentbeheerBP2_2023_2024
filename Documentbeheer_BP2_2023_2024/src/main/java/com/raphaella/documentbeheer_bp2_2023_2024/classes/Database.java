package com.raphaella.documentbeheer_bp2_2023_2024.classes;

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
            //throw new RuntimeException(e);
        }
    }

    public void uploadDocument(String title, String author, String information, Date date){

        String sql = "INSERT INTO document (title, author, information, date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, information);
            pstmt.setDate(4, date);

            // Execute the statement
            pstmt.executeUpdate();

            // Get the generated file_id (if needed)
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long fileId = generatedKeys.getLong(1);
                    System.out.println("Gelukt!! Het gegenereerde file_id is: " + fileId);
                }
            }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

    public List<Document> getAllDocuments() {
        List<Document> documents = new ArrayList<>();

        // JDBC-verbinding
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/documentbeheer", "root", "");
             Statement statement = connection.createStatement()) {

            // Voer de SQL-query uit
            String query = "SELECT * FROM document";
            ResultSet resultSet = statement.executeQuery(query);

            // Verwerk de resultaten en voeg documenten toe aan de lijst
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
            // Behandel SQLException afhankelijk van je applicatiebehoeften
        }

        return documents;
    }


}
