package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleStackTest {

    @Test
    public void stackTest() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);

        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
        assertThat(simpleStack.poll(), is(nullValue()));
    }
}