package ru.job4j.array;
/**
 * TurnTest.
 *
 * @author Maxim Malnev (mazular@ya.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import ru.job4j.loop.Factorial;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    /**
     * TurnTest.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с чётным числом элементов, например {2, 6, 1, 4}.
        Turn trn = new Turn();
        int[] array = new int[] {2, 6, 1, 4};
        int[] result = trn.back(array);
        int[] expected = new int[] {4, 1, 6, 2};
        assertThat(result, is(expected));
    }
    /**
     * TurnTest.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов, например {1, 2, 3, 4, 5}.
        Turn trn = new Turn();
        int[] array = new int[] {1, 2, 3, 4, 5};
        int[] result = trn.back(array);
        int[] expected = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expected));
    }
}
