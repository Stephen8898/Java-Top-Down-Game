package com.rpg.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import com.rpg.game.Tiles.Tile;

// This creates the world for our game
public class Map {
	
	private Tiles tileSet;
	private RenderHandler renderer;
	private int fileTileID = -1;

	private ArrayList<MappedTile> mappedTileA = new ArrayList<MappedTile>();
	
	public Map(File mapFile, Tiles tileSet) {
		// TODO Auto-generated constructor stub
		
		this.tileSet = tileSet;
		try {
		
			Scanner filescanner = new Scanner(mapFile);
			
			while(filescanner.hasNextLine()) {
				
				String line = filescanner.nextLine();
				if(!line.startsWith("//")) {
					
					
					if (line.contains(":")) {
						String[] splitString = line.split(":"); 
						if(splitString[0].equalsIgnoreCase("Fill")) {
							fileTileID = Integer.parseInt(splitString[1]);
							continue;
						}
					}
					
					String[] splitString = line.split("-"); 
					if(splitString.length >= 3) {
						
						//id, x, and y position
						MappedTile mappedtile = new MappedTile(Integer.parseInt(splitString[0]),
								Integer.parseInt(splitString[1]),
								Integer.parseInt(splitString[2]));
						
								mappedTileA.add(mappedtile);
					}
						
				}
				
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	public void render(RenderHandler render, int xZoom, int yZoom) {
		
		int xInc = 16*xZoom;
		int yInc = 16*yZoom;
		
		
//		if(fileTileID >= 0) {
//			
//			Rectangle camera  = renderer.getCamera();
//			for(int y = 0; y < camera.getH(); ) {
//				for(int x = 0; x < camera.getW();) {
//					
//				}
//			}
//		}
		
		for(int tileIndex = 0; tileIndex < mappedTileA.size(); tileIndex++) {
			
			MappedTile mappedtile = mappedTileA.get(tileIndex);
			tileSet.renderTile(mappedtile.id, render, mappedtile.x * xInc, mappedtile.y * yInc, xZoom, yZoom);
		}
		
	}

	//Struct will containe Tile ID in the Tileset and the position of the tile in the map			
	class MappedTile{
		
		public int id, x, y;
		
		public MappedTile(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
	}

}
