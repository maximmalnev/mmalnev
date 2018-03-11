package ru.job4j.coffee;
import java.util.Arrays;
public class CoffeeMachine {
    int[] changes(int value, int price) {
        int[] count = new int[100];
        int i = 0;
        int cashback = value - price;
        while ((cashback / 1000) > 0) {
            cashback -= 1000;
            count[i++] = 1000;
        }
        while ((cashback / 500) > 0) {
            cashback -= 500;
            count[i++] = 500;
        }
        while ((cashback / 100) > 0) {
            cashback -= 100;
            count[i++] = 100;
        }
        while ((cashback / 50) > 0) {
            cashback -= 50;
            count[i++] = 50;
        }
        while ((cashback / 10) > 0) {
            cashback -= 10;
            count[i++] = 10;
        }
        while ((cashback / 5) > 0) {
            cashback -= 5;
            count[i++] = 5;
        }
        while ((cashback / 2) > 0) {
            cashback -= 2;
            count[i++] = 2;
        }
        while ((cashback / 1) > 0) {
            cashback -= 1;
            count[i++] = 1;
        }
        int[] result = Arrays.copyOf(count, i);
        return result;
    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        int[] res = cm.changes(800, 34);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
