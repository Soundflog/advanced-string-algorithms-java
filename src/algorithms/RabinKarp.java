package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {

    public List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        if (m > n) return result;

        int base = 256;
        int mod = 101;
        int hpattern = 0;
        int htext = 0;
        int h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }
        for (int i = 0; i < m; i++) {
            hpattern = (base * hpattern + pattern.charAt(i)) % mod;
            htext = (base * htext + text.charAt(i)) % mod;
        }

        for (int i = 0; i <= n - m; i++) {
            if (hpattern == htext) {
                if (text.regionMatches(i, pattern, 0, m)) {
                    result.add(i);
                }
            }
            if (i < n - m) {
                htext = (base * (htext - text.charAt(i) * h) + text.charAt(i + m)) % mod;
                if (htext < 0) htext += mod;
            }
        }
        return result;
    }
}
