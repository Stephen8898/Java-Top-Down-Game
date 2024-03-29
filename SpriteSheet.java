package com.rpg.game;

import java.awt.image.BufferedImage;

/** 
 * Sprites: Hold an int array of pixels for the sprite 
 * and it holds fields for the width and height of the sprite
 * 
 * @author steph
 * Holds an int array of pixels for the entire sheet image
 * Holds an Array of Sprites
 * The sprites are loaded based on img size parameters
 *
 */
public class SpriteSheet {

	 private int[] pixels;
	 private BufferedImage image;
	 private Sprite[] loadedSprites = null;
	 private boolean spritesLoaded = false;
	 public final int SIZEX;
	 public final int SIZEY;
	 private int spriteSizeX;
	 
	 
	public SpriteSheet(BufferedImage sheetImg) {
		SIZEX = sheetImg.getWidth();
		SIZEY = sheetImg.getHeight();
		this.image = sheetImg;
		
		pixels = new int[SIZEX*SIZEY];
		pixels = sheetImg.getRGB(0, 0, SIZEX, SIZEY, pixels, 0, SIZEX);
	}
	
	public void loadSprites(int spriteSizeX, int spriteSizeY) {
		
		this.spriteSizeX = spriteSizeX;
		loadedSprites = new Sprite[(SIZEX / spriteSizeX) * (SIZEY / spriteSizeY)];
		
		
		int spriteID = 0;
		for(int y = 0; y < SIZEY; y += spriteSizeY)
			for(int x = 0; x < SIZEX; x += spriteSizeX) {
				
				loadedSprites[spriteID] = new Sprite(this, x, y, spriteSizeX, spriteSizeY);
				spriteID++;
			}
		
		spritesLoaded = true;
			
	}
	
	public Sprite getSprite(int x, int y) {
		
		if(spritesLoaded) {
			
			int spriteID = x + y * (SIZEX / spriteSizeX);
			
			if (spriteID < loadedSprites.length) {
				return loadedSprites[spriteID];
			}
			
			else {
				System.out.println("SpriteID of " + spriteID + " is out of range with a length of " + loadedSprites.length);
			}
		}
		else {
			System.out.println("SpriteSheet could not get a sprite with no loaded sprites.");
		}
		return null;
	}
	 
	 public int[] getPixels() {
		 
		 return pixels;
	 }
	 
	 public BufferedImage getImage() {
		 return image;
	 }
}
