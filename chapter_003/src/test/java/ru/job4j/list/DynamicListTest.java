package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.ConcurrentModificationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicListTest {

    @Test
    public void whenAddValueThenIncreaseSize() {
        DynamicList<Integer> dynamicList = new DynamicList<>(1);
        dynamicList.add(1);
        dynamicList.add(2);

        assertThat(dynamicList.get(0), is(1));
        assertThat(dynamicList.get(1), is(2));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifyCollectionThenIteratorReturnException() {
        DynamicList<Integer> dynamicList = new DynamicList<>(1);
        dynamicList.add(1);
        dynamicList.add(2);

        Iterator iterator = dynamicList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            dynamicList.add(4);
        }
    }
}
