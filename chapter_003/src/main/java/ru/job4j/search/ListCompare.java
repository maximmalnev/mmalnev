package ru.job4j.search;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int maxLen = Math.max(left.length(), right.length());
        int result = 0;
        for (int i = 0; i < maxLen; i++) {
            if (left.length() - 1 < i) {
                result = -1;
                break;
            } else if (right.length() - 1 < i) {
                result = 1;
                break;
            } else if (left.charAt(i) < right.charAt(i)) {
                result = -1;
                break;
            } else if (left.charAt(i) > right.charAt(i)) {
                result = 1;
                break;
            }
        }
        return result;
    }
}

