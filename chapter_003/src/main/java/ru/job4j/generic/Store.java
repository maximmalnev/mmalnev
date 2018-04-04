package ru.job4j.generic;

public interface Store<T extends Base> {
    SimpleList<Base> LIST = new SimpleList<>(10);

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}