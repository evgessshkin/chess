package core.board;

import core.Color;
import core.figure.Figure;
import lombok.Getter;
import lombok.Setter;

public class Tile {
    @Getter
    private final Color color;
    private int row;
    private int col;

    @Getter
    @Setter
    private Figure figure = null;

    public Tile(int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }



}
