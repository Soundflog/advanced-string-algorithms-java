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
        // Элементы для ввода исходного текста
        Label inputTextLabel = new Label("Введите текст:");
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(5);

        // Элементы для ввода шаблона (для алгоритмов, где он необходим)
        Label patternLabel = new Label("Введите шаблон (если требуется):");
        TextField patternField = new TextField();

        // Выбор алгоритма из выпадающего списка
        ComboBox<String> algorithmComboBox = new ComboBox<>();
        algorithmComboBox.getItems().addAll("Рабин–Карп", "Кнута–Моррис–Пратта", "Z-функция");
        algorithmComboBox.setValue("Рабин–Карп");

        // Лейбл для краткого пояснения выбранного алгоритма
        Label explanationLabel = new Label();
        updateExplanation(algorithmComboBox.getValue(), explanationLabel);

        // Кнопка для запуска обработки
        Button executeButton = new Button("Выполнить");
        Label resultLabel = new Label();

        // При выборе Z-функции шаблон не требуется
        algorithmComboBox.setOnAction(event -> {
            String selected = algorithmComboBox.getValue();
            updateExplanation(selected, explanationLabel);
            if ("Z-функция".equals(selected)) {
                patternField.setDisable(true);
                patternField.setPromptText("Не требуется для Z-функции");
            } else {
                patternField.setDisable(false);
                patternField.setPromptText("");
            }
        });

        // Обработка нажатия кнопки с обработкой пользовательских и системных ошибок
        executeButton.setOnAction(event -> {
            try {
                String text = textArea.getText();
                if (text == null || text.trim().isEmpty()) {
                    throw new IllegalArgumentException("Текст не должен быть пустым.");
                }
                String selectedAlgorithm = algorithmComboBox.getValue();
                StringMatcher matcher = new StringMatcher();
                String output;
                if ("Рабин–Карп".equals(selectedAlgorithm)) {
                    String pattern = patternField.getText();
                    if (pattern == null || pattern.trim().isEmpty()) {
                        throw new IllegalArgumentException("Для алгоритма Рабина–Карпа шаблон не может быть пустым.");
                    }
                    int index = matcher.rabinKarp(text, pattern);
                    output = (index != -1) ? "Шаблон найден на позиции: " + index : "Шаблон не найден.";
                } else if ("Кнута–Моррис–Пратта".equals(selectedAlgorithm)) {
                    String pattern = patternField.getText();
                    if (pattern == null || pattern.trim().isEmpty()) {
                        throw new IllegalArgumentException("Для алгоритма Кнута–Моррис–Пратта шаблон не может быть пустым.");
                    }
                    int index = matcher.knuthMorrisPratt(text, pattern);
                    output = (index != -1) ? "Шаблон найден на позиции: " + index : "Шаблон не найден.";
                } else if ("Z-функция".equals(selectedAlgorithm)) {
                    int[] zValues = matcher.zFunction(text);
                    output = "Z-функция: " + arrayToString(zValues);
                } else {
                    throw new IllegalArgumentException("Выбран неизвестный алгоритм: " + selectedAlgorithm);
                }
                resultLabel.setText(output);
            } catch (IllegalArgumentException ex) {
                showAlert(Alert.AlertType.WARNING, "Ошибка ввода", ex.getMessage());
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Системная ошибка", "Произошла системная ошибка: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Организация элементов интерфейса
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(
                inputTextLabel, textArea,
                patternLabel, patternField,
                new HBox(10, new Label("Выберите алгоритм:"), algorithmComboBox),
                new Label("Пояснение:"), explanationLabel,
                executeButton, resultLabel
        );

        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("JavaFX Приложение для строковых алгоритмов");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Метод обновления пояснения в зависимости от выбранного алгоритма
    private void updateExplanation(String algorithm, Label explanationLabel) {
        switch (algorithm) {
            case "Рабин–Карп":
                explanationLabel.setText("Алгоритм Рабина–Карпа использует хеширование для быстрого поиска подстроки, однако может сталкиваться с коллизиями.");
                break;
            case "Кнута–Моррис–Пратта":
                explanationLabel.setText("Алгоритм Кнута–Моррис–Пратта (КМП) использует префикс-функцию для оптимального поиска шаблона с минимизацией повторных сравнений.");
                break;
            case "Z-функция":
                explanationLabel.setText("Алгоритм Z-функции вычисляет массив длин общих префиксов, что позволяет анализировать структуру строки.");
                break;
            default:
                explanationLabel.setText("");
        }
    }

    // Вспомогательный метод для преобразования массива int в строку
    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(" ");
        }
        return sb.toString().trim();
    }

    // Вспомогательный метод для отображения диалоговых окон с сообщениями об ошибках
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}