package entitees;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import constantes.Constantes;
import outils.HitBox;
import outils.Stats;
import usine.SingletonStatsJoueur;

public class Joueur extends Entity {
	
	public boolean left=false, right=false, top=false, bot=false;
	
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
		Stats sts = SingletonStatsJoueur.getInstance();
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
		g.drawRect(Constantes.REFERENTIEL_JOUEUR.width,Constantes.REFERENTIEL_JOUEUR.height,Constantes.TAILLE_BASE_ENTITY.width,Constantes.TAILLE_BASE_ENTITY.height);
	}

}
