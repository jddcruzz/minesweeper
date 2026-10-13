package model;

// Imports

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scene {

    // ATTRIBUTES
    protected final List<String> labels = new ArrayList<>();
    protected String scannMessage = "Select an option by typing a number.";

    protected Scanner scanner = new Scanner(System.in);
    // CONSTRUCTOR

    // METHODS
    public void addLabel(String info) {
        this.labels.add(info);
    }

    public void addLabel(int position, String labelText) {
        this.labels.add(position, labelText);
    }

    public String perform() {

        var sceneASCCI = this.getSceneASCCI();

        String reply = null;
        int numberReply = 0;
        boolean isReplyValid = false;

        // Prints
        System.out.println(sceneASCCI);
        System.out.println(this.scannMessage);

        // Invalid character
        do {

            reply = scanner.nextLine();

            // 1. Check that it is a number
            try {

                numberReply = Integer.parseInt(reply);
                isReplyValid = true;

            } catch (Exception exc) {

                String errorMsg = String.format("'%s' Not a number; please enter a valid character.", reply);
                System.out.println(errorMsg);
                isReplyValid = false;

            }

            // 2. Number out of range
            if (numberReply < 0 || numberReply >= this.labels.size()) {

                String errorMsg = "Please enter a number within the range.";
                System.out.println(errorMsg);
                isReplyValid = false;

            }

        } while (!isReplyValid);

        return reply;

    }

    protected StringBuilder getSceneASCCI() {
        var str = new StringBuilder();

        for (int i = 0; i < this.labels.size(); i++) {

            str.append("\n");

            String label = this.labels.get(i);
            String finalLabel = String.format("[%d] " + label, i);

            str.append(finalLabel);

        }

        return str;
    }

}
