module com.example.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires advanced.string.algorithms.java;


    opens com.example.javafxapp to javafx.fxml;
    exports com.example.javafxapp;
}