package ru.job4j.map;

public class EntryH {
    private Object key;
    private Object value;

    EntryH(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
