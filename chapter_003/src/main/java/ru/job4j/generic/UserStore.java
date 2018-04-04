package ru.job4j.generic;

public class UserStore extends AbstractStore {

    @Override
    public void add(Base model) {
        LIST.add((User) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        for (Base base : LIST) {
            if (base.getId() == id) {
                LIST.delete(base);
                LIST.add((User) model);
                return true;
            }
        }
        return false;
    }
}
