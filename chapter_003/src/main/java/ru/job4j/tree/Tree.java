package ru.job4j.tree;


import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    Node<E> root;

    public Tree(Node<E> root) {
        this.root = root;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(parent)) {
                if (!el.contains(child)) {
                    el.add(new Node(child));
                    break;
                }
            }
            for (Node<E> node : el.leaves()) {
                data.offer(node);
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    void print() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            el.print();
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
    }

    Queue<Node<E>> toArray() {
        Queue<Node<E>> data = new LinkedList<>();
        Queue<Node<E>> list = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            list.offer(el);
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        for (Node<E> node : list) {
            node.print();
        }
        return list;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator iterator = new Iterator() {

            private Queue<Node<E>> list = toArray();
            int index = 0;


            @Override
            public boolean hasNext() {
                boolean result = false;
                if (index < list.size()) {
                    result = true;
                }
                return result;
            }

            @Override
            public Node<E> next() {
                index++;
                return list.poll();
            }
        };
        return iterator;
    }
}
