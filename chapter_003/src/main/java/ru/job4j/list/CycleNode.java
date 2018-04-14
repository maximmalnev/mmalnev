package ru.job4j.list;

public class CycleNode<T> {
    T data;
    CycleNode<T> next;

    public CycleNode(T inputData) {
        this.data = inputData;
    }

    boolean hasCycle(CycleNode first) {
        boolean result = false;
        CycleNode slow = first;
        CycleNode fast = first;
        if (slow.next != null) {
            fast = slow.next;
        }

        while (slow.next != null) {
            if (slow == fast) {
                result = true;
                break;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
            }
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        return result;
    }

}
