package com.string.algorithms;

public class KMP {

    /**
     * @requires text != null && pattern != null
     * @ensures (\forall int i; 0 <= i && i < \result.size(); text.substring(\result.get(i), \result.get(i) + pattern.length()).equals(pattern))
     */
    /**
     * Поиск первого вхождения шаблона в тексте с использованием алгоритма Кнута–Морриса–Пратта.
     * @param text Исходный текст.
     * @param pattern Искомый шаблон.
     * @return Индекс первого вхождения шаблона или -1, если совпадения не найдены.
     */
    public int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m > n || m == 0) return -1;

        int[] lps = computePrefix(pattern);
        int i = 0, j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m)
                    return i - j;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return -1;
    }

    /**
     * Вычисление префикс-функции (lps — longest proper prefix which is also suffix) для шаблона.
     * @param pattern Шаблон для которого рассчитывается префикс-функция.
     * @return Массив lps.
     */
    private int[] computePrefix(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
