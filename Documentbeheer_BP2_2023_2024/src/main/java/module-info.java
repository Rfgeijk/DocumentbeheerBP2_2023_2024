module com.raphaella.documentbeheer_bp2_2023_2024 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.raphaella.documentbeheer_bp2_2023_2024 to javafx.fxml;
    exports com.raphaella.documentbeheer_bp2_2023_2024;
}