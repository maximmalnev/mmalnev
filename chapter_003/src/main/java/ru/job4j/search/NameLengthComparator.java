package ru.job4j.search;
import java.util.Comparator;
public class NameLengthComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        Integer len1 = o1.getName().length();
        Integer len2 = o2.getName().length();
        return len1.compareTo(len2);
    }
}
