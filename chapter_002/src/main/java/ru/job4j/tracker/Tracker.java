package ru.job4j.tracker;

import java.util.*;

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
    private final Item[] items = new Item[100];

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
        this.items[this.position++] = item;
        return item;
    }

    public void edit(Item fresh) {
        for (int index = 0; index != items.length; ++index) {
            Item item = items[index];
            if (item != null && item.getId().equals(fresh.getId())) {
                item = fresh;
                break;
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

    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    public void replace(String id, Item newItem) {
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                //item = newItem;
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                item.setCreate(newItem.getCreate());
            }
        }
    }

    public boolean delete(String id) {
        Item[] temp = new Item[this.position];
        System.arraycopy(items, 0, temp, 0, this.position);
        boolean res = false;

        for (int i = 0; i != this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                //System.out.println("Удаляю запись с ID: " + id + " номер в массиве: " + i + " номер позиции: " + this.position);
                System.arraycopy(temp, i + 1, items, i, this.position - i - 1);
                items[this.position - 1] = null;
                this.position--;
                res = true;
                break;
            }
        }
    return res;
    }


    public Item[] findByName(String key) {
        Item[] result = null;
        int pos = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                if (pos == 0) {
                    result = new Item[1];
                    result[0] = item;
                    pos++;
                    //System.out.println(item.getName());
                } else {
                    Item[] temp = new Item[pos + 1];
                    //copy
                    System.arraycopy(result, 0, temp, 0, result.length);
                    temp[pos++] = item;
                    result = temp;
                    //System.out.println(item.getName());
                }

            }
        }
        return result;
    }


}