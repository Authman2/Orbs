package STATES;

import java.awt.Graphics2D;

import ENTITIES.Player;
import MANAGERS.GameStateManager;
import WORLD.World;

public class WorldState extends GameState {

	
	//The world that the player is in
	World world;
	
	//The player
	Player player;
	
	
	public WorldState(GameStateManager gsm) {
		super(gsm);
		
		world = new World(40,40, this);
		player = new Player();
	}
	
	
	/** Returns the world that is being displayed in this world state. */
	public World getWorld() { return world; }
	
	/** Returns the player. */
	public Player getPlayer() { return player; }
	

	@Override
	public void initialize() {
		if(world != null)
			world.initialize();
			player.initialize();
	}

	@Override
	public void update(double time) {
		if(world != null)
			world.update(time);
			player.update(time);
	}

	@Override
	public void draw(Graphics2D g) {
		if(world != null)
			world.draw(g);
			player.draw(g);
	}
	
}
