package com.rpg.game;

public class Player implements GameObject{

	Rectangle player;
	int speed = 10;
	
	
	public Player() {
		
		player = new Rectangle(32,16,16,32);
		player.generateGraphics(3, 0xFF00F90);
		
		
	}
	
	@Override
	public void render(RenderHandler renderer, int xZoom, int yZoom) {
		// TODO Auto-generated method stub
		renderer.renderRectangle(player, xZoom, yZoom);
	}

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		
		KeyBoardListener keylistener = game.getKeyListener();
		
		if(keylistener.up()) {
			player.y -= speed;
		}
		if(keylistener.down()) {
			player.y += speed;
		}
		if(keylistener.left()) {
			player.x -= speed;
		}
		if(keylistener.right()) {
			player.x += speed;
		}
	}

}
