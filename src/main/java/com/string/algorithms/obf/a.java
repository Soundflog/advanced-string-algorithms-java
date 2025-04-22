package com.string.algorithms.obf;/*
 * Decompiled with CFR 0.152.
 */


public class a {
    public int a(String string, String string2) {
        int n = string.length();
        int n2 = string2.length();
        if (n2 > n || n2 == 0) {
            return -1;
        }
        int[] nArray = this.a(string2);
        int n3 = 0;
        int n4 = 0;
        while (n3 < n) {
            if (string.charAt(n3) == string2.charAt(n4)) {
                ++n3;
                if (++n4 != n2) continue;
                return n3 - n4;
            }
            if (n4 != 0) {
                n4 = nArray[n4 - 1];
                continue;
            }
            ++n3;
        }
        return -1;
    }

    private int[] a(String string) {
        int n = string.length();
        int[] nArray = new int[n];
        int n2 = 0;
        int n3 = 1;
        while (n3 < n) {
            if (string.charAt(n3) == string.charAt(n2)) {
                nArray[n3] = ++n2;
                ++n3;
                continue;
            }
            if (n2 != 0) {
                n2 = nArray[n2 - 1];
                continue;
            }
            nArray[n3] = 0;
            ++n3;
        }
        return nArray;
    }
}

