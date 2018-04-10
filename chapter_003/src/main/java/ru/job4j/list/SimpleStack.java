package ru.job4j.list;

public class SimpleStack<T> {
    private LinList<T> values = new LinList();

    public T poll() {
        return values.removeTail();
    }

    public void push(T value) {
        this.values.add(value);
    }

    public static void main(String[] args) {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        simpleStack.push(4);
        simpleStack.push(5);

        System.out.println(simpleStack.poll());
        System.out.println(simpleStack.poll());
        System.out.println(simpleStack.poll());
        System.out.println(simpleStack.poll());
        System.out.println(simpleStack.poll());
    }
}
