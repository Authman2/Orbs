package MAIN;

import java.io.IOException;

import myproject.gos.main.GameWindow;

public class Orbs {

	public static final int WIDTH = 512, HEIGHT = 406;
	
	public static void main(String[] args) throws IOException {	
		GameWindow gamewindow = new GameWindow("Orbs", WIDTH, HEIGHT);
		
		GameLoop gloop = new GameLoop(WIDTH, HEIGHT);		
		gamewindow.add(gloop);
		
		gamewindow.addKeyListener(gloop.gsm.input);
		gamewindow.setVisible(true);
	}

}
