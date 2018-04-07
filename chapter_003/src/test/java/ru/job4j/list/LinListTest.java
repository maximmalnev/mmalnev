package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LinListTest {

    @Test
    public void whenAddValueThenIncreaseSize() {
        LinList<Integer> linkedList = new LinList<>();
        linkedList.add(1);
        linkedList.add(2);

        assertThat(linkedList.get(1), is(1));
        assertThat(linkedList.get(2), is(2));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifyCollectionThenIteratorReturnException() {
        LinList<Integer> linkedList = new LinList<>();
        linkedList.add(1);
        linkedList.add(2);

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            linkedList.add(4);
        }
    }
}
