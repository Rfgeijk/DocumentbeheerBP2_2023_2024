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

        String sql = "INSERT INTO document VALUES (0, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, information);
            pstmt.setDate(4, date);

            // Execute the statement
            pstmt.executeUpdate();
            System.out.println("Gelukt!!");
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
            String query = "SELECT * FROM Document";
            ResultSet resultSet = statement.executeQuery(query);

            // Verwerk de resultaten en voeg documenten toe aan de lijst
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
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
