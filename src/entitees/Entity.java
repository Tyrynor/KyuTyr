package entitees;

import java.awt.Graphics;
import java.util.Observable;

import outils.Stats;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public abstract class Entity extends Observable{
	
	protected Stats stats;
	
	public Entity(Stats sts) {
		this.stats = sts;
	}
	
	public Stats getStats() {
		return this.stats;
	}
	
	public boolean move(int x,int y) {
		this.stats.posX += x;
		this.stats.posY += y;
		this.setChanged();
		this.notifyObservers();
		return true;
	}
	
	public abstract void draw (Graphics g);
}
