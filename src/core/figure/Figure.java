package core.figure;

import core.Board;
import core.Move;

import java.util.List;

public abstract class Figure {

    protected int row;
    protected int col;
    protected FigureColor color;

    public Figure(int row, int col, FigureColor color){
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public abstract  List<Move> getAvailableMoves(Board board);

}
