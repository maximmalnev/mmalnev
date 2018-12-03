package ru.job4j.analyze;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.analyze.Analyze.User;
import ru.job4j.analyze.Analyze.Info;

import java.util.LinkedList;
import java.util.List;

public class AnalyseTest {
    @Test
    public void diffAll() {
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
        Assert.assertArrayEquals(info.diff(previous, current), new int[]{1, 2, 1});
    }

    @Test
    public void diffNewUser() {
        List<User> previous = new LinkedList<>();
        List<User> current = new LinkedList<>();
        User user1 = new User(1, "Sasha");
        User user2 = new User(2, "Boris");
        previous.add(user1);
        current.add(user1);
        current.add(user2);

        Info info = new Info();
        Assert.assertArrayEquals(info.diff(previous, current), new int[]{1, 0, 0});
    }

    @Test
    public void diffDeleteUser() {
        List<User> previous = new LinkedList<>();
        List<User> current = new LinkedList<>();
        User user1 = new User(1, "Sasha");
        previous.add(user1);

        Info info = new Info();
        Assert.assertArrayEquals(info.diff(previous, current), new int[]{0, 1, 0});
    }

    @Test
    public void diffRenameUser() {
        List<User> previous = new LinkedList<>();
        List<User> current = new LinkedList<>();
        User user1 = new User(1, "Sasha");
        User user2 = new User(1, "Alexander");
        previous.add(user1);
        current.add(user2);

        Info info = new Info();
        Assert.assertArrayEquals(info.diff(previous, current), new int[]{0, 0, 1});
    }
}
