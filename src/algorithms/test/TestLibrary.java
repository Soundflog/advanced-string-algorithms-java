package algorithms.test;

import algorithms.*;

import java.util.List;

public class TestLibrary {

    public static void main(String[] args) {
        // Тест алгоритма Рабина-Карпа
        RabinKarp rk = new RabinKarp();
        List<Integer> result = rk.search("ababcabcababc", "abc");
        System.out.println("Rabin-Karp result: " + result);

        // Тест Z-функции
        ZFunction zf = new ZFunction();
        int[] z = zf.compute("aaabaab");
        System.out.print("Z-Function result: ");
        for (int value : z) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Тест алгоритма Кнута-Морриса-Пратта
        KMP kmp = new KMP();
        List<Integer> kmpResult = kmp.search("ababcabcababc", "abc");
        System.out.println("KMP result: " + kmpResult);
    }
}
