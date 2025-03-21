package com.string.algorithms;

public class StringMatcher {
    private final RabinKarp rabinKarp = new RabinKarp();
    private final ZFunction zFunction = new ZFunction();
    private final KMP knuthMorrisPratt = new KMP();

    /**
     * Поиск шаблона в тексте с использованием алгоритма Рабина–Карпа.
     */
    public int rabinKarp(String text, String pattern) {
        return rabinKarp.search(text, pattern);
    }

    /**
     * Вычисление Z-функции для заданной строки.
     */
    public int[] zFunction(String text) {
        return zFunction.compute(text);
    }

    /**
     * Поиск шаблона в тексте с использованием алгоритма Кнута–Морриса–Пратта.
     */
    public int knuthMorrisPratt(String text, String pattern) {
        return knuthMorrisPratt.search(text, pattern);
    }
}
