package algorithms;


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

    //@ ensures \result == (\exists int j; 0 <= j < text.length() - pattern.length() + 1; text.regionMatches(j, pattern, 0, pattern.length()));
    public boolean verifyKMP(String text, String pattern) {
        KMP kmp = new KMP();
        return !kmp.search(text, pattern).isEmpty();
    }
}