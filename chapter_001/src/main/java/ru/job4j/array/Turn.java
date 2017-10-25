package ru.job4j.array;
/**
 * ArrayClass.
 */
public class Turn {
    /**
     * Back.
     * @param array - входноймассив
     * @return  - пееревернутый массив
     */
    public int[] back(int[] array) {
        for (int i = 0; i < (array.length / 2); i++) {
            int a = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = a;
        }
        return array;
    }
}
