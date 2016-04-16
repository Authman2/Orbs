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
							world.initialize();
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
					
					if(door.position.equals (10.0f,6.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (10.0f,14.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (18.0f,6.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (24.0f,20.0f)) { ((Door) door).setGoTo(worlds[3]); }
					if(door.position.equals (26.0f,6.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (44.0f,10.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (62.0f,7.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (62.0f,14.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (70.0f,81.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (71.0f,3.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (73.0f,15.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (77.0f,81.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (79.0f,73.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (85.0f,81.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (89.0f,73.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (90.0f,73.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (92.0f,81.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (170.0f,107.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (174.0f,-44.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (174.0f,-32.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (174.0f,-25.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (174.0f,-17.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (176.0f,66.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (176.0f,73.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (176.0f,80.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (182.0f,-44.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (182.0f,-32.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (182.0f,-25.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (182.0f,-17.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (183.0f,66.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (183.0f,73.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (183.0f,80.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (183.0f,116.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (189.0f,58.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (191.0f,12.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (191.0f,66.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (191.0f,73.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (191.0f,80.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (193.0f,-19.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (196.0f,-35.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (197.0f,-43.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (197.0f,-27.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (200.0f,108.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (201.0f,-19.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (209.0f,29.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (214.0f,115.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (218.0f,-6.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (231.0f,57.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (283.0f,19.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (284.0f,32.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (286.0f,11.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (290.0f,19.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (292.0f,32.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (299.0f,10.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (299.0f,16.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (304.0f,22.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (305.0f,32.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (306.0f,10.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (306.0f,16.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (453.0f,57.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (455.0f,49.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (458.0f,65.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (459.0f,-43.0f)) { ((Door) door).setGoTo(worlds[1]); }
					if(door.position.equals (471.0f,58.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (553.0f,105.0f)) { ((Door) door).setGoTo(worlds[2]); }
					if(door.position.equals (554.0f,105.0f)) { ((Door) door).setGoTo(worlds[1]); }

					
				}
			}
		}
	}

}
