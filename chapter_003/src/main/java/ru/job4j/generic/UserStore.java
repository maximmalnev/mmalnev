package ru.job4j.generic;

public class UserStore extends AbstractStore {

    @Override
    public void add(Base model) {
        list.add((User) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        for (Base base : list) {
            if (base.getId() == id) {
                list.delete(base);
                list.add((User) model);
                return true;
            }
        }
        return false;
    }
}
