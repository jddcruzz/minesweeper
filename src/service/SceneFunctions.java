package service;

// Imports
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import java.util.function.Function;

// Local Imports
public class SceneFunctions {

    // ATTRIBUTES
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

				int newX = 0;
				int newY = 0;

				while (newX < 1) {

					try {

						System.out.println("Enter the map width:");
						newX = SceneFunctions.sc.nextInt();

						if (newX < 1) {
							System.out.println("The width must be at least 1!");
						}
						
					} catch (Exception e) {
						System.out.println("Please enter a valid integer!");
						SceneFunctions.sc.next();
					}

				}
				System.out.println(newX);
				
			// Mines count
			} else if (optionB) {

			}
			
			return true;
		}

		
	));
	

    // METHODS
    public void sceneOutput(String[] output) {

    }
}
