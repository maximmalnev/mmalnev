package ru.job4j.max;

/**
 * MaxClass.
 */
public class Max {
    /**
     * Max.
     * @param first - first param
     * @param second - second param
     * @return maximum of two
     */
    public int max(int first, int second) {
        int result;
        result = first > second ? first : second;
        return result;
    }
}
