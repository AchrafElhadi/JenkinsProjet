module com.example.javafxdatabasemaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxdatabasemaven to javafx.fxml;
    exports com.example.javafxdatabasemaven;
}