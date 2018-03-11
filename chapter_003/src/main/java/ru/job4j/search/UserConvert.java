package ru.job4j.search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashUsers = new HashMap<>();
        for (User user : list) {
            hashUsers.put(user.getId(), user);
        }
        return hashUsers;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(3, 13, "Petr", "Moscow"));
        list.add(new User(2, 32, "Ivan", "Volgograd"));
        list.add(new User(1, 3, "Vova", "Vologda"));
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> hashMapUsers = userConvert.process(list);
        System.out.println(hashMapUsers);
    }
}
