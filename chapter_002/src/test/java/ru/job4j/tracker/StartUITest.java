package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    String menu = new String("0. Добавить заявку\n1. Показать все заявки\n2. Редактировать заявку\n3. Удалить заявку\n4. Найти заявку по ID\n5. Найти заявку(и) по имени\n6. Выход\n");
/*
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    @Test
    public void whenDeleteThenTrackerHasNoThisValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
    @Test
    public void whenShowAllThenPrintAlItemsInTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Список всех заявок ----------\n")
                                .append("ID заявки:" + item.getId() + " Имя:" + item.getName() + " Описание:" + item.getDescription() + "\n")
                                .append("-------------------------------------------\n")
                                .append(menu)
                                .toString()
                )
        );
    }
    @Test
    public void whenFindByIdThenPrintSelectedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Информация по заявке с ID: " + item.getId() + " ----------\n")
                                .append("Имя:" + item.getName() + " Описание:" + item.getDescription() + "\n")
                                .append("-------------------------------------------\n")
                                .append(menu)
                                .toString()
                )
        );
    }
    @Test
    public void whenFindByNameThenPrintSelectedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Информация по заявке(ам) с именем: " + item.getName() + " ----------\n")
                                .append("ID заявки:" + item.getId() + " Имя:" + item.getName() + " Описание:" + item.getDescription() + "\n")
                                .append("-------------------------------------------\n")
                                .append(menu)
                                .toString()
                )
        );
    }*/
}
