package ru.job4j.sort;

import java.util.*;

public class Department {

    public SortedSet<String> sortAscendingly(String[] stringArray) {
        SortedSet<String> sortedList = new TreeSet<>();
        for (String string : stringArray) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '\\') {
                    sortedList.add(string.substring(0, i));
                }
                sortedList.add(string);
            }
        }
        return sortedList;
    }

    public List<String> sortDescendingly(String[] stringArray) {
        Set<String> sortedSet = new TreeSet<>();
        for (String string : stringArray) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '\\') {
                    sortedSet.add(string.substring(0, i));
                }
                sortedSet.add(string);
            }
        }
        List<String> sortedList = new ArrayList<>();
        sortedList.addAll(sortedSet);
        Collections.sort(sortedList, new DescComparator());
        return sortedList;
    }

    public static void main(String[] args) {
        String[] depsToSort = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        Department department = new Department();
        System.out.println(department.sortAscendingly(depsToSort));
        System.out.println(department.sortDescendingly(depsToSort));
    }
}


