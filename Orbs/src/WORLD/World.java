package WORLD;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ENTITIES.Entity;
import ENTITIES.Tree;
import MISC.Item;
import MISC.Orb;
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
	
	//All of the items that are on the floor of the game world that the player can just pick up
	ArrayList<Item> droppedItems;
	
	//All of the trees in the game world that may or may not contain items
	ArrayList<Tree> trees;
	
	
	public World(int w, int h, WorldState ws) {
		position = new Vector2D();
		width = w;
		height = h;
		tiles = new Tile[width][height];
		map = new GameMap();
		entities = new ArrayList<Entity>();
		droppedItems = new ArrayList<Item>();
		trees = new ArrayList<Tree>();
		worldState = ws;
		initialize();
	}
	
	
	////////////// SETTERS ///////////////
	
	/** Adds an entity to the list in the World class, and subsequently to the game world itself. */
	public void addEntity(Entity ent) { entities.add(ent); }
	
	
	/** Adds items to a bunch of the trees in the game world based on their location. */
	public void addTreeItems(Tree tree) {
		if(tree.position.X == 7 && tree.position.Y == 5) {
			tree.setContainedItem(new Orb());
		}
		
		if(tree.position.X == 8 && tree.position.Y == 18) {
			tree.setContainedItem(new Orb());
		}
		
		if(tree.position.X == 13 && tree.position.Y == 10) {
			tree.setContainedItem(new Orb());
		}
	}
	
	
	////////////// GETTERS ///////////////
	
	/** Returns the world state that holds this world. */
	public WorldState getWorldState() { return worldState; }
	
	
	/** Returns the tiles that are on the screen. */
	public Tile[][] getTileMap() { return tiles; }
	
	
	/** Returns a list of all of the entities in the game world. */
	public ArrayList<Entity> getEntities() { return entities; }
	
	
	/** Returns a list of all of the items that are on the floor of the game world. */
	public ArrayList<Item> getDroppedItems() { return droppedItems; }
	
	
	/** Returns a list of all of the trees in the game world that may or may not have items in them. */
	public ArrayList<Tree> getTrees() { return trees; }
	
	
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
		
		for(Entity ent : entities) {
			if(ent.position.X == worldState.getPlayer().position.X && ent.position.Y == worldState.getPlayer().position.Y - 1) {
				canMoveUp = false;
			}
		}
		
		for(Item itm : droppedItems) {
			if(itm.position.X == worldState.getPlayer().position.X && itm.position.Y == worldState.getPlayer().position.Y - 1) {
				canMoveUp = false;
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
		
		for(Entity ent : entities) {
			if(ent.position.X == worldState.getPlayer().position.X && ent.position.Y == worldState.getPlayer().position.Y + 1) {
				canMoveDown = false;
			}
		}
		
		for(Item itm : droppedItems) {
			if(itm.position.X == worldState.getPlayer().position.X && itm.position.Y == worldState.getPlayer().position.Y + 1) {
				canMoveDown = false;
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
		
		for(Entity ent : entities) {
			if(ent.position.X == worldState.getPlayer().position.X + 1 && ent.position.Y == worldState.getPlayer().position.Y) {
				canMoveRight = false;
			}
		}
		
		for(Item itm : droppedItems) {
			if(itm.position.X == worldState.getPlayer().position.X + 1 && itm.position.Y == worldState.getPlayer().position.Y) {
				canMoveRight = false;
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
		
		for(Entity ent : entities) {
			if(ent.position.X == worldState.getPlayer().position.X - 1 && ent.position.Y == worldState.getPlayer().position.Y) {
				canMoveLeft = false;
			}
		}
		
		for(Item itm : droppedItems) {
			if(itm.position.X == worldState.getPlayer().position.X - 1 && itm.position.Y == worldState.getPlayer().position.Y) {
				canMoveLeft = false;
			}
		}
		
		return canMoveLeft;
	}
		
	
	
	////////////// Abstract Methods ///////////////
	
	public void initialize() {
		
		//Set the tiles based on the numbers in the game map
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				if(map.currentMap[y][x] == 0) {
					tiles[x][y] = new Tile(TileType.Grass_1, false);
				}
				if(map.currentMap[y][x] == 3) {
					tiles[x][y] = new Tile(TileType.Tree_1, true);
					trees.add(new Tree(new Vector2D(x, y)));
				}
				if(map.currentMap[y][x] == 4) {
					tiles[x][y] = new Tile(TileType.Tree_2, true);
				}
				if(map.currentMap[y][x] == 5) {
					tiles[x][y] = new Tile(TileType.House_TopLeft, true);
				}
				if(map.currentMap[y][x] == 6) {
					tiles[x][y] = new Tile(TileType.House_TopMiddle, true);
				}
				if(map.currentMap[y][x] == 7) {
					tiles[x][y] = new Tile(TileType.House_TopRight, true);
				}
				if(map.currentMap[y][x] == 20) {
					tiles[x][y] = new Tile(TileType.House_BottomLeft, true);
				}
				if(map.currentMap[y][x] == 21) {
					tiles[x][y] = new Tile(TileType.House_BottomMiddle, true);
				}
				if(map.currentMap[y][x] == 22) {
					tiles[x][y] = new Tile(TileType.House_BottomRight, true);
				}
				if(map.currentMap[y][x] == 36) {
					tiles[x][y] = new Tile(TileType.House_Door, false);
					//Add door object so that the player can go to a different location.
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
		
		//Initialize each item
		for(Item itm : droppedItems) 
			itm.initialize();
		
		//Initialize each item
		for(Tree tree : trees) {
			addTreeItems(tree);
			tree.initialize();
			System.out.println(tree.position.toString());
		}
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
			
			//Update each item
			for(Item itm : droppedItems) 
				itm.update(time);
			
			//Initialize each item
			for(Tree tree : trees) {
				tree.update(time);
			}
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
			
			//Draw each item
			for(Item itm : droppedItems) 
				itm.draw(g);
			
			//Draw all of the entities
			for(Entity e : entities) 
				e.draw(g);
			
			//Initialize each item
			for(Tree tree : trees) {
				if(tree.getTextBox().isOpen()) {
					tree.draw(g);
				}
			}
		}
		
	}
	
	

} //End of class.
