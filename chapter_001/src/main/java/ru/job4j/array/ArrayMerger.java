package ru.job4j.array;

/**
 * ArrayMergerClass.
 */
public class ArrayMerger {
    /**
     * Merger.
     *
     * @param a - входной массив для объединения первый
     * @param b - входной массив для объединения второй
     * @return - объединенный массив упорядоченный
     */
    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int i = 0;

        while (i < result.length) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
            i++;
        }
        return result;
    }
}
