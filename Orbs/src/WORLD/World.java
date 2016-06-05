package WORLD;

import java.awt.Graphics2D;

import visualje.Vector2D;

public class World {

	//Position of the world
	public Vector2D position;
	
	//Size of the world
	int width, height;
	
	//The tiles in the world
	Tile[][] tiles;
	
	//The game map as integers
	GameMap map;
	
	
	public World(int w, int h) {
		position = new Vector2D();
		width = w;
		height = h;
		tiles = new Tile[width][height];
		map = new GameMap();
		initialize();
	}
	
	
	/** Returns the tiles that are on the screen. */
	public Tile[][] getTileMap() { return tiles; }
	
	
	public void initialize() {
		
		//Set the tiles based on the numbers in the 2D array
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				if(map.currentMap[y][x] == 0) {
					tiles[x][y] = new Tile(TileType.Grass_1, true);
				}
				if(map.currentMap[y][x] == 3) {
					tiles[x][y] = new Tile(TileType.Tree_1, true);
				}
				if(map.currentMap[y][x] == 4) {
					tiles[x][y] = new Tile(TileType.Tree_2, true);
				}
			}	
		}
		
		//Set the position of each tile
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				tiles[x][y].setPosition(new Vector2D(position.X+x, position.Y+y));
			}	
		}
	}
	
	
	public void update(double time) {
		
		if(tiles != null) {
			for(Tile[] ts : tiles) {
				for(Tile t : ts) {
					t.update(time);
				}
			}
		}
		
	}
	
	
	public void draw(Graphics2D g) {
		
		if(tiles != null) {
			for(Tile[] ts : tiles) {
				for(Tile t : ts) {
					t.draw(g);
				}
			}
		}
		
	}
	
	

} //End of "World" class.
