package ru.job4j.calculator;

/**
 * Calculator.
 * @author Maxim Malnev (mazular@ya.ru)
 * @version $Id$
 * @since 0.1
 */

public class Calculator {
    /**
     * Result.
     */
    private double result;
    /**
     * Add.
     * @param first - first param
     * @param second - second param
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Subtract.
     * @param first - first param
     * @param second - second param
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    /**
     * Div.
     * @param first - first param
     * @param second - second param
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Multiple.
     * @param first - first param
     * @param second - second param
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     * GetResult.
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}
