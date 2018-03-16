package ru.job4j.sort;

import java.util.Comparator;

public class DescComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        //final int name = o1.getName().compareTo(o2.getName());
        //return name != 0 ? name : o1.getAge().compareTo(o2.getAge());
        final Integer len1 = o1.length();
        final Integer len2 = o2.length();

        //обычная сортировка
        //return o1.compareTo(o2) < 0 ? o1.compareTo(o2) : len1.compareTo(len2);
        //return len1.compareTo(len2) < 0 ? len1.compareTo(len2) : o2.compareTo(o1);

        int result = 0;
        if (len1.compareTo(len2) < 0) {
            result = 1;
        } else {
            if (o1.compareTo(o2) > 0) {
                result = -1;
            } else {
                result = 1;
            }
        }
        return result;

    }
}