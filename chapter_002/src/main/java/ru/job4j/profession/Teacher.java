package ru.job4j.profession;

public class Teacher extends Profession {
    public int category;

    public int getCategory() {
        return category;
    }

    public String teach(Human student) {
        student.setKnowledge(student.knowledge + 20);
        return "Учитель " + this.name + " учит " + student.name + ". Его уровень знаний повышен на 20 и равен " + student.knowledge;
    }
}
