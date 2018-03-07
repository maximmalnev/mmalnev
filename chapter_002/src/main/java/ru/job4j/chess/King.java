package ru.job4j.chess;

public class King extends Figure {
    public King(Cell cell) {
        super(cell);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int x0 = source.getPosX();
        int y0 = source.getPosY();
        int x1 = dest.getPosX();
        int y1 = dest.getPosY();
        int deltaX = Integer.compare(x0, x1);
        int deltaY = Integer.compare(y0, y1);

        if (deltaX == 0 && Math.abs(y0 - y1) == 1) {
            Cell[] moveArray = new Cell[1];
            moveArray[0] = new Cell(x0, y0 + deltaY);
            return moveArray;
        } else if (deltaY == 0 && Math.abs(x0 - x1) == 1) {
            Cell[] moveArray = new Cell[1];
            moveArray[0] = new Cell(x0 + deltaX, y0);
            return moveArray;
        } else if (Math.abs(x0 - x1) == 1 && Math.abs(y0 - y1) == 1) {
            Cell[] moveArray = new Cell[1];
            moveArray[0] = new Cell(x0 + deltaX, y0 + deltaY);
            return moveArray;
        } else {
            throw new ImpossibleMoveException("Your king can't move such way");
        }
    }

    public Figure copy(Cell dest) {
        return new King(dest);
    }
}
