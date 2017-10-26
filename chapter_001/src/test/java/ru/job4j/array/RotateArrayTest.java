package ru.job4j.array;
/**
 * RotateArrayTest.
 *
 * @author Maxim Malnev (mazular@ya.ru)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {
    /**
     * RotateTest.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
        RotateArray ra = new RotateArray();
        int[][] array = new int[][] {{1, 2}, {4, 5}};
        int[][] resultArray = ra.rotate(array);
        int[][] expectArray = new int[][] {{4, 1}, {5, 2}};
        assertThat(resultArray, is(expectArray));
    }
    /**
     * RotateTest.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 3 на 3.
        RotateArray ra = new RotateArray();
        int[][] array = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] resultArray = ra.rotate(array);
        int[][] expectArray = new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(resultArray, is(expectArray));
    }
}
