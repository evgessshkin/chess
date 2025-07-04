package core;

import core.figure.*;

public class Board {

    private final int size = 8;
    private Tile[][] board;


    public Board() {
        this.setColorsForTiles();
        this.placeFigures();
    }

    private void setColorsForTiles() {
        board = new Tile[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                TileColor color = ((row + col) % 2 == 0) ? TileColor.WHITE : TileColor.BLACK;
                Tile tile = new Tile(row, col, color);
                board[row][col] = tile;

            }
        }
    }

    private void placeFigures() {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (row == 1) {
                    Pawn pawn = new Pawn(row, col, FigureColor.BLACK);
                    board[row][col].setFigure(pawn);
                } else if (row == 3) {
                    Pawn pawn = new Pawn(row, col, FigureColor.WHITE);
                    board[row][col].setFigure(pawn);
                }
            }

            if(row == 0){
                board[row][0].setFigure(new Rook(row , 0, FigureColor.BLACK));
                board[row][7].setFigure(new Rook(row, 7, FigureColor.BLACK));

                board[row][1].setFigure(new Knight(row, 1, FigureColor.BLACK));
                board[row][6].setFigure(new Knight(row, 6, FigureColor.BLACK));

                board[row][2].setFigure(new Bishop(row, 2, FigureColor.BLACK));
                board[row][5].setFigure(new Bishop(row, 5, FigureColor.BLACK));

                board[row][3].setFigure(new Queen(row, 3, FigureColor.BLACK));
                board[row][4].setFigure(new King(row, 4, FigureColor.BLACK));

            }else if (row == 7){
                board[row][0].setFigure(new Rook(row , 0, FigureColor.WHITE));
                board[row][7].setFigure(new Rook(row, 7, FigureColor.WHITE));

                board[row][1].setFigure(new Knight(row, 1, FigureColor.WHITE));
                board[row][6].setFigure(new Knight(row, 6, FigureColor.WHITE));

                board[row][2].setFigure(new Bishop(row, 2, FigureColor.WHITE));
                board[row][5].setFigure(new Bishop(row, 5, FigureColor.WHITE));

                board[row][3].setFigure(new Queen(row, 3, FigureColor.WHITE));
                board[row][4].setFigure(new King(row, 4, FigureColor.WHITE));

            }

        }
    }

    public Tile[][] getBoard(){
        return this.board;
    }

    public boolean isValidTile(int newRow, int newCol){
        return 0 <= newRow && 7 >= newRow && 0 <= newCol && 7 >= newCol;
    }

    public Tile getTile(int row,int col){
        return board[row][col];
    }




    public void printColorOfTiles() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col].getColor() == TileColor.BLACK) {
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
                if (board[row][col].getFigure() != null && board[row][col].getFigure().getClass() == Pawn.class) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println(" ");
        }
    }

}
