package STATES;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import MAIN.Orbs;
import MANAGERS.GameStateManager;

public class MenuState extends GameState  {
	
	public int selectedOption = 0;
	String[] options = {"Play","Controls","Quit"};
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
		initialize();
	}

	@Override
	public void initialize() {
		
	}

	@Override
	public void update(double time) {
		
	}

	@Override
	public void draw(Graphics2D g) {
		//Draw all the text
		g.setColor(Color.blue);
		
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("ORBS", Orbs.WIDTH / 2 - 55, 100);
		
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.setColor(new Color(0,120,220));
		
		g.drawString(options[0], Orbs.WIDTH / 2 - 40, Orbs.HEIGHT / 2 - 15);
		g.drawString(options[1], Orbs.WIDTH / 2 - 40, Orbs.HEIGHT / 2 + 35);
		g.drawString(options[2], Orbs.WIDTH / 2 - 40, Orbs.HEIGHT / 2 + 80);
		
		
		//Draw a square on which option is being selected.
		if(selectedOption == 0) {
			g.fillRect(Orbs.WIDTH / 2 - 65, Orbs.HEIGHT / 2 - 35, 20, 20);
		} else if(selectedOption == 1){
			g.fillRect(Orbs.WIDTH / 2 - 65, Orbs.HEIGHT / 2 + 10, 20, 20);
		} else if(selectedOption == 2) {
			g.fillRect(Orbs.WIDTH / 2 - 65, Orbs.HEIGHT / 2 + 55, 20, 20);
		}
		
	}

}
