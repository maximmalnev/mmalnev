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
        //Collections.sort(list, new NaturalOrderComparator());
        List<List<String>> listString  = Convert.divide(list);
        Collections.sort(listString, new NaturalOrderAscComparator());
        list = Convert.combine(listString);
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

    public static class Convert {
        static List<List<String>> divide(List<String> list) {
            List<List<String>> stringFullList= new ArrayList<>();
            for (String string : list) {
                List<String> stringList = new ArrayList<>();
                int i =0;
                for (int j = 0; j < string.length(); i++) {
                    if (string.charAt(j) == '\\') {
                        stringList.add(string.substring(i,j));
                        i = j+1;
                    } else if (j == string.length() - 1) {
                        stringList.add(string.substring(i,j));
                    }
                }
                stringFullList.add(stringList);
            }
            return stringFullList;
        }

        static List<String> combine(List<List<String>> list) {
            List<String> stringList= new ArrayList<>();
            for (List<String> strList : list) {
                String tmp = new String();
                for (int i = 0; i < strList.size(); i++) {
                    tmp = tmp + "/" + strList.get(i);
                }
                stringList.add(tmp);
            }
            return stringList;
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


