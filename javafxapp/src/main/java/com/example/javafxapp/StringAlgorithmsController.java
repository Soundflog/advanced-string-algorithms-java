package com.example.javafxapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StringAlgorithmsController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}