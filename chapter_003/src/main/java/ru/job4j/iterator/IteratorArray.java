package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorArray implements Iterator {

    private final int[][] values;
    private int posi = 0;
    private int posj = 0;

    public IteratorArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return !(values.length == posi + 1 && values[posi].length == posj);
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (values.length == 0) {
            throw new NoSuchElementException();
        } else if (posj < values[posi].length) {
            return values[posi][posj++];
        } else {
            do {
                posi++;
                posj = 0;
            } while (values[posi].length == 0 && posi < values.length);
            if (posi < values.length && values[posi].length != 0) {
                return values[posi][posj++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
