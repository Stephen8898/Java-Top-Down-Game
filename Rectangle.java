package com.rpg.game;

public class Rectangle {

	public int x,y,w,h;
	private int[] pixels;
	
	public Rectangle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	//This constructor is for an empty rectangle
	public Rectangle() {
		// Calls another constructor (the one above) and we can pass arguments into it
		this(0,0,0,0);
	}
	
	
	public void generateGraphics(int color) {
		
		pixels = new int[w*h];
		for(int y = 0; y < h; y++)
			for(int x = 0; x < w; x++)
				//Y is getting multiplied by width because of n amount of width, which is getting offset by x
				pixels[x + y * w] = color;

	}
	
	
	public void generateGraphics(int borderWidth, int color) {
		pixels = new int[w*h];
		
		for(int i = 0; i < pixels.length; i++)
			pixels[i] = Game.alpha;
		
		for(int y = 0; y < borderWidth; y++)
			for(int x = 0; x < w; x++)
				pixels[x + y * w] = color;
//		
		/** Render rectangle on the left, right & bottom side of the rectangle **/
		// left
		for(int y = 0; y < h; y++)
			for(int x = 0; x < borderWidth; x++)
				pixels[x + y * w] = color;
		// right
		for(int y = 0; y < h; y++)
			for(int x = w - borderWidth; x < w ; x++)
				pixels[x + y * w] = color;
		// bottom
		for(int y = h - borderWidth ; y < h; y++)
			for(int x = 0; x < w; x++)
			pixels[x + y * w] = color;
	}
	
	public int[] getPixels() {
		if (pixels != null) 
			return pixels;
			
		else
			System.out.println("Attempted to get pixels from rectangle without generated graphics.");
		
		return null;
	
	}
	
//	public int getX() {
//		return x;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}
//
//	public int getW() {
//		return w;
//	}
//
//	public void setW(int w) {
//		this.w = w;
//	}
//
//	public int getH() {
//		return h;
//	}
//
//	public void setH(int h) {
//		this.h = h;
//	}
//	
	
}
