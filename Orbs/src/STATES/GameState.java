package STATES;

import java.awt.Graphics2D;

import MANAGERS.GameStateManager;

public abstract class GameState {

	public GameStateManager gsm;

	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	
	public abstract void initialize();
	public abstract void update(double time);
	public abstract void draw(Graphics2D g);
}
