/*
 * Decompiled with CFR 0.152.
 */
package com.string.algorithms;

import com.string.algorithms.KMP;
import com.string.algorithms.RabinKarp;
import com.string.algorithms.ZFunction;

public class StringMatcher {
    private final RabinKarp rabinKarp = new RabinKarp();
    private final ZFunction zFunction = new ZFunction();
    private final KMP knuthMorrisPratt = new KMP();

    public int rabinKarp(String text, String pattern) {
        return this.rabinKarp.search(text, pattern);
    }

    public int[] zFunction(String text) {
        return this.zFunction.compute(text);
    }

    public int knuthMorrisPratt(String text, String pattern) {
        return this.knuthMorrisPratt.search(text, pattern);
    }
}

