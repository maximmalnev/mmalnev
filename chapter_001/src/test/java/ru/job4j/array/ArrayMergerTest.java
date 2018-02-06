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
     *  добавь еще тестов. когда оба массива одинаковые. когда первый меньше. когда первый пустой. и наоборот для второго.

     когда везед одинаковые числа
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
    public void whenMergeArrayOneAndArrayTwoThenArrayMergeTwo() {
        ArrayMerger mrg = new ArrayMerger();
        int[] arrayFirst = new int[] {1, 1, 1, 1};
        int[] arraySecond = new int[] {1, 1, 1, 1};
        int[] resultArray = mrg.merge(arrayFirst, arraySecond);
        int[] expectArray = new int[] {1, 1, 1, 1, 1, 1, 1, 1};
        assertThat(resultArray, is(expectArray));
    }
    public void whenMergeArrayOneAndArrayTwoThenArrayMergeThree() {
        ArrayMerger mrg = new ArrayMerger();
        int[] arrayFirst = new int[] {2, 4, 6};
        int[] arraySecond = new int[] {1, 3, 5, 7};
        int[] resultArray = mrg.merge(arrayFirst, arraySecond);
        int[] expectArray = new int[] {1, 2, 3, 4, 5, 6, 7};
        assertThat(resultArray, is(expectArray));
    }
    public void whenMergeArrayOneAndArrayTwoThenArrayMergeFour() {
        ArrayMerger mrg = new ArrayMerger();
        int[] arrayFirst = new int[] {};
        int[] arraySecond = new int[] {1, 3, 5, 7};
        int[] resultArray = mrg.merge(arrayFirst, arraySecond);
        int[] expectArray = new int[] {1, 3, 5, 7};
        assertThat(resultArray, is(expectArray));
    }
    public void whenMergeArrayOneAndArrayTwoThenArrayMergeFive() {
        ArrayMerger mrg = new ArrayMerger();
        int[] arrayFirst = new int[] {2, 4, 6, 8};
        int[] arraySecond = new int[] {1, 3, 5};
        int[] resultArray = mrg.merge(arrayFirst, arraySecond);
        int[] expectArray = new int[] {1, 2, 3, 4, 5, 6, 8};
        assertThat(resultArray, is(expectArray));
    }
    public void whenMergeArrayOneAndArrayTwoThenArrayMergeSix() {
        ArrayMerger mrg = new ArrayMerger();
        int[] arrayFirst = new int[] {2, 4, 6, 8};
        int[] arraySecond = new int[] {};
        int[] resultArray = mrg.merge(arrayFirst, arraySecond);
        int[] expectArray = new int[] {2, 4, 6, 8};
        assertThat(resultArray, is(expectArray));
    }

}


