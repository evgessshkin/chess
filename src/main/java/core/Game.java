package core;

import core.board.Board;
import core.board.Tile;
import core.figure.Figure;
import lombok.Getter;

import java.util.List;

public class Game {
    @Getter
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;

    public void startGame() {
        this.board = new Board();
        this.board.init();
        this.whitePlayer = new Player(Color.WHITE);
        this.blackPlayer = new Player(Color.BLACK);
        this.currentPlayer = whitePlayer;
    }

    public boolean makeMove(int startRow, int startCol, int newRow, int newCol) {
        Tile startTile = board.getTile(startRow, startCol);

        if (startTile == null || startTile.getFigure() == null || startTile.getFigure().getColor() != currentPlayer.getColor()) {
            return false;
        }

        List<Move> availableMoves = startTile.getFigure().getAvailableMoves(this.board);

        Move playerMove = new Move(startTile.getFigure(), startRow, startCol, newRow, newCol, null);

        if (availableMoves.contains(playerMove)){
            int index = availableMoves.indexOf(playerMove);
            Move move = availableMoves.get(index);
            board.moveFigure(move);
        }


            return true;
    }


}
