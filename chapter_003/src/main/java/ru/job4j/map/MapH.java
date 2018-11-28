package ru.job4j.map;

import java.util.Iterator;

public class MapH<K, V> implements Iterable {
    private EntryH[] table;
    private int mapSize = 128;
    private int elements = 0;

    public MapH() {
        table = new EntryH[mapSize];
    }

    boolean insert(K key, V value) {
        boolean result = false;
        int hash = key.hashCode() % mapSize;
        if (table[hash] == null) {
            table[hash] = new EntryH(key, value);
            elements++;
            result = true;
        }
        return result;
    }

    V get(K key) {
        int hash = key.hashCode() % mapSize;
        if (table[hash] != null) {
            return (V) table[hash].getValue();
        } else {
            return null;
        }
    }

    boolean delete(K key) {
        boolean result = false;
        int hash = key.hashCode() % mapSize;
        if (table[hash].getKey() != null && table[hash].getKey().equals(key)) {
            table[hash] = null;
            result = true;
            elements--;
        }
        return result;
    }

    public static void main(String[] args) {
        MapH<Integer, String> map = new MapH<>();
        map.insert(1, "user1");
        map.delete(1);
        map.insert(2, "user2");
        map.insert(3, "user3");

        for (int i = 0; i < map.mapSize; i++) {
            if (map.table[i] != null) {
                System.out.println(map.get(i));
            }
        }
        System.out.println(map.elements);
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (currentIndex < mapSize) {
                    result = true;
                }
                return result;
            }

            @Override
            public EntryH next() {
                for (int i = currentIndex; i < mapSize; i++) {
                    if (table[i] != null) {
                        currentIndex = i + 1;
                        return table[i];
                    }
                }
                return null;
            }
        };
        return iterator;
    }
}
