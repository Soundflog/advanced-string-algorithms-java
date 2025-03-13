import stringalgorithms.StringMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        StringMatcher matcher = new StringMatcher();

        // Пример Рабина-Карпа
        String text = "abracadabra";
        String pattern = "cad";
        List<Integer> index = matcher.rabinKarp(text, pattern);
        System.out.println("Rabin-Karp result: " + index);

        // Пример Z-функции
        int[] z = matcher.zFunction("abracadabra");
        System.out.println("Z-function result: " + Arrays.toString(z));

        // Пример Кнута-Морриса-Пратта
        List<Integer> indexKMP = matcher.knuthMorrisPratt(text, pattern);
        System.out.println("Knuth-Morris-Pratt result: " + indexKMP);
    }
}