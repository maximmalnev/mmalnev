package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicList<E> implements Iterable<E> {

    private Object[] container;
    public int index = 0;
    private Integer modCount = 0;

    public DynamicList(int size) {
        container = new Object[size];
    }

    public DynamicList() {
        container = new Object[10];
    }

    public void add(E value) {
        if (index < container.length) {
            container[index++] = value;
            modCount++;
        } else {
            Object[] tmpContainer = new Object[container.length + 10];
            System.arraycopy(container, 0, tmpContainer, 0, container.length);
            container = tmpContainer;
            container[index++] = value;
            modCount++;
        }
    }

    E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() throws ConcurrentModificationException {
        Iterator<E> iterator = new Iterator<E>() {

            private int currentIndex = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                } else if (currentIndex < index && container[currentIndex] != null) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                return (E) container[currentIndex++];
            }
        };
        return iterator;
    }
}