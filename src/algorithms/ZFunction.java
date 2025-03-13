package algorithms;

public class ZFunction {

    public int[] compute(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i <= R) {
                Z[i] = Math.min(R - i + 1, Z[i - L]);
            }
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > R) {
                L = i;
                R = i + Z[i] - 1;
            }
        }
        return Z;
    }
}

