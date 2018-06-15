package ru.job4j.set;

import ru.job4j.list.LinList;

public class SimpleSetL<E> extends LinList<E> implements Iterable<E> {

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
