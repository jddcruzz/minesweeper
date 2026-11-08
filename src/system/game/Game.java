package system.game;

// Imports
import java.util.Scanner;

// Local Imports
import util.GameConfig;
import system.game.GameMatch;
import service.ConsoleManager;

public class Game {

    // ATTRIBUTES
	public int[] bs = GameConfig.getBoardSize();
    public GameMatch gm = new GameMatch(bs[0], bs[1]);

    // CONSTRUCTOR 
    public Game() {
		
        var scanner = new Scanner(System.in);
        var console = new ConsoleManager();

		System.out.println(gm.readGameBoard());
		
        console.run();

    }

    // METHODS
    public void start() {

		

    }


}
