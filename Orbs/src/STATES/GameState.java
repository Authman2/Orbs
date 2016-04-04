package STATES;

import java.awt.Graphics2D;
import java.io.Serializable;

import myproject.gos.main.TransitionManager;
import MANAGERS.GameStateManager;

public abstract class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1541365540437310243L;

	public GameStateManager gsm;

	//The TransitionManager
	public TransitionManager transitions;
	
	
	public GameState() {
		transitions = new TransitionManager();
	}
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
		transitions = new TransitionManager();
	}
	
	
	public abstract void initialize();
	public abstract void update(double time);
	public abstract void draw(Graphics2D g);
}
