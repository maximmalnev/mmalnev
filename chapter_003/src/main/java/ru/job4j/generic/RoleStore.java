package ru.job4j.generic;

public class RoleStore extends AbstractStore {

    @Override
    public void add(Base model) {
        list.add((Role) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        for (Base base : list) {
            if (base.getId() == id) {
                list.delete(base);
                list.add((Role) model);
                return true;
            }
        }
        return false;
    }
}
