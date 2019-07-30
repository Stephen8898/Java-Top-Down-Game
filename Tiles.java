package com.rpg.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// This class deals with the placement of the loaded sprite
//This class will contain a structure(struct)
public class Tiles {
	
	private SpriteSheet spriteSheet;
	private ArrayList<Tile> tileslist = new ArrayList<Tile>();
	
	//This will only work under the assumption that the sprite sheet has been loaded
	public Tiles(File tilesFile, SpriteSheet spriteSheet) {
		
		this.spriteSheet = spriteSheet;
		
		try {
		//We are using scanner to scan or read thought the files being passed
			Scanner filescanner = new Scanner(tilesFile);
		
			while(filescanner.hasNextLine()) {
			// read each line and creates a file
				
				String line = filescanner.nextLine();
				if(!line.startsWith("//")) {
					String[] splitString = line.split("-"); 
					String tileName = splitString[0];
					int spriteX = Integer.parseInt(splitString[1]);
					int spriteY = Integer.parseInt(splitString[2]);
					Tile tile = new Tile(tileName, this.spriteSheet.getSprite(spriteX, spriteY));
					tileslist.add(tile);
				}
				
//				filescanner.close();
			}
		
		} catch(FileNotFoundException e) {
			// throws exception if files not found
			e.printStackTrace();
		}
	}
	
	public void renderTile(int tileID, RenderHandler renderer, int xPosition, int yPosition, int xZoom, int yZoom) {
		if (tileID >= 0 && tileslist.size() > tileID) {
		 		renderer.renderSprites(tileslist.get(tileID).sprite, xPosition, yPosition, xZoom, yZoom);
		} else {
			
			System.out.println("TileID " + tileID + " is not within range " + tileslist.size());
		}
	}
	
	//This is our Structure (It's like a small class within a class)
	class Tile{
		
		public String tileName;
		public Sprite sprite;
		
		public Tile(String tileName, Sprite sprite) {
			this.tileName = tileName;
			this.sprite = sprite;
		}
	}

}
