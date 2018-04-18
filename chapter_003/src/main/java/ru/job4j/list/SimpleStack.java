package ru.job4j.list;

public class SimpleStack<T> {
    private LinList<T> values = new LinList<>();

    public T poll() {
        return values.removeTail();
    }

    public void push(T value) {
        this.values.add(value);
    }
}
