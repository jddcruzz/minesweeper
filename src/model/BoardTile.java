package model;

public class BoardTile {

    // STATIC 
    public static final String ASCII_TEMPLATE = "[ ]";

    // ATTRIBUTES
    public boolean flagged = false;
    public boolean containsTrap = false;
    public boolean visible = false;
    public int trapCount = 0;

    // CONSTRUCTOR
    public BoardTile() {
    }

    // METHODS

    // SET
    public void setTrapCount(int value) {
        this.trapCount = value;
    }

    public void setFlag(boolean state) {
        this.flagged = state;
    }

    public void setTrap(boolean state) {
        this.containsTrap = state;
    }

    public void setVisibility(boolean state) {
        this.visible = state;
    }

    // GET
    public int getTrapCount() {
        return this.trapCount;
    }

    public boolean trapState() {
        return this.containsTrap;
    }

    public boolean isFlagged() {
        return this.flagged;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public String getASCII() {

        String tileASCII = BoardTile.ASCII_TEMPLATE;

        // Applies the modifications to the text
        int trapCount = this.trapCount;

        if (this.visible) {

            if (this.containsTrap) {
                tileASCII = "[*]";
            } else {
                tileASCII = String.format("[%d]", trapCount);
            }

        } else if (this.flagged) {

            tileASCII = "[F]";

        }

        return tileASCII;
    }

}
