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
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new ExitMenu();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter task name:");
            String desc = input.ask("Please enter task description:");
            tracker.add(new Item(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new item");
        }
    }

    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    private class FindById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter tack ID:");
            System.out.println("Item with id " + id + " : " + tracker.findById(id).getName());
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find by ID");
        }
    }

    private class FindByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter tack name:");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println("Task with name " + name + " : " + item.getId());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find by Name");
        }
    }

    private class ExitMenu implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit");
        }
    }
}

class EditItem implements UserAction {
    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter tack ID:");
        String name = input.ask("Please enter tack name:");
        String desc = input.ask("Please enter tack description:");
        tracker.replace(id, new Item(name, desc));
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
    }
}