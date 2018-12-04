package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MapH<K, V> implements Iterable {

    static class EntryH {
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

    private EntryH[] table;
    private int mapSize = 128;
    private int elements = 0;
    private int mod = 0;
    private float loadFactor = 0;

    public MapH() {
        table = new EntryH[mapSize];
    }

    public MapH(int size) {
        table = new EntryH[size];
        this.mapSize = size;
    }

    boolean addElement(K key, V value) {
        boolean result = false;
        int hash = key.hashCode() % mapSize;
        if (table[hash] == null) {
            table[hash] = new EntryH(key, value);
            elements++;
            mod++;
            loadFactor = elements / mapSize;
        }
        return result;
    }

    boolean insert(K key, V value) {

        boolean result;
        if (loadFactor <= 0.75) {
            result = addElement(key, value);
        } else {
            mapSize = mapSize * 2;
            EntryH[] tmpTable = new EntryH[mapSize];
            elements = 0;
            for (EntryH entry : table) {
                if (entry != null) {
                    int hash = entry.key.hashCode() % mapSize;
                    if (tmpTable[hash] == null) {
                        tmpTable[hash] = new EntryH(entry.key, entry.value);
                        elements++;
                    }
                }
            }
            table = tmpTable;
            result = addElement(key, value);
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
            loadFactor = elements / mapSize;
            elements--;
            mod++;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator iterator() throws NoSuchElementException, ConcurrentModificationException {
        Iterator iterator = new Iterator() {

            private int currentIndex = 0;
            private int copyMod = mod;

            @Override
            public boolean hasNext() {
                if (copyMod != mod) {
                    throw new ConcurrentModificationException("коллекция была изменена во время работы итератора");
                }
                boolean result = false;
                for (int i = currentIndex; i < mapSize; i++) {
                    if (table[i] != null) {
                        currentIndex = i;
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public EntryH next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("В итераторе нет элементов");
                }
                return table[currentIndex++];
            }
        };
        return iterator;
    }
}
