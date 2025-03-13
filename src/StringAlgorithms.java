import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAlgorithms {

    /**
     * Алгоритм Рабина–Карпа для поиска подстроки.
     * @param text Исходный текст
     * @param pattern Искомый шаблон
     * @return Список позиций начала вхождения шаблона в текст
     */
    public static List<Integer> rabinKarp(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        if (m > n) return result;

        int base = 256; // Основание (количество возможных символов)
        int mod = 101;  // Простое число для взятия по модулю
        int hpattern = 0;
        int htext = 0;
        int h = 1; // Значение base^(m-1) mod mod

        // Вычисление h = (base^(m-1)) % mod
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }
        // Вычисление начальных хешей для шаблона и первого окна текста
        for (int i = 0; i < m; i++) {
            hpattern = (base * hpattern + pattern.charAt(i)) % mod;
            htext = (base * htext + text.charAt(i)) % mod;
        }
        // Основной цикл алгоритма
        for (int i = 0; i <= n - m; i++) {
            if (hpattern == htext) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(i);
                }
            }
            if (i < n - m) {
                htext = (base * (htext - text.charAt(i) * h) + text.charAt(i + m)) % mod;
                if (htext < 0) {
                    htext += mod;
                }
            }
        }
        return result;
    }

    /**
     * Вычисление Z-функции для строки.
     * @param s Исходная строка
     * @return Массив Z, где Z[i] – длина наибольшего общего префикса строки s и ее суффикса, начинающегося с i
     */
    public static int[] computeZ(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && s.charAt(R - L) == s.charAt(R)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (Z[k] < R - i + 1) {
                    Z[i] = Z[k];
                } else {
                    L = i;
                    while (R < n && s.charAt(R - L) == s.charAt(R)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }

    /**
     * Алгоритм Кнута–Морриса–Пратта для поиска подстроки.
     * @param text Исходный текст
     * @param pattern Искомый шаблон
     * @return Список позиций начала вхождения шаблона в текст
     */
    public static List<Integer> kmp(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        if (m > n) return result;
        int[] prefix = computePrefixFunction(pattern);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefix[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                result.add(i - m + 1);
                j = prefix[j - 1];
            }
        }
        return result;
    }

    /**
     * Вычисление префикс-функции для алгоритма КМП.
     * @param pattern Искомый шаблон
     * @return Массив префикс-функции
     */
    public static int[] computePrefixFunction(String pattern) {
        int m = pattern.length();
        int[] prefix = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = prefix[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }
        return prefix;
    }

    // Метод main для демонстрации работы алгоритмов
    public static void main(String[] args) {
        String text = "abracadabra";
        String pattern = "abra";
        System.out.println("Результаты алгоритма Рабина–Карпа: " + rabinKarp(text, pattern));
        System.out.println("Результаты алгоритма КМП: " + kmp(text, pattern));
        System.out.println("Z-функция для строки '" + pattern + "': " + Arrays.toString(computeZ(pattern)));
    }
}

