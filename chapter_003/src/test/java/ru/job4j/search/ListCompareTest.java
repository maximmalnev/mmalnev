package ru.job4j.search;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListCompareTest {
    @Test
    public void whenLeftAndRightEqualsThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessRightThenMunis() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, is(-1));
    }

    @Test
    public void whenLeftGreatRightThenPlus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, is(1));
    }

    @Test
    public void whenFirstShorterAndGreaterThenPlus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Кац",
                "Арсентьев"
        );
        assertThat(rst, is(1));
    }

    @Test
    public void whenSecondShorterAndGreaterThenMinus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Арсентьев",
                "Кац"
        );
        assertThat(rst, is(-1));
    }
}

