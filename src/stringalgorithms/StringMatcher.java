package stringalgorithms;


import java.util.List;

public class StringMatcher {

    // Рабин-Карп
    public List<Integer> rabinKarp(String text, String pattern) {
        RabinKarp rabinKarp = new RabinKarp();
        return rabinKarp.search(text, pattern);
    }

    // Z-функция
    public int[] zFunction(String text) {
        ZFunction zFunction = new ZFunction();
        return zFunction.compute(text);
    }

    // Кнут-Моррис-Пратт
    public List<Integer> knuthMorrisPratt(String text, String pattern) {
        KMP kmp = new KMP();
        return kmp.search(text, pattern);
    }
}
