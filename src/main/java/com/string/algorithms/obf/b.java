package com.string.algorithms.obf;/*
 * Decompiled with CFR 0.152.
 */

import java.util.Objects;

public class  b{
    private final int a = 256;
    private final int b = 101;

    public int a(String string, String string2) {
        int n;
        Objects.requireNonNull(string, "Text cannot be null");
        Objects.requireNonNull(string2, "Pattern cannot be null");
        int n2 = string.length();
        int n3 = string2.length();
        if (n3 > n2 || n3 == 0) {
            return -1;
        }
        int n4 = 1;
        int n5 = 0;
        int n6 = 0;
        for (n = 0; n < n3 - 1; ++n) {
            n4 = n4 * 256 % 101;
        }
        for (n = 0; n < n3; ++n) {
            n5 = (256 * n5 + string2.charAt(n)) % 101;
            n6 = (256 * n6 + string.charAt(n)) % 101;
        }
        for (n = 0; n <= n2 - n3; ++n) {
            if (n5 == n6 && string.regionMatches(n, string2, 0, n3)) {
                return n;
            }
            if (n >= n2 - n3 || (n6 = (256 * (n6 - string.charAt(n) * n4) + string.charAt(n + n3)) % 101) >= 0) continue;
            n6 += 101;
        }
        return -1;
    }
}

