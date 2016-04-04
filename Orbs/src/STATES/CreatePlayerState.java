package STATES;

import java.awt.Color;
import java.awt.Graphics2D;

import myproject.gos.main.TransitionManager.Transition;
import MANAGERS.GameStateManager;
import MISC.KeyBoard;

public class CreatePlayerState extends GameState {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1300623807297021549L;
	public KeyBoard keyboard;
	public String playerName = "";

	public CreatePlayerState(GameStateManager gsm) {
		super(gsm);
		
		keyboard = new KeyBoard();
		keyboard.createplayer = this;
		
		
		initialize();
	}

	@Override
	public void initialize() {
		transitions.SetTransition(Transition.Fade_In, 0.0085);
		transitions.BeginTransition();
		
		keyboard.initialize();
	}

	@Override
	public void update(double time) {
		if(transitions.transitionSet()) { transitions.update(time); }
		
		keyboard.update(time);
		
		/*
		 * TODO: FIX THIS. 
		 * 
		 */
		if(transitions.getTransition() == Transition.Fade_Out && transitions.Finished()) {
			gsm.currentState = gsm.states[2];
			gsm.currentState.initialize();
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, 640, 470);
		
		/* Later on draw a picture of the player just so that the user can see. */
		
		keyboard.draw(g);
		
		//Always draw the transition on top.
		if(transitions.transitionSet()) { transitions.draw(g); }
	}

}
