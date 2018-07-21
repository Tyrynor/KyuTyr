package entitees;

import java.awt.Graphics;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public abstract class Entity {
	private int posX, posY;
	
	public Entity(int initPosX, int initPosY) {
		this.posX = initPosX;
		this.posY = initPosY;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public boolean move(int x,int y) {
		this.posX += x;
		this.posY += y;
		return true;
	}
	
	public abstract void draw (Graphics g);
}
