package MAIN;

import java.awt.Graphics2D;

import MANAGERS.GameStateManager;
import myproject.gos.main.GOSGameLoop;

public class GameLoop extends GOSGameLoop {
	private static final long serialVersionUID = 4869900297997334871L;
	
	public GameStateManager gsm;
	public static Assets assets = new Assets();
	
	public GameLoop(int w, int h) {
		super(w,h);
		initialize();
	}

	public void initialize() {
		assets.initialize();
		gsm = new GameStateManager();
		gsm.initialize();
		super.init();
	}

	@Override
	public void update(double time) {
		super.update(time);
		if(gsm != null)
			gsm.update(time);
	}
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		if(gsm != null)
			gsm.draw(g);
		clear();
	}
	
	@Override
	public void clear() {
		super.clear();
	}
}
