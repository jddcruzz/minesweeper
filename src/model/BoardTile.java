package model;

public class BoardTile {

    // ATTRIBUTES
    public int displayValue = 0;

    public boolean flagged = false;
    public boolean containsTrap = false;
    public boolean visible = false;

    // CONSTRUCTOR
    public BoardTile(boolean containsTrap) {
        this.containsTrap = containsTrap;
    }

    // METHODS
    public void setValue(int value) {
        this.displayValue = value;
    }

    public void toggleFlag() {
        this.flagged = !this.flagged;
    }

    public void toggleTrap() {
        this.containsTrap = !this.containsTrap;
    }

    public void toggleVisibility() {
        this.visible = !this.visible;
    }

}
