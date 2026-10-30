package util;

// Imports
import java.util.List;
import java.util.Map;

// Local Imports
import model.Scene;
import service.SceneManager;

public class SceneLoader {

    // ATTRIBUTES
    private static final Map<String, Scene> sceneMap = Map.of(

        "menu", new Scene(Map.of(

            "A", "Start Game",
            "B", "Configuration",
            "C", "Exit"

        )),

        "inGame", new Scene(Map.of(

            "A", "Reveal Cell",
            "B", "Add Flag",
            "C", "Exit to menu"

        )),

        "config", new Scene(Map.of(

            "A", "Map size",
            "B", "Mines count",
            "C", "Exit to menu"

        ))

    );

    private static final List<String[]> linkList = List.of(

        // Menu
        new String[] {"menu", "inGame", "a"},
        new String[] {"menu", "config", "b"},

        // In Game
        new String[] {"inGame", "menu", "c"},

        // Config
        new String[] {"config", "menu", "c"}

    );

    // METHODS
    public static void load(SceneManager sceneMgr) {

        var sm = SceneLoader.sceneMap;
        var ll = SceneLoader.linkList;

        // 1. Load scenes
        for (Map.Entry<String, Scene> entry : sm.entrySet()) {
            sceneMgr.addScene(
                entry.getKey(),
                entry.getValue()
            );
        }

        // 2. Load scene links
        for (String[] link : ll) {
            sceneMgr.addSceneLink(
                link[0],
                link[1],
                link[2]
            );
        }

    }
}
