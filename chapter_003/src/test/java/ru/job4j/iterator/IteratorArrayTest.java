package ru.job4j.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorArrayTest {

    @Test
    public void whenHasNextReturnTrue() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2, 3}, {4, 5}, {6}});
        it.next();
        it.next();
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenNoHasNextReturnFalse() {
        IteratorArray it = new IteratorArray(new int[][]{{1}, {4}});
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenGetSecondElementReturnIt() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2, 3}, {4, 5}, {6}});
        it.next();
        it.next();
        assertThat(it.next(), is(3));
    }
}
