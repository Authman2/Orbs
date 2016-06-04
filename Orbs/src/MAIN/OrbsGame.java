package MAIN;

import gamedev2Dje.JEGameWindow;

public class OrbsGame {

	public static final int WIDTH = 500, HEIGHT = 400;
	
	public static void main(String[] args) {
		JEGameWindow window = new JEGameWindow("Orbs", WIDTH, HEIGHT);
		window.setFullScreen(0);
		
		OrbsGameLoop gameloop = new OrbsGameLoop(WIDTH,HEIGHT);
		window.add(gameloop);
		window.addKeyListener(gameloop.gsm.states.peek());
		
		
		window.setVisible(true);
	}

}
