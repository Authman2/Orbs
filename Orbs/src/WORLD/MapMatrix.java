package WORLD;

import java.io.Serializable;
import java.util.ArrayList;

import myproject.gos.main.ArrayConversion;
import myproject.gos.main.ReadFile;

public class MapMatrix implements Serializable {
	private static final long serialVersionUID = 6191318611659876760L;
	
	
	//The world map as a 1D array
	public int[] worldMapSingle;
	//The world map as a 2D array
	public int[][] worldMap;
	
	//A house as a 1D and 2D array
	public int[] house1Single;
	public int[][] house1;
	
	//A group of maps to display
	public ArrayList<int[]> maps1D;
	public ArrayList<int[][]> maps2D;
	
	//The current map being displayed.
	public int[][] currentMap;
	
	
	
	public MapMatrix(int i) {
		maps1D.add(worldMapSingle);
		maps1D.add(house1Single);
		
		//Read the world map text file
		getWorldFiles();
		currentMap = maps2D.get(i);
	}
	
	/** Fills all of the one dimensional arrays based off of their text files. */
	private void getWorldFiles() { 
		for(int[] a : maps1D) {
			
			/* THE GENERAL WORLD MAP */
			if(a == worldMapSingle) {
				ReadFile reader = new ReadFile();
				String s = null;
				try {
					s = reader.Read("/Users/adeouthman/Documents/AdeolasCodingStuff/Images/2DTileGame/MapsInTiled/WorldMap.txt");
				} catch(Exception e) {
					e.printStackTrace();
				}
				//Create a single dimensional array for it.
				worldMapSingle = reader.CreateArrayINT(s, ",");
				
				//Convert it to a two dimensional array. REMEMBER, WORLD MAP MUST HAVE DIMENSIONS NxN TO WORK.
				worldMap = ArrayConversion.OneToTwo(worldMapSingle, 96);
			}
			
			
			/* THE FIRST HOUSE IN THE FIRST TOWN */
			if(a == house1Single) {
				ReadFile reader = new ReadFile();
				String s = null;
				try {
					s = reader.Read("/Users/adeouthman/Documents/AdeolasCodingStuff/Images/2DTileGame/MapsInTiled/WorldMap.txt");
				} catch(Exception e) {
					e.printStackTrace();
				}
				//Create a single dimensional array for it.
				house1Single = reader.CreateArrayINT(s, ",");
				
				//Convert it to a two dimensional array. REMEMBER, WORLD MAP MUST HAVE DIMENSIONS NxN TO WORK.
				house1 = ArrayConversion.OneToTwo(worldMapSingle, 96);
			}
		}
	}
}
