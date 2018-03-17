package ru.job4j.sort;

import java.util.*;

public class Department {

    public List<String> sortAscendingly(String[] stringArray) {
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
        Collections.sort(list, new NaturalOrderComparator());
        return list;
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

    public static void main(String[] args) {
        String[] depsToSort = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K11\\SK1"};
        Department department = new Department();
        System.out.println("Прямая сортировка");
        System.out.println(department.sortAscendingly(depsToSort));

        System.out.println("Обратная сортировка");
        System.out.println(department.sortDescendingly(depsToSort));

        System.out.println(ElementQuantity.quant("sada\\dasdasd\\asd\\", '\\'));
    }


}


