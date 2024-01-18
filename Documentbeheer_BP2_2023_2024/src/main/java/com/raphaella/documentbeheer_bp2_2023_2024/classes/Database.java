package com.raphaella.documentbeheer_bp2_2023_2024.classes;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private Connection conn;
    ArrayList<Document> list = new ArrayList<>();

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

    public ArrayList<Document> giveAllDocuments(){


        String sQuery = "SELECT * FROM bestemming";
        try {
            Statement stm = this.conn.createStatement();
            //Select query uitvoeren naar de database
            stm.execute(sQuery);
            //Resultaten uit de query ophalen als ResultSet
            ResultSet rs = stm.getResultSet();

            while(rs.next()){
                //Ophalen resultaten gekoppeld aan de kolomnamen uit de database
                int id = rs.getInt("id");
                String sTitle = rs.getString("Title");
                String sInformation = rs.getString("Information");
                String sAuthor = rs.getString("Author");
                double dDate = rs.getDouble("Date");

                Document vak = new Document(id, sTitle, sInformation, sAuthor);
                list.add(vak);


                //Waarden in de console laten zien
                System.out.println();
                //return lijst;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }



}
