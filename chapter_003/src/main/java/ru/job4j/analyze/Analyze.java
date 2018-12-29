package ru.job4j.analyze;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Analyze {

    public boolean wordInfo(String first, String second) {
        boolean result = false;
        char[] f = first.toCharArray();
        Arrays.sort(f);
        String sortedF = String.valueOf(f);
        char[] s = second.toCharArray();
        Arrays.sort(s);
        String sortedS = String.valueOf(s);
        if (sortedF.equals(sortedS)) {
            result = true;
        }
        return result;
    }

    public static class Info {
        int[] diff(List<User> previous, List<User> current) {
            int[] result = new int[3];
            HashMap<Integer, String> prMap = new HashMap<>();
            for (User user : previous) {
                prMap.put(user.getId(), user.getName());
            }
            HashMap<Integer, String> curMap = new HashMap<>();
            for (User user : current) {
                curMap.put(user.getId(), user.getName());
            }
            int newUsers = 0;
            int dellUsers = 0;
            int renameUsers = 0;

            for (User userCu : current) {
                if (!prMap.containsKey(userCu.getId())) {
                    newUsers++;
                }
            }
            result[0] = newUsers;

            for (User user : previous) {
                if (!curMap.containsKey(user.getId())) {
                    dellUsers++;
                }
            }
            result[1] = dellUsers;

            for (User user : previous) {
                if (curMap.containsKey(user.getId()) && !curMap.get(user.getId()).equals(user.getName())) {
                    renameUsers++;
                }
            }

            result[2] = renameUsers;
            return result;
        }
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
