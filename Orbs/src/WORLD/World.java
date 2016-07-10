package WORLD;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ENTITIES.ActionEntity;
import ENTITIES.Entity;
import ENTITIES.SearchableEntity;
import ITEMS.Item;
import MAIN.Assets;
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
	ArrayList<SearchableEntity> searchables;
	
	//All of the entities that require the player to choose an action before continuing
	ArrayList<ActionEntity> actionEnts;
	
	
	
	/////////// Constructor ////////////
	
	public World(int w, int h, WorldState ws) {
		position = new Vector2D(0,0);
		width = w;
		height = h;
		tiles = new Tile[width][height];
		map = new GameMap();
		entities = new ArrayList<Entity>();
		droppedItems = new ArrayList<Item>();
		searchables = new ArrayList<SearchableEntity>();
		actionEnts = new ArrayList<ActionEntity>();
		worldState = ws;
		initialize();
	}
	
	
	
	////////////// SETTERS ///////////////
	
	/** Adds an entity to the list in the World class, and subsequently to the game world itself. */
	public void addEntity(Entity ent) { 
		if(!entities.contains(ent))
			entities.add(ent);
	}
	
	
	/** Adds items to a bunch of the trees in the game world based on their location. */
	public void addSearchableItems(SearchableEntity se) {
		
	}
	
	
	/** Adds barrier action entities (trees and rocks) to the game world. The position that they are added to are 
	 * the coordinates "x" and "y". */
	public void addActionEntities() {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				//Add an action entity at a particular coordinate point
				
				/* TREES */
				if(x == 21 && y == 80) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 22 && y == 80) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 51 && y == 54) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 52 && y == 53) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 51 && y == 53) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 52 && y == 52) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				if(x == 53 && y == 52) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.tree_3);
					ae.setName("tree_3");
					ae.setActionQuestion("This tree could be cut down using a hatchet. Would you like to cut    down the tree?");
					actionEnts.add(ae);
				}
				
				
				/* ROCKS */
				if(x == 74 && y == 30) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 30) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 31) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 32) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 32) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 33) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 73 && y == 34) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
				
				if(x == 74 && y == 34) {
					ActionEntity ae = new ActionEntity(new Vector2D(x,y));
					ae.setSprite(Assets.rock);
					ae.setName("rock");
					ae.setActionQuestion("This rock can be broken using a pickaxe. Would you like to break the  rock?");
					actionEnts.add(ae);
				}
			}
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
	
	
	/** Returns a list of all of the searchable items in the game world that may or may not have items in them. */
	public ArrayList<SearchableEntity> getSearchables() { return searchables; }
	
	
	/** Returns a list of all of the action entities in the game world. */
	public ArrayList<ActionEntity> getActionEntities() { return actionEnts; }
	
	
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
		
	
	
	////////////// Abstract Methods ///////////////
	
	public void initialize() {
		//Add the action entities to the game
		addActionEntities();
		
		
		//Set the tiles based on the numbers in the game map
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				if(map.currentMap[y][x] == 0) {
					tiles[x][y] = new Tile(TileType.Grass_1, false);
				}
				if(map.currentMap[y][x] == 3) {
					tiles[x][y] = new Tile(TileType.Tree_1, true);
					SearchableEntity se = new SearchableEntity(new Vector2D(x, y));
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
		
		//Initialize each searchable entity
		for(SearchableEntity se : searchables) {
			addSearchableItems(se);
			se.initialize();
			System.out.println(se.position.toString());
		}
		
		//Initialize each action entity
		for(ActionEntity ae : actionEnts) {
			ae.initialize();
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
			for(SearchableEntity tree : searchables) {
				tree.update(time);
			}
			
			//Initialize each action entity
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
			
			//Initialize each item
			for(SearchableEntity tree : searchables) {
				if(tree.getTextBox().isOpen()) {
					tree.draw(g);
				}
			}
			
			//Initialize each action entity
			for(ActionEntity ae : actionEnts) {
				ae.draw(g);
			}
		}
		
	}
	
	

} //End of class.
