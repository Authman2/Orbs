package STATES;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import myproject.gos.main.TransitionManager.Transition;
import MANAGERS.GameStateManager;
import MANAGERS.InputManager;

public class MenuState extends GameState  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7650742187726682146L;
	public int selectedOption = 1;
	String[] options = {"NEW GAME", "LOAD GAME", "QUIT"};
	public static boolean load;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
		initialize();
	}

	@Override
	public void initialize() {
		transitions.SetTransition(Transition.Fade_In, 0.0035);
		transitions.BeginTransition();
	}

	@Override
	public void update(double time) {
		//If the transition has been set.
		if(transitions.transitionSet() == true) { transitions.update(time); }
		
		//If the transitions was to fade out and it has finished, then move on.
		if(transitions.getTransition() == Transition.Fade_Out && transitions.Finished()) {
			if(!load) {
				gsm.currentState = gsm.states[1];
				gsm.currentState.initialize();
			} else {
				gsm.load();
				gsm.currentState.initialize();
			}
		}
	}

	@Override
	public void draw(Graphics2D g) {
		//Draw all the text
		g.setColor(Color.blue);
		
		g.setFont(new Font("Arial", Font.BOLD, 60));
		g.drawString("ORBS", 230, 100);
		
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.setColor(new Color(0,120,220));
		
		g.drawString(options[0], 210, 250);
		g.drawString(options[1], 205, 300);
		g.drawString(options[2], 265, 350);
		
		
		//Draw a square on which option is being selected.
		if(selectedOption == 0) {
			g.fillRect(180, 225, 20, 20);
		} else if(selectedOption == 1){
			g.fillRect(180, 275, 20, 20);
		} else {
			g.fillRect(240, 325, 20, 20);
		}
		
		
		//Check for when to start fading the screen.
		if(transitions.transitionSet() == true) {
			transitions.draw(g);
		}
	}
	
	//If an option is clicked.
	public void select() {
		if(selectedOption == 0) {
			//Tells the menu state to fade out.
			transitions.SetTransition(Transition.Fade_Out, 0.0035);
			transitions.BeginTransition();
		} else if(selectedOption == 1) {
			//load the game
		} else {
			System.exit(0);
		}
	}
}
