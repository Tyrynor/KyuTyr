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
 * Classe abstraite permettant de d�finir les bases d'une entit�e
 */
public abstract class Entity{
	public static int nbOfEntity = 0;
	protected Stats stats;
	public final int EntityId;
	
	/**
	 * Constructeur de classe
	 * @param sts Stats que l'ont veut assigner � une entit�e (passer par StatsFactory)
	 */
	public Entity(Stats sts) {
		this.stats = sts;
		this.EntityId = Entity.nbOfEntity;
		Entity.nbOfEntity++;
	}
	
	/**
	 * M�thode permettant de r�cup�rer la hit-box de l'entit�e	
	 * @return la hit-box
	 */
	public Rectangle getHitBox() {
		int refX = Calcules.posXRefPlayer(this.stats.posX), refY = Calcules.posYRefPlayer(this.stats.posY);
		return new Rectangle(refX,refY, this.stats.width, this.stats.height);
	}
	
	/**
	 * getteur sur les stats
	 * @return les stats
	 */
	public Stats getStats() {
		return this.stats;
	}
	
	/**
	 * M�thode permettant de se d�placer
	 * @param x montant du d�placement sur x
	 * @param y montant du d�placement sur y
	 * @return booleen qui permet de savoir si le d�placement est r�ussi
	 */
	public boolean move(int x,int y) {
		this.stats.posX += x;
		this.stats.posY += y;
		if (!HitBox.canMove(this)) {
			this.stats.posX -= x;
			this.stats.posY -= y;
		}
		return true;
	}
	/**
	 * M�thode permettant de se d�placer selon un vecteur de d�placement
	 * @param dx
	 * @param dy
	 * @param vectored
	 * @return
	 */
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
	/**
	 * M�thode abstraite qui permet � l'entit�e de se desssiner elle meme
	 * @param g objet de dessin (Graphics)
	 */
	public abstract void draw (Graphics g);
}
