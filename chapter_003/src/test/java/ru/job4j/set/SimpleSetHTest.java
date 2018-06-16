package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetHTest {
    @Test
    public void add() {
        SimpleSetH simSet = new SimpleSetH<String>(4);

        String string1 = "language1";
        simSet.add(string1);

        assertThat(simSet.contains(string1), is(true));
    }

    @Test
    public void remove() {
        SimpleSetH simSet = new SimpleSetH<String>(4);

        String string1 = "language1";
        simSet.add(string1);
        simSet.remove(string1);

        assertThat(simSet.contains(string1), is(false));
    }

    @Test
    public void ifAddMoreThenSizeThenIncreaseSize() {
        SimpleSetH simSet = new SimpleSetH<String>(4);

        String string1 = "language1";
        String string2 = "language2";
        String string3 = "language3";
        String string4 = "language4";
        String string5 = "language5";
        simSet.add(string1);
        simSet.add(string2);
        simSet.add(string3);
        simSet.add(string4);
        simSet.add(string5);

        assertThat(simSet.contains(string1), is(true));
        assertThat(simSet.contains(string2), is(true));
        assertThat(simSet.contains(string3), is(true));
        assertThat(simSet.contains(string4), is(true));
        assertThat(simSet.contains(string5), is(true));
    }
}
