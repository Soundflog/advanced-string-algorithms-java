package com.string.algorithms.obf;/*
 * Decompiled with CFR 0.152.
 */

public class d {
    public int[] a(String string) {
        int n = string.length();
        int[] nArray = new int[n];
        int n2 = 0;
        int n3 = 0;
        for (int i = 1; i < n; ++i) {
            if (i <= n3) {
                nArray[i] = Math.min(n3 - i + 1, nArray[i - n2]);
            }
            while (i + nArray[i] < n && string.charAt(nArray[i]) == string.charAt(i + nArray[i])) {
                int n4 = i;
                nArray[n4] = nArray[n4] + 1;
            }
            if (i + nArray[i] - 1 <= n3) continue;
            n2 = i;
            n3 = i + nArray[i] - 1;
        }
        return nArray;
    }
}

