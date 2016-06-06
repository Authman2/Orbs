package WORLD;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ENTITIES.Entity;
import STATES.WorldState;
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
	
	//The world state that holds this world
	WorldState worldState;
	
	//Booleans for movement
	public boolean up, down, left, right;
	
	//All of the entities in the world, excluding the player
	ArrayList<Entity> entities;
	
	
	
	
	public World(int w, int h, WorldState ws) {
		position = new Vector2D();
		width = w;
		height = h;
		tiles = new Tile[width][height];
		map = new GameMap();
		entities = new ArrayList<Entity>();
		worldState = ws;
		initialize();
	}
	
	
	////////////// SETTERS ///////////////
	
	/** Adds an entity to the list in the World class, and subsequently to the game world itself. */
	public void addEntity(Entity ent) { entities.add(ent); }
	
	
	
	////////////// GETTERS ///////////////
	
	/** Returns the world state that holds this world. */
	public WorldState getWorldState() { return worldState; }
	
	
	/** Returns the tiles that are on the screen. */
	public Tile[][] getTileMap() { return tiles; }
	
	
	/** Returns a list of all of the entities in the game world. */
	public ArrayList<Entity> getEntities() { return entities; }
	
	
	/** Finds out if the next tile above the one the player is currently on is solid or not. */
	public boolean canMoveUp() {
		boolean canMoveUp = true;
		
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				if(tiles[x][y].position.X == worldState.getPlayer().position.X
						&& tiles[x][y].position.Y == worldState.getPlayer().position.Y - 1) {
					
					if(tiles[x][y].isSolid()) {
						canMoveUp = false;
					} else {
						canMoveUp = true;
					}
					
				}
			}	
		}
		return canMoveUp;
	}
	
	
	/** Finds out if the next tile below the one the player is currently on is solid or not. */
	public boolean canMoveDown() {
		boolean canMoveDown = true;
		
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				if(tiles[x][y].position.X == worldState.getPlayer().position.X
						&& tiles[x][y].position.Y == worldState.getPlayer().position.Y + 1) {
					
					if(tiles[x][y].isSolid()) {
						canMoveDown = false;
					} else {
						canMoveDown = true;
					}
					
				}
			}	
		}
		return canMoveDown;
	}
	
	
	/** Finds out if the next tile to the right of the one the player is currently on is solid or not. */
	public boolean canMoveRight() {
		boolean canMoveRight = true;
		
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				if(tiles[x][y].position.X == worldState.getPlayer().position.X + 1
						&& tiles[x][y].position.Y == worldState.getPlayer().position.Y) {
					
					if(tiles[x][y].isSolid()) {
						canMoveRight = false;
					} else {
						canMoveRight = true;
					}
					
				}
			}	
		}
		
		return canMoveRight;
	}
	
	
	/** Finds out if the next tile to the left of the one the player is currently on is solid or not. */
	public boolean canMoveLeft() {
		boolean canMoveLeft = true;
		
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				if(tiles[x][y].position.X == worldState.getPlayer().position.X - 1
						&& tiles[x][y].position.Y == worldState.getPlayer().position.Y) {
					
					if(tiles[x][y].isSolid()) {
						canMoveLeft = false;
					} else {
						canMoveLeft = true;
					}
					
				}
			}	
		}
		
		return canMoveLeft;
	}
		
	
	
	////////////// Initialize, Update, Draw ///////////////
	
	public void initialize() {
		
		//Set the tiles based on the numbers in the game map
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				if(map.currentMap[y][x] == 0) {
					tiles[x][y] = new Tile(TileType.Grass_1, false);
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
		
		//Initialize each entity
		for(Entity e : entities) 
			e.initialize();
	}
	
	
	public void update(double time) {
		
		if(tiles != null) {
			
			//Update and set the position of each tile
			for(int x = 0; x < tiles.length; x++) {
				for(int y = 0; y < tiles[0].length; y++) {
					tiles[x][y].update(time);
					tiles[x][y].setPosition(new Vector2D(position.X+x, position.Y+y));
				}	
			}
			
			//Update all of the entities
			for(Entity e : entities) 
				e.update(time);
		}
		
	}
	
	
	public void draw(Graphics2D g) {
		
		if(tiles != null) {
			//Draw all of the tiles
			for(Tile[] ts : tiles) {
				for(Tile t : ts) {
					t.draw(g);
				}
			}
			
			//Draw all of the entities
			for(Entity e : entities) 
				e.draw(g);
		}
		
	}
	
	

} //End of class.
