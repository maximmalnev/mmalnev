package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

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
        assertThat(tracker.getAll().get(0).getName(), is("test name"));
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
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find by ID")
                                .append(System.lineSeparator())
                                .append("5. Find by Name")
                                .append(System.lineSeparator())
                                .append("6. Exit")
                                .append(System.lineSeparator())
                                .append(item.getId() + ". " + item.getName())
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find by ID")
                                .append(System.lineSeparator())
                                .append("5. Find by Name")
                                .append(System.lineSeparator())
                                .append("6. Exit")
                                .append(System.lineSeparator())
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
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find by ID")
                                .append(System.lineSeparator())
                                .append("5. Find by Name")
                                .append(System.lineSeparator())
                                .append("6. Exit")
                                .append(System.lineSeparator())
                                .append("Item with id " + item.getId() + " : " + item.getName())
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find by ID")
                                .append(System.lineSeparator())
                                .append("5. Find by Name")
                                .append(System.lineSeparator())
                                .append("6. Exit")
                                .append(System.lineSeparator())
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
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find by ID")
                                .append(System.lineSeparator())
                                .append("5. Find by Name")
                                .append(System.lineSeparator())
                                .append("6. Exit")
                                .append(System.lineSeparator())
                                .append("Task with name " + item.getName() + " : " + item.getId())
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find by ID")
                                .append(System.lineSeparator())
                                .append("5. Find by Name")
                                .append(System.lineSeparator())
                                .append("6. Exit")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
