package ru.job4j.chess;

public class Pawn extends Figure {
    public Pawn(Cell cell) {
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

        if (y0 == 2 && deltaX == 0 && y1 - y0 <= 2 && y1 - y0 > 0) {
            Cell[] moveArray = new Cell[Math.abs(y0 - y1)];
            for (int i = 1; i < (Math.abs(y0 - y1) + 1); i++) {
                moveArray[position++] = new Cell(x0, y0 + deltaY * i);
            }
            return moveArray;
        } else if (y0 > 2 && deltaX == 0 && y1 - y0 == 1) {
            Cell[] moveArray = new Cell[1];
            moveArray[0] = new Cell(x0, y0 + 1);
            return moveArray;
        } else {
            throw new ImpossibleMoveException("Your pawn can't move such way");
        }
    }

    public Figure copy(Cell dest) {
        return new Pawn(dest);
    }
}
