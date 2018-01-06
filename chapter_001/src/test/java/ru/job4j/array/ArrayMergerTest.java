package ru.job4j.array;
/**
 * ArrayMergerTest.
 *
 * @author Maxim Malnev (mazular@ya.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayMergerTest {
    /**
     * MergerTest.
     */
    @Test
    public void whenMergeArrayOneAndArrayTwoThenArrayMerge() {
        ArrayMerger mrg = new ArrayMerger();
        int[] arrayFirst = new int[] {2, 4, 6, 8};
        int[] arraySecond = new int[] {1, 3, 5, 7};
        int[] resultArray = mrg.merge(arrayFirst, arraySecond);
        int[] expectArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(resultArray, is(expectArray));
    }
}


