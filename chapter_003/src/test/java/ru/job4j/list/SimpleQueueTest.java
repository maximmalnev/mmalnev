package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleQueueTest {

    @Test
    public void queueTest() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);

        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
        assertThat(simpleQueue.poll(), is(nullValue()));
    }
}