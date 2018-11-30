package ru.job4j.store;

import java.util.LinkedList;
import java.util.List;

public class Store {
    public static void main(String[] args) {
        List<User> previous = new LinkedList<>();
        List<User> current = new LinkedList<>();
        User user1 = new User(1, "Sasha");
        User user2 = new User(2, "Boris");
        User user3 = new User(3, "Petr");
        User user4 = new User(4, "Max");
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        User user5 = new User(1, "Alexander");
        current.add(user5);
        current.add(user4);

        Info info = new Info();
        info.diff(previous, current);

        for (User user : previous) {
            System.out.println("previous: " + user.id + " " + user.name);
        }
        for (User user : current) {
            System.out.println("current: " + user.id + " " + user.name);
        }
    }

    static class Info {
        void diff(List<User> previous, List<User> current) {
            int newUsers = 0;
            for (User userCu : current) {
                boolean n = true;
                for (User userPr : previous) {
                    if (userCu.id == userPr.id) {
                        n = false;
                    }
                }
                if (n) {
                    newUsers++;
                }
            }
            System.out.println("Добавлено новых пользователей: " + newUsers);

            int dellUsers = 0;
            for (User userPr : previous) {
                boolean inCollection = false;
                for (User userCu : current) {
                    if (userCu.id == userPr.id) {
                        inCollection = true;
                    }
                }
                if (!inCollection) {
                    dellUsers++;
                }
            }
            System.out.println("Удалено пользователей: " + dellUsers);

            int renameUsers = 0;
            for (User userPr : previous) {
                boolean rename = false;
                for (User userCu : current) {
                    if (userCu.id == userPr.id && !userCu.name.equals(userPr.name)) {
                        rename = true;
                    }
                }
                if (rename) {
                    renameUsers++;
                }
            }
            System.out.println("Переименовано пользователей: " + renameUsers);
        }
    }

    static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
