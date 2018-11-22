package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        GregorianCalendar gBirth = new GregorianCalendar(2013,0,31);
        User userIvan = new User();
        userIvan.setName("Ivan");
        userIvan.setChildren(2);
        userIvan.setBirthday(gBirth);
        User userDaniil = new User();
        userDaniil.setName("Ivan");
        userDaniil.setChildren(2);
        userDaniil.setBirthday(gBirth);

        Map userMap = new HashMap <User, Object>();
        userMap.put(userIvan,1);
        userMap.put(userDaniil,2);

        System.out.println(userMap);
    }

}

