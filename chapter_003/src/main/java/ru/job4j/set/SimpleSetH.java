package ru.job4j.set;

public class SimpleSetH<E> {

    private boolean[] isDeleted;
    private E[] elements;

    public SimpleSetH(int size) {
        elements = (E[]) new Object[size];
        isDeleted = new boolean[size];
    }

    boolean add(E e) {
        boolean result = false;
        int hNum = (Math.abs(e.hashCode())) % elements.length;
        if (elements[hNum] == null || isDeleted[hNum]) {
            elements[hNum] = e;
            result = true;
        } else {
            for (int i = hNum; i < elements.length; i++) {
                if (elements[i] == null || isDeleted[hNum]) {
                    elements[i] = e;
                    result = true;
                    break;
                }
                if (i == elements.length - 1 && (elements[i] != null || !isDeleted[hNum])) {
                    expand();
                    add(e);
                    break;
                }
            }
        }
        return result;
    }

    void expand() {
        E[] tmpElements = elements;
        elements = (E[]) new Object[elements.length * 2];
        boolean[] newIsDeleted = new boolean[elements.length * 2];
        for (int i = 0; i < tmpElements.length; i++) {
            if (tmpElements[i] != null && !isDeleted[i]) {
                add(tmpElements[i]);
            }
        }
        isDeleted = newIsDeleted;
    }

    boolean contains(E e) {
        boolean result = false;
        int hNum = (Math.abs(e.hashCode())) % elements.length;
        if (elements[hNum] != null && elements[hNum].equals(e)) {
            result = true;
        } else {
            for (int i = hNum + 1; i < elements.length; i++) {
                if (elements[i] == null && !isDeleted[i]) {
                    break;
                } else if (elements[i].equals(e)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    boolean remove(E e) {
        boolean result = false;
        int hNum = (Math.abs(e.hashCode())) % elements.length;
        if (elements[hNum] != null && elements[hNum].equals(e)) {
            elements[hNum] = null;
            isDeleted[hNum] = true;
            result = true;
        } else {
            for (int i = hNum + 1; i < elements.length; i++) {
                if (elements[i] == null && !isDeleted[i]) {
                    break;
                } else if (elements[i].equals(e)) {
                    elements[i] = null;
                    isDeleted[i] = true;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
