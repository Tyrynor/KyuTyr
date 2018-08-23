package entitees;

import java.awt.Graphics;
import java.awt.Rectangle;

import constantes.Constantes;
import outils.Calcules;
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
		int refX = Calcules.posXRefPlayer(this.stats.posX), refY = Calcules.posYRefPlayer(this.stats.posY);
		return new Rectangle(refX,refY, this.stats.width, this.stats.height);
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
	
	public boolean move(int dx, int dy, boolean vectored) {
		int x = 0;
		int y = 0;
		if (dx > 0) {
			if (dy == 0) {
				x = stats.speed;
			} else {
				x = (int) (stats.speed * Constantes.FACTEUR_BIAIS);
				if (dy > 0) {
					y = (int) (stats.speed * Constantes.FACTEUR_BIAIS);
				} else {
					y = -(int) (stats.speed * Constantes.FACTEUR_BIAIS);
				}
			}
		} else if (dx < 0) {
			if (dy == 0) {
				x = -stats.speed;
			} else {
				x = -(int) (stats.speed * Constantes.FACTEUR_BIAIS);
				if (dy > 0) {
					y = (int) (stats.speed * Constantes.FACTEUR_BIAIS);
				} else {
					y = -(int) (stats.speed * Constantes.FACTEUR_BIAIS);
				}
			}
		} else {
			if (dy > 0) {
				y = stats.speed;
			} else {
				y = -stats.speed;
			}
		}
		return move(x,y);
	}
	
	public abstract void draw (Graphics g);
}
