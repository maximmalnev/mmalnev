package ru.job4j.chess;

public class Knight extends Figure {
    public Knight(Cell cell) {
        super(cell);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int x0 = source.getPosX();
        int y0 = source.getPosY();
        int x1 = dest.getPosX();
        int y1 = dest.getPosY();

        if ((Math.abs(x0 - x1) == 1 && Math.abs(y0 - y1) == 2) || (Math.abs(x0 - x1) == 2 && Math.abs(y0 - y1) == 1)) {
            Cell[] moveArray = new Cell[0];
            moveArray[0] = new Cell(x1, y1);
            return moveArray;
        } else {
            throw new ImpossibleMoveException("Your knight can't move such way");
        }
    }

    public Figure copy(Cell dest) {
        return new Knight(dest);
    }
}
