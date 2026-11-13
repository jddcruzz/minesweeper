package service;

// Imports
import java.util.Scanner;

// Local Imports

public class ConsoleManager {

    // ATTRIBUTES
    private final Scanner consoleIn = new Scanner(System.in);
    private final SceneManager sceneMgr = new SceneManager();
	
    private boolean running = false;
	
    // CONSTRUCTOR
    public ConsoleManager() {

		SceneFunctions.functionMap.get("config").apply("A");
		SceneFunctions.functionMap.get("config").apply("b");
		
		
    }

    // METHODS
    public void run() {

        this.running = true;

        var currentScene = "menu";

        while (this.running) {

            var output = this.performScene(currentScene);
            String[] reply = {
                output[1],
                currentScene
            };

            if (output[1] == null) {
                this.running = false;
            } else {

            }

            currentScene = output[1];

        }
    }

    private String[] performScene(String sceneTag) {
        var output = this.sceneMgr.once(sceneTag, this.consoleIn);
        return output;
    }

}
