package entitees;

import java.awt.Color;
import java.awt.Graphics;

import constantes.Constantes;
import usine.SingletonStatsJoueur;

public class Joueur extends Entity {
	
	public boolean left=false, right=false, top=false, bot=false;
	
	public Joueur() {
		super(null);
	}
	
	@Override
	public boolean move(int x,int y) {
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
		SingletonStatsJoueur.getIntance().posX+=x;
		SingletonStatsJoueur.getIntance().posY+=y;
		return true;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(SingletonStatsJoueur.getIntance().posX,SingletonStatsJoueur.getIntance().posY,Constantes.TAILLE_BASE_ENTITY.width,Constantes.TAILLE_BASE_ENTITY.height);
	}

}
