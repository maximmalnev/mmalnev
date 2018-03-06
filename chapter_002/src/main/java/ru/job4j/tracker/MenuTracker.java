package ru.job4j.tracker;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem(0, "Add new item");
        this.actions[1] = new ShowItems(1, "Show all items");
        this.actions[2] = new EditItem(2, "Edit item");
        this.actions[3] = new DeleteItem(3, "Delete item");
        this.actions[4] = new FindById(4, "Find by ID");
        this.actions[5] = new FindByName(5, "Find by Name");
        this.actions[6] = new ExitMenu(6, "Exit");
    }

    public int select(int key) {
        this.actions[key].execute(this.input, this.tracker);
        return key;
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name:");
            String desc = input.ask("Enter description:");
            tracker.add(new Item(name, desc));
        }
    }

    private static class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
    }

    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter tack ID:");
            if (tracker.delete(id)) {
                System.out.println("Delete item with ID:" + id);
            } else {
                System.out.println("Wrong ID");
            }
        }
    }

    private class FindById extends BaseAction {
        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter tack ID:");
            System.out.println("Item with id " + id + " : " + tracker.findById(id).getName());
        }
    }

    private class FindByName extends BaseAction {
        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter tack name:");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println("Task with name " + name + " : " + item.getId());
            }
        }
    }

    private class ExitMenu extends BaseAction {
        public ExitMenu(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}

class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter tack ID:");
        String name = input.ask("Please enter tack name:");
        String desc = input.ask("Please enter tack description:");
        tracker.replace(id, new Item(name, desc));
    }
}