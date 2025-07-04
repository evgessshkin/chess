package core.figure;

import core.Board;
import core.Move;
import java.util.ArrayList;
import java.util.List;


// TODO: en passant

public class Pawn extends Figure {

    private boolean isFirstMove = true;

    public Pawn(int row, int col, FigureColor color) {
        super(row, col, color);
    }

    @Override
    public List<Move> getAvailableMoves(Board board) {
        List<Move> availableMoves = new ArrayList<>();

        int direction = (this.color == FigureColor.WHITE) ? -1 : 1;

        int startRow = this.row;
        int startCol = this.col;

        int oneStepRow = startRow + direction;
        if (board.isValidTile(oneStepRow, startCol) &&
                board.getTile(oneStepRow, startCol).getFigure() == null) {

            availableMoves.add(new Move(this, startRow, startCol, oneStepRow, startCol, null));

            int twoStepRow = startRow + 2 * direction;
            if (isFirstMove &&
                    board.isValidTile(twoStepRow, startCol) &&
                    board.getTile(twoStepRow, startCol).getFigure() == null) {

                availableMoves.add(new Move(this, startRow, startCol, twoStepRow, startCol, null));
            }
        }

        int[] captureOffsets = {-1, 1};

        for (int offset : captureOffsets) {
            int captureCol = startCol + offset;

            if (board.isValidTile(oneStepRow, captureCol)) {
                Figure target = board.getTile(oneStepRow, captureCol).getFigure();
                if (target != null && target.color != this.color) {
                    availableMoves.add(new Move(this, startRow, startCol, oneStepRow, captureCol, target));
                }
            }
        }

        return availableMoves;
    }

    public void setFirstMove(boolean isFirstMove){
        this.isFirstMove = isFirstMove;
    }

}
