package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    private final int[] values;
    private int pos = 0;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        if (pos < values.length) {
            for (int i = pos; i < values.length; i++) {
                if (values[i] % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (pos < values.length) {
            for (int i = pos; i < values.length; i++) {
                if (values[i] % 2 == 0) {
                    pos = i + 1;
                    return values[i];
                }
            }
        }
        throw new NoSuchElementException();
    }
}
