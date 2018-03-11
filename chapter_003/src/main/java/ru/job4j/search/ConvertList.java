package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
public class ConvertList {
    public static void main(String[] args) {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        list.add(new int[]{7, 8});
        System.out.println(convertList.convert(list));
    }
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
    public List<Integer> convert(List<int[]> list) {
        List<Integer> converted = new ArrayList<>();
        for (int[] array : list) {
            for (int i = 0; i < array.length; i++) {
                converted.add(array[i]);
            }
        }
        return converted;
    }
}
