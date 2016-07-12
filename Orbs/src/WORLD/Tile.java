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
		if(type == TileType.House_TopLeft) {
			g.drawImage(Assets.house_topLeft, t, null);
		}
		if(type == TileType.House_TopMiddle) {
			g.drawImage(Assets.house_topMiddle, t, null);
		}
		if(type == TileType.House_TopRight) {
			g.drawImage(Assets.house_topRight, t, null);
		}
		if(type == TileType.House_BottomLeft) {
			g.drawImage(Assets.house_bottomLeft, t, null);
		}
		if(type == TileType.House_BottomMiddle) {
			g.drawImage(Assets.house_bottomMiddle, t, null);
		}
		if(type == TileType.House_BottomRight) {
			g.drawImage(Assets.house_bottomRight, t, null);
		}
		if(type == TileType.House_Door) {
			g.drawImage(Assets.house_door, t, null);
		}
		if(type == TileType.Wood_Floor) {
			g.drawImage(Assets.wood_floor, t, null);
		}
		if(type == TileType.Rug_Left) {
			g.drawImage(Assets.rug_left, t, null);
		}
		if(type == TileType.Rug_Right) {
			g.drawImage(Assets.rug_right, t, null);
		}
		if(type == TileType.BLACK_SPACE) {
			g.drawImage(Assets.black_space, t, null);
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
