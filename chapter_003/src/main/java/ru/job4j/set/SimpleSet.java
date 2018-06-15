package ru.job4j.set;

import ru.job4j.generic.SimpleList;

public class SimpleSet<E> extends SimpleList<E> implements Iterable<E> {

    SimpleSet(int size) {
        super(size);
    }

    @Override
    public void add(E value) {
        boolean result = false;
        for (E tmp : this) {
            if (tmp.equals(value)) {
                result = true;
                break;
            }
        }
        if (!result) {
            super.add(value);
        }
    }
}
