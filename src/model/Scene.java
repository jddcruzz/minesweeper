package model;

// Imports
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scene {

    // ATTRIBUTES
    protected final Map<String, String> labels = new HashMap<>();
    protected String scannMessage = "Select an option by typing a character.";
	
    protected Scanner scanner = new Scanner(System.in);
    // CONSTRUCTOR

    // METHODS
    public void addLabel(String key, String labelText) {

		/** The key is stored in lowercase using `toLowerCase()`,
		  * and it is accessed by converting the user-provided key
		  * to lowercase.
		*/
        this.labels.put(key.toLowerCase(), labelText);
		
    }

	public HashMap<String, String> getLabels() {
		HashMap<String, String> clone = new HashMap<>(this.labels);
		return clone;
	}

    public String perform() {

        var sceneASCCI = this.getSceneASCCI();
		var keySet = this.labels.keySet();
		
        String reply = null;
        boolean isReplyValid = false;
		

        // Prints
        System.out.println(sceneASCCI);
        System.out.println(this.scannMessage);

        // Invalid character
        do {

            reply = scanner.nextLine().toLowerCase();

            // Check that it is a number
            isReplyValid = keySet.contains(reply);
				
            if (!isReplyValid) {

                String errorMsg = String.format("'%s' Is not an option; please enter a valid character.", reply);
                System.out.println(errorMsg);

            }

        } while (!isReplyValid);

		
        return reply;

    }

    protected StringBuilder getSceneASCCI() {
        var str = new StringBuilder();

		for (Map.Entry<String, String> entry : this.labels.entrySet()) {

			str.append("\n");
			
			String k = entry.getKey().toUpperCase();
			String v = entry.getValue();
			
			String finalLabel = String.format("[%s] %s", k, v);
			
			str.append(finalLabel);
			
		}

        return str;
    }

}
