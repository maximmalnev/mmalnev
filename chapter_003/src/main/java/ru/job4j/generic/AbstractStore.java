package ru.job4j.generic;

public abstract class AbstractStore implements Store {

    SimpleList<Base> list = new SimpleList<>(10);

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < list.index; i++) {
            if (list.get(i).getId() == id) {
                list.delete(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Base findById(String id) {
        for (Base base : list) {
            if (base.getId() == id) {
                return base;
            }
        }
        return null;
    }
}
