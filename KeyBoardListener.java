package com.rpg.game;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardListener implements KeyListener, FocusListener{

	public Boolean[] keys = new Boolean[120];
	
	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		int keycode = event.getKeyCode();
		
		if(keycode < keys.length)
			keys[keycode] = true;
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		int keycode = event.getKeyCode();
		
		if(keycode < keys.length)
			keys[keycode] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		for(int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}

	public boolean up() {
		return keys[KeyEvent.VK_W];
	}
	
	public boolean down() {
		
		return keys[KeyEvent.VK_S];
	}
	public boolean left() {
		
		return keys[KeyEvent.VK_A];
	}
	public boolean right() {
		
		return keys[KeyEvent.VK_D];
	}
	
}
