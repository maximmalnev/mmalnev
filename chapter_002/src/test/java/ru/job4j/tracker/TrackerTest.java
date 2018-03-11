package ru.job4j.tracker;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    /**
     * tracker.add
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    /**
     * tracker.replace
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * tracker.delete
     */
    @Test
    public void whenDeleteItemThenReturnNewTracker() {
        Tracker tracker1 = new Tracker();
        Tracker tracker2 = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker1.add(item1);
        tracker2.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker1.add(item2);
        Item item3 = new Item("test3", "testDescription3", 1234L);
        tracker1.add(item3);
        tracker2.add(item3);
        tracker1.delete(item2.getId());
        assertThat(tracker1.getAll(), is(tracker2.getAll()));
    }

    /**
     * tracker.findByName
     */
    @Test
    public void whenFindByNameThenReturnItem() {
        Tracker tracker1 = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker1.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker1.add(item2);
        Item item3 = new Item("test3", "testDescription3", 1234L);
        tracker1.add(item3);
        assertThat(tracker1.findByName("test3").get(0), is(item3));
    }

    /**
     * tracker.getAll
     */
    @Test
    public void whenGetAllThenReturnFullArray() {
        Tracker tracker1 = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker1.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker1.add(item2);
        Item item3 = new Item("test3", "testDescription3", 1234L);
        tracker1.add(item3);
        ArrayList<Item> result = new ArrayList<>();
        result.add(item1);
        result.add(item2);
        result.add(item3);
        assertThat(tracker1.getAll(), is(result));
    }

    /**
     * tracker.findById
     */
    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker1 = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker1.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker1.add(item2);
        Item item3 = new Item("test3", "testDescription3", 1234L);
        tracker1.add(item3);
        String id = item2.getId();
        assertThat(tracker1.findById(id), is(item2));
    }
}
