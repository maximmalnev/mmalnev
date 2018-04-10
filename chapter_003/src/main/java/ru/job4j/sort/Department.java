package ru.job4j.sort;

import java.util.*;

public class Department {
    public List<String> sortAscendingly(String[] stringArray) {
        List<String> list = divideDesp(stringArray);

        List<List<String>> listString = new ArrayList<>();
        for (String tmp : list) {
            listString.add(divide(tmp));
        }

        Collections.sort(listString, new NaturalOrderAscComparator());
        return combine(listString);
    }

    public List<String> sortDescendingly(String[] stringArray) {
        List<List<String>> listString = new ArrayList<>();
        List<String> list = divideDesp(stringArray);
        for (String tmp : list) {
            listString.add(divide(tmp));
        }
        Collections.sort(listString, new NaturalOrderDescComparator());
        return combine(listString);
    }

    public List<String> divideDesp(String[] stringArray) {
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
        return list;
    }

    public List<String> divide(String string) {
        List<String> stringList = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < string.length(); j++) {
            if (string.charAt(j) == '\\') {
                stringList.add(string.substring(i, j));
                i = j + 1;
            } else if (j == string.length() - 1) {
                stringList.add(string.substring(i, j + 1));
            }
        }
        return stringList;
    }

    public List<String> combine(List<List<String>> list) {
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
}


