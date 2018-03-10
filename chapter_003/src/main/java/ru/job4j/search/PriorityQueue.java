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
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() <= tasks.get(i).getPriority()) {
                tasks.add(i, task);
                break;
            } else {
                tasks.add(tasks.size(),task);
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }

    public void printAll() {
        for (Task task : tasks) {
            System.out.println("222222");
            System.out.println(String.format("Desc: %s, Prior: %s", task.getDesc(), task.getPriority() ));
        }
    }

    public static void main(String[] args) {
        System.out.println("111");
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.printAll();
        System.out.println("222");

        //Task result = queue.take();
    }
}