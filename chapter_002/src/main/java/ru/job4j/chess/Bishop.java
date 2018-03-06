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


        if ((x1 - x0) == (y1 - y0)) { // низ право
            Cell[] moveArray = new Cell[x1 - x0];
            int j = y0 + 1;
            for (int i = x0 + 1; i <= x1; i++) {
                moveArray[position++] = new Cell(i, j++);
            }
            return moveArray;
        } else if ((x1 - x0) == (y0 - y1)) { // низ лево
            Cell[] moveArray = new Cell[x1 - x0];
            int j = y0 - 1;
            for (int i = x0 + 1; i <= x1; i++) {
                moveArray[position++] = new Cell(i, j--);
            }
            return moveArray;
        } else if ((x0 - x1) == (y0 - y1)) { // верх лево
            Cell[] moveArray = new Cell[x0 - x1];
            int j = y0 - 1;
            for (int i = x0 - 1; i >= x1; i--) {
                moveArray[position++] = new Cell(i, j--);
            }
            return moveArray;
        } else if ((x0 - x1) == (y1 - y0)) { // верх право
            Cell[] moveArray = new Cell[x0 - x1];
            int j = y0 + 1;
            for (int i = x0 - 1; i >= x1; i--) {
                    moveArray[position++] = new Cell(i, j++);
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
