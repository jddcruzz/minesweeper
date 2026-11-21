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

	public final String startPoint = "menu";
	public boolean gameRunning = false;


    // CONSTRUCTOR 
    public Game() {

        // Set up
        int[] boardSize = GameConfig.getBoardSize();

        this.gameHdr = new GameHandler(boardSize[0], boardSize[1]);
        this.sceneMgr = new SceneManager(this.gameHdr, this.consoleIn);
    }

    // METHODS
    public void start() {
		this.gameRunning = true;
        this.scenesLoop();
		
    }

	public void scenesLoop() {
		
		String currentScene = this.startPoint;

        while (this.gameRunning) {

            // output = {sceneReply, nextScene}
            var output = this.sceneMgr.once(currentScene);
            String[] reply = {
                currentScene,
                output[0]
            };

            if (output[1] != null) {
                currentScene = output[1];
            }

            // Stops the loop if the function returns false
            this.gameRunning = this.sceneMgr.performFunction(currentScene, output[0]);

        }
	}

}
