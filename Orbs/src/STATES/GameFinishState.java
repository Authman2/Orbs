package STATES;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import MAIN.Orbs;
import MANAGERS.GameStateManager;

public class GameFinishState extends GameState {

	public int selectedOption = 0;
	
	
	public GameFinishState(GameStateManager gsm) {
		super(gsm);
	}
	
	
	///////////// Abstract Methods //////////////
	
	@Override
	public void initialize() {
		
	}

	@Override
	public void update(double time) {
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Orbs.WIDTH, Orbs.HEIGHT);
		
		// Draw the end credits
		g.setColor(Color.white);
		
		g.setFont(new Font("Arial", 1, 20));
		g.drawString("Orbs", Orbs.WIDTH / 2 - 23, (Orbs.HEIGHT / 2) - 160);
		
		g.setFont(new Font("Arial", 0, 15));
		g.drawString("Created By: Adeola Uthman", Orbs.WIDTH / 2 - 90, (Orbs.HEIGHT / 2) - 130);
		
		g.setFont(new Font("Arial", 1, 20));
		g.drawString("Play Again", Orbs.WIDTH / 2 - 50, Orbs.HEIGHT / 2 - 20);
		g.drawString("Main Menu", Orbs.WIDTH / 2 - 50, Orbs.HEIGHT / 2 + 20);
		
		if(selectedOption == 0) {
			g.fillRect(Orbs.WIDTH / 2 - 75, Orbs.HEIGHT / 2 - 30, 10, 10);
		} else if(selectedOption == 1){
			g.fillRect(Orbs.WIDTH / 2 - 75, Orbs.HEIGHT / 2 + 10, 10, 10);
		}
	}

}
