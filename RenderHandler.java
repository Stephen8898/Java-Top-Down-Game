package com.rpg.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class RenderHandler {

	private BufferedImage view;
	private int[] pixels;
	private Rectangle camera;
	
	// 
	public RenderHandler(int width, int height) {
		
		// create a bufferedImage that represents our view
		view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		// create an array for the pixels
		pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();
		
		camera = new Rectangle(0, 0, width, height);
		
		camera.setX(-100); 
		camera.setY(-30);
		
	}
	
	// Render our array of pixels to the screen
	public void render(Graphics graphics) {	
	
		// draws an image 
		graphics.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
	}
	
	// renders our image to the pixels
	public void renderImage(BufferedImage image, int xPosition, int yPosition, int xZoom, int yZoom) {
		int[] imgPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		renderArray(imgPixels, image.getWidth(), image.getHeight(), xPosition, yPosition, xZoom, yZoom);
	}
	
	
	public void renderSprites(Sprite sprite, int xPosition, int yPosition, int xZoom, int yZoom) {
		renderArray(sprite.getPixels(), sprite.getWidth(), sprite.getHeight(), xPosition, yPosition, xZoom, yZoom);
	}
	
	public void renderRectangle(Rectangle rectangle, int xZoom, int yZoom) {
		
		int [] rectanglePixels = rectangle.getPixels();
		if(rectanglePixels != null)
			renderArray(rectanglePixels, rectangle.getW(), rectangle.getH(), rectangle.getX(), rectangle.getY(), xZoom, yZoom);
	}
	
	public void renderArray(int[] renderPixels, int renderWidth, int renderHeight, int xPosition, int yPosition, int xZoom, int yZoom) {
		for(int y = 0; y < renderHeight; y++) 
			// rendering pixel
			for(int x = 0; x < renderWidth; x++) 
				// Passing in position to offset the 0, 0 you get from x,y. 
				for(int yZoomPosition = 0;  yZoomPosition < yZoom;  yZoomPosition++) 		
					for(int xZoomPosition = 0;  xZoomPosition < xZoom;  xZoomPosition++) 
						setPixel(renderPixels[x + y * renderWidth], ((x* xZoom) + xPosition + xZoomPosition), ((y * yZoom)+ yPosition + yZoomPosition));
					
	}
	
	
	private void setPixel(int pixel, int x, int y) {
		
 		if(x >= camera.getX() && y >= camera.getY() && x <= camera.getW() &&  y <= camera.getY() + camera.getH()) {		
 			
 			int pixelIndex = (x - camera.getX()) + (y - camera.getY()) * view.getWidth();
 			if (pixels.length > pixelIndex && pixel != Game.alpha) {
 				pixels[pixelIndex] = pixel;
 			}
 		}
	}
	
	
}
