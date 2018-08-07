package entitees;

import java.awt.Graphics;
import java.awt.Rectangle;

import constantes.Constantes;
import outils.HitBox;
import outils.Stats;
import usine.SingletonStatsJoueur;

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
	
	public Rectangle getHitBox() {
		int posXD = SingletonStatsJoueur.getInstance().posX;
		int posYD = SingletonStatsJoueur.getInstance().posY;
		return new Rectangle(this.stats.posX+ Constantes.REFERENTIEL_JOUEUR.width-posXD, this.stats.posY+Constantes.REFERENTIEL_JOUEUR.height-posYD, this.stats.width, this.stats.height);
	}
	
	public Stats getStats() {
		return this.stats;
	}
	
	public boolean move(int x,int y) {
		this.stats.posX += x;
		this.stats.posY += y;
		if (!HitBox.canMove(this)) {
			this.stats.posX -= x;
			this.stats.posY -= y;
		}
		return true;
	}
	
	public abstract void draw (Graphics g);
}