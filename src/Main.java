import stringalgorithms.StringMatcher;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        StringMatcher matcher = new StringMatcher();

        // Исходный текст
        String text = "This is a test message containing some bad and inappropriate words.";

        // Conflict for demostartion
        // Запрещённые слова
        String[] bannedWords = {"bad", "inappropriate"};

        // Поиск запрещённых слов в тексте
        List<String> detectedWords = new ArrayList<>();
        for (String word : bannedWords) {
            List<Integer> index = matcher.rabinKarp(text, word);
            if (!index.contains(-1)) {
                detectedWords.add(word);
            }
        }

        // Вывод результата
        if (!detectedWords.isEmpty()) {
            System.out.println("Detected inappropriate words: " +
                    String.join(", ", detectedWords));
        } else {
            System.out.println("No inappropriate words found.");
        }

        System.out.println("Verify KMP: " + matcher.verifyKMP(text, bannedWords[0]));
    }
}