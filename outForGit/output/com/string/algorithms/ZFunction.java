/*
 * Decompiled with CFR 0.152.
 */
package com.string.algorithms;

public class ZFunction {
    public int[] compute(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int L = 0;
        int R = 0;
        for (int i = 1; i < n; ++i) {
            if (i <= R) {
                Z[i] = Math.min(R - i + 1, Z[i - L]);
            }
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                int n2 = i;
                Z[n2] = Z[n2] + 1;
            }
            if (i + Z[i] - 1 <= R) continue;
            L = i;
            R = i + Z[i] - 1;
        }
        return Z;
    }
}

