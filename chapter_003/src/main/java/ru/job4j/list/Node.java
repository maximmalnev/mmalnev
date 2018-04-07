package ru.job4j.list;

public class Node<E> {
    private Node<E> next;
    private E data;

    public Node() {
        this(null, null);
    }

    public Node(E inputData) {
        this(inputData, null);
    }

    public Node(E inputData, Node<E> inputNext) {
        this.next = inputNext;
        this.data = inputData;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E inputData) {
        this.data = inputData;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> inputNode) {
        this.next = inputNode;
    }
}
