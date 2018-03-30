package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator {

    private final int[] values;
    private int pos = 0;

    public PrimeIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        if (pos < values.length) {
            for (int i = pos; i < values.length; i++) {
                if (checkSimple(values[i])) {
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
                if (checkSimple(values[i])) {
                    pos = i + 1;
                    return values[i];
                }
            }
        }
        throw new NoSuchElementException();
    }

    public static boolean checkSimple(int i) {
        if (i <= 1) {
            return false;
        } else if (i <= 3) {
            return true;
        } else if (i % 2 == 0 || i % 3 == 0) {
            return false;
        }
        int n = 5;
        while (n * n <= i) {
            if (i % n == 0 || i % (n + 2) == 0) {
                return false;
            }
            n = n + 6;
        }
        return true;
    }
}
