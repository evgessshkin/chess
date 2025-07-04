package core.figure;

import core.Board;
import core.Move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends Figure {
    public Rook(int row, int col, FigureColor color) {
        super(row, col, color);
    }

    @Override
    public List<Move> getAvailableMoves(Board board) {
        List<Move> availableMoves = new ArrayList<>();

        int startRow = this.row;
        int startCol = this.col;

        int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        for (int[] j : direction) {
            int newRow = startRow;
            int newCol = startCol;

            while (true) {
                newRow += j[0];
                newCol += j[1];

                if (!board.isValidTile(newRow, newCol)) {
                    break;
                }

                Figure figure = board.getTile(newRow, newCol).getFigure();

                if (figure == null) {
                    availableMoves.add(
                            new Move(this, startRow, startCol, newRow, newCol, null));
                } else {
                    if (figure.color != this.color) {
                        availableMoves.add(
                                new Move(this, startRow, startCol, newRow, newCol, figure));
                    }
                    break;
                }

            }
        }


        return availableMoves;
    }
}
