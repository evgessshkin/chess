package core;

import core.figure.Figure;
import lombok.Getter;

@Getter
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

        return "figure: " + figure.getClass() + "; new row:" + this.toRow + "; new col:" + this.toCol + ";\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return this.fromRow == move.fromRow && this.fromCol == move.fromCol  &&  this.toRow == move.toRow && this.toCol == move.toCol;
    }


}
