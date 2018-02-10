package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    private StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    private void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                if (this.tracker.getPosition() != 0) {
                    System.out.println("---------- Список всех заявок ----------");
                    Item[] output = this.tracker.getAll();
                    for (Item item : output) {
                        System.out.println("ID заявки:" + item.getId() + " Имя:" + item.getName() + " Описание:" + item.getDescription());
                    }
                } else {
                    System.out.println("---------- Список заявок пуст ----------");
                }
                System.out.println("-------------------------------------------");
            } else if (EDIT.equals(answer)) {
                System.out.println("---------- Редактирование заявки ----------");
                String id = this.input.ask("Введите ID заявки :");
                if (this.tracker.findById(id) != null) {
                    String name = this.input.ask("Введите имя заявки :");
                    String desc = this.input.ask("Введите описание заявки :");
                    Item item = new Item(name, desc);
                    this.tracker.replace(id, item);
                    System.out.println("Заявка с ID: " + id + " изменена");
                } else {
                    System.out.println("---------- Заявки с таким ID нет в трекере ----------");
                }
                System.out.println("-------------------------------------------");
            } else if (DELETE.equals(answer)) {
                System.out.println("---------- Удаление заявки ----------");
                String id = this.input.ask("Введите ID заявки :");
                if (this.tracker.findById(id) != null) {
                    this.tracker.delete(id);
                    System.out.println("Заявка с ID: " + id + " удалена");
                } else {
                    System.out.println("---------- Заявки с таким ID нет в трекере ----------");
                }
                System.out.println("-------------------------------------------");
            } else if (FIND_BY_ID.equals(answer)) {
                String id = this.input.ask("Введите ID заявки :");
                if (this.tracker.findById(id) != null) {
                    System.out.println("---------- Информация по заявке с ID: " + id + " ----------");
                    Item item = this.tracker.findById(id);
                    System.out.println("Имя:" + item.getName() + " Описание:" + item.getDescription());
                } else {
                    System.out.println("---------- Заявки с таким ID нет в трекере ----------");
                }
                System.out.println("-------------------------------------------");
            } else if (FIND_BY_NAME.equals(answer)) {
                String name = this.input.ask("Введите имя заявки :");
                if (this.tracker.findByName(name) != null) {
                    System.out.println("---------- Информация по заявке(ам) с именем: " + name + " ----------");
                    Item[] output = this.tracker.findByName(name);
                    for (Item item : output) {
                        System.out.println("ID заявки:" + item.getId() + " Имя:" + item.getName() + " Описание:" + item.getDescription());
                    }
                } else {
                    System.out.println("---------- Заявки с таким ID нет в трекере ----------");
                }
                System.out.println("-------------------------------------------");
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }

    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("---------- Добавление новой заявки ----------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("---------- Новая заявка с getId : " + item.getId() + " добавлена в трекер ----------");
        System.out.println("-------------------------------------------");
    }

    private void showMenu() {
        System.out.println("0. Добавить заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по ID");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Выход");
    }

    /**
     * Запускт программы.
     *
     * @param args - входные параметры
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
