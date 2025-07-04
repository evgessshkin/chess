package core.figure;

import core.Board;
import core.Move;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure {

    private static final int[] dCol = {1, 1, 1, 0, 0, -1, -1, -1};
    private static final int[] dRow = {-1, 0, 1, -1, 1, -1, 0, 1};

    public King(int row, int col, FigureColor color) {
        super(row, col, color);
    }

    @Override
    public List<Move> getAvailableMoves(Board board) {
        List<Move> availableMoves = new ArrayList<>();

        int startRow = this.row;
        int startCol = this.col;

        for (int i = 0; i < dCol.length; i++) {
            int newRow = startRow + dRow[i];
            int newCol = startCol + dCol[i];

            if (!board.isValidTile(newRow, newCol)) {
                continue;
            }

            Figure target = board.getTile(newRow, newCol).getFigure();

            if (target == null) {
                availableMoves.add(new Move(this, startRow, startCol, newRow, newCol, null));
            } else if (target.color != this.color) {
                availableMoves.add(new Move(this, startRow, startCol, newRow, newCol, target));
            }
        }

        // TODO: Add castling logic

        return availableMoves;
    }
}
