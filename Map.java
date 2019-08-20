package com.rpg.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.rpg.game.Tiles.Tile;

// This creates the world for our game
public class Map {
	
	private Tiles tileSet;

	public Map(File mapFile, Tiles tileSet) {
		// TODO Auto-generated constructor stub
		
		this.tileSet = tileSet;
		try {
		
			Scanner filescanner = new Scanner(mapFile);
			
			while(filescanner.hasNextLine()) {
				
				String line = filescanner.nextLine();
				if(!line.startsWith("//")) {
					String[] splitString = line.split("-"); 
				
					
				}
				
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
