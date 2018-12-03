package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class MapHTest {
    @Test
    public void whenDelete() {
        MapH<Integer, String> map = new MapH<>();
        map.insert(1, "user1");
        map.delete(1);
        map.insert(2, "user2");
        assertThat(
                map.get(1),
                is(nullValue())
        );
    }

    @Test
    public void whenResize() {
        MapH<Integer, String> map = new MapH<>(4);
        map.insert(1, "user1");
        map.insert(2, "user2");
        map.insert(3, "user3");
        map.insert(4, "user4");
        map.insert(5, "user5");
        map.insert(6, "user6");
        map.insert(7, "user7");
        map.insert(8, "user8");
        assertThat(
                map.get(8),
                is("user8")
        );
    }

    @Test
    public void whenItereatorHaveNext() {
        MapH<Integer, String> map = new MapH<>(16);
        map.insert(10, "user1");
        map.insert(12, "user2");
        Iterator iterator = map.iterator();
        iterator.next();
        assertTrue(iterator.hasNext());

    }

    @Test
    public void whenItereatorHaveNoNext() {
        MapH<Integer, String> map = new MapH<>(16);
        map.insert(10, "user1");
        map.insert(12, "user2");
        Iterator iterator = map.iterator();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());

    }
}