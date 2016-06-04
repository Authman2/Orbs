package MAIN;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	
	//Options for the user to choose from
	String[] options = {"Play", "Quit"};
	int currentOption = 0;
	
	

	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g) {
		//Set font
		g.setFont(new Font("Arial", 1, 30));
		
		//Draw the text options
		g.drawString(options[0], OrbsGame.WIDTH / 2 - 35, OrbsGame.HEIGHT / 2 - 15);
		g.drawString(options[1], OrbsGame.WIDTH / 2 - 35, OrbsGame.HEIGHT / 2 + 25);
		
		//Draw the little arrow indicator
		if(currentOption == 0)
			g.fillRect(OrbsGame.WIDTH / 2 - 50, OrbsGame.HEIGHT / 2 - 30, 10, 10);
		if(currentOption == 1)
			g.fillRect(OrbsGame.WIDTH / 2 - 50, OrbsGame.HEIGHT / 2 + 10, 10, 10);
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			currentOption = 0;
			System.out.println(currentOption);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			currentOption = 1;
			System.out.println(currentOption);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}
