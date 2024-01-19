package com.raphaella.documentbeheer_bp2_2023_2024.classes;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Date;

public class Document {


    private int id;

    private String title;

    private String author;

    private String information;

    private Date date;

    public Document(int id, String title, String author, String information, Date date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.information = information;
        this.date = date;
    }

    public int getId() {return id;}

    public String getTitle() {return title;}

    public String getAuthor() {return author;}

    public String getInformation() {return information;}

    public Date getDate() {return date;}

    public VBox show(){
        VBox listItem = new VBox();
        listItem.setPrefHeight( 150);
        listItem.setStyle("-fx-background-color: #fff303;");


        Label document = new Label(title + " " + author + " " + information + " " + date);
        listItem.getChildren().add(document);

        return listItem;
    }





}
