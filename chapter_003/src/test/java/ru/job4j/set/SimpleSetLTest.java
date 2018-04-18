package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetLTest {

    @Test
    public void add() {
        SimpleSetL<Integer> simpleSet = new SimpleSetL<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(3);

        assertThat(simpleSet.get(1), is(1));
        assertThat(simpleSet.get(2), is(2));
        assertThat(simpleSet.get(3), is(3));
        assertThat(simpleSet.get(4), is(nullValue()));
    }
}