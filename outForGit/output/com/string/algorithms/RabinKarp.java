/*
 * Decompiled with CFR 0.152.
 */
package com.string.algorithms;

import java.util.Objects;

public class RabinKarp {
    private final int base = 256;
    private final int mod = 101;

    public int search(String text, String pattern) {
        int i;
        Objects.requireNonNull(text, "Text cannot be null");
        Objects.requireNonNull(pattern, "Pattern cannot be null");
        int n = text.length();
        int m = pattern.length();
        if (m > n || m == 0) {
            return -1;
        }
        int h = 1;
        int patternHash = 0;
        int textHash = 0;
        for (i = 0; i < m - 1; ++i) {
            h = h * 256 % 101;
        }
        for (i = 0; i < m; ++i) {
            patternHash = (256 * patternHash + pattern.charAt(i)) % 101;
            textHash = (256 * textHash + text.charAt(i)) % 101;
        }
        for (i = 0; i <= n - m; ++i) {
            if (patternHash == textHash && text.regionMatches(i, pattern, 0, m)) {
                return i;
            }
            if (i >= n - m || (textHash = (256 * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % 101) >= 0) continue;
            textHash += 101;
        }
        return -1;
    }
}

