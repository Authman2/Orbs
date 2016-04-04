package MAIN;

import java.awt.Graphics2D;

import myproject.gos.main.GOSGameLoop;
import myproject.gos.main.IUD;
import MANAGERS.GameStateManager;

public class GameLoop extends GOSGameLoop implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4869900297997334871L;
	public GameStateManager gsm;
	public static Assets assets = new Assets();
	
	public GameLoop(int w, int h) {
		super(w,h);
		initialize();
	}

	@Override
	public void initialize() {
		assets.init();
		try {
			gsm = new GameStateManager();
		} catch(Exception e) {
			e.printStackTrace();
		}
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
