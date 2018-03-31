package ru.job4j.generic;

import java.util.Iterator;

public class SimpleList<E> implements Iterable<E> {

    Object[] objects;
    int index = 0;

    public SimpleList(int size) {
        this.objects = new Object[size];
    }

    public void add(E value) {
        this.objects[index++] = value;
    }

    public E get(int position) {
        return (E) this.objects[position];

    }

    public void set(int index, E model) {
        this.objects[index] = model;
    }

    public void delete(int index) {
        for (int i = index; i < this.index; i++) {
            objects[i] = objects[i + 1];
        }
        this.index--;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < index && objects[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) objects[currentIndex++];
            }
        };
        return it;
    }

}
