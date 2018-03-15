package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int size = tasks.size();
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() <= tasks.get(i).getPriority()) {
                tasks.add(i, task);
                break;
            }
        }
        if (size == tasks.size()) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }

    public void printAll() {
        for (Task task : this.tasks) {
            System.out.println(String.format("Desc: %s, Prior: %s", task.getDesc(), task.getPriority()));
        }
    }
}