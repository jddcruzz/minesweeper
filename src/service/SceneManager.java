package service;

// Imports
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

// Local Imports
import model.Scene;
import util.SceneLoader;

public class SceneManager {

    // ATTRIBUTES
    private final Map<String, Scene> scenes = new HashMap<>();
	private final Map<String, Function<String, ?>> functionMap = new HashMap<>();
	private final Map<String, Map<String, String>> sceneLinks = new HashMap<>();

    // CONSTRUCTOR

    public SceneManager() {

        SceneLoader.load(this);

    }

    public String[] once(String sceneTag) {

        boolean containsScene = this.scenes.containsKey(sceneTag);
        if (!containsScene) {return null;}

        var scene = this.scenes.get(sceneTag);
        var reply = scene.perform();
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
        boolean containsScenes =
            this.scenes.containsKey(sceneTag)
            && this.scenes.containsKey(targetSceneTag);
        if (!containsScenes) {return;}

        var links = this.sceneLinks.get(sceneTag);
        links.put(labelTag, targetSceneTag);

    }
	public void addSceneFunction(String sceneTag, Function<String, ?> func) {

		boolean containsScene = this.scenes.containsKey(sceneTag);
		if (!containsScene) {return;}

		this.functionMap.put(sceneTag, func);
		
	}

    private String nextScene(String sceneTag, String sceneReply) {

        // Verify that sceneTag is registered in both Maps
        boolean validScene = this.scenes.containsKey(sceneTag) && this.sceneLinks.containsKey(sceneTag);
        if (!validScene) {return null;}

        var links = this.sceneLinks.get(sceneTag);

        return links.getOrDefault(sceneReply, null);

    }

}
