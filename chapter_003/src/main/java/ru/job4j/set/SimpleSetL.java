package ru.job4j.set;

import ru.job4j.list.LinList;

public class SimpleSetL<E> extends LinList<E> implements Iterable<E> {

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
        SimpleSetL<Integer> simpleSetL = new SimpleSetL<>();

        simpleSetL.add(1);
        simpleSetL.add(1);
        simpleSetL.add(2);
        simpleSetL.add(2);
        simpleSetL.add(3);

        System.out.println(simpleSetL);

    }
}
