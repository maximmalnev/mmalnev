package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int listSize;
    private int modCount;

    public LinList() {
        this.head = null;
        this.tail = null;
        this.listSize = 0;
        this.modCount = 0;
    }

    public int size() {
        return this.listSize;
    }

    private boolean isEmpty() {
        return this.size() == 0;
    }

    public void add(E data) {

        Node<E> newNode = new Node<>(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = head;
        } else {
            (this.tail).setNext(newNode);
            this.tail = newNode;
        }
        this.listSize++;
        this.modCount++;
    }

    public E get(int index) {
        if (index <= 0 || index > size()) {
            return null;
        }

        Node<E> currentNode = this.head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public E removeTail() {

        if (this.isEmpty()) {
            return null;
        } else if (this.size() == 1) {
            return this.clear();
        } else {

            Node<E> previousNode = this.head;
            for (int i = 1; i < size() - 1; i++) {
                previousNode = previousNode.getNext();
            }

            E returnData = get(this.size());
            previousNode.setNext(null);
            this.tail = previousNode;
            listSize--;
            return returnData;
        }
    }

    public E clear() {
        E headData = this.get(1);
        head = null;
        tail = null;
        listSize = 0;
        return headData;
    }

    public E removeHead() {
        if (isEmpty()) {
            return null;
        } else if (size() == 1) {
            return clear();
        } else {
            E headData = get(1);
            this.head = head.getNext();
            this.listSize--;
            return headData;
        }
    }

    public String toString() {
        Node<E> currentNode = this.head;
        StringBuilder output = new StringBuilder();
        while (currentNode != null) {
            output.append("[");
            output.append(currentNode.getData());
            output.append("]");
            currentNode = currentNode.getNext();
        }
        return output.toString();
    }

    @Override
    public Iterator<E> iterator() throws ConcurrentModificationException {
        Iterator<E> iterator = new Iterator<E>() {

            private int currentIndex = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                } else if (currentIndex < listSize) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                Node<E> currentNode = head;
                for (int i = 1; i <= currentIndex; i++) {
                    currentNode = currentNode.getNext();
                }
                currentIndex++;
                return currentNode.getData();
            }
        };
        return iterator;
    }
}
