package ru.job4j.search;
import java.util.*;
public class SortUser {
    //SortUser написать метод public Set<User> sort (List<User>), который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
    public Set<User> sort(List<User> users) {
        SortedSet<User> treeSetUsers = new TreeSet<>();
        treeSetUsers.addAll(users);
        return treeSetUsers;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(3, 23, "Petr", "Moscow"));
        list.add(new User(2, 32, "Ivan", "Volgograd"));
        list.add(new User(1, 12, "Vova", "Vologda"));
        SortUser userSort = new SortUser();
        System.out.println(list);
        System.out.println("---");
        System.out.println(userSort.sort(list));
    }
}
