package MAIN;

import java.awt.Graphics2D;
import java.awt.event.KeyListener;

public abstract class GameState implements KeyListener {

	GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}

	
	public abstract void initialize();
	public abstract void update();
	public abstract void draw(Graphics2D g);
}
