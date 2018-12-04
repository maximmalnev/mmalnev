package ru.job4j.tree;


import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int size = 1;

    public Tree(Node<E> root) {
        this.root = root;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> tmp = findBy(parent);
        Optional<Node<E>> ch = findBy(child);
        if (tmp.isPresent() && !ch.isPresent()) {
            Node<E> el = tmp.get();
            el.add(new Node<>(child));
            result = true;
            this.size++;
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
        while (!data.isEmpty()) {
            Node<E> poll = data.poll();
            if (poll != null) {
                if (poll.leaves().size() > 2) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue<Node<E>> data = new LinkedList<>(Collections.singletonList(root));
            private int copySize = size;

            @Override
            public boolean hasNext() {
                if (copySize != size) {
                    throw new ConcurrentModificationException();
                }
                return !data.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> poll = data.poll();
                if (poll != null) {
                    for (Node<E> l : poll.leaves()) {
                        data.offer(l);
                    }
                }
                return poll != null ? poll.getValue() : null;
            }
        };
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        Iterator iterator = tree.iterator();
        tree.add(4, 5);
        iterator.hasNext();
    }
}
