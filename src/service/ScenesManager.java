package service;

// Imports
import java.util.Set;
import java.util.Map;
import java.util.HashMap ;
import java.util.function.Supplier;
import java.util.function.Function;

// Local Imports
import model.Scene;

public class ScenesManager {

    // ATTRIBUTES
    private Map<String, Scene> scenes = new HashMap<>();
	private Map<String, Function<String, ?>> functionMap = new HashMap<>();
	private Map<String, Map<String, String>> sceneLinks = new HashMap<>();
	
	private String mainSceneTag = null;
	
    // CONSTRUCTOR 
    public ScenesManager() {

        this.loadScenes();
    }

    private void loadScenes() {
        
        // Menu
        var menu = new Scene();
        
        menu.addLabel("A", "Start Game");
        menu.addLabel("B", "Configuration");
        menu.addLabel("C", "Exit");

        this.scenes.put("menu", menu);

        // In Game
        var inGame = new Scene();

        inGame.addLabel("A", "Reveal Cell");
        inGame.addLabel("B", "Add Flag");
        inGame.addLabel("C", "Exit to menu");

		this.scenes.put("inGame", inGame);
        
    }

	private void perform(String sceneTag) {

		// Main scene
		
		
	}

	public void addScene(Scene scene, String sceneTag) {

		boolean tagInUse = this.scenes.containsKey(sceneTag);
		if (tagInUse) {
			return;
		}

		this.scenes.put(sceneTag, scene);

		// Set up scene
		Set<String> labelsMap = scene.getLabels().keySet();
		
	}

	public void setMainScene(String sceneTag) {

		boolean containsKey = this.scenes.containsKey(sceneTag);
		if (!containsKey) {
			return;
		}
		
	}
	
	public void addSceneFunction(String sceneTag, Function<String, ?> func) {

		boolean containsKey = this.scenes.containsKey(sceneTag);
		if (!containsKey) {
			return;
		}

		this.functionMap.put(sceneTag, func);
		
	}

}
