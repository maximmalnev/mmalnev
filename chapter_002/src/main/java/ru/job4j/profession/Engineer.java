package ru.job4j.profession;

public class Engineer extends Profession {
    public String repair(Detail detail) {
        detail.setDurability(100);
        return "Инженер полностью восстановил деталь " + detail.name;
    }
}
