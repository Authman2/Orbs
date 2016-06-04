package MAIN;

import java.awt.Graphics2D;
import java.util.Stack;

public class GameStateManager {

	Stack<GameState> states;
	
	public GameStateManager() {
		states = new Stack<GameState>();
		states.push(new MenuState(this)); 
	}
	
	public void initialize() {
		states.peek().initialize();
	}
	
	public void update() {
		states.peek().update();
	}
	
	public void draw(Graphics2D g) {
		states.peek().draw(g); 
	}

}
