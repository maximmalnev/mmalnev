package ru.job4j.tree;

import java.util.Iterator;
import java.util.Optional;

public class Tree implements SimpleTree {
    @Override
    public boolean add(Object parent, Object child) {
        return false;
    }

    @Override
    public Optional<Node> findBy(Object value) {
        return Optional.empty();
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
