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
    /**
     * Max.
     * @param first - first param
     * @param second - second param
     * @param third - third param
     * @return maximum of three
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
