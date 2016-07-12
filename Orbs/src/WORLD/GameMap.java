package WORLD;

import collectionsje.ArrayConversion;
import filesje.ReadFile;

public class GameMap {

	
	//The world map as a 1D array
	public int[] worldMapSingle;
	//The world map as a 2D array
	public int[][] worldMap;
	
	
	//House map as a 1D array
	public int[] houseMapSingle;
	//The house map as a 2D array
	public int[][] houseMap;
	
	
	//The current map being displayed.
	public int[][] currentMap;
	
	
	//A bunch of different maps
	public int[][][] maps;
	
	
	public GameMap() {
		//Read the world map text file
		getWorldFiles();
		
		maps = new int[2][][];
		
		maps[0] = worldMap;
		maps[1] = houseMap;
		
		currentMap = maps[0];
	}
		
	/** Fills all of the one dimensional arrays based off of their text files. */
	private void getWorldFiles() { 
		/* THE GENERAL WORLD MAP */
		ReadFile reader = new ReadFile();
		String s = null;
		try {
			s = reader.Read("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/WorldMapText.txt");
		} catch(Exception e) { e.printStackTrace(); }
		
		//Create a single dimensional array for it.
		worldMapSingle = reader.CreateArrayINT(s, ",");
		
		//Convert it to a two dimensional array. REMEMBER, WORLD MAP MUST HAVE DIMENSIONS NxN TO WORK.
		worldMap = ArrayConversion.OneToTwo(worldMapSingle, 100);
		
		
		//Reset
		s = null;
		
		/* THE HOUSE MAP */
		try {
			s = reader.Read("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/HouseMapText.txt");
		} catch(Exception e) { e.printStackTrace(); }
		
		//Create a single dimensional array for it.
		houseMapSingle = reader.CreateArrayINT(s, ",");
		
		//Convert it to a two dimensional array. REMEMBER, WORLD MAP MUST HAVE DIMENSIONS NxN TO WORK.
		houseMap = ArrayConversion.OneToTwo(houseMapSingle, 12);
	}
	
}
