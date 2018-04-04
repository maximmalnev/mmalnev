package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.sort.Department.sortAscendingly;
import static ru.job4j.sort.Department.sortDescendingly;

public class DepartmentTest {

    @Test
    public void sortArrayAscendingly() {
        String[] depsToSort = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K11\\SK1"};
        List<String> sortedList = new ArrayList<>(sortAscendingly(depsToSort));

        assertThat(sortedList.get(0), is("K1"));
        assertThat(sortedList.get(1), is("K1\\SK1"));
        assertThat(sortedList.get(2), is("K1\\SK1\\SSK1"));
        assertThat(sortedList.get(3), is("K1\\SK1\\SSK2"));
        assertThat(sortedList.get(4), is("K1\\SK2"));
        assertThat(sortedList.get(5), is("K2"));
        assertThat(sortedList.get(6), is("K2\\SK1"));
        assertThat(sortedList.get(7), is("K2\\SK1\\SSK1"));
        assertThat(sortedList.get(8), is("K2\\SK1\\SSK2"));
        assertThat(sortedList.get(9), is("K11"));
        assertThat(sortedList.get(10), is("K11\\SK1"));
    }

    @Test
    public void sortArrayDescendingly() {
        String[] depsToSort = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K11\\SK1"};
        List<String> sortedList = new ArrayList<>(sortDescendingly(depsToSort));

        assertThat(sortedList.get(0), is("K11"));
        assertThat(sortedList.get(1), is("K11\\SK1"));
        assertThat(sortedList.get(2), is("K2"));
        assertThat(sortedList.get(3), is("K2\\SK1"));
        assertThat(sortedList.get(4), is("K2\\SK1\\SSK2"));
        assertThat(sortedList.get(5), is("K2\\SK1\\SSK1"));
        assertThat(sortedList.get(6), is("K1"));
        assertThat(sortedList.get(7), is("K1\\SK2"));
        assertThat(sortedList.get(8), is("K1\\SK1"));
        assertThat(sortedList.get(9), is("K1\\SK1\\SSK2"));
        assertThat(sortedList.get(10), is("K1\\SK1\\SSK1"));
    }
}
