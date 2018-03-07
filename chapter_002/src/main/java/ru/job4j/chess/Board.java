package ru.job4j.chess;

public class Board {
    private Figure[] figures = new Figure[32];
    private int count = 0;

    void add(Figure figure) {
        this.figures[count++] = figure;
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean figureExist = false;
        boolean wayExist = true;
        int index = 0;

        for (int i = 0; i < 32; i++) {
            if (figures[i] != null && source.equals(figures[i].position)) {
                index = i;
                figureExist = true;
                break;
            }
        }
        if (figureExist) {
            if (figures[index].way(source, dest) != null) {
                for (Cell way : figures[index].way(source, dest)) {
                    for (int i = 0; i < 32; i++) {
                        if (figures[i] != null && (way.getPosX() == figures[i].position.getPosX()) && (way.getPosY() == figures[i].position.getPosY())) {
                            wayExist = false;
                            break;
                        }
                    }
                }
                if (wayExist) {
                    figures[index] = figures[index].copy(dest);
                } else {
                    throw new OccupiedWayException("Other figures on the way");
                }
            }
        } else {
            throw new FigureNotFoundException("No figure in source cell");
        }
        return true;
    }
}
