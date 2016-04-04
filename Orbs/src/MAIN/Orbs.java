package MAIN;

import java.io.IOException;

import myproject.gos.main.GameWindow;
import MANAGERS.InputManager;

public class Orbs {

	public static void main(String[] args) throws IOException {	
		GameWindow gamewindow = new GameWindow("Orbs", 640, 470);
		
		GameLoop gloop = new GameLoop(640,470);		
		gamewindow.add(gloop);
		
		gamewindow.addKeyListener(gloop.gsm.input);
		gamewindow.setVisible(true);
	}

}
