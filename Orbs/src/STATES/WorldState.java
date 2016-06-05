package STATES;

import java.awt.Graphics2D;

import MANAGERS.GameStateManager;
import WORLD.World;

public class WorldState extends GameState {

	
	//The world that the player was in
	World world;
	
	
	public WorldState(GameStateManager gsm) {
		super(gsm);
		
		world = new World(40,40);
	}
	
	
	/** Returns the world that is being displayed in this world state. */
	public World getWorld() { return world; }
	

	@Override
	public void initialize() {
		if(world != null)
			world.initialize();
	}

	@Override
	public void update(double time) {
		if(world != null)
			world.update(time);
	}

	@Override
	public void draw(Graphics2D g) {
		if(world != null)
			world.draw(g);
	}
	
}
