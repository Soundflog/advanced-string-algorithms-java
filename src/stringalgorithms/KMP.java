package stringalgorithms;

import java.util.ArrayList;
import java.util.List;

public class KMP {

    public List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int[] lps = computePrefix(pattern);
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                result.add(i - j + 1);
                j = lps[j - 1];
            }
        }
        return result;
    }

    private int[] computePrefix(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }
}
