/*
 * Decompiled with CFR 0.152.
 */
package com.string.output.com.string;


import com.string.output.com.string.algorithms.StringMatcher;

public class Main {
    public static void main(String[] args) {
        StringMatcher matcher = new StringMatcher();
        String text = Main.generateLargeText(1000000);
        String pattern = "pattern";
        long start = System.currentTimeMillis();
        int indexRK = matcher.rabinKarp(text, pattern);
        long durationRK = System.currentTimeMillis() - start;
        System.out.println("Rabin-Karp: \u0448\u0430\u0431\u043b\u043e\u043d \u043d\u0430\u0439\u0434\u0435\u043d \u043d\u0430 \u043f\u043e\u0437\u0438\u0446\u0438\u0438 " + indexRK + ", \u0432\u0440\u0435\u043c\u044f: " + durationRK + " \u043c\u0441.");
        start = System.currentTimeMillis();
        int[] z = matcher.zFunction(text);
        long durationZ = System.currentTimeMillis() - start;
        System.out.println("Z-\u0444\u0443\u043d\u043a\u0446\u0438\u044f: \u0432\u044b\u0447\u0438\u0441\u043b\u0435\u043d\u0438\u0435 \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d\u043e \u0437\u0430 " + durationZ + " \u043c\u0441.");
        start = System.currentTimeMillis();
        int indexKMP = matcher.knuthMorrisPratt(text, pattern);
        long durationKMP = System.currentTimeMillis() - start;
        System.out.println("KMP: \u0448\u0430\u0431\u043b\u043e\u043d \u043d\u0430\u0439\u0434\u0435\u043d \u043d\u0430 \u043f\u043e\u0437\u0438\u0446\u0438\u0438 " + indexKMP + ", \u0432\u0440\u0435\u043c\u044f: " + durationKMP + " \u043c\u0441.");
    }

    private static String generateLargeText(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            sb.append((char)(97 + i % 26));
        }
        int insertPosition = length / 2;
        sb.replace(insertPosition, insertPosition + "pattern".length(), "pattern");
        return sb.toString();
    }
}

