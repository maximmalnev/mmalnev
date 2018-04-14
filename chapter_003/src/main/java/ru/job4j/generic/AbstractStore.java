package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    SimpleList<T> list = new SimpleList<>(10);

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
    public T findById(String id) {
        for (T base : list) {
            if (base.getId() == id) {
                return base;
            }
        }
        return null;
    }

    @Override
    public void add(T model) {
        list.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        for (T base : list) {
            if (base.getId() == id) {
                list.delete(base);
                list.add(model);
                return true;
            }
        }
        return false;
    }
}
