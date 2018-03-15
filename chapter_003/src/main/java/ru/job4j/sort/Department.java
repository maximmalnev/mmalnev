package ru.job4j.sort;

import java.util.SortedSet;
import java.util.TreeSet;

public class Department {

    public SortedSet<String> sortAscendingly(String[] stringArray) {
        SortedSet<String> sortedList = new TreeSet<>();
        for (String string : stringArray) {
            sortedList.add(string);
        }
        return sortedList;
    }

    public SortedSet<String> sortDescendingly(String[] stringArray) {
        SortedSet<String> sortedList = new TreeSet<>();

        return sortedList;
    }

    public static void main(String[] args) {
        String[] depsToSort = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        Department department = new Department();
        System.out.println(department.sortAscendingly(depsToSort));
    }
}


