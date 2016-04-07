package WORLD;

import java.io.Serializable;
import java.util.ArrayList;

import myproject.gos.main.ReadFile;
import contents.ArrayConversion;

/** Solely responsible for setting up the maps. Loads data into the 2D arrays that are used for the maps on the screen. */
public class MapMatrix implements Serializable {
	private static final long serialVersionUID = 6191318611659876760L;
	
	
	//1D arrays
	public int[] worldMapSingle, house1Single, house2Single, laboratory1Single;
	
	//2D arrays
	public int[][] worldMap, house1, house2, laboratory1;
	
	//A group of maps to display
	public ArrayList<int[]> maps1D = new ArrayList<int[]>();
	public ArrayList<int[][]> maps2D = new ArrayList<int[][]>();
	
	//The current map being displayed.
	public int[][] currentMap;
	
	
	
	public MapMatrix(int i) {
		maps1D.add(worldMapSingle);
		maps1D.add(house1Single);
		maps1D.add(house2Single);
		maps1D.add(laboratory1Single);
		
		//Read the world map text file
		getWorldFiles();
		
		maps2D.add(worldMap);
		maps2D.add(house1);
		maps2D.add(house2);
		maps2D.add(laboratory1);
		
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
				
				//Convert it to a two dimensional array.
				worldMap = ArrayConversion.OneToTwo(worldMapSingle, 581);
			}
			
			
			/* THE FIRST HOUSE */
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
				
				//Convert it to a two dimensional array.
				house1 = ArrayConversion.OneToTwo(house1Single, 15);
			}
			
			
			/* THE SECOND HOUSE */
			if(a == house2Single) {
				ReadFile reader = new ReadFile();
				String s = null;
				try {
					s = reader.Read("House2.txt");
				} catch(Exception e) {
					e.printStackTrace();
				}
				//Create a single dimensional array for it.
				house2Single = reader.CreateArrayINT(s, ",");
				
				//Convert it to a two dimensional array.
				house2 = ArrayConversion.OneToTwo(house2Single, 20);
			}
			
			
			/* THE FIRST LABORATORY */
			if(a == laboratory1Single) {
				ReadFile reader = new ReadFile();
				String s = null;
				try {
					s = reader.Read("Laboratory1.txt");
				} catch(Exception e) {
					e.printStackTrace();
				}
				//Create a single dimensional array for it.
				laboratory1Single = reader.CreateArrayINT(s, ",");
				
				//Convert it to a two dimensional array.
				laboratory1 = ArrayConversion.OneToTwo(laboratory1Single, 35);
			}
		}
	}
}
