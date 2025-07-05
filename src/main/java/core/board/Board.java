package core.board;

import core.Color;
import core.Move;
import core.figure.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Board {

    @Getter
    private Tile[][] board;

    private final int size = 8;
    private List<Figure> captureFigures;

    public Board() {

    }

    private void setColorsForTiles() {
        board = new Tile[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                Color color = ((row + col) % 2 == 0) ? Color.WHITE : Color.BLACK;
                Tile tile = new Tile(row, col, color);
                board[row][col] = tile;

            }
        }
    }

    private void placeFigures() {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (row == 1) {
                    Pawn pawn = new Pawn(row, col, core.Color.BLACK);
                    board[row][col].setFigure(pawn);
                } else if (row == 6) {
                    Pawn pawn = new Pawn(row, col, core.Color.WHITE);
                    board[row][col].setFigure(pawn);
                }
            }

            if (row == 0) {
                board[row][0].setFigure(new Rook(row, 0, core.Color.BLACK));
                board[row][7].setFigure(new Rook(row, 7, core.Color.BLACK));

                board[row][1].setFigure(new Knight(row, 1, core.Color.BLACK));
                board[row][6].setFigure(new Knight(row, 6, core.Color.BLACK));

                board[row][2].setFigure(new Bishop(row, 2, core.Color.BLACK));
                board[row][5].setFigure(new Bishop(row, 5, core.Color.BLACK));

                board[row][3].setFigure(new Queen(row, 3, core.Color.BLACK));
                board[row][4].setFigure(new King(row, 4, core.Color.BLACK));

            } else if (row == 7) {
                board[row][0].setFigure(new Rook(row, 0, core.Color.WHITE));
                board[row][7].setFigure(new Rook(row, 7, core.Color.WHITE));

                board[row][1].setFigure(new Knight(row, 1, core.Color.WHITE));
                board[row][6].setFigure(new Knight(row, 6, core.Color.WHITE));

                board[row][2].setFigure(new Bishop(row, 2, core.Color.WHITE));
                board[row][5].setFigure(new Bishop(row, 5, core.Color.WHITE));

                board[row][3].setFigure(new Queen(row, 3, core.Color.WHITE));
                board[row][4].setFigure(new King(row, 4, core.Color.WHITE));

            }

        }
    }


    public boolean isValidTile(int newRow, int newCol) {
        return 0 <= newRow && 7 >= newRow && 0 <= newCol && 7 >= newCol;
    }

    public Tile getTile(int row, int col) {
        return board[row][col];
    }

    public void init() {
        this.setColorsForTiles();
        this.placeFigures();
        this.captureFigures = new ArrayList<>();
    }

    public void moveFigure(Move move) {

        Figure currentFigure = move.getFigure();
        Tile startTile = getTile(move.getFromRow(), move.getFromCol());
        Tile finishTile = getTile(move.getToRow(), move.getToCol());

        if(move.getCapturedFigure() != null){
            captureFigures.add(move.getCapturedFigure());
        }

        startTile.setFigure(null);
        finishTile.setFigure(currentFigure);

    }


    public void printColorOfTiles() {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (board[row][col].getColor() == Color.BLACK) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println(" ");
        }
    }

    public void printFiguresOfBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col].getFigure() != null && board[row][col].getFigure().getClass() == Queen.class) {
                    System.out.print("0 ");
                } else if (board[row][col].getFigure() != null && board[row][col].getFigure().getClass() == Pawn.class) {
                    System.out.print("1 ");
                } else {
                    System.out.print("2 ");
                }
            }
            System.out.println(" ");
        }
    }

}
