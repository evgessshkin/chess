import core.Board;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
//        board.printColorOfTiles();
        board.printFiguresOfBoard();


        System.out.println(" available moves: " + board.getBoard()[3][6].getFigure().getAvailableMoves(board).toString());
    }
}