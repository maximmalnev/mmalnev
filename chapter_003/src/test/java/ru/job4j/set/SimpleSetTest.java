package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

public class SimpleSetTest {

    @Test
    public void add() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>(10);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);

        assertThat(simpleSet.get(0), is(1));
        assertThat(simpleSet.get(1), is(2));
        assertThat(simpleSet.get(2), is(3));
        assertThat(simpleSet.get(3), is(nullValue()));
    }
}