package WORLD;

import java.io.Serializable;
import java.util.ArrayList;

import myproject.gos.main.ArrayConversion;
import myproject.gos.main.ReadFile;

/** Solely responsible for setting up the maps. Loads data into the 2D arrays that are used for the maps on the screen. */
public class MapMatrix implements Serializable {
	private static final long serialVersionUID = 6191318611659876760L;
	
	
	//1D arrays
	public int[] worldMapSingle;
	public int[] house1Single;
	public int[][] house1;
	
	//A group of maps to display
	public ArrayList<int[]> maps1D = new ArrayList<int[]>();
	public ArrayList<int[][]> maps2D = new ArrayList<int[][]>();
	
	//The current map being displayed.
	public int[][] currentMap;
	
	
	
	public MapMatrix(int i) {
		maps1D.add(worldMapSingle);
		maps1D.add(house1Single);
		
		//Read the world map text file
		getWorldFiles();
		
		maps2D.add(worldMap);
		maps2D.add(house1);
		
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
					s = reader.Read("WorldMap.txt");
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
					s = reader.Read("House1.txt");
				} catch(Exception e) {
					e.printStackTrace();
				}
				//Create a single dimensional array for it.
				house1Single = reader.CreateArrayINT(s, ",");
				
				//Convert it to a two dimensional array. REMEMBER, WORLD MAP MUST HAVE DIMENSIONS NxN TO WORK.
				house1 = ArrayConversion.OneToTwo(house1Single, 15);
			}
		}
	}
}
