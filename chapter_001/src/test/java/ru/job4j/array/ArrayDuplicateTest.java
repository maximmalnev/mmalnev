package ru.job4j.array;
/**
 * ArrayDuplicateTest.
 *
 * @author Maxim Malnev (mazular@ya.ru)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    /**
     * DuplicateTest.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate dupl = new ArrayDuplicate();
        String[] array = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир", "Привет", "Привет"};
        String[] resultArray = dupl.remove(array);
        String[] expectArray = new String[] {"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expectArray));
    }


}