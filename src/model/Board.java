package model;

// Imports

import java.util.ArrayList;
import java.util.List;

// Local Imports

public class Board {

    // ATTRIBUTES
    protected int[] boardSize = {10, 10};
    protected List<List<BoardTile>> board = new ArrayList<>();

    public Board(int sx, int sy) {
        this.boardSize[0] = sx;
        this.boardSize[1] = sy;
    }

    // METHODS
    private boolean validTile(int x, int y) {

        if (x < 0 || y < 0) {
            return false;
        }
        return x < this.boardSize[0] && y < this.boardSize[1];

    }

    // BOARD METHODS
    public void constructBoard() {

        this.board.clear();

        for (int x = 0; x < this.boardSize[0]; x++) {

            this.board.add(x, new ArrayList<>());

            for (int y = 0; y < this.boardSize[1]; y++) {

                var list = this.board.get(x);
                var tile = new BoardTile();

                tile.setVisibility(true);
                list.add(tile);

            }
        }

    }

    public StringBuilder read() {

        StringBuilder mapASCII = new StringBuilder();
        int tileLength = BoardTile.ASCII_TEMPLATE.length();
        int jumps = 0;

        for (int x = 0; x < this.boardSize[0]; x++) {

            for (int y = 0; y < this.boardSize[1]; y++) {

                var list = this.board.get(x);
                var tile = list.get(y);
                String tileASCII = tile.getASCII();

                // Adds the tile to the mapString
                int tileCount = (mapASCII.length() - jumps) / tileLength;

                if (tileCount % this.boardSize[1] == 0) {
                    mapASCII.append("\n");
                    jumps += 1;
                }

                mapASCII.append(tileASCII);

            }
        }

        return mapASCII;
    }

    // TILE OPERATIONS

    public void addTrap(int x, int y) {

        if (!this.validTile(x, y)) {
            return;
        }

        var list = this.board.get(x);
        var tile = list.get(y);

        if (tile.trapState()) {
            return;
        }

        tile.setTrap(true);


        // Updates the nearby Tiles
        for (int x1 = x - 1; x1 <= x + 1; x1++) {

            if (x1 < 0 || x1 >= this.boardSize[0]) {
                continue;
            }
            var list1 = this.board.get(x1);

            for (int y1 = y - 1; y1 <= y + 1; y1++) {

                if (y1 < 0 || y1 >= this.boardSize[1]) {
                    continue;
                }

                var neighbor = list1.get(y1);
                neighbor.setTrapCount(neighbor.getTrapCount() + 1);

            }
        }

    }

    public void removeTrap(int x, int y) {

        if (!this.validTile(x, y)) {
            return;
        }

        var list = this.board.get(x);
        var tile = list.get(y);

        if (!tile.trapState()) {
            return;
        }

        tile.setTrap(false);

        // Updates the nearby tiles
        for (int x1 = x - 1; x1 <= x + 1; x1++) {

            if (x1 < 0 || x1 >= this.boardSize[0]) {
                continue;
            }
            var list1 = this.board.get(x1);

            for (int y1 = y - 1; y1 <= y + 1; y1++) {

                if (y1 < 0 || y1 >= this.boardSize[1]) {
                    continue;
                }
                var neighbor = list1.get(y1);

                if (neighbor.getTrapCount() > 0) {
                    int newTraps = neighbor.getTrapCount() - 1;
                    neighbor.setTrapCount(newTraps);
                }

            }
        }

    }

    // Add or remove the Tile flag
    public void setFlagState(boolean state, int x, int y) {
        if (!this.validTile(x, y)) {
            return;
        }

        var list = this.board.get(x);
        var tile = list.get(y);

        tile.setFlag(state);
    }

    // Show or hide the Tile info
    public void setVisibility(boolean state, int x, int y) {
        if (!this.validTile(x, y)) {
            return;
        }

        var list = this.board.get(x);
        var tile = list.get(y);

        tile.setVisibility(state);
    }

};
