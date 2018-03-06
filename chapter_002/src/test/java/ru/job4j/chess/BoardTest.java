package ru.job4j.chess;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void whenMoveFigureByRulesThenItMoves() {
        Board board = new Board();
        Cell cellSrc = new Cell(1, 1);
        Cell cellDst = new Cell(3, 3);
        board.add(new Bishop(cellSrc));
        assertThat(board.move(cellSrc, cellDst), is(true));
    }

    @Test
    public void whenHaveNoFigureInCellThenThrowException() {
        Board board = new Board();
        Cell cellFigure = new Cell(2, 1);
        Cell cellSrc = new Cell(1, 1);
        Cell cellDst = new Cell(3, 3);
        board.add(new Bishop(cellFigure));
        try {
            board.move(cellSrc, cellDst);
        } catch (FigureNotFoundException fne) {
            assertThat(fne.getMessage(), is("No figure in source cell"));
        }
    }

    @Test
    public void whenFigureCantMoveInDestCellThenThrowException() {
        Board board = new Board();
        Cell cellSrc = new Cell(1, 1);
        Cell cellDst = new Cell(2, 3);
        board.add(new Bishop(cellSrc));
        try {
            board.move(cellSrc, cellDst);
        } catch (ImpossibleMoveException ime) {
            assertThat(ime.getMessage(), is("Your bishop can't move such way"));
        }
    }

    @Test
    public void whenOtherFigureOnTheWayThenThrowException() {
        Board board = new Board();
        Cell cellFigure2 = new Cell(3, 3);
        Cell cellSrc = new Cell(2, 2);
        Cell cellDst = new Cell(4, 4);

        board.add(new Bishop(cellSrc));
        board.add(new Bishop(cellFigure2));
        try {
            board.move(cellSrc, cellDst);
        } catch (OccupiedWayException owe) {
            assertThat(owe.getMessage(), is("Other figures on the way"));
        }
    }
}
