package com.example.javafxapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import com.string.algorithms.StringMatcher;

public class StringAlgorithmsFXApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Создаем элементы интерфейса
        Label textLabel = new Label("Введите текст:");
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(5);

        Label patternLabel = new Label("Введите шаблон:");
        TextField patternField = new TextField();

        Button searchButton = new Button("Найти (Рабин–Карп)");
        Label resultLabel = new Label();

        // Обработка нажатия кнопки
        searchButton.setOnAction(e -> {
            String text = textArea.getText();
            String pattern = patternField.getText();
            if (text.isEmpty() || pattern.isEmpty()) {
                resultLabel.setText("Пожалуйста, введите текст и шаблон для поиска.");
                return;
            }
            // Используем класс StringMatcher из библиотеки
            StringMatcher matcher = new StringMatcher();
            int index = matcher.rabinKarp(text, pattern);
            if (index != -1) {
                resultLabel.setText("Шаблон найден на позиции: " + index);
            } else {
                resultLabel.setText("Шаблон не найден.");
            }
        });

        // Организация элементов на экране
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(textLabel, textArea, patternLabel, patternField, searchButton, resultLabel);

        Scene scene = new Scene(root, 500, 350);
        primaryStage.setTitle("JavaFX Приложение для строковых алгоритмов");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}