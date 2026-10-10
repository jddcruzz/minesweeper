package service;

// Imports

// Local Imports
import model.GameBoard;

public class Game {
    
    // ATTRIBUTES
    public GameBoard gb = new GameBoard();

    // CONSTRUCTOR 
    public Game() {
        gb.constructBoard();
        gb.addTrap(4,4);
        gb.addTrap(4,3);
        System.out.println(gb.readBoard());
    }
    
    
    
}
