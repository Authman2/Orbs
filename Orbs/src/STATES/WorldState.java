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
		/* World Map */
		worlds[0] = new World(581,205,0,this).setStartPosition(new Vector2D(-7,-51));
		
		/* Houses */
		worlds[1] = new World(15,15,1,this).setStartPosition(new Vector2D(3,-7));
		worlds[2] = new World(20,15,2,this).setStartPosition(new Vector2D(0,-7));
		worlds[3] = new World(35,35,3,this).setStartPosition(new Vector2D(-8,-20));
		
		world = worlds[0];
	}
	
	/** Return the instance of the CURRENT world. */
	public World getWorld() { return world; }

	/** Sets ups all of the destinations for the doors.*/
	private void configureDoors() {
		for(Tile[] tls : world.tiles) {
			for(Tile door : tls) {
				if(door instanceof Door) {
					//System.out.println(door.position.toString());
					
					if(door.position.equals(10, 6)) {
						((Door) door).setGoTo(worlds[2]);
					}
					
					if(door.position.equals(10, 14)) {
						((Door) door).setGoTo(worlds[1]);
					}
					
					if(door.position.equals(18, 6)) {
						
					}
					
					if(door.position.equals(24, 20)) {
						((Door) door).setGoTo(worlds[3]);
					}
					
					if(door.position.equals(26, 6)) {
						
					}
					
					if(door.position.equals(44, 10)) {
						
					}
					
					if(door.position.equals(62, 7)) {
						
					}
					
					if(door.position.equals(62, 14)) {
						
					}
					
					if(door.position.equals(70, 81)) {
						
					}
					
					if(door.position.equals(71, 3)) {
						
					}
					
					if(door.position.equals(73, 15)) {
						
					}
					
					if(door.position.equals(77, 81)) {
						
					}
					
					if(door.position.equals(79, 73)) {
						
					}

					if(door.position.equals(85, 81)) {
						
					}
					
					if(door.position.equals(89, 73)) {
						
					}
					
					if(door.position.equals(90, 73)) {
						
					}
					
					if(door.position.equals(92, 81)) {
						
					}
					
					if(door.position.equals(174, -44)) {
						
					}
					
					if(door.position.equals(174, -32)) {
						
					}
					
					if(door.position.equals(174, -25)) {
						
					}
					
					if(door.position.equals(174, -17)) {
						
					}
					
					if(door.position.equals(176, 66)) {
						
					}
					
					if(door.position.equals(176, 73)) {
						
					}
					
					if(door.position.equals(176, 80)) {
						
					}
					
					
					if(door.position.equals(182, -44)) {
						
					}
					
					if(door.position.equals(182, -32)) {
						
					}
					
					if(door.position.equals(182, -25)) {
						
					}
					
					if(door.position.equals(182, -17)) {
						
					}
					
					if(door.position.equals(183, 66)) {
						
					}
					
					if(door.position.equals(183, 73)) {
						
					}
					
					if(door.position.equals(183, 80)) {
						
					}
					
					if(door.position.equals(189, 58)) {
						
					}
					
					if(door.position.equals(191, 12)) {
						
					}
					
					if(door.position.equals(191, 66)) {
						
					}
					
					if(door.position.equals(191, 73)) {
						
					}
					
					if(door.position.equals(191, 80)) {
						
					}
					
					if(door.position.equals(193, -19)) {
						
					}
					
					if(door.position.equals(196, -35)) {
						
					}
					
					if(door.position.equals(197, -43)) {
						
					}
					
					if(door.position.equals(197, -27)) {
						
					}
					
					if(door.position.equals(201, -19)) {
						
					}
					
					if(door.position.equals(209, 29)) {
						
					}
					
					if(door.position.equals(218, -6)) {
						
					}
					
					if(door.position.equals(231, 57)) {
						
					}
					
					if(door.position.equals(283, 19)) {
						
					}
					
					if(door.position.equals(284, 32)) {
						
					}
					
					if(door.position.equals(286, 11)) {
						
					}
					
					if(door.position.equals(290, 19)) {
						
					}
					
					if(door.position.equals(292, 32)) {
						
					}
					
					if(door.position.equals(299, 10)) {
						
					}
					
					if(door.position.equals(299, 16)) {
						
					}
					
					if(door.position.equals(304, 22)) {
						
					}
					
					if(door.position.equals(305, 32)) {
						
					}
					
					if(door.position.equals(306, 10)) {
						
					}
					
					if(door.position.equals(306, 16)) {
						
					}
					
					if(door.position.equals(453, 57)) {
						
					}
					
					if(door.position.equals(455, 49)) {
						
					}
					
					if(door.position.equals(458, 65)) {
						
					}
					
					if(door.position.equals(459, -43)) {
						
					}
					
					if(door.position.equals(471, 58)) {
						
					}
					
					if(door.position.equals(553, 105)) {
						
					}
					
					if(door.position.equals(554, 105)) {
						
					}
					
				}
			}
		}
	}

}
