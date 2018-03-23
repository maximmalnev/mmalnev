package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;

public class NaturalOrderDescComparator implements Comparator<List<String>> {
    @Override
    public int compare(List<String> left, List<String> right) {
        int result = 0;
        for (int i = 0; i < Math.min(left.size(), right.size()); i++) {

            int j = Math.min(left.size(), right.size()) - 1;
            String leftStr = left.get(i);
            String rightStr = right.get(i);
            System.out.println("i:" + i + " max:" + j  + " left:" + leftStr + " right:" + rightStr);

            if (leftStr.length() > rightStr.length()) {
                result = -1;
                break;
            } else if (leftStr.length() == rightStr.length()) {
                result = -leftStr.compareTo(rightStr);
                if (result == 1 || result == -1){
                    break;
                }
            } else {
                result = 1;
            }
        }
        return result;
    }
}
