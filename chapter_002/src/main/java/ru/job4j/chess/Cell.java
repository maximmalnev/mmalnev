package ru.job4j.chess;

public class Cell {
    private int posX, posY;

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Cell(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
}
