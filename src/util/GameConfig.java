package util;

public class GameConfig {

	// ATTRIBUTES
	private static final int[] boardSize = {10, 10};
	private static int minesCount = 25;

	// METHODS 
	public static int[] getBoardSize() {
		return GameConfig.boardSize;
	}
	public static void setBoardSize(int x, int y) {
		GameConfig.boardSize[0] = x;
		GameConfig.boardSize[1] = y;
	}

	public static int getMinesCount() {
		return GameConfig.minesCount;
	}
	public static void setMinesCount(int n) {
		GameConfig.minesCount = n;
	}
	
}