package ru.job4j.condition;
/**
 * PointClass.
 */
public class Point {
    /**
     * Xcoordinate.
     */
    private int x;
    /**
     * Ycoordinate.
     */
    private int y;
    /**
     * Point.
     * @param x - x coord
     * @param y - y coord
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Xgetter.
     * @return x
     */
    public int getX() {
        return this.x;
    }
    /**
     * Ygetter.
     * @return y
     */
    public int getY() {
        return this.y;
    }
    /**
     * Point.
     * @param a - a koef
     * @param b - b koef
     * @return true if dot on line
     */
    public boolean is(int a, int b) {
        return this.y == a * this.x + b;
    }
}
