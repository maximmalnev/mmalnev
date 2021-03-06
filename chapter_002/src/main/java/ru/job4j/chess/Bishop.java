package ru.job4j.chess;

public class Bishop extends Figure {
    public Bishop(Cell cell) {
        super(cell);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int position = 0;
        int x0 = source.getPosX();
        int y0 = source.getPosY();
        int x1 = dest.getPosX();
        int y1 = dest.getPosY();
        int deltaX = Integer.compare(x0, x1);
        int deltaY = Integer.compare(y0, y1);

        if (Math.abs(x0 - x1) == Math.abs(y0 - y1)) {
            Cell[] moveArray = new Cell[Math.abs(x0 - x1)];

            for (int i = 1; i < (Math.abs(x0 - x1) + 1); i++) {
                moveArray[position++] = new Cell(x0 + deltaX * i, y0 + deltaY * i);
            }
            return moveArray;
        } else {
            throw new ImpossibleMoveException("Your bishop can't move such way");
        }
    }

    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
