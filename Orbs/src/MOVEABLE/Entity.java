package MOVEABLE;

import java.awt.Graphics2D;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import WORLD.World;

public class Entity implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8854284740101223004L;

	//The position of the entity.
	public Vector2D position;
	
	//The world that the entity is in.\
	
	public World world;
	
	//This is only true for the player.
	protected boolean isPlayer;
	
	
	
	public Entity() {
		position = new Vector2D();
	}
	
	public Entity isPlayer(boolean b) { isPlayer = b; return this; }
	
	public boolean isPlayer() { return isPlayer; }

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}
