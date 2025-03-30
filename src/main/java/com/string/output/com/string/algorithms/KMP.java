/*
 * Decompiled with CFR 0.152.
 */
package com.string.output.com.string.algorithms;

public class KMP {
    public int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m > n || m == 0) {
            return -1;
        }
        int[] lps = this.computePrefix(pattern);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                ++i;
                if (++j != m) continue;
                return i - j;
            }
            if (j != 0) {
                j = lps[j - 1];
                continue;
            }
            ++i;
        }
        return -1;
    }

    private int[] computePrefix(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i] = ++len;
                ++i;
                continue;
            }
            if (len != 0) {
                len = lps[len - 1];
                continue;
            }
            lps[i] = 0;
            ++i;
        }
        return lps;
    }
}

