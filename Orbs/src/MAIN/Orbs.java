package MAIN;

import java.io.IOException;

import GAMEDEV.GameWindow;

public class Orbs {

	public static final int WIDTH = 512, HEIGHT = 406;
	
	public static void main(String[] args) throws IOException {	
		GameWindow gamewindow = new GameWindow("Orbs", WIDTH, HEIGHT);
		
		OrbsGameLoop gloop = new OrbsGameLoop(WIDTH, HEIGHT);		
		gamewindow.add(gloop);
		
		gamewindow.addKeyListener(gloop.gsm.input);
		gamewindow.setVisible(true);
	}

}
