package service;

// Imports
import java.util.Arrays;

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

		System.out.println(Arrays.toString(output);
        while (output[0] != null && output[1] != null) {
            output = gs.once(output[1]);
            System.out.println(Arrays.toString(output));
        }


    }

    // METHODS
    public void start() {

		

    }


}
