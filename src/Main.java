import core.Board;


public class Main {
    public static void main(String[] args) {

        Board board = new Board();
//        board.printColorOfTiles();
        board.printFiguresOfBoard();


        System.out.println(" available moves: " + board.getTile(0,3).getFigure().getAvailableMoves(board).toString());
    }
}