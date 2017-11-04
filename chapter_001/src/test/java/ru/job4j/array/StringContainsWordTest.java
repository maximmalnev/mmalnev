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

public class StringContainsWordTest {
    /**
     * StringTest.
     */
    @Test
    public void whenStringContainsWordThenReturnTrue() {
        StringContainsWord scw = new StringContainsWord();
        String stringOriginal = "Привет";
        String stringSub = "иве";
        boolean expected = true;
        boolean result = scw.contains(stringOriginal, stringSub);
        assertThat(result, is(expected));
    }
}
