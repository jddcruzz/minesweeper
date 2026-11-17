package util;

import java.util.Scanner;

public class Console {

    // METHODS
    public static int[] reqTwoIntegers(Scanner consoleIn, boolean excludeNegatives) {

        int[] coordinate = {0, 0};
        boolean crdObtained = false;

        while (!crdObtained) {

            try {

                String[] numbers;
                String reply;

                // This looks for two numbers separated by a comma; there may be spaces before or after the comma
                System.out.println("Enter the values separated by a comma, like this: (w, h)");
                reply = consoleIn.findInLine("-?\\d+\\s*,\\s*-?\\d+");
                consoleIn.nextLine();

                // Removes the spaces from the text (if reply == null catch a NullPointerException)
                reply = reply.replaceAll("\\s+", "");

                numbers = reply.split(",", 2);
                coordinate[0] = Integer.parseInt(numbers[0]);
                coordinate[1] = Integer.parseInt(numbers[1]);

                crdObtained = true;

                if (excludeNegatives) {
                    if (coordinate[0] < 0 || coordinate[1] < 0) {
                        crdObtained = false;
                        System.out.println("Please enter positive values!");
                    }
                }

            } catch (NullPointerException e) {
                System.out.println("Please enter the values in the specified format!");
            }
        }

        return coordinate;
    }

    public static int[] reqTwoIntegers(Scanner consoleIn) {
        return Console.reqTwoIntegers(consoleIn, false);
    }

}
