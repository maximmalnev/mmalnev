package ru.job4j.loop;
/**
 * FactorialTest.
 *
 * @author Maxim Malnev (mazular@ya.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FactorialTestClass.
 */
public class FactorialTest {
    /**
     * FactorialTest.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        //напишите здесь тест, проверяющий, что факториал для числа 5 равен 120.
        Factorial fct = new Factorial();
        int result = fct.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }
    /**
     * FactorialTest.
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        //напишите здесь тест, проверяющий, что факториал для числа 0 равен 1.
        Factorial fct = new Factorial();
        int result = fct.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }
}
