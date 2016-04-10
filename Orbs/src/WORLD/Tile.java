package WORLD;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import INVENTORY.Item;
import INVENTORY.Item.ItemType;
import MAIN.Assets;

public class Tile implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3697846158630363219L;
	
	public Vector2D position;
	private TileType type;
	Item item = null;
	private boolean solid, hasItem;
	private String tileInfo;
	public World tilesWorld;
	
	
	public Tile(boolean isSolid, World w) {
		this.solid = isSolid;
		this.tilesWorld = w;
	}
	public Tile(TileType t, boolean isSolid, World w) {
		this.type = t;
		this.solid = isSolid;
		this.tilesWorld = w;
	}
	
	public boolean isSolid() { return solid; }
	public boolean hasItem() { return hasItem; }

	public boolean isNextToPlayer() {
		 if(isAbove() || isBelow() || isRight() || isLeft()) {
			 return true;
		 }
		
		
		return false;
	}
	
	public boolean isAbove() {
		if(position.X == tilesWorld.worldstate.gsm.input.player.position.X && position.Y == tilesWorld.worldstate.gsm.input.player.position.Y + 1) {
			return true;
		}
		return false;
	}
	public boolean isBelow() {
		if(position.X == tilesWorld.worldstate.gsm.input.player.position.X && position.Y == tilesWorld.worldstate.gsm.input.player.position.Y - 1) {
			return true;
		}
		return false;
	}
	public boolean isRight() {
		if(position.X == tilesWorld.worldstate.gsm.input.player.position.X + 1 && position.Y == tilesWorld.worldstate.gsm.input.player.position.Y) {
			return true;
		}
		return false;
	}
	public boolean isLeft() {
		if(position.X == tilesWorld.worldstate.gsm.input.player.position.X - 1 && position.Y == tilesWorld.worldstate.gsm.input.player.position.Y) {
			return true;
		}
		return false;
	}
	
	
	
	public Tile setPosition(Vector2D pos) {
		position = new Vector2D(pos.X, pos.Y);
		return this;
	}
	
	private Item getRandomItem() {
		ArrayList<Item> ITEMS = new ArrayList<Item>();
		
		ITEMS.add(new Item(ItemType.Apple));
		ITEMS.add(new Item(ItemType.Orange));
		ITEMS.add(new Item(ItemType.Money));
		ITEMS.add(new Item(ItemType.Fish));
		ITEMS.add(new Item(ItemType.Hatchet));
		
		Random rand = new Random();
		return ITEMS.get(rand.nextInt(ITEMS.size()));
	}
	
	/** Returns info about the tile. Mostly only used when the player clicks on a tile; sometimes it will appear. */
	public String tileInfo() { return tileInfo; }
	
	private void drawTiles(Graphics2D g, AffineTransform t) {

		if(type == TileType.Grass_1) {g.drawImage(Assets.Grass_1, t, null); }
		if(type == TileType.Grass_2) {g.drawImage(Assets.Grass_2, t, null); }
		if(type == TileType.Cave_Entry) {g.drawImage(Assets.Cave_Entry, t, null); tileInfo = "An entrance to "; }
		if(type == TileType.Rock_On_Grass) {g.drawImage(Assets.Rock_On_Grass, t, null);  }
		if(type == TileType.Flower) {g.drawImage(Assets.Flower, t, null);  }
		if(type == TileType.Bush) {g.drawImage(Assets.Bush, t, null);  }
		if(type == TileType.Sand) {g.drawImage(Assets.Sand, t, null);  }
		if(type == TileType.Water_TopLeft) {g.drawImage(Assets.Water_TopLeft, t, null);  }
		if(type == TileType.Water_Top) {g.drawImage(Assets.Water_Top, t, null);  }
		if(type == TileType.Water_TopRight) {g.drawImage(Assets.Water_TopRight, t, null);  }
		if(type == TileType.Red_Brick) {g.drawImage(Assets.Red_Brick, t, null);  }
		if(type == TileType.Gray_Brick) {g.drawImage(Assets.Gray_Brick, t, null);  }
		if(type == TileType.Cave_Floor) {g.drawImage(Assets.Cave_Floor, t, null);  }
		if(type == TileType.Tree_Top) {g.drawImage(Assets.Tree_Top, t, null);  }
		if(type == TileType.Dead_Tree) {g.drawImage(Assets.Dead_Tree, t, null);  }
		if(type == TileType.City_Tile) {g.drawImage(Assets.City_Tile, t, null);  }
		if(type == TileType.Window) {g.drawImage(Assets.Window, t, null);  }
		if(type == TileType.Water_Left) {g.drawImage(Assets.Water_Left, t, null);  }
		if(type == TileType.Water_Base) {g.drawImage(Assets.Water_Base, t, null);  }
		if(type == TileType.Water_Right) {g.drawImage(Assets.Water_Right, t, null);  }
		if(type == TileType.Wood_Door) {g.drawImage(Assets.Wood_Door, t, null);  }
		if(type == TileType.Wood_Top) {g.drawImage(Assets.Wood_Top, t, null);  }
		if(type == TileType.Rock_On_CaveFloor) {g.drawImage(Assets.Rock_On_CaveFloor, t, null);  }
		if(type == TileType.Tree_Bottom) {g.drawImage(Assets.Tree_Bottom, t, null);  }
		if(type == TileType.Water_BottomLeft) {g.drawImage(Assets.Water_BottomLeft, t, null);  }
		if(type == TileType.Water_Bottom) {g.drawImage(Assets.Water_Bottom, t, null);  }
		if(type == TileType.Water_BottomRight) {g.drawImage(Assets.Water_BottomRight, t, null);  }
		if(type == TileType.Wood_Floor) {g.drawImage(Assets.Wood_Floor, t, null);  }
		if(type == TileType.Wood_Base) {g.drawImage(Assets.Wood_Base, t, null);  }
		if(type == TileType.Rock) {g.drawImage(Assets.Rock, t, null);  }
		if(type == TileType.CaveEntry_OnDirt) {g.drawImage(Assets.CaveEntry_OnDirt, t, null);  }
		if(type == TileType.Bridge_Left) {g.drawImage(Assets.Bridge_Left, t, null);  }
		if(type == TileType.Bridge_Top) {g.drawImage(Assets.Bridge_Top, t, null);  }
		if(type == TileType.Bridge_Base) {g.drawImage(Assets.Bridge_Base, t, null);  }
		if(type == TileType.Rock_On_Dirt) {g.drawImage(Assets.Rock_On_Dirt, t, null);  }
		if(type == TileType.Bridge_Bottom) {g.drawImage(Assets.Bridge_Bottom, t, null);  }
		if(type == TileType.Bridge_BaseSide) {g.drawImage(Assets.Bridge_BaseSide, t, null);  }
		if(type == TileType.Bridge_Right) {g.drawImage(Assets.Bridge_Right, t, null);  }
		if(type == TileType.Dirt_TopLeft) {g.drawImage(Assets.Dirt_TopLeft, t, null);  }
		if(type == TileType.Dirt_Top) {g.drawImage(Assets.Dirt_Top, t, null);  }
		if(type == TileType.Dirt_TopRight) {g.drawImage(Assets.Dirt_TopRight, t, null);  }
		if(type == TileType.Dirt_Left) {g.drawImage(Assets.Dirt_Left, t, null);  }
		if(type == TileType.Dirt_Base) {g.drawImage(Assets.Dirt_Base, t, null);  }
		if(type == TileType.Dirt_Right) {g.drawImage(Assets.Dirt_Right, t, null);  }
		if(type == TileType.Dirt_BottomLeft) {g.drawImage(Assets.Dirt_BottomLeft, t, null);  }
		if(type == TileType.Dirt_Bottom) {g.drawImage(Assets.Dirt_Bottom, t, null);  }
		if(type == TileType.Dirt_BottomRight) {g.drawImage(Assets.Dirt_BottomRight, t, null);  }
		/////
		if(type == TileType.Steel_Top) {g.drawImage(Assets.Steel_Top, t, null); }
		if(type == TileType.SteelRoof_Top) {g.drawImage(Assets.SteelRoof_Top, t, null);}
		if(type == TileType.SteelRoof_Bottom) {g.drawImage(Assets.SteelRoof_Bottom, t, null); } 
		if(type == TileType.SteelRoof_TopRight) { g.drawImage(Assets.SteelRoof_TopRight, t, null);}
		if(type == TileType.SteelRoof_TopLeft) {g.drawImage(Assets.SteelRoof_TopLeft, t, null); } 
		if(type == TileType.SteelRoof_BottomRight) {g.drawImage(Assets.SteelRoof_BottomRight, t, null); }
		if(type == TileType.SteelRoof_BottomLeft) {g.drawImage(Assets.SteelRoof_BottomLeft, t, null);} 
		if(type == TileType.SteelRoof_Left) {g.drawImage(Assets.SteelRoof_Left, t, null); } 
		if(type == TileType.SteelRoof_Right) {g.drawImage(Assets.SteelRoof_Right, t, null); } 
		if(type == TileType.SteelRoof_Base) {g.drawImage(Assets.SteelRoof_Base, t, null); } 
		if(type == TileType.WoodRoof_Top1) {g.drawImage(Assets.WoodRoof_Top1, t, null); }
		if(type == TileType.WoodRoof_Bottom1) {g.drawImage(Assets.WoodRoof_Bottom1, t, null); } 
		if(type == TileType.WoodRoof_TopRight1) { g.drawImage(Assets.WoodRoof_TopRight1, t, null);} 
		if(type == TileType.WoodRoof_TopLeft1) {g.drawImage(Assets.WoodRoof_TopLeft1, t, null); } 
		if(type == TileType.WoodRoof_BottomRight1) {g.drawImage(Assets.WoodRoof_BottomRight1, t, null); }
		if(type == TileType.WoodRoof_BottomLeft1) {g.drawImage(Assets.WoodRoof_BottomLeft1, t, null); }
		if(type == TileType.WoodRoof_Left1) {g.drawImage(Assets.WoodRoof_Left1, t, null); }
		if(type == TileType.WoodRoof_Right1) {g.drawImage(Assets.WoodRoof_Right1, t, null); } 
		if(type == TileType.WoodRoof_Base1) {g.drawImage(Assets.WoodRoof_Base1, t, null); } 
		if(type == TileType.WoodRoof_Top2) {g.drawImage(Assets.WoodRoof_Top2, t, null); }
		if(type == TileType.WoodRoof_Bottom2) {g.drawImage(Assets.WoodRoof_Bottom2, t, null); }
		if(type == TileType.WoodRoof_TopRight2) { g.drawImage(Assets.WoodRoof_TopRight2, t, null);}
		if(type == TileType.WoodRoof_TopLeft2) {g.drawImage(Assets.WoodRoof_TopLeft2, t, null); }
		if(type == TileType.WoodRoof_BottomRight2) {g.drawImage(Assets.WoodRoof_BottomRight2, t, null); }
		if(type == TileType.WoodRoof_BottomLeft2) {g.drawImage(Assets.WoodRoof_BottomLeft2, t, null); }
		if(type == TileType.WoodRoof_Left2) { g.drawImage(Assets.WoodRoof_Left2, t, null);} 
		if(type == TileType.WoodRoof_Right2) {g.drawImage(Assets.WoodRoof_Right2, t, null); } 
		if(type == TileType.WoodRoof_Base2) {g.drawImage(Assets.WoodRoof_Base2, t, null); }
		if(type == TileType.WoodRoof_Base) {g.drawImage(Assets.WoodRoof_Base, t, null); }
	}
	
	@Override
	public void draw(Graphics2D g) {
		AffineTransform t = new AffineTransform();
		t.translate(position.X*32, position.Y*32);
		t.scale(1, 1);
		
		//Draw based on the type of tile
		drawTiles(g,t);
	}


	@Override
	public void initialize() {
		if(type == TileType.Grass_1) { tileInfo = null; }
		if(type == TileType.Grass_2) { tileInfo = null; }
		if(type == TileType.Cave_Entry) { tileInfo = "An entrance to a cave. I wonder what could be down there?"; }
		if(type == TileType.Rock_On_Grass) {tileInfo = "A plain, old rock.";}
		if(type == TileType.Flower) {tileInfo = "A lovely flower!";}
		if(type == TileType.Bush) { hasItem = true; this.item = getRandomItem(); tileInfo = "You found a " + this.item.itemName(); }
		if(type == TileType.Sand) { tileInfo = null; }
		if(type == TileType.Water_TopLeft) { tileInfo = "I could sail here with a boat."; }
		if(type == TileType.Water_Top) { tileInfo = "I could sail here with a boat."; }
		if(type == TileType.Water_TopRight) { tileInfo = "I could sail here with a boat."; }
		if(type == TileType.Red_Brick) { tileInfo = null; }
		if(type == TileType.Gray_Brick) { tileInfo = null; }
		if(type == TileType.Cave_Floor) { tileInfo = null; }
		if(type == TileType.Tree_Top) { tileInfo = null; }
		if(type == TileType.Dead_Tree) { tileInfo = "This tree looks like it could be cut down easily."; }
		if(type == TileType.City_Tile) { tileInfo = null; }
		if(type == TileType.Window) { tileInfo = "I can see inside through the window!"; }
		if(type == TileType.Water_Left) { tileInfo = "I could sail here with a boat."; }
		if(type == TileType.Water_Base) { tileInfo = "I could sail here with a boat."; }
		if(type == TileType.Water_Right) { tileInfo = "I could sail here with a boat."; }
		if(type == TileType.Wood_Door) { tileInfo = "What lies beyond this door?"; }
		if(type == TileType.Wood_Top) { tileInfo = null; }
		if(type == TileType.Rock_On_CaveFloor) { tileInfo = "A plain, old rock."; }
		if(type == TileType.Tree_Bottom) { tileInfo = null; }
		if(type == TileType.Water_BottomLeft) { tileInfo = "I could sail here with a boat."; }
		if(type == TileType.Water_Bottom) { tileInfo = "I could sail here with a boat."; }
		if(type == TileType.Water_BottomRight) { tileInfo = "I could sail here with a boat."; }
		if(type == TileType.Wood_Floor) { tileInfo = null; }
		if(type == TileType.Wood_Base) { tileInfo = null; }
		if(type == TileType.Rock) { tileInfo = "A plain, old rock."; }
		if(type == TileType.CaveEntry_OnDirt) { tileInfo = "An entrance to a cave. I wonder what could be down there?"; }
		if(type == TileType.Bridge_Left) { tileInfo = null; }
		if(type == TileType.Bridge_Top) { tileInfo = null; }
		if(type == TileType.Bridge_Base) { tileInfo = null; }
		if(type == TileType.Rock_On_Dirt) { tileInfo = null; }
		if(type == TileType.Bridge_Bottom) { tileInfo = null; }
		if(type == TileType.Bridge_BaseSide) { tileInfo = null; }
		if(type == TileType.Bridge_Right) { tileInfo = null; }
		if(type == TileType.Dirt_TopLeft) { tileInfo = null; }
		if(type == TileType.Dirt_Top) { tileInfo = null; }
		if(type == TileType.Dirt_TopRight) { tileInfo = null; }
		if(type == TileType.Dirt_Left) { tileInfo = null; }
		if(type == TileType.Dirt_Base) { tileInfo = null; }
		if(type == TileType.Dirt_Right) { tileInfo = null; }
		if(type == TileType.Dirt_BottomLeft) { tileInfo = null; }
		if(type == TileType.Dirt_Bottom) { tileInfo = null; }
		if(type == TileType.Dirt_BottomRight) { tileInfo = null; }
	}

	@Override
	public void update(double time) { }
	
}
