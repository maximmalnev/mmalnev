package ru.job4j.search;
public class User implements Comparable<User> {
    private int id;
    private Integer age;
    private String name, city;

    public Integer getAge() {
        return age;
    }

    public User(int id, int age, String name, String city) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.city = city;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "age=" + age + ", name='" + name + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.getAge());
    }
}
