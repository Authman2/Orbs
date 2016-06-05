package WORLD;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import MAIN.Assets;
import visualje.Vector2D;

public class Tile {
	
	//The position of the tile
	public Vector2D position;

	//Size of the tile
	int size = 32;
	
	//Solid or not?
	boolean solid;
	
	//The type of tile this is
	TileType type;
	
	
	public Tile(TileType t, boolean isSolid) {
		type = t;
		solid = isSolid;
	}
	
	
	public void initialize() {
		
	}
	
	public void update(double time) {
		
	}
	
	public void draw(Graphics2D g) {
		AffineTransform t = new AffineTransform();
		t.translate(position.X*32, position.Y*32);
		t.scale(1, 1);
		
		
		if(type == TileType.Grass_1) {
			g.drawImage(Assets.grass_1, t, null);
		}
		if(type == TileType.Tree_1) {
			g.drawImage(Assets.tree_1, t, null);
		}
		if(type == TileType.Tree_2) {
			g.drawImage(Assets.tree_2, t, null);
		}
	}
	
	
	//////////// Getters ////////////
	
	public boolean isSolid() { return solid; }
	
	
	//////////// Setters ////////////
	
	public Tile setPosition(Vector2D pos) {
		position = new Vector2D(pos.X, pos.Y);
		return this;
	}
	
	
}
