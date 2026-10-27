package service;

// Imports
import java.util.function.Function;

// Local Imports
import model.Board;
import model.Scene;

public class Game {

    // ATTRIBUTES
    public Board board = new Board(10, 10);

    // CONSTRUCTOR 
    public Game() {

        board.constructBoard();
        board.addTrap(5, 6);
        board.addTrap(4, 4);

        System.out.println(board.read());

        board.removeTrap(4, 4);

        System.out.println(board.read());

		var gs = new ScenesManager();

        gs.perform("menu");

    }

    // METHODS
    public void start() {

		

    }


}
