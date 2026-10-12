package service;

// Imports

// Local Imports
import model.Board;

public class GameMatch {

    // ATTRIBUTES
    private final Board gameBoard;

    // CONSTRUCTOR
    public GameMatch(int sx, int sy) {

        this.gameBoard = new Board(sx, sy);

    }

    // METHODS
    public void revealTile(int x, int y) {

        var tile = this.gameBoard.getTile(x, y);
        if (tile == null) {
            return;
        }

        tile.setVisibility(true);

    }

    public void toggleFlag(int x, int y) {

        var tile = this.gameBoard.getTile(x, y);
        boolean flag = false;

        if (tile == null) {
            return;
        }

        flag = tile.isFlagged();
        tile.setFlag(!flag);

    }


}
