package service;

// Imports
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

// Local Imports
import system.game.GameHandler;
import util.GameConfig;
import util.Console;

public class SceneFunctions {

    // ATTRIBUTES
    private Scanner consoleIn;
    private GameHandler gameHdr;

	private final Map<String, Function<String, Boolean>> functionMap = new HashMap<>(Map.of(

		"menu", str -> {

            if (this.gameHdr == null) {return false;}

            boolean optionA = str.toLowerCase().equals("a");
            boolean optionC = str.toLowerCase().equals("c");

            // Start Game
            if (optionA) {

                this.gameHdr.stop();
                this.gameHdr.start();
                System.out.println(this.gameHdr.readGameBoard());

            } else if (optionC) {
                this.gameHdr.stop();
                return false;
            }

            return true;
		},

        "inGame", str -> {

            if (this.consoleIn == null) {return false;}

            boolean optionA = str.toLowerCase().equals("a");
            boolean optionB = str.toLowerCase().equals("b");

			// Reveal tile
            if (optionA) {

                // Ask the user for two integers
                int[] coordinate = Console.reqTwoIntegers(this.consoleIn, true);

				this.gameHdr.revealTile(
					coordinate[0],
					coordinate[1]
				);

			// Toggle flag
            } else if (optionB) {

				// Ask the user for two integers
				int[] coordinate = Console.reqTwoIntegers(this.consoleIn, true);

				this.gameHdr.toggleFlag(
					coordinate[0],
					coordinate[1]
				);
				
            }

            return true;
        },

        "config", str -> {

            if (this.consoleIn == null) {return false;}

			boolean optionA = str.toLowerCase().equals("a");
			boolean optionB = str.toLowerCase().equals("b");

			// Map size
			if (optionA) {

                // Ask the user for two integers
                int[] newSize = Console.reqTwoIntegers(this.consoleIn, true);
                newSize[0] = Math.clamp(newSize[0], 1, 1000);
                newSize[1] = Math.clamp(newSize[1], 1, 1000);

                GameConfig.setBoardSize(newSize[0], newSize[1]);

			// Mines count
			} else if (optionB) {

				int newVal = 0;
				while (newVal < 1) {

					try {

						System.out.println("Enter the mines number: ");

                        // This clears the Scanner buffer
                        newVal = this.consoleIn.nextInt();
                        this.consoleIn.nextLine();

						boolean success = newVal > 0;
						if (!success) {
							System.out.println("The value must be at least 1!");
						}
						
					} catch (Exception e) {

                        this.consoleIn.nextLine();
                        System.out.println("Please enter a valid integer!");
						
					}
				}

				GameConfig.setMinesCount(newVal);
			}
			
			return true;
		}
		
	));
	
    // CONSTRUCTOR
    public SceneFunctions(Scanner consoleIn) {
        this.consoleIn = consoleIn;
    }

    // METHODS
    public void loadGameHdr(GameHandler gameHdr) {
        this.gameHdr = gameHdr;
    }

    public boolean runFunction(String sceneTag, String output) {

        boolean containsScene = this.functionMap.containsKey(sceneTag);
        boolean functionOutput = false;

        if (containsScene) {
            var f = this.functionMap.get(sceneTag);
            functionOutput = f.apply(output);
        }

        return functionOutput;
    }
}
