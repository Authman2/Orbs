package STATES;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

import myproject.gos.main.TransitionManager.Transition;
import myproject.gos.main.Vector2D;
import MANAGERS.GameStateManager;
import MISC.TextBox;

public class StatsState extends GameState implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1743726112188241224L;

	//Boolean for whether or not the stats state is being shown
	public boolean Open;
	
	//Text box to display information about the player.
	TextBox header, body;
	
	public StatsState(GameStateManager gsm) {
		super(gsm);
		header = new TextBox(new Vector2D(3,10),630,50);
		body = new TextBox(new Vector2D(3,60),630,380);
		initialize();
	}

	@Override
	public void initialize() {
		//Set default transition
		transitions.SetTransition(Transition.Fade_In, 0.0085);
		transitions.BeginTransition();
		
		String tempn = "Player Name: " + ((WorldState)gsm.states[2]).player.playerName;
		header.addText(tempn);
		body.spacingW = 15; body.spacingH = 40;
		body.setLineNum(5);
		body.addText("Health: ");
		body.addText("Attack Level: ");
		body.addText("Defense Level: ");
		body.addText("Ranged Level: ");
		body.addText("Magic Level: ");
	}

	@Override
	public void update(double time) {
		if(transitions.transitionSet()) { transitions.update(time); }
		header.update(time);
		body.update(time);
		
		//If the fading out transition is done, just go back to the world state.
		if(transitions.getTransition() == Transition.Fade_Out && transitions.Finished()) {
			this.Open = false;
			transitions.SetTransition(Transition.Fade_In, 0.01);
			transitions.BeginTransition();
			((WorldState)gsm.states[2]).initialize();
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 640, 470);
		
		
		body.draw(g);
		header.draw(g);
		
		
		
		
		if(transitions.transitionSet()) { transitions.draw(g); }
	}

}
