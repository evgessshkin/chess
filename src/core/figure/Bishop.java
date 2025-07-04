package core.figure;

import core.Board;
import core.Move;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Figure{
    public Bishop(int row, int col, FigureColor color) {
        super(row, col, color);
    }

    @Override
    public List<Move> getAvailableMoves(Board board) {
        List<Move> availableMoves = new ArrayList<>();

        int startRow = this.row;
        int startCol = this.col;

        int[][] direction = {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}};

        for(int[] j: direction){
            int newRow = startRow;
            int newCol = startCol;

            while(true){
                newRow += j[0];
                newCol += j[1];

                if(!board.isValidTile(newRow, newCol)){
                    break;
                }

                Figure target = board.getTile(newRow,newCol).getFigure();

                if (target == null) {
                    availableMoves.add(new Move(this, startRow, startCol, newRow, newCol, null));
                } else {
                    if(target.color != this.color){
                        availableMoves.add(new Move(this, startRow, startCol, newRow, newCol, target));
                    }
                    break;
                }
            }
        }

        return availableMoves;
    }
}
