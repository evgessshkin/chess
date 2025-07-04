package core.figure;

import core.Board;
import core.Move;

import java.util.List;

public class Knight extends Figure{
    public Knight(int row, int col, FigureColor color) {
        super(row, col, color);
    }

    @Override
    public List<Move> getAvailableMoves(Board board) {
        return List.of();
    }
}
