package ru.job4j.chess;

abstract class Figure {
    final Cell position;

    public Figure(Cell cell) {
        this.position = cell;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);
}
