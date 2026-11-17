package system.game;

// Imports

// Local Imports
import service.SceneManager;
import util.GameConfig;

import java.util.Scanner;

public class Game {

    // ATTRIBUTES
    public final Scanner consoleIn = new Scanner(System.in);
    public GameHandler gameHdr;
    public SceneManager sceneMgr;


    // CONSTRUCTOR 
    public Game() {

        // Set up
        int[] boardSize = GameConfig.getBoardSize();

        this.gameHdr = new GameHandler(boardSize[0], boardSize[1]);
        this.sceneMgr = new SceneManager(this.gameHdr, this.consoleIn);
    }

    // METHODS
    public void start() {
        this.sceneMgr.run("menu");
    }


}
