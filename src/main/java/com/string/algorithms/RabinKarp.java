package com.string.algorithms;

/*@
  requires text != null && pattern != null;
  ensures (\forall int i; 0 <= i && i < \result.length;
          (\exists int j; 0 <= j && j < text.length() - pattern.length() + 1;
          \result[i] == j));
*/

import java.util.Objects;

public class RabinKarp {
    // Опорные константы для хеширования
    private final int base = 256;
    private final int mod = 101;

    /**
     * Поиск первого вхождения шаблона в тексте с оптимизированным пересчётом хеша.
     * @param text Исходный текст.
     * @param pattern Искомый шаблон.
     * @return Индекс первого вхождения шаблона или -1, если совпадения не найдены.
     */
    public int search(String text, String pattern) {
        Objects.requireNonNull(text, "Text cannot be null");
        Objects.requireNonNull(pattern, "Pattern cannot be null");

        int n = text.length();
        int m = pattern.length();
        if (m > n || m == 0) return -1;

        int h = 1; // base^(m-1) % mod
        int patternHash = 0, textHash = 0;

        // Предвычисление значения h для оптимизации пересчёта хеша
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }

        // Вычисление начальных хешей для шаблона и первого окна текста
        for (int i = 0; i < m; i++) {
            patternHash = (base * patternHash + pattern.charAt(i)) % mod;
            textHash = (base * textHash + text.charAt(i)) % mod;
        }

        // Проход по тексту с использованием скользящего окна
        for (int i = 0; i <= n - m; i++) {
            // Сравнение хешей
            if (patternHash == textHash) {
                // Если хеши совпадают, выполняется посимвольная проверка
                if (text.regionMatches(i, pattern, 0, m)) {
                    return i;
                }
            }
            // Пересчёт хеша для следующего окна
            if (i < n - m) {
                textHash = (base * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % mod;
                if (textHash < 0) {
                    textHash += mod;
                }
            }
        }
        return -1;
    }
}