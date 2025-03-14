import stringalgorithms.StringMatcher;

public class Main {
    /**
     * Демонстрация работы оптимизированных алгоритмов и проведение простого профилирования.
     * Генерируется большой текст для замеров времени работы алгоритмов.
     */
    public static void main(String[] args) {
        StringMatcher matcher = new StringMatcher();

        // Генерация большого текста (1 миллион символов)
        String text = generateLargeText(1_000_000);
        // Пример шаблона для поиска
        String pattern = "pattern";

        // Замер времени работы алгоритма Рабина–Карпа
        long start = System.currentTimeMillis();
        int indexRK = matcher.rabinKarp(text, pattern);
        long durationRK = System.currentTimeMillis() - start;
        System.out.println("Rabin-Karp: шаблон найден на позиции " + indexRK + ", время: " + durationRK + " мс.");

        // Замер времени работы Z-функции (вычисление массива Z для всего текста)
        start = System.currentTimeMillis();
        int[] z = matcher.zFunction(text);
        long durationZ = System.currentTimeMillis() - start;
        System.out.println("Z-функция: вычисление завершено за " + durationZ + " мс.");

        // Замер времени работы алгоритма Кнута–Морриса–Пратта
        start = System.currentTimeMillis();
        int indexKMP = matcher.knuthMorrisPratt(text, pattern);
        long durationKMP = System.currentTimeMillis() - start;
        System.out.println("KMP: шаблон найден на позиции " + indexKMP + ", время: " + durationKMP + " мс.");
    }

    /**
     * Генерирует строку заданной длины, состоящую из повторяющихся символов.
     * @param length Желаемая длина строки.
     * @return Сгенерированная строка.
     */
    private static String generateLargeText(int length) {
        StringBuilder sb = new StringBuilder(length);
        // Генерация текстовой последовательности из строчных букв латинского алфавита
        for (int i = 0; i < length; i++) {
            sb.append((char)('a' + (i % 26)));
        }
        // Вставляем шаблон в середину текста для демонстрации поиска
        int insertPosition = length / 2;
        sb.replace(insertPosition, insertPosition + "pattern".length(), "pattern");
        return sb.toString();
    }
}
