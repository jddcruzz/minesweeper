package service;

// Imports
import java.util.function.Function;

// Local Imports
import model.Board;
import model.Scene;
import util.GameScenes;

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
		Function<String, String> menuFunc = label -> {
			return "ok";
		};

		var menu = new Scene();
		menu.addLabel("A", "Start Game");
        menu.addLabel("B", "Configuration");
        menu.addLabel("C", "Exit");

		menu.perform();

    }

    // METHODS
    public void start() {

		

    }


}
