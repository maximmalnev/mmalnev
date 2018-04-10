package ru.job4j.list;

public class SimpleQueue<T> {
    private LinList<T> values = new LinList();

    public T poll() {
        return values.removeHead();
    }

    public void push(T value) {
        this.values.add(value);
    }
}
