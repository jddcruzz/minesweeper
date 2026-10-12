package service;

// Imports

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

        var scene = new Scene();
        scene.addLabel("Option 1");
        scene.addLabel("Option 2");
        scene.addLabel("Option 3");

        String reply = scene.perform();
        System.out.println(reply);
    }

    // METHODS
    public void start() {

    }


}
