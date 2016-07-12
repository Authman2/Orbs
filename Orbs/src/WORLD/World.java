package WORLD;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ENTITIES.ActionEntity;
import ENTITIES.Entity;
import ENTITIES.SearchableEntity;
import ITEMS.Item;
import ITEMS.Orb;
import MAIN.Assets;
import MANAGERS.NPCManager;
import MISC.Door;
import STATES.WorldState;
import visualje.Vector2D;

public class World {

	//Position of the world
	public Vector2D position;
	
	//The name of the world. Mostly for keeping track of different worlds.
	String name;
	
	//Size of the world
	int width, height;
	
	//The tiles in the world
	Tile[][] tiles;
	
	//The game map as integers
	GameMap map;
	
	//Whether or not this world is currently open (visible to the player)
	boolean open;
	
	//The world state that holds this world
	WorldState worldState;
	
	//Booleans for movement
	public boolean up, down, left, right;
	
	//Handles all of the NPCs for this world
	NPCManager npcManager;
	
	//All of the entities in the world, excluding the player
	ArrayList<Entity> entities;
	
	//All of the items that are on the floor of the game world that the player can just pick up
	ArrayList<Item> droppedItems;
	
	//All of the trees in the game world that may or may not contain items
	ArrayList<SearchableEntity> searchables;
	
	//All of the entities that require the player to choose an action before continuing
	ArrayList<ActionEntity> actionEnts;

	//All of the doors in THIS world
	ArrayList<Door> doors;
	
	
	
	/////////// Constructor ////////////
	
	public World(String name, int w, int h, int currentMap, WorldState ws) {
		position = new Vector2D(0,0);
		this.name = name;
		width = w;
		height = h;
		tiles = new Tile[width][height];
		map = new GameMap();
		map.currentMap = map.maps[currentMap];
		entities = new ArrayList<Entity>();
		droppedItems = new ArrayList<Item>();
		searchables = new ArrayList<SearchableEntity>();
		actionEnts = new ArrayList<ActionEntity>();
		doors = new ArrayList<Door>();
		worldState = ws;
		npcManager = new NPCManager(this);
	}
	
	
	
	////////////// SETTERS ///////////////
	
	/** Adds an entity to the list in the World class, and subsequently to the game world itself. */
	public void addEntity(Entity ent) { 
		if(!entities.contains(ent))
			entities.add(ent);
	}
	
	
	/** Adds items to a bunch of the trees in the game world based on their location. */
	public void addSearchableItems(SearchableEntity se) {
		if(se.position.equals(75 + position.X, 32 + position.Y)) {
			se.setContainedItem(new Orb());
		}
		
		if(se.position.equals(90 + position.X, 13 + position.Y)) {
			se.setContainedItem(new Orb());
		}
		
		if(se.position.equals(11 + position.X, 73 + position.Y)) {
			se.setContainedItem(new Orb());
		}
		
		if(se.position.equals(86 + position.X, 90 + position.Y)) {
			se.setContainedItem(new Orb());
		}
	}
	
	
	/** Adds barrier action entities (trees and rocks) to the game world. The position that they are added to are 
	 * the coordinates "x" and "y". */
	public void addActionEntities() {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				int worldX = (int)position.X;
				int worldY = (int)position.Y;
				
				//Add an action entity at a particular coordinate point
				
				/* TREES */
				if(x == 21 && y == 80) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 22 && y == 80) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 51 && y == 54) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 52 && y == 53) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 51 && y == 53) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 52 && y == 52) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 53 && y == 52) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				
				/* ROCKS */
				if(x == 74 && y == 30) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 30) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 31) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 32) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 32) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 33) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 34) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 74 && y == 34) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
			}
		}
	}
	
	
	/** Adds door destinations. */
	public void addDoorDestinations() {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				int worldX = (int)position.X;
				int worldY = (int)position.Y;
				
				// Main World
				if(name.equals("Main")) {
					if(x == 13 && y == 9) {
						Door door = new Door(worldState, new Vector2D(x + worldX, y + worldY));
						door.setDestination(worldState.getHouseWorld_1());
						
						doors.add(door);
					}
				}
				
				// The House
				if(name.equals("House_1")) {
					if(x == 7 && y == 9) {
						Door door = new Door(worldState, new Vector2D(x + worldX, y + worldY));
						door.setDestination(worldState.getMainWorld());
						
						doors.add(door);
					}
				}
			}
		}
	}
	
	
	/** Sets whether or not this world is open. */
	public void setOpen(boolean b) { open = b; }
	
	
	/** Sets the name of the world. */
	public void setName(String n) { name = n; }
	
	
	/** Set the position of the world and all of the world entitites. */
	public void setPosition(Vector2D pos) {
		position = pos;
		
		//Initialize each entity
		for(Entity e : entities) {
			e.position.add(pos);
		}
		
		//Initialize each item
		for(Item itm : droppedItems)  {
			itm.position.add(pos);
		}
		
		//Initialize each searchable entity
		for(SearchableEntity se : searchables) {
			se.position.add(pos);
		}
		
		//Initialize each action entity
		for(ActionEntity ae : actionEnts) {
			ae.position.add(pos);
		}
		
		
	}
	
	
	
	////////////// GETTERS ///////////////
	
	/** Returns the world state that holds this world. */
	public WorldState getWorldState() { return worldState; }
	
	
	/** Returns the width of the world. */
	public int getWidth() { return width; }
	

	/** Returns the height of the world. */
	public int getHeight() { return height; }
	
	
	/** Returns the name of this world. */
	public String getName() { return name; }
	
	
	/** Returns the tiles that are on the screen. */
	public Tile[][] getTileMap() { return tiles; }
	
	
	/** Returns the NPCManager. */
	public NPCManager getNPCManager() { return npcManager; }
	
	
	/** Returns a list of all of the entities in the game world. */
	public ArrayList<Entity> getEntities() { return entities; }
	
	
	/** Returns a list of all of the items that are on the floor of the game world. */
	public ArrayList<Item> getDroppedItems() { return droppedItems; }
	
	
	/** Returns a list of all of the searchable items in the game world that may or may not have items in them. */
	public ArrayList<SearchableEntity> getSearchables() { return searchables; }
	
	
	/** Returns a list of all of the action entities in the game world. */
	public ArrayList<ActionEntity> getActionEntities() { return actionEnts; }
	
	
	/** Returns a list of all of the doors in THIS world only. */
	public ArrayList<Door> getDoors() { return doors; }
	
	
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
		
		for(ActionEntity ae : actionEnts) {
			if(ae.position.X == worldState.getPlayer().position.X && ae.position.Y == worldState.getPlayer().position.Y - 1) {
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
		
		for(ActionEntity ae : actionEnts) {
			if(ae.position.X == worldState.getPlayer().position.X && ae.position.Y == worldState.getPlayer().position.Y + 1) {
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

		for(ActionEntity ae : actionEnts) {
			if(ae.position.X == worldState.getPlayer().position.X + 1 && ae.position.Y == worldState.getPlayer().position.Y) {
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
		
		for(ActionEntity ae : actionEnts) {
			if(ae.position.X == worldState.getPlayer().position.X - 1 && ae.position.Y == worldState.getPlayer().position.Y) {
				canMoveLeft = false;
			}
		}
		
		return canMoveLeft;
	}
		
	
	/** Whether or not this world is open. */
	public boolean isOpen() { return open; }
	
	
	
	////////////// Abstract Methods ///////////////
	
	public void initialize() {
		entities.clear();
		droppedItems.clear();
		searchables.clear();
		actionEnts.clear();
		doors.clear();
		
		//Add the action entities to the game
		addActionEntities();
		
		//Add all of the door destinations
		addDoorDestinations();
		
		
		//Set the tiles based on the numbers in the game map
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				if(map.currentMap[y][x] == 0) {
					tiles[x][y] = new Tile(TileType.Grass_1, false);
				}
				if(map.currentMap[y][x] == 3) {
					tiles[x][y] = new Tile(TileType.Tree_1, true);
					SearchableEntity se = new SearchableEntity(new Vector2D(x + position.X, y + position.Y));
					se.setName("tree");
					searchables.add(se);
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
				}
				if(map.currentMap[y][x] == 33) {
					tiles[x][y] = new Tile(TileType.Wood_Floor, false);
				}
				if(map.currentMap[y][x] == 34) {
					tiles[x][y] = new Tile(TileType.Rug_Left, false);
				}
				if(map.currentMap[y][x] == 35) {
					tiles[x][y] = new Tile(TileType.Rug_Right, false);
				}
				if(map.currentMap[y][x] == 48) {
					tiles[x][y] = new Tile(TileType.BLACK_SPACE, true);
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
		
		//Initialize each searchable entity
		for(SearchableEntity se : searchables) {
			addSearchableItems(se);
			se.initialize();
		}
		
		//Initialize each action entity
		for(ActionEntity ae : actionEnts) {
			ae.initialize();
		}
		
		//Initialize the npc manager
		npcManager.createNPCs();
		npcManager.initialize();
		npcManager.addToGame();
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
			
			//Update each item
			for(SearchableEntity tree : searchables) {
				tree.update(time);
			}
			
			//Update each action entity
			for(ActionEntity ae : actionEnts) {
				ae.update(time);
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
			
			//Draw each item
			for(SearchableEntity tree : searchables) {
				if(tree.getTextBox().isOpen()) {
					tree.draw(g);
				}
			}
			
			//Draw each action entity
			for(ActionEntity ae : actionEnts) {
				ae.draw(g);
			}
		}
		
	}
	
	

} //End of class.
