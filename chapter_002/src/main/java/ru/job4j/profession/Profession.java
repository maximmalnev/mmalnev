package ru.job4j.profession;

public class Profession {
    public String name;
    public String gender;
    public String diploma;
    public int age;

    public Profession() {
    }

    public Profession(String name, String gender, String diploma, int age) {
        this.name = name;
        this.gender = gender;
        this.diploma = diploma;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDiploma() {
        return diploma;
    }

    public int getAge() {
        return age;
    }
}
