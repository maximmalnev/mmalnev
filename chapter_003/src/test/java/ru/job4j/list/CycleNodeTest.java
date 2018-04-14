package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CycleNodeTest {

    @Test
    public void whenCollectionHasCycleReturnTrue() {

        CycleNode first = new CycleNode(1);
        CycleNode second = new CycleNode(2);
        CycleNode third = new CycleNode(3);
        CycleNode fourth = new CycleNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenCollectionHasNoCycleReturnFalse() {

        CycleNode first = new CycleNode(1);
        CycleNode second = new CycleNode(2);
        CycleNode third = new CycleNode(3);
        CycleNode fourth = new CycleNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;

        assertThat(first.hasCycle(first), is(false));
    }
}
