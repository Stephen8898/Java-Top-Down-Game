package com.rpg.game;

import java.awt.image.BufferedImage;

public class Sprite {
	
	
	private int[] pixels;
	private int width, height;
	
	
	//Loads a specific sprite from specific part of our buffered image given by a specific sprite sheet
	public Sprite(SpriteSheet sheet, int startX, int startY, int width, int height) {
		
		this.height = height;
		this.width = width;
		
		pixels = new int[width*height];
		sheet.getImage().getRGB(startX, startY, width, height, pixels, 0, width);
	}
	
	
	//Loads a normal sprite without a spritesheet
	public Sprite(BufferedImage image) {
		
		height = image.getHeight();
		width = image.getWidth();
		
		pixels = new int[width*height];
		image.getRGB(0, 0, width, height, pixels, 0, width);
		
	}
	
	// getters
	public int getWidth() {
		 return width;
	}

	public int[] getPixels() {
		return pixels;
	}


	public int getHeight() {
		return height;
	}

}
