package system.game;

// Imports

// Local Imports
import util.GameConfig;
import model.Board;

public class GameMatch {

    // STATIC
	private static final String[] GAME_STATES = {
		"defeat",
		"running",
        "win"
	};

    // ATTRIBUTES
    private final Board gameBoard;
	private String gameState = GameMatch.GAME_STATES[0];

    // CONSTRUCTOR
    public GameMatch(int sx, int sy) {		
        this.gameBoard = new Board(sx, sy);
		this.gameBoard.constructBoard();
    }

    // METHODS
    public void start() {

        this.gameState = GameMatch.GAME_STATES[1];
        this.setUp();

    }

	private void setUp() {

        boolean gameRunning = GameMatch.GAME_STATES[1].equals(this.gameState);
        if (gameRunning) {return;}

		int[] boardSize = this.gameBoard.getBoardSize();
		int minesPlaced = 0;
		int minesCount = Math.min(
			GameConfig.getMinesCount(),
			boardSize[0] * boardSize[1]
		);
		
		while (minesPlaced < minesCount) {
			
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

    public void checkGameState() {



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
