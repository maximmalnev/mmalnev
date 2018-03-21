package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;

public class NaturalOrderAscComparator implements Comparator<List<String>> {
    @Override
    public int compare(List<String> left, List<String> right) {
        int result = 0;
        if (left.size() < right.size()) {
            result = -1;
        } else if (left.size() > right.size()) {
            result = 1;
        } else {
            for (int i = 0; i < left.size(); i++) {
                String leftStr = left.get(i);
                String rightStr = right.get(i);
                if (leftStr.length() < rightStr.length()) {
                    result = -1;
                    break;
                } else if (leftStr.length() == rightStr.length()) {
                    result = leftStr.compareTo(rightStr);
                    break;
                } else {
                    result = 1;
                }
            }
        }
        return result;
    }
}
