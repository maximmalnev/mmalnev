package ru.job4j.loop;
/**
 * CounterClass.
 */
public class Counter {
    /**
     * Counter.
     * @param start - start parameter
     * @param finish - finish parameter
     * @return sum of even
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
