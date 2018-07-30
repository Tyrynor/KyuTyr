package entitees;

import java.awt.Graphics;

import outils.Stats;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public abstract class Entity{
	public static int nbOfEntity = 0;
	protected Stats stats;
	public final int EntityId;
	
	public Entity(Stats sts) {
		this.stats = sts;
		this.EntityId = Entity.nbOfEntity;
		Entity.nbOfEntity++;
	}
	
	public Stats getStats() {
		return this.stats;
	}
	
	public boolean move(int x,int y) {
		this.stats.posX += x;
		this.stats.posY += y;
		return true;
	}
	
	public abstract void draw (Graphics g);
}
