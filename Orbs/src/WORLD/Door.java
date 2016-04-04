package WORLD;

public class Door extends Tile {
	private static final long serialVersionUID = 7256091607091622469L;

	
	private World goTo = null;
	
	
	public Door(TileType t, boolean isSolid, World w) {
		super(t, isSolid, w);
		
	}
	
	/** Sets the world that this door will send the player to upon collision. */
	public void setGoTo(World gt) {
		goTo = gt;
	}
	
	/** Returns the destination world that this door will send the player to. */
	public World getGoTo() {
		return goTo;
	}
	
	/** Returns whether or not the player is standing on a door. */
	public boolean onDoor() {
		if(position.equals(tilesWorld.worldstate.player.position)) {
			System.out.println("Player is standing on a door.");
			System.out.println(position.toString());
			return true;
		}
		return false;
	}

}
