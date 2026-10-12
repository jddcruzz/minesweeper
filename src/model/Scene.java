package model;

// Imports

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scene {

    // ATTRIBUTES
    protected final List<String> labels = new ArrayList<>();
    protected String scannMessage = "Select an option by typing a number.";

    // CONSTRUCTOR

    // METHODS
    public void addLabel(String info) {
        this.labels.add(info);
    }

    public void addLabel(int position, String labelText) {
        this.labels.add(position, labelText);
    }

    public String perform() {

        var sc = new Scanner(System.in);
        var sceneASCCI = this.getSceneASCCI();
        String reply = null;

        System.out.println(sceneASCCI);
        System.out.println(this.scannMessage);

        reply = sc.nextLine();

        // Invalid character



        return  reply;

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
