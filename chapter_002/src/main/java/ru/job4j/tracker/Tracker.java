package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Random;
/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     * добавление заявок - public Item add(Item item);
     * редактирование заявок - public void replace(String id, Item item);
     * удаление заявок - public void delete(String id);
     * получение списка всех заявок - public Item[] findAll();
     * получение списка по имени - public Item[] findByName(String key);
     * получение заявки по id - public Item findById(String id);
     */
    private final ArrayList<Item> items = new ArrayList<>();

    public int getPosition() {
        return position;
    }

    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    public void edit(Item fresh) {
        for (Item item : items) {
            if (item.equals(fresh)) {
                item = fresh;
            }
        }
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод реализаущий поиск заявки по id
     *
     * @param id - уникальное поле заявки
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public ArrayList<Item> getAll() {
        return items;
    }

    public void replace(String id, Item newItem) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                item.setCreate(newItem.getCreate());
            }
        }
    }

    public boolean delete(String id) {
        boolean res = false;
        for (Item item : items) {
            if (id.equals(item.getId())) {
                items.remove(item);
                res = true;
                break;
            }
        }
        return res;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }
}