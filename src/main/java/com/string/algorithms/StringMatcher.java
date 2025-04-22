package com.string.algorithms;

import com.string.algorithms.obf.*;

public class StringMatcher {
    private final b rabinKarp = new b();
    private final c zFunction = new c();
    private final a knuthMorrisPratt = new a();

    /**
     * Поиск шаблона в тексте с использованием алгоритма Рабина–Карпа.
     */
    public int rabinKarp(String text, String pattern) {
        return rabinKarp.a(text, pattern);
    }

    /**
     * Вычисление Z-функции для заданной строки.
     */
    public int[] zFunction(String text) {
        return zFunction.a(text);
    }

    /**
     * Поиск шаблона в тексте с использованием алгоритма Кнута–Морриса–Пратта.
     */
    public int knuthMorrisPratt(String text, String pattern) {
        return knuthMorrisPratt.a(text, pattern);
    }
}
