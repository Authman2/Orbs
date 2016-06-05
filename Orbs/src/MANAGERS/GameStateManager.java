package MANAGERS;

import java.awt.Graphics2D;

import STATES.GameState;
import STATES.MenuState;
import STATES.WorldState;

public class GameStateManager {
	
	public InputManager input;
	public GameState[] gameStates;
	public GameState  currentState;
	
	
	public GameStateManager() {
		//Set up all of the game states initially.
		gameStates = new GameState[2];
		gameStates[0] = new MenuState(this);
		gameStates[1] = new WorldState(this);
		
		//Set the current game state to the menu state.
		currentState = gameStates[0];
		
		//Tell the input manager which game state is which.
		input = new InputManager(this);
		input.menuState = (MenuState)gameStates[0];
		input.worldState = (WorldState)gameStates[1];
		
		
		initialize();
	}
	
	
	public void initialize() {
		currentState.initialize();
	}
	
	public void draw(Graphics2D g) {
		currentState.draw(g);
	}

	public void update(double time) {
		currentState.update(time);
	}

}
