package ru.job4j.search;
import java.util.Comparator;
public class AllFieldsComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        final int name = o1.getName().compareTo(o2.getName());
        return name != 0 ? name : o1.getAge().compareTo(o2.getAge());
    }
}