package ru.job4j.sort;
import java.util.*;
public class Department {
    public static List<String> sortAscendingly(String[] stringArray) {
        SortedSet<String> sortedList = new TreeSet<>();
        for (String string : stringArray) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '\\') {
                    sortedList.add(string.substring(0, i));
                }
                sortedList.add(string);
            }
        }
        List<String> list = new ArrayList<>();
        list.addAll(sortedList);
        List<List<String>> listString = new ArrayList<>();
        for (String tmp : list) {
            listString.add(divide(tmp));
        }
        System.out.println(listString);
        Collections.sort(listString, new NaturalOrderAscComparator());
        list = combine(listString);
        return list;
    }

    public static List<String> sortDescendingly(String[] stringArray) {
        Set<String> sortedSet = new TreeSet<>();
        for (String string : stringArray) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '\\') {
                    sortedSet.add(string.substring(0, i));
                }
                sortedSet.add(string);
            }
        }
        List<String> list = new ArrayList<>();
        list.addAll(sortedSet);
        Collections.sort(list, new NaturalOrderComparator());
        List<String> level1List = new ArrayList<>();
        for (String string : list) {
            if (ElementQuantity.quant(string, '\\') == 0) {
                level1List.add(string);
            }
        }
        Collections.reverse(level1List);
        return level1List;
    }

    public static class ElementQuantity {
        static int quant(String string, Character character) {
            int res = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == character) {
                    res++;
                }
            }
            return res;
        }
    }

    public static List<String> divide(String string) {
        List<String> stringList = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < string.length(); j++) {
            if (string.charAt(j) == '\\') {
                stringList.add(string.substring(i, j));
                i = j + 1;
            } else if (j == string.length() - 1) {
                stringList.add(string.substring(i, j+1));
            }
        }
        return stringList;
    }

    public static List<String> combine(List<List<String>> list) {
        List<String> stringList = new ArrayList<>();
        for (List<String> strList : list) {
            String tmp = new String();
            for (int i = 0; i < strList.size(); i++) {
                if (i != 0) {
                    tmp = tmp + "\\" + strList.get(i);
                } else {
                    tmp = tmp + strList.get(i);
                }

            }
            stringList.add(tmp);
        }
        return stringList;
    }

    public static void main(String[] args) {
        String[] depsToSort = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K11\\SK1"};
        System.out.println("Прямая сортировка");
        System.out.println(sortAscendingly(depsToSort));
        //System.out.println("Обратная сортировка");
        //System.out.println(department.sortDescendingly(depsToSort));
    }
}


