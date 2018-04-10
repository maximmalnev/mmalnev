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
        boolean result = false;
        if (pos < values.length) {
            for (int i = pos; i < values.length; i++) {
                if (values[i] % 2 == 0) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Object next() throws NoSuchElementException {
        int result = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            for (int i = pos; i < values.length; i++) {
                if (values[i] % 2 == 0) {
                    result = values[i];
                    pos = i + 1;
                    break;
                }
            }
        }
        return result;
    }
}
