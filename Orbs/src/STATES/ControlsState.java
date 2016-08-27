package STATES;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import MANAGERS.GameStateManager;

public class ControlsState extends GameState {

	// The controls
	String[] controls;
	
	
	public ControlsState(GameStateManager gsm) {
		super(gsm);
		controls = new String[6];
		controls[0] = "Press the backspace button to go back to main menu.";
		controls[1] = "Up, Down, Left, Right: Move the player in respective directions";
		controls[2] = "\nM: Open up the menu";
		controls[3] = "\n X: Back/Cancel button";
		controls[4] = "\nC: Select/Interact button";
		controls[5] = "\n Enter: Select/Interact button";
	}

	@Override
	public void initialize() {
		
	}

	@Override
	public void update(double time) {
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 15));
		g.drawString(controls[0], 10, 15);
		
		g.drawString(controls[1], 40, 100);
		g.drawString(controls[2], 180, 120);
		g.drawString(controls[3], 175, 140);
		g.drawString(controls[4], 170, 160);
		g.drawString(controls[5], 155, 180);
	}
}
