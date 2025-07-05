package core.figure;

import core.Color;
import core.board.Board;
import core.Move;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Figure{
    public Knight(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public List<Move> getAvailableMoves(Board board) {
        List <Move> availableMoves = new ArrayList<>();

        int startRow = this.row;
        int startCol = this.col;

        int[][] direction = {{-1, -2},
                {-2, -1},
                {-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2,-1},
                {1,-2}
        };

        for(int[] j: direction){
            int newRow =  startRow + j[0];
            int newCol = startCol + j[1];

            if(!board.isValidTile(newRow,newCol)){
                continue;
            }

            Figure target = board.getTile(newRow, newCol).getFigure();

            if (target == null) {
                availableMoves.add(new Move(this, startRow, startCol, newRow, newCol, null));
            } else if(target.color != this.color){
                availableMoves.add(new Move(this, startRow, startCol, newRow, newCol, target));
            }


        }


        return availableMoves;
    }
}
