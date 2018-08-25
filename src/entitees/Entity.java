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
 * Classe abstraite permettant de définir les bases d'une entitée
 */
public abstract class Entity{
	public static int nbOfEntity = 0;
	protected Stats stats;
	public final int EntityId;
	
	/**
	 * Constructeur de classe
	 * @param sts Stats que l'ont veut assigner à une entitée (passer par StatsFactory)
	 */
	public Entity(Stats sts) {
		this.stats = sts;
		this.EntityId = Entity.nbOfEntity;
		Entity.nbOfEntity++;
	}
	
	/**
	 * Méthode permettant de récupérer la hit-box de l'entitée	
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
	 * Méthode permettant de se déplacer
	 * @param x montant du déplacement sur x
	 * @param y montant du déplacement sur y
	 * @return booleen qui permet de savoir si le déplacement est réussi
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
	 * Méthode permettant de se déplacer selon un vecteur de déplacement
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
	 * Méthode abstraite qui permet à l'entitée de se desssiner elle meme
	 * @param g objet de dessin (Graphics)
	 */
	public abstract void draw (Graphics g);
}
