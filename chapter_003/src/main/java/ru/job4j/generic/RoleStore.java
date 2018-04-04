package ru.job4j.generic;

public class RoleStore extends AbstractStore {

    @Override
    public void add(Base model) {
        LIST.add((Role) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        for (Base base : LIST) {
            if (base.getId() == id) {
                LIST.delete(base);
                LIST.add((Role) model);
                return true;
            }
        }
        return false;
    }
}
