package ru.job4j.profession;

public class Doctor extends Profession {

    public String heal(Human patient) {
        patient.setHealth(100);
        return "Доктор " + this.name + " лечит " + patient.name + " и его здоровье теперь " + patient.health + "%";
    }
}
