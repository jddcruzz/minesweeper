package service;

// Imports
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import java.util.function.Function;

// Local Imports
import util.GameConfig;

public class SceneFunctions {

    // STATIC
	private static final Scanner sc = new Scanner(System.in);
	public static final Map<String, Function<String, Boolean>> functionMap = new HashMap<>(Map.of(

		"menu", str -> {

			return true;
		},

		"config", str -> {

			boolean optionA = str.toLowerCase().equals("a");
			boolean optionB = str.toLowerCase().equals("b");

			// Map size
			if (optionA) {

				String[] labels = {"width: ", "height: "};
				int[] newSize = {0, 0};
				int n = 0;

				while (newSize[0] < 1 || newSize[1] < 1) {
					
					if (newSize[n] > 0) {continue;}

					try {

						System.out.println("Enter the map " + labels[n]);
						newSize[n] = SceneFunctions.sc.nextInt();

						// Updates "n" only if the new size is valid
						boolean success = newSize[n] > 0;
						
						if (success) {
							n = (n + 1) % (2);
						} else {
							System.out.println("The " + labels[n] + " must be at least 1!");
						}
						
					} catch (Exception e) {
						
						// This clears the Scanner buffer
						System.out.println("Please enter a valid integer!");
						SceneFunctions.sc.next();
						
					}
				}

                GameConfig.setBoardSize(newSize[0], newSize[1]);

			// Mines count
			} else if (optionB) {

				int newVal = 0;

				while (newVal < 1) {

					try {

						System.out.println("Enter the mines number: ");
						newVal = SceneFunctions.sc.nextInt();

						boolean success = newVal > 0;
						if (!success) {
							System.out.println("The value must be at least 1!");
						}
						
					} catch (Exception e) {

						// This clears the Scanner buffer
						System.out.println("Please enter a valid integer!");
						SceneFunctions.sc.next();
						
					}
				}

				GameConfig.setMinesCount(newVal);
			}
			
			return true;
		}

		
	));
	

    // METHODS
    public void sceneOutput(String[] output) {

    }
}
