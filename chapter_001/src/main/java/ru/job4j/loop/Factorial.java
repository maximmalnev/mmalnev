package ru.job4j.loop;
/**
 * FactorialClass.
 */
public class Factorial {
    /**
     * Calculate Factorial.
     * @param n - число от которого нужно найти факториал
     * @return факториал n
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
