package Service;

// Imports
import java.util.Map;
import java.util.HashMap ;
import java.util.function.Supplier;
import java.util.function.Function;

// Local Imports
import model.Scene;

public class GameScenes {

    // ATTRIBUTES
    private Map<String, Scene> scenes = new HashMap<>();
	private Map<String, Function<String, ?>> functionMap = new HashMap<>();
	private Map<String, Map<String, String>> sceneLinks = new HashMap<>();

	private String mainSceneTag = null;
	
    // CONSTRUCTOR 
    public GameScenes() {

        this.loadScenes();
    }

    private void loadScenes() {
        
        // Menu
        var menu = new Scene();
        
        menu.addLabel("A", "Start Game");
        menu.addLabel("B", "Configuration");
        menu.addLabel("C", "Exit");

        this.scenes.put("menu", menu);

		var menuMap 
		this.sceneLinks.put("menu", new HashMap<>())

        // In Game
        var inGame = new Scene();

        inGame.addLabel("A", "Reveal Cell");
        inGame.addLabel("B", "Add Flag");
        inGame.addLabel("C", "Exit to menu");

		this.scenes.put("inGame", inGame);
        
    }

	private void perform() {

		// Main scene
		
		
	}

	public void addScene(Scene scene) {

		
		
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

		this.functionMap.put(
			sceneTag,
			func
		);
		
	}

	public void addSceneLink(String originTag, String targetTag) {

		boolean containsK1 = this.scenes.containsKeys(originTag);
		boolean containsK2 = this.scenes.containsKey(targetTag);

		if (!containsK1 || !containsK2) {
			return;
		}
		
		var originLinks = this.sceneLinks.get(originTag);
		this.sceneLinks.put(originTag, targetTag);
		
	}
}
