package com.rpg.game;

import java.awt.Canvas;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.JFrame;


public class Game extends JFrame implements Runnable {

	public static int alpha = 0xFFFF00DC;
	
	private Canvas canvas = new Canvas();
	private RenderHandler renderer;
//	private BufferedImage testImg;
	private Sprite testSprite;
	private SpriteSheet sheet;
	private Rectangle testRect = new Rectangle(30, 90, 100, 110);
	
	private Tiles tiles;
	
	public Game() {
		
		//Makes sure program is fully shutdown on exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sets the title of the window
		setTitle("Game in Development");
	
		// set position and size of our frame
		setBounds(0, 0, 1000, 900);
		
		//centers frame on screen
		setLocationRelativeTo(null);
		
		//add graphics components
		add(canvas);
		
		// make frame visible
		setVisible(true);
		
		// create our object for buffer strategy 
		canvas.createBufferStrategy(3);
		
		renderer = new RenderHandler(getWidth(), getHeight());
		
//		testImg = loadImage("grass-tile.png");
		
//		testRect.generateGraphics(9876);
		BufferedImage sheetImage = loadImage("assets/Tiles1.png");
		sheet = new SpriteSheet(sheetImage);
		sheet.loadSprites(16, 16);
		
		tiles = new Tiles(new File("assets/Tiles.txt"), sheet);
		
//		testSprite = sheet.getSprite(0, 0);
		
		testRect.generateGraphics(4, 12234);
	}
	
	
		
	// Updates position
		public void update() {
			
		}

		private BufferedImage loadImage(String path) {
			try {
			BufferedImage loadedImage = ImageIO.read(Game.class.getResource(path));
			BufferedImage formattedImage = new BufferedImage(loadedImage.getWidth(), loadedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			formattedImage.getGraphics().drawImage(loadedImage, 0, 0, null);
			return formattedImage;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		
		// Renders everything to the screen
		public void render() {
			BufferStrategy bufferstrat = canvas.getBufferStrategy();
			bufferstrat = canvas.getBufferStrategy();
			Graphics graphics = bufferstrat.getDrawGraphics();
			super.paint(graphics);
			
			//renderer.renderImage(testImg, 4, 2, 2, 2);
			tiles.renderTile(0, renderer, 0, 0, 2, 2);
//			renderer.renderSprites(testSprite, 0, 0, 5, 5);
			renderer.renderRectangle(testRect, 1, 1);
			renderer.render(graphics);
			
			
			graphics.dispose();
			bufferstrat.show();
			
		}
		
		
		
	// thread
	
	@Override
	public void run() {
//		BufferStrategy bufferstrat = canvas.getBufferStrategy();
		long lasttime = System.nanoTime(); // long type 2^63
		
		//converting  nanoseconds to the desired fps 
		double nanoSecondConvert = 1000000000 / 60; //60 fps (frames per second)
		
		// this is the change in seconds
		double deltaSeconds = 0;
		
		
		while(true) {
			
			// when while loop runs this variable is used to compare how it ran compared to lasttime
			long now = System.nanoTime();
			
			/* deltaSeconds is initialized outside the loop because loop does
			 * not run according to our assigned frame rate. So we want to  increase
			 * deltaSeconds by our time difference.
			 */
			
			deltaSeconds += (now - lasttime) / nanoSecondConvert;
			
			while (deltaSeconds >= 1) {
				update();
				deltaSeconds = 0;
			}
			
			render();
			// resetting lasttime 
			lasttime = now;
			}
		
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		
		// Creating an instance of thread and passing in game since its a type runnable
		Thread gamethread = new Thread(game);
		gamethread.start();
	}


}
