package ru.job4j.profession;

public class Doctor extends Profession {

    public String heal(Human pacient) {
        pacient.setHealth(100);
        return "Доктор " + this.name + " лечит " + pacient.name + " и его здоровье теперь " + pacient.health + "%";
    }
}
