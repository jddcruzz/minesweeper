package service;

// Imports
import java.util.Map;
import java.util.HashMap ;
import java.util.function.Function;

// Local Imports
import model.Scene;

public class SceneManager {

    // ATTRIBUTES
    private Map<String, Scene> scenes = new HashMap<>();
	private Map<String, Function<String, ?>> functionMap = new HashMap<>();
	private Map<String, Map<String, String>> sceneLinks = new HashMap<>();

    // CONSTRUCTOR 	private String mainSceneTag = null;

    public SceneManager() {

        this.loadScenes();
    }

    private void loadScenes() {
        
        // Menu
        var menu = new Scene();
        
        menu.addLabel("A", "Start Game");
        menu.addLabel("B", "Configuration");
        menu.addLabel("C", "Exit");

        this.addScene(menu, "menu");

        // In Game
        var inGame = new Scene();

        inGame.addLabel("A", "Reveal Cell");
        inGame.addLabel("B", "Add Flag");
        inGame.addLabel("C", "Exit to menu");

		this.addScene(inGame, "inGame");

        // Links
        this.addSceneLink("menu", "a", "inGame");
        this.addSceneLink("inGame", "a", "menu");
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

    private String nextScene(String sceneTag, String sceneReply) {

        // Verify that sceneTag is registered in both Maps
        boolean validScene = this.scenes.containsKey(sceneTag) && this.sceneLinks.containsKey(sceneTag);
        if (!validScene) {return null;}

        var links = this.sceneLinks.get(sceneTag);

        return links.getOrDefault(sceneReply, null);

    }

	public void addScene(Scene scene, String sceneTag) {

		boolean tagInUse = this.scenes.containsKey(sceneTag);
		if (tagInUse) {return;}

		// Set up scene
        this.scenes.put(sceneTag, scene);
        this.sceneLinks.put(
            sceneTag,
            new HashMap<>()
        );
		
	}

    public void addSceneLink(String sceneTag, String labelTag, String targetSceneTag) {

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



}
