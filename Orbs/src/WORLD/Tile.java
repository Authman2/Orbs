package WORLD;

import java.awt.Color;
import java.awt.Graphics2D;

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
		if(type == TileType.Grass_1) {
			g.drawImage(Assets.grass_1, (int)position.X*size, (int)position.Y*size, size, size, null);
		}
		if(type == TileType.Tree_1) {
			g.drawImage(Assets.tree_1, (int)position.X*size, (int)position.Y*size, size, size, null);
			g.setColor(Color.red);
			g.drawRect((int)position.X*size, (int)position.Y*size, size, size);
		}
		if(type == TileType.Tree_2) {
			g.drawImage(Assets.tree_2, (int)position.X*size, (int)position.Y*size, size, size, null);
			g.setColor(Color.red);
			g.drawRect((int)position.X*size, (int)position.Y*size, size, size);
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
