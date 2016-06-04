package MAIN;

import gamedev2Dje.GameLoop;

public class OrbsGameLoop extends GameLoop {
	private static final long serialVersionUID = 251824467158869244L;
	
	
	public GameStateManager gsm;
	
	
	public OrbsGameLoop(int w, int h) {
		super(w, h);
		initialize();
	}
	
	
	@Override
	public void initialize() {
		gsm = new GameStateManager();
		gsm.initialize();
		super.initialize();
	}

	@Override
	public void update() {
		super.update();
		gsm.update();
	}
	
	@Override
	public void draw() {
		super.draw();
		gsm.draw(graphics);
		clear();
	}
	
	@Override
	public void clear() {
		super.clear();
	}
	
}
