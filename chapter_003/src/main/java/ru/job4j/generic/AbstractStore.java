package ru.job4j.generic;

public abstract class AbstractStore implements Store {

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < LIST.index; i++) {
            if (LIST.get(i).getId() == id) {
                LIST.delete(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Base findById(String id) {
        for (Base base : LIST) {
            if (base.getId() == id) {
                return base;
            }
        }
        return null;
    }
}
