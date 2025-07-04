package core;

import core.figure.Figure;

public class Move {

    private Figure figure;
    private Figure capturedFigure;
    private int fromRow;
    private int fromCol;
    private int toRow;
    private int toCol;

    public Move(Figure figure, int fromRow, int fromCol, int toRow, int toCol, Figure capturedFigure){
        this.figure = figure;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
        this.capturedFigure = capturedFigure;
    }

    @Override
    public String toString(){

        return new String("figure: " + figure.getClass() + "; new row:" + this.toRow + "; new col:" + this.toCol + ";\n");
    }


}
