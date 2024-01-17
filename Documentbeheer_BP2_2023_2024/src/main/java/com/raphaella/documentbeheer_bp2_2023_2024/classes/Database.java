package com.raphaella.documentbeheer_bp2_2023_2024.classes;

import java.sql.*;

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
}
