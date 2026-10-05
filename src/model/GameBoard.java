package model;

// Imports
import java.util.ArrayList;
import java.util.List;

// Local Imports

public class GameBoard {

    // ATTRIBUTES
    protected int[] boardSize = {10, 10};
    protected List<List<BoardTile>> board = new ArrayList<>(); 

    // METHODS
    public void constructBoard() {

        this.board.clear();

        for (int x = 0; x < this.boardSize[1]; x++) {
            
            this.board.add(x, new ArrayList<>());

            for (int y = 0; y < this.boardSize[2]; y++) {
                
                var list = this.board.get(x);
                var tile = new BoardTile(false);
                list.add(tile);

            }            
        }
        
    }
    
}
