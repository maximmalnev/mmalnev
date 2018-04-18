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
            }
        }
        if (!result) {
            super.add(value);
        }
    }

    public static void main(String[] args) {
        SimpleSet<Integer> simpleSet = new SimpleSet<>(10);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);

        System.out.println(simpleSet.get(0));
        System.out.println(simpleSet.get(1));
        System.out.println(simpleSet.get(2));
        System.out.println(simpleSet.get(3));


    }
}
