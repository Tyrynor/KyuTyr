package entitees;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import constantes.Constantes;
import outils.HitBox;
import outils.Stats;
import usine.EntityStock;
import usine.SingletonStatsJoueur;

public class Joueur extends Entity implements AttackingEntity{
	
	public boolean left=false, right=false, top=false, bot=false;
	
	private boolean isAttacking = false;
	
	private int dirX = 0,dirY = 0;
	
	private int attackingFramesRemaining = 0;
	
	private double theta = 0;
	
	public Joueur() {
		super(null);
	}
	
	@Override
	public boolean move(int x,int y) {
		int prevX=SingletonStatsJoueur.getInstance().posX, prevY=SingletonStatsJoueur.getInstance().posY;
		x = y = Constantes.VITESSE_DE_DEPLACEMENT;
		if (left && !right) {
			if (top && !bot) {
				x=-(int)((double) x * Constantes.FACTEUR_BIAIS);
				y=-(int)((double) y * Constantes.FACTEUR_BIAIS);
			} else if (bot && !top) {
				x=-(int)((double) x * Constantes.FACTEUR_BIAIS);
				y=(int)((double) y * Constantes.FACTEUR_BIAIS);
			} else {
				x=-x;
				y=0;
			}
		} else if (right && !left) {
			if (top && !bot) {
				x=(int)((double) x * Constantes.FACTEUR_BIAIS);
				y=-(int)((double) y * Constantes.FACTEUR_BIAIS);
			} else if (bot && !top) {
				x=(int)((double) x * Constantes.FACTEUR_BIAIS);
				y=(int)((double) y * Constantes.FACTEUR_BIAIS);
			} else {
				y=0;
			}
		} else if (top && !bot) {
			x=0;
			y=-y;
		} else if (bot && !top) {
			x=0;
		} else {
			x=0;
			y=0;
		}
		SingletonStatsJoueur.getInstance().posX+=x;
		SingletonStatsJoueur.getInstance().posY+=y;
		while (!HitBox.canMove(this)) {
			SingletonStatsJoueur.getInstance().posX = prevX;
			SingletonStatsJoueur.getInstance().posY = prevY;
			return false;
		}
		return true;
	}
	
	@Override
	public Rectangle getHitBox() {
		return new Rectangle(Constantes.REFERENTIEL_JOUEUR.width,Constantes.REFERENTIEL_JOUEUR.height, Constantes.TAILLE_BASE_ENTITY.width,Constantes.TAILLE_BASE_ENTITY.height);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(Constantes.REFERENTIEL_JOUEUR.width,Constantes.REFERENTIEL_JOUEUR.height,Constantes.TAILLE_BASE_ENTITY.width,Constantes.TAILLE_BASE_ENTITY.height);
		g.setColor(Color.BLUE);
		g.drawString(SingletonStatsJoueur.getInstance().posX + "/" + SingletonStatsJoueur.getInstance().posY, Constantes.REFERENTIEL_JOUEUR.width, Constantes.REFERENTIEL_JOUEUR.height);
		g.setColor(Color.RED);
		Rectangle r = this.getHitBox();
		Graphics2D g2d = (Graphics2D)g;
		g2d.draw(r);
		if (isAttacking) {
			attackingFramesRemaining--;
			drawAttack(g, r);
			if (attackingFramesRemaining <= 0) {
				isAttacking = false;
			}
		}
	}

	public void drawAttack (Graphics g, Rectangle r) {
		g.setColor(Color.MAGENTA);
		AffineTransform at = AffineTransform.getRotateInstance(dirX-r.getCenterX(),dirY-r.getCenterY(), r.getCenterX(), r.getCenterY());
		Shape sp = at.createTransformedShape(new Rectangle((int)r.getCenterX()+(int)r.getWidth()/2, (int)r.getCenterY()-(int)r.getHeight()/4, (int)r.getWidth()+50, (int)r.getHeight()/2));
		if (HitBox.allHittedEntity(sp, this).size() > 0) {
			g.setColor(Color.BLUE);
		}
		((Graphics2D)g).draw(sp);
	}
	
	@Override
	public boolean attaquer() {
		return false;
	}
	
	public boolean attaquer(MouseEvent m) {
		if (isAttacking) {
			return false;
		} else {
			dirX = m.getX();
			dirY = m.getY();
			attackingFramesRemaining = 10;
			return isAttacking = true;
		}
	}

}
