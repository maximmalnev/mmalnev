package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleListTest {

    @Test
    public void whenTypeIntegerThenReturnInteger() {
        SimpleList<Integer> simple = new SimpleList<Integer>(4);
        simple.add(2);
        Integer result = simple.get(0);
        assertThat(result, is(2));
    }
}