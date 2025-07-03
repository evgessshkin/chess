package core;

import core.figure.Figure;

public class Tile {

    private final TileColor color;
    private int row;
    private int col;

    private Figure figure = null;

    public Tile(int row, int col, TileColor color){
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public TileColor getColor(){
         return color;
    }

    public void setFigure(Figure figure){
        this.figure = figure;
    }

    public Figure getFigure(){
        return figure;
    }

}
