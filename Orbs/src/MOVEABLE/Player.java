package MOVEABLE;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import STATES.WorldState;

public class Player extends Entity implements IUD, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 70648151348581551L;
	
	//World state
	WorldState worldstate;
	
	//The player's name
	public String playerName = "";
	
	//The direction the player is facing
	/* 0 = down
	 * 1 = right 
	 * 2 = up 
	 * 3 = left */
	public int facing;
	
	//Stats (health, level, etc.) for the player.
	PlayerStats stats = new PlayerStats();
	
	//Interaction
	public static boolean interacting;

	
	public Player(WorldState  w) {
		worldstate = w;
		position = new Vector2D(10,7);
		this.isPlayer(true);
	}
	
	@Override
	public void initialize() {	
		facing = 0;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect((int)position.X*32, (int)position.Y*32, 32, 32);
		
		//Draw interaction box
		g.setColor(Color.black);
	}
	
	@Override
	public void update(double time) {
		
	}
	
	
	public PlayerStats getStats() { return stats; }
	
} //End of Player class.
