package ru.job4j.search;
import java.util.*;
public class SortUser {
    public Set<User> sort(List<User> users) {
        SortedSet<User> treeSetUsers = new TreeSet<>();
        treeSetUsers.addAll(users);
        return treeSetUsers;
    }

    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new NameLengthComparator());
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new AllFieldsComparator());
        return list;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(23, "Petr"));
        list.add(new User(32, "Max"));
        list.add(new User(12, "Vladimir"));
        list.add(new User(43, "Petr"));
        list.add(new User(18, "Andrey"));
        SortUser userSort = new SortUser();
        System.out.println(list);
        System.out.println("Sorted by name length");
        System.out.println(userSort.sortNameLength(list));
        System.out.println("Sorted by all fields");
        System.out.println(userSort.sortByAllFields(list));
    }
}
