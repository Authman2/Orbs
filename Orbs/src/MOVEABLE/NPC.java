package MOVEABLE;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MAIN.Assets;
import MISC.TextBox;
import WORLD.World;

public class NPC extends Entity implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1009753565072502368L;
	
	//The world the NPC is in.
	World world;
	
	//Name of the NPC
	String npcName;
	
	//The text box, which will display this NPC's text.
	public TextBox textBox = new TextBox(this);;

	
	public NPC(String name, World w) { npcName = name; world = w; }
	
	public String Name() { return npcName; }
	public World inWorld() { return world; }
	public void setPosition(Vector2D pos) { position = pos ; }
	
	/** Determines if the player is above, below, or next to this NPC. */
	public boolean isNextToPlayer() {
		if(!isPlayer) {
			 if(isAbove() || isBelow() || isRight() || isLeft()) {
				 return true;
			 }
		}
		return false;
	}
	
	/** Determines if the player is above this NPC. */
	public boolean isAbove() {
		if(position.X == world.worldstate.gsm.input.player.position.X && position.Y == world.worldstate.gsm.input.player.position.Y + 1) {
			return true;
		}
		return false;
	}
	/** Determines if the player is below this NPC. */
	public boolean isBelow() {
		if(position.X == world.worldstate.gsm.input.player.position.X && position.Y == world.worldstate.gsm.input.player.position.Y - 1) {
			return true;
		}
		return false;
	}
	/** Determines if the player is to the right of this NPC. */
	public boolean isRight() {
		if(position.X == world.worldstate.gsm.input.player.position.X - 1 && position.Y == world.worldstate.gsm.input.player.position.Y) {
			return true;
		}
		return false;
	}
	/** Determines if the player is to the left of this NPC. */
	public boolean isLeft() {
		if(position.X == world.worldstate.gsm.input.player.position.X + 1 && position.Y == world.worldstate.gsm.input.player.position.Y) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public void initialize() {
	}

	@Override
	public void update(double time) {
		
		if(world.worldstate.gsm.input.player != null) {
			if(world.worldstate.gsm.input.player.interacting == true) {
				if(isNextToPlayer()) {
					textBox.update(time);
				}
			}
		}
	}

	@Override
	public void draw(Graphics2D g) {
		AffineTransform t = new AffineTransform();
		t.translate(position.X*32, position.Y*32);
		t.scale(1, 1);
		
		//Change this image later.
		g.drawImage(Assets.boat, t, null);
		
		if(world.worldstate.gsm.input.player != null) { 
			if(world.worldstate.gsm.input.player.interacting == true) {
				if(isNextToPlayer()) {
					textBox.draw(g);
				}
			}
		}
	}
}
