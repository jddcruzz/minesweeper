package system.game;

// Imports

// Local Imports
import util.GameConfig;
import model.Board;

public class GameHandler {

    // STATIC
	private static final String[] GAME_STATES = {
		"defeat",
		"running",
        "win"
	};

    // ATTRIBUTES
    private final Board gameBoard;
    private String gameState = GameHandler.GAME_STATES[0];
    private int localMineCount = 0;

    // CONSTRUCTOR
    public GameHandler(int sx, int sy) {
        this.gameBoard = new Board(sx, sy);
		this.gameBoard.constructBoard();
    }

    // METHODS
    public void start() {

        this.setUp();
        this.gameState = GameHandler.GAME_STATES[1];

    }

    public void stop() {
        this.gameState = GameHandler.GAME_STATES[0];
    }

	private void setUp() {

        // The game must not be running in order to configure it
        boolean gameRunning = GameHandler.GAME_STATES[1].equals(this.gameState);
        if (gameRunning) {return;}

		int[] boardSize = GameConfig.getBoardSize();
        int minesPlaced = 0;

        // Update the map size and the number of mines according to the game settings
		this.localMineCount = Math.min(
			GameConfig.getMinesCount(),
			boardSize[0] * boardSize[1]
		);
        this.gameBoard.setBoardSize(boardSize[0], boardSize[1]);
        this.gameBoard.constructBoard();

        // Place the mines on the map
		while (minesPlaced < this.localMineCount) {
			
			int rnX = (int) (Math.random() * boardSize[0]);
			int rnY = (int) (Math.random() * boardSize[1]);
			var tile = this.gameBoard.getTile(rnX, rnY);

			if (tile != null) {

				if (tile.trapState()) {continue;}

                this.gameBoard.addTrap(rnX, rnY);
				minesPlaced += 1;
				
			}
		}
	}

    // In game Methods
    public StringBuilder readGameBoard() {
        return this.gameBoard.read();
    }

    public String checkGameState() {

		// States
        String defeat = GameHandler.GAME_STATES[0];
        String running = GameHandler.GAME_STATES[1];
        String win = GameHandler.GAME_STATES[2];

        int[] boardSize = this.gameBoard.getBoardSize();
        int hiddenTraps = 0;
        String state = running;

        for (int x = 0; x < boardSize[0]; x++) {
			
            for (int y = 0; y < boardSize[1]; y++) {

                var tile = this.gameBoard.getTile(x, y);
                if (tile == null) {continue;}

                // 1. If the trap was found
                boolean trapFound = tile.trapState() && tile.isVisible();
                if (trapFound) {
                    state = defeat;
                    break;
                }

                // 2. Counts the hidden traps
                boolean hiddenTrap = tile.trapState() && !tile.isVisible();
                if (hiddenTrap) {
                    hiddenTraps++;
                }
            }

            // Breaks if a trap is found
            if (state.equals(defeat)) {
                break;
            }
        }

        // Wins when all cells are uncovered, except for those that contain mines
        boolean victory = !state.equals(defeat) && (hiddenTraps == this.localMineCount);
        if (victory) {
            state = win;
        }

        return state;
    }
	
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
