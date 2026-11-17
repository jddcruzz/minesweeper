package service;

// Imports
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

// Local Imports
import model.Scene;
import system.game.GameHandler;
import util.SceneLoader;

public class SceneManager {

    // ATTRIBUTES
    private final Map<String, Scene> scenes;
	private final Map<String, Map<String, String>> sceneLinks;

    private final Scanner consoleIn;
    private final SceneFunctions functions;
    private final GameHandler gameHdr;

    private boolean running = false;

    // CONSTRUCTOR
    public SceneManager(GameHandler gameHdr, Scanner consoleIn) {

        this.scenes = new HashMap<>();
        this.sceneLinks = new HashMap<>();
        this.functions = new SceneFunctions(consoleIn);

        this.gameHdr = gameHdr;
        this.consoleIn = consoleIn;

        this.functions.loadGameHdr(gameHdr);
        SceneLoader.load(this);

    }

    // METHODS
    public void run(String startFrom) {

        this.running = true;
        var currentScene = startFrom;

        while (this.running) {

            // output = {sceneReply, nextScene}
            var output = this.once(currentScene);
            String[] reply = {
                currentScene,
                output[0]
            };

            if (output[1] != null) {
                currentScene = output[1];
            }

            // Stops the loop if the function returns false
            this.running = this.functions.runFunction(reply);

        }
    }

    public String[] once(String sceneTag) {

        boolean containsScene = this.scenes.containsKey(sceneTag);
        if (!containsScene) {return null;}

        var scene = this.scenes.get(sceneTag);
        var reply = scene.perform(this.consoleIn);
        var next = this.nextScene(sceneTag, reply);

        String[] output = {reply, next};

        return output;

    }

	public void addScene(String sceneTag, Scene scene) {

		boolean tagInUse = this.scenes.containsKey(sceneTag);
		if (tagInUse) {return;}

		// Set up scene
        this.scenes.put(sceneTag, scene);
        this.sceneLinks.put(
            sceneTag,
            new HashMap<>()
        );
		
	}

    public void addSceneLink(String sceneTag, String targetSceneTag, String labelTag) {

        // Verify that "scenes" contains both scenes
        boolean containsScenes = this.scenes.containsKey(sceneTag)
            && this.scenes.containsKey(targetSceneTag);
        if (!containsScenes) {return;}

        var links = this.sceneLinks.get(sceneTag);
        links.put(labelTag, targetSceneTag);

    }

    private String nextScene(String sceneTag, String sceneReply) {

        // Verify that sceneTag is registered in both Maps
        boolean validScene = this.scenes.containsKey(sceneTag) && this.sceneLinks.containsKey(sceneTag);
        if (!validScene) {return null;}

        var links = this.sceneLinks.get(sceneTag);
        return links.getOrDefault(sceneReply, null);

    }

}
