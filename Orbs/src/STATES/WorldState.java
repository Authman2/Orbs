package STATES;

import java.awt.Graphics2D;
import java.io.Serializable;

import myproject.gos.main.TransitionManager.Transition;
import MANAGERS.GameStateManager;
import MANAGERS.HUDManager;
import MANAGERS.InputManager;
import MISC.TextBox;
import MOVEABLE.Player;
import WORLD.World;

public class WorldState extends GameState implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -616713729862260238L;
	
	//The initial "world."
	public World world;
	
	//A list of words that the player can go into
	public World[] worlds = new World[5];

	//The player
	public Player player;
	
	//The HUD
	public HUDManager hud;
	
	
	public WorldState(GameStateManager gsm) {
		super(gsm);
		
		player = new Player(this);
		//world = new World(95,95,0,this);
		hud = new HUDManager(this);
		
		hud.worldState = this;
		
		setupWorlds();
		initialize();
	}
	
	private void setupWorlds() {
		worlds[0] = new World(95,95,0,this);
		worlds[1] = new World(40,40,1,this);
		
		world = worlds[0];
	}
	
	public World getWorld() { return world; }

	
	@Override
	public void initialize() {
		if(hud != null) {
			hud.initialize();
		}
		if(world != null) {
			world.initialize();
			player.initialize();
		}
		//Set the player's name
		if(((CreatePlayerState)gsm.states[1]).playerName != null) {
			player.playerName = ((CreatePlayerState)gsm.states[1]).playerName;
		}
		
		hud.menu.selectedOption = 0;
		
		//Default transition is to fade in.
		transitions.SetTransition(Transition.Fade_In, 0.0085);
		transitions.BeginTransition();
	}

	@Override
	public void update(double time) {
		if(transitions.transitionSet() == true) transitions.update(time);
		
		hud.update(time);
		if(world != null) {
			world.update(time);
			player.update(time);
		}
		
		//If this transition is done, display a particular screen based on selected menu option.
		if(transitions.getTransition() == Transition.Fade_Out && transitions.Finished()) {
			//Go to inventory
			if(hud.menu.selectedOption == 0) {
				
			}
			//Go to equipment
			if(hud.menu.selectedOption == 1) {
				
			}
			//Go to stats
			if(hud.menu.selectedOption == 2) {
				
			}
			
			hud.menu.Open = false;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if(world != null) {
			world.draw(g);
			player.draw(g);
		}
			
		hud.draw(g);
		
		
		
		if(transitions.transitionSet() == true) transitions.draw(g);
	}

}
