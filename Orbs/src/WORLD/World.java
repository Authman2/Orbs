package WORLD;

import java.awt.Graphics2D;
import java.util.ArrayList;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MANAGERS.NPCManager;
import MOVEABLE.Entity;
import MOVEABLE.NPC;
import MOVEABLE.Player;
import STATES.WorldState;

public class World implements IUD  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7832765625558276286L;
	
	//The position of the world. (0,0) means it starts in the top left corner.
	public Vector2D position;
	
	//The world state
	public WorldState worldstate;
	
	//Handles all of the NPCs
	public NPCManager npcManager;
	
	//All the entities in the world.
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	//The 2D Map Array
	public MapMatrix map;
	
	//The tile set
	public Tile[][] tiles;
	
	//The dimensions of the world
	public int Width, Height;
	
	//Moving the Map
	public boolean up, down, left, right, moving, canMoveUp, canMoveDown, canMoveLeft, canMoveRight;
	
	//Boolean for whether or not the player has moved at least one space in this world
	public boolean hasMoved;
	
	//Distance to move in each direction.
	public float dist = 1;
	final float MOVE_STEP = 0.05f;
	
	
	
	
	//CONSTRUCTORS
	public World(int w, int h, int mapnum, WorldState ws) {
		position = new Vector2D(0,0);
		Width = w;
		Height = h;
		tiles = new Tile[Width][Height];
		map = new MapMatrix(mapnum);
		npcManager = new NPCManager(this);
		worldstate = ws;
		initialize();
	}
	
	
	
	@SuppressWarnings("static-access")
	@Override
	public void initialize() {
		//Initializes the different types of tiles.
		if(map.currentMap != null)
			for(int x = 0; x < Width; x++) {
				for(int y = 0; y < Height; y++) {
					
					if(map.currentMap[y][x] == 0) {
						tiles[x][y] = new Tile(TileType.Grass_1, false, this);
					}
					if(map.currentMap[y][x] == 1) {
						tiles[x][y] = new Tile(TileType.Grass_2, false, this);
					}
					if(map.currentMap[y][x] == 2) {
						tiles[x][y] = new Tile(TileType.Cave_Entry, false, this);
					}
					if(map.currentMap[y][x] == 3) {
						tiles[x][y] = new Tile(TileType.Rock_On_Grass, true, this);
					}
					if(map.currentMap[y][x] == 4) {
						tiles[x][y] = new Tile(TileType.Flower, false, this);
					}
					if(map.currentMap[y][x] == 5) {
						tiles[x][y] = new Tile(TileType.Bush, true, this);
					}
					if(map.currentMap[y][x] == 6) {
						tiles[x][y] = new Tile(TileType.Sand, false, this);
					}
					if(map.currentMap[y][x] == 7) {
						tiles[x][y] = new Tile(TileType.Water_TopLeft, true, this);
					}
					if(map.currentMap[y][x] == 8) {
						tiles[x][y] = new Tile(TileType.Water_Top, true, this);
					}
					if(map.currentMap[y][x] == 9) {
						tiles[x][y] = new Tile(TileType.Water_TopRight, true, this);
					}
					if(map.currentMap[y][x] == 10) {
						tiles[x][y] = new Tile(TileType.Red_Brick, true, this);
					}
					if(map.currentMap[y][x] == 11) {
						tiles[x][y] = new Tile(TileType.Gray_Brick, true, this);
					}
					if(map.currentMap[y][x] == 12) {
						tiles[x][y] = new Tile(TileType.Cave_Floor, false, this);
					}
					if(map.currentMap[y][x] == 13) {
						tiles[x][y] = new Tile(TileType.Tree_Top, true, this);
					}
					if(map.currentMap[y][x] == 14) {
						tiles[x][y] = new Tile(TileType.Dead_Tree, true, this);
					}
					if(map.currentMap[y][x] == 15) {
						tiles[x][y] = new Tile(TileType.City_Tile, false, this);
					}
					if(map.currentMap[y][x] == 16) {
						tiles[x][y] = new Tile(TileType.Window, false, this);
					}
					if(map.currentMap[y][x] == 17) {
						tiles[x][y] = new Tile(TileType.Water_Left, true, this);
					}
					if(map.currentMap[y][x] == 18) {
						tiles[x][y] = new Tile(TileType.Water_Base, true, this);
					}
					if(map.currentMap[y][x] == 19) {
						tiles[x][y] = new Tile(TileType.Water_Right, true, this);
					}
					if(map.currentMap[y][x] == 20) {
						//tiles[x][y] = new Tile(TileType.Wood_Door, false, this);
						tiles[x][y] = new Door(TileType.Wood_Door, false, this);
					}
					if(map.currentMap[y][x] == 21) {
						tiles[x][y] = new Tile(TileType.Wood_Top, true, this);
					}
					if(map.currentMap[y][x] == 22) {
						tiles[x][y] = new Tile(TileType.Rock_On_CaveFloor, true, this);
					}
					if(map.currentMap[y][x] == 23) {
						tiles[x][y] = new Tile(TileType.Tree_Bottom, true, this);
					}
					if(map.currentMap[y][x] == 27) {
						tiles[x][y] = new Tile(TileType.Water_BottomLeft, true, this);
					}
					if(map.currentMap[y][x] == 28) {
						tiles[x][y] = new Tile(TileType.Water_Bottom, true, this);
					}
					if(map.currentMap[y][x] == 29) {
						tiles[x][y] = new Tile(TileType.Water_BottomRight, true, this);
					}
					if(map.currentMap[y][x] == 30) {
						tiles[x][y] = new Tile(TileType.Wood_Floor, false, this);
					}
					if(map.currentMap[y][x] == 31) {
						tiles[x][y] = new Tile(TileType.Wood_Base, true, this);
					}
					if(map.currentMap[y][x] == 32) {
						tiles[x][y] = new Tile(TileType.Rock, true, this);
					}
					if(map.currentMap[y][x] == 33) {
						tiles[x][y] = new Tile(TileType.CaveEntry_OnDirt, false, this);
					}
					if(map.currentMap[y][x] == 37) {
						tiles[x][y] = new Tile(TileType.Bridge_Left, true, this);
					}
					if(map.currentMap[y][x] == 38) {
						tiles[x][y] = new Tile(TileType.Bridge_Top, true, this);
					}
					if(map.currentMap[y][x] == 39) {
						tiles[x][y] = new Tile(TileType.Bridge_Base, false, this);
					}
					if(map.currentMap[y][x] == 42) {
						tiles[x][y] = new Tile(TileType.Rock_On_Dirt, true, this);
					}
					if(map.currentMap[y][x] == 47) {
						tiles[x][y] = new Tile(TileType.Bridge_Bottom, true, this);
					}
					if(map.currentMap[y][x] == 48) {
						tiles[x][y] = new Tile(TileType.Bridge_BaseSide, false, this);
					}
					if(map.currentMap[y][x] == 49) {
						tiles[x][y] = new Tile(TileType.Bridge_Right, true, this);
					}
					if(map.currentMap[y][x] == 57) {
						tiles[x][y] = new Tile(TileType.Dirt_TopLeft, false, this);
					}
					if(map.currentMap[y][x] == 58) {
						tiles[x][y] = new Tile(TileType.Dirt_Top, false, this);
					}
					if(map.currentMap[y][x] == 59) {
						tiles[x][y] = new Tile(TileType.Dirt_TopRight, false, this);
					}
					if(map.currentMap[y][x] == 67) {
						tiles[x][y] = new Tile(TileType.Dirt_Left, false, this);
					}
					if(map.currentMap[y][x] == 68) {
						tiles[x][y] = new Tile(TileType.Dirt_Base, false, this);
					}
					if(map.currentMap[y][x] == 69) {
						tiles[x][y] = new Tile(TileType.Dirt_Right, false, this);
					}
					if(map.currentMap[y][x] == 77) {
						tiles[x][y] = new Tile(TileType.Dirt_BottomLeft, false, this);
					}
					if(map.currentMap[y][x] == 78) {
						tiles[x][y] = new Tile(TileType.Dirt_Bottom, false, this);
					}
					if(map.currentMap[y][x] == 79) {
						tiles[x][y] = new Tile(TileType.Dirt_BottomRight, false, this);
					}
					//Wood roof 1
					if(map.currentMap[y][x] == 44) {
						tiles[x][y] = new Tile(TileType.WoodRoof_TopLeft1, true, this);
					}
					if(map.currentMap[y][x] == 45) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Top1, true, this);
					}
					if(map.currentMap[y][x] == 46) {
						tiles[x][y] = new Tile(TileType.WoodRoof_TopRight1, true, this);
					}
					if(map.currentMap[y][x] == 54) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Left1, true, this);
					}
					if(map.currentMap[y][x] == 55) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Base1, true, this);
					}
					if(map.currentMap[y][x] == 56) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Right1, true, this);
					}
					if(map.currentMap[y][x] == 64) {
						tiles[x][y] = new Tile(TileType.WoodRoof_BottomLeft1, true, this);
					}
					if(map.currentMap[y][x] == 65) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Bottom1, true, this);
					}
					if(map.currentMap[y][x] == 66) {
						tiles[x][y] = new Tile(TileType.WoodRoof_BottomRight1, true, this);
					}
					//Wood roof 2
					if(map.currentMap[y][x] == 74) {
						tiles[x][y] = new Tile(TileType.WoodRoof_TopLeft2, true, this);
					}
					if(map.currentMap[y][x] == 75) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Top2, true, this);
					}
					if(map.currentMap[y][x] == 76) {
						tiles[x][y] = new Tile(TileType.WoodRoof_TopRight2, true, this);
					}
					if(map.currentMap[y][x] == 84) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Left2, true, this);
					}
					if(map.currentMap[y][x] == 85) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Base2, true, this);
					}
					if(map.currentMap[y][x] == 86) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Right2, true, this);
					}
					if(map.currentMap[y][x] == 94) {
						tiles[x][y] = new Tile(TileType.WoodRoof_BottomLeft2, true, this);
					}
					if(map.currentMap[y][x] == 95) {
						tiles[x][y] = new Tile(TileType.WoodRoof_Bottom2, true, this);
					}
					if(map.currentMap[y][x] == 96) {
						tiles[x][y] = new Tile(TileType.WoodRoof_BottomRight2, true, this);
					}
					//Steel roof
					if(map.currentMap[y][x] == 71) {
						tiles[x][y] = new Tile(TileType.SteelRoof_TopLeft, true, this);
					}
					if(map.currentMap[y][x] == 72) {
						tiles[x][y] = new Tile(TileType.SteelRoof_Top, true, this);
					}
					if(map.currentMap[y][x] == 73) {
						tiles[x][y] = new Tile(TileType.SteelRoof_TopRight, true, this);
					}
					if(map.currentMap[y][x] == 81) {
						tiles[x][y] = new Tile(TileType.SteelRoof_Left, true, this);
					}
					if(map.currentMap[y][x] == 82) {
						tiles[x][y] = new Tile(TileType.SteelRoof_Base, true, this);
					}
					if(map.currentMap[y][x] == 83) {
						tiles[x][y] = new Tile(TileType.SteelRoof_Right, true, this);
					}
					if(map.currentMap[y][x] == 91) {
						tiles[x][y] = new Tile(TileType.SteelRoof_BottomLeft, true, this);
					}
					if(map.currentMap[y][x] == 92) {
						tiles[x][y] = new Tile(TileType.SteelRoof_Bottom, true, this);
					}
					if(map.currentMap[y][x] == 93) {
						tiles[x][y] = new Tile(TileType.SteelRoof_BottomRight, true, this);
					}
					if(map.currentMap[y][x] == 40) {
						tiles[x][y] = new Tile(TileType.Steel_Top, true, this);
					}
				}
			}
		
		
		//Set all the tiles' positions to the world's position plus i and j. That will give you the world location.
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				tiles[i][j].setPosition(new Vector2D(position.X+i, position.Y+j));
			}
		}
		
		//NPCs
		npcManager.initialize();
		for(NPC c : npcManager.npcs) {
			if(!entities.contains(c)) {
				c.textBox.Open = false;
				entities.add(c);
			}
		}
		
	}
	
	@Override
	public void draw(Graphics2D g) {
		if(tiles != null) {
			//Draw all of the tiles
			for(int x = 0; x < Width; x++) {
				for(int y = 0; y < Height; y++) {
					//If it is within the screen width and height.
					if(tiles[x][y].position.X >= -1 && tiles[x][y].position.X <= 20) {
						if(tiles[x][y].position.Y >= -1 && tiles[x][y].position.Y <= 14) {
							tiles[x][y].draw(g);
						}
					}
				}
			}
			
			//NPCs
			for(NPC c : npcManager.npcs) {
				if(c.inWorld() == this) {
					c.draw(g);
				}
			}
		}
	}
	
	@Override
	public void update(double time) {
		//If the tiles have been created.
		if(tiles != null) {
			//Check for world position movements.
			checkCollisions();
			
			//System.out.println(worldstate.player.position.toString());
			
			if(up) { moveUp(); hasMoved = true; }
			if(down) { moveDown(); hasMoved = true; }
			if(left) { moveLeft(); hasMoved = true; }
			if(right) { moveRight(); hasMoved = true; }
			
			//NPCs
			for(NPC c : npcManager.npcs) {
				if(c.inWorld() == this) {
					c.update(time);
				}
			}
			
			//Update the position of each tile.
			for(int i = 0; i < tiles.length; i++) {
				for(int j = 0; j < tiles[0].length; j++) {
					tiles[i][j].setPosition(new Vector2D(i+position.X, j+position.Y));
					tiles[i][j].update(time);
				}
			}
		}
	}
	
	/** Returns the player from the world state. */
	public Player getPlayer() { return worldstate.player; }
	
	/** Returns the tile that is at the position, "pos." */
	public Tile tileAt(Vector2D pos) {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				if(tiles[i][j].position.equals(pos)) {
					return tiles[i][j];
				}
			}
		}
		return null;
	}
	
	/** Sets the initial position of the world, starting from the top left corner of the screen. */
	public World setStartPosition(Vector2D pos) {
		position = pos;		
		return this;
	}
	
	
	public void moveUp() {
		
		if(dist >= 0) {
			moving = true;
			position.Y += MOVE_STEP;
			dist -= MOVE_STEP;
			for(Entity e : entities) {
				e.position.Y = e.position.Y + MOVE_STEP;
			}
		} else {
			up  = false;
			moving = false;
			dist = 1;
		}
	}
	public void moveDown() {

		if(dist >= 0) {
			moving = true;
			position.Y -= MOVE_STEP;
			dist -= MOVE_STEP;
			for(Entity e : entities) {
				e.position.Y = e.position.Y - MOVE_STEP;
			}
		} else {
			down  = false;
			moving = false;
			dist = 1;
		}
		
	}
	public void moveLeft() {
		
		if(dist >= 0) {
			moving = true;
			position.X += MOVE_STEP;
			dist -= MOVE_STEP;
			for(Entity e : entities) {
				e.position.X = e.position.X + MOVE_STEP;
			}
		} else {
			left  = false;
			moving = false;
			dist = 1;
		}
	
	}
	public void moveRight() {
		
		if(dist >= 0) {
			moving = true;
			position.X -= MOVE_STEP;
			dist -= MOVE_STEP;
			for(Entity e : entities) {
				e.position.X = e.position.X - MOVE_STEP;
			}
		} else {
			right  = false;
			moving = false;
			dist = 1;
		}
	
	}

	
	private void checkCollisions() {
		/* Basically, if you are not moving... */
		if(dist >= 1) {				
			//Round the position just to keep things even.
			position.Y = Math.round(position.Y);
			position.X = Math.round(position.X);
			for(NPC npc : npcManager.npcs) {
				npc.position.X = Math.round(npc.position.X);
				npc.position.Y = Math.round(npc.position.Y);
			}
			
			/* Find the next tile in each direction of the player. */
			findNextUp();
			findNextDown();
			findNextLeft();
			findNextRight();
		}
	}
	
	//Get the next tile in each direction from the player.
	private void findNextUp() {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				//Up
				if(tiles[i][j].position.X == worldstate.player.position.X && tiles[i][j].position.Y == worldstate.player.position.Y - 1) {
					if(!tiles[i][j].isSolid()) {
						canMoveUp = true;
					} else {
						canMoveUp = false;
					}
				}
			}
		} //end of for loop
	}
	private void findNextDown() {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				//Down
				if(tiles[i][j].position.X == worldstate.player.position.X && tiles[i][j].position.Y == worldstate.player.position.Y + 1) {
					if(!tiles[i][j].isSolid()) {
						canMoveDown = true;
					} else {
						canMoveDown = false;
					}
				}
			}
		} //end of for loop
	}
	private void findNextLeft() {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				//Left
				if(tiles[i][j].position.X == worldstate.player.position.X - 1 && tiles[i][j].position.Y == worldstate.player.position.Y) {
					if(!tiles[i][j].isSolid()) {
						canMoveLeft = true;
					} else {
						canMoveLeft = false;
					}
				}
			}
		} //end of for loop
	}
	private void findNextRight() {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				//Right
				if(tiles[i][j].position.X == worldstate.player.position.X + 1 && tiles[i][j].position.Y == worldstate.player.position.Y) {
					if(!tiles[i][j].isSolid()) {
						canMoveRight = true;
					} else {
						canMoveRight = false;
					}
				}
			}
		} //end of for loop
	}
}
