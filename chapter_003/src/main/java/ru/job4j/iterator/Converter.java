package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {


        return new Iterator<Integer>() {
            Iterator<Integer> temp = it.next();

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (temp.hasNext()) {
                    result = true;
                } else {
                    while (it.hasNext()) {
                        temp = it.next();
                        if (temp.hasNext()) {
                            result = true;
                            break;
                        }
                    }
                }
                return result;
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (temp.hasNext()) {
                    return temp.next();
                } else if (it.hasNext()) {
                    temp = it.next();
                    return temp.next();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}