package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;

public class NaturalOrderDescComparator implements Comparator<List<String>> {
    @Override
    public int compare(List<String> left, List<String> right) {
        int result = 0;
        for (int i = 0; i < Math.min(left.size(), right.size()); i++) {
            String leftStr = left.get(i);
            String rightStr = right.get(i);
            if (leftStr.length() > rightStr.length()) {
                result = -1;
                break;
            } else if (leftStr.length() < rightStr.length()) {
                result = 1;
                break;
            } else {
                if (leftStr.compareTo(rightStr) != 0) {
                    result = -leftStr.compareTo(rightStr);
                    break;
                }
            }
        }
        return result;
    }
}
