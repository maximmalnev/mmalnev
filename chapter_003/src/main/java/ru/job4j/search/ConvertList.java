package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public List<Integer> toList(int[][] array) {
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                arrayList.add(array[i][j]);
            }
        }
        return arrayList;
    }


    public int[][] toArray(List<Integer> list, int rows) {
        int x;
        if (list.size() % rows == 0) {
            x = list.size() / rows;
        } else {
            x = (list.size() / rows) + 1;
        }
        int[][] array = new int[rows][x];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (list.size() != 0) {
                    array[i][j] = list.get(0);
                    list.remove(0);
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
