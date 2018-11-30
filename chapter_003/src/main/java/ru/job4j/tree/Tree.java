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
        Node<E> el;
        Optional<Node<E>> tmp = findBy(parent);
        if (tmp.isPresent()) {
            el = tmp.get();
            if (!el.haveChild(child)) {
                el.add(new Node<>(child));
                result = true;
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

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        if (data.peek().haveChildren() && data.peek().leaves().size() <= 2) {
            for (Node<E> l : data.peek().leaves()) {
                data.offer(l);
            }
            data.poll();
        } else {
            result = false;
        }

        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);

        Iterator iterator = new Iterator() {

            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public Node<E> next() {
                if (data.peek().haveChildren()) {
                    for (Node<E> l : data.peek().leaves()) {
                        data.offer(l);
                    }
                }
                return data.poll();
            }
        };
        return iterator;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 3);
        //tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);

        System.out.println(tree.isBinary());
    }

}
