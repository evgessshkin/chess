package core.figure;

import core.Board;
import core.Move;

import java.util.List;

public class Rook extends Figure{
    public Rook(int row, int col, FigureColor color) {
        super(row, col, color);
    }

    @Override
    public List<Move> getAvailableMoves(Board board) {
        return List.of();
    }
}
