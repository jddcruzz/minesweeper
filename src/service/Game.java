package service;

// Imports

// Local Imports
import model.Board;

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

		var gs = new SceneManager();

        var output = gs.once("menu");

        while (output[0] != null && output[1] != null) {
            output = gs.once(output[1]);
            System.out.println(output);
        }


    }

    // METHODS
    public void start() {

		

    }


}
