package algorithms;

/*@
  requires text != null && pattern != null;
  ensures (\forall int i; 0 <= i && i < \result.length;
          (\exists int j; 0 <= j && j < text.length() - pattern.length() + 1;
          \result[i] == j));
*/

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
        int hpattern = 0, htext = 0, h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }

        for (int i = 0; i < m; i++) {
            hpattern = (base * hpattern + pattern.charAt(i)) % mod;
            htext = (base * htext + text.charAt(i)) % mod;
        }

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (hpattern == htext && text.substring(i, i + pattern.length()).equals(pattern)) {
                result.add(i);
            }
            if (i < text.length() - pattern.length()) {
                htext = (base * (htext - text.charAt(i) * h) + text.charAt(i + pattern.length())) % mod;
                htext = (htext + mod) % mod;
            }
        }
        return result;
    }
}
