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
        if (values.length > posi) {
            return values[posi].length > posj;
        } else {
            return false;
        }
    }

    @Override
    public Object next() throws NoSuchElementException {
        int result = values[posi][posj];
        if (values[posi].length > posj + 1) {
            posj++;
        } else {
            posi++;
            posj = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        IteratorArray ia = new IteratorArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9, 10, 11}});
        while (ia.hasNext()) {
            System.out.println(ia.next());
        }
        IteratorArray ia2 = new IteratorArray(new int[][]{});
        ia2.next();

    }
}
