package ru.job4j.tracker;

class EditItem implements UserAction {
    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter task ID: ");
        String name = input.ask("Enter task name: ");
        String desc = input.ask("Enter task description: ");
        Item item = new Item(name, desc);
        item.setId(id);
        tracker.edit(item);
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit new item");
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
    }

    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter task name: ");
            String desc = input.ask("Please enter task description: ");
            tracker.add(new Item(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new item");
        }
    }

}
