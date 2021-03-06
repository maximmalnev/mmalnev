package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenTreeIsBinaryReturnTrue() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }

    @Test
    public void whenTreeIsNotBinaryReturnFalse() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.isBinary(),
                is(false)
        );
    }

    @Test
    public void whenIteratorHasNext() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        Iterator iterator = tree.iterator();
        iterator.next();
        assertTrue(iterator.hasNext());
    }

    @Test
    public void whenIteratorHaveNoNext() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        Iterator iterator = tree.iterator();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }
}