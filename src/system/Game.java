package system;

// Imports
import java.util.Scanner;

// Local Imports
import model.Board;
import service.ConsoleManager;

public class Game {

    // ATTRIBUTES
    public Board board = new Board(10, 10);

    // CONSTRUCTOR 
    public Game() {

        var scanner = new Scanner(System.in);
        var console = new ConsoleManager();

        board.constructBoard();
        board.addTrap(5, 6);
        board.addTrap(4, 4);

        System.out.println(board.read());
        board.removeTrap(4, 4);
        System.out.println(board.read());

        console.run();

    }

    // METHODS
    public void start() {

		

    }


}
