package core.figure;

public abstract class Figure {

    protected int row;
    protected int col;
    protected FigureColor color;

    public Figure(int row, int col, FigureColor color){
        this.row = row;
        this.col = col;
        this.color = color;
    }


}
