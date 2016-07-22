package WORLD;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ENTITIES.ActionEntity;
import ENTITIES.Entity;
import ENTITIES.NPC;
import ENTITIES.SearchableEntity;
import ITEMS.Coin;
import ITEMS.Item;
import ITEMS.Orb;
import MAIN.Assets;
import MANAGERS.ItemManager;
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
	
	//Handles all of the items for this world
	ItemManager itemManager;
	
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
		itemManager = new ItemManager(this);
	}
	
	
	
	////////////// SETTERS ///////////////
	
	/** Adds an entity to the list in the World class, and subsequently to the game world itself. */
	public void addEntity(Entity ent) { 
		if(!entities.contains(ent))
			entities.add(ent);
	}
	
	
	/** Adds items to a bunch of the trees in the game world based on their location. */
	public void addSearchableItems() {
		if(name.equals("Main")) {
			
			for(SearchableEntity se : searchables) {
				if(se.position.equals(75 + position.X, 32 + position.Y)) {
					Orb orb = new Orb();
					orb.setID("searchOrb_1");
					se.setContainedItem(orb);
				}
				if(se.position.equals(90 + position.X, 13 + position.Y)) {
					Orb orb = new Orb();
					orb.setID("searchOrb_2");
					se.setContainedItem(orb);
				}
				if(se.position.equals(11 + position.X, 73 + position.Y)) {
					Orb orb = new Orb();
					orb.setID("searchOrb_3");
					se.setContainedItem(orb);
				}
				if(se.position.equals(86 + position.X, 90 + position.Y)) {
					Orb orb = new Orb();
					orb.setID("searchOrb_4");
					se.setContainedItem(orb);
				}
				if(se.position.equals(83 + position.X, 91 + position.Y)) {
					Coin coin = new Coin(12);
					coin.setID("searchCoin_1");
					se.setContainedItem(coin);
				}
				if(se.position.equals(47 + position.X, 20 + position.Y)) {
					Coin coin = new Coin(26);
					coin.setID("searchCoin_2");
					se.setContainedItem(coin);
				}
				if(se.position.equals(46 + position.X, 46 + position.Y)) {
					Coin coin = new Coin(14);
					coin.setID("searchCoin_3");
					se.setContainedItem(coin);
				}
			}
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
					ae.setDefaultSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 22 && y == 80) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 51 && y == 54) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 52 && y == 53) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 51 && y == 53) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 52 && y == 52) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 53 && y == 52) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				
				/* ROCKS */
				if(x == 74 && y == 30) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 30) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 31) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 32) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 32) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 33) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 34) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 74 && y == 34) {
					ActionEntity ae = new ActionEntity(new Vector2D(x + worldX,y + worldY));
					ae.setDefaultSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
			}
		}
	}
	
	
	/** Adds door destinations. */
	public void addDoorDestinations() {
		if(name.equals("Main")) {
			/* TOWN 1 */
			Door d1 = new Door(1, worldState, new Vector2D(13, 9).add(position));
			Door d2 = new Door(1, worldState, new Vector2D(33, 74).add(position));
			Door d3 = new Door(1, worldState, new Vector2D(13, 23).add(position));
			Door d4 = new Door(1, worldState, new Vector2D(18, 56).add(position));
			Door d5 = new Door(1, worldState, new Vector2D(15, 62).add(position));
			Door d6 = new Door(1, worldState, new Vector2D(11, 68).add(position));
			Door d7 = new Door(1, worldState, new Vector2D(19, 74).add(position));
			Door d8 = new Door(1, worldState, new Vector2D(25, 65).add(position));
			
			/* TOWN 2 */
			Door d9 = new Door(1, worldState, new Vector2D(35,67).add(position));
			Door d10 = new Door(1, worldState, new Vector2D(59,85).add(position));
			Door d11 = new Door(1, worldState, new Vector2D(77,87).add(position));
			Door d12 = new Door(1, worldState, new Vector2D(88,83).add(position));
			Door d13 = new Door(1, worldState, new Vector2D(81,81).add(position));
			Door d14 = new Door(1, worldState, new Vector2D(76,76).add(position));
			Door d15 = new Door(1, worldState, new Vector2D(84,74).add(position));
			
			/* TOWN 3 */
			Door d16 = new Door(1, worldState, new Vector2D(80,56).add(position));
			Door d17 = new Door(1, worldState, new Vector2D(87,53).add(position));
			Door d18 = new Door(1, worldState, new Vector2D(84,48).add(position));
			Door d19 = new Door(1, worldState, new Vector2D(76,49).add(position));
			
			/* TOWN 4 */
			Door d20 = new Door(1, worldState, new Vector2D(51,20).add(position));
			Door d21 = new Door(1, worldState, new Vector2D(61,21).add(position));
			Door d22 = new Door(1, worldState, new Vector2D(58,14).add(position));
			Door d23 = new Door(1, worldState, new Vector2D(49,15).add(position));
			Door d24 = new Door(1, worldState, new Vector2D(54,10).add(position));
			Door d25 = new Door(1, worldState, new Vector2D(64,11).add(position));
			
			/* TOWN 5 */
			Door d26 = new Door(1, worldState, new Vector2D(84,16).add(position));
			Door d27 = new Door(1, worldState, new Vector2D(88,20).add(position));
			Door d28 = new Door(1, worldState, new Vector2D(86,26).add(position));
			
			//Add to the list of doors
			doors.add(d1);
			doors.add(d2);
			doors.add(d3);
			doors.add(d4);
			doors.add(d5);
			doors.add(d6);
			doors.add(d7);
			doors.add(d8);
			doors.add(d9);
			doors.add(d10);
			doors.add(d11);
			doors.add(d12);
			doors.add(d13);
			doors.add(d14);
			doors.add(d15);
			doors.add(d16);
			doors.add(d17);
			doors.add(d18);
			doors.add(d19);
			doors.add(d20);
			doors.add(d21);
			doors.add(d22);
			doors.add(d23);
			doors.add(d24);
			doors.add(d25);
			doors.add(d26);
			doors.add(d27);
			doors.add(d28);
			
			//Set the destinations
			for(int i = 0; i < 28; i++) {
				doors.get(i).setDestination(worldState.getHouse(i));
			}
			
		} else {
			Door d1 = new Door(-1, worldState, new Vector2D(7 + position.X, 9 + position.Y));
			Door d2 = new Door(-1, worldState, new Vector2D(6 + position.X, 9 + position.Y));
			d1.setDestination(worldState.getMainWorld());
			d2.setDestination(worldState.getMainWorld());
			
			doors.add(d1);
			doors.add(d2);
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
	
	
	/** Handles the creation of NPCs and Items. */
	public void createNPCsAndItems() {
		//Initialize the item manager
		itemManager.createItems();
		itemManager.addToGame();
		
		//Initialize all of the searchable entities
		addSearchableItems();
		
		//Initialize the npc manager
		npcManager.createNPCs();
		npcManager.giveItems();
		try { npcManager.loadNPCText(); }catch(Exception err) { err.printStackTrace(); }
		npcManager.addToGame();
	}
	
	
	/** Calls the draw method on each game element's text box if it is open. Can be called from the world state to make sure
	 * that all text boxes are drawn on top of everything in the game. */
	public void drawTextBoxes(Graphics2D g) {
		for(Entity e : getEntities()) {
			if(e instanceof NPC)
				if(((NPC) e).getTextBox().isOpen())
					((NPC) e).getTextBox().draw(g);
		}
		for(Item e : getDroppedItems()) {
			if(e.getTextBox().isOpen())
				e.getTextBox().draw(g);
		}
		for(SearchableEntity e : getSearchables()) {
			if(e.getTextBox().isOpen())
				e.getTextBox().draw(g);
		}
		for(ActionEntity e : getActionEntities()) {
			if(e.getTextBox().isOpen())
				e.getTextBox().draw(g);
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
	
	
	/** Returns the ItemManager. */
	public ItemManager getItemManager() { return itemManager; }
	
	
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
					se.setContainedItem(null);
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
			se.initialize();
		}
		
		//Initialize each action entity
		for(ActionEntity ae : actionEnts) {
			ae.initialize();
		}
		
//		//Initialize the npc manager
//		npcManager.createNPCs();
//		npcManager.initialize();
//		npcManager.addToGame();
//		
//		//Initialize the item manager
//		itemManager.initialize();
//		itemManager.addToGame();
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
					if(t.position.X >= 0 && t.position.X <= 15) {
						if(t.position.Y >= 0 && t.position.Y <= 11) {
							t.draw(g);
						}
					}
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
