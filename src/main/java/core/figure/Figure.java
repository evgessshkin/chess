package core.figure;

import core.Color;
import core.board.Board;
import core.Move;
import lombok.Getter;

import java.util.List;

public abstract class Figure {

    protected int row;
    protected int col;

    @Getter
    protected final Color color;

    public Figure(int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public abstract  List<Move> getAvailableMoves(Board board);


}
