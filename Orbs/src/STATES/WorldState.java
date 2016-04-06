package STATES;

import java.awt.Graphics2D;
import java.io.Serializable;

import myproject.gos.main.TransitionManager.Transition;
import myproject.gos.main.Vector2D;
import MANAGERS.GameStateManager;
import MANAGERS.HUDManager;
import MOVEABLE.Player;
import WORLD.Door;
import WORLD.Tile;
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
	
	@Override
	public void initialize() {
		if(hud != null) {
			hud.initialize();
		}
		if(world != null) {
			world.initialize();
			player.initialize();
			
			//Set the desitinations of the doors
			configureDoors();
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
			
			//Go to a particular world when stepping on a door tile.
			for(Tile[] tls : world.tiles) {
				for(Tile door : tls) {
					if(door instanceof Door) {
						if(((Door) door).onDoor()) {
							world = ((Door) door).getGoTo();
						}
					}
				}
			}
		}
		
		//If this transition is done, display a particular screen based on selected menu option.
		if(transitions.getTransition() == Transition.Fade_Out && transitions.Finished()) {
			
			
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
	
	
	/** Create all of the worlds. */
	private void setupWorlds() {
		worlds[0] = new World(322,174,0,this).setStartPosition(new Vector2D(-10,-50));
		worlds[1] = new World(15,15,1,this).setStartPosition(new Vector2D(3,-7));
		
		world = worlds[0];
	}
	
	/** Return the instance of the CURRENT world. */
	public World getWorld() { return world; }

	/** Sets ups all of the destinations for the doors.*/
	private void configureDoors() {
		for(Tile[] tls : world.tiles) {
			for(Tile door : tls) {
				if(door instanceof Door) {
					
					if(door.position.X == 2 && door.position.Y == 3) {
						((Door) door).setGoTo(worlds[1]);
					}
					
					if(door.position.X == 2 && door.position.Y == 11) {
						((Door) door).setGoTo(worlds[1]);
					}
					
					if(door.position.X == 10 && door.position.Y == 3) {
						
					}
					
					if(door.position.X == 16 && door.position.Y == 17) {
						
					}
					
					if(door.position.X == 10 && door.position.Y == 3) {
						
					}
					
					if(door.position.X == 18 && door.position.Y == 3) {
						
					}
					
					if(door.position.X == 36 && door.position.Y == 7) {
						
					}
					
					if(door.position.X == 54 && door.position.Y == 4) {
						
					}
					
					if(door.position.X == 54 && door.position.Y == 11) {
						
					}
					
					if(door.position.X == 62 && door.position.Y == 78) {
						
					}
					
					if(door.position.X == 63 && door.position.Y == 0) {
						
					}
					
					if(door.position.X == 69 && door.position.Y == 78) {
						
					}
					
					if(door.position.X == 71 && door.position.Y == 70) {
						
					}

					if(door.position.X == 77 && door.position.Y == 78) {
						
					}
					
					if(door.position.X == 81 && door.position.Y == 70) {
						
					}
					
					if(door.position.X == 82 && door.position.Y == 70) {
						
					}
					
					if(door.position.X == 84 && door.position.Y == 78) {
						
					}
				}
			}
		}
	}

}
