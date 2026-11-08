package system.game;

// Imports

// Local Imports
import util.GameConfig;
import model.Board;

public class GameMatch {

    // ATTRIBUTES
	private static final String[] GAME_STATES = {
		"off",
		"running"
	}
	
    private final Board gameBoard;
	private String gameState = GameMatch.GAME_STATES[0];

    // CONSTRUCTOR
    public GameMatch(int sx, int sy) {		
        this.gameBoard = new Board(sx, sy);
		this.gameBoard.constructBoard();
		this.setUp();
    }

	public void start() {
		this.gameState = GameMatch.GAME_STATES[1];
	}

    // METHODS
	public StringBuilder readGameBoard() {
		return this.gameBoard.read();
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

	private void setUp() {
		
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

				if (tile.trapState() == true) {continue;}

				this.gameBoard.addTrap(rnX, rnY);
				minesPlaced += 1;
				
			}
			
		}
		
	}

}
