package ru.job4j.array;
/**
 * ArrayDuplicatClass.
 */
import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Duplicate.
     * @param array - входноймассив
     * @return  - массив недублированных значений
     */
    public String[] remove(String[] array) {
        int duplicate = 0;

        for (int n = 0; n < array.length - 1 - duplicate; n++) {
            for (int i = n; i < array.length - 1 - duplicate; i++) {
                if (array[n].equals(array[i + 1])) {
                    String tmp = array[array.length - 1 - duplicate];
                    array[array.length - 1 - duplicate] = array[i + 1];
                    array[i + 1] = tmp;
                    duplicate++;
                    i--;
                }
            }
        }


        return Arrays.copyOf(array, array.length - duplicate);

    }
}
