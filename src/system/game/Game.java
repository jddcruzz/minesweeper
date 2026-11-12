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
	public ConsoleManager cm = new ConsoleManager();

    // CONSTRUCTOR 
    public Game() {}

    // METHODS
    public void start() {
        this.gm.start();
        System.out.println(this.gm.readGameBoard());
    }


}
