package ru.job4j.loop;
/**
 * CounterTest.
 *
 * @author Maxim Malnev (mazular@ya.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTestClass.
 */
public class CounterTest {
    /**
     * CounterTest.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        //напишите здесь тест, проверяющий, что сумма чётных чисел от 1 до 10 при вызове метода counter.add будет равна 30.
        Counter cnt = new Counter();
        int result = cnt.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}
