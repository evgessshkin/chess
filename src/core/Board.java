package core;

import core.figure.*;

public class Board {

    private final int size = 8;
    private Tile[][] square;


    public Board() {
        this.setColorsForTiles();
        this.placeFigures();
    }

    private void setColorsForTiles() {
        square = new Tile[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                TileColor color = ((row + col) % 2 == 0) ? TileColor.WHITE : TileColor.BLACK;
                Tile tile = new Tile(row, col, color);
                square[row][col] = tile;

            }
        }
    }

    private void placeFigures() {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (row == 1) {
                    Pawn pawn = new Pawn(row, col, FigureColor.BLACK);
                    square[row][col].setFigure(pawn);
                } else if (row == 6) {
                    Pawn pawn = new Pawn(row, col, FigureColor.WHITE);
                    square[row][col].setFigure(pawn);
                }
            }

            if(row == 0){
                square[row][0].setFigure(new Rook(row , 0, FigureColor.BLACK));
                square[row][7].setFigure(new Rook(row, 7, FigureColor.BLACK));

                square[row][1].setFigure(new Knight(row, 1, FigureColor.BLACK));
                square[row][6].setFigure(new Knight(row, 6, FigureColor.BLACK));

                square[row][2].setFigure(new Bishop(row, 2, FigureColor.BLACK));
                square[row][5].setFigure(new Bishop(row, 5, FigureColor.BLACK));

                square[row][3].setFigure(new Queen(row, 3, FigureColor.BLACK));
                square[row][4].setFigure(new King(row, 4, FigureColor.BLACK));

            }else if (row == 7){
                square[row][0].setFigure(new Rook(row , 0, FigureColor.WHITE));
                square[row][7].setFigure(new Rook(row, 7, FigureColor.WHITE));

                square[row][1].setFigure(new Knight(row, 1, FigureColor.WHITE));
                square[row][6].setFigure(new Knight(row, 6, FigureColor.WHITE));

                square[row][2].setFigure(new Bishop(row, 2, FigureColor.WHITE));
                square[row][5].setFigure(new Bishop(row, 5, FigureColor.WHITE));

                square[row][3].setFigure(new Queen(row, 3, FigureColor.WHITE));
                square[row][4].setFigure(new King(row, 4, FigureColor.WHITE));

            }

        }
    }


    public void printColorOfTiles() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (square[row][col].getColor() == TileColor.BLACK) {
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
                if (square[row][col].getFigure() != null && square[row][col].getFigure().getClass() == King.class) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println(" ");
        }
    }

}
