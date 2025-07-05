package core;


public class Main {
    public static void main(String[] args) {

//        Board board = new Board();
//        board.printColorOfTiles();
//        System.out.println(" available moves: " + board.getTile(0,3).getFigure().getAvailableMoves(board).toString());

        Game game = new Game();

        game.startGame();
        game.getBoard().printFiguresOfBoard();
        game.makeMove(6,1,4,1);
        System.out.println("  ");
        game.getBoard().printFiguresOfBoard();

    }
}