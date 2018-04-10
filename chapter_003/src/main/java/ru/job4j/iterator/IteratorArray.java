package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorArray implements Iterator {

    private final int[][] values;
    private int row = 0;
    private int cell = 0;

    public IteratorArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return !(values.length == 0 || (values.length - 1 == row && values[row].length == cell));
    }

    @Override
    public Object next() throws NoSuchElementException {
        int result;
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            if (cell != values[row].length) {
                result = values[row][cell++];
            } else {
                cell = 0;
                result = values[++row][cell++];
            }
        }
        return result;
    }
}
