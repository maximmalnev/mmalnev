package ru.job4j.array;
/**
 * BubbleSortClass.
 */
public class BubbleSort {
    /**
     * Sort.
     * @param array - входноймассив
     * @return  - отсортированный массив
     */
    public int[] sort(int[] array) {
        for (int i = (array.length - 2); i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (array[j + 1] < array[j]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
        }
        return array;
    }
}
